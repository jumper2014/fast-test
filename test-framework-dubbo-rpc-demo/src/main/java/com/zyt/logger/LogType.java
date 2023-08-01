package com.zyt.logger;

import java.util.Arrays;

public enum LogType {
    LOG_TYPE_ACCESS("accesslog"),
    LOG_TYPE_ALARM("alarmlog");

    private String type;

    LogType(String type) {
        this.type = type;
    }

    public static LogType getByType(final String type) {
        return Arrays.stream(values()).filter(e->e.getType().equals(type)).findFirst().orElse(null);
    }

    public static LogType getByTypeOrElseThrows(String type) {
        return Arrays.stream(values()).filter(e->e.getType().equals(type)).findFirst().orElseThrow(IllegalArgumentException::new);
    }


    public String getType() {
        return type;
    }
}
