package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.UncheckedBooleanSupplier;
import io.netty.util.internal.ObjectUtil;

public interface RecvByteBufAllocator {
    public static class DelegatingHandle implements Handle {
        private final Handle delegate;

        public DelegatingHandle(Handle recvByteBufAllocator$Handle0) {
            this.delegate = (Handle)ObjectUtil.checkNotNull(recvByteBufAllocator$Handle0, "delegate");
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public ByteBuf allocate(ByteBufAllocator byteBufAllocator0) {
            return this.delegate.allocate(byteBufAllocator0);
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public int attemptedBytesRead() {
            return this.delegate.attemptedBytesRead();
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public void attemptedBytesRead(int v) {
            this.delegate.attemptedBytesRead(v);
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public boolean continueReading() {
            return this.delegate.continueReading();
        }

        public final Handle delegate() {
            return this.delegate;
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public int guess() {
            return this.delegate.guess();
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public void incMessagesRead(int v) {
            this.delegate.incMessagesRead(v);
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public int lastBytesRead() {
            return this.delegate.lastBytesRead();
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public void lastBytesRead(int v) {
            this.delegate.lastBytesRead(v);
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public void readComplete() {
            this.delegate.readComplete();
        }

        @Override  // io.netty.channel.RecvByteBufAllocator$Handle
        public void reset(ChannelConfig channelConfig0) {
            this.delegate.reset(channelConfig0);
        }
    }

    public interface ExtendedHandle extends Handle {
        boolean continueReading(UncheckedBooleanSupplier arg1);
    }

    @Deprecated
    public interface Handle {
        ByteBuf allocate(ByteBufAllocator arg1);

        int attemptedBytesRead();

        void attemptedBytesRead(int arg1);

        boolean continueReading();

        int guess();

        void incMessagesRead(int arg1);

        int lastBytesRead();

        void lastBytesRead(int arg1);

        void readComplete();

        void reset(ChannelConfig arg1);
    }

    Handle newHandle();
}

