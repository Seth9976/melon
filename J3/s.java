package j3;

import B3.N;
import B3.c;
import I6.Q;
import I6.S;
import I6.p0;
import I6.w;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.exoplayer.C;
import androidx.media3.exoplayer.audio.DefaultAudioOffloadSupportProvider;
import androidx.media3.exoplayer.audio.DefaultAudioSink.Builder;
import androidx.media3.session.legacy.V;
import b3.H;
import b3.L;
import b3.d;
import b3.e;
import c3.a;
import c3.g;
import c3.h;
import e3.x;
import i.n.i.b.a.s.e.Ga;
import i.n.i.b.a.s.e.Q7;
import i.n.i.b.a.s.e.tb;
import i.n.i.b.a.s.e.v7;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import k8.Y;

public final class s {
    public p A;
    public p B;
    public L C;
    public boolean D;
    public ByteBuffer E;
    public int F;
    public long G;
    public long H;
    public long I;
    public long J;
    public int K;
    public boolean L;
    public boolean M;
    public long N;
    public float O;
    public ByteBuffer P;
    public int Q;
    public ByteBuffer R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public int X;
    public e Y;
    public Ga Z;
    public final Context a;
    public boolean a0;
    public final V b;
    public long b0;
    public final m c;
    public long c0;
    public final y d;
    public boolean d0;
    public final p0 e;
    public boolean e0;
    public final p0 f;
    public Looper f0;
    public final l g;
    public long g0;
    public final ArrayDeque h;
    public long h0;
    public final boolean i;
    public Handler i0;
    public int j;
    public static final Object j0;
    public y8.s k;
    public static ScheduledExecutorService k0;
    public final r l;
    public static int l0;
    public final r m;
    public final t n;
    public final DefaultAudioOffloadSupportProvider o;
    public final t p;
    public i3.l q;
    public Ga r;
    public o s;
    public o t;
    public a u;
    public AudioTrack v;
    public b w;
    public j3.e x;
    public d5.m y;
    public d z;

    static {
        s.j0 = new Object();
    }

    public s(DefaultAudioSink.Builder defaultAudioSink$Builder0) {
        this.a = defaultAudioSink$Builder0.a;
        this.z = d.g;
        this.w = defaultAudioSink$Builder0.a == null ? defaultAudioSink$Builder0.b : b.c(defaultAudioSink$Builder0.a, d.g, null);
        this.b = defaultAudioSink$Builder0.c;
        this.i = false;
        this.j = 0;
        this.n = defaultAudioSink$Builder0.e;
        DefaultAudioOffloadSupportProvider defaultAudioOffloadSupportProvider0 = defaultAudioSink$Builder0.g;
        defaultAudioOffloadSupportProvider0.getClass();
        this.o = defaultAudioOffloadSupportProvider0;
        this.g = new l(new Ga(this, 15));
        m m0 = new m();  // 初始化器: Lc3/e;-><init>()V
        this.c = m0;
        y y0 = new y();  // 初始化器: Lc3/e;-><init>()V
        y0.m = x.f;
        this.d = y0;
        Object[] arr_object = {new h(), m0, y0};  // 初始化器: Lc3/e;-><init>()V
        w.a(3, arr_object);
        this.e = I6.V.l(3, arr_object);
        this.f = I6.V.t(new j3.x());  // 初始化器: Lc3/e;-><init>()V
        this.O = 1.0f;
        this.X = 0;
        this.Y = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.B = new p(L.d, 0L, 0L);
        this.C = L.d;
        this.D = false;
        this.h = new ArrayDeque();
        this.l = new r();
        this.m = new r();
        this.p = defaultAudioSink$Builder0.f;
    }

    public final void a(long v) {
        boolean z;
        L l0;
        V v1 = this.b;
        if(this.x()) {
            l0 = L.d;
        }
        else {
            if(this.a0 || this.t.c != 0) {
                l0 = L.d;
            }
            else {
                l0 = this.C;
                g g0 = (g)v1.c;
                float f = l0.a;
                if(Float.compare(g0.c, f) != 0) {
                    g0.c = f;
                    g0.i = true;
                }
                float f1 = l0.b;
                if(g0.d != f1) {
                    g0.d = f1;
                    g0.i = true;
                }
            }
            this.C = l0;
        }
        if(this.a0 || this.t.c != 0) {
            z = false;
        }
        else {
            z = this.D;
            ((j3.w)v1.b).o = z;
        }
        this.D = z;
        o o0 = this.t;
        long v2 = this.k();
        p p0 = new p(l0, Math.max(0L, v), x.R(o0.e, v2));
        this.h.add(p0);
        this.u = this.t.i;
        this.t.i.a();
        Ga ga0 = this.r;
        if(ga0 != null) {
            boolean z1 = this.D;
            E9.g g1 = ((u)ga0.b).Z0;
            Handler handler0 = (Handler)g1.a;
            if(handler0 != null) {
                handler0.post(new I9.b(g1, z1, 4));
            }
        }
    }

    public final AudioTrack b(c c0, d d0, int v, androidx.media3.common.b b0) {
        AudioTrack audioTrack0;
        try {
            audioTrack0 = this.p.a(c0, d0, v);
        }
        catch(UnsupportedOperationException | IllegalArgumentException unsupportedOperationException0) {
            throw new i(0, c0.b, c0.c, c0.a, b0, c0.e, unsupportedOperationException0);
        }
        int v1 = audioTrack0.getState();
        if(v1 == 1) {
            return audioTrack0;
        }
        try {
            audioTrack0.release();
        }
        catch(Exception unused_ex) {
        }
        throw new i(v1, c0.b, c0.c, c0.a, b0, c0.e, null);
    }

