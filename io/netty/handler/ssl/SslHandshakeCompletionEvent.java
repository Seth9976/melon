package io.netty.handler.ssl;

public final class SslHandshakeCompletionEvent extends SslCompletionEvent {
    public static final SslHandshakeCompletionEvent SUCCESS;

    static {
        SslHandshakeCompletionEvent.SUCCESS = new SslHandshakeCompletionEvent();
    }

    private SslHandshakeCompletionEvent() {
    }

    public SslHandshakeCompletionEvent(Throwable throwable0) {
        super(throwable0);
    }
}

