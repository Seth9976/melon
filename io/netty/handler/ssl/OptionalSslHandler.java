package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

public class OptionalSslHandler extends ByteToMessageDecoder {
    private final SslContext sslContext;

    public OptionalSslHandler(SslContext sslContext0) {
        this.sslContext = (SslContext)ObjectUtil.checkNotNull(sslContext0, "sslContext");
    }

    public void decode(ChannelHandlerContext channelHandlerContext0, ByteBuf byteBuf0, List list0) {
        if(byteBuf0.readableBytes() < 5) {
            return;
        }
        if(SslHandler.isEncrypted(byteBuf0)) {
            this.handleSsl(channelHandlerContext0);
            return;
        }
        this.handleNonSsl(channelHandlerContext0);
    }

    private void handleNonSsl(ChannelHandlerContext channelHandlerContext0) {
        channelHandlerContext0.pipeline().remove(((ChannelHandler)this));
    }

    private void handleSsl(ChannelHandlerContext channelHandlerContext0) {
        SslHandler sslHandler0 = null;
        try {
            sslHandler0 = this.newSslHandler(channelHandlerContext0, this.sslContext);
            channelHandlerContext0.pipeline().replace(((ChannelHandler)this), null, sslHandler0);
        }
        catch(Throwable throwable0) {
            if(sslHandler0 != null) {
                ReferenceCountUtil.safeRelease(sslHandler0.engine());
            }
            throw throwable0;
        }
    }

    public ChannelHandler newNonSslHandler(ChannelHandlerContext channelHandlerContext0) [...] // Inlined contents

    public String newNonSslHandlerName() [...] // Inlined contents

    public SslHandler newSslHandler(ChannelHandlerContext channelHandlerContext0, SslContext sslContext0) {
        return sslContext0.newHandler(channelHandlerContext0.alloc());
    }

    public String newSslHandlerName() [...] // Inlined contents
}

