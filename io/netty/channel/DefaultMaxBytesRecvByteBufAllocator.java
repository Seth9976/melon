package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.ObjectUtil;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class DefaultMaxBytesRecvByteBufAllocator implements MaxBytesRecvByteBufAllocator {
    final class HandleImpl implements ExtendedHandle {
        private int attemptBytesRead;
        private int bytesToRead;
        private final UncheckedBooleanSupplier defaultMaybeMoreSupplier;
        private int individualReadMax;
        private int lastBytesRead;

        private HandleImpl() {
            this.defaultMaybeMoreSupplier = new UncheckedBooleanSupplier() {
                @Override  // io.netty.util.UncheckedBooleanSupplier
                public boolean get() {
                    return HandleImpl.this.attemptBytesRead == HandleImpl.this.lastBytesRead;
                }
            };
        }

        public HandleImpl(io.netty.channel.DefaultMaxBytesRecvByteBufAllocator.1 defaultMaxBytesRecvByteBufAllocator$10) {
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public ByteBuf allocate(ByteBufAllocator byteBufAllocator0) {
            return byteBufAllocator0.ioBuffer(this.guess());
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public int attemptedBytesRead() {
            return this.attemptBytesRead;
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public void attemptedBytesRead(int v) {
            this.attemptBytesRead = v;
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public boolean continueReading() {
            return this.continueReading(this.defaultMaybeMoreSupplier);
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$ExtendedHandle
        public boolean continueReading(UncheckedBooleanSupplier uncheckedBooleanSupplier0) {
            return this.bytesToRead > 0 && uncheckedBooleanSupplier0.get();
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public int guess() {
            return Math.min(this.individualReadMax, this.bytesToRead);
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public void incMessagesRead(int v) {
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public int lastBytesRead() {
            return this.lastBytesRead;
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public void lastBytesRead(int v) {
            this.lastBytesRead = v;
            this.bytesToRead -= v;
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public void readComplete() {
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public void reset(ChannelConfig channelConfig0) {
            this.bytesToRead = DefaultMaxBytesRecvByteBufAllocator.this.maxBytesPerRead();
            this.individualReadMax = DefaultMaxBytesRecvByteBufAllocator.this.maxBytesPerIndividualRead();
        }
    }

    private volatile int maxBytesPerIndividualRead;
    private volatile int maxBytesPerRead;

    public DefaultMaxBytesRecvByteBufAllocator() {
        this(0x10000, 0x10000);
    }

    public DefaultMaxBytesRecvByteBufAllocator(int v, int v1) {
        DefaultMaxBytesRecvByteBufAllocator.checkMaxBytesPerReadPair(v, v1);
        this.maxBytesPerRead = v;
        this.maxBytesPerIndividualRead = v1;
    }

    private static void checkMaxBytesPerReadPair(int v, int v1) {
        ObjectUtil.checkPositive(v, "maxBytesPerRead");
        ObjectUtil.checkPositive(v1, "maxBytesPerIndividualRead");
        if(v < v1) {
            throw new IllegalArgumentException("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (" + v1 + "): " + v);
        }
    }

    @Override  // io.netty.channel.MaxBytesRecvByteBufAllocator
    public int maxBytesPerIndividualRead() {
        return this.maxBytesPerIndividualRead;
    }

    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerIndividualRead(int v) {
        int v2;
        ObjectUtil.checkPositive(v, "maxBytesPerIndividualRead");
        synchronized(this) {
            v2 = this.maxBytesPerRead();
            if(v <= v2) {
                this.maxBytesPerIndividualRead = v;
                return this;
            }
        }
        throw new IllegalArgumentException("maxBytesPerIndividualRead cannot be greater than maxBytesPerRead (" + v2 + "): " + v);
    }

    @Override  // io.netty.channel.MaxBytesRecvByteBufAllocator
    public MaxBytesRecvByteBufAllocator maxBytesPerIndividualRead(int v) {
        return this.maxBytesPerIndividualRead(v);
    }

    @Override  // io.netty.channel.MaxBytesRecvByteBufAllocator
    public int maxBytesPerRead() {
        return this.maxBytesPerRead;
    }

    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerRead(int v) {
        int v2;
        ObjectUtil.checkPositive(v, "maxBytesPerRead");
        synchronized(this) {
            v2 = this.maxBytesPerIndividualRead();
            if(v >= v2) {
                this.maxBytesPerRead = v;
                return this;
            }
        }
        throw new IllegalArgumentException("maxBytesPerRead cannot be less than maxBytesPerIndividualRead (" + v2 + "): " + v);
    }

    @Override  // io.netty.channel.MaxBytesRecvByteBufAllocator
    public MaxBytesRecvByteBufAllocator maxBytesPerRead(int v) {
        return this.maxBytesPerRead(v);
    }

    public DefaultMaxBytesRecvByteBufAllocator maxBytesPerReadPair(int v, int v1) {
        DefaultMaxBytesRecvByteBufAllocator.checkMaxBytesPerReadPair(v, v1);
        synchronized(this) {
            this.maxBytesPerRead = v;
            this.maxBytesPerIndividualRead = v1;
        }
        return this;
    }

    @Override  // io.netty.channel.MaxBytesRecvByteBufAllocator
    public MaxBytesRecvByteBufAllocator maxBytesPerReadPair(int v, int v1) {
        return this.maxBytesPerReadPair(v, v1);
    }

    @Override  // io.netty.channel.MaxBytesRecvByteBufAllocator
    public Map.Entry maxBytesPerReadPair() {
        synchronized(this) {
            return new AbstractMap.SimpleEntry(this.maxBytesPerRead, this.maxBytesPerIndividualRead);
        }
    }

    @Override  // io.netty.channel.RecvByteBufAllocator
    public Handle newHandle() {
        return new HandleImpl(this, null);
    }

    class io.netty.channel.DefaultMaxBytesRecvByteBufAllocator.1 {
    }

}

