package io.netty.util.internal.logging;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

class JdkLogger extends AbstractInternalLogger {
    static final String SELF = "io.netty.util.internal.logging.JdkLogger";
    static final String SUPER = null;
    final transient Logger logger;
    private static final long serialVersionUID = 0xE77962F427A9D205L;

    static {
        JdkLogger.SUPER = "io.netty.util.internal.logging.AbstractInternalLogger";
    }

    public JdkLogger(Logger logger0) {
        super(logger0.getName());
        this.logger = logger0;
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s) {
        Level level0 = Level.FINE;
        if(this.logger.isLoggable(level0)) {
            this.log("io.netty.util.internal.logging.JdkLogger", level0, s, null);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Object object0) {
        Level level0 = Level.FINE;
        if(this.logger.isLoggable(level0)) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0);
            this.log("io.netty.util.internal.logging.JdkLogger", level0, formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Object object0, Object object1) {
        Level level0 = Level.FINE;
        if(this.logger.isLoggable(level0)) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0, object1);
            this.log("io.netty.util.internal.logging.JdkLogger", level0, formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Throwable throwable0) {
        Level level0 = Level.FINE;
        if(this.logger.isLoggable(level0)) {
            this.log("io.netty.util.internal.logging.JdkLogger", level0, s, throwable0);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(String s, Object[] arr_object) {
        Level level0 = Level.FINE;
        if(this.logger.isLoggable(level0)) {
            FormattingTuple formattingTuple0 = MessageFormatter.arrayFormat(s, arr_object);
            this.log("io.netty.util.internal.logging.JdkLogger", level0, formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s) {
        Level level0 = Level.SEVERE;
        if(this.logger.isLoggable(level0)) {
            this.log("io.netty.util.internal.logging.JdkLogger", level0, s, null);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Object object0) {
        Level level0 = Level.SEVERE;
        if(this.logger.isLoggable(level0)) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0);
            this.log("io.netty.util.internal.logging.JdkLogger", level0, formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Object object0, Object object1) {
        Level level0 = Level.SEVERE;
        if(this.logger.isLoggable(level0)) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0, object1);
            this.log("io.netty.util.internal.logging.JdkLogger", level0, formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Throwable throwable0) {
        Level level0 = Level.SEVERE;
        if(this.logger.isLoggable(level0)) {
            this.log("io.netty.util.internal.logging.JdkLogger", level0, s, throwable0);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(String s, Object[] arr_object) {
        Level level0 = Level.SEVERE;
        if(this.logger.isLoggable(level0)) {
            FormattingTuple formattingTuple0 = MessageFormatter.arrayFormat(s, arr_object);
            this.log("io.netty.util.internal.logging.JdkLogger", level0, formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    private static void fillCallerData(String s, LogRecord logRecord0) {
        StackTraceElement[] arr_stackTraceElement = new Throwable().getStackTrace();
        int v;
        for(v = 0; true; ++v) {
            if(v >= arr_stackTraceElement.length) {
                v = -1;
                break;
            }
            String s1 = arr_stackTraceElement[v].getClassName();
            if(s1.equals(s) || s1.equals("io.netty.util.internal.logging.AbstractInternalLogger")) {
                break;
            }
        }
        do {
            ++v;
            if(v >= arr_stackTraceElement.length) {
                goto label_14;
            }
            String s2 = arr_stackTraceElement[v].getClassName();
        }
        while(s2.equals(s) || s2.equals("io.netty.util.internal.logging.AbstractInternalLogger"));
        goto label_15;
    label_14:
        v = -1;
    label_15:
        if(v != -1) {
            StackTraceElement stackTraceElement0 = arr_stackTraceElement[v];
            logRecord0.setSourceClassName(stackTraceElement0.getClassName());
            logRecord0.setSourceMethodName(stackTraceElement0.getMethodName());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s) {
        Level level0 = Level.INFO;
        if(this.logger.isLoggable(level0)) {
            this.log("io.netty.util.internal.logging.JdkLogger", level0, s, null);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Object object0) {
        Level level0 = Level.INFO;
        if(this.logger.isLoggable(level0)) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0);
            this.log("io.netty.util.internal.logging.JdkLogger", level0, formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Object object0, Object object1) {
        Level level0 = Level.INFO;
        if(this.logger.isLoggable(level0)) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0, object1);
            this.log("io.netty.util.internal.logging.JdkLogger", level0, formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Throwable throwable0) {
        Level level0 = Level.INFO;
        if(this.logger.isLoggable(level0)) {
            this.log("io.netty.util.internal.logging.JdkLogger", level0, s, throwable0);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(String s, Object[] arr_object) {
        Level level0 = Level.INFO;
        if(this.logger.isLoggable(level0)) {
            FormattingTuple formattingTuple0 = MessageFormatter.arrayFormat(s, arr_object);
            this.log("io.netty.util.internal.logging.JdkLogger", level0, formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isDebugEnabled() {
        return this.logger.isLoggable(Level.FINE);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isErrorEnabled() {
        return this.logger.isLoggable(Level.SEVERE);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isInfoEnabled() {
        return this.logger.isLoggable(Level.INFO);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isTraceEnabled() {
        return this.logger.isLoggable(Level.FINEST);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isWarnEnabled() {
        return this.logger.isLoggable(Level.WARNING);
    }

    private void log(String s, Level level0, String s1, Throwable throwable0) {
        LogRecord logRecord0 = new LogRecord(level0, s1);
        logRecord0.setLoggerName(this.name());
        logRecord0.setThrown(throwable0);
        JdkLogger.fillCallerData(s, logRecord0);
        this.logger.log(logRecord0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s) {
        Level level0 = Level.FINEST;
        if(this.logger.isLoggable(level0)) {
            this.log("io.netty.util.internal.logging.JdkLogger", level0, s, null);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Object object0) {
        Level level0 = Level.FINEST;
        if(this.logger.isLoggable(level0)) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0);
            this.log("io.netty.util.internal.logging.JdkLogger", level0, formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Object object0, Object object1) {
        Level level0 = Level.FINEST;
        if(this.logger.isLoggable(level0)) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0, object1);
            this.log("io.netty.util.internal.logging.JdkLogger", level0, formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Throwable throwable0) {
        Level level0 = Level.FINEST;
        if(this.logger.isLoggable(level0)) {
            this.log("io.netty.util.internal.logging.JdkLogger", level0, s, throwable0);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(String s, Object[] arr_object) {
        Level level0 = Level.FINEST;
        if(this.logger.isLoggable(level0)) {
            FormattingTuple formattingTuple0 = MessageFormatter.arrayFormat(s, arr_object);
            this.log("io.netty.util.internal.logging.JdkLogger", level0, formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s) {
        Level level0 = Level.WARNING;
        if(this.logger.isLoggable(level0)) {
            this.log("io.netty.util.internal.logging.JdkLogger", level0, s, null);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Object object0) {
        Level level0 = Level.WARNING;
        if(this.logger.isLoggable(level0)) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0);
            this.log("io.netty.util.internal.logging.JdkLogger", level0, formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Object object0, Object object1) {
        Level level0 = Level.WARNING;
        if(this.logger.isLoggable(level0)) {
            FormattingTuple formattingTuple0 = MessageFormatter.format(s, object0, object1);
            this.log("io.netty.util.internal.logging.JdkLogger", level0, formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Throwable throwable0) {
        Level level0 = Level.WARNING;
        if(this.logger.isLoggable(level0)) {
            this.log("io.netty.util.internal.logging.JdkLogger", level0, s, throwable0);
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(String s, Object[] arr_object) {
        Level level0 = Level.WARNING;
        if(this.logger.isLoggable(level0)) {
            FormattingTuple formattingTuple0 = MessageFormatter.arrayFormat(s, arr_object);
            this.log("io.netty.util.internal.logging.JdkLogger", level0, formattingTuple0.getMessage(), formattingTuple0.getThrowable());
        }
    }
}

