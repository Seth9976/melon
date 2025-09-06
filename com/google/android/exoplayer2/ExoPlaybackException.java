package com.google.android.exoplayer2;

import android.os.SystemClock;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ExoPlaybackException extends Exception {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    public static final int TYPE_OUT_OF_MEMORY = 4;
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    private final Throwable cause;
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    public final long timestampMs;
    public final int type;

    private ExoPlaybackException(int v, String s) {
        super(s);
        this.type = v;
        this.rendererIndex = -1;
        this.rendererFormat = null;
        this.rendererFormatSupport = 0;
        this.cause = null;
        this.timestampMs = SystemClock.elapsedRealtime();
    }

    private ExoPlaybackException(int v, Throwable throwable0) {
        this(v, throwable0, -1, null, 4);
    }

    private ExoPlaybackException(int v, Throwable throwable0, int v1, Format format0, int v2) {
        super(throwable0);
        this.type = v;
        this.cause = throwable0;
        this.rendererIndex = v1;
        this.rendererFormat = format0;
        this.rendererFormatSupport = v2;
        this.timestampMs = SystemClock.elapsedRealtime();
    }

    public static ExoPlaybackException createForOutOfMemoryError(OutOfMemoryError outOfMemoryError0) {
        return new ExoPlaybackException(4, outOfMemoryError0);
    }

    public static ExoPlaybackException createForRemote(String s) {
        return new ExoPlaybackException(3, s);
    }

    public static ExoPlaybackException createForRenderer(Exception exception0, int v, Format format0, int v1) {
        if(format0 == null) {
            v1 = 4;
        }
        return new ExoPlaybackException(1, exception0, v, format0, v1);
    }

    public static ExoPlaybackException createForSource(IOException iOException0) {
        return new ExoPlaybackException(0, iOException0);
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException0) {
        return new ExoPlaybackException(2, runtimeException0);
    }

    public OutOfMemoryError getOutOfMemoryError() {
        Assertions.checkState(this.type == 4);
        return (OutOfMemoryError)Assertions.checkNotNull(this.cause);
    }

    public Exception getRendererException() {
        Assertions.checkState(this.type == 1);
        return (Exception)Assertions.checkNotNull(this.cause);
    }

    public IOException getSourceException() {
        Assertions.checkState(this.type == 0);
        return (IOException)Assertions.checkNotNull(this.cause);
    }

    public RuntimeException getUnexpectedException() {
        Assertions.checkState(this.type == 2);
        return (RuntimeException)Assertions.checkNotNull(this.cause);
    }
}

