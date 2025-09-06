package z3;

import B3.d;
import E9.u;
import I6.p0;
import M6.s;
import Q0.D;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import android.view.Surface;
import androidx.media3.exoplayer.C;
import androidx.media3.exoplayer.f;
import androidx.media3.exoplayer.g;
import androidx.media3.exoplayer.h0;
import androidx.media3.exoplayer.video.PlaceholderSurface;
import androidx.media3.exoplayer.video.VideoFrameReleaseHelper;
import androidx.media3.exoplayer.y;
import b3.H;
import b3.m0;
import b3.z0;
import com.facebook.appevents.internal.a;
import e3.q;
import e3.r;
import e3.t;
import e3.x;
import ea.c;
import h3.e;
import i.n.i.b.a.s.e.Fd;
import i.n.i.b.a.s.e.H0;
import i.n.i.b.a.s.e.P3;
import j3.n;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jeb.synthetic.FIN;
import o3.h;
import o3.i;
import o3.m;
import o3.p;
import o3.v;
import s3.z;

public final class b extends p {
    public int A1;
    public boolean B1;
    public int C1;
    public H0 D1;
    public j E1;
    public long F1;
    public long G1;
    public boolean H1;
    public static final int[] I1;
    public static boolean J1;
    public static boolean K1;
    public final Context Y0;
    public final boolean Z0;
    public final ea.b a1;
    public final int b1;
    public final boolean c1;
    public final l d1;
    public final k e1;
    public d f1;
    public boolean g1;
    public boolean h1;
    public z3.d i1;
    public boolean j1;
    public List k1;
    public Surface l1;
    public PlaceholderSurface m1;
    public q n1;
    public boolean o1;
    public int p1;
    public int q1;
    public long r1;
    public int s1;
    public int t1;
    public int u1;
    public long v1;
    public int w1;
    public long x1;
    public z0 y1;
    public z0 z1;

    static {
        b.I1 = new int[]{0x780, 1600, 0x5A0, 0x500, 960, 854, 640, 540, 480};
    }

    public b(Context context0, i i0, h h0, long v, Handler handler0, y y0) {
        super(2, i0, h0, 30.0f);
        Context context1 = context0.getApplicationContext();
        this.Y0 = context1;
        this.b1 = 50;
        this.i1 = null;
        this.a1 = new ea.b(handler0, y0);
        this.Z0 = true;
        this.d1 = new l(context1, this, v);
        this.e1 = new k();
        this.c1 = "NVIDIA".equals(x.c);
        this.n1 = q.c;
        this.p1 = 1;
        this.q1 = 0;
        this.y1 = z0.d;
        this.C1 = 0;
        this.z1 = null;
        this.A1 = -1000;
        this.F1 = 0x8000000000000001L;
        this.G1 = 0x8000000000000001L;
    }

    public final void A0() {
        if(this.B1) {
            o3.j j0 = this.g0;
            if(j0 != null) {
                this.D1 = new H0(this, j0);
                Bundle bundle0 = new Bundle();
                bundle0.putInt("tunnel-peek", 1);
                j0.c(bundle0);
            }
        }
    }

    @Override  // o3.p
    public final g B(m m0, androidx.media3.common.b b0, androidx.media3.common.b b1) {
        g g0 = m0.b(b0, b1);
        int v = g0.e;
        d d0 = this.f1;
        d0.getClass();
        if(b1.u > d0.a || b1.v > d0.b) {
            v |= 0x100;
        }
        if(b.x0(m0, b1) > d0.c) {
            v |= 0x40;
        }
        return v == 0 ? new g(m0.a, b0, b1, g0.d, 0) : new g(m0.a, b0, b1, 0, v);
    }

    public final void B0(o3.j j0, int v, long v1) {
        Trace.beginSection("releaseOutputBuffer");
        j0.n(v, v1);
        Trace.endSection();
        ++this.T0.e;
        boolean z = false;
        this.t1 = 0;
        if(this.i1 == null) {
            z0 z00 = this.y1;
            ea.b b0 = this.a1;
            if(!z00.equals(z0.d) && !z00.equals(this.z1)) {
                this.z1 = z00;
                b0.m(z00);
            }
            l l0 = this.d1;
            if(l0.e != 3) {
                z = true;
            }
            l0.e = 3;
            l0.l.getClass();
            l0.g = x.M(SystemClock.elapsedRealtime());
            if(z) {
                Surface surface0 = this.l1;
                if(surface0 != null) {
                    Handler handler0 = (Handler)b0.a;
                    if(handler0 != null) {
                        handler0.post(new a(3, SystemClock.elapsedRealtime(), b0, surface0));
                    }
                    this.o1 = true;
                }
            }
        }
    }

    @Override  // o3.p
    public final o3.l C(IllegalStateException illegalStateException0, m m0) {
        Surface surface0 = this.l1;
        o3.l l0 = new z3.a(illegalStateException0, m0);  // 初始化器: Lo3/l;-><init>(Ljava/lang/IllegalStateException;Lo3/m;)V
        if(surface0 != null) {
            surface0.isValid();
        }
        return l0;
    }

    // 去混淆评级： 低(40)
    public final boolean C0(m m0) {
        return !this.B1 && !b.u0(m0.a) && (!m0.f || PlaceholderSurface.a(this.Y0));
    }

