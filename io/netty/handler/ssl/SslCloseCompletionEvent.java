package io.netty.handler.ssl;

public final class SslCloseCompletionEvent extends SslCompletionEvent {
    public static final SslCloseCompletionEvent SUCCESS;

    static {
        SslCloseCompletionEvent.SUCCESS = new SslCloseCompletionEvent();
    }

    private SslCloseCompletionEvent() {
    }

    public SslCloseCompletionEvent(Throwable throwable0) {
        super(throwable0);
    }
}