    public final AudioTrack c(o o0) {
        try {
            return this.b(o0.a(), this.z, this.X, o0.a);
        }
        catch(i i0) {
            Ga ga0 = this.r;
            if(ga0 != null) {
                ga0.p(i0);
            }
            throw i0;
        }
    }

    public final void d(androidx.media3.common.b b0, int[] arr_v) {
        int v16;
        int v15;
        int v11;
        int v10;
        boolean z3;
        int v6;
        boolean z2;
        a a1;
        int v5;
        int v4;
        this.q();
        String s = b0.n;
        int v = b0.D;
        int v1 = b0.C;
        int v2 = b0.E;
        boolean z = this.i;
        if("audio/raw".equals(s)) {
            e3.b.c(x.H(v2));
            x.A(v2, v1);
            Q q0 = new Q(4);  // 初始化器: LI6/N;-><init>(I)V
            q0.d(this.e);
            q0.b(((c3.d[])this.b.a));
            boolean z1 = !new a(q0.g()).equals(this.u);
            this.d.i = b0.F;
            this.d.j = b0.G;
            this.c.i = arr_v;
            c3.b b1 = new c3.b(v, v1, v2);
            try {
                throw new c3.c(b1);
            }
            catch(c3.c c0) {
                throw new j3.h(c0, b0);
            }
        }
        a a0 = new a(p0.e);
        f f0 = this.j == 0 ? f.d : this.h(b0);
        if(this.j != 0 && f0.a) {
            s.getClass();
            int v3 = H.b(s, b0.k);
            v4 = 1;
            v5 = x.p(v1);
            a1 = a0;
            z2 = f0.b;
            v6 = v3;
            z3 = true;
        }
        else {
            Pair pair0 = this.w.d(b0, this.z);
            if(pair0 == null) {
                throw new j3.h("Unable to configure passthrough for: " + b0, b0);
            }
            int v7 = (int)(((Integer)pair0.first));
            z3 = z;
            v5 = (int)(((Integer)pair0.second));
            v6 = v7;
            a1 = a0;
            z2 = false;
            v4 = 2;
        }
        if(v6 == 0) {
            throw new j3.h("Invalid output encoding (mode=" + v4 + ") for: " + b0, b0);
        }
        if(v5 == 0) {
            throw new j3.h("Invalid output channel config (mode=" + v4 + ") for: " + b0, b0);
        }
        int v8 = !"audio/vnd.dts.hd;profile=lbr".equals(s) || b0.j != -1 ? b0.j : 768000;
        int v9 = AudioTrack.getMinBufferSize(v, v5, v6);
        e3.b.j(v9 != -2);
        this.n.getClass();
        if(v4 == 1) {
            v15 = v6;
            v16 = ye.a.t(50000000L * ((long)t.c(v15)) / 1000000L);
        }
        else {
            switch(v6) {
                case 5: {
                    v10 = 500000;
                    break;
                }
                case 8: {
                    v10 = 1000000;
                    break;
                }
                default: {
                    v10 = 250000;
                }
            }
            if(v8 == -1) {
                v11 = t.c(v6);
            }
            else {
                RoundingMode roundingMode0 = RoundingMode.CEILING;
                roundingMode0.getClass();
                v11 = v8 / 8;
                int v12 = v8 - 8 * v11;
                if(v12 != 0) {
                    int v13 = (v8 ^ 8) >> 0x1F | 1;
                    switch(K6.c.a[roundingMode0.ordinal()]) {
                        case 1: {
                            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
                        }
                        case 2: {
                            break;
                        }
                        case 3: {
                            if(v13 < 0) {
                                v11 += v13;
                            }
                            break;
                        }
                        case 4: {
                            v11 += v13;
                            break;
                        }
                        case 5: {
                            if(v13 > 0) {
                                v11 += v13;
                            }
                            break;
                        }
                        case 6: 
                        case 7: 
                        case 8: {
                            int v14 = Math.abs(v12) * 2 - 8;
                            if(v14 != 0 && v14 > 0) {
                                v11 += v13;
                            }
                            break;
                        }
                        default: {
                            throw new AssertionError();
                        }
                    }
                }
            }
            v15 = v6;
            v16 = ye.a.t(((long)v10) * ((long)v11) / 1000000L);
        }
        this.d0 = false;
        o o0 = new o(b0, -1, v4, -1, v, v5, v15, Math.max(v9, ((int)(((double)v16) * (z3 ? 8.0 : 1.0)))), a1, z3, z2, this.a0);
        if(this.o()) {
            this.s = o0;
            return;
        }
        this.t = o0;
    }

