package com.uc.credit.repository;

import com.uc.credit.model.entity.Score;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ScoreRepository extends MongoRepository<Score, String> {
    Optional<Score> findByCustomer_Id(String customerId);
}
