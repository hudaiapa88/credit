package com.uc.credit.rest.score;

import com.uc.credit.CreditApplicationTests;
import com.uc.credit.RequestSpec;
import com.uc.credit.ResponseSpec;
import com.uc.credit.model.entity.Score;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.repository.CustomerRepository;
import com.uc.credit.utils.TestCustomerUtility;
import com.uc.credit.utils.TestScoreUtility;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ScoreControllerDeleteTest extends CreditApplicationTests {
    @Autowired
    TestScoreUtility testScoreUtility;
    Score score;
    private String path(String id){
        return String.format("/score/%s",id);
    }
    @Before
    public void before(){
        score = testScoreUtility.createTestScore();
    }

    @Test
    public void testDelete200() {
        RequestSpec.given()
                .jsonRequest().delete(path(score.getId()))
                .then()
                .spec(ResponseSpec.isOkResponse());
    }

}
