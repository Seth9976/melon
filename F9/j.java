package f9;

import com.iloen.melon.mcache.util.CacheTrackingLog;
import h9.f;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.Future;

public final class j implements ChannelFutureListener {
    public final int a;
    public final Comparable b;
    public final Object c;

    public j(Object object0, Comparable comparable0, int v) {
        this.a = v;
        this.c = object0;
        this.b = comparable0;
        super();
    }

    @Override  // io.netty.util.concurrent.GenericFutureListener
    public final void operationComplete(Future future0) {
        switch(this.a) {
            case 0: {
                l l0 = (l)this.c;
                if(((ChannelFuture)future0).isSuccess()) {
                    if(l0.b != null) {
                        f.b("CacheServerFrontendHandler", "close prior BackHandler Channel by reconnection : " + l0.b.toString());
                        l0.b.close();
                    }
                    l0.b = ((ChannelFuture)future0).channel();
                    f.b("CacheServerFrontendHandler", "new delivery server channel : " + l0.b.toString());
                    f.b("CacheServerFrontendHandler", "Request the meta request.");
                    l0.b.writeAndFlush(l0.a.r());
                }
                else {
                    f.b("CacheServerFrontendHandler", "connection fail!");
                    ((Channel)this.b).close();
                }
                String s1 = ((ChannelFuture)future0).isSuccess() ? "Success" : "Failure";
                f.b.k0("Connection (Server Response): " + s1);
                return;
            }
            case 1: {
                f.b("CacheServerFrontendHandler", "Finish to response cache.[filePath: " + ((String)this.c) + "] - " + ("isSuccess: " + ((ChannelFuture)future0).isSuccess()));
                f.b.k0("Connection (Frontend Response): Local Complete");
                l.c(((Channel)this.b));
                return;
            }
            default: {
                t t0 = (t)this.c;
                String s = (String)this.b;
                f.b("ServerResponse", "Finish to response cache.[cacheFileName: " + s + "] - " + ("isSuccess: " + ((ChannelFuture)future0).isSuccess()));
                CacheTrackingLog.i(("Cache reused: " + s));
                if(!((ChannelFuture)future0).isSuccess()) {
                    f.j("ServerResponse", "fail cause() : " + ((ChannelFuture)future0).cause());
                    t0.b.i(s);
                }
                f.b.k0("Connection (Frontend Response) : Send exist cache.");
                t0.b();
            }
        }
    }
}

