package f9;

import com.iloen.melon.utils.a;
import h9.f;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

public final class i extends ChannelInboundHandlerAdapter {
    public t a;
    public int b;
    public boolean c;
    public l d;
    public Channel e;
    public n f;

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public final void channelActive(ChannelHandlerContext channelHandlerContext0) {
        f.b("CacheServerBackendHandler", "Backend handler is activated.");
        channelHandlerContext0.channel().read();
        t t0 = this.a;
        Channel channel0 = channelHandlerContext0.channel();
        t0.d = channel0;
        t0.m.d = ((InetSocketAddress)channel0.remoteAddress()).getAddress().getHostAddress();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public final void channelInactive(ChannelHandlerContext channelHandlerContext0) {
        Channel channel0 = this.e;
        f.b("CacheServerBackendHandler", "channelInactive() : " + channelHandlerContext0.channel().toString());
        this.a.D = this.c;
        this.a.close();
        if(this.c && channel0 != null) {
            f.b("CacheServerBackendHandler", "channelInactive() - retry clientChannel : " + channel0);
            ++this.b;
            channelHandlerContext0.channel().eventLoop().schedule(new E9.t(this, 17), 1L, TimeUnit.SECONDS);
        }
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public final void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
        this.a.l(channelHandlerContext0, ((ByteBuf)object0));
        if(this.e == null) {
            t t0 = this.a;
            t0.getClass();
            try {
                while(t0.w != null && (t0.w.writerIndex() > t0.w.readerIndex() + 0xFF0000 && t0.j())) {
                    Thread.sleep(100L);
                }
                if(t0.j()) {
                    ByteBuf byteBuf0 = t0.w;
                    if(byteBuf0 != null) {
                        synchronized(byteBuf0) {
                            t0.w.discardReadBytes();
                        }
                    }
                }
            }
            catch(Exception exception0) {
                f.d("ServerResponse", "delayForStreamingBufferAvailable() - " + exception0.toString());
            }
            if(!this.a.j()) {
                return;
            }
        }
        channelHandlerContext0.channel().read();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public final void exceptionCaught(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        f.j("CacheServerBackendHandler", "exceptionCaught: " + throwable0);
        t t0 = this.a;
        f.b("CacheServerBackendHandler", "exceptionCaught() > response.getCurrentState() : " + a.y(t0.a));
        f.b("CacheServerBackendHandler", "exceptionCaught() > retryCount : " + this.b);
        if(throwable0 instanceof IOException && this.b < 1 && t0.a == 4) {
            this.c = true;
            return;
        }
        f.b("CacheServerBackendHandler", "exceptionCaught() : closeOnFlush");
        f.b.k0("Connection (Frontend Response) : Backend Handler exceptionCaught " + ("exceptionCaught: " + throwable0));
        l.c(channelHandlerContext0.channel());
    }
}

