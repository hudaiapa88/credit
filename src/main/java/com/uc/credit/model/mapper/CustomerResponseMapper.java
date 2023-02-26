package com.uc.credit.model.mapper;

import com.uc.credit.model.dto.customer.response.CustomerResponse;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.model.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerResponseMapper extends BaseMapper<Customer, CustomerResponse> {
}
