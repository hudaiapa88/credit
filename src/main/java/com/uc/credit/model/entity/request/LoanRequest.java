package com.uc.credit.model.entity.request;

import com.uc.credit.model.dto.loanrequest.request.SaveLoanRequestRequest;
import com.uc.credit.model.entity.Score;
import com.uc.credit.model.entity.base.AuditData;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.model.enums.RequestStatus;
import com.uc.credit.model.enums.RequestType;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.math.BigDecimal;

import static org.apache.commons.lang3.compare.ComparableUtils.is;

@Data
@Document(collection = "request")
@TypeAlias("loanRequest")
public class LoanRequest extends Request {
    private BigDecimal amount = new BigDecimal(0);
    public LoanRequest() {
        setRequestType(RequestType.LOAN);
    }


    public static LoanRequest create(Customer customer, Score score,Integer creditLimitFactor){
        LoanRequest loanRequest = new LoanRequest();
        loanRequest.setCustomer(customer);
        if (score.getAmount() < 500L) {
            loanRequest.setRequestStatus(RequestStatus.DENIED);
        } else if (is(score.getAmount()).between(500L, 1000L) && is(customer.getMonthlyIncome()).lessThan(new BigDecimal(5000))) {
            loanRequest.setRequestStatus(RequestStatus.ACCEPT);
            loanRequest.setAmount(new BigDecimal(10000));
        } else if (is(score.getAmount()).between(500L, 1000L) && is(customer.getMonthlyIncome()).between(new BigDecimal(5000), new BigDecimal(10000))) {
            loanRequest.setRequestStatus(RequestStatus.ACCEPT);
            loanRequest.setAmount(new BigDecimal(20000)) ;
        } else if (is(score.getAmount()).between(500L, 1000L) && is(customer.getMonthlyIncome()).greaterThan(new BigDecimal(10000))) {
            loanRequest.setRequestStatus(RequestStatus.ACCEPT);
           loanRequest.setAmount(customer.getMonthlyIncome().multiply(new BigDecimal(creditLimitFactor / 2)));
        } else if (is(score.getAmount()).greaterThanOrEqualTo(1000L)) {
            loanRequest.setRequestStatus(RequestStatus.ACCEPT);
            loanRequest.setAmount(customer.getMonthlyIncome().multiply(new BigDecimal(creditLimitFactor)));
        }
        return loanRequest;
    }
}