    public final void D0(o3.j j0, int v) {
        Trace.beginSection("skipVideoBuffer");
        j0.k(v);
        Trace.endSection();
        ++this.T0.f;
    }

    public final void E0(int v, int v1) {
        this.T0.h += v;
        int v2 = v + v1;
        this.T0.g += v2;
        this.s1 += v2;
        int v3 = this.t1 + v2;
        this.t1 = v3;
        this.T0.i = Math.max(v3, this.T0.i);
        if(this.b1 > 0 && this.s1 >= this.b1) {
            this.z0();
        }
    }

    public final void F0(long v) {
        this.T0.k += v;
        ++this.T0.l;
        this.v1 += v;
        ++this.w1;
    }

    @Override  // o3.p
    public final int K(e e0) {
        return 0;
    }

    @Override  // o3.p
    public final boolean L() {
        return false;
    }

    @Override  // o3.p
    public final float M(float f, androidx.media3.common.b[] arr_b) {
        float f1 = -1.0f;
        for(int v = 0; v < arr_b.length; ++v) {
            float f2 = arr_b[v].w;
            if(f2 != -1.0f) {
                f1 = Math.max(f1, f2);
            }
        }
        return f1 == -1.0f ? -1.0f : f1 * f;
    }

    @Override  // o3.p
    public final ArrayList N(h h0, androidx.media3.common.b b0, boolean z) {
        ArrayList arrayList0 = new ArrayList(b.w0(this.Y0, h0, b0, z, this.B1));
        Collections.sort(arrayList0, new D(new n(b0, 4), 4));
        return arrayList0;
    }

