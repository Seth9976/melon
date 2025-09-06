package io.netty.util.internal.logging;

import org.apache.logging.log4j.LogManager;

public final class Log4J2LoggerFactory extends InternalLoggerFactory {
    public static final InternalLoggerFactory INSTANCE;

    static {
        Log4J2LoggerFactory.INSTANCE = new Log4J2LoggerFactory();
    }

    @Override  // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String s) {
        return new Log4J2Logger(LogManager.getLogger(s));
    }
}

