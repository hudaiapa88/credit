package com.uc.credit.manager;

import com.uc.credit.exception.EntityNotFoundException;
import com.uc.credit.model.dto.customer.request.SaveCustomerRequest;
import com.uc.credit.model.dto.customer.request.UpdateCustomerRequest;
import com.uc.credit.model.dto.customer.response.CustomerResponse;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.model.mapper.CustomerResponseMapper;
import com.uc.credit.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class CustomerManager {
    private final CustomerRepository customerRepository;
    private final CustomerResponseMapper customerResponseMapper;
    public CustomerResponse save(SaveCustomerRequest saveCustomerRequest) {
        return customerResponseMapper.convert(customerRepository.save(Customer.create(saveCustomerRequest)));
    }

    public CustomerResponse update(String id, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer=findById(id);
        return customerResponseMapper.convert(customerRepository.save(customer.update(updateCustomerRequest)));
    }

    public Customer findById(String id) {
        return customerRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Müşteri bulunamadı."));
    }

    public void delete(String id) {

    }

    public CustomerResponse getById(String id) {
        return customerResponseMapper.convert(findById(id));
    }

    public List<CustomerResponse> getAll() {
        return customerResponseMapper.convertList(customerRepository.findAll());
    }
}
