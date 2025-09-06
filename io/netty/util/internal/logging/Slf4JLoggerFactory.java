package io.netty.util.internal.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

public class Slf4JLoggerFactory extends InternalLoggerFactory {
    static final class NopInstanceHolder {
        private static final InternalLoggerFactory INSTANCE_WITH_NOP_CHECK;

        static {
            NopInstanceHolder.INSTANCE_WITH_NOP_CHECK = new Slf4JLoggerFactory(true);
        }

        public static InternalLoggerFactory access$000() {
            return NopInstanceHolder.INSTANCE_WITH_NOP_CHECK;
        }
    }

    static final boolean $assertionsDisabled;
    public static final InternalLoggerFactory INSTANCE;

    static {
        Slf4JLoggerFactory.INSTANCE = new Slf4JLoggerFactory();
    }

    @Deprecated
    public Slf4JLoggerFactory() {
    }

    public Slf4JLoggerFactory(boolean z) {
        if(LoggerFactory.getILoggerFactory() instanceof NOPLoggerFactory) {
            throw new NoClassDefFoundError("NOPLoggerFactory not supported");
        }
    }

    public static InternalLoggerFactory getInstanceWithNopCheck() {
        return NopInstanceHolder.access$000();
    }

    @Override  // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String s) {
        return Slf4JLoggerFactory.wrapLogger(LoggerFactory.getLogger(s));
    }

    public static InternalLogger wrapLogger(Logger logger0) {
        return logger0 instanceof LocationAwareLogger ? new LocationAwareSlf4JLogger(((LocationAwareLogger)logger0)) : new Slf4JLogger(logger0);
    }
}

