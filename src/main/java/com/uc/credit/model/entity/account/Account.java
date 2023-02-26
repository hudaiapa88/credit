package com.uc.credit.model.entity.account;

import com.uc.credit.model.entity.base.AuditData;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.model.enums.AccountType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.math.BigDecimal;

@Document(collection = "account")
@Data
public class Account extends AuditData {
    private BigDecimal balance;
    @DocumentReference(lookup = "{ '_id' : '?#{#target}' }")
    private Customer customer;
    @Setter(AccessLevel.PROTECTED)
    private AccountType accountType;
}