    public final void e(long v) {
        int v2;
        boolean z = false;
        r r0 = this.m;
        if(this.R != null && (r0.a == null || s.l0 <= 0 && SystemClock.elapsedRealtime() >= r0.c)) {
            int v1 = this.R.remaining();
            if(this.a0) {
                e3.b.j(v != 0x8000000000000001L);
                if(v == 0x8000000000000000L) {
                    v = this.b0;
                }
                else {
                    this.b0 = v;
                }
                v2 = this.v.write(this.R, v1, 1, 1000L * v);
            }
            else {
                v2 = this.v.write(this.R, v1, 1);
            }
            this.c0 = SystemClock.elapsedRealtime();
            if(v2 < 0) {
                if(v2 == 0xFFFFFFE0 || v2 == -6) {
                    if(this.k() > 0L) {
                        z = true;
                    }
                    else if(s.p(this.v)) {
                        if(this.t.c == 1) {
                            this.d0 = true;
                        }
                        z = true;
                    }
                }
                j j0 = new j(v2, this.t.a, z);
                Ga ga0 = this.r;
                if(ga0 != null) {
                    ga0.p(j0);
                }
                if(!j0.b) {
                    r0.a(j0);
                    return;
                }
                this.w = b.c;
                throw j0;
            }
            r0.a = null;
            r0.b = 0x8000000000000001L;
            r0.c = 0x8000000000000001L;
            if(s.p(this.v)) {
                if(this.J > 0L) {
                    this.e0 = false;
                }
                if(this.V) {
                    Ga ga1 = this.r;
                    if(ga1 != null && v2 < v1 && !this.e0) {
                        C c0 = ((u)ga1.b).b0;
                        if(c0 != null) {
                            c0.a.h0 = true;
                        }
                    }
                }
            }
            int v3 = this.t.c;
            if(v3 == 0) {
                this.I += (long)v2;
            }
            if(v2 == v1) {
                if(v3 != 0) {
                    if(this.R == this.P) {
                        z = true;
                    }
                    e3.b.j(z);
                    this.J = ((long)this.K) * ((long)this.Q) + this.J;
                }
                this.R = null;
            }
        }
    }

    public final boolean f() {
        if(!this.u.d()) {
            this.e(0x8000000000000000L);
            return this.R == null;
        }
        a a0 = this.u;
        if(a0.d() && !a0.d) {
            a0.d = true;
            ((c3.d)a0.b.get(0)).queueEndOfStream();
        }
        this.t(0x8000000000000000L);
        return this.u.c() && (this.R == null || !this.R.hasRemaining());
    }

    public final void g() {
        if(this.o()) {
            this.G = 0L;
            this.H = 0L;
            this.I = 0L;
            this.J = 0L;
            this.e0 = false;
            this.K = 0;
            this.B = new p(this.C, 0L, 0L);
            this.N = 0L;
            this.A = null;
            this.h.clear();
            this.P = null;
            this.Q = 0;
            this.R = null;
            this.T = false;
            this.S = false;
            this.U = false;
            this.E = null;
            this.F = 0;
            this.d.o = 0L;
            this.u = this.t.i;
            this.t.i.a();
            AudioTrack audioTrack0 = this.g.c;
            audioTrack0.getClass();
            if(audioTrack0.getPlayState() == 3) {
                this.v.pause();
            }
            if(s.p(this.v)) {
                y8.s s0 = this.k;
                s0.getClass();
                com.iloen.melon.utils.player.a.A(this.v, ((tb)s0.b));
                ((Handler)s0.a).removeCallbacksAndMessages(null);
            }
            c c0 = this.t.a();
            o o0 = this.s;
            if(o0 != null) {
                this.t = o0;
                this.s = null;
            }
            this.g.d();
            this.g.c = null;
            this.g.e = null;
            d5.m m0 = this.y;
            if(m0 != null) {
                AudioTrack audioTrack1 = (AudioTrack)m0.b;
                q q0 = (q)m0.d;
                q0.getClass();
                audioTrack1.removeOnRoutingChangedListener(q0);
                m0.d = null;
                this.y = null;
            }
            AudioTrack audioTrack2 = this.v;
            Ga ga0 = this.r;
            Handler handler0 = new Handler(Looper.myLooper());
            Object object0 = s.j0;
            synchronized(object0) {
                if(s.k0 == null) {
                    s.k0 = Executors.newSingleThreadScheduledExecutor(new e3.w());  // 初始化器: Ljava/lang/Object;-><init>()V
                }
                ++s.l0;
                s.k0.schedule(new D5.a(audioTrack2, ga0, handler0, c0, 25), 20L, TimeUnit.MILLISECONDS);
            }
            this.v = null;
        }
        this.m.a = null;
        this.m.b = 0x8000000000000001L;
        this.m.c = 0x8000000000000001L;
        this.l.a = null;
        this.l.b = 0x8000000000000001L;
        this.l.c = 0x8000000000000001L;
        this.g0 = 0L;
        this.h0 = 0L;
        Handler handler1 = this.i0;
        if(handler1 != null) {
            handler1.removeCallbacksAndMessages(null);
        }
    }

