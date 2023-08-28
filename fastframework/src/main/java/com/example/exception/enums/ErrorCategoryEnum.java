package com.example.exception.enums;

public enum ErrorCategoryEnum {
    VALIDATE_ERROR("01"),
    SYSTEM_ERROR("02"),
    ;

    private final String code;
    ErrorCategoryEnum(String code) {
        this.code = code;
    }
    public String getCode() {
        return this.code;
    }
}
