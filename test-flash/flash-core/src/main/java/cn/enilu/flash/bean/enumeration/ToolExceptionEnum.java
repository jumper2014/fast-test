package cn.enilu.flash.bean.enumeration;

import cn.enilu.flash.bean.exception.ServiceExceptionEnum;

/**
 * @Description 测试平台的业务异常的枚举
 */
public enum ToolExceptionEnum implements ServiceExceptionEnum {




    FLOW_ALREADY_REG(401, "该用户已经注册");




    ToolExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
