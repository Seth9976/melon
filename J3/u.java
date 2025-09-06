package j3;

import E9.g;
import I6.V;
import I6.p0;
import Q0.D;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.b;
import androidx.media3.exoplayer.C;
import androidx.media3.exoplayer.L;
import androidx.media3.exoplayer.f;
import androidx.media3.exoplayer.h0;
import androidx.media3.exoplayer.y;
import b3.H;
import b3.d;
import com.iloen.melon.utils.player.a;
import d5.m;
import e3.r;
import e3.x;
import ea.c;
import h3.e;
import i.n.i.b.a.s.e.Ga;
import i.n.i.b.a.s.e.Q7;
import i.n.i.b.a.s.e.u9;
import i3.l;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jeb.synthetic.FIN;
import o3.h;
import o3.i;
import o3.j;
import o3.p;
import o3.v;

public final class u extends p implements L {
    public final Context Y0;
    public final g Z0;
    public final s a1;
    public final m b1;
    public int c1;
    public boolean d1;
    public boolean e1;
    public b f1;
    public b g1;
    public long h1;
    public boolean i1;
    public boolean j1;
    public boolean k1;
    public int l1;

    public u(Context context0, i i0, h h0, Handler handler0, y y0, s s0) {
        super(1, i0, h0, 44100.0f);
        this.Y0 = context0.getApplicationContext();
        this.a1 = s0;
        this.b1 = null;
        this.l1 = -1000;
        this.Z0 = new g(handler0, y0);
        s0.r = new Ga(this, 16);
    }

    @Override  // o3.p
    public final androidx.media3.exoplayer.g B(o3.m m0, b b0, b b1) {
        androidx.media3.exoplayer.g g0 = m0.b(b0, b1);
        int v = this.Z != null || !this.p0(b1) ? g0.e : g0.e | 0x8000;
        if(this.v0(m0, b1) > this.c1) {
            v |= 0x40;
        }
        return v == 0 ? new androidx.media3.exoplayer.g(m0.a, b0, b1, g0.d, 0) : new androidx.media3.exoplayer.g(m0.a, b0, b1, 0, v);
    }

    @Override  // o3.p
    public final float M(float f, b[] arr_b) {
        int v1 = -1;
        for(int v = 0; v < arr_b.length; ++v) {
            int v2 = arr_b[v].D;
            if(v2 != -1) {
                v1 = Math.max(v1, v2);
            }
        }
        return v1 == -1 ? -1.0f : ((float)v1) * f;
    }

    @Override  // o3.p
    public final ArrayList N(h h0, b b0, boolean z) {
        p0 p00;
        if(b0.n == null) {
            p00 = p0.e;
        }
        else if(this.a1.i(b0) == 0) {
            p00 = v.g(h0, b0, z, false);
        }
        else {
            List list0 = v.e("audio/raw", false, false);
            o3.m m0 = list0.isEmpty() ? null : ((o3.m)list0.get(0));
            p00 = m0 == null ? v.g(h0, b0, z, false) : V.t(m0);
        }
        ArrayList arrayList0 = new ArrayList(p00);
        Collections.sort(arrayList0, new D(new n(b0, 4), 4));
        return arrayList0;
    }

    @Override  // o3.p
    public final E9.u O(o3.m m0, b b0, MediaCrypto mediaCrypto0, float f) {
        b[] arr_b = this.j;
        arr_b.getClass();
        int v = this.v0(m0, b0);
        String s = m0.a;
        if(arr_b.length != 1) {
            for(int v1 = 0; v1 < arr_b.length; ++v1) {
                b b1 = arr_b[v1];
                if(m0.b(b0, b1).d != 0) {
                    v = Math.max(v, this.v0(m0, b1));
                }
            }
        }
        this.c1 = v;
        this.d1 = false;
        this.e1 = s.equals("OMX.google.opus.decoder") || s.equals("c2.android.opus.decoder") || s.equals("OMX.google.vorbis.decoder") || s.equals("c2.android.vorbis.decoder");
        int v2 = this.c1;
        MediaFormat mediaFormat0 = new MediaFormat();
        mediaFormat0.setString("mime", m0.c);
        String s1 = b0.n;
        mediaFormat0.setInteger("channel-count", b0.C);
        int v3 = b0.D;
        mediaFormat0.setInteger("sample-rate", v3);
        e3.b.B(mediaFormat0, b0.q);
        e3.b.x(mediaFormat0, "max-input-size", v2);
        mediaFormat0.setInteger("priority", 0);
        if(f != -1.0f) {
            mediaFormat0.setFloat("operating-rate", f);
        }
        b3.n n0 = new b3.n();
        n0.m = "audio/raw";
        n0.B = b0.C;
        n0.C = v3;
        n0.D = 4;
        b b2 = new b(n0);
        if(this.a1.i(b2) == 2) {
            mediaFormat0.setInteger("pcm-encoding", 4);
        }
        mediaFormat0.setInteger("max-output-channel-count", 99);
        this.g1 = !"audio/raw".equals(m0.b) || "audio/raw".equals(s1) ? null : b0;
        return new E9.u(m0, mediaFormat0, b0, null, mediaCrypto0, this.b1);
    }

