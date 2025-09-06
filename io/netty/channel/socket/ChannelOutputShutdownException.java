package io.netty.channel.socket;

import java.io.IOException;

public final class ChannelOutputShutdownException extends IOException {
    private static final long serialVersionUID = 0x5D27C49AB4FA4322L;

    public ChannelOutputShutdownException(String s) {
        super(s);
    }

    public ChannelOutputShutdownException(String s, Throwable throwable0) {
        super(s, throwable0);
    }
}

