package com.uc.credit.model.dto.loanrequest.request;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class UpdateLoanRequestRequest {
    private BigDecimal amount;
}
