package f9;

import h9.f;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.stream.ChunkedWriteHandler;

public final class p extends ChunkedWriteHandler {
    @Override  // io.netty.handler.stream.ChunkedWriteHandler
    public final void channelInactive(ChannelHandlerContext channelHandlerContext0) {
        super.channelInactive(channelHandlerContext0);
        f.f("PlayerOutboundHandlerAdapter", "channelInactive()");
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public final void channelReadComplete(ChannelHandlerContext channelHandlerContext0) {
        super.channelReadComplete(channelHandlerContext0);
        f.f("PlayerOutboundHandlerAdapter", "channelReadComplete()");
    }

    @Override  // io.netty.handler.stream.ChunkedWriteHandler
    public final void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext0) {
        super.channelWritabilityChanged(channelHandlerContext0);
        f.b("PlayerOutboundHandlerAdapter", "channelWritabilityChanged()");
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandler
    public final void exceptionCaught(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        super.exceptionCaught(channelHandlerContext0, throwable0);
        f.d("PlayerOutboundHandlerAdapter", "exceptionCaught() - cause : " + throwable0);
    }

    @Override  // io.netty.handler.stream.ChunkedWriteHandler
    public final void resumeTransfer() {
        super.resumeTransfer();
        f.b("PlayerOutboundHandlerAdapter", "resumeTransfer()");
    }
}

