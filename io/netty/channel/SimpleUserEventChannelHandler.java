package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;

public abstract class SimpleUserEventChannelHandler extends ChannelInboundHandlerAdapter {
    private final boolean autoRelease;
    private final TypeParameterMatcher matcher;

    public SimpleUserEventChannelHandler() {
        this(true);
    }

    public SimpleUserEventChannelHandler(Class class0) {
        this(class0, true);
    }

    public SimpleUserEventChannelHandler(Class class0, boolean z) {
        this.matcher = TypeParameterMatcher.get(class0);
        this.autoRelease = z;
    }

    public SimpleUserEventChannelHandler(boolean z) {
        this.matcher = TypeParameterMatcher.find(this, SimpleUserEventChannelHandler.class, "I");
        this.autoRelease = z;
    }

    public boolean acceptEvent(Object object0) {
        return this.matcher.match(object0);
    }

    public abstract void eventReceived(ChannelHandlerContext arg1, Object arg2);

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public final void userEventTriggered(ChannelHandlerContext channelHandlerContext0, Object object0) {
        try {
            boolean z = true;
            if(this.acceptEvent(object0)) {
                this.eventReceived(channelHandlerContext0, object0);
            }
            else {
                z = false;
                channelHandlerContext0.fireUserEventTriggered(object0);
            }
        }
        finally {
            if(this.autoRelease && z) {
                ReferenceCountUtil.release(object0);
            }
        }
    }
}

