package com.digicap.melon.exception;

public class DrmException extends Exception {
    private static final long serialVersionUID = 0xAFEABB151E44F7E2L;

    public DrmException() {
    }

    public DrmException(String s) {
        super(s);
    }

    public DrmException(String s, Throwable throwable0) {
        super(s, throwable0);
    }

    public DrmException(Throwable throwable0) {
        super(throwable0);
    }
}

