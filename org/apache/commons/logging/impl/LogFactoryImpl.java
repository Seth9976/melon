package org.apache.commons.logging.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Deprecated
public class LogFactoryImpl extends LogFactory {
    public static final String ALLOW_FLAWED_CONTEXT_PROPERTY = "org.apache.commons.logging.Log.allowFlawedContext";
    public static final String ALLOW_FLAWED_DISCOVERY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedDiscovery";
    public static final String ALLOW_FLAWED_HIERARCHY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedHierarchy";
    public static final String LOG_PROPERTY = "org.apache.commons.logging.Log";
    protected static final String LOG_PROPERTY_OLD = "org.apache.commons.logging.log";
    protected Hashtable attributes;
    protected Hashtable instances;
    protected Constructor logConstructor;
    protected Class[] logConstructorSignature;
    protected Method logMethod;
    protected Class[] logMethodSignature;

    public LogFactoryImpl() {
        this.logConstructorSignature = null;
        this.logMethodSignature = null;
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.LogFactory
    public Object getAttribute(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.LogFactory
    public String[] getAttributeNames() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.LogFactory
    public static ClassLoader getClassLoader(Class class0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.LogFactory
    public static ClassLoader getContextClassLoader() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.LogFactory
    public Log getInstance(Class class0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.LogFactory
    public Log getInstance(String s) {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public String getLogClassName() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public Constructor getLogConstructor() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.LogFactory
    public static boolean isDiagnosticsEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public boolean isJdk13LumberjackAvailable() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public boolean isJdk14Available() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public boolean isLog4JAvailable() {
        throw new RuntimeException("Stub!");
    }

    public void logDiagnostic(String s) {
        throw new RuntimeException("Stub!");
    }

    public Log newInstance(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.LogFactory
    public void release() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.LogFactory
    public void removeAttribute(String s) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.commons.logging.LogFactory
    public void setAttribute(String s, Object object0) {
        throw new RuntimeException("Stub!");
    }
}

