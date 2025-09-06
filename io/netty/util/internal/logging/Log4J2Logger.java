package io.netty.util.internal.logging;

import java.security.AccessController;
import java.security.PrivilegedAction;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;

class Log4J2Logger extends ExtendedLoggerWrapper implements InternalLogger {
    private static final boolean VARARGS_ONLY = false;
    private static final long serialVersionUID = 0x4C201EF797341125L;

    static {
        Log4J2Logger.VARARGS_ONLY = ((Boolean)AccessController.doPrivileged(new PrivilegedAction() {
            public Boolean run() {
                try {
                    Logger.class.getMethod("debug", String.class, Object.class);
                    return false;
                }
                catch(NoSuchMethodException unused_ex) {
                    return true;
                }
                catch(SecurityException unused_ex) {
                    return false;
                }
            }

            @Override
            public Object run() {
                return this.run();
            }
        })).booleanValue();
    }

    public Log4J2Logger(Logger logger0) {
        super(((ExtendedLogger)logger0), logger0.getName(), logger0.getMessageFactory());
        if(Log4J2Logger.VARARGS_ONLY) {
            throw new UnsupportedOperationException("Log4J2 version mismatch");
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(Throwable throwable0) {
        this.log(Level.DEBUG, "Unexpected exception:", throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(Throwable throwable0) {
        this.log(Level.ERROR, "Unexpected exception:", throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(Throwable throwable0) {
        this.log(Level.INFO, "Unexpected exception:", throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isEnabled(InternalLogLevel internalLogLevel0) {
        return this.isEnabled(Log4J2Logger.toLevel(internalLogLevel0));
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel0, String s) {
        this.log(Log4J2Logger.toLevel(internalLogLevel0), s);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel0, String s, Object object0) {
        this.log(Log4J2Logger.toLevel(internalLogLevel0), s, object0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel0, String s, Object object0, Object object1) {
        this.log(Log4J2Logger.toLevel(internalLogLevel0), s, object0, object1);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel0, String s, Throwable throwable0) {
        this.log(Log4J2Logger.toLevel(internalLogLevel0), s, throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel0, String s, Object[] arr_object) {
        this.log(Log4J2Logger.toLevel(internalLogLevel0), s, arr_object);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel0, Throwable throwable0) {
        this.log(Log4J2Logger.toLevel(internalLogLevel0), "Unexpected exception:", throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public String name() {
        return this.getName();
    }

    private static Level toLevel(InternalLogLevel internalLogLevel0) {
        switch(io.netty.util.internal.logging.Log4J2Logger.2.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel0.ordinal()]) {
            case 1: {
                return Level.INFO;
            }
            case 2: {
                return Level.DEBUG;
            }
            case 3: {
                return Level.WARN;
            }
            case 4: {
                return Level.ERROR;
            }
            case 5: {
                return Level.TRACE;
            }
            default: {
                throw new Error();
            }
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(Throwable throwable0) {
        this.log(Level.TRACE, "Unexpected exception:", throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(Throwable throwable0) {
        this.log(Level.WARN, "Unexpected exception:", throwable0);
    }
}

