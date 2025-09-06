package io.netty.handler.timeout;

import io.netty.channel.ChannelException;

public class TimeoutException extends ChannelException {
    private static final long serialVersionUID = 0x40DC1C87CBD5AA55L;

    public TimeoutException() {
    }

    public TimeoutException(String s, boolean z) {
        super(s, null, z);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}

