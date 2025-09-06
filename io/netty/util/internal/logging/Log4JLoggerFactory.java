package io.netty.util.internal.logging;

import org.apache.log4j.Logger;

public class Log4JLoggerFactory extends InternalLoggerFactory {
    public static final InternalLoggerFactory INSTANCE;

    static {
        Log4JLoggerFactory.INSTANCE = new Log4JLoggerFactory();
    }

    @Override  // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String s) {
        return new Log4JLogger(Logger.getLogger(s));
    }
}

