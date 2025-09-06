package i.n.i.b.a.s.e;

import Q0.D;
import W.p;
import Y0.d;
import android.app.UiModeManager;
import android.content.Context;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import com.iloen.melon.fragments.radio.a;
import d5.i;
import ea.b;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jeb.synthetic.FIN;
import k8.Y;

public final class od extends oa implements S9 {
    public final Context n1;
    public final p o1;
    public final ub p1;
    public int q1;
    public boolean r1;
    public u s1;
    public long t1;
    public boolean u1;
    public boolean v1;
    public boolean w1;
    public C9 x1;
    public boolean y1;
    public int z1;

    public od(Context context0, Handler handler0, W6 w60, ub ub0, Gd gd0) {
        super(context0, 1, 44100.0f, gd0);
        this.n1 = context0.getApplicationContext();
        this.p1 = ub0;
        p p0 = new p();  // 初始化器: Ljava/lang/Object;-><init>()V
        p0.a = handler0;
        p0.b = w60;
        this.o1 = p0;
        ub0.o = new Ga(this, 6);
        this.y1 = false;
        this.z1 = 0;
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final void F() {
        this.p1.D = true;
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final float H(float f, u[] arr_u) {
        int v1 = -1;
        for(int v = 0; v < arr_u.length; ++v) {
            int v2 = arr_u[v].T;
            if(v2 != -1) {
                v1 = Math.max(v1, v2);
            }
        }
        return v1 == -1 ? -1.0f : ((float)v1) * f;
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final int I(Ma ma0, u u0) {
        if(!mb.h(u0.l)) {
            return 0;
        }
        int v = L7.a < 21 ? 0 : 0x20;
        boolean z = u0.Z != null;
        boolean z1 = u0.Z == null || T5.class.equals(u0.Z);
        ub ub0 = this.p1;
        if(z1 && ub0.j(u0) != 0) {
            if(!z) {
                return 12 | v;
            }
            List list0 = Cb.g("audio/raw", false, false);
            if((list0.isEmpty() ? null : ((K9)list0.get(0))) != null) {
                return 12 | v;
            }
        }
        if(!"audio/raw".equals(u0.l) || ub0.j(u0) != 0) {
            ob ob0 = new ob();
            ob0.k = "audio/raw";
            ob0.x = u0.S;
            ob0.y = u0.T;
            ob0.z = 2;
            if(ub0.j(new u(ob0)) != 0) {
                List list1 = this.N(ma0, u0, false);
                if(!list1.isEmpty()) {
                    if(!z1) {
                        return 2;
                    }
                    K9 k90 = (K9)list1.get(0);
                    boolean z2 = k90.f(u0);
                    int v1 = !z2 || !k90.g(u0) ? 8 : 16;
                    return z2 ? v1 | 4 | v : v1 | 3 | v;
                }
            }
        }
        return 1;
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final i J(K9 k90, u u0, MediaCrypto mediaCrypto0, float f) {
        u[] arr_u = this.g;
        arr_u.getClass();
        int v = this.q0(k90, u0);
        if(arr_u.length != 1) {
            for(int v1 = 0; v1 < arr_u.length; ++v1) {
                u u1 = arr_u[v1];
                if(k90.a(u0, u1).d != 0) {
                    v = Math.max(v, this.q0(k90, u1));
                }
            }
        }
        this.q1 = v;
        int v2 = L7.a;
        this.r1 = v2 < 24 && "OMX.SEC.aac.dec".equals(k90.a) && "samsung".equals(L7.d) && (L7.c.startsWith("zeroflte") || L7.c.startsWith("herolte") || L7.c.startsWith("heroqlte"));
        int v3 = this.q1;
        MediaFormat mediaFormat0 = new MediaFormat();
        mediaFormat0.setString("mime", k90.c);
        String s = u0.l;
        mediaFormat0.setInteger("channel-count", u0.S);
        int v4 = u0.T;
        mediaFormat0.setInteger("sample-rate", v4);
        M7.r(mediaFormat0, u0.n);
        M7.q(mediaFormat0, "max-input-size", v3);
        if(v2 >= 23) {
            mediaFormat0.setInteger("priority", 0);
            if(f != -1.0f && (v2 != 23 || !"ZTE B2017G".equals(L7.e) && !"AXON 7 mini".equals(L7.e))) {
                mediaFormat0.setFloat("operating-rate", f);
            }
        }
        if(v2 <= 28 && "audio/ac4".equals(s)) {
            mediaFormat0.setInteger("ac4-is-sync", 1);
        }
        if(v2 >= 24) {
            ob ob0 = new ob();
            ob0.k = "audio/raw";
            ob0.x = u0.S;
            ob0.y = v4;
            ob0.z = 4;
            u u2 = new u(ob0);
            if(this.p1.j(u2) == 2) {
                mediaFormat0.setInteger("pcm-encoding", 4);
            }
        }
        if(!"audio/raw".equals(k90.b) || "audio/raw".equals(s)) {
            u0 = null;
        }
        this.s1 = u0;
        return new i(k90, mediaFormat0, null, mediaCrypto0);
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final H9 L(b b0) {
        H9 h90 = super.L(b0);
        u u0 = (u)b0.b;
        p p0 = this.o1;
        Handler handler0 = (Handler)p0.a;
        if(handler0 != null) {
            handler0.post(new I2(p0, u0, h90, 3));
        }
        return h90;
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final H9 M(K9 k90, u u0, u u1) {
        H9 h90 = k90.a(u0, u1);
        int v = this.q0(k90, u1) <= this.q1 ? h90.e : h90.e | 0x40;
        return v == 0 ? new H9(k90.a, u0, u1, h90.d, 0) : new H9(k90.a, u0, u1, 0, v);
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final List N(Ma ma0, u u0, boolean z) {
        String s = u0.l;
        if(s == null) {
            return Collections.EMPTY_LIST;
        }
        if(this.p1.j(u0) != 0) {
            List list0 = Cb.g("audio/raw", false, false);
            K9 k90 = list0.isEmpty() ? null : ((K9)list0.get(0));
            if(k90 != null) {
                return Collections.singletonList(k90);
            }
        }
        ma0.getClass();
        ArrayList arrayList0 = new ArrayList(Cb.g(s, z, false));
        Collections.sort(arrayList0, new D(new a(u0, 24), 1));
        if("audio/eac3-joc".equals(s)) {
            ArrayList arrayList1 = new ArrayList(arrayList0);
            arrayList1.addAll(Cb.g("audio/eac3", z, false));
            arrayList0 = arrayList1;
        }
        return Collections.unmodifiableList(arrayList0);
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final void O(long v, String s, long v1) {
        p p0 = this.o1;
        Handler handler0 = (Handler)p0.a;
        if(handler0 != null) {
            handler0.post(new com.google.android.exoplayer2.audio.a(p0, s, v, v1, 3));
        }
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final void T(u u0, MediaFormat mediaFormat0) {
        u u1 = this.s1;
        int[] arr_v = null;
        if(u1 != null) {
            u0 = u1;
        }
        else if(this.f0 != null) {
            int v = u0.S;
            int v1 = u0.V;
            if(!"audio/raw".equals(u0.l)) {
                if(L7.a >= 24 && mediaFormat0.containsKey("pcm-encoding")) {
                    v1 = mediaFormat0.getInteger("pcm-encoding");
                }
                else if(mediaFormat0.containsKey("v-bits-per-sample")) {
                    v1 = L7.u(mediaFormat0.getInteger("v-bits-per-sample"));
                }
                else if(!"audio/raw".equals(u0.l)) {
                    v1 = 2;
                }
            }
            ob ob0 = new ob();
            ob0.k = "audio/raw";
            ob0.z = v1;
            ob0.A = u0.W;
            ob0.B = u0.X;
            ob0.x = mediaFormat0.getInteger("channel-count");
            ob0.y = mediaFormat0.getInteger("sample-rate");
            u0 = new u(ob0);
            if(this.r1 && u0.S == 6 && v < 6) {
                arr_v = new int[v];
                for(int v2 = 0; v2 < v; ++v2) {
                    arr_v[v2] = v2;
                }
            }
        }
        try {
            this.p1.e(u0, arr_v);
        }
        catch(s7 s70) {
            throw this.h(s70, s70.a, false);
        }
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final void U(IllegalStateException illegalStateException0) {
        M7.H("MediaCodecAudioRenderer", "Audio codec error", illegalStateException0);
        p p0 = this.o1;
        Handler handler0 = (Handler)p0.a;
        if(handler0 != null) {
            handler0.post(new P3(3, p0, illegalStateException0));
        }
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final boolean V(long v, long v1, W7 w70, ByteBuffer byteBuffer0, int v2, int v3, int v4, long v5, boolean z, boolean z1, u u0) {
        byteBuffer0.getClass();
        if(this.s1 != null && (v3 & 2) != 0) {
            w70.getClass();
            w70.j(v2, false);
            return true;
        }
        ub ub0 = this.p1;
        if(z) {
            if(w70 != null) {
                w70.j(v2, false);
            }
            this.a1.getClass();
            ub0.D = true;
            return true;
        }
        try {
            if(ub0.g(v4, byteBuffer0, v5)) {
                goto label_18;
            }
            return false;
        }
        catch(t7 t70) {
            throw this.h(t70, t70.b, t70.a);
        }
        catch(u7 u70) {
            throw this.h(u70, u0, u70.b);
        }
    label_18:
        if(w70 != null) {
            w70.j(v2, false);
        }
        this.a1.getClass();
        return true;
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final void X(I8 i80) {
        if(this.u1 && !i80.f(0x80000000)) {
            if(Math.abs(i80.f - this.t1) > 500000L) {
                this.t1 = i80.f;
            }
            this.u1 = false;
        }
        if(!this.y1) {
            this.y1 = true;
            long v = i80.f;
            p p0 = this.o1;
            Handler handler0 = (Handler)p0.a;
            if(handler0 != null) {
                handler0.post(new U6(p0, v, 0));
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.d2
    public final void a(int v, Object object0) {
        int v1 = 0;
        ub ub0 = this.p1;
    alab1:
        switch(v) {
            case 2: {
                float f = (float)(((Float)object0));
                if(ub0.G != f || ub0.H != f) {
                    ub0.G = f;
                    ub0.H = f;
                    ub0.w();
                    return;
                }
                break;
            }
            case 3: {
                if(!ub0.s.equals(((I4)object0))) {
                    ub0.s = (I4)object0;
                    if(!ub0.W) {
                        ub0.o();
                        return;
                    }
                }
                break;
            }
            case 5: {
                if(!ub0.V.equals(((G9)object0))) {
                    ((G9)object0).getClass();
                    if(ub0.r != null) {
                        ub0.V.getClass();
                    }
                    ub0.V = (G9)object0;
                    return;
                }
                break;
            }
            case 101: {
                ub0.d(ub0.q().a, ((Boolean)object0).booleanValue());
                return;
            }
            case 102: {
                int v2 = (int)(((Integer)object0));
                if(ub0.U != v2) {
                    ub0.U = v2;
                    if(v2 != 0) {
                        v1 = 1;
                    }
                    ub0.T = v1;
                    ub0.o();
                    return;
                }
                break;
            }
            case 103: {
                this.x1 = (C9)object0;
                return;
            }
            case 10001: {
                float f1 = (float)(((Float)((Pair)object0).first));
                float f2 = (float)(((Float)((Pair)object0).second));
                if(ub0.G != f1 || ub0.H != f2) {
                    ub0.G = f1;
                    ub0.H = f2;
                    ub0.w();
                    return;
                }
                break;
            }
            case 10002: {
                Pair pair0 = (Pair)object0;
                A6[] arr_a6 = (A6[])ub0.b.b;
                while(true) {
                    if(v1 >= arr_a6.length) {
                        break alab1;
                    }
                    A6 a60 = arr_a6[v1];
                    ++v1;
                }
            }
        }
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final void b() {
        p p0;
        try {
            p0 = this.o1;
            this.w1 = true;
            this.p1.o();
        }
        catch(Throwable unused_ex) {
            try {
                super.b();
            }
            throw throwable0;
        }
        finally {
            p0.c(this.a1);
        }
        super.b();
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final void b0() {
        try {
            ub ub0 = this.p1;
            if(!ub0.Q && ub0.u() && ub0.n()) {
                ub0.v();
                ub0.Q = true;
            }
        }
        catch(u7 u70) {
            throw this.h(u70, u70.c, u70.b);
        }
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final void c() {
        ub ub0;
        int v;
        try {
            v = FIN.finallyOpen$NT();
            ub0 = this.p1;
            this.y();
            this.W();
            FIN.finallyCodeBegin$NT(v);
            b1 b10 = this.Y;
            if(b10 != null) {
                b10.a(null);
            }
        }
        catch(Throwable throwable0) {
            if(this.w1) {
                this.w1 = false;
                ub0.i();
            }
            throw throwable0;
        }
        this.Y = null;
        FIN.finallyCodeEnd$NT(v);
        if(this.w1) {
            this.w1 = false;
            ub0.i();
        }
    }

    @Override  // i.n.i.b.a.s.e.d2
    public final void d() {
        if(this.w0) {
            this.j1 = true;
        }
        ub ub0 = this.p1;
        ub0.S = true;
        if(ub0.u()) {
            Q7 q70 = ub0.i.f;
            q70.getClass();
            q70.b();
            ub0.r.play();
        }
    }

    // 去混淆评级： 低(20)
    @Override  // i.n.i.b.a.s.e.S9
    public final x6 e() {
        return this.p1.k ? this.p1.v : this.p1.q().a;
    }

    @Override  // i.n.i.b.a.s.e.S9
    public final void e(x6 x60) {
        ub ub0 = this.p1;
        ub0.getClass();
        x6 x61 = new x6(L7.a(x60.a, 0.1f, 8.0f), L7.a(x60.b, 0.1f, 8.0f));
        if(ub0.k && L7.a >= 23) {
            ub0.l(x61);
            return;
        }
        ub0.d(x61, ub0.q().b);
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final boolean e0(u u0) {
        return this.p1.j(u0) != 0;
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final void k(long v, boolean z) {
        super.k(v, z);
        this.p1.o();
        this.t1 = v;
        this.u1 = true;
        this.v1 = true;
    }

    @Override  // i.n.i.b.a.s.e.d2
    public final void l(boolean z, boolean z1) {
        Nf.p p0 = new Nf.p();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.a1 = p0;
        p p1 = this.o1;
        Handler handler0 = (Handler)p1.a;
        if(handler0 != null) {
            handler0.post(new V6(p1, p0, 0));
        }
        Ha ha0 = this.c;
        ha0.getClass();
        boolean z2 = false;
        ub ub0 = this.p1;
        if(ha0.a) {
            ub0.getClass();
            if(L7.a >= 21) {
                z2 = true;
            }
            M7.J(z2);
            M7.J(ub0.T);
            if(!ub0.W) {
                ub0.W = true;
                ub0.o();
            }
        }
        else if(ub0.W) {
            ub0.W = false;
            ub0.o();
        }
    }

    @Override  // i.n.i.b.a.s.e.oa
    public final void n0(String s) {
        p p0 = this.o1;
        Handler handler0 = (Handler)p0.a;
        if(handler0 != null) {
            handler0.post(new P3(5, p0, s));
        }
    }

    @Override  // i.n.i.b.a.s.e.d2
    public final void o(boolean z) {
        this.r0();
        ub ub0 = this.p1;
        ub0.S = false;
        if(ub0.u()) {
            G8 g80 = ub0.i;
            g80.l = 0L;
            g80.w = 0;
            g80.v = 0;
            g80.m = 0L;
            g80.C = 0L;
            g80.F = 0L;
            g80.k = false;
            if(g80.x == 0x8000000000000001L) {
                Q7 q70 = g80.f;
                q70.getClass();
                q70.b();
                ub0.r.pause();
            }
        }
        if(this.w0 && !this.x()) {
            this.j1 = false;
        }
    }

    // 去混淆评级： 低(40)
    @Override  // i.n.i.b.a.s.e.oa
    public final boolean p() {
        return this.W0 && (!this.p1.u() || this.p1.Q && !this.p1.p());
    }

    // 去混淆评级： 低(20)
    @Override  // i.n.i.b.a.s.e.oa
    public final boolean q() {
        return this.p1.p() || super.q();
    }

    public final int q0(K9 k90, u u0) {
        if("OMX.google.raw.decoder".equals(k90.a)) {
            int v = L7.a;
            if(v < 24) {
                if(v == 23) {
                    UiModeManager uiModeManager0 = (UiModeManager)this.n1.getApplicationContext().getSystemService("uimode");
                    return uiModeManager0 != null && uiModeManager0.getCurrentModeType() == 4 ? u0.m : -1;
                }
                return -1;
            }
        }
        return u0.m;
    }

    @Override  // i.n.i.b.a.s.e.d2
    public final String r() {
        return "MediaCodecAudioRenderer";
    }

    public final void r0() {
        long v26;
        long v25;
        long v20;
        long v12;
        boolean z1;
        ub ub2;
        boolean z = this.p();
        ub ub0 = this.p1;
        sa sa0 = ub0.b;
        if(!ub0.u() || ub0.E) {
            v26 = 0x8000000000000000L;
        }
        else {
            G8 g80 = ub0.i;
            ub ub1 = (ub)g80.a.b;
            AudioTrack audioTrack0 = g80.c;
            audioTrack0.getClass();
            if(audioTrack0.getPlayState() == 3) {
                long[] arr_v = g80.b;
                long v = g80.a() * 1000000L / ((long)g80.g);
                if(v == 0L) {
                    ub2 = ub1;
                }
                else {
                    long v1 = System.nanoTime();
                    ub2 = ub1;
                    if(v1 / 1000L - g80.m >= 30000L) {
                        int v2 = g80.v;
                        arr_v[v2] = v - v1 / 1000L;
                        g80.v = (v2 + 1) % 10;
                        int v3 = g80.w;
                        if(v3 < 10) {
                            g80.w = v3 + 1;
                        }
                        g80.m = v1 / 1000L;
                        g80.l = 0L;
                        for(int v4 = 0; true; ++v4) {
                            int v5 = g80.w;
                            if(v4 >= v5) {
                                break;
                            }
                            g80.l = arr_v[v4] / ((long)v5) + g80.l;
                        }
                    }
                    if(!g80.h) {
                        Q7 q70 = g80.f;
                        q70.getClass();
                        d d0 = (d)q70.f;
                        if(d0 == null) {
                            z1 = false;
                        }
                        else {
                            long v6 = v1 / 1000L - q70.d;
                            AudioTimestamp audioTimestamp0 = (AudioTimestamp)d0.e;
                            if(v6 >= q70.c) {
                                q70.d = v1 / 1000L;
                                z1 = ((AudioTrack)d0.d).getTimestamp(audioTimestamp0);
                                if(z1) {
                                    long v7 = audioTimestamp0.framePosition;
                                    if(d0.b > v7) {
                                        ++d0.a;
                                    }
                                    d0.b = v7;
                                    d0.c = v7 + (d0.a << 0x20);
                                }
                                switch(q70.a) {
                                    case 0: {
                                        if(!z1) {
                                            if(v1 / 1000L - q70.b > 500000L) {
                                                q70.a(3);
                                            }
                                        }
                                        else if(audioTimestamp0.nanoTime / 1000L >= q70.b) {
                                            q70.e = d0.c;
                                            q70.a(1);
                                        }
                                        else {
                                            z1 = false;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        if(!z1) {
                                            q70.b();
                                        }
                                        else if(d0.c > q70.e) {
                                            q70.a(2);
                                        }
                                        break;
                                    }
                                    case 2: {
                                        if(!z1) {
                                            q70.b();
                                        }
                                        break;
                                    }
                                    case 3: {
                                        if(z1) {
                                            q70.b();
                                        }
                                        break;
                                    }
                                    case 4: {
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException();
                                    }
                                }
                            }
                            else {
                                z1 = false;
                            }
                        }
                        if(z1) {
                            long v8 = d0 == null ? 0x8000000000000001L : ((AudioTimestamp)d0.e).nanoTime / 1000L;
                            long v9 = d0 == null ? -1L : d0.c;
                            if(Long.compare(Math.abs(v8 - v1 / 1000L), 5000000L) > 0) {
                                StringBuilder stringBuilder0 = Y.o(v9, "Spurious audio timestamp (system clock mismatch): ", ", ");
                                stringBuilder0.append(v8);
                                com.iloen.melon.utils.a.s(v1 / 1000L, ", ", ", ", stringBuilder0);
                                stringBuilder0.append(v);
                                stringBuilder0.append(", ");
                                stringBuilder0.append(ub2.r());
                                stringBuilder0.append(", ");
                                stringBuilder0.append(ub2.s());
                                Log.w("DefaultAudioSink", stringBuilder0.toString());
                                q70.a(4);
                            }
                            else if(Math.abs(v9 * 1000000L / ((long)g80.g) - v) > 5000000L) {
                                StringBuilder stringBuilder1 = Y.o(v9, "Spurious audio timestamp (frame position mismatch): ", ", ");
                                stringBuilder1.append(v8);
                                com.iloen.melon.utils.a.s(v1 / 1000L, ", ", ", ", stringBuilder1);
                                stringBuilder1.append(v);
                                stringBuilder1.append(", ");
                                stringBuilder1.append(ub2.r());
                                stringBuilder1.append(", ");
                                stringBuilder1.append(ub2.s());
                                Log.w("DefaultAudioSink", stringBuilder1.toString());
                                q70.a(4);
                            }
                            else if(q70.a == 4) {
                                q70.b();
                            }
                        }
                        if(g80.q) {
                            Method method0 = g80.n;
                            if(method0 != null && v1 / 1000L - g80.r >= 500000L) {
                                try {
                                    AudioTrack audioTrack1 = g80.c;
                                    audioTrack1.getClass();
                                    long v10 = Math.max(((long)(((int)(((Integer)method0.invoke(audioTrack1, null)))))) * 1000L - g80.i, 0L);
                                    g80.o = v10;
                                    if(v10 > 5000000L) {
                                        Log.w("DefaultAudioSink", "Ignoring impossibly large audio latency: " + v10);
                                        g80.o = 0L;
                                    }
                                }
                                catch(Exception unused_ex) {
                                    g80.n = null;
                                }
                                g80.r = v1 / 1000L;
                            }
                        }
                    }
                }
            }
            else {
                ub2 = ub1;
            }
            long v11 = System.nanoTime();
            Q7 q71 = g80.f;
            q71.getClass();
            boolean z2 = q71.a == 2;
            if(z2) {
                d d1 = (d)q71.f;
                v12 = L7.i(v11 / 1000L - (d1 == null ? 0x8000000000000001L : ((AudioTimestamp)d1.e).nanoTime / 1000L), g80.j) + (d1 == null ? -1L : d1.c) * 1000000L / ((long)g80.g);
            }
            else {
                v12 = g80.w == 0 ? g80.a() * 1000000L / ((long)g80.g) : g80.l + v11 / 1000L;
                if(!z) {
                    v12 = Math.max(0L, v12 - g80.o);
                }
            }
            if(g80.D != z2) {
                g80.F = g80.C;
                g80.E = g80.B;
            }
            long v13 = v11 / 1000L - g80.F;
            if(v13 < 1000000L) {
                long v14 = v13 * 1000L / 1000000L;
                v12 = ((1000L - v14) * (L7.i(v13, g80.j) + g80.E) + v12 * v14) / 1000L;
            }
            if(!g80.k) {
                long v15 = g80.B;
                if(v12 > v15) {
                    g80.k = true;
                    long v16 = System.currentTimeMillis();
                    long v17 = b4.b(L7.z(b4.b(v12 - v15), g80.j));
                    Ga ga0 = ub2.o;
                    if(ga0 != null) {
                        p p0 = ((od)ga0.b).o1;
                        Handler handler0 = (Handler)p0.a;
                        if(handler0 != null) {
                            handler0.post(new U6(p0, v16 - v17, 1));
                        }
                    }
                }
            }
            g80.C = v11 / 1000L;
            g80.B = v12;
            g80.D = z2;
            qb qb0 = ub0.q;
            long v18 = Math.min(v12, ub0.s() * 1000000L / ((long)qb0.d));
            ArrayDeque arrayDeque0 = ub0.j;
            while(!arrayDeque0.isEmpty() && v18 >= ((sb)arrayDeque0.getFirst()).d) {
                ub0.u = (sb)arrayDeque0.remove();
            }
            long v19 = v18 - ub0.u.d;
            if(ub0.u.a.equals(x6.d)) {
                v20 = ub0.u.c + v19;
            }
            else if(arrayDeque0.isEmpty()) {
                Z0 z00 = (Z0)sa0.d;
                if(z00.o >= 0x400L) {
                    long v21 = z00.n;
                    l0 l00 = z00.j;
                    l00.getClass();
                    long v22 = v21 - ((long)(l00.k * l00.b * 2));
                    int v23 = z00.h.a;
                    int v24 = z00.g.a;
                    v25 = v23 == v24 ? L7.C(v19, v22, z00.o) : L7.C(v19, v22 * ((long)v23), z00.o * ((long)v24));
                }
                else {
                    v25 = (long)(((double)z00.c) * ((double)v19));
                }
                v20 = v25 + ub0.u.c;
            }
            else {
                sb sb0 = (sb)arrayDeque0.getFirst();
                v20 = sb0.c - L7.i(sb0.d - v18, ub0.u.a.a);
            }
            v26 = ((O)sa0.c).t * 1000000L / ((long)ub0.q.d) + v20;
        }
        if(v26 != 0x8000000000000000L) {
            if(!this.v1) {
                v26 = Math.max(this.t1, v26);
            }
            this.t1 = v26;
            this.v1 = false;
        }
    }

    @Override  // i.n.i.b.a.s.e.S9
    public final long t() {
        if(this.e == 2) {
            this.r0();
        }
        return this.t1 + ((long)this.z1);
    }

    @Override  // i.n.i.b.a.s.e.d2
    public final S9 u() {
        return this;
    }
}

