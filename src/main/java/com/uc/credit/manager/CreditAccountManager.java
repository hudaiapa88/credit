package com.uc.credit.manager;

import com.uc.credit.model.entity.account.CreditAccount;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.repository.CreditAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class CreditAccountManager {
  private final CreditAccountRepository creditAccountRepository;

  public CreditAccount save(Customer customer, BigDecimal limit){
   CreditAccount creditAccount= new CreditAccount();
   creditAccount.setCutOffDate(LocalDate.now());
   creditAccount.setCustomer(customer);
   creditAccount.setLimit(limit);
   creditAccount.setBalance(limit);
   return creditAccountRepository.save(creditAccount);
  }
}
