package com.google.android.exoplayer2.drm;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class UnsupportedDrmException extends Exception {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Reason {
    }

    public static final int REASON_INSTANTIATION_ERROR = 2;
    public static final int REASON_UNSUPPORTED_SCHEME = 1;
    public final int reason;

    public UnsupportedDrmException(int v) {
        this.reason = v;
    }

    public UnsupportedDrmException(int v, Exception exception0) {
        super(exception0);
        this.reason = v;
    }
}

