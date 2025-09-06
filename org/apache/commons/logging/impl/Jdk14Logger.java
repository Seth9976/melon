package org.apache.commons.logging.impl;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;

@Deprecated
public class Jdk14Logger implements Serializable, Log {
    protected static final Level dummyLevel;
    protected transient Logger logger;
    protected String name;

    public Jdk14Logger(String s) {
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

    public Logger getLogger() {
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
    public boolean isDebugEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public boolean isErrorEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public boolean isFatalEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public boolean isInfoEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public boolean isTraceEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.Log
    public boolean isWarnEnabled() {
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

