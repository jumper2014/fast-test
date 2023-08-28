package com.example.exception.enums;

public enum ErrorCodeEnum {
    SYSTEM_UNKNOWN_ERROR(ErrorCategoryEnum.SYSTEM_ERROR, "999", "System Unknown Exception."),
    COMPONENT_INITIALIZED_FAILED(ErrorCategoryEnum.VALIDATE_ERROR, "009", "Component initialized failed"),
    VALIDATE_USER_AGE_FAILED(ErrorCategoryEnum.VALIDATE_ERROR, "009", "validate user age failed"),
        ;
    private final String code;
    private final String desc;

    ErrorCodeEnum(final ErrorCategoryEnum error, final String code, final String desc) {
        this.code = error.getCode() + code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
