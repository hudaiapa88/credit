package com.uc.credit.rest.score;

import com.uc.credit.CreditApplicationTests;
import com.uc.credit.RequestSpec;
import com.uc.credit.ResponseSpec;
import com.uc.credit.model.dto.score.request.UpdateScoreRequest;
import com.uc.credit.model.dto.score.response.ScoreResponse;
import com.uc.credit.model.entity.Score;
import com.uc.credit.utils.TestScoreUtility;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ScoreControllerUpdateTest extends CreditApplicationTests {
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
    public void testUpdate200() {
        UpdateScoreRequest request = updateScoreRequest();
        ScoreResponse response = RequestSpec.given().jsonRequest().body(request).put(path(score.getId()))
                .then().log().all()
                .spec(ResponseSpec.isOkResponse())
                .extract().body().as(ScoreResponse.class);

        Assert.assertEquals(request.getAmount(), response.getAmount());

    }
    public UpdateScoreRequest updateScoreRequest(){
        UpdateScoreRequest request = UpdateScoreRequest.builder()
                .amount(1002L)
                .build();
        return request;
    }
}
