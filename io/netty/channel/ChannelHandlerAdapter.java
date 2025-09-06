package io.netty.channel;

import io.netty.util.internal.InternalThreadLocalMap;
import java.util.Map;

public abstract class ChannelHandlerAdapter implements ChannelHandler {
    boolean added;

    public void ensureNotSharable() {
        if(this.isSharable()) {
            throw new IllegalStateException("ChannelHandler " + this.getClass().getName() + " is not allowed to be shared");
        }
    }

    @Override  // io.netty.channel.ChannelHandler
    @Skip
    @Deprecated
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        channelHandlerContext0.fireExceptionCaught(throwable0);
    }

    @Override  // io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext0) {
    }

    @Override  // io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext0) {
    }

    public boolean isSharable() {
        Class class0 = this.getClass();
        Map map0 = InternalThreadLocalMap.get().handlerSharableCache();
        Boolean boolean0 = (Boolean)map0.get(class0);
        if(boolean0 == null) {
            boolean0 = Boolean.valueOf(class0.isAnnotationPresent(Sharable.class));
            map0.put(class0, boolean0);
        }
        return boolean0.booleanValue();
    }
}

