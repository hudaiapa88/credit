package com.uc.credit.exception.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private String code;
    private String request;
    private String requestType;
}
