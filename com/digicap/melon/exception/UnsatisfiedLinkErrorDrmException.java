package com.digicap.melon.exception;

public class UnsatisfiedLinkErrorDrmException extends DrmException {
    private static final long serialVersionUID = 0xAFEABB151E44F7E2L;

    public UnsatisfiedLinkErrorDrmException() {
    }

    public UnsatisfiedLinkErrorDrmException(String s) {
        super(s);
    }

    public UnsatisfiedLinkErrorDrmException(String s, Throwable throwable0) {
        super(s, throwable0);
    }

    public UnsatisfiedLinkErrorDrmException(Throwable throwable0) {
        super(throwable0);
    }
}

