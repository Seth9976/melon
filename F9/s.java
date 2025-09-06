package f9;

import h9.f;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.Future;
import java.io.IOException;

public final class s implements ChannelFutureListener {
    public final t a;

    public s(t t0) {
        this.a = t0;
    }

    @Override  // io.netty.util.concurrent.GenericFutureListener
    public final void operationComplete(Future future0) {
        if(!((ChannelFuture)future0).isSuccess() && ((ChannelFuture)future0).cause() instanceof IOException) {
            f.j("ServerResponse", ((ChannelFuture)future0).cause().toString());
            this.a.E = true;
        }
    }
}