    public final f h(androidx.media3.common.b b0) {
        AudioFormat audioFormat0;
        boolean z1;
        if(this.d0) {
            return f.d;
        }
        d d0 = this.z;
        DefaultAudioOffloadSupportProvider defaultAudioOffloadSupportProvider0 = this.o;
        defaultAudioOffloadSupportProvider0.getClass();
        b0.getClass();
        int v = b0.D;
        d0.getClass();
        if(v != -1) {
            Context context0 = defaultAudioOffloadSupportProvider0.a;
            Boolean boolean0 = defaultAudioOffloadSupportProvider0.b;
            boolean z = false;
            if(boolean0 == null) {
                if(context0 == null) {
                    defaultAudioOffloadSupportProvider0.b = Boolean.FALSE;
                }
                else {
                    AudioManager audioManager0 = (AudioManager)context0.getSystemService("audio");
                    if(audioManager0 == null) {
                        defaultAudioOffloadSupportProvider0.b = Boolean.FALSE;
                    }
                    else {
                        String s = audioManager0.getParameters("offloadVariableRateSupported");
                        defaultAudioOffloadSupportProvider0.b = Boolean.valueOf(s != null && s.equals("offloadVariableRateSupported=1"));
                    }
                }
                z1 = defaultAudioOffloadSupportProvider0.b.booleanValue();
            }
            else {
                z1 = boolean0.booleanValue();
            }
            b0.n.getClass();
            int v1 = H.b(b0.n, b0.k);
            if(v1 != 0 && 33 >= x.n(v1)) {
                int v2 = x.p(b0.C);
                if(v2 == 0) {
                    return f.d;
                }
                try {
                    audioFormat0 = x.o(v, v2, v1);
                }
                catch(IllegalArgumentException unused_ex) {
                    return f.d;
                }
                int v3 = AudioManager.getPlaybackOffloadSupport(audioFormat0, ((AudioAttributes)d0.b().a));
                if(v3 == 0) {
                    return f.d;
                }
                V3.c c0 = new V3.c();  // 初始化器: Ljava/lang/Object;-><init>()V
                if(v3 == 2) {
                    z = true;
                }
                c0.a = true;
                c0.b = z;
                c0.c = z1;
                return c0.a();
            }
            return f.d;
        }
        return f.d;
    }

    public final int i(androidx.media3.common.b b0) {
        this.q();
        int v = b0.E;
        if("audio/raw".equals(b0.n)) {
            if(!x.H(v)) {
                com.iloen.melon.utils.a.r(v, "Invalid PCM encoding: ", "DefaultAudioSink");
                return 0;
            }
            return v == 2 ? 2 : 1;
        }
        return this.w.d(b0, this.z) == null ? 0 : 2;
    }

    public final long j() {
        return this.t.c == 0 ? this.G / ((long)this.t.b) : this.H;
    }

    public final long k() {
        return this.t.c == 0 ? (this.I + ((long)this.t.d) - 1L) / ((long)this.t.d) : this.J;
    }

