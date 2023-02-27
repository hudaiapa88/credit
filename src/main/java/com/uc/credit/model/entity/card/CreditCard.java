package com.uc.credit.model.entity.card;

import com.uc.credit.model.entity.account.CreditAccount;
import com.uc.credit.model.enums.CardType;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@Document(collection = "card")
@TypeAlias("creditCard")
public class CreditCard extends Card{
    public CreditCard() {
        setCardType(CardType.CREDIT);
    }
    @DocumentReference(lookup = "{ '_id' : '?#{#target}' }")
    private CreditAccount creditAccount;
}
