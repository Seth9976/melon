package io.netty.handler.ssl.ocsp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.ssl.ReferenceCountedOpenSslEngine;
import io.netty.handler.ssl.SslHandshakeCompletionEvent;
import io.netty.util.internal.ObjectUtil;
import javax.net.ssl.SSLHandshakeException;

public abstract class OcspClientHandler extends ChannelInboundHandlerAdapter {
    private final ReferenceCountedOpenSslEngine engine;

    public OcspClientHandler(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine0) {
        this.engine = (ReferenceCountedOpenSslEngine)ObjectUtil.checkNotNull(referenceCountedOpenSslEngine0, "engine");
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext0, Object object0) {
        if(object0 instanceof SslHandshakeCompletionEvent) {
            channelHandlerContext0.pipeline().remove(this);
            if(((SslHandshakeCompletionEvent)object0).isSuccess() && !this.verify(channelHandlerContext0, this.engine)) {
                throw new SSLHandshakeException("Bad OCSP response");
            }
        }
        channelHandlerContext0.fireUserEventTriggered(object0);
    }

    public abstract boolean verify(ChannelHandlerContext arg1, ReferenceCountedOpenSslEngine arg2);
}

