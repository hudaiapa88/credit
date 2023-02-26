package com.uc.credit.model.dto.customer.response;

import com.uc.credit.model.dto.base.AuditDataDto;
import com.uc.credit.model.dto.base.BaseDto;
import com.uc.credit.model.entity.Address;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CustomerResponse extends AuditDataDto {
    private String firstname;
    private String lastname;
    private String citizenId;
    private String phone;
    private LocalDate birthDate;
    private BigDecimal monthlyIncome;
    private Address address;
}
