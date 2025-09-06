package f9;

import J0.h;
import android.text.TextUtils;
import com.iloen.melon.custom.S0;
import com.iloen.melon.mcache.CachingJNI;
import com.iloen.melon.mcache.MCacheConnectionInfo;
import com.iloen.melon.mcache.MelonStreamCacheManager;
import com.iloen.melon.mcache.error.CodecErrorDebugLog;
import com.iloen.melon.mcache.error.NetworkError;
import com.iloen.melon.mcache.error.ParamError;
import com.iloen.melon.mcache.error.ParseError.NeedParse;
import com.iloen.melon.mcache.error.ParseError;
import com.iloen.melon.mcache.error.StreamIOError.ReadError;
import com.iloen.melon.mcache.error.StreamIOError.WriteError;
import com.iloen.melon.mcache.error.StreamIOError;
import com.iloen.melon.mcache.util.CacheTrackingLog;
import h9.c;
import h9.d;
import h9.e;
import hg.a;
import hg.b;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.stream.ChunkedStream;
import io.netty.util.CharsetUtil;
import java.io.Closeable;
import java.io.IOException;

public final class t implements Closeable {
    public final boolean B;
    public boolean D;
    public boolean E;
    public int a;
    public final g b;
    public final Channel c;
    public Channel d;
    public final n e;
    public d f;
    public long g;
    public int h;
    public h i;
    public a j;
    public boolean k;
    public boolean l;
    public final e m;
    public CachingJNI n;
    public String o;
    public int r;
    public ByteBuf w;

    public t(Channel channel0, n n0, boolean z) {
        this.a = 1;
        this.b = f.a;
        this.g = 0L;
        this.h = 0;
        this.i = null;
        this.j = null;
        this.k = true;
        this.l = true;
        this.m = null;
        this.n = null;
        this.o = null;
        this.r = 3;
        this.w = null;
        this.E = false;
        this.c = channel0;
        this.e = n0;
        String s = n0.b.toString();
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.a = 0;
        e0.b = new StringBuilder(0x800);
        e0.c = s;
        e0.d = e0.d;
        this.m = e0;
        this.B = z;
        if(channel0 == null) {
            this.w = Unpooled.buffer(0x1000000);
        }
        MelonStreamCacheManager.getInstance().codecErrorDebugLog = new CodecErrorDebugLog();
    }

    public final void b() {
        Channel channel0 = this.c;
        if(channel0 != null) {
            l.c(channel0);
            return;
        }
        l.c(this.d);
    }

    public final a c(String s, d d0) {
        return this.f(s, d0, false);
    }

    public final void c() {
        boolean z;
        a a0 = this.j;
        if(a0 == null) {
            z = false;
        }
        else {
            try {
                a0.close();
                this.j = null;
                z = true;
            }
            catch(IOException iOException0) {
                h9.f.j("ServerResponse", "Can\'t close cacheOutputStream: " + iOException0.getMessage());
                z = false;
            }
        }
        if(this.i != null) {
            String s = this.o;
            this.b.getClass();
            long v = g.a(s);
            if((!z || !this.k || v != this.g) && !this.D) {
                try {
                    this.i.f();
                    h9.f.d("ServerResponse", "cacheEditor.abort() - succeededWriteCache : " + this.k);
                }
                catch(IOException iOException2) {
                    h9.f.j("ServerResponse", "Can\'t abort the cache data: " + iOException2.getMessage());
                }
                h9.f.f("ServerResponse", "Failed to write cache data.");
                hg.d d1 = f.a.a;
                if(d1 != null) {
                    try {
                        synchronized(d1) {
                            if(d1.h == null) {
                                throw new IllegalStateException("cache is closed");
                            }
                            d1.B();
                            d1.h.flush();
                        }
                    }
                    catch(Exception exception0) {
                        h9.f.j("CacheFileControler", "clearCacheStorage() - " + exception0.getMessage());
                    }
                }
            }
            else {
                try {
                    h h0 = this.i;
                    hg.d d0 = (hg.d)h0.d;
                    if(h0.b) {
                        hg.d.c(d0, h0, false);
                        d0.A(((b)h0.c).a);
                    }
                    else {
                        hg.d.c(d0, h0, true);
                    }
                    h9.f.f("ServerResponse", "Succeeded to write cache data.");
                }
                catch(IOException iOException1) {
                    h9.f.j("ServerResponse", "Can\'t commit the cache data." + iOException1.getMessage());
                }
            }
            this.i = null;
        }
    }

