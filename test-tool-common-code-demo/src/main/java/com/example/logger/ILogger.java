package com.example.logger;

public interface ILogger {
    void debug(String msg);
    void debug(String format, Object... arguments);
    void debug(String format, Object arg);
    void debug(String format, Object arg1, Object arg2);
    void debug(String msg, Throwable throwable);

    void error(String msg);
    void error(String format, Object... arguments);
    void error(String format, Object arg);
    void error(String format, Object arg1, Object arg2);
    void error(String msg, Throwable throwable);

    void info(String msg);
    void info(String format, Object... arguments);
    void info(String format, Object arg);
    void info(String format, Object arg1, Object arg2);
    void info(String msg, Throwable throwable);

    void trace(String msg);
    void trace(String format, Object... arguments);
    void trace(String format, Object arg);
    void trace(String format, Object arg1, Object arg2);
    void trace(String msg, Throwable throwable);

    void warn(String msg);
    void warn(String format, Object... arguments);
    void warn(String format, Object arg);
    void warn(String format, Object arg1, Object arg2);
    void warn(String msg, Throwable throwable);

    boolean isDebugEnabled();
    boolean isErrorEnabled();
    boolean isInfoEnabled();
    boolean isTraceEnabled();
    boolean isWarnEnabled();





}
