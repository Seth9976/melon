package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.ObjectUtil;

public abstract class DefaultMaxMessagesRecvByteBufAllocator implements MaxMessagesRecvByteBufAllocator {
    public abstract class MaxMessageHandle implements ExtendedHandle {
        private int attemptedBytesRead;
        private ChannelConfig config;
        private final UncheckedBooleanSupplier defaultMaybeMoreSupplier;
        private int lastBytesRead;
        private int maxMessagePerRead;
        private final boolean respectMaybeMoreData;
        private int totalBytesRead;
        private int totalMessages;

        public MaxMessageHandle() {
            this.respectMaybeMoreData = defaultMaxMessagesRecvByteBufAllocator0.respectMaybeMoreData;
            this.defaultMaybeMoreSupplier = new UncheckedBooleanSupplier() {
                @Override  // io.netty.util.UncheckedBooleanSupplier
                public boolean get() {
                    return MaxMessageHandle.this.attemptedBytesRead == MaxMessageHandle.this.lastBytesRead;
                }
            };
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public ByteBuf allocate(ByteBufAllocator byteBufAllocator0) {
            return byteBufAllocator0.ioBuffer(this.guess());
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public int attemptedBytesRead() {
            return this.attemptedBytesRead;
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public void attemptedBytesRead(int v) {
            this.attemptedBytesRead = v;
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public boolean continueReading() {
            return this.continueReading(this.defaultMaybeMoreSupplier);
        }

        // 去混淆评级： 低(40)
        @Override  // io.netty.channel.RecvByteBufAllocator$ExtendedHandle
        public boolean continueReading(UncheckedBooleanSupplier uncheckedBooleanSupplier0) {
            return this.config.isAutoRead() && (!this.respectMaybeMoreData || uncheckedBooleanSupplier0.get()) && this.totalMessages < this.maxMessagePerRead && (DefaultMaxMessagesRecvByteBufAllocator.this.ignoreBytesRead || this.totalBytesRead > 0);
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public final void incMessagesRead(int v) {
            this.totalMessages += v;
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public final int lastBytesRead() {
            return this.lastBytesRead;
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public void lastBytesRead(int v) {
            this.lastBytesRead = v;
            if(v > 0) {
                this.totalBytesRead += v;
            }
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public void readComplete() {
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public void reset(ChannelConfig channelConfig0) {
            this.config = channelConfig0;
            this.maxMessagePerRead = DefaultMaxMessagesRecvByteBufAllocator.this.maxMessagesPerRead();
            this.totalBytesRead = 0;
            this.totalMessages = 0;
        }

        public final int totalBytesRead() {
            return this.totalBytesRead >= 0 ? this.totalBytesRead : 0x7FFFFFFF;
        }
    }

    private final boolean ignoreBytesRead;
    private volatile int maxMessagesPerRead;
    private volatile boolean respectMaybeMoreData;

    public DefaultMaxMessagesRecvByteBufAllocator() {
        this(1);
    }

    public DefaultMaxMessagesRecvByteBufAllocator(int v) {
        this(v, false);
    }

    public DefaultMaxMessagesRecvByteBufAllocator(int v, boolean z) {
        this.respectMaybeMoreData = true;
        this.ignoreBytesRead = z;
        this.maxMessagesPerRead(v);
    }

    @Override  // io.netty.channel.MaxMessagesRecvByteBufAllocator
    public int maxMessagesPerRead() {
        return this.maxMessagesPerRead;
    }

    @Override  // io.netty.channel.MaxMessagesRecvByteBufAllocator
    public MaxMessagesRecvByteBufAllocator maxMessagesPerRead(int v) {
        ObjectUtil.checkPositive(v, "maxMessagesPerRead");
        this.maxMessagesPerRead = v;
        return this;
    }

    public DefaultMaxMessagesRecvByteBufAllocator respectMaybeMoreData(boolean z) {
        this.respectMaybeMoreData = z;
        return this;
    }

    public final boolean respectMaybeMoreData() {
        return this.respectMaybeMoreData;
    }
}

