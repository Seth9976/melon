package io.netty.channel;

public class EventLoopException extends ChannelException {
    private static final long serialVersionUID = -8969100344583703616L;

    public EventLoopException() {
    }

    public EventLoopException(String s) {
        super(s);
    }

    public EventLoopException(String s, Throwable throwable0) {
        super(s, throwable0);
    }

    public EventLoopException(Throwable throwable0) {
        super(throwable0);
    }
}

