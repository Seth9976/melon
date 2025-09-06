package io.netty.channel.nio;

import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.ServerChannel;
import java.io.IOException;
import java.net.PortUnreachableException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNioMessageChannel extends AbstractNioChannel {
    final class NioMessageUnsafe extends AbstractNioUnsafe {
        static final boolean $assertionsDisabled;
        private final List readBuf;

        private NioMessageUnsafe() {
            this.readBuf = new ArrayList();
        }

        public NioMessageUnsafe(io.netty.channel.nio.AbstractNioMessageChannel.1 abstractNioMessageChannel$10) {
        }

        @Override  // io.netty.channel.nio.AbstractNioChannel$NioUnsafe
        public void read() {
            Throwable throwable1;
            boolean z = false;
            ChannelConfig channelConfig0 = AbstractNioMessageChannel.this.config();
            ChannelPipeline channelPipeline0 = AbstractNioMessageChannel.this.pipeline();
            Handle recvByteBufAllocator$Handle0 = AbstractNioMessageChannel.this.unsafe().recvBufAllocHandle();
            recvByteBufAllocator$Handle0.reset(channelConfig0);
            try {
                do {
                    int v = AbstractNioMessageChannel.this.doReadMessages(this.readBuf);
                    if(v == 0) {
                        break;
                    }
                    if(v < 0) {
                        goto label_11;
                    }
                    recvByteBufAllocator$Handle0.incMessagesRead(v);
                }
                while(AbstractNioMessageChannel.this.continueReading(recvByteBufAllocator$Handle0));
                goto label_16;
            label_11:
                z = true;
            }
            catch(Throwable throwable0) {
                throwable1 = throwable0;
                goto label_17;
            }
        label_16:
            throwable1 = null;
        label_17:
            try {
                int v2 = this.readBuf.size();
                for(int v3 = 0; v3 < v2; ++v3) {
                    AbstractNioMessageChannel.this.readPending = false;
                    channelPipeline0.fireChannelRead(this.readBuf.get(v3));
                }
                this.readBuf.clear();
                recvByteBufAllocator$Handle0.readComplete();
                channelPipeline0.fireChannelReadComplete();
                if(throwable1 != null) {
                    z = AbstractNioMessageChannel.this.closeOnReadError(throwable1);
                    channelPipeline0.fireExceptionCaught(throwable1);
                }
                if(z) {
                    AbstractNioMessageChannel.this.inputShutdown = true;
                    if(AbstractNioMessageChannel.this.isOpen()) {
                        this.close(this.voidPromise());
                    }
                }
            }
            finally {
                if(!AbstractNioMessageChannel.this.readPending && !channelConfig0.isAutoRead()) {
                    this.removeReadOp();
                }
            }
        }
    }

    boolean inputShutdown;

    public AbstractNioMessageChannel(Channel channel0, SelectableChannel selectableChannel0, int v) {
        super(channel0, selectableChannel0, v);
    }

    public boolean closeOnReadError(Throwable throwable0) {
        if(!this.isActive()) {
            return true;
        }
        if(throwable0 instanceof PortUnreachableException) {
            return false;
        }
        return throwable0 instanceof IOException ? !(this instanceof ServerChannel) : true;
    }

    public boolean continueOnWriteError() {
        return false;
    }

    public boolean continueReading(Handle recvByteBufAllocator$Handle0) {
        return recvByteBufAllocator$Handle0.continueReading();
    }

    @Override  // io.netty.channel.nio.AbstractNioChannel
    public void doBeginRead() {
        if(this.inputShutdown) {
            return;
        }
        super.doBeginRead();
    }

    public abstract int doReadMessages(List arg1);

    @Override  // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer0) {
        int v2;
        SelectionKey selectionKey0 = this.selectionKey();
        int v = selectionKey0.interestOps();
        int v1 = this.maxMessagesPerWrite();
        while(v1 > 0) {
            Object object0 = channelOutboundBuffer0.current();
            if(object0 == null) {
                break;
            }
            try {
                v2 = this.config().getWriteSpinCount() - 1;
            label_7:
                if(v2 < 0) {
                    break;
                }
                if(!this.doWriteMessage(object0, channelOutboundBuffer0)) {
                    --v2;
                    goto label_7;
                }
                --v1;
                channelOutboundBuffer0.remove();
            }
            catch(Exception exception0) {
                if(!this.continueOnWriteError()) {
                    throw exception0;
                }
                --v1;
                channelOutboundBuffer0.remove(exception0);
            }
        }
        if(channelOutboundBuffer0.isEmpty()) {
            if((v & 4) != 0) {
                selectionKey0.interestOps(v & -5);
            }
        }
        else if((v & 4) == 0) {
            selectionKey0.interestOps(v | 4);
        }
    }

    public abstract boolean doWriteMessage(Object arg1, ChannelOutboundBuffer arg2);

    @Override  // io.netty.channel.AbstractChannel
    public AbstractUnsafe newUnsafe() {
        return this.newUnsafe();
    }

    public AbstractNioUnsafe newUnsafe() {
        return new NioMessageUnsafe(this, null);
    }

    class io.netty.channel.nio.AbstractNioMessageChannel.1 {
    }

}

