package com.example.constant;

import com.example.logger.FtLoggerFactory;
import com.example.logger.ILogger;
import com.example.logger.LogType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogConstant {

    public static final ILogger ALARM_LOG = FtLoggerFactory.getFtLogger(LogType.LOG_TYPE_ALARM);
    public static final ILogger ACC_LOG = FtLoggerFactory.getFtLogger(LogType.LOG_TYPE_ACCESS);


}
