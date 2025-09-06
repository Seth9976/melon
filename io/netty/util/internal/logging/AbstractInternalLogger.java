package io.netty.util.internal.logging;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.io.Serializable;

public abstract class AbstractInternalLogger implements InternalLogger, Serializable {
    static final String EXCEPTION_MESSAGE = "Unexpected exception:";
    private final String name;
    private static final long serialVersionUID = 0xA76B204E3686F702L;

    public AbstractInternalLogger(String s) {
        this.name = (String)ObjectUtil.checkNotNull(s, "name");
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void debug(Throwable throwable0) {
        this.debug("Unexpected exception:", throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void error(Throwable throwable0) {
        this.error("Unexpected exception:", throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void info(Throwable throwable0) {
        this.info("Unexpected exception:", throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public boolean isEnabled(InternalLogLevel internalLogLevel0) {
        switch(io.netty.util.internal.logging.AbstractInternalLogger.1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel0.ordinal()]) {
            case 1: {
                return this.isTraceEnabled();
            }
            case 2: {
                return this.isDebugEnabled();
            }
            case 3: {
                return this.isInfoEnabled();
            }
            case 4: {
                return this.isWarnEnabled();
            }
            case 5: {
                return this.isErrorEnabled();
            }
            default: {
                throw new Error();
            }
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel0, String s) {
        switch(io.netty.util.internal.logging.AbstractInternalLogger.1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel0.ordinal()]) {
            case 1: {
                this.trace(s);
                return;
            }
            case 2: {
                this.debug(s);
                return;
            }
            case 3: {
                this.info(s);
                return;
            }
            case 4: {
                this.warn(s);
                return;
            }
            case 5: {
                this.error(s);
                return;
            }
            default: {
                throw new Error();
            }
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel0, String s, Object object0) {
        switch(io.netty.util.internal.logging.AbstractInternalLogger.1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel0.ordinal()]) {
            case 1: {
                this.trace(s, object0);
                return;
            }
            case 2: {
                this.debug(s, object0);
                return;
            }
            case 3: {
                this.info(s, object0);
                return;
            }
            case 4: {
                this.warn(s, object0);
                return;
            }
            case 5: {
                this.error(s, object0);
                return;
            }
            default: {
                throw new Error();
            }
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel0, String s, Object object0, Object object1) {
        switch(io.netty.util.internal.logging.AbstractInternalLogger.1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel0.ordinal()]) {
            case 1: {
                this.trace(s, object0, object1);
                return;
            }
            case 2: {
                this.debug(s, object0, object1);
                return;
            }
            case 3: {
                this.info(s, object0, object1);
                return;
            }
            case 4: {
                this.warn(s, object0, object1);
                return;
            }
            case 5: {
                this.error(s, object0, object1);
                return;
            }
            default: {
                throw new Error();
            }
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel0, String s, Throwable throwable0) {
        switch(io.netty.util.internal.logging.AbstractInternalLogger.1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel0.ordinal()]) {
            case 1: {
                this.trace(s, throwable0);
                return;
            }
            case 2: {
                this.debug(s, throwable0);
                return;
            }
            case 3: {
                this.info(s, throwable0);
                return;
            }
            case 4: {
                this.warn(s, throwable0);
                return;
            }
            case 5: {
                this.error(s, throwable0);
                return;
            }
            default: {
                throw new Error();
            }
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel0, String s, Object[] arr_object) {
        switch(io.netty.util.internal.logging.AbstractInternalLogger.1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel0.ordinal()]) {
            case 1: {
                this.trace(s, arr_object);
                return;
            }
            case 2: {
                this.debug(s, arr_object);
                return;
            }
            case 3: {
                this.info(s, arr_object);
                return;
            }
            case 4: {
                this.warn(s, arr_object);
                return;
            }
            case 5: {
                this.error(s, arr_object);
                return;
            }
            default: {
                throw new Error();
            }
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void log(InternalLogLevel internalLogLevel0, Throwable throwable0) {
        switch(io.netty.util.internal.logging.AbstractInternalLogger.1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[internalLogLevel0.ordinal()]) {
            case 1: {
                this.trace(throwable0);
                return;
            }
            case 2: {
                this.debug(throwable0);
                return;
            }
            case 3: {
                this.info(throwable0);
                return;
            }
            case 4: {
                this.warn(throwable0);
                return;
            }
            case 5: {
                this.error(throwable0);
                return;
            }
            default: {
                throw new Error();
            }
        }
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public String name() {
        return this.name;
    }

    public Object readResolve() {
        return InternalLoggerFactory.getInstance(this.name());
    }

    @Override
    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + this.name() + ')';
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void trace(Throwable throwable0) {
        this.trace("Unexpected exception:", throwable0);
    }

    @Override  // io.netty.util.internal.logging.InternalLogger
    public void warn(Throwable throwable0) {
        this.warn("Unexpected exception:", throwable0);
    }

    class io.netty.util.internal.logging.AbstractInternalLogger.1 {
        static final int[] $SwitchMap$io$netty$util$internal$logging$InternalLogLevel;

        static {
            int[] arr_v = new int[InternalLogLevel.values().length];
            io.netty.util.internal.logging.AbstractInternalLogger.1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel = arr_v;
            try {
                arr_v[InternalLogLevel.TRACE.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.util.internal.logging.AbstractInternalLogger.1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[InternalLogLevel.DEBUG.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.util.internal.logging.AbstractInternalLogger.1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[InternalLogLevel.INFO.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.util.internal.logging.AbstractInternalLogger.1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[InternalLogLevel.WARN.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                io.netty.util.internal.logging.AbstractInternalLogger.1.$SwitchMap$io$netty$util$internal$logging$InternalLogLevel[InternalLogLevel.ERROR.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

