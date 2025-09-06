package org.apache.http.protocol;

@Deprecated
public interface HttpContext {
    public static final String RESERVED_PREFIX = "http.";

    Object getAttribute(String arg1);

    Object removeAttribute(String arg1);

    void setAttribute(String arg1, Object arg2);
}

