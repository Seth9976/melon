package io.netty.handler.ssl;

import javax.net.ssl.SSLException;

public class NotSslRecordException extends SSLException {
    private static final long serialVersionUID = 0xC417B36D898F41B7L;

    public NotSslRecordException() {
        super("");
    }

    public NotSslRecordException(String s) {
        super(s);
    }

    public NotSslRecordException(String s, Throwable throwable0) {
        super(s, throwable0);
    }

    public NotSslRecordException(Throwable throwable0) {
        super(throwable0);
    }
}

