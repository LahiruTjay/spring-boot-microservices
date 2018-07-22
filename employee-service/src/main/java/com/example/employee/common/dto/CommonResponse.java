package com.example.employee.common.dto;

public class CommonResponse {

    private String code;
    private Object data;

    public CommonResponse() {
    }

    public CommonResponse(String code) {
        this.code = code;
    }

    public CommonResponse(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
