package io.netty.handler.ssl;

import U4.x;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.ScheduledFuture;
import io.netty.util.internal.ObjectUtil;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public abstract class AbstractSniHandler extends SslClientHelloHandler {
    protected final long handshakeTimeoutMillis;
    private String hostname;
    private ScheduledFuture timeoutFuture;

    public AbstractSniHandler() {
        this(0, 0L);
    }

    public AbstractSniHandler(int v, long v1) {
        super(v);
        this.handshakeTimeoutMillis = ObjectUtil.checkPositiveOrZero(v1, "handshakeTimeoutMillis");
    }

    public AbstractSniHandler(long v) {
        this(0, v);
    }

    public void channelActive(ChannelHandlerContext channelHandlerContext0) {
        channelHandlerContext0.fireChannelActive();
        this.checkStartTimeout(channelHandlerContext0);
    }

    private void checkStartTimeout(ChannelHandlerContext channelHandlerContext0) {
        if(this.handshakeTimeoutMillis > 0L && this.timeoutFuture == null) {
            this.timeoutFuture = channelHandlerContext0.executor().schedule(new Runnable() {
                @Override
                public void run() {
                    if(channelHandlerContext0.channel().isActive()) {
                        StringBuilder stringBuilder0 = new StringBuilder("handshake timed out after ");
                        SniCompletionEvent sniCompletionEvent0 = new SniCompletionEvent(new SslHandshakeTimeoutException(x.h(AbstractSniHandler.this.handshakeTimeoutMillis, "ms", stringBuilder0)));
                        channelHandlerContext0.fireUserEventTriggered(sniCompletionEvent0);
                        channelHandlerContext0.close();
                    }
                }
            }, this.handshakeTimeoutMillis, TimeUnit.MILLISECONDS);
        }
    }

    private static String extractSniHostname(ByteBuf byteBuf0) {
        int v = byteBuf0.readerIndex();
        int v1 = byteBuf0.writerIndex();
        if(v1 - (v + 34) >= 6) {
            int v2 = byteBuf0.getUnsignedByte(v + 34) + 1 + (v + 34);
            int v3 = byteBuf0.getUnsignedShort(v2) + 2 + v2;
            int v4 = byteBuf0.getUnsignedByte(v3) + 1 + v3;
            int v5 = v4 + 2;
            int v6 = byteBuf0.getUnsignedShort(v4) + v5;
            if(v6 <= v1) {
                while(v6 - v5 >= 4) {
                    int v7 = byteBuf0.getUnsignedShort(v5);
                    int v8 = byteBuf0.getUnsignedShort(v5 + 2);
                    if(v6 - (v5 + 4) < v8) {
                        break;
                    }
                    if(v7 == 0) {
                        if(v6 - (v5 + 6) < 3 || byteBuf0.getUnsignedByte(v5 + 6) != 0) {
                            break;
                        }
                        int v9 = byteBuf0.getUnsignedShort(v5 + 7);
                        return v6 - (v5 + 9) < v9 ? null : byteBuf0.toString(v5 + 9, v9, CharsetUtil.US_ASCII).toLowerCase(Locale.US);
                    }
                    v5 = v5 + 4 + v8;
                }
            }
        }
        return null;
    }

    private static void fireSniCompletionEvent(ChannelHandlerContext channelHandlerContext0, String s, Future future0) {
        Throwable throwable0 = future0.cause();
        if(throwable0 == null) {
            channelHandlerContext0.fireUserEventTriggered(new SniCompletionEvent(s));
            return;
        }
        channelHandlerContext0.fireUserEventTriggered(new SniCompletionEvent(s, throwable0));
    }

    @Override  // io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext0) {
        if(channelHandlerContext0.channel().isActive()) {
            this.checkStartTimeout(channelHandlerContext0);
        }
    }

    @Override  // io.netty.handler.ssl.SslClientHelloHandler
    public Future lookup(ChannelHandlerContext channelHandlerContext0, ByteBuf byteBuf0) {
        String s = byteBuf0 == null ? null : AbstractSniHandler.extractSniHostname(byteBuf0);
        this.hostname = s;
        return this.lookup(channelHandlerContext0, s);
    }

    public abstract Future lookup(ChannelHandlerContext arg1, String arg2);

    @Override  // io.netty.handler.ssl.SslClientHelloHandler
    public void onLookupComplete(ChannelHandlerContext channelHandlerContext0, Future future0) {
        ScheduledFuture scheduledFuture0 = this.timeoutFuture;
        if(scheduledFuture0 != null) {
            scheduledFuture0.cancel(false);
        }
        try {
            this.onLookupComplete(channelHandlerContext0, this.hostname, future0);
        }
        finally {
            AbstractSniHandler.fireSniCompletionEvent(channelHandlerContext0, this.hostname, future0);
        }
    }

    public abstract void onLookupComplete(ChannelHandlerContext arg1, String arg2, Future arg3);
}

