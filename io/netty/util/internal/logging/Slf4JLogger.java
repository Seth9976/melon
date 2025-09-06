package io.netty.util.internal.logging;

import org.slf4j.Logger;

final class Slf4JLogger extends AbstractInternalLogger {
    private final transient Logger logger;
    private static final long serialVersionUID = 0x17FD4DF8CCB9C49L;

    public Slf4JLogger(Logger logger0) {
        super(logger0.getName());
        this.logger = logger0;
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s) {
        this.logger.debug(s);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Object object0) {
        this.logger.debug(s, object0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Object object0, Object object1) {
        this.logger.debug(s, object0, object1);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Throwable throwable0) {
        this.logger.debug(s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Object[] arr_object) {
        this.logger.debug(s, arr_object);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s) {
        this.logger.error(s);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Object object0) {
        this.logger.error(s, object0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Object object0, Object object1) {
        this.logger.error(s, object0, object1);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Throwable throwable0) {
        this.logger.error(s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Object[] arr_object) {
        this.logger.error(s, arr_object);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s) {
        this.logger.info(s);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Object object0) {
        this.logger.info(s, object0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Object object0, Object object1) {
        this.logger.info(s, object0, object1);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Throwable throwable0) {
        this.logger.info(s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Object[] arr_object) {
        this.logger.info(s, arr_object);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isErrorEnabled() {
        return this.logger.isErrorEnabled();
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isWarnEnabled() {
        return this.logger.isWarnEnabled();
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s) {
        this.logger.trace(s);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Object object0) {
        this.logger.trace(s, object0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Object object0, Object object1) {
        this.logger.trace(s, object0, object1);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Throwable throwable0) {
        this.logger.trace(s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Object[] arr_object) {
        this.logger.trace(s, arr_object);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s) {
        this.logger.warn(s);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Object object0) {
        this.logger.warn(s, object0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Object object0, Object object1) {
        this.logger.warn(s, object0, object1);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Throwable throwable0) {
        this.logger.warn(s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Object[] arr_object) {
        this.logger.warn(s, arr_object);
    }
}

