package io.netty.util.internal.logging;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

final class LocationAwareSlf4JLogger extends AbstractInternalLogger {
    static final String FQCN = "io.netty.util.internal.logging.LocationAwareSlf4JLogger";
    private final transient LocationAwareLogger logger;
    private static final long serialVersionUID = -8292030083201538180L;

    public LocationAwareSlf4JLogger(LocationAwareLogger locationAwareLogger0) {
        super(locationAwareLogger0.getName());
        this.logger = locationAwareLogger0;
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s) {
        if(this.isDebugEnabled()) {
            this.log(10, s);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Object object0) {
        if(this.isDebugEnabled()) {
            this.log(10, MessageFormatter.format(s, object0));
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Object object0, Object object1) {
        if(this.isDebugEnabled()) {
            this.log(10, MessageFormatter.format(s, object0, object1));
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Throwable throwable0) {
        if(this.isDebugEnabled()) {
            this.log(10, s, throwable0);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Object[] arr_object) {
        if(this.isDebugEnabled()) {
            this.log(10, MessageFormatter.arrayFormat(s, arr_object));
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s) {
        if(this.isErrorEnabled()) {
            this.log(40, s);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Object object0) {
        if(this.isErrorEnabled()) {
            this.log(40, MessageFormatter.format(s, object0));
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Object object0, Object object1) {
        if(this.isErrorEnabled()) {
            this.log(40, MessageFormatter.format(s, object0, object1));
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Throwable throwable0) {
        if(this.isErrorEnabled()) {
            this.log(40, s, throwable0);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Object[] arr_object) {
        if(this.isErrorEnabled()) {
            this.log(40, MessageFormatter.arrayFormat(s, arr_object));
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s) {
        if(this.isInfoEnabled()) {
            this.log(20, s);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Object object0) {
        if(this.isInfoEnabled()) {
            this.log(20, MessageFormatter.format(s, object0));
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Object object0, Object object1) {
        if(this.isInfoEnabled()) {
            this.log(20, MessageFormatter.format(s, object0, object1));
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Throwable throwable0) {
        if(this.isInfoEnabled()) {
            this.log(20, s, throwable0);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Object[] arr_object) {
        if(this.isInfoEnabled()) {
            this.log(20, MessageFormatter.arrayFormat(s, arr_object));
        }
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

    private void log(int v, String s) {
        this.logger.log(null, "io.netty.util.internal.logging.LocationAwareSlf4JLogger", v, s, null, null);
    }

    private void log(int v, String s, Throwable throwable0) {
        this.logger.log(null, "io.netty.util.internal.logging.LocationAwareSlf4JLogger", v, s, null, throwable0);
    }

    private void log(int v, FormattingTuple formattingTuple0) {
        Object[] arr_object = formattingTuple0.getArgArray();
        Throwable throwable0 = formattingTuple0.getThrowable();
        this.logger.log(null, "io.netty.util.internal.logging.LocationAwareSlf4JLogger", v, formattingTuple0.getMessage(), arr_object, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s) {
        if(this.isTraceEnabled()) {
            this.log(0, s);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Object object0) {
        if(this.isTraceEnabled()) {
            this.log(0, MessageFormatter.format(s, object0));
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Object object0, Object object1) {
        if(this.isTraceEnabled()) {
            this.log(0, MessageFormatter.format(s, object0, object1));
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Throwable throwable0) {
        if(this.isTraceEnabled()) {
            this.log(0, s, throwable0);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Object[] arr_object) {
        if(this.isTraceEnabled()) {
            this.log(0, MessageFormatter.arrayFormat(s, arr_object));
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s) {
        if(this.isWarnEnabled()) {
            this.log(30, s);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Object object0) {
        if(this.isWarnEnabled()) {
            this.log(30, MessageFormatter.format(s, object0));
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Object object0, Object object1) {
        if(this.isWarnEnabled()) {
            this.log(30, MessageFormatter.format(s, object0, object1));
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Throwable throwable0) {
        if(this.isWarnEnabled()) {
            this.log(30, s, throwable0);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Object[] arr_object) {
        if(this.isWarnEnabled()) {
            this.log(30, MessageFormatter.arrayFormat(s, arr_object));
        }
    }
}

