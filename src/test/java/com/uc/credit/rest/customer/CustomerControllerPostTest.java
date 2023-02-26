package com.uc.credit.rest.customer;

import com.uc.credit.CreditApplicationTests;
import com.uc.credit.RequestSpec;
import com.uc.credit.ResponseSpec;
import com.uc.credit.model.dto.customer.request.SaveCustomerRequest;
import com.uc.credit.model.dto.customer.response.CustomerResponse;
import com.uc.credit.model.entity.Address;
import com.uc.credit.repository.CustomerRepository;
import com.uc.credit.utils.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;


@Slf4j
public class CustomerControllerPostTest  extends CreditApplicationTests {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RandomUtils randomUtils;
    private String path() {
        return "/customer";
    }

    @Test
    public void testPost200() {
        SaveCustomerRequest request = createSaveCustomerRequest();
        CustomerResponse response = RequestSpec.given()
                .jsonRequest().body(request).post(path())
                .then().log().all()
                .spec(ResponseSpec.isOkResponse())
                .extract().body().as(CustomerResponse.class);

        Assert.assertTrue("Should be in DB", customerRepository.findById(response.getId()).isPresent());
        Assert.assertEquals(request.getFirstname(), response.getFirstname());
        Assert.assertEquals(request.getLastname(), response.getLastname());
        Assert.assertEquals(request.getCitizenId(), response.getCitizenId());
    }

    public SaveCustomerRequest createSaveCustomerRequest() {
        Address address= new Address();
        address.setProvince("Denizli");
        address.setCountry("Türkiye");
        address.setDistrict("Pamukkale");
        address.setNeighborhood("Asmalıevler");
        address.setStreet("6661");
        address.setBuildingInformation("No:23 Kat:1 Daire:1");
        SaveCustomerRequest request = SaveCustomerRequest.builder()
                .firstname("Ali")
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