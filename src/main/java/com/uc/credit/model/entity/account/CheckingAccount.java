package com.uc.credit.model.entity.account;

import com.uc.credit.model.enums.AccountType;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "account")
@TypeAlias("checkingAccount")
public class CheckingAccount extends Account{
    public CheckingAccount() {
        setAccountType(AccountType.CHECKING);
    }

    private String iban;
}
