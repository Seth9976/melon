package io.netty.handler.ssl;

import U4.x;

public final class SniCompletionEvent extends SslCompletionEvent {
    private final String hostname;

    public SniCompletionEvent(String s) {
        this.hostname = s;
    }

    public SniCompletionEvent(String s, Throwable throwable0) {
        super(throwable0);
        this.hostname = s;
    }

    public SniCompletionEvent(Throwable throwable0) {
        this(null, throwable0);
    }

    public String hostname() {
        return this.hostname;
    }

    @Override  // io.netty.handler.ssl.SslCompletionEvent
    public String toString() {
        Throwable throwable0 = this.cause();
        return throwable0 == null ? x.m(new StringBuilder("SniCompletionEvent(SUCCESS=\'"), this.hostname, "\'\")") : "SniCompletionEvent(" + throwable0 + ')';
    }
}

