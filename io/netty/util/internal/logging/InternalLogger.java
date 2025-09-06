package io.netty.util.internal.logging;

public interface InternalLogger {
    void debug(String arg1);

    void debug(String arg1, Object arg2);

    void debug(String arg1, Object arg2, Object arg3);

    void debug(String arg1, Throwable arg2);

    void debug(String arg1, Object[] arg2);

    void debug(Throwable arg1);

    void error(String arg1);

    void error(String arg1, Object arg2);

    void error(String arg1, Object arg2, Object arg3);

    void error(String arg1, Throwable arg2);

    void error(String arg1, Object[] arg2);

    void error(Throwable arg1);

    void info(String arg1);

    void info(String arg1, Object arg2);

    void info(String arg1, Object arg2, Object arg3);

    void info(String arg1, Throwable arg2);

    void info(String arg1, Object[] arg2);

    void info(Throwable arg1);

    boolean isDebugEnabled();

    boolean isEnabled(InternalLogLevel arg1);

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isTraceEnabled();

    boolean isWarnEnabled();

    void log(InternalLogLevel arg1, String arg2);

    void log(InternalLogLevel arg1, String arg2, Object arg3);

    void log(InternalLogLevel arg1, String arg2, Object arg3, Object arg4);

    void log(InternalLogLevel arg1, String arg2, Throwable arg3);

    void log(InternalLogLevel arg1, String arg2, Object[] arg3);

    void log(InternalLogLevel arg1, Throwable arg2);

    String name();

    void trace(String arg1);

    void trace(String arg1, Object arg2);

    void trace(String arg1, Object arg2, Object arg3);

    void trace(String arg1, Throwable arg2);

    void trace(String arg1, Object[] arg2);

    void trace(Throwable arg1);

    void warn(String arg1);

    void warn(String arg1, Object arg2);

    void warn(String arg1, Object arg2, Object arg3);

    void warn(String arg1, Throwable arg2);

    void warn(String arg1, Object[] arg2);

    void warn(Throwable arg1);
}