    public final boolean l(int v, ByteBuffer byteBuffer0, long v1) {
        int v13;
        int v12;
        int v23;
        int v9;
        int v21;
        int v17;
        e3.b.c(this.P == null || byteBuffer0 == this.P);
        int v2 = 3;
        l l0 = this.g;
        if(this.s == null) {
        label_27:
            r r0 = this.l;
            if(!this.o()) {
                try {
                    if(!this.n()) {
                        return false;
                    }
                }
                catch(i i0) {
                    if(i0.b) {
                        throw i0;
                    }
                    r0.a(i0);
                    return false;
                }
            }
            r0.a = null;
            r0.b = 0x8000000000000001L;
            r0.c = 0x8000000000000001L;
            if(this.M) {
                this.N = Math.max(0L, v1);
                this.L = false;
                this.M = false;
                if(this.x()) {
                    this.v();
                }
                this.a(v1);
                if(this.V) {
                    this.r();
                }
            }
            long v3 = this.k();
            AudioTrack audioTrack0 = l0.c;
            audioTrack0.getClass();
            int v4 = audioTrack0.getPlayState();
            if(l0.g) {
                if(v4 == 2) {
                    l0.o = false;
                    return false;
                }
                if(v4 != 1 || l0.b() != 0L) {
                    goto label_57;
                }
            }
            else {
            label_57:
                boolean z = l0.o;
                boolean z1 = l0.c(v3);
                l0.o = z1;
                if(z && !z1 && v4 != 1) {
                    int v5 = l0.d;
                    long v6 = x.Z(l0.h);
                    s s0 = (s)l0.a.b;
                    if(s0.r != null) {
                        long v7 = SystemClock.elapsedRealtime() - s0.c0;
                        E9.g g0 = ((u)s0.r.b).Z0;
                        Handler handler0 = (Handler)g0.a;
                        if(handler0 != null) {
                            handler0.post(new j3.g(g0, v5, v6, v7));
                        }
                    }
                }
                if(this.P == null) {
                    e3.b.c(byteBuffer0.order() == ByteOrder.LITTLE_ENDIAN);
                    if(!byteBuffer0.hasRemaining()) {
                        return true;
                    }
                    o o2 = this.t;
                    if(o2.c != 0 && this.K == 0) {
                        int v8 = o2.g;
                    alab1:
                        switch(v8) {
                            case 9: {
                                int v14 = byteBuffer0.getInt(byteBuffer0.position());
                                if(byteBuffer0.order() != ByteOrder.BIG_ENDIAN) {
                                    v14 = Integer.reverseBytes(v14);
                                }
                                if((v14 & 0xFFE00000) == 0xFFE00000) {
                                    int v15 = v14 >>> 19 & 3;
                                    if(v15 == 1) {
                                        v17 = -1;
                                    }
                                    else {
                                        int v16 = v14 >>> 17 & 3;
                                        if(v16 == 0 || ((v14 >>> 12 & 15) == 0 || (v14 >>> 12 & 15) == 15) || (v14 >>> 10 & 3) == 3) {
                                            v17 = -1;
                                        }
                                        else {
                                            v17 = 0x480;
                                            switch(v16) {
                                                case 1: {
                                                    if(v15 != 3) {
                                                        v17 = 0x240;
                                                    }
                                                    break;
                                                }
                                                case 2: {
                                                    break;
                                                }
                                                case 3: {
                                                    v17 = 0x180;
                                                    break;
                                                }
                                                default: {
                                                    throw new IllegalArgumentException();
                                                }
                                            }
                                        }
                                    }
                                }
                                else {
                                    v17 = -1;
                                }
                                if(v17 == -1) {
                                    throw new IllegalArgumentException();
                                }
                                v9 = v17;
                                break;
                            }
                            case 11: 
                            case 12: {
                                v9 = 0x800;
                                break;
                            }
                            case 14: {
                                int v18 = byteBuffer0.position();
                                int v19 = byteBuffer0.limit();
                                for(int v20 = v18; true; ++v20) {
                                    v21 = -1;
                                    if(v20 > v19 - 10) {
                                        break;
                                    }
                                    int v22 = byteBuffer0.getInt(v20 + 4);
                                    if(byteBuffer0.order() != ByteOrder.BIG_ENDIAN) {
                                        v22 = Integer.reverseBytes(v22);
                                    }
                                    if((v22 & -2) == 0xF8726FBA) {
                                        v21 = v20 - v18;
                                        break;
                                    }
                                }
                                v9 = v21 == -1 ? 0 : (40 << (byteBuffer0.get(byteBuffer0.position() + v21 + ((byteBuffer0.get(byteBuffer0.position() + v21 + 7) & 0xFF) == 0xBB ? 8 : 9)) >> 4 & 7)) * 16;
                                break;
                            }
                            case 15: {
                                v9 = 0x200;
                                break;
                            }
                            case 10: 
                            case 16: {
                            label_128:
                                v9 = 0x400;
                                break;
                            }
                            case 17: {
                                byte[] arr_b = new byte[16];
                                byteBuffer0.get(arr_b);
                                byteBuffer0.position(byteBuffer0.position());
                                v9 = B3.b.l(new N(arr_b, 16, 2, 0)).c;
                                break;
                            }
                            case 5: 
                            case 6: 
                            case 18: {
                                if((byteBuffer0.get(byteBuffer0.position() + 5) & 0xF8) >> 3 > 10) {
                                    if((byteBuffer0.get(byteBuffer0.position() + 4) & 0xC0) >> 6 != 3) {
                                        v2 = (byteBuffer0.get(byteBuffer0.position() + 4) & 0x30) >> 4;
                                    }
                                    v9 = B3.b.c[v2] * 0x100;
                                }
                                else {
                                    v9 = 0x600;
                                }
                                break;
                            }
                            case 20: {
                                if((byteBuffer0.get(5) & 2) == 0) {
                                    v23 = 0;
                                }
                                else {
                                    int v24 = byteBuffer0.get(26);
                                    int v25 = 28;
                                    int v26 = 28;
                                    for(int v27 = 0; v27 < v24; ++v27) {
                                        v26 += byteBuffer0.get(v27 + 27);
                                    }
                                    int v28 = byteBuffer0.get(v26 + 26);
                                    for(int v29 = 0; v29 < v28; ++v29) {
                                        v25 += byteBuffer0.get(v26 + 27 + v29);
                                    }
                                    v23 = v26 + v25;
                                }
                                int v30 = byteBuffer0.get(v23 + 26) + 27 + v23;
                                v9 = (int)(B3.b.j(byteBuffer0.get(v30), ((byte)(byteBuffer0.limit() - v30 <= 1 ? 0 : byteBuffer0.get(v30 + 1)))) * 48000L / 1000000L);
                                break;
                            }
                            case 7: 
                            case 8: 
                            case 30: {
                                switch(byteBuffer0.getInt(0)) {
                                    case 0xE842C471: 
                                    case 0xF21B4140: {
                                        goto label_128;
                                    }
                                    case 0x25205864: {
                                        v9 = 0x1000;
                                        break alab1;
                                    }
                                    default: {
                                        int v10 = byteBuffer0.position();
                                        int v11 = byteBuffer0.get(v10);
                                        switch(v11) {
                                            case -2: {
                                                v12 = (byteBuffer0.get(v10 + 5) & 1) << 6;
                                                v13 = byteBuffer0.get(v10 + 4) & 0xFC;
                                                break;
                                            }
                                            case -1: {
                                                v12 = (byteBuffer0.get(v10 + 4) & 7) << 4;
                                                v13 = byteBuffer0.get(v10 + 7) & 60;
                                                break;
                                            }
                                            default: {
                                                if(v11 == 0x1F) {
                                                    v12 = (byteBuffer0.get(v10 + 5) & 7) << 4;
                                                    v13 = byteBuffer0.get(v10 + 6) & 60;
                                                }
                                                else {
                                                    v12 = (byteBuffer0.get(v10 + 4) & 1) << 6;
                                                    v13 = byteBuffer0.get(v10 + 5) & 0xFC;
                                                }
                                            }
                                        }
                                        v9 = ((v13 >> 2 | v12) + 1) * 0x20;
                                        break alab1;
                                    }
                                }
                            }
                            default: {
                                throw new IllegalStateException("Unexpected audio encoding: " + v8);
                            }
                        }
                        this.K = v9;
                        if(v9 != 0) {
                            goto label_180;
                        }
                        return true;
                    }
                label_180:
                    if(this.A == null) {
                    label_184:
                        long v31 = this.N;
                        o o3 = this.t;
                        long v32 = this.j();
                        long v33 = x.R(o3.a.D, v32 - this.d.o) + v31;
                        if(!this.L && Math.abs(v33 - v1) > 200000L) {
                            Ga ga0 = this.r;
                            if(ga0 != null) {
                                StringBuilder stringBuilder0 = Y.o(v33, "Unexpected audio track timestamp discontinuity: expected ", ", got ");
                                stringBuilder0.append(v1);
                                ga0.p(new v7(stringBuilder0.toString()));  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
                            }
                            this.L = true;
                        }
                        if(!this.L) {
                        label_204:
                            if(this.t.c == 0) {
                                this.G += (long)byteBuffer0.remaining();
                            }
                            else {
                                this.H = ((long)this.K) * ((long)v) + this.H;
                            }
                            this.P = byteBuffer0;
                            this.Q = v;
                            goto label_212;
                        }
                        else if(this.f()) {
                            long v34 = v1 - v33;
                            this.N += v34;
                            this.L = false;
                            this.a(v1);
                            Ga ga1 = this.r;
                            if(ga1 != null && v34 != 0L) {
                                ((u)ga1.b).i1 = true;
                            }
                            goto label_204;
                        }
                    }
                    else if(this.f()) {
                        this.a(v1);
                        this.A = null;
                        goto label_184;
                    }
                }
                else {
                label_212:
                    this.t(v1);
                    if(!this.P.hasRemaining()) {
                        this.P = null;
                        this.Q = 0;
                        return true;
                    }
                    long v35 = this.k();
                    if(l0.y != 0x8000000000000001L && v35 > 0L) {
                        l0.I.getClass();
                        if(SystemClock.elapsedRealtime() - l0.y >= 200L) {
                            e3.b.D("DefaultAudioSink", "Resetting stalled audio track");
                            this.g();
                            return true;
                        }
                    }
                }
            }
        }
        else if(this.f()) {
            o o0 = this.s;
            o o1 = this.t;
            o0.getClass();
            if(o1.c != o0.c || o1.g != o0.g || o1.e != o0.e || o1.f != o0.f || o1.d != o0.d || o1.j != o0.j || o1.k != o0.k) {
                this.s();
                if(!this.m()) {
                    this.g();
                    this.a(v1);
                    goto label_27;
                }
            }
            else {
                this.t = this.s;
                this.s = null;
                if(this.v != null && s.p(this.v) && this.t.k) {
                    if(this.v.getPlayState() == 3) {
                        com.iloen.melon.utils.player.a.o(this.v);
                        l0.G = true;
                        Q7 q70 = l0.e;
                        if(q70 != null) {
                            k k0 = (k)q70.f;
                            if(k0 != null) {
                                k0.f = true;
                            }
                        }
                    }
                    com.iloen.melon.utils.player.a.p(this.v, this.t.a.F, this.t.a.G);
                    this.e0 = true;
                }
                this.a(v1);
                goto label_27;
            }
        }
        return false;
    }

