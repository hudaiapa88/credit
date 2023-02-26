package com.uc.credit.repository;

import com.uc.credit.model.entity.account.CreditAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditAccountRepository extends MongoRepository<CreditAccount,String> {
}
