package io.netty.channel.socket;

public final class ChannelOutputShutdownEvent {
    public static final ChannelOutputShutdownEvent INSTANCE;

    static {
        ChannelOutputShutdownEvent.INSTANCE = new ChannelOutputShutdownEvent();
    }
}

