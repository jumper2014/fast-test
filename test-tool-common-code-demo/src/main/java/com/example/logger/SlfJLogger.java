package com.example.logger;

public class SlfJLogger implements ILogger{

    private org.slf4j.Logger logger;

    public SlfJLogger(org.slf4j.Logger slfjLogger) {
        this.logger = slfjLogger;
    }

    @Override
    public void debug(String msg) {
        if(logger != null && logger.isDebugEnabled()) {
            logger.debug(msg);
        }
    }

    @Override
    public void debug(String format, Object... arguments) {
        if(logger != null && logger.isDebugEnabled()) {
            logger.debug(format, arguments);
        }
    }

    @Override
    public void debug(String format, Object arg) {
        if(logger != null && logger.isDebugEnabled()) {
            logger.debug(format, arg);
        }
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        if(logger != null && logger.isDebugEnabled()) {
            logger.debug(format, arg1, arg2);
        }
    }

    @Override
    public void debug(String msg, Throwable throwable) {
        if(logger != null && logger.isDebugEnabled()) {
            logger.debug(msg, throwable);
        }
    }

    @Override
    public void error(String msg) {
        if(logger != null && logger.isErrorEnabled()) {
            logger.error(msg);
        }
    }

    @Override
    public void error(String format, Object... arguments) {
        if(logger != null && logger.isErrorEnabled()) {
            logger.error(format, arguments);
        }
    }

    @Override
    public void error(String format, Object arg) {
        if(logger != null && logger.isErrorEnabled()) {
            logger.error(format, arg);
        }
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        if(logger != null && logger.isErrorEnabled()) {
            logger.error(format, arg1, arg2);
        }
    }

    @Override
    public void error(String msg, Throwable throwable) {
        if(logger != null && logger.isErrorEnabled()) {
            logger.error(msg, throwable);
        }
    }

    @Override
    public void info(String msg) {
        if(logger != null && logger.isInfoEnabled()) {
            logger.info(msg);
        }
    }

    @Override
    public void info(String format, Object... arguments) {
        if(logger != null && logger.isInfoEnabled()) {
            logger.info(format, arguments);
        }
    }

    @Override
    public void info(String format, Object arg) {
        if(logger != null && logger.isInfoEnabled()) {
            logger.info(format, arg);
        }
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        if(logger != null && logger.isInfoEnabled()) {
            logger.info(format, arg1, arg2);
        }
    }

    @Override
    public void info(String msg, Throwable throwable) {
        if(logger != null && logger.isInfoEnabled()) {
            logger.info(msg, throwable);
        }
    }

    @Override
    public void trace(String msg) {
        if(logger != null && logger.isTraceEnabled()) {
            logger.trace(msg);
        }
    }

    @Override
    public void trace(String format, Object... arguments) {
        if(logger != null && logger.isTraceEnabled()) {
            logger.trace(format, arguments);
        }
    }

    @Override
    public void trace(String format, Object arg) {
        if(logger != null && logger.isTraceEnabled()) {
            logger.trace(format, arg);
        }
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        if(logger != null && logger.isTraceEnabled()) {
            logger.trace(format, arg1, arg2);
        }
    }

    @Override
    public void trace(String msg, Throwable throwable) {
        if(logger != null && logger.isTraceEnabled()) {
            logger.trace(msg, throwable);
        }
    }

    @Override
    public void warn(String msg) {
        if(logger != null && logger.isWarnEnabled()) {
            logger.warn(msg);
        }
    }

    @Override
    public void warn(String format, Object... arguments) {
        if(logger != null && logger.isWarnEnabled()) {
            logger.warn(format, arguments);
        }
    }

    @Override
    public void warn(String format, Object arg) {
        if(logger != null && logger.isWarnEnabled()) {
            logger.warn(format, arg);
        }
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        if(logger != null && logger.isWarnEnabled()) {
            logger.warn(format, arg1, arg2);
        }
    }

    @Override
    public void warn(String msg, Throwable throwable) {
        if(logger != null && logger.isWarnEnabled()) {
            logger.warn(msg, throwable);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

}
