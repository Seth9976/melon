package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

public abstract class AbstractNioByteChannel extends AbstractNioChannel {
    public class NioByteUnsafe extends AbstractNioUnsafe {
        private void closeOnRead(ChannelPipeline channelPipeline0) {
            if(!AbstractNioByteChannel.this.isInputShutdown0()) {
                if(AbstractNioByteChannel.isAllowHalfClosure(AbstractNioByteChannel.this.config())) {
                    AbstractNioByteChannel.this.shutdownInput();
                    channelPipeline0.fireUserEventTriggered(ChannelInputShutdownEvent.INSTANCE);
                    return;
                }
                this.close(this.voidPromise());
                return;
            }
            if(!AbstractNioByteChannel.this.inputClosedSeenErrorOnRead) {
                AbstractNioByteChannel.this.inputClosedSeenErrorOnRead = true;
                channelPipeline0.fireUserEventTriggered(ChannelInputShutdownReadComplete.INSTANCE);
            }
        }

        private void handleReadException(ChannelPipeline channelPipeline0, ByteBuf byteBuf0, Throwable throwable0, boolean z, Handle recvByteBufAllocator$Handle0) {
            if(byteBuf0 != null) {
                if(byteBuf0.isReadable()) {
                    AbstractNioByteChannel.this.readPending = false;
                    channelPipeline0.fireChannelRead(byteBuf0);
                }
                else {
                    byteBuf0.release();
                }
            }
            recvByteBufAllocator$Handle0.readComplete();
            channelPipeline0.fireChannelReadComplete();
            channelPipeline0.fireExceptionCaught(throwable0);
            if(!z && !(throwable0 instanceof OutOfMemoryError) && !(throwable0 instanceof IOException)) {
                return;
            }
            this.closeOnRead(channelPipeline0);
        }

        @Override  // io.netty.channel.nio.AbstractNioChannel$NioUnsafe
        public final void read() {
            boolean z1;
            ByteBuf byteBuf0;
            boolean z;
            ChannelConfig channelConfig0 = AbstractNioByteChannel.this.config();
            if(AbstractNioByteChannel.this.shouldBreakReadReady(channelConfig0)) {
                AbstractNioByteChannel.this.clearReadPending();
                return;
            }
            ChannelPipeline channelPipeline0 = AbstractNioByteChannel.this.pipeline();
            ByteBufAllocator byteBufAllocator0 = channelConfig0.getAllocator();
            Handle recvByteBufAllocator$Handle0 = this.recvBufAllocHandle();
            recvByteBufAllocator$Handle0.reset(channelConfig0);
            while(true) {
                try {
                label_8:
                    z = false;
                    byteBuf0 = recvByteBufAllocator$Handle0.allocate(byteBufAllocator0);
                }
                catch(Throwable throwable0) {
                    break;
                }
                try {
                    recvByteBufAllocator$Handle0.lastBytesRead(AbstractNioByteChannel.this.doReadBytes(byteBuf0));
                    z1 = true;
                    if(recvByteBufAllocator$Handle0.lastBytesRead() <= 0) {
                        byteBuf0.release();
                        goto label_14;
                    }
                    goto label_20;
                }
                catch(Throwable throwable1) {
                    goto label_25;
                }
                try {
                label_14:
                    if(recvByteBufAllocator$Handle0.lastBytesRead() >= 0) {
                        z1 = false;
                    }
                    else {
                        AbstractNioByteChannel.this.readPending = false;
                    }
                    z = z1;
                    goto label_28;
                }
                catch(Throwable throwable0) {
                    break;
                }
                z1 = false;
                z = z1;
                goto label_28;
                try {
                label_20:
                    recvByteBufAllocator$Handle0.incMessagesRead(1);
                    AbstractNioByteChannel.this.readPending = false;
                    channelPipeline0.fireChannelRead(byteBuf0);
                }
                catch(Throwable throwable1) {
                    try {
                    label_25:
                        this.handleReadException(channelPipeline0, byteBuf0, throwable1, false, recvByteBufAllocator$Handle0);
                        goto label_40;
                    }
                    catch(Throwable throwable2) {
                        goto label_37;
                    }
                }
                try {
                    if(recvByteBufAllocator$Handle0.continueReading()) {
                        goto label_8;
                    }
                label_28:
                    recvByteBufAllocator$Handle0.readComplete();
                    channelPipeline0.fireChannelReadComplete();
                    if(z) {
                        this.closeOnRead(channelPipeline0);
                    }
                    goto label_43;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            try {
                this.handleReadException(channelPipeline0, null, throwable0, z, recvByteBufAllocator$Handle0);
            }
            catch(Throwable throwable2) {
            label_37:
                if(!AbstractNioByteChannel.this.readPending && !channelConfig0.isAutoRead()) {
                    this.removeReadOp();
                }
                throw throwable2;
            }
        label_40:
            if(!AbstractNioByteChannel.this.readPending && !channelConfig0.isAutoRead()) {
                this.removeReadOp();
                return;
            label_43:
                if(!AbstractNioByteChannel.this.readPending && !channelConfig0.isAutoRead()) {
                    this.removeReadOp();
                }
            }
        }
    }

    private static final String EXPECTED_TYPES;
    private static final ChannelMetadata METADATA;
    private final Runnable flushTask;
    private boolean inputClosedSeenErrorOnRead;

    // 去混淆评级： 低(33)
    static {
        AbstractNioByteChannel.METADATA = new ChannelMetadata(false, 16);
        AbstractNioByteChannel.EXPECTED_TYPES = " (expected: ByteBuf, FileRegion" + ')';
    }

    public AbstractNioByteChannel(Channel channel0, SelectableChannel selectableChannel0) {
        super(channel0, selectableChannel0, 1);
        this.flushTask = new Runnable() {
            @Override
            public void run() {
                ((AbstractNioUnsafe)AbstractNioByteChannel.this.unsafe()).flush0();
            }
        };
    }

    public final void clearOpWrite() {
        SelectionKey selectionKey0 = this.selectionKey();
        if(selectionKey0.isValid()) {
            int v = selectionKey0.interestOps();
            if((v & 4) != 0) {
                selectionKey0.interestOps(v & -5);
            }
        }
    }

    public abstract int doReadBytes(ByteBuf arg1);

    @Override  // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer0) {
        int v = this.config().getWriteSpinCount();
        do {
            Object object0 = channelOutboundBuffer0.current();
            if(object0 == null) {
                this.clearOpWrite();
                return;
            }
            v -= this.doWriteInternal(channelOutboundBuffer0, object0);
        }
        while(v > 0);
        this.incompleteWrite(v < 0);
    }

