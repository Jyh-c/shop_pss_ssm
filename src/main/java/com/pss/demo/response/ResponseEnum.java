package com.pss.demo.response;

public enum ResponseEnum {

    SUCCESS("0", "请求成功"),
    ERROR("-1", "系统错误");

    private String code;
    private String message;

    ResponseEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }

    public static void main(String[] args) {
        System.out.println(ResponseEnum.SUCCESS.getCode());
        System.out.println(ResponseEnum.SUCCESS.getMessage());
    }

}
