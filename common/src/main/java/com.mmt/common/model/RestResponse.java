package com.mmt.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponse<T> {
    private int statusCode;
    private T data;
    private String message;

    public static <T> RestResponse<T> buildSuccess(T t) {
        RestResponse<T> restResponse = new RestResponse();
        restResponse.statusCode = 200;
        restResponse.message = "success";
        restResponse.data = t;
        return restResponse;
    }

    public static <T> RestResponse<T> builedFaild(int code, String msg) {
        RestResponse<T> restResponse = new RestResponse();
        restResponse.statusCode = code;
        restResponse.message = msg;
        return restResponse;
    }

    public static <T> RestResponse<T> buildFailed(String message){
        RestResponse<T> restResponse = new RestResponse();
        restResponse.statusCode = 500;
        restResponse.message = "fail";
        return restResponse;
    }

    public static <T> RestResponse<T> buildNotFound(){
        RestResponse<T> restResponse = new RestResponse();
        restResponse.statusCode = 404;
        restResponse.message = "not found";
        return restResponse;
    }
}
