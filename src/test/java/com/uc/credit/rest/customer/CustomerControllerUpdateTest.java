package com.uc.credit.rest.customer;


import com.uc.credit.CreditApplicationTests;
import com.uc.credit.RequestSpec;
import com.uc.credit.ResponseSpec;
import com.uc.credit.model.dto.customer.request.UpdateCustomerRequest;
import com.uc.credit.model.dto.customer.response.CustomerResponse;
import com.uc.credit.model.entity.Address;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.repository.CustomerRepository;
import com.uc.credit.utils.RandomUtils;
import com.uc.credit.utils.TestCustomerUtility;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

@Slf4j
public class CustomerControllerUpdateTest extends CreditApplicationTests {

    @Autowired
    TestCustomerUtility testCustomerUtility;

    @Autowired
    RandomUtils randomUtils;
    Customer customer;

    private String path(String id){
        return String.format("/customer/%s",id);
    }
    @Before
    public void before(){
        customer = testCustomerUtility.createTestCustomer();
    }
    @Test
    public void testUpdate200() {
        UpdateCustomerRequest request = updateCustomerRequest();
        CustomerResponse response = RequestSpec.given().jsonRequest().body(request).put(path(customer.getId()))
                .then().log().all()
                .spec(ResponseSpec.isOkResponse())
                .extract().body().as(CustomerResponse.class);

        Assert.assertEquals(request.getFirstname(), response.getFirstname());
        Assert.assertEquals(request.getPhone(), response.getPhone());
    }



    public UpdateCustomerRequest updateCustomerRequest(){
        Address address= new Address();
        address.setProvince("Denizli");
        address.setCountry("Türkiye");
        address.setDistrict("Pamukkale");
        address.setNeighborhood("Asmalıevler");
        address.setStreet("6661");
        address.setBuildingInformation("No:23 Kat:1 Daire:1");
        UpdateCustomerRequest request = UpdateCustomerRequest.builder()
                .firstname("Ahmet")
                .lastname("Çorbacı")
                .citizenId(randomUtils.randomCitizenId())
                .birthDate(LocalDate.of(1997,3,4))
                .monthlyIncome(new BigDecimal(10000))
                .phone(randomUtils.randomPhoneNumber())
                .address(address)
                .build();
        return request;
    }

}
