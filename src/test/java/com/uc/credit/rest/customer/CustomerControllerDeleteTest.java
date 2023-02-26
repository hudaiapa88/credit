package com.uc.credit.rest.customer;

import com.uc.credit.CreditApplicationTests;
import com.uc.credit.RequestSpec;
import com.uc.credit.ResponseSpec;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.repository.CustomerRepository;
import com.uc.credit.utils.TestCustomerUtility;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class CustomerControllerDeleteTest extends CreditApplicationTests {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TestCustomerUtility testCustomerUtility;

    Customer customer;

    @Before
    public void before() {
        customer = testCustomerUtility.createTestCustomer();
    }

    @Test
    public void testDelete200() {
        RequestSpec.given()
                .jsonRequest().delete(path(customer.getId()))
                .then()
                .spec(ResponseSpec.isOkResponse());

    }


    private String path(String id) {
        return String.format("/customer/%s", id);
    }
}


