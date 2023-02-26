package com.uc.credit.manager;

import com.uc.credit.exception.EntityNotFoundException;
import com.uc.credit.model.Message;
import com.uc.credit.model.dto.loanrequest.request.UpdateLoanRequestRequest;
import com.uc.credit.model.dto.loanrequest.response.LoanRequestResponse;
import com.uc.credit.model.entity.request.LoanRequest;
import com.uc.credit.model.entity.Score;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.model.enums.RequestStatus;
import com.uc.credit.model.mapper.LoanRequestResponseMapper;
import com.uc.credit.repository.LoanRequestRepository;
import com.uc.credit.sender.SmsSender;
import lombok.RequiredArgsConstructor;

import static org.apache.commons.lang3.compare.ComparableUtils.is;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LoanRequestManager {
    private final LoanRequestRepository loanRequestRepository;
    private final LoanRequestResponseMapper loanRequestResponseMapper;
    private final CustomerManager customerManager;
    private final ScoreManager scoreManager;
    private final CreditAccountManager creditAccountManager;
    private final SmsSender smsSender;

    @Value(" #{new Integer('${credit.limit.factor}')}")
    private Integer creditLimitFactor;

    public LoanRequestResponse save(String customerId) {
        Customer customer = customerManager.findById(customerId);
        Score score = scoreManager.findByCustomerId(customerId);
        LoanRequest loanRequest = loanRequestRepository.save(LoanRequest.create(customer,score,creditLimitFactor));
        creditAccountManager.save(customer, loanRequest.getAmount());
        smsSender.send(customer, Message.builder()
                .title(loanRequest.getRequestStatus() == RequestStatus.ACCEPT ? "Krediniz Onaylandı" : "Krediniz Onaylanmadı")
                .body(loanRequest.getRequestStatus() == RequestStatus.ACCEPT ? loanRequest.getAmount() + " tutarındaki krediniz hesabınıza tanımlanmıştır. İyi günlerde kullanın." : "Üzgünüz. Krediniz onaylanmadı. ")
                .build());
        return loanRequestResponseMapper.convert(loanRequest);
    }

    public LoanRequestResponse getById(String id) {
        return loanRequestResponseMapper.convert(findById(id));
    }

    private LoanRequest findById(String id) {
        return loanRequestRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Kredi başvurusu bulunamadı."));
    }

    public List<LoanRequestResponse> getAll() {
        return loanRequestResponseMapper.convertList(loanRequestRepository.findAll());
    }
}
