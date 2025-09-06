package f9;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.Future;
import kotlin.jvm.internal.q;

public final class a implements ChannelFutureListener {
    public final c a;

    public a(c c0) {
        this.a = c0;
    }

    @Override  // io.netty.util.concurrent.GenericFutureListener
    public final void operationComplete(Future future0) {
        c c0 = this.a;
        q.g(c0, "this$0");
        if(((ChannelFuture)future0).isSuccess()) {
            Channel channel0 = c0.b;
            if(channel0 != null) {
                channel0.close();
            }
            Channel channel1 = ((ChannelFuture)future0).channel();
            c0.b = channel1;
            if(channel1 != null) {
                n n0 = c0.h;
                if(n0 != null) {
                    channel1.writeAndFlush(n0.r());
                    return;
                }
                q.m("clientRequest");
                throw null;
            }
        }
    }
}

