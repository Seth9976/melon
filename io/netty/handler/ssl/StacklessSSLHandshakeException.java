package io.netty.handler.ssl;

import io.netty.util.internal.ThrowableUtil;
import javax.net.ssl.SSLHandshakeException;

final class StacklessSSLHandshakeException extends SSLHandshakeException {
    private static final long serialVersionUID = 0xEEB9A569E24C89C3L;

    private StacklessSSLHandshakeException(String s) {
        super(s);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public static StacklessSSLHandshakeException newInstance(String s, Class class0, String s1) {
        return (StacklessSSLHandshakeException)ThrowableUtil.unknownStackTrace(new StacklessSSLHandshakeException(s), class0, s1);
    }
}