    @Override  // o3.p
    public final void P(e e0) {
        if(e0.c != null && Objects.equals(e0.c.n, "audio/opus") && this.C0) {
            ByteBuffer byteBuffer0 = e0.h;
            byteBuffer0.getClass();
            b b0 = e0.c;
            b0.getClass();
            int v = b0.F;
            if(byteBuffer0.remaining() == 8) {
                long v1 = byteBuffer0.order(ByteOrder.LITTLE_ENDIAN).getLong();
                s s0 = this.a1;
                if(s0.v != null && s.p(s0.v) && (s0.t != null && s0.t.k)) {
                    a.p(s0.v, v, ((int)(v1 * 48000L / 1000000000L)));
                }
            }
        }
    }

    @Override  // o3.p
    public final void U(Exception exception0) {
        e3.b.q("MediaCodecAudioRenderer", "Audio codec error", exception0);
        g g0 = this.Z0;
        Handler handler0 = (Handler)g0.a;
        if(handler0 != null) {
            handler0.post(new j3.g(g0, exception0, 4));
        }
    }

    @Override  // o3.p
    public final void V(String s, long v, long v1) {
        g g0 = this.Z0;
        Handler handler0 = (Handler)g0.a;
        if(handler0 != null) {
            handler0.post(new j3.g(g0, s, v, v1));
        }
    }

    @Override  // o3.p
    public final void W(String s) {
        g g0 = this.Z0;
        Handler handler0 = (Handler)g0.a;
        if(handler0 != null) {
            handler0.post(new j3.g(g0, s, 8));
        }
    }

    @Override  // o3.p
    public final androidx.media3.exoplayer.g X(c c0) {
        b b0 = (b)c0.c;
        b0.getClass();
        this.f1 = b0;
        androidx.media3.exoplayer.g g0 = super.X(c0);
        g g1 = this.Z0;
        Handler handler0 = (Handler)g1.a;
        if(handler0 != null) {
            handler0.post(new j3.g(g1, b0, g0));
        }
        return g0;
    }

