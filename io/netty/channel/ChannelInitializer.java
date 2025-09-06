package io.netty.channel;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Sharable
public abstract class ChannelInitializer extends ChannelInboundHandlerAdapter {
    private final Set initMap;
    private static final InternalLogger logger;

    static {
        ChannelInitializer.logger = InternalLoggerFactory.getInstance(ChannelInitializer.class);
    }

    public ChannelInitializer() {
        this.initMap = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public final void channelRegistered(ChannelHandlerContext channelHandlerContext0) {
        if(this.initChannel(channelHandlerContext0)) {
            channelHandlerContext0.pipeline().fireChannelRegistered();
            this.removeState(channelHandlerContext0);
            return;
        }
        channelHandlerContext0.fireChannelRegistered();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        InternalLogger internalLogger0 = ChannelInitializer.logger;
        if(internalLogger0.isWarnEnabled()) {
            internalLogger0.warn("Failed to initialize a channel. Closing: " + channelHandlerContext0.channel(), throwable0);
        }
        channelHandlerContext0.close();
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext0) {
        if(channelHandlerContext0.channel().isRegistered() && this.initChannel(channelHandlerContext0)) {
            this.removeState(channelHandlerContext0);
        }
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext0) {
        this.initMap.remove(channelHandlerContext0);
    }

    private boolean initChannel(ChannelHandlerContext channelHandlerContext0) {
        if(this.initMap.add(channelHandlerContext0)) {
            try {
                this.initChannel(channelHandlerContext0.channel());
            }
            catch(Throwable throwable0) {
                try {
                    this.exceptionCaught(channelHandlerContext0, throwable0);
                }
                catch(Throwable throwable1) {
                    if(!channelHandlerContext0.isRemoved()) {
                        channelHandlerContext0.pipeline().remove(this);
                    }
                    throw throwable1;
                }
                if(!channelHandlerContext0.isRemoved()) {
                    channelHandlerContext0.pipeline().remove(this);
                    return true;
                }
                return true;
            }
            if(!channelHandlerContext0.isRemoved()) {
                channelHandlerContext0.pipeline().remove(this);
                return true;
            }
            return true;
        }
        return false;
    }

    public abstract void initChannel(Channel arg1);

    private void removeState(ChannelHandlerContext channelHandlerContext0) {
        if(channelHandlerContext0.isRemoved()) {
            this.initMap.remove(channelHandlerContext0);
            return;
        }
        channelHandlerContext0.executor().execute(new Runnable() {
            @Override
            public void run() {
                ChannelInitializer.this.initMap.remove(channelHandlerContext0);
            }
        });
    }
}