    @Override
    public final void close() {
        h9.f.f("ServerResponse", "close() - isCloseForReconnect : " + this.D);
        h9.f.f("ServerResponse", "close() - cacheOutputStream : " + (this.j != null));
        if(this.j != null) {
            if(!this.D) {
                h9.f.b("ServerResponse", "FrontHandler close by Response close()");
                h9.f.b.k0("Connection (Frontend Response) : Response close");
                l.c(this.c);
            }
            this.k = this.a == 5;
            this.c();
        }
        this.e();
    }

    public final void e() {
        CachingJNI cachingJNI0 = this.n;
        if(cachingJNI0 != null) {
            try {
                cachingJNI0.close();
            }
            catch(IOException iOException0) {
                h9.f.j("ServerResponse", "Can\'t close crypto: " + iOException0.getMessage());
            }
            this.n = null;
        }
    }

    public final a f(String s, d d0, boolean z) {
        g g0 = this.b;
        if(this.e.o || this.e.n <= 0L) {
            try {
                String s1 = Integer.toString(d0.a());
                h h0 = g0.b(s, s1);
                this.i = h0;
                if(h0 != null) {
                    if(z) {
                        h9.f.b("ServerResponse", "open cacheOutputStream");
                    }
                    else {
                        h9.f.b("ServerResponse", "create and open cacheOutputStream");
                    }
                    return g0.c(s, s1, this.i, z);
                }
                return null;
            }
            catch(StreamIOError streamIOError0) {
            }
            h9.f.d("ServerResponse", streamIOError0.toString());
        }
        return null;
    }

    public static String g(n n0) {
        return c.b((n0.q() + "&" + n0.h() + "&" + n0.E()));
    }

    public final void h(int v) {
        h9.f.f("ServerResponse", "Change ServerResponse Status. [prev: " + com.iloen.melon.utils.a.y(this.a) + ", cur: " + com.iloen.melon.utils.a.y(v));
        this.a = v;
    }

    public final void i(long v) {
        if(this.n == null) {
            h9.f.b("ServerResponse", "Create new Crypto object.[offset: " + v + "]");
            try {
                this.n = new CachingJNI(this.e.A(), v);
            }
            catch(ParseError parseError0) {
                h9.f.d("ServerResponse", "createCrypto() - " + parseError0.toString());
            }
        }
    }

    public final void j(o o0, ChannelFutureListener channelFutureListener0) {
        Channel channel0 = this.c;
        if(channel0 != null) {
            channel0.writeAndFlush(new ChunkedStream(o0)).addListener(channelFutureListener0);
            return;
        }
        if(this.r == 0) {
            l.c(this.d);
        }
        String s = this.o;
        try {
            try {
                while(this.j()) {
                    if(this.w.writerIndex() > this.w.readerIndex() + 0xFF0000) {
                        Thread.sleep(100L);
                    }
                    else {
                        byte[] arr_b = new byte[0x10000];
                        int v = o0.read(arr_b, 0, 0x10000);
                        if(v == -1) {
                            break;
                        }
                        ByteBuf byteBuf0 = this.w;
                        synchronized(byteBuf0) {
                            ByteBuf byteBuf1 = this.w;
                            if(byteBuf1 != null) {
                                byteBuf1.discardReadBytes();
                                this.w.writeBytes(arr_b, 0, v);
                            }
                        }
                    }
                }
                CacheTrackingLog.i(("Cache reused: " + s));
                goto label_41;
            }
            catch(NullPointerException unused_ex) {
            }
            catch(Exception exception0) {
                goto label_33;
            }
        }
        catch(Throwable throwable0) {
            goto label_38;
        }
        h9.f.b.k0("Connection (Frontend Response) : Send exist cache.");
        goto label_36;
        try {
        label_33:
            h9.f.j("ServerResponse", "fail cause() : " + exception0.getMessage());
            this.b.i(s);
        }
        catch(Throwable throwable0) {
            goto label_38;
        }
        h9.f.b.k0("Connection (Frontend Response) : Send exist cache.");
        try {
        label_36:
            o0.close();
        }
        catch(Exception unused_ex) {
        }
        return;
    label_38:
        h9.f.b.k0("Connection (Frontend Response) : Send exist cache.");
        try {
            o0.close();
        }
        catch(Exception unused_ex) {
        }
        throw throwable0;
    label_41:
        h9.f.b.k0("Connection (Frontend Response) : Send exist cache.");
        try {
            o0.close();
        }
        catch(Exception unused_ex) {
        }
    }

