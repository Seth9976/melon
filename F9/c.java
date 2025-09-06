package f9;

import android.net.Uri;
import com.iloen.melon.mcache.error.ParseError.NeedParse;
import h9.d;
import h9.f;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.io.IOException;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

public final class c {
    public long a;
    public Channel b;
    public long c;
    public long d;
    public i e;
    public NioEventLoopGroup f;
    public t g;
    public n h;
    public Uri i;
    public String j;

    public c() {
        this.a = -1L;
    }

    public final void a() {
        this.c = 0L;
        n n0 = this.h;
        if(n0 != null) {
            n0.D = "";
            t t0 = this.g;
            if(t0 != null) {
                ByteBuf byteBuf0 = t0.w;
                if(byteBuf0 != null) {
                    byteBuf0.clear();
                    t0.w = null;
                }
                t t1 = this.g;
                if(t1 != null) {
                    Channel channel0 = t1.d;
                    if(channel0 != null) {
                        l.c(channel0);
                    }
                    NioEventLoopGroup nioEventLoopGroup0 = this.f;
                    if(nioEventLoopGroup0 != null) {
                        nioEventLoopGroup0.shutdownGracefully();
                    }
                    this.e = null;
                    return;
                }
                q.m("serverResponse");
                throw null;
            }
            q.m("serverResponse");
            throw null;
        }
        q.m("clientRequest");
        throw null;
    }

