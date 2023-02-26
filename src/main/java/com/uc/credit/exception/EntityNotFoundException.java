package com.uc.credit.exception;

import com.uc.credit.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends BaseException {
    public EntityNotFoundException(String message) {
        super(message,HttpStatus.NOT_FOUND);
    }


}