    public final boolean j() {
        return !this.e.D.isEmpty();
    }

    public final void l(ChannelHandlerContext channelHandlerContext0, ByteBuf byteBuf0) {
        o o0;
        String s6;
        long v2;
        long v1;
        int v;
        boolean z3;
        String s1;
        S0 s01;
        S0 s00;
        g g0 = this.b;
        Channel channel0 = this.c;
        boolean z = this.B;
        e e0 = this.m;
        n n0 = this.e;
        if(this.a == 1) {
            try {
                this.l = true;
                if(e0.c(byteBuf0)) {
                    boolean z1 = n0.o;
                    if(n0.F()) {
                        throw new NeedParse("ClientRequest", "startOffset() - Please parsing.");
                    }
                    d d0 = e0.a(n0.n, z1);
                    this.f = d0;
                    this.g = d0.b;
                    MCacheConnectionInfo.getInstance().setXmStream(((String)this.f.g));
                    String s = ((StringBuilder)this.f.d).toString();
                    h9.f.b("ServerResponse", "Client Response Header: " + s);
                    if(!z) {
                        ByteBuf byteBuf1 = Unpooled.wrappedBuffer(s.getBytes(CharsetUtil.UTF_8));
                        if(channel0 != null) {
                            channel0.writeAndFlush(byteBuf1).addListener(new k(1));
                        }
                    }
                    e0.d();
                    this.h = 0;
                    this.h(2);
                }
            label_24:
                s00 = h9.f.b;
                if(this.a != 2) {
                    s01 = s00;
                    goto label_128;
                }
                s1 = ((StringBuilder)this.f.d).toString();
                String[] arr_s = s1.split("\r\n");
                h9.f.b("ServerResponse", "splits: " + arr_s[0]);
                if(arr_s[0].split(" ")[1].startsWith("20")) {
                    this.o = null;
                    try {
                        boolean z2 = g0.j();
                        String s2 = t.g(n0);
                        this.o = s2;
                        z3 = z2;
                        v = 3;
                        v = this.m(s2, this.f);
                        h9.f.b("ServerResponse", "newCacheFileName : " + this.o + " - " + v);
                        if(v != 0 && v != 1) {
                            String s3 = t.n(n0);
                            v = this.p(s3, this.f);
                            h9.f.b("ServerResponse", "cacheOldFileName : " + s3 + " - " + v);
                            if(v == 0) {
                                this.o = s3;
                                h9.f.b("ServerResponse", "exist cacheFileName : " + s3);
                            }
                        }
                    }
                    catch(StreamIOError streamIOError0) {
                        h9.f.j("ServerResponse", streamIOError0.toString());
                        z3 = false;
                    }
                    h9.f.b("ServerResponse", this.o + "\'s - " + this.f);
                    h9.f.b("ServerResponse", "appendResponseByteBuf() - cacheFileState : " + v);
                    if(v != 0) {
                        h9.f.b("ServerResponse", this.o + " cache is none exist.");
                        if(z3) {
                            String s4 = n0.p();
                            if(TextUtils.isEmpty(s4) || "Y".equalsIgnoreCase(s4)) {
                                if(n0.n > 0L) {
                                    this.l = false;
                                }
                                else {
                                    this.j = this.c(this.o, this.f);
                                }
                            }
                        }
                        this.h(3);
                        h9.f.b("ServerResponse", "Request the content tail data. [cacheFileName: " + this.o + ", ctx: " + channelHandlerContext0 + "]");
                        channelHandlerContext0.channel().writeAndFlush(n0.s());
                        goto label_65;
                    }
                    goto label_67;
                }
                goto label_178;
            }
            catch(ParseError parseError0) {
                goto label_165;
            }
            catch(NetworkError networkError0) {
                goto label_167;
            }
            catch(ParamError paramError0) {
                goto label_169;
            }
            catch(IOException | InterruptedException iOException0) {
                goto label_172;
            }
            catch(Throwable throwable0) {
                byteBuf0.release();
                throw throwable0;
            }
        }
        goto label_24;
    label_65:
        byteBuf0.release();
        return;
        try {
        label_67:
            String s5 = this.o;
            g0.getClass();
            v1 = g.a(s5);
            h9.f.b("ServerResponse", this.o + " cache is exist. - [cache size : " + v1 + "]");
            v2 = n0.n;
            if(v2 > v1) {
                this.l = false;
                this.h(3);
                channelHandlerContext0.channel().writeAndFlush(n0.s());
                goto label_76;
            }
            goto label_78;
        }
        catch(ParseError parseError0) {
            goto label_165;
        }
        catch(NetworkError networkError0) {
            goto label_167;
        }
        catch(ParamError paramError0) {
            goto label_169;
        }
        catch(IOException | InterruptedException iOException0) {
            goto label_172;
        }
        catch(Throwable throwable0) {
            byteBuf0.release();
            throw throwable0;
        }
    label_76:
        byteBuf0.release();
        return;
        try {
            try {
            label_78:
                s6 = Integer.toString(this.f.a());
                h9.f.b("ServerResponse", "open cacheOutputStream - tailStartOffset : " + v2);
                o0 = new o(n0.A(), v2, g0.f(this.o, s6));
                o0.skip(v2);
                goto label_90;
            }
            catch(IOException | StreamIOError iOException1) {
            }
            catch(ParseError parseError0) {
                goto label_165;
            }
            catch(NetworkError networkError0) {
                goto label_167;
            }
            catch(ParamError paramError0) {
                goto label_169;
            }
            try {
                h9.f.j("ServerResponse", "Can\'t skip the cache stream. [skip: " + v2 + "]\n" + iOException1.toString());
                this.h(3);
                h9.f.b("ServerResponse", "Request the content tail data.[cacheFileName: " + this.o + ", ctx: " + channelHandlerContext0 + "]");
                channelHandlerContext0.channel().writeAndFlush(n0.s());
            }
            catch(ParseError parseError0) {
                goto label_165;
            }
            catch(NetworkError networkError0) {
                goto label_167;
            }
            catch(ParamError paramError0) {
                goto label_169;
            }
            catch(IOException iOException0) {
                goto label_172;
            }
        }
        catch(InterruptedException iOException0) {
            goto label_172;
        }
        catch(Throwable throwable0) {
            byteBuf0.release();
            throw throwable0;
        }
        byteBuf0.release();
        return;
        try {
            try {
            label_90:
                MelonStreamCacheManager.getInstance().codecErrorDebugLog.setResponseHeader(s1.replace("\n", ", "));
                MelonStreamCacheManager.getInstance().codecErrorDebugLog.setFileName(this.o);
                MelonStreamCacheManager.getInstance().codecErrorDebugLog.setHCode(s6);
                MelonStreamCacheManager.getInstance().codecErrorDebugLog.setCacheFileLength(v1);
                MelonStreamCacheManager.getInstance().codecErrorDebugLog.setDecryptOffset(n0.n);
                MelonStreamCacheManager.getInstance().codecErrorDebugLog.setBitrate(n0.h());
                MelonStreamCacheManager.getInstance().codecErrorDebugLog.setMetaType(n0.E());
                int v3 = n0.A().length();
                MelonStreamCacheManager.getInstance().codecErrorDebugLog.setC(n0.A().substring(0, 5) + "..." + n0.A().substring(v3 - 5, v3));
            }
            catch(Exception unused_ex) {
            }
            try {
                h9.f.b("ServerResponse", "cachedFileSize : " + v1 + " / clientHeader.contsSize : " + this.f.b);
                if(v1 < this.f.b) {
                    this.r = 2;
                    MelonStreamCacheManager.getInstance().codecErrorDebugLog.setCacheFileStatus("CACHE_PART_FILE");
                    h9.f.b("ServerResponse", "Uncomplted cache file exist - cachedFileSize: " + v1);
                    if(z3) {
                        String s7 = n0.p();
                        if(TextUtils.isEmpty(s7) || "Y".equalsIgnoreCase(s7)) {
                            n0.j(((long)(((int)v1))));
                            n0.o();
                            this.j = this.q(this.o, this.f);
                        }
                    }
                    if(!z) {
                        this.j(o0, new r(this, this.o, channelHandlerContext0));
                        if(channel0 == null) {
                            this.h(3);
                            channelHandlerContext0.channel().writeAndFlush(n0.s()).addListener(new s(this));
                        }
                        s01 = s00;
                        goto label_128;
                    }
                    channelHandlerContext0.channel().writeAndFlush(n0.s());
                    this.h(3);
                    goto label_119;
                }
                else {
                    goto label_121;
                }
                goto label_128;
            }
            catch(ParseError parseError0) {
                goto label_165;
            }
            catch(NetworkError networkError0) {
                goto label_167;
            }
            catch(ParamError paramError0) {
                goto label_169;
            }
            catch(IOException | InterruptedException iOException0) {
                goto label_172;
            }
        }
        catch(Throwable throwable0) {
            byteBuf0.release();
            throw throwable0;
        }
    label_119:
        byteBuf0.release();
        return;
        try {
        label_121:
            this.r = 0;
            MelonStreamCacheManager.getInstance().codecErrorDebugLog.setCacheFileStatus("CACHE_COMPLETE_FILE");
            h9.f.b("ServerResponse", "Response the cache data.[cacheFileName: " + this.o + ", startOffset: " + v2 + ", skip: " + v2 + "]");
            this.j(o0, new j(this, this.o, 2));
            this.h(5);
            s01 = s00;
            s01.j0(g.a(this.o), this.o);
        label_128:
            if(this.a == 3 && e0.c(byteBuf0)) {
                boolean z4 = n0.o;
                if(n0.F()) {
                    throw new NeedParse("ClientRequest", "startOffset() - Please parsing.");
                }
                this.f = e0.a(n0.n, z4);
                this.h(4);
            }
        }
        catch(ParseError parseError0) {
            goto label_165;
        }
        catch(NetworkError networkError0) {
            goto label_167;
        }
        catch(ParamError paramError0) {
            goto label_169;
        }
        catch(IOException | InterruptedException iOException0) {
            goto label_172;
        }
        catch(Throwable throwable0) {
            byteBuf0.release();
            throw throwable0;
        }
        if(this.a == 4) {
            try {
                try {
                    this.i(n0.n);
                    byteBuf0.retain();
                    this.o(byteBuf0);
                    this.h += byteBuf0.readableBytes();
                    h9.f.b("ServerResponse", "processedContsSize/clientHeader.responseContentLength : " + this.h + "/" + this.f.c);
                    if(((long)this.h) == this.f.c) {
                        this.h(5);
                        this.e();
                        this.c();
                        s01.k0("Connection (Frontend Response) : Send server data.");
                        this.b();
                        int v4 = this.r;
                        if(v4 == 3) {
                            CacheTrackingLog.i(("Cache created: " + this.o));
                        }
                        else {
                            switch(v4) {
                                case 1: {
                                    CacheTrackingLog.i(("Cache changed: " + this.o));
                                    break;
                                }
                                case 2: {
                                    CacheTrackingLog.i(("Cache concatenated: " + this.o));
                                }
                            }
                        }
                    }
                    goto label_176;
                }
                catch(ParseError parseError0) {
                }
                catch(NetworkError networkError0) {
                    goto label_167;
                }
                catch(ParamError paramError0) {
                    goto label_169;
                }
                catch(IOException | InterruptedException iOException0) {
                    goto label_172;
                }
            label_165:
                h9.f.d("ServerResponse", "state: " + com.iloen.melon.utils.a.y(this.a) + " - " + parseError0.getMessage());
                goto label_170;
            label_167:
                h9.f.d("ServerResponse", networkError0.toString());
                goto label_170;
            label_169:
                h9.f.d("ServerResponse", paramError0.toString());
            }
            catch(Throwable throwable0) {
                byteBuf0.release();
                throw throwable0;
            }
        label_170:
            byteBuf0.release();
            return;
            try {
            label_172:
                h9.f.d("ServerResponse", iOException0.getMessage());
                throw new RuntimeException(iOException0);
            }
            catch(Throwable throwable0) {
            }
            byteBuf0.release();
            throw throwable0;
        }
    label_176:
        byteBuf0.release();
        return;
    label_178:
        byteBuf0.release();
    }

