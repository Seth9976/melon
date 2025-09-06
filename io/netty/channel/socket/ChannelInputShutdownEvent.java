package io.netty.channel.socket;

public final class ChannelInputShutdownEvent {
    public static final ChannelInputShutdownEvent INSTANCE;

    static {
        ChannelInputShutdownEvent.INSTANCE = new ChannelInputShutdownEvent();
    }
}

