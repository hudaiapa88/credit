package com.uc.credit.utils;

import com.uc.credit.model.dto.score.request.SaveScoreRequest;
import com.uc.credit.model.entity.Score;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.repository.ScoreRepository;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TestScoreUtility {

    @Autowired
    TestCustomerUtility testCustomerUtility;
    @Autowired
    ScoreRepository scoreRepository;

    public Score createTestScore() {
        return scoreRepository.save(Score.create(SaveScoreRequest.builder()
                        .amount(1000L)
                .build(),testCustomerUtility.createTestCustomer()));
    }
    public Score createTestScoreWithAmountAndCustomerMonthlyIncome(Long amount, BigDecimal monthlyIncome){
        return scoreRepository.save(Score.create(SaveScoreRequest.builder()
                .amount(amount)
                .build(),testCustomerUtility.createTestCustomerWithMonthlyIncome(monthlyIncome)));
    }
}
