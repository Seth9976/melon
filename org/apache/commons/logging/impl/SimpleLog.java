package org.apache.commons.logging.impl;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Properties;
import org.apache.commons.logging.Log;

@Deprecated
public class SimpleLog implements Serializable, Log {
    protected static final String DEFAULT_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss:SSS zzz";
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_DEBUG = 2;
    public static final int LOG_LEVEL_ERROR = 5;
    public static final int LOG_LEVEL_FATAL = 6;
    public static final int LOG_LEVEL_INFO = 3;
    public static final int LOG_LEVEL_OFF = 7;
    public static final int LOG_LEVEL_TRACE = 1;
    public static final int LOG_LEVEL_WARN = 4;
    protected int currentLogLevel;
    protected static DateFormat dateFormatter = null;
    protected static String dateTimeFormat = null;
    protected String logName;
    protected static boolean showDateTime = false;
    protected static boolean showLogName = false;
    protected static boolean showShortName = false;
    protected static final Properties simpleLogProps = null;
    protected static final String systemPrefix = "org.apache.commons.logging.simplelog.";

    public SimpleLog(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final void debug(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final void debug(Object object0, Throwable throwable0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final void error(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final void error(Object object0, Throwable throwable0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final void fatal(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final void fatal(Object object0, Throwable throwable0) {
        throw new RuntimeException("Stub!");
    }

    public int getLevel() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final void info(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final void info(Object object0, Throwable throwable0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final boolean isDebugEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final boolean isErrorEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final boolean isFatalEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final boolean isInfoEnabled() {
        throw new RuntimeException("Stub!");
    }

    public boolean isLevelEnabled(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final boolean isTraceEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final boolean isWarnEnabled() {
        throw new RuntimeException("Stub!");
    }

    public void log(int v, Object object0, Throwable throwable0) {
        throw new RuntimeException("Stub!");
    }

    public void setLevel(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final void trace(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final void trace(Object object0, Throwable throwable0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final void warn(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final void warn(Object object0, Throwable throwable0) {
        throw new RuntimeException("Stub!");
    }

    public void write(StringBuffer stringBuffer0) {
        throw new RuntimeException("Stub!");
    }
}

