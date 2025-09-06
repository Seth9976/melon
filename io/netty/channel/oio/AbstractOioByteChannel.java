package io.netty.channel.oio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.util.internal.StringUtil;
import java.io.IOException;

public abstract class AbstractOioByteChannel extends AbstractOioChannel {
    private static final String EXPECTED_TYPES;
    private static final ChannelMetadata METADATA;

    // 去混淆评级： 低(33)
    static {
        AbstractOioByteChannel.METADATA = new ChannelMetadata(false);
        AbstractOioByteChannel.EXPECTED_TYPES = " (expected: ByteBuf, FileRegion" + ')';
    }

    public AbstractOioByteChannel(Channel channel0) {
        super(channel0);
    }

    public abstract int available();

    private void closeOnRead(ChannelPipeline channelPipeline0) {
        if(this.isOpen()) {
            Object object0 = this.config().getOption(ChannelOption.ALLOW_HALF_CLOSURE);
            if(Boolean.TRUE.equals(object0)) {
                this.shutdownInput();
                channelPipeline0.fireUserEventTriggered(ChannelInputShutdownEvent.INSTANCE);
            }
            else {
                this.unsafe().close(this.unsafe().voidPromise());
            }
            channelPipeline0.fireUserEventTriggered(ChannelInputShutdownReadComplete.INSTANCE);
        }
    }

    @Override  // io.netty.channel.oio.AbstractOioChannel
    public void doRead() {
        boolean z1;
        boolean z;
        Throwable throwable1;
        int v1;
        ByteBuf byteBuf0;
        ChannelConfig channelConfig0 = this.config();
        if(!this.isInputShutdown() && this.readPending) {
            int v = 0;
            this.readPending = false;
            ChannelPipeline channelPipeline0 = this.pipeline();
            ByteBufAllocator byteBufAllocator0 = channelConfig0.getAllocator();
            Handle recvByteBufAllocator$Handle0 = this.unsafe().recvBufAllocHandle();
            recvByteBufAllocator$Handle0.reset(channelConfig0);
            try {
                byteBuf0 = recvByteBufAllocator$Handle0.allocate(byteBufAllocator0);
                v1 = 0;
            }
            catch(Throwable throwable0) {
                throwable1 = throwable0;
                z = false;
                byteBuf0 = null;
                goto label_74;
            }
            while(true) {
                try {
                label_16:
                    recvByteBufAllocator$Handle0.lastBytesRead(this.doReadBytes(byteBuf0));
                    z1 = true;
                    if(recvByteBufAllocator$Handle0.lastBytesRead() <= 0) {
                        if(byteBuf0.isReadable()) {
                            goto label_57;
                        }
                        byteBuf0.release();
                        goto label_21;
                    }
                    goto label_33;
                }
                catch(Throwable throwable2) {
                    z = false;
                    v = v1;
                    goto label_73;
                }
                try {
                label_21:
                    if(recvByteBufAllocator$Handle0.lastBytesRead() >= 0) {
                        z1 = false;
                    }
                    else {
                        this.readPending = false;
                    }
                    byteBuf0 = null;
                    goto label_63;
                }
                catch(Throwable throwable2) {
                    z = false;
                    byteBuf0 = null;
                    v = v1;
                    goto label_73;
                }
                z1 = false;
                byteBuf0 = null;
                goto label_63;
                try {
                    this.readPending = false;
                }
                catch(Throwable throwable2) {
                    goto label_83;
                }
                byteBuf0 = null;
                goto label_63;
                try {
                label_33:
                    int v2 = this.available();
                    if(v2 > 0) {
                        if(!byteBuf0.isWritable()) {
                            int v3 = byteBuf0.maxCapacity();
                            if(byteBuf0.capacity() == v3) {
                                recvByteBufAllocator$Handle0.incMessagesRead(1);
                                this.readPending = false;
                                channelPipeline0.fireChannelRead(byteBuf0);
                                byteBuf0 = recvByteBufAllocator$Handle0.allocate(byteBufAllocator0);
                            }
                            else if(byteBuf0.writerIndex() + v2 > v3) {
                                byteBuf0.capacity(v3);
                            }
                            else {
                                byteBuf0.ensureWritable(v2);
                            }
                        }
                        if(!recvByteBufAllocator$Handle0.continueReading()) {
                            v1 = 1;
                            goto label_57;
                        }
                        v1 = 1;
                        goto label_16;
                    }
                    v1 = 1;
                    goto label_57;
                }
                catch(Throwable throwable3) {
                }
                break;
            }
            throwable1 = throwable3;
            z = false;
            v = 1;
            goto label_74;
            try {
            label_57:
                z1 = false;
            }
            catch(Throwable throwable2) {
                z = false;
                v = v1;
                goto label_73;
            }
        label_63:
            if(byteBuf0 == null) {
                try {
                label_76:
                    if(v1 != 0) {
                        recvByteBufAllocator$Handle0.readComplete();
                        channelPipeline0.fireChannelReadComplete();
                    }
                    if(z1) {
                        this.closeOnRead(channelPipeline0);
                    }
                    goto label_93;
                }
                catch(Throwable throwable2) {
                    try {
                    label_83:
                        v = v1;
                        this.handleReadException(channelPipeline0, null, throwable2, z1, recvByteBufAllocator$Handle0);
                        goto label_90;
                    }
                    catch(Throwable throwable4) {
                    }
                }
            }
            else {
                try {
                    if(byteBuf0.isReadable()) {
                        this.readPending = false;
                        channelPipeline0.fireChannelRead(byteBuf0);
                    }
                    else {
                        byteBuf0.release();
                    }
                    goto label_76;
                }
                catch(Throwable throwable2) {
                    v = v1;
                    z = z1;
                }
            label_73:
                throwable1 = throwable2;
                try {
                label_74:
                    this.handleReadException(channelPipeline0, byteBuf0, throwable1, z, recvByteBufAllocator$Handle0);
                    goto label_90;
                }
                catch(Throwable throwable4) {
                }
            }
            if(this.readPending || channelConfig0.isAutoRead() || v == 0 && this.isActive()) {
                this.read();
            }
            throw throwable4;
        label_90:
            if(this.readPending || channelConfig0.isAutoRead() || v == 0 && this.isActive()) {
                this.read();
                return;
            label_93:
                if(this.readPending || channelConfig0.isAutoRead() || v1 == 0 && this.isActive()) {
                    this.read();
                }
            }
        }
    }

