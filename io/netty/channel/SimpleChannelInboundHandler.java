package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;

public abstract class SimpleChannelInboundHandler extends ChannelInboundHandlerAdapter {
    private final boolean autoRelease;
    private final TypeParameterMatcher matcher;

    public SimpleChannelInboundHandler() {
        this(true);
    }

    public SimpleChannelInboundHandler(Class class0) {
        this(class0, true);
    }

    public SimpleChannelInboundHandler(Class class0, boolean z) {
        this.matcher = TypeParameterMatcher.get(class0);
        this.autoRelease = z;
    }

    public SimpleChannelInboundHandler(boolean z) {
        this.matcher = TypeParameterMatcher.find(this, SimpleChannelInboundHandler.class, "I");
        this.autoRelease = z;
    }

    public boolean acceptInboundMessage(Object object0) {
        return this.matcher.match(object0);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
        try {
            boolean z = true;
            if(this.acceptInboundMessage(object0)) {
                this.channelRead0(channelHandlerContext0, object0);
            }
            else {
                z = false;
                channelHandlerContext0.fireChannelRead(object0);
            }
        }
        finally {
            if(this.autoRelease && z) {
                ReferenceCountUtil.release(object0);
            }
        }
    }

    public abstract void channelRead0(ChannelHandlerContext arg1, Object arg2);
}

