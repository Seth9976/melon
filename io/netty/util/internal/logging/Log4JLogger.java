package io.netty.util.internal.logging;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

class Log4JLogger extends AbstractInternalLogger {
    static final String FQCN = "io.netty.util.internal.logging.Log4JLogger";
    final transient Logger logger;
    private static final long serialVersionUID = 0x27920E6556B5C112L;
    final boolean traceCapable;

    public Log4JLogger(Logger logger0) {
        super(logger0.getName());
        this.logger = logger0;
        this.traceCapable = this.isTraceCapable();
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s) {
        this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.DEBUG), s, null);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Object object0) {
        if(this.logger.isDebugEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0);
            this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.DEBUG), formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Object object0, Object object1) {
        if(this.logger.isDebugEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0, object1);
            this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.DEBUG), formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Throwable throwable0) {
        this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.DEBUG), s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Object[] arr_object) {
        if(this.logger.isDebugEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.arrayFormat(s, arr_object);
            this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.DEBUG), formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s) {
        this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.ERROR), s, null);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Object object0) {
        if(this.logger.isEnabledFor(((Priority)Level.ERROR))) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0);
            this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.ERROR), formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Object object0, Object object1) {
        if(this.logger.isEnabledFor(((Priority)Level.ERROR))) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0, object1);
            this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.ERROR), formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Throwable throwable0) {
        this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.ERROR), s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Object[] arr_object) {
        if(this.logger.isEnabledFor(((Priority)Level.ERROR))) {
            FormattingTuple formattingTuple0 = MessageFormatter.arrayFormat(s, arr_object);
            this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.ERROR), formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s) {
        this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.INFO), s, null);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Object object0) {
        if(this.logger.isInfoEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0);
            this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.INFO), formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Object object0, Object object1) {
        if(this.logger.isInfoEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0, object1);
            this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.INFO), formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Throwable throwable0) {
        this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.INFO), s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Object[] arr_object) {
        if(this.logger.isInfoEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.arrayFormat(s, arr_object);
            this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.INFO), formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isErrorEnabled() {
        return this.logger.isEnabledFor(((Priority)Level.ERROR));
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    private boolean isTraceCapable() {
        try {
            this.logger.isTraceEnabled();
            return true;
        }
        catch(NoSuchMethodError unused_ex) {
            return false;
        }
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isTraceEnabled() {
        return this.traceCapable ? this.logger.isTraceEnabled() : this.logger.isDebugEnabled();
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isWarnEnabled() {
        return this.logger.isEnabledFor(((Priority)Level.WARN));
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s) {
        this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)(this.traceCapable ? Level.TRACE : Level.DEBUG)), s, null);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Object object0) {
        if(this.isTraceEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0);
            this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)(this.traceCapable ? Level.TRACE : Level.DEBUG)), formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Object object0, Object object1) {
        if(this.isTraceEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0, object1);
            this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)(this.traceCapable ? Level.TRACE : Level.DEBUG)), formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Throwable throwable0) {
        this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)(this.traceCapable ? Level.TRACE : Level.DEBUG)), s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Object[] arr_object) {
        if(this.isTraceEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.arrayFormat(s, arr_object);
            this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)(this.traceCapable ? Level.TRACE : Level.DEBUG)), formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s) {
        this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.WARN), s, null);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Object object0) {
        if(this.logger.isEnabledFor(((Priority)Level.WARN))) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0);
            this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.WARN), formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Object object0, Object object1) {
        if(this.logger.isEnabledFor(((Priority)Level.WARN))) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0, object1);
            this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.WARN), formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Throwable throwable0) {
        this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.WARN), s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Object[] arr_object) {
        if(this.logger.isEnabledFor(((Priority)Level.WARN))) {
            FormattingTuple formattingTuple0 = MessageFormatter.arrayFormat(s, arr_object);
            this.logger.log("io.netty.util.internal.logging.Log4JLogger", ((Priority)Level.WARN), formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }
}

