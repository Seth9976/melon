package f9;

import h9.f;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.concurrent.Future;

public final class r implements ChannelFutureListener {
    public final String a;
    public final ChannelHandlerContext b;
    public final t c;

    public r(t t0, String s, ChannelHandlerContext channelHandlerContext0) {
        this.c = t0;
        this.a = s;
        this.b = channelHandlerContext0;
    }

    @Override  // io.netty.util.concurrent.GenericFutureListener
    public final void operationComplete(Future future0) {
        String s = this.a;
        f.b("ServerResponse", "Finish to response temp cache.[cacheFileName: " + s + "] - isSuccess: " + ((ChannelFuture)future0).isSuccess());
        boolean z = ((ChannelFuture)future0).isSuccess();
        t t0 = this.c;
        if(z) {
            t0.h(3);
            f.b("ServerResponse", "Request the content tail data.[cacheFileName: " + s + ", ctx: " + this.b + "]");
            this.b.channel().writeAndFlush(t0.e.s());
            return;
        }
        f.d("ServerResponse", "FrontHandler close by Response error");
        t0.b.i(s);
        f.b.k0("Connection (Frontend Response) : Fail to load exist cache.");
        t0.b();
    }
}

