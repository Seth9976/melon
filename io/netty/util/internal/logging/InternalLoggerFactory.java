package io.netty.util.internal.logging;

import io.netty.util.internal.ObjectUtil;

public abstract class InternalLoggerFactory {
    private static volatile InternalLoggerFactory defaultFactory;

    public static InternalLoggerFactory getDefaultFactory() {
        if(InternalLoggerFactory.defaultFactory == null) {
            InternalLoggerFactory.defaultFactory = InternalLoggerFactory.newDefaultFactory("io.netty.util.internal.logging.InternalLoggerFactory");
        }
        return InternalLoggerFactory.defaultFactory;
    }

    public static InternalLogger getInstance(Class class0) {
        return InternalLoggerFactory.getInstance(class0.getName());
    }

    public static InternalLogger getInstance(String s) {
        return InternalLoggerFactory.getDefaultFactory().newInstance(s);
    }

    private static InternalLoggerFactory newDefaultFactory(String s) {
        InternalLoggerFactory internalLoggerFactory0 = InternalLoggerFactory.useSlf4JLoggerFactory(s);
        if(internalLoggerFactory0 != null) {
            return internalLoggerFactory0;
        }
        InternalLoggerFactory internalLoggerFactory1 = InternalLoggerFactory.useLog4J2LoggerFactory(s);
        if(internalLoggerFactory1 != null) {
            return internalLoggerFactory1;
        }
        InternalLoggerFactory internalLoggerFactory2 = InternalLoggerFactory.useLog4JLoggerFactory(s);
        return internalLoggerFactory2 == null ? InternalLoggerFactory.useJdkLoggerFactory(s) : internalLoggerFactory2;
    }

    public abstract InternalLogger newInstance(String arg1);

    public static void setDefaultFactory(InternalLoggerFactory internalLoggerFactory0) {
        InternalLoggerFactory.defaultFactory = (InternalLoggerFactory)ObjectUtil.checkNotNull(internalLoggerFactory0, "defaultFactory");
    }

    private static InternalLoggerFactory useJdkLoggerFactory(String s) {
        JdkLoggerFactory.INSTANCE.newInstance(s).debug("Using java.util.logging as the default logging framework");
        return JdkLoggerFactory.INSTANCE;
    }

    private static InternalLoggerFactory useLog4J2LoggerFactory(String s) {
        try {
            Log4J2LoggerFactory.INSTANCE.newInstance(s).debug("Using Log4J2 as the default logging framework");
            return Log4J2LoggerFactory.INSTANCE;
        }
        catch(LinkageError | Exception unused_ex) {
            return null;
        }
    }

    private static InternalLoggerFactory useLog4JLoggerFactory(String s) {
        try {
            Log4JLoggerFactory.INSTANCE.newInstance(s).debug("Using Log4J as the default logging framework");
            return Log4JLoggerFactory.INSTANCE;
        }
        catch(LinkageError | Exception unused_ex) {
            return null;
        }
    }

    private static InternalLoggerFactory useSlf4JLoggerFactory(String s) {
        try {
            InternalLoggerFactory internalLoggerFactory0 = Slf4JLoggerFactory.getInstanceWithNopCheck();
            internalLoggerFactory0.newInstance(s).debug("Using SLF4J as the default logging framework");
            return internalLoggerFactory0;
        }
        catch(LinkageError | Exception unused_ex) {
            return null;
        }
    }
}

