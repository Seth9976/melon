package io.netty.channel;

import io.netty.util.internal.ObjectUtil;

public class FixedRecvByteBufAllocator extends DefaultMaxMessagesRecvByteBufAllocator {
    final class HandleImpl extends MaxMessageHandle {
        private final int bufferSize;

        public HandleImpl(int v) {
            this.bufferSize = v;
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public int guess() {
            return this.bufferSize;
        }
    }

    private final int bufferSize;

    public FixedRecvByteBufAllocator(int v) {
        ObjectUtil.checkPositive(v, "bufferSize");
        this.bufferSize = v;
    }

    @Override  // io.netty.channel.RecvByteBufAllocator
    public Handle newHandle() {
        return new HandleImpl(this, this.bufferSize);
    }

    @Override  // io.netty.channel.DefaultMaxMessagesRecvByteBufAllocator
    public DefaultMaxMessagesRecvByteBufAllocator respectMaybeMoreData(boolean z) {
        return this.respectMaybeMoreData(z);
    }

    public FixedRecvByteBufAllocator respectMaybeMoreData(boolean z) {
        super.respectMaybeMoreData(z);
        return this;
    }
}

