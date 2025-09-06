package f9;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.Future;

public final class k implements ChannelFutureListener {
    public final int a;

    public k(int v) {
        this.a = v;
        super();
    }

    @Override  // io.netty.util.concurrent.GenericFutureListener
    public final void operationComplete(Future future0) {
        if(this.a != 0) {
            if(!((ChannelFuture)future0).isSuccess()) {
                ((ChannelFuture)future0).channel().close();
            }
            return;
        }
        if(!((ChannelFuture)future0).isSuccess()) {
            ((ChannelFuture)future0).channel().close();
        }
    }
}

