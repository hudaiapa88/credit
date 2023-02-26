package com.uc.credit.model.entity;

import com.uc.credit.model.dto.score.request.SaveScoreRequest;
import com.uc.credit.model.dto.score.request.UpdateScoreRequest;
import com.uc.credit.model.entity.base.BaseEntity;
import com.uc.credit.model.entity.user.Customer;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@Document
public class Score extends BaseEntity {
    private Long amount;
    @Indexed(unique = true)
    @DocumentReference(lookup = "{ '_id' : '?#{#target}' }")
    private Customer customer;

    public static Score create(SaveScoreRequest saveScoreRequest, Customer customer){
        Score score= new Score();
        score.setAmount(saveScoreRequest.getAmount());
        score.setCustomer(customer);
        return score;

    }
    public Score update(UpdateScoreRequest updateScoreRequest){
        setAmount(updateScoreRequest.getAmount());
        return this;
    }
}
