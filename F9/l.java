package f9;

import com.iloen.melon.custom.S0;
import com.iloen.melon.mcache.MCacheConnectionInfo;
import com.iloen.melon.mcache.MelonStreamCacheManager;
import com.iloen.melon.mcache.error.ErrorBase;
import com.iloen.melon.mcache.error.ParamError.IllegalArgumentError;
import com.iloen.melon.mcache.error.ParseError.AlreadyParse;
import com.iloen.melon.mcache.error.ParseError.NeedParse;
import com.iloen.melon.mcache.error.ParseError;
import com.iloen.melon.mcache.error.StreamIOError.NoStreamError;
import com.iloen.melon.mcache.error.StreamIOError.OpenError;
import h9.f;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOption;
import io.netty.handler.stream.ChunkedStream;
import io.netty.util.CharsetUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class l extends ChannelInboundHandlerAdapter {
    public final n a;
    public Channel b;

    public l() {
        this.a = new n();
        this.b = null;
    }

    public static void c(Channel channel0) {
        if(channel0 != null && channel0.isActive()) {
            f.b("CacheServerFrontendHandler", "request the empty data for to close connection: " + channel0);
            channel0.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public final void channelActive(ChannelHandlerContext channelHandlerContext0) {
        f.b("CacheServerFrontendHandler", "Frontend handler is activated.");
        channelHandlerContext0.channel().read();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public final void channelInactive(ChannelHandlerContext channelHandlerContext0) {
        f.b("CacheServerFrontendHandler", "channelInactive() : " + channelHandlerContext0.channel().toString());
        this.a.close();
        if(this.b != null) {
            f.b("CacheServerFrontendHandler", "close BackHandler Channel by channelInactive()");
            f.b.k0("Connection (Frontend Response) : Frontend Handler channelInactive");
            l.c(this.b);
            this.b = null;
        }
        f.b("CacheServerFrontendHandler", "Disconnected client channel.");
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public final void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
        n n0 = this.a;
        CompositeByteBuf compositeByteBuf0 = n0.a;
        if(!n0.F()) {
            throw new AlreadyParse("ClientRequest", "Client request is already parsed.");
        }
        n0.r += (long)((ByteBuf)object0).readableBytes();
        CompositeByteBuf compositeByteBuf1 = compositeByteBuf0.addComponent(((ByteBuf)object0));
        int v = compositeByteBuf0.writerIndex();
        compositeByteBuf1.writerIndex(((ByteBuf)object0).readableBytes() + v);
        channelHandlerContext0.channel().read();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public final void channelReadComplete(ChannelHandlerContext channelHandlerContext0) {
        String s1;
        boolean z;
        S0 s00 = f.b;
        n n0 = this.a;
        CompositeByteBuf compositeByteBuf0 = n0.a;
        if(n0.F()) {
            n0.b = new StringBuilder(compositeByteBuf0.writerIndex() + 0x80);
            ByteBufInputStream byteBufInputStream0 = new ByteBufInputStream(compositeByteBuf0);
            try {
                try {
                    n0.c = new StringBuilder();
                    z = false;
                    boolean z1 = false;
                    boolean z2 = false;
                    while(true) {
                    label_10:
                        String s = byteBufInputStream0.readLine();
                        if(s == null) {
                            goto label_34;
                        }
                        s1 = n.i(s);
                        n0.c.append(s1 + "\r\n");
                        if(!z1 && s1.contains("GET")) {
                            s00.k0("Connection (Frontend Request) : " + s1);
                            z1 = true;
                        }
                        f.b("ClientRequest", "Original Request Header: " + s1);
                        if(!z2) {
                            n0.m(s1);
                            z2 = true;
                        }
                        if(s1.length() > 10 && s1.substring(0, 10).equalsIgnoreCase("User-Agent")) {
                            StringBuilder stringBuilder0 = n0.b;
                            stringBuilder0.append(s1);
                            stringBuilder0.append("\r\n");
                            n0.B = s1;
                        }
                        if(s1.length() > 5 && s1.substring(0, 5).equalsIgnoreCase("Range")) {
                            n0.o = true;
                            break;
                        }
                        z = true;
                    }
                }
                catch(ErrorBase errorBase0) {
                    goto label_41;
                }
                catch(Exception exception0) {
                    goto label_44;
                }
                try {
                    n0.n = (long)Integer.parseInt(s1.substring(s1.indexOf(61) + 1, s1.indexOf(45)));
                    z = true;
                    goto label_10;
                }
                catch(Exception exception1) {
                    try {
                        throw new ParseError("ClientRequest", "Can\'t parse the Range - " + exception1.toString() + " / " + n0.B());
                    label_34:
                        if(!z) {
                            throw new NoStreamError("ClientRequest", "There is no stream source[appendBufSize: " + n0.r + "]");
                        }
                        goto label_48;
                    }
                    catch(ErrorBase errorBase0) {
                    }
                    catch(Exception exception0) {
                        goto label_44;
                    }
                }
            label_41:
                f.d("ClientRequest", errorBase0.toString());
            }
            catch(Throwable throwable0) {
                goto label_46;
            }
            try {
                byteBufInputStream0.close();
            }
            catch(IOException unused_ex) {
            }
            return;
            try {
            label_44:
                exception0.printStackTrace();
                goto label_48;
            }
            catch(Throwable throwable0) {
            }
            try {
            label_46:
                byteBufInputStream0.close();
            }
            catch(IOException unused_ex) {
            }
            throw throwable0;
            try {
            label_48:
                byteBufInputStream0.close();
            }
            catch(IOException unused_ex) {
            }
            n0.c.append("\r\n");
            StringBuilder stringBuilder1 = n0.b;
            stringBuilder1.append("Host: ");
            stringBuilder1.append(n0.k);
            if(n0.l == 80) {
                n0.b.append("\r\nConnection: Keep-Alive\r\n");
            }
            else {
                StringBuilder stringBuilder2 = n0.b;
                stringBuilder2.append(":");
                stringBuilder2.append(n0.l);
                stringBuilder2.append("\r\nConnection: Keep-Alive\r\n");
            }
            compositeByteBuf0.release();
            f.b("ClientRequest", "[Converted Request Header]\n" + n0.b);
            if(n0.w) {
                MelonStreamCacheManager.getInstance().checkUserAgent((n0.B == null ? "" : n0.B));
            }
            MCacheConnectionInfo.getInstance().clear();
            MCacheConnectionInfo.getInstance().setCid(n0.q());
            Channel channel0 = channelHandlerContext0.channel();
            f.b("CacheServerFrontendHandler", "Connect original server.");
            if(n0.F()) {
                throw new NeedParse("ClientRequest", "isLocal() - Please parsing.");
            }
            if("Y".equals(n0.f)) {
                f.b("CacheServerFrontendHandler", "loadLocalContents()");
                try {
                    if(n0.F()) {
                        throw new NeedParse("ClientRequest", "localPath() - Please parsing.");
                    }
                    String s2 = n0.g;
                    if(n0.F()) {
                        throw new NeedParse("ClientRequest", "contentType() - Please parsing.");
                    }
                    String s3 = n0.h;
                    long v = n0.n;
                    s00.k0("Connection (Frontend Local Source): " + s2);
                    File file0 = new File(s2);
                    if(!file0.exists()) {
                        throw new OpenError("CacheServerFrontendHandler", s2 + " is not exist.");
                    }
                    o o0 = new o(n0.A(), v, new FileInputStream(file0));
                    o0.skip(v);
                    long v1 = file0.length();
                    String s4 = "HTTP/1.1 206 Partial Content\nAccept-Ranges: bytes\n" + ("Content-Type: " + s3) + "\nConnection: Keep-Alive\nKeep-Alive: timeout=10\nContent-Range: bytes " + v + "-" + (v1 - 1L) + "/" + v1 + "\n\n";
                    f.b("CacheServerFrontendHandler", "loadLocalContents() - Response header: " + s4);
                    channel0.writeAndFlush(Unpooled.wrappedBuffer(s4.getBytes(CharsetUtil.UTF_8))).addListener(new k(0));
                    channel0.writeAndFlush(new ChunkedStream(o0)).addListener(new j(s2, channel0, 1));
                    return;
                }
                catch(Exception exception2) {
                }
                f.d("CacheServerFrontendHandler", "loadLocalContents() - " + exception2.toString());
                s00.k0("Connection (Frontend Response): Local Failure " + exception2.toString());
                l.c(channel0);
                return;
            }
            f.b("CacheServerFrontendHandler", "channelReadComplete() - call createBootstarp()");
            this.f(channelHandlerContext0.channel(), n0, false, 0);
        }
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public final void exceptionCaught(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        String s = throwable0.toString();
        if(!s.contains("ParseError$AlreadyParse")) {
            f.j("CacheServerFrontendHandler", "exceptionCaught: " + throwable0);
        }
        f.j("CacheServerFrontendHandler", "exceptionCaught: " + throwable0);
        f.b.k0("Connection (Frontend Response) : Frontend Handler exceptionCaught " + s);
        l.c(channelHandlerContext0.channel());
    }

    public final void f(Channel channel0, n n0, boolean z, int v) {
        f.b("CacheServerFrontendHandler", "createBootstrap() - byRetry : " + z + " - retryCount : " + v);
        Bootstrap bootstrap0 = new Bootstrap();
        Bootstrap bootstrap1 = (Bootstrap)((Bootstrap)bootstrap0.group(channel0.eventLoop())).channel(channel0.getClass());
        i i0 = new i();  // 初始化器: Lio/netty/channel/ChannelInboundHandlerAdapter;-><init>()V
        i0.a = null;
        i0.b = 0;
        i0.c = false;
        if(n0 == null) {
            new IllegalArgumentError("CacheServerBackendHandler", "The request is required.");
        }
        i0.d = this;
        i0.e = channel0;
        i0.f = n0;
        i0.a = new t(channel0, n0, z);
        i0.b = v;
        ((Bootstrap)bootstrap1.handler(i0)).option(ChannelOption.AUTO_READ, Boolean.FALSE);
        f.b.k0("Connection (Server Request): " + n0.b.toString());
        bootstrap0.connect(n0.C(), n0.G()).addListener(new j(this, channel0, 0));
    }
}