    @Override  // o3.p
    public final void Y(b b0, MediaFormat mediaFormat0) {
        int v1;
        b b1 = this.g1;
        int[] arr_v = null;
        if(b1 != null) {
            b0 = b1;
        }
        else if(this.g0 != null) {
            mediaFormat0.getClass();
            int v = b0.C;
            if("audio/raw".equals(b0.n)) {
                v1 = b0.E;
            }
            else if(mediaFormat0.containsKey("pcm-encoding")) {
                v1 = mediaFormat0.getInteger("pcm-encoding");
            }
            else {
                v1 = mediaFormat0.containsKey("v-bits-per-sample") ? x.z(mediaFormat0.getInteger("v-bits-per-sample")) : 2;
            }
            b3.n n0 = new b3.n();
            n0.m = "audio/raw";
            n0.D = v1;
            n0.E = b0.F;
            n0.F = b0.G;
            n0.k = b0.l;
            n0.a = b0.a;
            n0.b = b0.b;
            n0.c = V.p(b0.c);
            n0.d = b0.d;
            n0.e = b0.e;
            n0.f = b0.f;
            n0.B = mediaFormat0.getInteger("channel-count");
            n0.C = mediaFormat0.getInteger("sample-rate");
            b0 = new b(n0);
            int v2 = b0.C;
            if(this.d1 && v2 == 6 && v < 6) {
                arr_v = new int[v];
                for(int v3 = 0; v3 < v; ++v3) {
                    arr_v[v3] = v3;
                }
            }
            else if(this.e1) {
                if(v2 == 3) {
                    arr_v = new int[]{0, 2, 1};
                }
                else {
                    switch(v2) {
                        case 5: {
                            arr_v = new int[]{0, 2, 1, 3, 4};
                            break;
                        }
                        case 6: {
                            arr_v = new int[]{0, 2, 1, 5, 3, 4};
                            break;
                        }
                        case 7: {
                            arr_v = new int[]{0, 2, 1, 6, 5, 3, 4};
                            break;
                        }
                        case 8: {
                            arr_v = new int[]{0, 2, 1, 7, 5, 6, 3, 4};
                        }
                    }
                }
            }
        }
        try {
            s s0 = this.a1;
            if(this.C0) {
                h0 h00 = this.d;
                h00.getClass();
                if(h00.a != 0) {
                    h0 h01 = this.d;
                    h01.getClass();
                    s0.getClass();
                    e3.b.j(true);
                    s0.j = h01.a;
                    s0.d(b0, arr_v);
                    return;
                }
                goto label_63;
            }
            else {
            label_63:
                s0.getClass();
                e3.b.j(true);
                s0.j = 0;
            }
            s0.d(b0, arr_v);
            return;
        }
        catch(j3.h h0) {
        }
        throw this.d(h0, h0.a, false, 5001);
    }

    @Override  // o3.p
    public final void Z() {
        this.a1.getClass();
    }

    @Override  // androidx.media3.exoplayer.L
    public final void a(b3.L l0) {
        s s0 = this.a1;
        s0.getClass();
        s0.C = new b3.L(x.g(l0.a, 0.1f, 8.0f), x.g(l0.b, 0.1f, 8.0f));
        if(s0.x()) {
            s0.v();
            return;
        }
        j3.p p0 = new j3.p(l0, 0x8000000000000001L, 0x8000000000000001L);
        if(s0.o()) {
            s0.A = p0;
            return;
        }
        s0.B = p0;
    }

    @Override  // androidx.media3.exoplayer.L
    public final boolean b() {
        boolean z = this.k1;
        this.k1 = false;
        return z;
    }

    @Override  // o3.p
    public final void b0() {
        this.a1.L = true;
    }

    @Override  // androidx.media3.exoplayer.e
    public final L f() {
        return this;
    }

    @Override  // o3.p
    public final boolean f0(long v, long v1, j j0, ByteBuffer byteBuffer0, int v2, int v3, int v4, long v5, boolean z, boolean z1, b b0) {
        int v7;
        int v6;
        byteBuffer0.getClass();
        if(this.g1 != null && (v3 & 2) != 0) {
            j0.getClass();
            j0.k(v2);
            return true;
        }
        s s0 = this.a1;
        if(z) {
            if(j0 != null) {
                j0.k(v2);
            }
            this.T0.f += v4;
            s0.L = true;
            return true;
        }
        try {
            if(s0.l(v4, byteBuffer0, v5)) {
                goto label_37;
            }
            return false;
        }
        catch(j3.i i0) {
            b b1 = this.f1;
            if(this.C0) {
                h0 h00 = this.d;
                h00.getClass();
                v6 = h00.a == 0 ? 5001 : 5004;
            }
            else {
                v6 = 5001;
            }
            throw this.d(i0, b1, i0.b, v6);
        }
        catch(j3.j j1) {
            if(this.C0) {
                h0 h01 = this.d;
                h01.getClass();
                v7 = h01.a == 0 ? 5002 : 5003;
            }
            else {
                v7 = 5002;
            }
            throw this.d(j1, b0, j1.b, v7);
        }
    label_37:
        if(j0 != null) {
            j0.k(v2);
        }
        this.T0.e += v4;
        return true;
    }

    @Override  // androidx.media3.exoplayer.e
    public final String g() {
        return "MediaCodecAudioRenderer";
    }

    @Override  // androidx.media3.exoplayer.L
    public final b3.L getPlaybackParameters() {
        return this.a1.C;
    }

    @Override  // androidx.media3.exoplayer.L
    public final long getPositionUs() {
        if(this.h == 2) {
            this.w0();
        }
        return this.h1;
    }

