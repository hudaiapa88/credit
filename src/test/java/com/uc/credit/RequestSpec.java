package com.uc.credit;



import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    public final static String BASE_URI = "http://localhost/api/v1";

    private final RequestSpecification request;

    private RequestSpec(){
        RestAssured.config().failureConfig(new FailureConfig());
        request = RestAssured.given();
    }
    public static RequestSpec given(){
        return new RequestSpec();
    }
    public RequestSpecification request(){
        return request;
    }

    public RequestSpecification jsonRequest(){
        request.contentType(ContentType.JSON);
        request.accept(ContentType.JSON);
        return request;
    }

    public RequestSpec acceptJson() {
        request.accept(ContentType.JSON);
        return this;
    }
}