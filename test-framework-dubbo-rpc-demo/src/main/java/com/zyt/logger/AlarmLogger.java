package com.zyt.logger;


public class AlarmLogger extends AbstractLogger {
    private static ILogger logger = FtLoggerFactory.getLogger(LogType.LOG_TYPE_ALARM);

    private static  AlarmLogger instance = null;

    public static synchronized AlarmLogger getInstance() {
        if(instance == null) {
            instance = new AlarmLogger();
        }
        return instance;
    }

    public AlarmLogger() {
        super(logger);
    }

    public void debug(final AlarmLogFormatter.AlarmLogFormatterBuilder builder) {
        logger.debug((builder==null?null: builder.build().getMessage()));
    }

    public void warn(final AlarmLogFormatter.AlarmLogFormatterBuilder builder) {
        logger.warn((builder==null?null: builder.build().getMessage()));
    }

    public void error(final AlarmLogFormatter.AlarmLogFormatterBuilder builder) {
        logger.error((builder==null?null: builder.build().getMessage()));
    }

    public void trace(final AlarmLogFormatter.AlarmLogFormatterBuilder builder) {
        logger.trace((builder==null?null: builder.build().getMessage()));
    }

    public void info(final AlarmLogFormatter.AlarmLogFormatterBuilder builder) {
        logger.info((builder==null?null: builder.build().getMessage()));
    }
}