    public final void b(Uri uri0, long v, String s) {
        try {
            this.j = s;
            this.i = uri0;
            this.d = v;
            n n0 = new n();
            this.h = n0;
            n0.l(uri0, v, s);
            n n1 = this.h;
            if(n1 != null) {
                this.g = new t(null, n1, false);
                n n2 = this.h;
                if(n2 != null) {
                    n2.D = "d5b01378-9fb6-4101-a486-0d4871d54ecf";
                    n n3 = this.h;
                    if(n3 != null) {
                        if(n3.F()) {
                            throw new NeedParse("ClientRequest", "isLocal() - Please parsing.");
                        }
                        if(q.b(n3.f, "Y")) {
                            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new b(this, null), 3, null);
                            return;
                        }
                        n n4 = this.h;
                        if(n4 != null) {
                            t t0 = this.g;
                            if(t0 != null) {
                                i i0 = new i();  // 初始化器: Lio/netty/channel/ChannelInboundHandlerAdapter;-><init>()V
                                i0.c = false;
                                i0.f = n4;
                                i0.a = t0;
                                i0.b = 0;
                                this.e = i0;
                                this.f = new NioEventLoopGroup(1);
                                Bootstrap bootstrap0 = new Bootstrap();
                                ((Bootstrap)((Bootstrap)((Bootstrap)bootstrap0.group(this.f)).channel(NioSocketChannel.class)).handler(this.e)).option(ChannelOption.AUTO_READ, Boolean.FALSE);
                                n n5 = this.h;
                                if(n5 != null) {
                                    String s1 = n5.C();
                                    n n6 = this.h;
                                    if(n6 != null) {
                                        bootstrap0.connect(s1, n6.G()).addListener(new a(this));
                                        return;
                                    }
                                    q.m("clientRequest");
                                    throw null;
                                }
                                q.m("clientRequest");
                                throw null;
                            }
                            q.m("serverResponse");
                            throw null;
                        }
                        q.m("clientRequest");
                        throw null;
                    }
                    q.m("clientRequest");
                    throw null;
                }
                q.m("clientRequest");
                throw null;
            }
            q.m("clientRequest");
            throw null;
        }
        catch(Exception exception0) {
            f.d("DataSource", "init() - " + exception0);
        }
    }

    public final boolean c(int v) {
        long v1 = this.c;
        if(v1 > 0L && v == 0) {
            t t0 = this.g;
            if(t0 != null) {
                return v1 >= t0.f.c;
            }
            q.m("serverResponse");
            throw null;
        }
        return false;
    }

    public final long d(Uri uri0, long v, String s) {
        q.g(uri0, "uri");
        q.g(s, "userAgent");
        try {
            this.b(uri0, v, s);
            if(v > 0L) {
                this.a = -1L;
                this.c = 0L;
            }
            this.f();
            return this.a;
        }
        catch(IOException iOException0) {
        }
        f.d("DataSource", "open() - " + iOException0);
        return this.a;
    }

    public final int e(byte[] arr_b, int v, int v1) {
        q.g(arr_b, "buffer");
        t t0 = this.g;
        if(t0 != null) {
            ByteBuf byteBuf0 = t0.w;
            if(byteBuf0 == null) {
                f.d("DataSource", "read() - streamingBuffer null");
                return -1;
            }
            int v2 = byteBuf0.readableBytes();
            if(v2 >= 0 && v2 < v1) {
                if(v2 == 0) {
                    t t1 = this.g;
                    if(t1 == null) {
                        q.m("serverResponse");
                        throw null;
                    }
                    if(t1.D || t1.E) {
                        Uri uri0 = this.i;
                        if(uri0 == null) {
                            q.m("uri");
                            throw null;
                        }
                        long v3 = this.d + this.c;
                        String s = this.j;
                        if(s == null) {
                            q.m("userAgent");
                            throw null;
                        }
                        this.b(uri0, v3, s);
                        t t2 = this.g;
                        if(t2 == null) {
                            q.m("serverResponse");
                            throw null;
                        }
                        ByteBuf byteBuf1 = t2.w;
                        if(byteBuf1 != null) {
                            byteBuf1.clear();
                        }
                        this.c = 0L;
                        this.f();
                    }
                    else if(!this.c(0)) {
                        this.f();
                    }
                    t t3 = this.g;
                    if(t3 == null) {
                        q.m("serverResponse");
                        throw null;
                    }
                    v2 = t3.w.readableBytes();
                    if(v2 <= v1) {
                        v1 = v2;
                    }
                }
                else {
                    v1 = v2;
                }
            }
            try {
                t t4 = this.g;
                if(t4 == null) {
                    q.m("serverResponse");
                    throw null;
                }
                ByteBuf byteBuf2 = t4.w;
                q.f(byteBuf2, "serverResponse.streamingBuffer");
                synchronized(byteBuf2) {
                    t t5 = this.g;
                    if(t5 == null) {
                        q.m("serverResponse");
                        throw null;
                    }
                    t5.w.readBytes(arr_b, v, v1);
                }
                this.c += (long)v1;
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                f.d("DataSource", "read() - " + indexOutOfBoundsException0);
                v1 = 0;
            }
            if(this.c(v1)) {
                f.f("DataSource-read", "read : -1");
                return -1;
            }
            return v1;
        }
        q.m("serverResponse");
        throw null;
    }

    public final void f() {
        long v = 0L;
        while(true) {
            if(Long.compare(this.a, -1L) == 0) {
            label_8:
                t t1 = this.g;
                if(t1 == null) {
                    q.m("serverResponse");
                    throw null;
                }
                if(!t1.j()) {
                    return;
                }
                goto label_12;
            }
            else {
                t t0 = this.g;
                if(t0 == null) {
                    q.m("serverResponse");
                    throw null;
                }
                else if(t0.w.readableBytes() <= 0) {
                    goto label_8;
                }
            }
            return;
        label_12:
            v += 100L;
            if(v > 5000L) {
                throw new IOException();
            }
            t t2 = this.g;
            if(t2 == null) {
                break;
            }
            d d0 = t2.f;
            if((d0 == null ? 0L : d0.c) > 0L) {
                if(t2 != null) {
                    this.a = d0.c;
                    goto label_23;
                }
                q.m("serverResponse");
                throw null;
            }
        label_23:
            Thread.sleep(100L);
        }
        q.m("serverResponse");
        throw null;
    }
}

