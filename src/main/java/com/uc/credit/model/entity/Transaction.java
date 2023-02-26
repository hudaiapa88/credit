package com.uc.credit.model.entity;

import com.uc.credit.model.entity.account.Account;
import com.uc.credit.model.entity.base.AuditData;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.math.BigDecimal;

@Data
@Document
public class Transaction extends AuditData {
    private BigDecimal availableBalance;
    private BigDecimal amount;
    @DocumentReference(lookup = "{ '_id' : '?#{#target}' }")
    private Account account;
}
