package com.zyt.logger;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogConstants {
    public static final String TRACE_ID = "TraceId";
    public static final String SPAN_ID = "SpanId";
    public static final String PARENTSPAN_ID = "ParentSpanId";
    public static final String IDC = "";
    public static final String VERTICAL_LINE = "|";
    public static final String SPAN_TYPE = "dubbo";
    public static final String LOG_DATEFORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String APP_NAME = "fast-test";
    public static final String EMPTY_STRING = "";
    public static final String LOG_LEVEL_DEBUG = "TraceId";
    public static final String LOGGER_NAME = "unstructuredlog";
    public static final String MDC_TRACE_ID = "MDC-TraceId";
    public static final String MDC_PARENTID_ID = "MDC-parentId";
    public static final String MDC_SPAN_ID = "MDC-spanId";
    public static final String IDC_KEY = "CSW.common.currentDC";

}
