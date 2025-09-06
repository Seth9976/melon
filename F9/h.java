package f9;

import android.net.Uri;
import com.iloen.melon.mcache.error.NetworkError.OperationStartError;
import com.iloen.melon.mcache.error.OtherError;
import com.iloen.melon.mcache.error.ParamError.IllegalStateError;
import com.iloen.melon.mcache.error.StreamIOError;
import h9.c;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.NetUtil;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class h {
    public final AtomicBoolean a;
    public CountDownLatch b;
    public String c;
    public int d;
    public NioEventLoopGroup e;
    public NioEventLoopGroup f;

    public h() {
        this.a = new AtomicBoolean(false);
        this.b = new CountDownLatch(1);
        this.c = null;
        this.d = 0;
        this.e = null;
        this.f = null;
    }

    public final void a() {
        if(this.a.compareAndSet(true, false)) {
            try {
                f.a.g();
            }
            catch(StreamIOError streamIOError0) {
                h9.f.d("CacheServer", streamIOError0.toString());
            }
            NioEventLoopGroup nioEventLoopGroup0 = this.e;
            if(nioEventLoopGroup0 != null) {
                nioEventLoopGroup0.shutdownGracefully();
            }
            NioEventLoopGroup nioEventLoopGroup1 = this.f;
            if(nioEventLoopGroup1 != null) {
                nioEventLoopGroup1.shutdownGracefully();
            }
            this.c = null;
            this.b = new CountDownLatch(1);
            h9.f.f("CacheServer", "Close cache server");
        }
    }

    public final boolean b(Uri uri0) {
        return uri0 != null && uri0.getHost() != null && uri0.getPort() != -1 && uri0.getHost().equals(NetUtil.LOCALHOST4.getHostAddress()) && this.d == uri0.getPort();
    }

    public final void c() {
        int v2;
        h9.f.f("CacheServer", "Start cache server");
        String s = q.b;
        long v = q.a;
        if(this.a.compareAndSet(false, true)) {
            if(s == null || v < 0L) {
                throw new IllegalStateError("CacheServer", "start - The cache settings are invalid.[cache directory: " + s + ", cache size: " + v + "]");
            }
            if(new File(s + "/melon.debug").exists()) {
                q.c = true;
                q.d = true;
                q.e = 0;
            }
            this.e = new NioEventLoopGroup(1);
            this.f = new NioEventLoopGroup(1);
            synchronized(c.class) {
                try {
                    do {
                        AtomicInteger atomicInteger0 = c.a;
                        v2 = atomicInteger0.getAndIncrement();
                        if(v2 >= 50000) {
                            atomicInteger0.set(10000);
                            v2 = atomicInteger0.getAndIncrement();
                        }
                    }
                    while(!c.c(v2));
                }
                catch(IOException unused_ex) {
                    v2 = c.a();
                }
            }
            ServerBootstrap serverBootstrap0 = new ServerBootstrap();
            try {
                ((ServerBootstrap)serverBootstrap0.group(this.e, this.f).channel(NioServerSocketChannel.class)).childHandler(new m()).childOption(ChannelOption.AUTO_READ, Boolean.FALSE).bind(v2).sync().channel();  // 初始化器: Lio/netty/channel/ChannelInitializer;-><init>()V
                this.c = NetUtil.LOCALHOST4.getHostAddress() + ":" + v2;
                this.d = v2;
                this.b.countDown();
                h9.f.f("CacheServer", "Internal proxy server listens on " + this.c);
            }
            catch(InterruptedException interruptedException0) {
                new OperationStartError("CacheServer", "start - Can\'t start the proxy server: " + interruptedException0.getMessage());
            }
            catch(Exception exception0) {
                new OtherError("CacheServer", "start - Can\'t start the proxy server: " + exception0.toString());
            }
        }
    }
}

