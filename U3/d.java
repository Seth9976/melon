package u3;

import Ac.X3;
import I6.Q;
import I6.p0;
import Q8.h;
import R6.c;
import Y3.i;
import Y3.l;
import Z3.f;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import androidx.media3.common.b;
import androidx.media3.exoplayer.e;
import androidx.media3.exoplayer.y;
import b3.H;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Objects;
import pc.t;
import s3.V;
import s3.z;

public final class d extends e implements Handler.Callback {
    public final c B;
    public final h3.e D;
    public a E;
    public final u3.c G;
    public boolean I;
    public int M;
    public Y3.e N;
    public i S;
    public Y3.c T;
    public Y3.c V;
    public int W;
    public final Handler X;
    public final y Y;
    public final ea.c Z;
    public boolean b0;
    public boolean c0;
    public b d0;
    public long e0;
    public long f0;
    public IOException g0;

    public d(y y0, Looper looper0) {
        super(3);
        this.Y = y0;
        this.X = looper0 == null ? null : new Handler(looper0, this);
        this.G = u3.c.U;
        this.B = new c(8);
        this.D = new h3.e(1);
        this.Z = new ea.c(5);
        this.f0 = 0x8000000000000001L;
        this.e0 = 0x8000000000000001L;
    }

    public final void A() {
        boolean z = Objects.equals(this.d0.n, "application/cea-608") || Objects.equals(this.d0.n, "application/x-mp4-cea-608") || Objects.equals(this.d0.n, "application/cea-708");
        e3.b.i(("Legacy decoding is disabled, can\'t handle " + this.d0.n + " samples (expected application/x-media3-cues)."), z);
    }

    public final long B() {
        if(this.W == -1) {
            return 0x7FFFFFFFFFFFFFFFL;
        }
        this.T.getClass();
        return this.W < this.T.getEventTimeCount() ? this.T.getEventTime(this.W) : 0x7FFFFFFFFFFFFFFFL;
    }

    public final long C(long v) {
        e3.b.j(v != 0x8000000000000001L);
        return v - this.k;
    }

