package io.netty.util.internal.logging;

import org.apache.commons.logging.LogFactory;

@Deprecated
public class CommonsLoggerFactory extends InternalLoggerFactory {
    public static final InternalLoggerFactory INSTANCE;

    static {
        CommonsLoggerFactory.INSTANCE = new CommonsLoggerFactory();
    }

    @Override  // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String s) {
        return new CommonsLogger(LogFactory.getLog(s), s);
    }
}

