package com.zyt.logger;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FtLoggerFactory {
    public static ILogger getLogger(LogType desc) {
        Logger slfjLogger = LoggerFactory.getLogger(desc.getType());
        return new SlfJLogger(slfjLogger);
    }

    public static <T> ILogger getLogger(Class<T> clazz) {
        Logger slfjLogger = LoggerFactory.getLogger(clazz);
        return new SlfJLogger(slfjLogger);
    }

    public static ILogger getFtLogger(LogType desc) {
        if(desc.getType().equals(LogType.LOG_TYPE_ALARM.getType())) {
            return AlarmLogger.getInstance();
        } else {
            return AccLogger.getInstance();
        }
    }
}
