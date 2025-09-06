package io.netty.util.internal.logging;

import io.netty.util.internal.ObjectUtil;
import org.apache.commons.logging.Log;

@Deprecated
class CommonsLogger extends AbstractInternalLogger {
    private final transient Log logger;
    private static final long serialVersionUID = 0x78034B75B4394B85L;

    public CommonsLogger(Log log0, String s) {
        super(s);
        this.logger = (Log)ObjectUtil.checkNotNull(log0, "logger");
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s) {
        this.logger.debug(s);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Object object0) {
        if(this.logger.isDebugEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0);
            this.logger.debug(formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Object object0, Object object1) {
        if(this.logger.isDebugEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0, object1);
            this.logger.debug(formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Throwable throwable0) {
        this.logger.debug(s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Object[] arr_object) {
        if(this.logger.isDebugEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.arrayFormat(s, arr_object);
            this.logger.debug(formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s) {
        this.logger.error(s);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Object object0) {
        if(this.logger.isErrorEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0);
            this.logger.error(formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Object object0, Object object1) {
        if(this.logger.isErrorEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0, object1);
            this.logger.error(formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Throwable throwable0) {
        this.logger.error(s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Object[] arr_object) {
        if(this.logger.isErrorEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.arrayFormat(s, arr_object);
            this.logger.error(formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s) {
        this.logger.info(s);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Object object0) {
        if(this.logger.isInfoEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0);
            this.logger.info(formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Object object0, Object object1) {
        if(this.logger.isInfoEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0, object1);
            this.logger.info(formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Throwable throwable0) {
        this.logger.info(s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Object[] arr_object) {
        if(this.logger.isInfoEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.arrayFormat(s, arr_object);
            this.logger.info(formattingTuple0.getMessage(), formattingTuple0.getThrowable());
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

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s) {
        this.logger.trace(s);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Object object0) {
        if(this.logger.isTraceEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0);
            this.logger.trace(formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Object object0, Object object1) {
        if(this.logger.isTraceEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0, object1);
            this.logger.trace(formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Throwable throwable0) {
        this.logger.trace(s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Object[] arr_object) {
        if(this.logger.isTraceEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.arrayFormat(s, arr_object);
            this.logger.trace(formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s) {
        this.logger.warn(s);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Object object0) {
        if(this.logger.isWarnEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0);
            this.logger.warn(formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Object object0, Object object1) {
        if(this.logger.isWarnEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0, object1);
            this.logger.warn(formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Throwable throwable0) {
        this.logger.warn(s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Object[] arr_object) {
        if(this.logger.isWarnEnabled()) {
            FormattingTuple formattingTuple0 = MessageFormatter.arrayFormat(s, arr_object);
            this.logger.warn(formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }
}

