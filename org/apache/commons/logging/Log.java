package org.apache.commons.logging;

@Deprecated
public interface Log {
    void debug(Object arg1);

    void debug(Object arg1, Throwable arg2);

    void error(Object arg1);

    void error(Object arg1, Throwable arg2);

    void fatal(Object arg1);

    void fatal(Object arg1, Throwable arg2);

    void info(Object arg1);

    void info(Object arg1, Throwable arg2);

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isFatalEnabled();

    boolean isInfoEnabled();

    boolean isTraceEnabled();

    boolean isWarnEnabled();

    void trace(Object arg1);

    void trace(Object arg1, Throwable arg2);

    void warn(Object arg1);

    void warn(Object arg1, Throwable arg2);
}

