package com.uc.credit.repository;

import com.uc.credit.model.entity.user.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;


public interface CustomerRepository extends MongoRepository<Customer, String> {
}