    public final boolean m() {
        if(this.o() && (!com.iloen.melon.utils.player.a.t(this.v) || !this.U)) {
            long v = this.k();
            return this.g.c(v);
        }
        return false;
    }

    public final boolean n() {
        AudioTrack audioTrack0;
        if(this.l.a != null && (s.l0 > 0 || SystemClock.elapsedRealtime() < this.l.c)) {
            return false;
        }
        try {
            o o0 = this.t;
            o0.getClass();
            audioTrack0 = this.c(o0);
        }
        catch(i i0) {
            o o1 = this.t;
            if(o1.h > 1000000) {
                o o2 = new o(o1.a, o1.b, o1.c, o1.d, o1.e, o1.f, o1.g, 1000000, o1.i, o1.j, o1.k, o1.l);
                try {
                    audioTrack0 = this.c(o2);
                    this.t = o2;
                    goto label_18;
                }
                catch(i i1) {
                    i0.addSuppressed(i1);
                }
            }
            if(this.t.c == 1) {
                this.d0 = true;
            }
            throw i0;
        }
    label_18:
        this.v = audioTrack0;
        if(s.p(audioTrack0)) {
            AudioTrack audioTrack1 = this.v;
            if(this.k == null) {
                y8.s s0 = new y8.s();  // 初始化器: Ljava/lang/Object;-><init>()V
                s0.c = this;
                s0.a = new Handler(Looper.myLooper());
                s0.b = new tb(s0, 1);
                this.k = s0;
            }
            y8.s s1 = this.k;
            Handler handler0 = (Handler)s1.a;
            Objects.requireNonNull(handler0);
            com.iloen.melon.utils.player.a.z(audioTrack1, new androidx.media3.session.p0(handler0, 1), ((tb)s1.b));
            o o3 = this.t;
            if(o3.k) {
                com.iloen.melon.utils.player.a.p(this.v, o3.a.F, o3.a.G);
            }
        }
        i3.l l0 = this.q;
        if(l0 != null) {
            AudioTrack audioTrack2 = this.v;
            l0.b.getClass();
            LogSessionId logSessionId0 = l0.b.a;
            if(!i3.i.z(logSessionId0)) {
                audioTrack2.setLogSessionId(logSessionId0);
            }
        }
        this.X = this.v.getAudioSessionId();
        AudioTrack audioTrack3 = this.v;
        o o4 = this.t;
        this.g.c = audioTrack3;
        this.g.d = o4.h;
        this.g.e = new Q7(audioTrack3, 1);
        this.g.f = audioTrack3.getSampleRate();
        this.g.g = false;
        boolean z = x.H(o4.g);
        this.g.p = z;
        this.g.h = z ? x.R(this.g.f, ((long)(o4.h / o4.d))) : 0x8000000000000001L;
        this.g.s = 0L;
        this.g.t = 0L;
        this.g.G = false;
        this.g.H = 0L;
        this.g.u = 0L;
        this.g.o = false;
        this.g.x = 0x8000000000000001L;
        this.g.y = 0x8000000000000001L;
        this.g.q = 0L;
        this.g.n = 0L;
        this.g.i = 1.0f;
        if(this.o()) {
            this.v.setVolume(this.O);
        }
        this.Y.getClass();
        Ga ga0 = this.Z;
        if(ga0 != null) {
            this.v.setPreferredDevice(((AudioDeviceInfo)ga0.b));
            j3.e e0 = this.x;
            if(e0 != null) {
                e0.b(((AudioDeviceInfo)this.Z.b));
            }
        }
        j3.e e1 = this.x;
        if(e1 != null) {
            this.y = new d5.m(this.v, e1);
        }
        this.M = true;
        Ga ga1 = this.r;
        if(ga1 != null) {
            c c0 = this.t.a();
            E9.g g0 = ((u)ga1.b).Z0;
            Handler handler1 = (Handler)g0.a;
            if(handler1 != null) {
                handler1.post(new j3.g(g0, c0, 0));
            }
        }
        return true;
    }

