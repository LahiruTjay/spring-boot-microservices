package com.example.employee.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.employee.common.dto.CommonResponse;

public class CommonResponseUtil {

    public static ResponseEntity<CommonResponse> successResponse(Object data) {
        return ResponseEntity.status(HttpStatus.OK)
            .header("content-type", "application/json")
            .body(new CommonResponse(CommonConstants.SUCCESS_CODE, data));
    }

    public static ResponseEntity<CommonResponse> failureResponse() {
        return ResponseEntity.status(HttpStatus.OK)
            .header("content-type", "application/json")
            .body(new CommonResponse(CommonConstants.FAILURE_CODE));
    }

}
