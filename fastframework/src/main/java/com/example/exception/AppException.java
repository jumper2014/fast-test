package com.example.exception;

import com.example.App;
import com.example.exception.enums.ErrorCodeEnum;

public class AppException extends RuntimeException {

    private String errCode;

    public AppException(ErrorCodeEnum errorCodeEnum, Throwable cause) {
        super(errorCodeEnum.getDesc(), cause);
        this.errCode = errorCodeEnum.getCode();
    }

    public AppException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getDesc());
        this.errCode = errorCodeEnum.getCode();
    }

    public AppException(ErrorCodeEnum errorCodeEnum, String errorMessage) {
        super(errorMessage);
        this.errCode = errorCodeEnum.getCode();
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
}