    public final int doWrite0(ChannelOutboundBuffer channelOutboundBuffer0) {
        return channelOutboundBuffer0.current() == null ? 0 : this.doWriteInternal(channelOutboundBuffer0, channelOutboundBuffer0.current());
    }

    public abstract int doWriteBytes(ByteBuf arg1);

    public abstract long doWriteFileRegion(FileRegion arg1);

    private int doWriteInternal(ChannelOutboundBuffer channelOutboundBuffer0, Object object0) {
        if(object0 instanceof ByteBuf) {
            if(!((ByteBuf)object0).isReadable()) {
                channelOutboundBuffer0.remove();
                return 0;
            }
            int v = this.doWriteBytes(((ByteBuf)object0));
            if(v <= 0) {
                return 0x7FFFFFFF;
            }
            channelOutboundBuffer0.progress(((long)v));
            if(!((ByteBuf)object0).isReadable()) {
                channelOutboundBuffer0.remove();
            }
            return 1;
        }
        if(!(object0 instanceof FileRegion)) {
            throw new Error();
        }
        if(((FileRegion)object0).transferred() >= ((FileRegion)object0).count()) {
            channelOutboundBuffer0.remove();
            return 0;
        }
        long v1 = this.doWriteFileRegion(((FileRegion)object0));
        if(v1 > 0L) {
            channelOutboundBuffer0.progress(v1);
            if(((FileRegion)object0).transferred() >= ((FileRegion)object0).count()) {
                channelOutboundBuffer0.remove();
            }
            return 1;
        }
        return 0x7FFFFFFF;
    }

    @Override  // io.netty.channel.AbstractChannel
    public final Object filterOutboundMessage(Object object0) {
        if(object0 instanceof ByteBuf) {
            return ((ByteBuf)object0).isDirect() ? object0 : this.newDirectBuffer(((ByteBuf)object0));
        }
        if(!(object0 instanceof FileRegion)) {
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(object0) + AbstractNioByteChannel.EXPECTED_TYPES);
        }
        return object0;
    }

    public final void incompleteWrite(boolean z) {
        if(z) {
            this.setOpWrite();
            return;
        }
        this.clearOpWrite();
        this.eventLoop().execute(this.flushTask);
    }

    // 去混淆评级： 低(20)
    private static boolean isAllowHalfClosure(ChannelConfig channelConfig0) {
        return channelConfig0 instanceof SocketChannelConfig && ((SocketChannelConfig)channelConfig0).isAllowHalfClosure();
    }

    public boolean isInputShutdown0() {
        return false;
    }

    @Override  // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return AbstractNioByteChannel.METADATA;
    }

    @Override  // io.netty.channel.AbstractChannel
    public AbstractUnsafe newUnsafe() {
        return this.newUnsafe();
    }

    public AbstractNioUnsafe newUnsafe() {
        return new NioByteUnsafe(this);
    }

    public final void setOpWrite() {
        SelectionKey selectionKey0 = this.selectionKey();
        if(selectionKey0.isValid()) {
            int v = selectionKey0.interestOps();
            if((v & 4) == 0) {
                selectionKey0.interestOps(v | 4);
            }
        }
    }

    // 去混淆评级： 低(30)
    public final boolean shouldBreakReadReady(ChannelConfig channelConfig0) {
        return this.isInputShutdown0() && (this.inputClosedSeenErrorOnRead || !AbstractNioByteChannel.isAllowHalfClosure(channelConfig0));
    }

    public abstract ChannelFuture shutdownInput();
}

