package com.pss.demo.response;

import lombok.Data;

@Data
public class ResponseResult<T> {

    public ResponseResult(ResponseEnum responseEnum, T data){
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.data = data;
    }

    private String code;
    private String message;
    private T data;

}
