package org.apache.commons.logging.impl;

import java.io.Serializable;
import org.apache.commons.logging.Log;

@Deprecated
public class NoOpLog implements Serializable, Log {
    public NoOpLog() {
        throw new RuntimeException("Stub!");
    }

    public NoOpLog(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public void debug(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public void debug(Object object0, Throwable throwable0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public void error(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public void error(Object object0, Throwable throwable0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public void fatal(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public void fatal(Object object0, Throwable throwable0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public void info(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public void info(Object object0, Throwable throwable0) {
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

    @Override  // org.apache.commons.logging.Log
    public final boolean isTraceEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public final boolean isWarnEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public void trace(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public void trace(Object object0, Throwable throwable0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public void warn(Object object0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public void warn(Object object0, Throwable throwable0) {
        throw new RuntimeException("Stub!");
    }
}

