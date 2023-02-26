package com.uc.credit.model.entity.user;

import com.uc.credit.model.dto.customer.request.SaveCustomerRequest;
import com.uc.credit.model.dto.customer.request.UpdateCustomerRequest;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;


@Data
@Document(collection = "user")
@TypeAlias("customer")
public class Customer extends User{

    private BigDecimal monthlyIncome;


    public static Customer create(SaveCustomerRequest saveCustomerRequest){
        Customer customer= new Customer();
        customer.setFirstname(saveCustomerRequest.getFirstname());
        customer.setLastname(saveCustomerRequest.getLastname());
        customer.setCitizenId(saveCustomerRequest.getCitizenId());
        customer.setPhone(saveCustomerRequest.getPhone());
        customer.setBirthDate(saveCustomerRequest.getBirthDate());
        customer.setMonthlyIncome(saveCustomerRequest.getMonthlyIncome());
        customer.setAddress(saveCustomerRequest.getAddress());
        return customer;
    }
    public Customer update(UpdateCustomerRequest updateCustomerRequest){
        setFirstname(updateCustomerRequest.getFirstname());
        setLastname(updateCustomerRequest.getLastname());
        setCitizenId(updateCustomerRequest.getCitizenId());
        setPhone(updateCustomerRequest.getPhone());
        setBirthDate(updateCustomerRequest.getBirthDate());
        setMonthlyIncome(updateCustomerRequest.getMonthlyIncome());
        return this;
    }
}
