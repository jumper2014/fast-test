package com.zyt.constant;

import com.zyt.logger.FtLoggerFactory;
import com.zyt.logger.ILogger;
import com.zyt.logger.LogType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogConstant {

    public static final ILogger ALARM_LOG = FtLoggerFactory.getFtLogger(LogType.LOG_TYPE_ALARM);
    public static final ILogger ACC_LOG = FtLoggerFactory.getFtLogger(LogType.LOG_TYPE_ACCESS);


}