    public final boolean o() {
        return this.v != null;
    }

    public static boolean p(AudioTrack audioTrack0) {
        return com.iloen.melon.utils.player.a.t(audioTrack0);
    }

    public final void q() {
        b b0;
        if(this.x == null) {
            Context context0 = this.a;
            if(context0 != null) {
                this.f0 = Looper.myLooper();
                j3.e e0 = new j3.e(context0, new n(this, 0), this.z, this.Z);
                this.x = e0;
                if(e0.j) {
                    b0 = e0.g;
                    b0.getClass();
                }
                else {
                    e0.j = true;
                    j3.d d0 = e0.f;
                    if(d0 != null) {
                        d0.a.registerContentObserver(d0.b, false, d0);
                    }
                    Handler handler0 = e0.c;
                    Context context1 = e0.a;
                    j3.c c0 = e0.d;
                    if(c0 != null) {
                        AudioManager audioManager0 = (AudioManager)context1.getSystemService("audio");
                        audioManager0.getClass();
                        audioManager0.registerAudioDeviceCallback(c0, handler0);
                    }
                    IntentFilter intentFilter0 = new IntentFilter("android.media.action.HDMI_AUDIO_PLUG");
                    b0 = b.b(context1, context1.registerReceiver(e0.e, intentFilter0, null, handler0), e0.i, e0.h);
                    e0.g = b0;
                }
                this.w = b0;
            }
        }
    }

    public final void r() {
        this.V = true;
        if(this.o()) {
            l l0 = this.g;
            if(l0.x != 0x8000000000000001L) {
                l0.I.getClass();
                l0.x = x.M(SystemClock.elapsedRealtime());
            }
            Q7 q70 = l0.e;
            q70.getClass();
            q70.c();
            this.v.play();
        }
    }

    public final void s() {
        if(!this.T) {
            this.T = true;
            long v = this.k();
            this.g.z = this.g.b();
            this.g.I.getClass();
            this.g.x = x.M(SystemClock.elapsedRealtime());
            this.g.A = v;
            if(s.p(this.v)) {
                this.U = false;
            }
            this.v.stop();
            this.F = 0;
        }
    }

    public final void t(long v) {
        ByteBuffer byteBuffer1;
        this.e(v);
        if(this.R == null) {
            if(this.u.d()) {
                while(!this.u.c()) {
                    while(true) {
                        a a0 = this.u;
                        if(a0.d()) {
                            ByteBuffer byteBuffer2 = a0.c[a0.b()];
                            if(byteBuffer2.hasRemaining()) {
                                byteBuffer1 = byteBuffer2;
                            }
                            else {
                                a0.e(c3.d.a);
                                byteBuffer1 = a0.c[a0.b()];
                            }
                        }
                        else {
                            byteBuffer1 = c3.d.a;
                        }
                        if(!byteBuffer1.hasRemaining()) {
                            break;
                        }
                        this.w(byteBuffer1);
                        this.e(v);
                        if(this.R != null) {
                            return;
                        }
                    }
                    if(this.P == null || !this.P.hasRemaining()) {
                        break;
                    }
                    a a1 = this.u;
                    ByteBuffer byteBuffer3 = this.P;
                    if(a1.d() && !a1.d) {
                        a1.e(byteBuffer3);
                    }
                }
            }
            else {
                ByteBuffer byteBuffer0 = this.P;
                if(byteBuffer0 != null) {
                    this.w(byteBuffer0);
                    this.e(v);
                }
            }
        }
    }

    public final void u() {
        this.g();
        S s0 = this.e.r(0);
        while(s0.hasNext()) {
            ((c3.d)s0.next()).reset();
        }
        S s1 = this.f.r(0);
        while(s1.hasNext()) {
            ((c3.d)s1.next()).reset();
        }
        a a0 = this.u;
        if(a0 != null) {
            I6.V v0 = a0.a;
            for(int v1 = 0; v1 < v0.size(); ++v1) {
                c3.d d0 = (c3.d)v0.get(v1);
                d0.flush();
                d0.reset();
            }
            a0.c = new ByteBuffer[0];
            a0.d = false;
        }
        this.V = false;
        this.d0 = false;
    }

    public final void v() {
        if(this.o()) {
            PlaybackParams playbackParams0 = new PlaybackParams().allowDefaults().setSpeed(this.C.a).setPitch(this.C.b).setAudioFallbackMode(2);
            try {
                this.v.setPlaybackParams(playbackParams0);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                e3.b.E("DefaultAudioSink", "Failed to set playback params", illegalArgumentException0);
            }
            L l0 = new L(this.v.getPlaybackParams().getSpeed(), this.v.getPlaybackParams().getPitch());
            this.C = l0;
            l l1 = this.g;
            l1.i = l0.a;
            Q7 q70 = l1.e;
            if(q70 != null) {
                q70.c();
            }
            l1.d();
        }
    }

