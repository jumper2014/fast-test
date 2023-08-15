package com.example.logger;

import org.apache.dubbo.rpc.RpcContext;
import org.springframework.util.StringUtils;

public class AlarmLogFormatter {
    private String alarmID;
    private String requestType;
    private String errorMsg;
    private String errorCode;
    private String[] reserved;

    AlarmLogFormatter(String alarmID, String requestType, String errorCode, String errorMsg, String... reserved) {
        this.alarmID = alarmID;
        this.requestType = requestType;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.reserved = reserved;
    }

    public static AlarmLogFormatterBuilder builder() {
        return new AlarmLogFormatterBuilder();
    }

    public String getMessage() {
        String idcFromEnv = LoggerHelper.getIdc();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LoggerHelper.getCurrentDate()).append(LogConstants.VERTICAL_LINE);

        String dubboTraceId = RpcContext.getContext().getAttachment(LogConstants.TRACE_ID);
        String strDubboTraceId = StringUtils.isEmpty(dubboTraceId)? "" :dubboTraceId;
        stringBuilder.append(strDubboTraceId).append(LogConstants.VERTICAL_LINE);

        String strRequestType = StringUtils.isEmpty(requestType)?"":requestType;
        stringBuilder.append(strRequestType).append(LogConstants.VERTICAL_LINE);

        String appClientName = LoggerHelper.getAppName();
        String strAppClientName = StringUtils.isEmpty(appClientName)?"":appClientName;
        stringBuilder.append(strAppClientName).append(LogConstants.VERTICAL_LINE);

        stringBuilder.append(StringUtils.isEmpty(idcFromEnv)?"":idcFromEnv).append(LogConstants.VERTICAL_LINE);
        stringBuilder.append(LoggerHelper.getIp()).append(LogConstants.VERTICAL_LINE);
        stringBuilder.append(StringUtils.isEmpty(errorCode)?"":errorCode).append(LogConstants.VERTICAL_LINE);
        stringBuilder.append(StringUtils.isEmpty(errorMsg)?"":errorMsg);
        LoggerHelper.reseredFieldBuilder(stringBuilder, this.reserved);

        return stringBuilder.toString();


    }



    public static class AlarmLogFormatterBuilder {
        private String alarmID;
        private String requestType;
        private String errorMsg;
        private String errorCode;
        private String[] reserved;

        public AlarmLogFormatterBuilder errorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        public AlarmLogFormatterBuilder errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public AlarmLogFormatterBuilder requestType(String requestType) {
            this.requestType = requestType;
            return this;
        }

        public AlarmLogFormatterBuilder alarmID(String alarmID) {
            this.alarmID = alarmID;
            return this;
        }

        public AlarmLogFormatterBuilder reserved(String... reserved) {
            this.reserved = reserved;
            return this;
        }

        public AlarmLogFormatter build() {
            return new AlarmLogFormatter(this.alarmID, this.requestType, this.errorCode, this.errorMsg, this.reserved);
        }

    }





}