    @Override  // androidx.media3.exoplayer.e
    public final void handleMessage(int v, Object object0) {
        Ga ga0;
        boolean z = false;
        AudioDeviceInfo audioDeviceInfo0 = null;
        s s0 = this.a1;
        switch(v) {
            case 2: {
                object0.getClass();
                float f = (float)(((Float)object0));
                if(s0.O != f) {
                    s0.O = f;
                    if(s0.o()) {
                        s0.v.setVolume(s0.O);
                        return;
                    }
                }
                break;
            }
            case 3: {
                ((d)object0).getClass();
                if(!s0.z.equals(((d)object0))) {
                    s0.z = (d)object0;
                    if(!s0.a0) {
                        j3.e e0 = s0.x;
                        if(e0 != null) {
                            e0.i = (d)object0;
                            e0.a(j3.b.c(e0.a, ((d)object0), e0.h));
                        }
                        s0.g();
                        return;
                    }
                }
                break;
            }
            case 6: {
                ((b3.e)object0).getClass();
                if(!s0.Y.equals(((b3.e)object0))) {
                    if(s0.v != null) {
                        s0.Y.getClass();
                    }
                    s0.Y = (b3.e)object0;
                    return;
                }
                break;
            }
            case 9: {
                object0.getClass();
                s0.D = ((Boolean)object0).booleanValue();
                j3.p p0 = new j3.p((s0.x() ? b3.L.d : s0.C), 0x8000000000000001L, 0x8000000000000001L);
                if(s0.o()) {
                    s0.A = p0;
                    return;
                }
                s0.B = p0;
                return;
            }
            case 10: {
                object0.getClass();
                int v1 = (int)(((Integer)object0));
                if(s0.X != v1) {
                    s0.X = v1;
                    if(v1 != 0) {
                        z = true;
                    }
                    s0.W = z;
                    s0.g();
                    return;
                }
                break;
            }
            case 11: {
                this.b0 = (C)object0;
                return;
            }
            case 12: {
                if(((AudioDeviceInfo)object0) == null) {
                    ga0 = null;
                }
                else {
                    s0.getClass();
                    ga0 = new Ga(((AudioDeviceInfo)object0), 14);
                }
                s0.Z = ga0;
                j3.e e1 = s0.x;
                if(e1 != null) {
                    e1.b(((AudioDeviceInfo)object0));
                }
                AudioTrack audioTrack0 = s0.v;
                if(audioTrack0 != null) {
                    Ga ga1 = s0.Z;
                    if(ga1 != null) {
                        audioDeviceInfo0 = (AudioDeviceInfo)ga1.b;
                    }
                    audioTrack0.setPreferredDevice(audioDeviceInfo0);
                    return;
                }
                break;
            }
            case 16: {
                object0.getClass();
                this.l1 = (int)(((Integer)object0));
            }
        }
    }

    // 去混淆评级： 低(40)
    @Override  // androidx.media3.exoplayer.e
    public final boolean i() {
        return this.P0 && (!this.a1.o() || this.a1.S && !this.a1.m());
    }

    @Override  // o3.p
    public final void i0() {
        try {
            s s0 = this.a1;
            if(!s0.S && s0.o() && s0.f()) {
                s0.s();
                s0.S = true;
            }
        }
        catch(j3.j j0) {
            throw this.d(j0, j0.c, j0.b, (this.C0 ? 5003 : 5002));
        }
    }

    // 去混淆评级： 低(20)
    @Override  // o3.p
    public final boolean k() {
        return this.a1.m() || super.k();
    }

    @Override  // o3.p
    public final void l() {
        g g0;
        try {
            g0 = this.Z0;
            this.j1 = true;
            this.f1 = null;
            this.a1.g();
        }
        catch(Throwable unused_ex) {
            try {
                super.l();
            }
            throw throwable0;
        }
        finally {
            g0.e(this.T0);
        }
        super.l();
    }

