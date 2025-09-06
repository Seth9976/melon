package io.netty.util.internal.logging;

import java.util.logging.Logger;

public class JdkLoggerFactory extends InternalLoggerFactory {
    public static final InternalLoggerFactory INSTANCE;

    static {
        JdkLoggerFactory.INSTANCE = new JdkLoggerFactory();
    }

    @Override  // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String s) {
        return new JdkLogger(Logger.getLogger(s));
    }
}

