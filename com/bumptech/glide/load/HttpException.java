package com.bumptech.glide.load;

import java.io.IOException;

public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1L;
    private final int statusCode;

    public HttpException(int v) {
        this("Http request failed", v);
    }

    @Deprecated
    public HttpException(String s) {
        this(s, -1);
    }

    public HttpException(String s, int v) {
        this(s, v, null);
    }

    public HttpException(String s, int v, Throwable throwable0) {
        super(s + ", status code: " + v, throwable0);
        this.statusCode = v;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}