    public final int m(String s, d d0) {
        String s1 = Integer.toString(d0.a());
        long v = d0.b;
        g g0 = this.b;
        g0.getClass();
        try {
            hg.c c0 = g0.a.i(s, false);
            if(c0 != null) {
                boolean z = g0.a.k >= 2;
                h9.f.b("DiskLruCache", "isSupportConcat() - result: " + z);
                if(!z && g.e(v, s)) {
                    h9.f.b("CacheFileControler", "hasContent() - Unsupported concat file " + s + " is deleted.");
                    return 1;
                }
                if(s1.equals(c0.h())) {
                    h9.f.b("CacheFileControler", "hasContent() - " + s + "\'s info is not changed.");
                    return 0;
                }
                h9.f.b("CacheFileControler", "hasContent() - " + s + "\'s info is changed.");
                if(g0.a.A(s)) {
                    CacheTrackingLog.i(("Cache deleted: " + s + "[cause: file meta changed]"));
                }
                return 1;
            }
            if(g.e(v, s)) {
                h9.f.b("CacheFileControler", "hasContent() - Unmanaged file " + s + " is deleted.");
            }
            return 3;
        }
        catch(Exception exception0) {
        }
        StringBuilder stringBuilder0 = A7.d.o("Failed to check the Cache[cid=", s, ", hCode=", s1, "]: ");
        stringBuilder0.append(exception0.getMessage());
        throw new ReadError("CacheFileControler", stringBuilder0.toString());
    }

