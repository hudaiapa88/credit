package com.uc.credit.rest.loanrequest;

import com.uc.credit.CreditApplicationTests;
import com.uc.credit.RequestSpec;
import com.uc.credit.ResponseSpec;
import com.uc.credit.model.dto.loanrequest.response.LoanRequestResponse;
import com.uc.credit.model.entity.Score;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.model.enums.RequestStatus;
import com.uc.credit.repository.LoanRequestRepository;
import com.uc.credit.utils.TestScoreUtility;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

@Slf4j
public class LoanRequestControllerPostTest extends CreditApplicationTests {
    @Autowired
    TestScoreUtility testScoreUtility;
    @Autowired
    LoanRequestRepository loanRequestRepository;

    @Value(" #{new Integer('${credit.limit.factor}')}")
    private Integer creditLimitFactor;

    private String path(Customer customer){
        return String.format("/loanRequest/customer/%s",customer.getId());
    }
    @Test
    public void testPost200WithDenied() {
        LoanRequestResponse response = RequestSpec.given()
                .jsonRequest().post(path(testScoreUtility.createTestScoreWithAmountAndCustomerMonthlyIncome(450L,new BigDecimal(1000)).getCustomer()))
                .then().log().all()
                .spec(ResponseSpec.isOkResponse())
                .extract().body().as(LoanRequestResponse.class);

        Assert.assertTrue("Should be in DB", loanRequestRepository.findById(response.getId()).isPresent());
        Assert.assertEquals(RequestStatus.DENIED, response.getRequestStatus());
    }
    @Test
    public void testPost200WithAcceptAnd10000Amount() {
        LoanRequestResponse response = RequestSpec.given()
                .jsonRequest().post(path(testScoreUtility.createTestScoreWithAmountAndCustomerMonthlyIncome(501L,new BigDecimal(4500)).getCustomer()))
                .then().log().all()
                .spec(ResponseSpec.isOkResponse())
                .extract().body().as(LoanRequestResponse.class);

        Assert.assertTrue("Should be in DB", loanRequestRepository.findById(response.getId()).isPresent());
        Assert.assertEquals(RequestStatus.ACCEPT, response.getRequestStatus());
        Assert.assertEquals(new BigDecimal(10000), response.getAmount());
    }
    @Test
    public void testPost200WithAcceptAnd20000Amount() {
        LoanRequestResponse response = RequestSpec.given()
                .jsonRequest().post(path(testScoreUtility.createTestScoreWithAmountAndCustomerMonthlyIncome(600L,new BigDecimal(7000)).getCustomer()))
                .then().log().all()
                .spec(ResponseSpec.isOkResponse())
                .extract().body().as(LoanRequestResponse.class);

        Assert.assertTrue("Should be in DB", loanRequestRepository.findById(response.getId()).isPresent());
        Assert.assertEquals(RequestStatus.ACCEPT, response.getRequestStatus());
        Assert.assertEquals(new BigDecimal(20000), response.getAmount());
    }
    @Test
    public void testPost200WithAcceptAndCreditLimitFactorDivisionTwo() {
        Score score = testScoreUtility.createTestScoreWithAmountAndCustomerMonthlyIncome(900L,new BigDecimal(11000));
        LoanRequestResponse response = RequestSpec.given()
                .jsonRequest().post(path(score.getCustomer()))
                .then().log().all()
                .spec(ResponseSpec.isOkResponse())
                .extract().body().as(LoanRequestResponse.class);

        Assert.assertTrue("Should be in DB", loanRequestRepository.findById(response.getId()).isPresent());
        Assert.assertEquals(RequestStatus.ACCEPT, response.getRequestStatus());
        Assert.assertEquals(score.getCustomer().getMonthlyIncome().multiply(new BigDecimal(creditLimitFactor / 2)), response.getAmount());
    }
    @Test
    public void testPost200WithAcceptAndMonthlyIncomeMultiplicationCreditLimitFactor() {
        Score score = testScoreUtility.createTestScoreWithAmountAndCustomerMonthlyIncome(1001L,new BigDecimal(9000));
        LoanRequestResponse response = RequestSpec.given()
                .jsonRequest().post(path(score.getCustomer()))
                .then().log().all()
                .spec(ResponseSpec.isOkResponse())
                .extract().body().as(LoanRequestResponse.class);

        Assert.assertTrue("Should be in DB", loanRequestRepository.findById(response.getId()).isPresent());
        Assert.assertEquals(RequestStatus.ACCEPT, response.getRequestStatus());
        Assert.assertEquals(score.getCustomer().getMonthlyIncome().multiply(new BigDecimal(creditLimitFactor)), response.getAmount());
    }
}
