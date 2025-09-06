package io.netty.channel;

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public interface ChannelFutureListener extends GenericFutureListener {
    public static final ChannelFutureListener CLOSE;
    public static final ChannelFutureListener CLOSE_ON_FAILURE;
    public static final ChannelFutureListener FIRE_EXCEPTION_ON_FAILURE;

    static {
        ChannelFutureListener.CLOSE = new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                channelFuture0.channel().close();
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        };
        ChannelFutureListener.CLOSE_ON_FAILURE = new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                if(!channelFuture0.isSuccess()) {
                    channelFuture0.channel().close();
                }
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        };
        ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE = new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture0) {
                if(!channelFuture0.isSuccess()) {
                    channelFuture0.channel().pipeline().fireExceptionCaught(channelFuture0.cause());
                }
            }

            @Override  // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future future0) {
                this.operationComplete(((ChannelFuture)future0));
            }
        };
    }
}