    public final void D() {
        n3.b b1;
        this.I = true;
        b b0 = this.d0;
        b0.getClass();
        c c0 = (c)((t)this.G).b;
        String s = b0.n;
        int v = b0.H;
        if(s == null) {
        label_14:
            if(!c0.n(b0)) {
                throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + s);
            }
            l l0 = c0.l(b0);
            l0.getClass().getSimpleName().concat("Decoder");
            b1 = new n3.b(l0);
        }
        else {
            switch(s) {
                case "application/cea-608": 
                case "application/x-mp4-cea-608": {
                    b1 = new Z3.c(s, v);
                    break;
                }
                case "application/cea-708": {
                    b1 = new f(v, b0.q);
                    break;
                }
                default: {
                    goto label_14;
                }
            }
        }
        this.N = b1;
        b1.b(this.l);
    }

    public final void E(d3.c c0) {
        C5.a a0 = new C5.a(c0.a, 1);
        this.Y.a.m.g(27, a0);
        this.Y.a.W = c0;
        X3 x30 = new X3(c0, 25);
        this.Y.a.m.g(27, x30);
    }

    public final void F() {
        this.S = null;
        this.W = -1;
        Y3.c c0 = this.T;
        if(c0 != null) {
            c0.p();
            this.T = null;
        }
        Y3.c c1 = this.V;
        if(c1 != null) {
            c1.p();
            this.V = null;
        }
    }

    @Override  // androidx.media3.exoplayer.e
    public final String g() {
        return "TextRenderer";
    }

    @Override  // android.os.Handler$Callback
    public final boolean handleMessage(Message message0) {
        if(message0.what != 1) {
            throw new IllegalStateException();
        }
        this.E(((d3.c)message0.obj));
        return true;
    }

    @Override  // androidx.media3.exoplayer.e
    public final boolean i() {
        return this.c0;
    }

    @Override  // androidx.media3.exoplayer.e
    public final boolean k() {
        if(this.d0 != null) {
            if(this.g0 == null) {
                try {
                    V v0 = this.i;
                    v0.getClass();
                    v0.maybeThrowError();
                }
                catch(IOException iOException0) {
                    this.g0 = iOException0;
                }
            }
            if(this.g0 != null) {
                b b0 = this.d0;
                b0.getClass();
                if(Objects.equals(b0.n, "application/x-media3-cues")) {
                    a a0 = this.E;
                    a0.getClass();
                    return a0.d(this.e0) != 0x8000000000000000L;
                }
                if(this.c0) {
                    return false;
                }
                if(this.b0) {
                    long v1 = this.e0;
                    if(this.T == null || this.T.getEventTime(this.T.getEventTimeCount() - 1) <= v1) {
                        long v2 = this.e0;
                        return this.V != null && this.V.getEventTime(this.V.getEventTimeCount() - 1) > v2 || this.S == null;
                    }
                }
            }
        }
        return true;
    }

    @Override  // androidx.media3.exoplayer.e
    public final void l() {
        this.d0 = null;
        this.f0 = 0x8000000000000001L;
        d3.c c0 = new d3.c(this.C(this.e0), p0.e);
        Handler handler0 = this.X;
        if(handler0 == null) {
            this.E(c0);
        }
        else {
            handler0.obtainMessage(1, c0).sendToTarget();
        }
        this.e0 = 0x8000000000000001L;
        if(this.N != null) {
            this.F();
            Y3.e e0 = this.N;
            e0.getClass();
            e0.release();
            this.N = null;
            this.M = 0;
        }
    }

    @Override  // androidx.media3.exoplayer.e
    public final void n(long v, boolean z) {
        this.e0 = v;
        a a0 = this.E;
        if(a0 != null) {
            a0.clear();
        }
        d3.c c0 = new d3.c(this.C(this.e0), p0.e);
        Handler handler0 = this.X;
        if(handler0 == null) {
            this.E(c0);
        }
        else {
            handler0.obtainMessage(1, c0).sendToTarget();
        }
        this.b0 = false;
        this.c0 = false;
        this.f0 = 0x8000000000000001L;
        if(this.d0 != null && !Objects.equals(this.d0.n, "application/x-media3-cues")) {
            if(this.M != 0) {
                this.F();
                Y3.e e0 = this.N;
                e0.getClass();
                e0.release();
                this.N = null;
                this.M = 0;
                this.D();
                return;
            }
            this.F();
            Y3.e e1 = this.N;
            e1.getClass();
            e1.flush();
            e1.b(this.l);
        }
    }

    @Override  // androidx.media3.exoplayer.e
    public final void s(b[] arr_b, long v, long v1, z z0) {
        this.d0 = arr_b[0];
        if(!Objects.equals(arr_b[0].n, "application/x-media3-cues")) {
            this.A();
            if(this.N != null) {
                this.M = 1;
                return;
            }
            this.D();
            return;
        }
        u3.b b0 = this.d0.I == 1 ? new u3.b() : new h(8, false);
        this.E = b0;
    }

    @Override  // androidx.media3.exoplayer.e
    public final void u(long v, long v1) {
        long v11;
        ea.c c4;
        if(this.n && (this.f0 != 0x8000000000000001L && v >= this.f0)) {
            this.F();
            this.c0 = true;
        }
        if(!this.c0) {
            b b0 = this.d0;
            b0.getClass();
            boolean z = Objects.equals(b0.n, "application/x-media3-cues");
            Handler handler0 = this.X;
            ea.c c0 = this.Z;
            int v2 = 0;
            if(z) {
                this.E.getClass();
                if(!this.b0) {
                    h3.e e0 = this.D;
                    if(this.t(c0, e0, 0) == -4) {
                        if(e0.i(4)) {
                            this.b0 = true;
                        }
                        else {
                            e0.r();
                            ByteBuffer byteBuffer0 = e0.e;
                            byteBuffer0.getClass();
                            long v3 = e0.g;
                            byte[] arr_b = byteBuffer0.array();
                            int v4 = byteBuffer0.arrayOffset();
                            this.B.getClass();
                            Parcel parcel0 = Parcel.obtain();
                            parcel0.unmarshall(arr_b, v4, byteBuffer0.limit());
                            parcel0.setDataPosition(0);
                            Bundle bundle0 = parcel0.readBundle(Bundle.class.getClassLoader());
                            parcel0.recycle();
                            ArrayList arrayList0 = bundle0.getParcelableArrayList("c");
                            arrayList0.getClass();
                            Q q0 = I6.V.o();
                            while(v2 < arrayList0.size()) {
                                Bundle bundle1 = (Bundle)arrayList0.get(v2);
                                bundle1.getClass();
                                q0.a(d3.b.a(bundle1));
                                ++v2;
                            }
                            Y3.a a0 = new Y3.a(q0.g(), v3, bundle0.getLong("d"));
                            e0.o();
                            v2 = this.E.b(a0, v);
                        }
                    }
                }
                long v5 = this.E.d(this.e0);
                int v6 = Long.compare(v5, 0x8000000000000000L);
                if(v6 == 0 && this.b0 && v2 == 0) {
                    this.c0 = true;
                }
                if(v6 != 0 && v5 <= v) {
                    v2 = 1;
                }
                if(v2 != 0) {
                    I6.V v7 = this.E.a(v);
                    long v8 = this.E.c(v);
                    d3.c c1 = new d3.c(this.C(v8), v7);
                    if(handler0 == null) {
                        this.E(c1);
                    }
                    else {
                        handler0.obtainMessage(1, c1).sendToTarget();
                    }
                    this.E.e(v8);
                }
                this.e0 = v;
                return;
            }
            this.A();
            this.e0 = v;
            if(this.V == null) {
                Y3.e e1 = this.N;
                e1.getClass();
                e1.setPositionUs(v);
                try {
                    Y3.e e2 = this.N;
                    e2.getClass();
                    this.V = (Y3.c)e2.dequeueOutputBuffer();
                }
                catch(Y3.f f0) {
                    e3.b.q("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.d0, f0);
                    d3.c c2 = new d3.c(this.C(this.e0), p0.e);
                    if(handler0 == null) {
                        this.E(c2);
                    }
                    else {
                        handler0.obtainMessage(1, c2).sendToTarget();
                    }
                    this.F();
                    Y3.e e3 = this.N;
                    e3.getClass();
                    e3.release();
                    this.N = null;
                    this.M = 0;
                    this.D();
                    return;
                }
            }
            if(this.h == 2) {
                if(this.T == null) {
                    z1 = false;
                }
                else {
                    long v9 = this.B();
                    boolean z1;
                    for(z1 = false; v9 <= v; z1 = true) {
                        ++this.W;
                        v9 = this.B();
                    }
                }
                Y3.c c3 = this.V;
                if(c3 == null) {
                    c4 = c0;
                }
                else if(!c3.i(4)) {
                    c4 = c0;
                    if(c3.c <= v) {
                        Y3.c c5 = this.T;
                        if(c5 != null) {
                            c5.p();
                        }
                        this.W = c3.getNextEventTimeIndex(v);
                        this.T = c3;
                        this.V = null;
                        z1 = true;
                    }
                }
                else if(z1 || this.B() != 0x7FFFFFFFFFFFFFFFL) {
                    c4 = c0;
                }
                else if(this.M == 2) {
                    this.F();
                    Y3.e e4 = this.N;
                    e4.getClass();
                    e4.release();
                    this.N = null;
                    this.M = 0;
                    this.D();
                    c4 = c0;
                }
                else {
                    this.F();
                    this.c0 = true;
                    c4 = c0;
                }
                if(z1) {
                    this.T.getClass();
                    int v10 = this.T.getNextEventTimeIndex(v);
                    if(v10 == 0 || this.T.getEventTimeCount() == 0) {
                        v11 = this.T.c;
                    }
                    else if(v10 == -1) {
                        v11 = this.T.getEventTime(this.T.getEventTimeCount() - 1);
                    }
                    else {
                        v11 = this.T.getEventTime(v10 - 1);
                    }
                    d3.c c6 = new d3.c(this.C(v11), this.T.getCues(v));
                    if(handler0 == null) {
                        this.E(c6);
                    }
                    else {
                        handler0.obtainMessage(1, c6).sendToTarget();
                    }
                }
                if(this.M != 2) {
                    while(!this.b0) {
                        try {
                            i i0 = this.S;
                            if(i0 == null) {
                                Y3.e e5 = this.N;
                                e5.getClass();
                                i0 = (i)e5.dequeueInputBuffer();
                                if(i0 == null) {
                                    break;
                                }
                                this.S = i0;
                            }
                            if(this.M == 1) {
                                i0.b = 4;
                                Y3.e e6 = this.N;
                                e6.getClass();
                                e6.a(i0);
                                this.S = null;
                                this.M = 2;
                                return;
                            }
                            int v12 = this.t(c4, i0, 0);
                            if(v12 == -4) {
                                if(i0.i(4)) {
                                    this.b0 = true;
                                    this.I = false;
                                }
                                else {
                                    b b1 = (b)c4.c;
                                    if(b1 == null) {
                                        break;
                                    }
                                    i0.j = b1.s;
                                    i0.r();
                                    this.I &= !i0.i(1);
                                }
                                if(this.I) {
                                    continue;
                                }
                                Y3.e e7 = this.N;
                                e7.getClass();
                                e7.a(i0);
                                this.S = null;
                                continue;
                            }
                            if(v12 == -3) {
                                return;
                            }
                            goto label_193;
                        }
                        catch(Y3.f f1) {
                        }
                        e3.b.q("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.d0, f1);
                        d3.c c7 = new d3.c(this.C(this.e0), p0.e);
                        if(handler0 == null) {
                            this.E(c7);
                        }
                        else {
                            handler0.obtainMessage(1, c7).sendToTarget();
                        }
                        this.F();
                        Y3.e e8 = this.N;
                        e8.getClass();
                        e8.release();
                        this.N = null;
                        this.M = 0;
                        this.D();
                        return;
                    label_193:
                        if(false) {
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override  // androidx.media3.exoplayer.e
    public final int y(b b0) {
        boolean z = Objects.equals(b0.n, "application/x-media3-cues");
        String s = b0.n;
        if(!z) {
            ((t)this.G).getClass();
            if(!((c)((t)this.G).b).n(b0) && !Objects.equals(s, "application/cea-608") && !Objects.equals(s, "application/x-mp4-cea-608") && !Objects.equals(s, "application/cea-708")) {
                return H.j(s) ? 0x81 : 0x80;
            }
        }
        return b0.L == 0 ? 0x84 : 130;
    }
}

