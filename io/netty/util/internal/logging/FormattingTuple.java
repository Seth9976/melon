package io.netty.util.internal.logging;

public final class FormattingTuple {
    private final String message;
    private final Throwable throwable;

    public FormattingTuple(String s, Throwable throwable0) {
        this.message = s;
        this.throwable = throwable0;
    }

    public String getMessage() {
        return this.message;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }
}

