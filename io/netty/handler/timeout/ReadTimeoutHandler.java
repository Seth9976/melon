package io.netty.handler.timeout;

import io.netty.channel.ChannelHandlerContext;
import java.util.concurrent.TimeUnit;

public class ReadTimeoutHandler extends IdleStateHandler {
    static final boolean $assertionsDisabled;
    private boolean closed;

    public ReadTimeoutHandler(int v) {
        this(((long)v), TimeUnit.SECONDS);
    }

    public ReadTimeoutHandler(long v, TimeUnit timeUnit0) {
        super(v, 0L, 0L, timeUnit0);
    }

    @Override  // io.netty.handler.timeout.IdleStateHandler
    public final void channelIdle(ChannelHandlerContext channelHandlerContext0, IdleStateEvent idleStateEvent0) {
        this.readTimedOut(channelHandlerContext0);
    }

    public void readTimedOut(ChannelHandlerContext channelHandlerContext0) {
        if(!this.closed) {
            channelHandlerContext0.fireExceptionCaught(ReadTimeoutException.INSTANCE);
            channelHandlerContext0.close();
            this.closed = true;
        }
    }
}

