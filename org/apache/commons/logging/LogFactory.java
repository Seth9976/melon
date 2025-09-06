package org.apache.commons.logging;

import java.util.Hashtable;

@Deprecated
public abstract class LogFactory {
    public static final String DIAGNOSTICS_DEST_PROPERTY = "org.apache.commons.logging.diagnostics.dest";
    public static final String FACTORY_DEFAULT = "org.apache.commons.logging.impl.LogFactoryImpl";
    public static final String FACTORY_PROPERTIES = "commons-logging.properties";
    public static final String FACTORY_PROPERTY = "org.apache.commons.logging.LogFactory";
    public static final String HASHTABLE_IMPLEMENTATION_PROPERTY = "org.apache.commons.logging.LogFactory.HashtableImpl";
    public static final String PRIORITY_KEY = "priority";
    protected static final String SERVICE_ID = "META-INF/services/org.apache.commons.logging.LogFactory";
    public static final String TCCL_KEY = "use_tccl";
    protected static Hashtable factories;
    protected static LogFactory nullClassLoaderFactory;

    public LogFactory() {
        throw new RuntimeException("Stub!");
    }

    public static Object createFactory(String s, ClassLoader classLoader0) {
        throw new RuntimeException("Stub!");
    }

    public static ClassLoader directGetContextClassLoader() {
        throw new RuntimeException("Stub!");
    }

    public abstract Object getAttribute(String arg1);

    public abstract String[] getAttributeNames();

    public static ClassLoader getClassLoader(Class class0) {
        throw new RuntimeException("Stub!");
    }

    public static ClassLoader getContextClassLoader() {
        throw new RuntimeException("Stub!");
    }

    public static LogFactory getFactory() {
        throw new RuntimeException("Stub!");
    }

    public abstract Log getInstance(Class arg1);

    public abstract Log getInstance(String arg1);

    public static Log getLog(Class class0) {
        throw new RuntimeException("Stub!");
    }

    public static Log getLog(String s) {
        throw new RuntimeException("Stub!");
    }

    public static boolean isDiagnosticsEnabled() {
        throw new RuntimeException("Stub!");
    }

    public static final void logRawDiagnostic(String s) {
        throw new RuntimeException("Stub!");
    }

    public static LogFactory newFactory(String s, ClassLoader classLoader0) {
        throw new RuntimeException("Stub!");
    }

    public static LogFactory newFactory(String s, ClassLoader classLoader0, ClassLoader classLoader1) {
        throw new RuntimeException("Stub!");
    }

    public static String objectId(Object object0) {
        throw new RuntimeException("Stub!");
    }

    public static void release(ClassLoader classLoader0) {
        throw new RuntimeException("Stub!");
    }

    public abstract void release();

    public static void releaseAll() {
        throw new RuntimeException("Stub!");
    }

    public abstract void removeAttribute(String arg1);

    public abstract void setAttribute(String arg1, Object arg2);
}

