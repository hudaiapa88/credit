package com.uc.credit.model.entity.request;

import com.uc.credit.model.enums.RequestType;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
@Data
@Document(collection = "request")
@TypeAlias("limitUpdateRequest")
public class LimitUpdateRequest extends Request{
    private BigDecimal amount;
    public LimitUpdateRequest() {
        setRequestType(RequestType.LIMITUPDATE);
    }
}