    public static String n(n n0) {
        return c.b(n0.q());
    }

    public final void o(ByteBuf byteBuf0) {
        g g0 = this.b;
        byte[] arr_b = ByteBufUtil.getBytes(byteBuf0);
        ByteBuf byteBuf1 = Unpooled.wrappedBuffer(this.n.c(arr_b));
        try {
            byteBuf1.retain();
            Channel channel0 = this.c;
            if(channel0 == null) {
                ByteBuf byteBuf2 = this.w;
                if(byteBuf2 != null) {
                    byteBuf2.writeBytes(byteBuf1);
                }
            }
            else if(channel0 != null) {
                channel0.writeAndFlush(byteBuf1).addListener(new k(1));
            }
        }
        finally {
            byteBuf1.release();
        }
        if(this.a == 4 && this.j != null && this.l && this.k) {
            try {
                String s = this.e.p();
                if((TextUtils.isEmpty(s) || "Y".equalsIgnoreCase(s)) && g0.j()) {
                    try {
                        this.j.write(arr_b);
                    }
                    catch(IOException unused_ex) {
                        throw new WriteError("CacheFileControler", "Stream write error.");
                    }
                    this.k = true;
                    return;
                }
                return;
            }
            catch(Exception exception0) {
            }
            h9.f.d("ServerResponse", "Write crypted content: " + exception0.toString());
        }
    }

