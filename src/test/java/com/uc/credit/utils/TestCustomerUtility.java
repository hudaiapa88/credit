package com.uc.credit.utils;

import com.uc.credit.model.dto.customer.request.SaveCustomerRequest;
import com.uc.credit.model.entity.Address;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

@Component
public class TestCustomerUtility {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RandomUtils randomUtils;
    public Customer createTestCustomer() {
        Address address= new Address();
        address.setProvince("Denizli");
        address.setCountry("Türkiye");
        address.setDistrict("Pamukkale");
        address.setNeighborhood("Asmalıevler");
        address.setStreet("6661");
        address.setBuildingInformation("No:23 Kat:1 Daire:1");
            return customerRepository.save(Customer.create(SaveCustomerRequest.builder()
                    .firstname(randomUtils.randomFirstname())
                    .lastname(randomUtils.randomLastname())
                    .citizenId(randomUtils.randomCitizenId())
                    .birthDate(LocalDate.of(1997,3,4))
                    .monthlyIncome(new BigDecimal(10000))
                    .phone(randomUtils.randomPhoneNumber())
                    .address(address)
                    .build()));
    }
    public Customer createTestCustomerWithMonthlyIncome(BigDecimal monthlyIncome) {
        Address address= new Address();
        address.setProvince("Denizli");
        address.setCountry("Türkiye");
        address.setDistrict("Pamukkale");
        address.setNeighborhood("Asmalıevler");
        address.setStreet("6661");
        address.setBuildingInformation("No:23 Kat:1 Daire:1");
        return customerRepository.save(Customer.create(SaveCustomerRequest.builder()
                .firstname(randomUtils.randomFirstname())
                .lastname(randomUtils.randomLastname())
                .citizenId(randomUtils.randomCitizenId())
                .birthDate(LocalDate.of(1997,3,4))
                .monthlyIncome(monthlyIncome)
                .phone(randomUtils.randomPhoneNumber())
                .address(address)
                .build()));
    }
}
