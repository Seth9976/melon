package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.util.List;

public abstract class SslClientHelloHandler extends ByteToMessageDecoder implements ChannelOutboundHandler {
    public static final int MAX_CLIENT_HELLO_LENGTH = 0xFFFFFF;
    private ByteBuf handshakeBuffer;
    private boolean handshakeFailed;
    private static final InternalLogger logger;
    private final int maxClientHelloLength;
    private boolean readPending;
    private boolean suppressRead;

    static {
        SslClientHelloHandler.logger = InternalLoggerFactory.getInstance(SslClientHelloHandler.class);
    }

    public SslClientHelloHandler() {
        this(0xFFFFFF);
    }

    public SslClientHelloHandler(int v) {
        this.maxClientHelloLength = ObjectUtil.checkInRange(v, 0, 0xFFFFFF, "maxClientHelloLength");
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void bind(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0, ChannelPromise channelPromise0) {
        channelHandlerContext0.bind(socketAddress0, channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void close(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        channelHandlerContext0.close(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void connect(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
        channelHandlerContext0.connect(socketAddress0, socketAddress1, channelPromise0);
    }

    public void decode(ChannelHandlerContext channelHandlerContext0, ByteBuf byteBuf0, List list0) {
        if(!this.suppressRead && !this.handshakeFailed) {
            try {
                int v = byteBuf0.readerIndex();
                int v1 = byteBuf0.readableBytes();
                int v2 = -1;
            alab1:
                while(v1 >= 5) {
                    switch(byteBuf0.getUnsignedByte(v)) {
                        case 20: 
                        case 21: {
                            switch(SslUtils.getEncryptedPacketLength(byteBuf0, v)) {
                                case -2: {
                                    this.handshakeFailed = true;
                                    NotSslRecordException notSslRecordException1 = new NotSslRecordException("not an SSL/TLS record: " + ByteBufUtil.hexDump(byteBuf0));
                                    byteBuf0.skipBytes(byteBuf0.readableBytes());
                                    channelHandlerContext0.fireUserEventTriggered(new SniCompletionEvent(notSslRecordException1));
                                    SslUtils.handleHandshakeFailure(channelHandlerContext0, notSslRecordException1, true);
                                    throw notSslRecordException1;
                                }
                                case -1: {
                                    break alab1;
                                }
                                default: {
                                    this.select(channelHandlerContext0, null);
                                    return;
                                }
                            }
                        }
                        case 22: {
                            if(byteBuf0.getUnsignedByte(v + 1) != 3) {
                                break;
                            }
                            goto label_19;
                        }
                    }
                    this.select(channelHandlerContext0, null);
                    return;
                label_19:
                    int v3 = byteBuf0.getUnsignedShort(v + 3);
                    int v4 = v3 + 5;
                    if(v1 < v4) {
                        break;
                    }
                    if(v4 == 5) {
                        this.select(channelHandlerContext0, null);
                        return;
                    }
                    if(v2 == -1) {
                        if(v + 4 > v + v4) {
                            break;
                        }
                        if(byteBuf0.getUnsignedByte(v + 5) != 1) {
                            this.select(channelHandlerContext0, null);
                            return;
                        }
                        int v5 = byteBuf0.getUnsignedMedium(v + 6);
                        if(v5 > this.maxClientHelloLength && this.maxClientHelloLength != 0) {
                            TooLongFrameException tooLongFrameException1 = new TooLongFrameException("ClientHello length exceeds " + this.maxClientHelloLength + ": " + v5);
                            byteBuf0.skipBytes(byteBuf0.readableBytes());
                            channelHandlerContext0.fireUserEventTriggered(new SniCompletionEvent(((Throwable)tooLongFrameException1)));
                            SslUtils.handleHandshakeFailure(channelHandlerContext0, ((Throwable)tooLongFrameException1), true);
                            throw tooLongFrameException1;
                        }
                        v4 = v3 + 1;
                        if(v5 + 9 <= v4) {
                            this.select(channelHandlerContext0, byteBuf0.retainedSlice(v + 9, v5));
                            return;
                        }
                        ByteBuf byteBuf1 = this.handshakeBuffer;
                        if(byteBuf1 == null) {
                            this.handshakeBuffer = channelHandlerContext0.alloc().buffer(v5);
                        }
                        else {
                            byteBuf1.clear();
                        }
                        v += 4;
                        v2 = v5;
                    }
                    this.handshakeBuffer.writeBytes(byteBuf0, v + 5, v4 - 5);
                    v += v4;
                    v1 -= v4;
                    if(v2 <= this.handshakeBuffer.readableBytes()) {
                        ByteBuf byteBuf2 = this.handshakeBuffer.setIndex(0, v2);
                        this.handshakeBuffer = null;
                        this.select(channelHandlerContext0, byteBuf2);
                        return;
                    }
                    if(false) {
                        break;
                    }
                }
                return;
            }
            catch(NotSslRecordException notSslRecordException0) {
                throw notSslRecordException0;
            }
            catch(TooLongFrameException tooLongFrameException0) {
                throw tooLongFrameException0;
            }
            catch(Exception exception0) {
            }
        }
        else {
            return;
        }
        InternalLogger internalLogger0 = SslClientHelloHandler.logger;
        if(internalLogger0.isDebugEnabled()) {
            internalLogger0.debug("Unexpected client hello packet: " + ByteBufUtil.hexDump(byteBuf0), exception0);
        }
        this.select(channelHandlerContext0, null);
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void deregister(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        channelHandlerContext0.deregister(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        channelHandlerContext0.disconnect(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext0) {
        channelHandlerContext0.flush();
    }

    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext0) {
        this.releaseHandshakeBuffer();
        super.handlerRemoved0(channelHandlerContext0);
    }

    public abstract Future lookup(ChannelHandlerContext arg1, ByteBuf arg2);

    public abstract void onLookupComplete(ChannelHandlerContext arg1, Future arg2);

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void read(ChannelHandlerContext channelHandlerContext0) {
        if(this.suppressRead) {
            this.readPending = true;
            return;
        }
        channelHandlerContext0.read();
    }

    private void releaseHandshakeBuffer() {
        SslClientHelloHandler.releaseIfNotNull(this.handshakeBuffer);
        this.handshakeBuffer = null;
    }

    private static void releaseIfNotNull(ByteBuf byteBuf0) {
        if(byteBuf0 != null) {
            byteBuf0.release();
        }
    }

    private void select(ChannelHandlerContext channelHandlerContext0, ByteBuf byteBuf0) {
        try {
            Future future0 = this.lookup(channelHandlerContext0, byteBuf0);
            if(future0.isDone()) {
                this.onLookupComplete(channelHandlerContext0, future0);
            }
            else {
                this.suppressRead = true;
                future0.addListener(new FutureListener() {
                    @Override  // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(Future future0) {
                        SslClientHelloHandler.releaseIfNotNull(byteBuf0);
                        try {
                            SslClientHelloHandler.this.suppressRead = false;
                            try {
                                SslClientHelloHandler.this.onLookupComplete(channelHandlerContext0, future0);
                            }
                            catch(DecoderException decoderException0) {
                                channelHandlerContext0.fireExceptionCaught(((Throwable)decoderException0));
                            }
                            catch(Exception exception0) {
                                DecoderException decoderException1 = new DecoderException(exception0);
                                channelHandlerContext0.fireExceptionCaught(((Throwable)decoderException1));
                            }
                            catch(Throwable throwable0) {
                                channelHandlerContext0.fireExceptionCaught(throwable0);
                            }
                        }
                        finally {
                            if(SslClientHelloHandler.this.readPending) {
                                SslClientHelloHandler.this.readPending = false;
                                channelHandlerContext0.read();
                            }
                        }
                    }
                });
                byteBuf0 = null;
            }
            goto label_16;
        }
        catch(Throwable throwable0) {
        }
        try {
            PlatformDependent.throwException(throwable0);
        }
        catch(Throwable throwable1) {
            SslClientHelloHandler.releaseIfNotNull(byteBuf0);
            throw throwable1;
        }
        SslClientHelloHandler.releaseIfNotNull(byteBuf0);
        return;
    label_16:
        SslClientHelloHandler.releaseIfNotNull(byteBuf0);
    }

    @Override  // io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext0, Object object0, ChannelPromise channelPromise0) {
        channelHandlerContext0.write(object0, channelPromise0);
    }
}

