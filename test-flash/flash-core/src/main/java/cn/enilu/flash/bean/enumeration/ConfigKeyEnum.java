package cn.enilu.flash.bean.enumeration;

public enum ConfigKeyEnum {
    /**
     * 系统默认上传路径
     */
    SYSTEM_FILE_UPLOAD_PATH("system.file.upload.path"),
    /**
     * 系统名称
     */
    SYSTEM_APP_NAME("system.app.name"),
    /**
     * 腾讯sms接口appid
     */
    API_TENCENT_SMS_APPID("api.tencent.sms.appid"),
    /**
     * 腾讯sms接口appkey
     */
    API_TENCENT_SMS_APPKEY("api.tencent.sms.appkey"),
    /**
     * 腾讯sms接口签名参数
     */
    API_TENCENT_SMS_SIGN("api.tencent.sms.sign"),
    API_ALIYUN_SMS_ACCESS_KEY_ID("api.aliyun.sms.access.key.id"),
    API_ALIYUN_SMS_ACCESS_SECRET("api.aliyun.sms.access.secret"),
    API_ALIYUN_SMS_REGION_ID("api.aliyun.sms.region.id"),
    API_ALIYUN_SMS_SIGN_NAME("api.aliyun.sms.sign.name");

    private String value;

    ConfigKeyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