    @Override  // o3.p
    public final u O(m m0, androidx.media3.common.b b0, MediaCrypto mediaCrypto0, float f) {
        Point point0;
        int v17;
        int v9;
        d d0;
        String s = m0.c;
        androidx.media3.common.b[] arr_b = this.j;
        arr_b.getClass();
        int v = b0.u;
        float f1 = b0.w;
        b3.i i0 = b0.B;
        int v1 = b0.v;
        int v2 = b.x0(m0, b0);
        if(arr_b.length == 1) {
            if(v2 != -1) {
                int v3 = b.v0(m0, b0);
                if(v3 != -1) {
                    v2 = Math.min(((int)(((float)v2) * 1.5f)), v3);
                }
            }
            d0 = new d(v, v1, v2);
        }
        else {
            int v4 = v;
            int v5 = v1;
            int v7 = 0;
            for(int v6 = 0; v6 < arr_b.length; v6 = v9 + 1) {
                androidx.media3.common.b b1 = arr_b[v6];
                if(i0 != null && b1.B == null) {
                    b3.n n0 = b1.a();
                    n0.A = i0;
                    b1 = new androidx.media3.common.b(n0);
                }
                g g0 = m0.b(b0, b1);
                int v8 = b1.v;
                if(g0.d == 0) {
                    v9 = v6;
                }
                else {
                    v9 = v6;
                    v7 |= (b1.u == -1 || v8 == -1 ? 1 : 0);
                    v4 = Math.max(v4, b1.u);
                    v5 = Math.max(v5, v8);
                    v2 = Math.max(v2, b.x0(m0, b1));
                }
            }
            if(v7 != 0) {
                e3.b.D("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + v4 + "x" + v5);
                boolean z = v1 > v;
                int v10 = z ? v1 : v;
                int v11 = z ? v : v1;
                float f2 = ((float)v11) / ((float)v10);
                int v12 = 0;
                while(true) {
                    if(v12 < 9) {
                        int v13 = b.I1[v12];
                        int v14 = (int)(((float)v13) * f2);
                        if(v13 > v10 && v14 > v11) {
                            int v15 = v14;
                            if(!z) {
                                v14 = v13;
                            }
                            if(!z) {
                                v13 = v15;
                            }
                            MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0 = m0.d;
                            if(mediaCodecInfo$CodecCapabilities0 == null) {
                                v17 = v10;
                                point0 = null;
                            }
                            else {
                                MediaCodecInfo.VideoCapabilities mediaCodecInfo$VideoCapabilities0 = mediaCodecInfo$CodecCapabilities0.getVideoCapabilities();
                                if(mediaCodecInfo$VideoCapabilities0 != null) {
                                    int v16 = mediaCodecInfo$VideoCapabilities0.getWidthAlignment();
                                    v17 = v10;
                                    int v18 = mediaCodecInfo$VideoCapabilities0.getHeightAlignment();
                                    point0 = new Point((v14 + v16 - 1) / v16 * v16, (v13 + v18 - 1) / v18 * v18);
                                }
                            }
                            if(point0 != null && m0.f(point0.x, point0.y, ((double)f1))) {
                                break;
                            }
                            ++v12;
                            v10 = v17;
                            continue;
                        }
                    }
                    point0 = null;
                    break;
                }
                if(point0 != null) {
                    v4 = Math.max(v4, point0.x);
                    v5 = Math.max(v5, point0.y);
                    b3.n n1 = b0.a();
                    n1.t = v4;
                    n1.u = v5;
                    v2 = Math.max(v2, b.v0(m0, new androidx.media3.common.b(n1)));
                    e3.b.D("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + v4 + "x" + v5);
                }
            }
            d0 = new d(v4, v5, v2);
        }
        this.f1 = d0;
        int v19 = this.B1 ? this.C1 : 0;
        MediaFormat mediaFormat0 = new MediaFormat();
        mediaFormat0.setString("mime", s);
        mediaFormat0.setInteger("width", v);
        mediaFormat0.setInteger("height", v1);
        e3.b.B(mediaFormat0, b0.q);
        if(f1 != -1.0f) {
            mediaFormat0.setFloat("frame-rate", f1);
        }
        e3.b.x(mediaFormat0, "rotation-degrees", b0.x);
        if(i0 != null) {
            e3.b.x(mediaFormat0, "color-transfer", i0.c);
            e3.b.x(mediaFormat0, "color-standard", i0.a);
            e3.b.x(mediaFormat0, "color-range", i0.b);
            byte[] arr_b1 = i0.d;
            if(arr_b1 != null) {
                mediaFormat0.setByteBuffer("hdr-static-info", ByteBuffer.wrap(arr_b1));
            }
        }
        if("video/dolby-vision".equals(b0.n)) {
            Pair pair0 = v.d(b0);
            if(pair0 != null) {
                e3.b.x(mediaFormat0, "profile", ((int)(((Integer)pair0.first))));
            }
        }
        mediaFormat0.setInteger("max-width", d0.a);
        mediaFormat0.setInteger("max-height", d0.b);
        e3.b.x(mediaFormat0, "max-input-size", d0.c);
        mediaFormat0.setInteger("priority", 0);
        if(f != -1.0f) {
            mediaFormat0.setFloat("operating-rate", f);
        }
        if(this.c1) {
            mediaFormat0.setInteger("no-post-process", 1);
            mediaFormat0.setInteger("auto-frc", 0);
        }
        if(v19 != 0) {
            mediaFormat0.setFeatureEnabled("tunneled-playback", true);
            mediaFormat0.setInteger("audio-session-id", v19);
        }
        Surface surface0 = this.y0(m0);
        if(this.i1 != null && !x.I(this.Y0)) {
            mediaFormat0.setInteger("allow-frame-drop", 0);
        }
        return new u(m0, mediaFormat0, b0, surface0, mediaCrypto0, null);
    }

    @Override  // o3.p
    public final void P(e e0) {
        if(this.h1) {
            ByteBuffer byteBuffer0 = e0.h;
            byteBuffer0.getClass();
            if(byteBuffer0.remaining() >= 7) {
                int v = byteBuffer0.get();
                int v1 = byteBuffer0.getShort();
                int v2 = byteBuffer0.getShort();
                int v3 = byteBuffer0.get();
                int v4 = byteBuffer0.get();
                byteBuffer0.position(0);
                if(v == -75 && v1 == 60 && v2 == 1 && v3 == 4 && (v4 == 0 || v4 == 1)) {
                    byte[] arr_b = new byte[byteBuffer0.remaining()];
                    byteBuffer0.get(arr_b);
                    byteBuffer0.position(0);
                    o3.j j0 = this.g0;
                    j0.getClass();
                    Bundle bundle0 = new Bundle();
                    bundle0.putByteArray("hdr10-plus-info", arr_b);
                    j0.c(bundle0);
                }
            }
        }
    }

    @Override  // o3.p
    public final void U(Exception exception0) {
        e3.b.q("MediaCodecVideoRenderer", "Video codec error", exception0);
        ea.b b0 = this.a1;
        Handler handler0 = (Handler)b0.a;
        if(handler0 != null) {
            handler0.post(new o(b0, exception0, 3));
        }
    }

    @Override  // o3.p
    public final void V(String s, long v, long v1) {
        MediaCodecInfo.CodecProfileLevel[] arr_mediaCodecInfo$CodecProfileLevel;
        ea.b b0 = this.a1;
        Handler handler0 = (Handler)b0.a;
        if(handler0 != null) {
            handler0.post(new o(b0, s, v, v1));
        }
        this.g1 = b.u0(s);
        m m0 = this.n0;
        m0.getClass();
        boolean z = false;
        if("video/x-vnd.on2.vp9".equals(m0.b)) {
            MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0 = m0.d;
            if(mediaCodecInfo$CodecCapabilities0 == null) {
                arr_mediaCodecInfo$CodecProfileLevel = new MediaCodecInfo.CodecProfileLevel[0];
            }
            else {
                arr_mediaCodecInfo$CodecProfileLevel = mediaCodecInfo$CodecCapabilities0.profileLevels;
                if(arr_mediaCodecInfo$CodecProfileLevel == null) {
                    arr_mediaCodecInfo$CodecProfileLevel = new MediaCodecInfo.CodecProfileLevel[0];
                }
            }
            for(int v2 = 0; v2 < arr_mediaCodecInfo$CodecProfileLevel.length; ++v2) {
                if(arr_mediaCodecInfo$CodecProfileLevel[v2].profile == 0x4000) {
                    z = true;
                    break;
                }
            }
        }
        this.h1 = z;
        this.A0();
    }

    @Override  // o3.p
    public final void W(String s) {
        ea.b b0 = this.a1;
        Handler handler0 = (Handler)b0.a;
        if(handler0 != null) {
            handler0.post(new o(b0, s, 6));
        }
    }

    @Override  // o3.p
    public final g X(c c0) {
        g g0 = super.X(c0);
        androidx.media3.common.b b0 = (androidx.media3.common.b)c0.c;
        b0.getClass();
        ea.b b1 = this.a1;
        Handler handler0 = (Handler)b1.a;
        if(handler0 != null) {
            handler0.post(new o(b1, b0, g0));
        }
        return g0;
    }

    @Override  // o3.p
    public final void Y(androidx.media3.common.b b0, MediaFormat mediaFormat0) {
        int v1;
        int v;
        o3.j j0 = this.g0;
        if(j0 != null) {
            j0.setVideoScalingMode(this.p1);
        }
        if(this.B1) {
            v = b0.u;
            v1 = b0.v;
        }
        else {
            mediaFormat0.getClass();
            boolean z = mediaFormat0.containsKey("crop-right") && mediaFormat0.containsKey("crop-left") && mediaFormat0.containsKey("crop-bottom") && mediaFormat0.containsKey("crop-top");
            int v2 = z ? mediaFormat0.getInteger("crop-right") - mediaFormat0.getInteger("crop-left") + 1 : mediaFormat0.getInteger("width");
            v1 = z ? mediaFormat0.getInteger("crop-bottom") - mediaFormat0.getInteger("crop-top") + 1 : mediaFormat0.getInteger("height");
            v = v2;
        }
        float f = b0.y;
        if(b0.x == 90 || b0.x == 270) {
            f = 1.0f / f;
            int v3 = v1;
            v1 = v;
            v = v3;
        }
        this.y1 = new z0(v, v1, f);
        z3.d d0 = this.i1;
        if(d0 == null || !this.H1) {
            this.d1.g(b0.w);
        }
        else {
            b3.n n0 = b0.a();
            n0.t = v;
            n0.u = v1;
            n0.x = f;
            androidx.media3.common.b b1 = new androidx.media3.common.b(n0);
            e3.b.j(false);
            d0.n.b.g(b1.w);
            d0.c = b1;
            if(d0.i) {
                e3.b.j(d0.h != 0x8000000000000001L);
                d0.j = true;
                d0.k = d0.h;
            }
            else {
                d0.e();
                d0.i = true;
                d0.j = false;
                d0.k = 0x8000000000000001L;
            }
        }
        this.H1 = false;
    }

    @Override  // o3.p
    public final void a0(long v) {
        super.a0(v);
        if(!this.B1) {
            --this.u1;
        }
    }

    @Override  // o3.p
    public final void b0() {
        z3.d d0 = this.i1;
        if(d0 == null) {
            this.d1.d(2);
        }
        else {
            d0.j(this.U0.b, this.U0.c, -this.F1, this.l);
        }
        this.H1 = true;
        this.A0();
    }

    @Override  // o3.p
    public final void c0(e e0) {
        if(!this.B1) {
            ++this.u1;
        }
    }

    @Override  // o3.p
    public final void d0(androidx.media3.common.b b0) {
        z3.d d0 = this.i1;
        if(d0 == null) {
            return;
        }
        try {
            d0.c(b0);
            throw null;
        }
        catch(z3.q q0) {
            throw this.d(q0, b0, false, 7000);
        }
    }

    @Override  // androidx.media3.exoplayer.e
    public final void e() {
        z3.d d0 = this.i1;
        if(d0 != null) {
            l l0 = (l)d0.n.f.a;
            if(l0.e == 0) {
                l0.e = 1;
            }
            return;
        }
        l l1 = this.d1;
        if(l1.e == 0) {
            l1.e = 1;
        }
    }

    @Override  // o3.p
    public final boolean f0(long v, long v1, o3.j j0, ByteBuffer byteBuffer0, int v2, int v3, int v4, long v5, boolean z, boolean z1, androidx.media3.common.b b0) {
        j0.getClass();
        o3.o o0 = this.U0;
        long v6 = v5 - o0.c;
        z3.d d0 = this.i1;
        if(d0 != null) {
            try {
                long v7 = v5 - this.F1;
                B7.b b1 = new B7.b();  // 初始化器: Ljava/lang/Object;-><init>()V
                b1.c = this;
                b1.b = j0;
                b1.a = v2;
                return d0.b(v7, z1, v, v1, b1);
            }
            catch(z3.q q0) {
                throw this.d(q0, q0.a, false, 7001);
            }
        }
        int v8 = this.d1.a(v5, v, v1, o0.b, z1, this.e1);
        if(v8 != 4) {
            if(z && !z1) {
                this.D0(j0, v2);
                return true;
            }
            k k0 = this.e1;
            if(this.l1 != null) {
                switch(v8) {
                    case 0: {
                        this.g.getClass();
                        long v9 = System.nanoTime();
                        j j1 = this.E1;
                        if(j1 != null) {
                            j1.a(v6, v9, b0, this.i0);
                        }
                        this.B0(j0, v2, v9);
                        this.F0(k0.a);
                        return true;
                    }
                    case 1: {
                        long v10 = k0.b;
                        long v11 = k0.a;
                        if(v10 == this.x1) {
                            this.D0(j0, v2);
                        }
                        else {
                            j j2 = this.E1;
                            if(j2 != null) {
                                j2.a(v6, v10, b0, this.i0);
                            }
                            this.B0(j0, v2, v10);
                        }
                        this.F0(v11);
                        this.x1 = v10;
                        return true;
                    }
                    case 2: {
                        Trace.beginSection("dropVideoBuffer");
                        j0.k(v2);
                        Trace.endSection();
                        this.E0(0, 1);
                        this.F0(k0.a);
                        return true;
                    }
                    case 3: {
                        this.D0(j0, v2);
                        this.F0(k0.a);
                        return true;
                    }
                    case 5: {
                        break;
                    }
                    default: {
                        throw new IllegalStateException(String.valueOf(v8));
                    }
                }
            }
            else if(k0.a < 30000L) {
                this.D0(j0, v2);
                this.F0(k0.a);
                return true;
            }
        }
        return false;
    }

    @Override  // androidx.media3.exoplayer.e
    public final String g() {
        return "MediaCodecVideoRenderer";
    }

    @Override  // androidx.media3.exoplayer.e
    public final void handleMessage(int v, Object object0) {
        l l0 = this.d1;
        switch(v) {
            case 1: {
                Surface surface1 = object0 instanceof Surface ? ((Surface)object0) : null;
                ea.b b0 = this.a1;
                if(this.l1 != surface1) {
                    this.l1 = surface1;
                    if(this.i1 == null) {
                        VideoFrameReleaseHelper videoFrameReleaseHelper1 = l0.b;
                        if(videoFrameReleaseHelper1.e != surface1) {
                            videoFrameReleaseHelper1.b();
                            videoFrameReleaseHelper1.e = surface1;
                            videoFrameReleaseHelper1.d(true);
                        }
                        l0.d(1);
                    }
                    this.o1 = false;
                    int v4 = this.h;
                    o3.j j1 = this.g0;
                    if(j1 != null && this.i1 == null) {
                        m m0 = this.n0;
                        m0.getClass();
                        if((this.l1 == null || !this.l1.isValid()) && !this.C0(m0) || this.g1) {
                            this.h0();
                            this.S();
                        }
                        else {
                            Surface surface2 = this.y0(m0);
                            if(surface2 == null) {
                                throw new IllegalStateException();
                            }
                            j1.i(surface2);
                        }
                    }
                    if(surface1 == null) {
                        this.z1 = null;
                        z3.d d5 = this.i1;
                        if(d5 != null) {
                            d5.n.l = null;
                        }
                    }
                    else {
                        z0 z00 = this.z1;
                        if(z00 != null) {
                            b0.m(z00);
                        }
                        if(v4 == 2) {
                            z3.d d4 = this.i1;
                            if(d4 == null) {
                                l0.c(true);
                            }
                            else {
                                d4.d(true);
                            }
                        }
                    }
                    this.A0();
                    return;
                }
                if(surface1 != null) {
                    z0 z01 = this.z1;
                    if(z01 != null) {
                        b0.m(z01);
                    }
                    Surface surface3 = this.l1;
                    if(surface3 != null && this.o1) {
                        Handler handler0 = (Handler)b0.a;
                        if(handler0 != null) {
                            handler0.post(new a(3, SystemClock.elapsedRealtime(), b0, surface3));
                        }
                    }
                }
                break;
            }
            case 4: {
                object0.getClass();
                int v2 = (int)(((Integer)object0));
                this.p1 = v2;
                o3.j j0 = this.g0;
                if(j0 != null) {
                    j0.setVideoScalingMode(v2);
                    return;
                }
                break;
            }
            case 5: {
                object0.getClass();
                int v1 = (int)(((Integer)object0));
                this.q1 = v1;
                z3.d d2 = this.i1;
                if(d2 != null) {
                    d2.g(v1);
                    return;
                }
                VideoFrameReleaseHelper videoFrameReleaseHelper0 = l0.b;
                if(videoFrameReleaseHelper0.j != v1) {
                    videoFrameReleaseHelper0.j = v1;
                    videoFrameReleaseHelper0.d(true);
                    return;
                }
                break;
            }
            case 7: {
                object0.getClass();
                this.E1 = (j)object0;
                z3.d d3 = this.i1;
                if(d3 != null) {
                    d3.n.j = (j)object0;
                    return;
                }
                break;
            }
            case 10: {
                object0.getClass();
                int v3 = (int)(((Integer)object0));
                if(this.C1 != v3) {
                    this.C1 = v3;
                    if(this.B1) {
                        this.h0();
                        return;
                    }
                }
                break;
            }
            case 11: {
                this.b0 = (C)object0;
                return;
            }
            case 13: {
                object0.getClass();
                this.k1 = (List)object0;
                z3.d d1 = this.i1;
                if(d1 != null) {
                    d1.k(((List)object0));
                    return;
                }
                break;
            }
            case 14: {
                object0.getClass();
                if(((q)object0).a != 0 && ((q)object0).b != 0) {
                    this.n1 = (q)object0;
                    z3.d d0 = this.i1;
                    if(d0 != null) {
                        Surface surface0 = this.l1;
                        e3.b.k(surface0);
                        d0.h(surface0, ((q)object0));
                        return;
                    }
                }
                break;
            }
            case 16: {
                object0.getClass();
                this.A1 = (int)(((Integer)object0));
            }
        }
    }

    @Override  // androidx.media3.exoplayer.e
    public final boolean i() {
        return this.P0 && this.i1 == null;
    }

    @Override  // o3.p
    public final void j0() {
        super.j0();
        this.u1 = 0;
    }

    @Override  // o3.p
    public final boolean k() {
        boolean z = super.k();
        z3.d d0 = this.i1;
        if(d0 != null) {
            return ((l)d0.n.f.a).b(false);
        }
        return !z || this.g0 != null && this.l1 != null && !this.B1 ? this.d1.b(z) : true;
    }

    @Override  // o3.p
    public final void l() {
        ea.b b0 = this.a1;
        this.z1 = null;
        this.G1 = 0x8000000000000001L;
        z3.d d0 = this.i1;
        if(d0 == null) {
            this.d1.d(0);
        }
        else {
            ((l)d0.n.f.a).d(0);
        }
        this.A0();
        this.o1 = false;
        this.D1 = null;
        try {
            super.l();
        }
        finally {
            f f0 = this.T0;
            b0.getClass();
            Handler handler0 = (Handler)b0.a;
            if(handler0 != null) {
                handler0.post(new P3(25, b0, f0));
            }
            b0.m(z0.d);
        }
    }

    @Override  // androidx.media3.exoplayer.e
    public final void m(boolean z, boolean z1) {
        this.T0 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        h0 h00 = this.d;
        h00.getClass();
        boolean z2 = h00.b;
        e3.b.j(!z2 || this.C1 != 0);
        if(this.B1 != z2) {
            this.B1 = z2;
            this.h0();
        }
        f f0 = this.T0;
        ea.b b0 = this.a1;
        Handler handler0 = (Handler)b0.a;
        if(handler0 != null) {
            handler0.post(new o(b0, f0, 4));
        }
        l l0 = this.d1;
        if(!this.j1) {
            if(this.k1 != null && this.i1 == null) {
                com.iloen.melon.sns.model.a a0 = new com.iloen.melon.sns.model.a();  // 初始化器: Ljava/lang/Object;-><init>()V
                a0.b = this.Y0.getApplicationContext();
                a0.c = l0;
                a0.f = p0.e;
                a0.g = r.a;
                r r0 = this.g;
                r0.getClass();
                a0.g = r0;
                e3.b.j(!a0.a);
                if(((z3.f)a0.e) == null) {
                    if(((z3.e)a0.d) == null) {
                        a0.d = new z3.e();  // 初始化器: Ljava/lang/Object;-><init>()V
                    }
                    a0.e = new z3.f(((z3.e)a0.d));
                }
                z3.g g0 = new z3.g(a0);
                a0.a = true;
                this.i1 = g0.a;
            }
            this.j1 = true;
        }
        z3.d d0 = this.i1;
        if(d0 != null) {
            d0.l = new wa.a(this);
            d0.m = s.a;
            j j0 = this.E1;
            if(j0 != null) {
                d0.n.j = j0;
            }
            if(this.l1 != null && !this.n1.equals(q.c)) {
                this.i1.h(this.l1, this.n1);
            }
            this.i1.g(this.q1);
            this.i1.i(this.e0);
            List list0 = this.k1;
            if(list0 != null) {
                this.i1.k(list0);
            }
            ((l)this.i1.n.f.a).e = z1;
            return;
        }
        r r1 = this.g;
        r1.getClass();
        l0.l = r1;
        l0.e = z1;
    }

    @Override  // o3.p
    public final void n(long v, boolean z) {
        z3.d d0 = this.i1;
        if(d0 != null) {
            d0.a(true);
            this.i1.j(this.U0.b, this.U0.c, -this.F1, this.l);
            this.H1 = true;
        }
        super.n(v, z);
        l l0 = this.d1;
        if(this.i1 == null) {
            l0.b.m = 0L;
            l0.b.p = -1L;
            l0.b.n = -1L;
            l0.h = 0x8000000000000001L;
            l0.f = 0x8000000000000001L;
            l0.d(1);
            l0.i = 0x8000000000000001L;
        }
        if(z) {
            z3.d d1 = this.i1;
            if(d1 == null) {
                l0.c(false);
            }
            else {
                d1.d(false);
            }
        }
        this.A0();
        this.t1 = 0;
    }

    // 去混淆评级： 低(30)
    @Override  // o3.p
    public final boolean n0(m m0) {
        return this.l1 != null && this.l1.isValid() || this.C0(m0);
    }

    @Override  // androidx.media3.exoplayer.e
    public final void o() {
        z3.d d0 = this.i1;
        if(d0 != null && this.Z0) {
            z3.g g0 = d0.n;
            if(g0.n != 2) {
                t t0 = g0.k;
                if(t0 != null) {
                    t0.a.removeCallbacksAndMessages(null);
                }
                g0.l = null;
                g0.n = 2;
            }
        }
    }

    // 去混淆评级： 低(40)
    @Override  // o3.p
    public final boolean o0(e e0) {
        return e0.i(0x4000000) && !this.h() && !e0.i(0x20000000) && (this.G1 != 0x8000000000000001L && this.G1 - (e0.g - this.U0.c) > 100000L && !e0.i(0x40000000) && e0.g < this.l);
    }

    @Override  // androidx.media3.exoplayer.e
    public final void p() {
        int v;
        try {
            v = FIN.finallyOpen$NT();
            this.D();
            this.h0();
            FIN.finallyCodeBegin$NT(v);
            k3.h h0 = this.Z;
            if(h0 != null) {
                h0.d(null);
            }
        }
        catch(Throwable throwable0) {
            this.j1 = false;
            this.F1 = 0x8000000000000001L;
            PlaceholderSurface placeholderSurface0 = this.m1;
            if(placeholderSurface0 != null) {
                placeholderSurface0.release();
                this.m1 = null;
            }
            throw throwable0;
        }
        this.Z = null;
        FIN.finallyCodeEnd$NT(v);
        this.j1 = false;
        this.F1 = 0x8000000000000001L;
        PlaceholderSurface placeholderSurface1 = this.m1;
        if(placeholderSurface1 != null) {
            placeholderSurface1.release();
            this.m1 = null;
        }
    }

    @Override  // androidx.media3.exoplayer.e
    public final void q() {
        this.s1 = 0;
        this.g.getClass();
        this.r1 = SystemClock.elapsedRealtime();
        this.v1 = 0L;
        this.w1 = 0;
        z3.d d0 = this.i1;
        if(d0 != null) {
            ((l)d0.n.f.a).e();
            return;
        }
        this.d1.e();
    }

    @Override  // o3.p
    public final int q0(h h0, androidx.media3.common.b b0) {
        int v = 0;
        if(!H.k(b0.n)) {
            return 0x80;
        }
        boolean z = b0.r != null;
        Context context0 = this.Y0;
        List list0 = b.w0(context0, h0, b0, z, false);
        if(z && list0.isEmpty()) {
            list0 = b.w0(context0, h0, b0, false, false);
        }
        if(list0.isEmpty()) {
            return 0x81;
        }
        if(b0.L != 0 && b0.L != 2) {
            return 130;
        }
        boolean z1 = true;
        m m0 = (m)list0.get(0);
        boolean z2 = m0.d(b0);
        if(!z2) {
            for(int v1 = 1; v1 < list0.size(); ++v1) {
                m m1 = (m)list0.get(v1);
                if(m1.d(b0)) {
                    z1 = false;
                    z2 = true;
                    m0 = m1;
                    break;
                }
            }
        }
        int v2 = m0.e(b0) ? 16 : 8;
        int v3 = m0.g ? 0x40 : 0;
        int v4 = z1 ? 0x80 : 0;
        if("video/dolby-vision".equals(b0.n) && !e1.x.B(context0)) {
            v4 = 0x100;
        }
        if(z2) {
            List list1 = b.w0(context0, h0, b0, z, true);
            if(!list1.isEmpty()) {
                ArrayList arrayList0 = new ArrayList(list1);
                Collections.sort(arrayList0, new D(new n(b0, 4), 4));
                m m2 = (m)arrayList0.get(0);
                if(m2.d(b0) && m2.e(b0)) {
                    v = 0x20;
                }
            }
        }
        return (z2 ? 4 : 3) | v2 | v | v3 | v4;
    }

    @Override  // androidx.media3.exoplayer.e
    public final void r() {
        this.z0();
        int v = this.w1;
        if(v != 0) {
            long v1 = this.v1;
            ea.b b0 = this.a1;
            Handler handler0 = (Handler)b0.a;
            if(handler0 != null) {
                handler0.post(new o(b0, v1, v));
            }
            this.v1 = 0L;
            this.w1 = 0;
        }
        z3.d d0 = this.i1;
        if(d0 != null) {
            ((l)d0.n.f.a).f();
            return;
        }
        this.d1.f();
    }

    @Override  // o3.p
    public final void s(androidx.media3.common.b[] arr_b, long v, long v1, z z0) {
        super.s(arr_b, v, v1, z0);
        if(this.F1 == 0x8000000000000001L) {
            this.F1 = v;
        }
        b3.p0 p00 = this.r;
        if(p00.p()) {
            this.G1 = 0x8000000000000001L;
            return;
        }
        z0.getClass();
        m0 m00 = new m0();
        this.G1 = p00.g(z0.a, m00).d;
    }

    @Override  // o3.p
    public final void u(long v, long v1) {
        super.u(v, v1);
        z3.d d0 = this.i1;
        if(d0 != null) {
            try {
                d0.f(v, v1);
            }
            catch(z3.q q0) {
                throw this.d(q0, q0.a, false, 7001);
            }
        }
    }

    public static boolean u0(String s) {
        boolean z = false;
        if(s.startsWith("OMX.google")) {
            return false;
        }
        synchronized(b.class) {
            if(!b.J1) {
                x.d.getClass();
                switch(x.d) {
                    case "AFTA": {
                        z = true;
                        break;
                    }
                    case "AFTEU011": {
                        z = true;
                        break;
                    }
                    case "AFTEU014": {
                        z = true;
                        break;
                    }
                    case "AFTEUFF014": {
                        z = true;
                        break;
                    }
                    case "AFTJMST12": {
                        z = true;
                        break;
                    }
                    case "AFTKMST12": {
                        z = true;
                        break;
                    }
                    case "AFTN": {
                        z = true;
                        break;
                    }
                    case "AFTR": {
                        z = true;
                        break;
                    }
                    case "AFTSO001": {
                        z = true;
                    }
                }
                b.K1 = z;
                b.J1 = true;
            }
            return b.K1;
        }
    }

    public static int v0(m m0, androidx.media3.common.b b0) {
        int v = b0.u;
        int v1 = b0.v;
        if(v != -1 && v1 != -1) {
            String s = b0.n;
            s.getClass();
            if("video/dolby-vision".equals(s)) {
                Pair pair0 = v.d(b0);
                if(pair0 == null) {
                    s = "video/hevc";
                }
                else {
                    switch(((int)(((Integer)pair0.first)))) {
                        case 1: 
                        case 2: 
                        case 0x200: {
                            s = "video/avc";
                            break;
                        }
                        default: {
                            s = "video/hevc";
                        }
                    }
                }
            }
            switch(s) {
                case "video/3gpp": {
                    return v * v1 * 3 / 4;
                }
                case "video/av01": {
                    return v * v1 * 3 / 4;
                }
                case "video/avc": {
                    return "BRAVIA 4K 2015".equals(x.d) || "Amazon".equals(x.c) && ("KFSOWI".equals(x.d) || "AFTS".equals(x.d) && m0.f) ? -1 : (v1 + 15) / 16 * ((v + 15) / 16) * 0x300 / 4;
                }
                case "video/hevc": {
                    return Math.max(0x200000, v * v1 * 3 / 4);
                }
                case "video/mp4v-es": {
                    return v * v1 * 3 / 4;
                }
                case "video/x-vnd.on2.vp8": {
                    return v * v1 * 3 / 4;
                }
                case "video/x-vnd.on2.vp9": {
                    return v * v1 * 3 / 8;
                }
                default: {
                    return -1;
                }
            }
        }
        return -1;
    }

    public static List w0(Context context0, h h0, androidx.media3.common.b b0, boolean z, boolean z1) {
        List list0;
        String s = b0.n;
        if(s == null) {
            return p0.e;
        }
        if("video/dolby-vision".equals(s) && !e1.x.B(context0)) {
            String s1 = v.b(b0);
            if(s1 == null) {
                list0 = p0.e;
            }
            else {
                h0.getClass();
                list0 = v.e(s1, z, z1);
            }
            if(!list0.isEmpty()) {
                return list0;
            }
        }
        return v.g(h0, b0, z, z1);
    }

    @Override  // o3.p
    public final void x(float f, float f1) {
        super.x(f, f1);
        z3.d d0 = this.i1;
        if(d0 != null) {
            d0.i(f);
            return;
        }
        this.d1.h(f);
    }

    public static int x0(m m0, androidx.media3.common.b b0) {
        List list0 = b0.q;
        if(b0.o != -1) {
            int v = list0.size();
            int v2 = 0;
            for(int v1 = 0; v1 < v; ++v1) {
                v2 += ((byte[])list0.get(v1)).length;
            }
            return b0.o + v2;
        }
        return b.v0(m0, b0);
    }

    public final Surface y0(m m0) {
        boolean z = false;
        if(this.i1 == null) {
            Surface surface0 = this.l1;
            if(surface0 != null) {
                return surface0;
            }
            e3.b.j(this.C0(m0));
            PlaceholderSurface placeholderSurface0 = this.m1;
            if(placeholderSurface0 != null && placeholderSurface0.a != m0.f && placeholderSurface0 != null) {
                placeholderSurface0.release();
                this.m1 = null;
            }
            if(this.m1 == null) {
                e3.b.j(!m0.f || PlaceholderSurface.a(this.Y0));
                Fd fd0 = new Fd("ExoPlayer:PlaceholderSurface", 1);
                int v = m0.f ? PlaceholderSurface.d : 0;
                fd0.start();
                Handler handler0 = new Handler(fd0.getLooper(), fd0);
                fd0.b = handler0;
                fd0.e = new e3.g(handler0);
                synchronized(fd0) {
                    fd0.b.obtainMessage(1, v, 0).sendToTarget();
                    while(((PlaceholderSurface)fd0.f) == null && fd0.d == null && fd0.c == null) {
                        try {
                            fd0.wait();
                        }
                        catch(InterruptedException unused_ex) {
                            z = true;
                        }
                    }
                }
                if(z) {
                    Thread.currentThread().interrupt();
                }
                RuntimeException runtimeException0 = fd0.d;
                if(runtimeException0 != null) {
                    throw runtimeException0;
                }
                Error error0 = fd0.c;
                if(error0 != null) {
                    throw error0;
                }
                PlaceholderSurface placeholderSurface1 = (PlaceholderSurface)fd0.f;
                placeholderSurface1.getClass();
                this.m1 = placeholderSurface1;
                return this.m1;
            }
            return this.m1;
        }
        e3.b.j(false);
        e3.b.k(null);
        throw null;
    }

    public final void z0() {
        if(this.s1 > 0) {
            this.g.getClass();
            long v = SystemClock.elapsedRealtime();
            long v1 = v - this.r1;
            int v2 = this.s1;
            ea.b b0 = this.a1;
            Handler handler0 = (Handler)b0.a;
            if(handler0 != null) {
                handler0.post(new o(b0, v2, v1));
            }
            this.s1 = 0;
            this.r1 = v;
        }
    }
}

