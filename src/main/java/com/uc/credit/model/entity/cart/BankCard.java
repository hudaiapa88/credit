package com.uc.credit.model.entity.cart;

import com.uc.credit.model.entity.account.Account;
import com.uc.credit.model.enums.CardType;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "card")
@TypeAlias("bankCard")
public class BankCard extends Card {
    public BankCard() {
        setCardType(CardType.BANK);
    }
    @DocumentReference(lazy = false)
    private List<Account> accounts=new ArrayList<>();
}
