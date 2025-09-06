package io.netty.channel;

public final class ServerChannelRecvByteBufAllocator extends DefaultMaxMessagesRecvByteBufAllocator {
    public ServerChannelRecvByteBufAllocator() {
        super(1, true);
    }

    @Override  // io.netty.channel.RecvByteBufAllocator
    public Handle newHandle() {
        return new MaxMessageHandle() {
            @Override  // io.netty.channel.RecvByteBufAllocator$Handle
            public int guess() {
                return 0x80;
            }
        };
    }
}

