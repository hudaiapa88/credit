package com.uc.credit.model.dto.loanrequest.response;

import com.uc.credit.model.dto.base.AuditDataDto;
import com.uc.credit.model.enums.RequestStatus;
import com.uc.credit.model.enums.RequestType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class LoanRequestResponse extends AuditDataDto {
    private RequestStatus requestStatus;
    private RequestType requestType;
    private BigDecimal amount;
}