    public final int p(String s, d d0) {
        String s1 = Integer.toString(d0.a());
        long v = d0.b;
        g g0 = this.b;
        g0.getClass();
        try {
            hg.c c0 = g0.a.i(s, false);
            if(c0 != null) {
                boolean z = g0.a.k >= 2;
                h9.f.b("DiskLruCache", "isSupportConcat() - result: " + z);
                if(!z && g.e(v, s)) {
                    h9.f.b("CacheFileControler", "hasContent() - Unsupported concat file " + s + " is deleted.");
                    return 1;
                }
                if(s1.equals(c0.h())) {
                    h9.f.b("CacheFileControler", "hasContent() - " + s + "\'s info is not changed.");
                    return 0;
                }
                h9.f.b("CacheFileControler", "hasContent() - " + s + "\'s hCode is difference.");
                return 4;
            }
            if(g.e(v, s)) {
                h9.f.b("CacheFileControler", "hasContent() - Unmanaged file " + s + " is deleted.");
            }
            return 3;
        }
        catch(Exception exception0) {
        }
        StringBuilder stringBuilder0 = A7.d.o("Failed to check the Cache[cid=", s, ", hCode=", s1, "]: ");
        stringBuilder0.append(exception0.getMessage());
        throw new ReadError("CacheFileControler", stringBuilder0.toString());
    }

    public final a q(String s, d d0) {
        return this.f(s, d0, true);
    }
}