    @Override  // androidx.media3.exoplayer.e
    public final void m(boolean z, boolean z1) {
        f f0 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.T0 = f0;
        g g0 = this.Z0;
        Handler handler0 = (Handler)g0.a;
        if(handler0 != null) {
            handler0.post(new j3.g(g0, f0, 3));
        }
        h0 h00 = this.d;
        h00.getClass();
        s s0 = this.a1;
        if(h00.b) {
            e3.b.j(s0.W);
            if(!s0.a0) {
                s0.a0 = true;
                s0.g();
            }
        }
        else if(s0.a0) {
            s0.a0 = false;
            s0.g();
        }
        l l0 = this.f;
        l0.getClass();
        s0.q = l0;
        r r0 = this.g;
        r0.getClass();
        s0.g.I = r0;
    }

    @Override  // o3.p
    public final void n(long v, boolean z) {
        super.n(v, z);
        this.a1.g();
        this.h1 = v;
        this.k1 = false;
        this.i1 = true;
    }

    @Override  // androidx.media3.exoplayer.e
    public final void o() {
        j3.e e0 = this.a1.x;
        if(e0 != null) {
            Context context0 = e0.a;
            if(e0.j) {
                e0.g = null;
                j3.c c0 = e0.d;
                if(c0 != null) {
                    AudioManager audioManager0 = (AudioManager)context0.getSystemService("audio");
                    audioManager0.getClass();
                    audioManager0.unregisterAudioDeviceCallback(c0);
                }
                context0.unregisterReceiver(e0.e);
                j3.d d0 = e0.f;
                if(d0 != null) {
                    d0.a.unregisterContentObserver(d0);
                }
                e0.j = false;
            }
        }
    }

    @Override  // androidx.media3.exoplayer.e
    public final void p() {
        s s0;
        int v;
        try {
            v = FIN.finallyOpen$NT();
            s0 = this.a1;
            this.k1 = false;
            this.D();
            this.h0();
            FIN.finallyCodeBegin$NT(v);
            k3.h h0 = this.Z;
            if(h0 != null) {
                h0.d(null);
            }
        }
        catch(Throwable throwable0) {
            if(this.j1) {
                this.j1 = false;
                s0.u();
            }
            throw throwable0;
        }
        this.Z = null;
        FIN.finallyCodeEnd$NT(v);
        if(this.j1) {
            this.j1 = false;
            s0.u();
        }
    }

    @Override  // o3.p
    public final boolean p0(b b0) {
        h0 h00 = this.d;
        h00.getClass();
        if(h00.a != 0) {
            int v = this.u0(b0);
            if((v & 0x200) != 0) {
                h0 h01 = this.d;
                h01.getClass();
                return h01.a != 2 && (v & 0x400) == 0 && (b0.F != 0 || b0.G != 0) ? this.a1.i(b0) != 0 : true;
            }
        }
        return this.a1.i(b0) != 0;
    }

    @Override  // androidx.media3.exoplayer.e
    public final void q() {
        this.a1.r();
    }

    @Override  // o3.p
    public final int q0(h h0, b b0) {
        boolean z4;
        boolean z3;
        p0 p00;
        int v3;
        int v = 0;
        String s = b0.n;
        if(!H.h(b0.n)) {
            return 0x80;
        }
        boolean z = b0.L != 0;
        boolean z1 = b0.L == 0 || b0.L == 2;
        int v1 = 8;
        int v2 = 4;
        s s1 = this.a1;
        if(!z1) {
            v3 = 0;
        }
        else if(z) {
            List list0 = v.e("audio/raw", false, false);
            if((list0.isEmpty() ? null : ((o3.m)list0.get(0))) == null) {
                v3 = 0;
                goto label_19;
            }
            goto label_15;
        }
        else {
        label_15:
            v3 = this.u0(b0);
            if(s1.i(b0) != 0) {
                return 0xAC | v3;
            }
        }
    label_19:
        if("audio/raw".equals(s) && s1.i(b0) == 0) {
            return 0x81;
        }
        b3.n n0 = new b3.n();
        n0.m = "audio/raw";
        n0.B = b0.C;
        n0.C = b0.D;
        n0.D = 2;
        if(s1.i(new b(n0)) != 0) {
            if(s == null) {
                p00 = p0.e;
            }
            else if(s1.i(b0) == 0) {
                p00 = v.g(h0, b0, false, false);
            }
            else {
                List list1 = v.e("audio/raw", false, false);
                o3.m m0 = list1.isEmpty() ? null : ((o3.m)list1.get(0));
                p00 = m0 == null ? v.g(h0, b0, false, false) : V.t(m0);
            }
            if(p00.isEmpty()) {
                return 0x81;
            }
            if(!z1) {
                return 130;
            }
            o3.m m1 = (o3.m)p00.get(0);
            boolean z2 = m1.d(b0);
            if(!z2) {
                int v4 = 1;
                while(v4 < p00.d) {
                    o3.m m2 = (o3.m)p00.get(v4);
                    if(m2.d(b0)) {
                        z3 = false;
                        m1 = m2;
                        z4 = true;
                        goto label_58;
                    }
                    ++v4;
                }
            }
            z4 = z2;
            z3 = true;
        label_58:
            if(!z4) {
                v2 = 3;
            }
            if(z4 && m1.e(b0)) {
                v1 = 16;
            }
            int v5 = m1.g ? 0x40 : 0;
            if(z3) {
                v = 0x80;
            }
            return v5 | (v2 | v1 | 0x20) | v | v3;
        }
        return 0x81;
    }

