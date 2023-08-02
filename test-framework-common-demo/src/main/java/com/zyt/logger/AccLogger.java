package com.zyt.logger;


public class AccLogger extends AbstractLogger {
    private static ILogger logger = FtLoggerFactory.getLogger(LogType.LOG_TYPE_ALARM);

    private static AccLogger instance = null;

    public static synchronized AccLogger getInstance() {
        if(instance == null) {
            instance = new AccLogger();
        }
        return instance;
    }

    public AccLogger() {
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
