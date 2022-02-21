package com.zyt.logger;

import io.netty.util.NetUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.dubbo.container.logback.LogbackContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoggerHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerHelper.class);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(LogConstants.LOG_DATEFORMAT);
    private static String ip = null;

    static {
        LoggerHelper.setIp(LoggerHelper.getLocalHost());
    }

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        LoggerHelper.ip = ip;
    }

    private static String appName = null;

    public static String getIdc() {
        return idc;
    }

    public static void setIdc(String idc) {
        LoggerHelper.idc = idc;
    }

    private static String idc = null;

    public static String getAppName() {
        return appName;
    }

    public static void setAppName(String appName) {
        LoggerHelper.appName = appName;
    }

    public static String getLocalHost() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            return NetUtil.toAddressString(addr);
        } catch (UnknownHostException e) {
            LOGGER.error("Cannot get the ip address");
            return "Unknown Host";
        }
    }

    public static String getCurrentDate() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(FORMATTER);
    }

    public static void reseredFieldBuilder(StringBuilder stringBuilder, String... reserved) {
        if(reserved != null) {
            stringBuilder.append(LogConstants.VERTICAL_LINE);
            for(String reserve: reserved) {
                stringBuilder.append(reserve).append((LogConstants.VERTICAL_LINE));
            }
        }
    }


}
