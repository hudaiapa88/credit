package com.uc.credit.exception.api.handler;


import com.uc.credit.exception.api.model.ErrorResponse;
import com.uc.credit.exception.base.BaseException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler  {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public ErrorResponse validationException(
            ValidationException ex,
            HttpServletRequest request){

        log.error("validation exception : "+
                ex.getLocalizedMessage()+
                " for "+
                request.getRequestURI() );

            return ErrorResponse.builder()
                    .message(ex.getMessage())
                    .code(HttpStatus.BAD_REQUEST.toString())
                    .request(request.getRequestURI())
                    .requestType(request.getMethod())
                    .build();


    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorResponse handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpServletRequest request){

        log.error("validation exception : "+
                ex.getLocalizedMessage()+
                " for "+
                request.getRequestURI() );

        return ErrorResponse.builder()
                .message(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage())
                .code(HttpStatus.BAD_REQUEST.toString())
                .request(request.getRequestURI())
                .requestType(request.getMethod())
                .build();


    }

    @ExceptionHandler({BaseException.class})
    public ResponseEntity<ErrorResponse> genericException(
            BaseException ex,
            HttpServletRequest request){

        log.error("exception : "+
                ex.getLocalizedMessage()+
                " for "+
                request.getRequestURI() );

        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .message(ex.getLocalizedMessage())
                        .code(ex.getHttpStatus().toString())
                        .request(request.getRequestURI())
                        .requestType(request.getMethod())
                        .build(), ex.getHttpStatus());
    }
}