    @Override  // androidx.media3.exoplayer.e
    public final void r() {
        this.w0();
        s s0 = this.a1;
        s0.V = false;
        if(s0.o()) {
            j3.l l0 = s0.g;
            l0.d();
            if(l0.x == 0x8000000000000001L) {
                Q7 q70 = l0.e;
                q70.getClass();
                q70.c();
                s0.v.pause();
                return;
            }
            l0.z = l0.b();
            if(s.p(s0.v)) {
                s0.v.pause();
            }
        }
    }

    public final int u0(b b0) {
        j3.f f0 = this.a1.h(b0);
        if(!f0.a) {
            return 0;
        }
        int v = f0.b ? 0x600 : 0x200;
        return f0.c ? v | 0x800 : v;
    }

    public final int v0(o3.m m0, b b0) {
        boolean z = !"OMX.google.raw.decoder".equals(m0.a);
        return b0.o;
    }

    public final void w0() {
        long v12;
        long v10;
        boolean z = this.i();
        s s0 = this.a1;
        androidx.media3.session.legacy.V v0 = s0.b;
        if(!s0.o() || s0.M) {
            v12 = 0x8000000000000000L;
        }
        else {
            long v1 = s0.g.a(z);
            o o0 = s0.t;
            long v2 = s0.k();
            long v3 = Math.min(v1, x.R(o0.e, v2));
            ArrayDeque arrayDeque0 = s0.h;
            while(!arrayDeque0.isEmpty() && v3 >= ((j3.p)arrayDeque0.getFirst()).c) {
                s0.B = (j3.p)arrayDeque0.remove();
            }
            long v4 = v3 - s0.B.c;
            long v5 = x.x(v4, s0.B.a.a);
            if(arrayDeque0.isEmpty()) {
                c3.g g0 = (c3.g)v0.c;
                if(g0.isActive()) {
                    if(g0.o >= 0x400L) {
                        long v6 = g0.n;
                        c3.f f0 = g0.j;
                        f0.getClass();
                        long v7 = v6 - ((long)(f0.k * f0.b * 2));
                        int v8 = g0.h.a;
                        int v9 = g0.g.a;
                        v4 = v8 == v9 ? x.T(v4, v7, g0.o, RoundingMode.DOWN) : x.T(v4, v7 * ((long)v8), g0.o * ((long)v9), RoundingMode.DOWN);
                    }
                    else {
                        v4 = (long)(((double)g0.c) * ((double)v4));
                    }
                }
                v10 = s0.B.b + v4;
                s0.B.d = v4 - v5;
            }
            else {
                v10 = s0.B.b + v5 + s0.B.d;
            }
            long v11 = ((w)v0.b).q;
            v12 = x.R(s0.t.e, v11) + v10;
            long v13 = s0.g0;
            if(v11 > v13) {
                long v14 = x.R(s0.t.e, v11 - v13);
                s0.g0 = v11;
                s0.h0 += v14;
                if(s0.i0 == null) {
                    s0.i0 = new Handler(Looper.myLooper());
                }
                s0.i0.removeCallbacksAndMessages(null);
                s0.i0.postDelayed(new u9(s0, 8), 100L);
            }
        }
        if(v12 != 0x8000000000000000L) {
            if(!this.i1) {
                v12 = Math.max(this.h1, v12);
            }
            this.h1 = v12;
            this.i1 = false;
        }
    }
}

