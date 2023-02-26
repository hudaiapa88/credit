package com.uc.credit.repository;

import com.uc.credit.model.entity.request.LoanRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanRequestRepository extends MongoRepository<LoanRequest, String> {
}
