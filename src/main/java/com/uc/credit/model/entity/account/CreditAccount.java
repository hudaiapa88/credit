package com.uc.credit.model.entity.account;

import com.uc.credit.model.enums.AccountType;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Document(collection = "account")
@TypeAlias("creditAccount")
public class CreditAccount extends Account{
    public CreditAccount() {
        setAccountType(AccountType.CREDIT);
    }

    private LocalDate cutOffDate;
    private BigDecimal limit;
}
