package com.uc.credit.rest.score;

import com.uc.credit.CreditApplicationTests;
import com.uc.credit.RequestSpec;
import com.uc.credit.ResponseSpec;
import com.uc.credit.model.dto.score.request.SaveScoreRequest;
import com.uc.credit.model.dto.score.response.ScoreResponse;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.repository.ScoreRepository;
import com.uc.credit.utils.TestCustomerUtility;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ScoreControllerPostTest extends CreditApplicationTests {
    @Autowired
    ScoreRepository scoreRepository;

    @Autowired
    TestCustomerUtility testCustomerUtility;

    Customer customer;
    @Before
    public void before(){
        customer = testCustomerUtility.createTestCustomer();
    }
    private String path(Customer customer) {
        return String.format("/score/customer/%s",customer.getId());
    }

    @Test
    public void testPost200() {
        SaveScoreRequest request = createSaveScoreRequest();
        ScoreResponse response = RequestSpec.given()
                .jsonRequest().body(request).post(path(customer))
                .then().log().all()
                .spec(ResponseSpec.isOkResponse())
                .extract().body().as(ScoreResponse.class);

        Assert.assertTrue("Should be in DB", scoreRepository.findById(response.getId()).isPresent());
        Assert.assertEquals(request.getAmount(), response.getAmount());
    }

        public SaveScoreRequest createSaveScoreRequest() {

        SaveScoreRequest request = SaveScoreRequest.builder()
                .amount(1000L)
                .build();
        return request;
    }
}
