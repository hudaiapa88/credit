package com.uc.credit.model.mapper;

import com.uc.credit.model.dto.loanrequest.response.LoanRequestResponse;
import com.uc.credit.model.entity.request.LoanRequest;
import com.uc.credit.model.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanRequestResponseMapper extends BaseMapper<LoanRequest, LoanRequestResponse> {
}