    public final void w(ByteBuffer byteBuffer0) {
        int v6;
        ByteBuffer byteBuffer1;
        e3.b.j(this.R == null);
        if(!byteBuffer0.hasRemaining()) {
            return;
        }
        if(this.t.c == 0) {
            int v = (int)x.T(x.M(20L), this.t.e, 1000000L, RoundingMode.UP);
            long v1 = this.k();
            if(v1 < ((long)v)) {
                int v2 = this.t.g;
                int v3 = this.t.d;
                int v4 = (int)v1;
                byteBuffer1 = ByteBuffer.allocateDirect(byteBuffer0.remaining()).order(ByteOrder.nativeOrder());
                int v5 = byteBuffer0.position();
                while(byteBuffer0.hasRemaining() && v4 < v) {
                    switch(v2) {
                        case 2: {
                            v6 = (byteBuffer0.get() & 0xFF) << 16 | (byteBuffer0.get() & 0xFF) << 24;
                            break;
                        }
                        case 3: {
                            v6 = (byteBuffer0.get() & 0xFF) << 24;
                            break;
                        }
                        case 4: {
                            float f = x.g(byteBuffer0.getFloat(), -1.0f, 1.0f);
                            v6 = (int)(f < 0.0f ? -f * -2147483648.0f : f * 2147483648.0f);
                            break;
                        }
                        case 21: {
                            v6 = (byteBuffer0.get() & 0xFF) << 8 | (byteBuffer0.get() & 0xFF) << 16 | (byteBuffer0.get() & 0xFF) << 24;
                            break;
                        }
                        case 22: {
                            v6 = byteBuffer0.get() & 0xFF | (byteBuffer0.get() & 0xFF) << 8 | (byteBuffer0.get() & 0xFF) << 16 | (byteBuffer0.get() & 0xFF) << 24;
                            break;
                        }
                        case 0x10000000: {
                            v6 = (byteBuffer0.get() & 0xFF) << 24 | (byteBuffer0.get() & 0xFF) << 16;
                            break;
                        }
                        case 0x50000000: {
                            v6 = (byteBuffer0.get() & 0xFF) << 24 | (byteBuffer0.get() & 0xFF) << 16 | (byteBuffer0.get() & 0xFF) << 8;
                            break;
                        }
                        default: {
                            if(v2 != 0x60000000) {
                                throw new IllegalStateException();
                            }
                            v6 = (byteBuffer0.get() & 0xFF) << 24 | (byteBuffer0.get() & 0xFF) << 16 | (byteBuffer0.get() & 0xFF) << 8 | byteBuffer0.get() & 0xFF;
                            break;
                        }
                    }
                    int v7 = (int)(((long)v6) * ((long)v4) / ((long)v));
                    switch(v2) {
                        case 2: {
                            byteBuffer1.put(((byte)(v7 >> 16)));
                            byteBuffer1.put(((byte)(v7 >> 24)));
                            break;
                        }
                        case 3: {
                            byteBuffer1.put(((byte)(v7 >> 24)));
                            break;
                        }
                        case 4: {
                            if(v7 < 0) {
                                byteBuffer1.putFloat(-((float)v7) / -2147483648.0f);
                            }
                            else {
                                byteBuffer1.putFloat(((float)v7) / 2147483648.0f);
                            }
                            break;
                        }
                        case 21: {
                            byteBuffer1.put(((byte)(v7 >> 8)));
                            byteBuffer1.put(((byte)(v7 >> 16)));
                            byteBuffer1.put(((byte)(v7 >> 24)));
                            break;
                        }
                        case 22: {
                            byteBuffer1.put(((byte)v7));
                            byteBuffer1.put(((byte)(v7 >> 8)));
                            byteBuffer1.put(((byte)(v7 >> 16)));
                            byteBuffer1.put(((byte)(v7 >> 24)));
                            break;
                        }
                        case 0x10000000: {
                            byteBuffer1.put(((byte)(v7 >> 24)));
                            byteBuffer1.put(((byte)(v7 >> 16)));
                            break;
                        }
                        case 0x50000000: {
                            byteBuffer1.put(((byte)(v7 >> 24)));
                            byteBuffer1.put(((byte)(v7 >> 16)));
                            byteBuffer1.put(((byte)(v7 >> 8)));
                            break;
                        }
                        case 0x60000000: {
                            byteBuffer1.put(((byte)(v7 >> 24)));
                            byteBuffer1.put(((byte)(v7 >> 16)));
                            byteBuffer1.put(((byte)(v7 >> 8)));
                            byteBuffer1.put(((byte)v7));
                            break;
                        }
                        default: {
                            throw new IllegalStateException();
                        }
                    }
                    if(byteBuffer0.position() == v5 + v3) {
                        ++v4;
                        v5 = byteBuffer0.position();
                    }
                }
                byteBuffer1.put(byteBuffer0);
                byteBuffer1.flip();
            }
            else {
                byteBuffer1 = byteBuffer0;
            }
        }
        else {
            byteBuffer1 = byteBuffer0;
        }
        this.R = byteBuffer1;
    }

    public final boolean x() {
        return this.t != null && this.t.j;
    }
}

