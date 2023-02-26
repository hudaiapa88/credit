package com.uc.credit.model.entity.request;

import com.uc.credit.model.entity.base.AuditData;
import com.uc.credit.model.entity.user.Customer;
import com.uc.credit.model.enums.RequestStatus;
import com.uc.credit.model.enums.RequestType;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@Document(collection = "request")
public class Request extends AuditData {
    @DocumentReference(lookup = "{ '_id' : '?#{#target}' }")
    private Customer customer;
    private RequestStatus requestStatus;
    private RequestType requestType;
}