    public abstract int doReadBytes(ByteBuf arg1);

    @Override  // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer0) {
        Object object0;
        while((object0 = channelOutboundBuffer0.current()) != null) {
            if(object0 instanceof ByteBuf) {
                ByteBuf byteBuf0 = (ByteBuf)object0;
                for(int v = byteBuf0.readableBytes(); v > 0; v = v1) {
                    this.doWriteBytes(byteBuf0);
                    int v1 = byteBuf0.readableBytes();
                    channelOutboundBuffer0.progress(((long)(v - v1)));
                }
                channelOutboundBuffer0.remove();
            }
            else if(object0 instanceof FileRegion) {
                long v2 = ((FileRegion)object0).transferred();
                this.doWriteFileRegion(((FileRegion)object0));
                channelOutboundBuffer0.progress(((FileRegion)object0).transferred() - v2);
                channelOutboundBuffer0.remove();
            }
            else {
                channelOutboundBuffer0.remove(new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(object0)));
            }
        }
    }

    public abstract void doWriteBytes(ByteBuf arg1);

    public abstract void doWriteFileRegion(FileRegion arg1);

    @Override  // io.netty.channel.AbstractChannel
    public final Object filterOutboundMessage(Object object0) {
        if(!(object0 instanceof ByteBuf) && !(object0 instanceof FileRegion)) {
            throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(object0) + AbstractOioByteChannel.EXPECTED_TYPES);
        }
        return object0;
    }

    private void handleReadException(ChannelPipeline channelPipeline0, ByteBuf byteBuf0, Throwable throwable0, boolean z, Handle recvByteBufAllocator$Handle0) {
        if(byteBuf0 != null) {
            if(byteBuf0.isReadable()) {
                this.readPending = false;
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

    public abstract boolean isInputShutdown();

    @Override  // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return AbstractOioByteChannel.METADATA;
    }

    public abstract ChannelFuture shutdownInput();
}

