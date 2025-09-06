package io.netty.handler.ssl;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public abstract class ApplicationProtocolNegotiationHandler extends ChannelInboundHandlerAdapter {
    private final RecyclableArrayList bufferedMessages;
    private ChannelHandlerContext ctx;
    private final String fallbackProtocol;
    private static final InternalLogger logger;
    private boolean sslHandlerChecked;

    static {
        ApplicationProtocolNegotiationHandler.logger = InternalLoggerFactory.getInstance(ApplicationProtocolNegotiationHandler.class);
    }

    public ApplicationProtocolNegotiationHandler(String s) {
        this.bufferedMessages = RecyclableArrayList.newInstance();
        this.fallbackProtocol = (String)ObjectUtil.checkNotNull(s, "fallbackProtocol");
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelInactive(ChannelHandlerContext channelHandlerContext0) {
        this.fireBufferedMessages();
        super.channelInactive(channelHandlerContext0);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
        this.bufferedMessages.add(object0);
        if(!this.sslHandlerChecked) {
            this.sslHandlerChecked = true;
            if(channelHandlerContext0.pipeline().get(SslHandler.class) == null) {
                this.removeSelfIfPresent(channelHandlerContext0);
            }
        }
    }

    public abstract void configurePipeline(ChannelHandlerContext arg1, String arg2);

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        Channel channel0 = channelHandlerContext0.channel();
        ApplicationProtocolNegotiationHandler.logger.warn("{} Failed to select the application-level protocol:", channel0, throwable0);
        channelHandlerContext0.fireExceptionCaught(throwable0);
        channelHandlerContext0.close();
    }

    private void fireBufferedMessages() {
        if(!this.bufferedMessages.isEmpty()) {
            for(int v = 0; v < this.bufferedMessages.size(); ++v) {
                this.ctx.fireChannelRead(this.bufferedMessages.get(v));
            }
            this.ctx.fireChannelReadComplete();
            this.bufferedMessages.clear();
        }
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext0) {
        this.ctx = channelHandlerContext0;
        super.handlerAdded(channelHandlerContext0);
    }

    @Override  // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext0) {
        this.fireBufferedMessages();
        this.bufferedMessages.recycle();
        super.handlerRemoved(channelHandlerContext0);
    }

    public void handshakeFailure(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        Channel channel0 = channelHandlerContext0.channel();
        ApplicationProtocolNegotiationHandler.logger.warn("{} TLS handshake failed:", channel0, throwable0);
        channelHandlerContext0.close();
    }

    private void removeSelfIfPresent(ChannelHandlerContext channelHandlerContext0) {
        ChannelPipeline channelPipeline0 = channelHandlerContext0.pipeline();
        if(!channelHandlerContext0.isRemoved()) {
            channelPipeline0.remove(this);
        }
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext0, Object object0) {
        if(object0 instanceof SslHandshakeCompletionEvent) {
            SslHandshakeCompletionEvent sslHandshakeCompletionEvent0 = (SslHandshakeCompletionEvent)object0;
            try {
                if(sslHandshakeCompletionEvent0.isSuccess()) {
                    SslHandler sslHandler0 = (SslHandler)channelHandlerContext0.pipeline().get(SslHandler.class);
                    if(sslHandler0 == null) {
                        throw new IllegalStateException("cannot find an SslHandler in the pipeline (required for application-level protocol negotiation)");
                    }
                    String s = sslHandler0.applicationProtocol();
                    if(s == null) {
                        s = this.fallbackProtocol;
                    }
                    this.configurePipeline(channelHandlerContext0, s);
                }
                goto label_21;
            }
            catch(Throwable throwable0) {
            }
            try {
                this.exceptionCaught(channelHandlerContext0, throwable0);
            }
            catch(Throwable throwable1) {
                if(sslHandshakeCompletionEvent0.isSuccess()) {
                    this.removeSelfIfPresent(channelHandlerContext0);
                }
                throw throwable1;
            }
            if(sslHandshakeCompletionEvent0.isSuccess()) {
                this.removeSelfIfPresent(channelHandlerContext0);
                goto label_23;
            label_21:
                if(sslHandshakeCompletionEvent0.isSuccess()) {
                    this.removeSelfIfPresent(channelHandlerContext0);
                }
            }
        }
    label_23:
        if(object0 instanceof ChannelInputShutdownEvent) {
            this.fireBufferedMessages();
        }
        channelHandlerContext0.fireUserEventTriggered(object0);
    }
}

