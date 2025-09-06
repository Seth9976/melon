package androidx.compose.foundation;

import A0.b;
import A0.c;
import A0.d;
import G.f;
import G.g;
import N0.L;
import N0.N;
import N0.O;
import N0.q;
import P0.K;
import P0.z;
import Q0.u;
import androidx.appcompat.app.o;
import androidx.compose.runtime.E;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import androidx.media3.session.legacy.V;
import i.n.i.b.a.s.e.M3;
import je.x;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import r0.p;
import w0.e;
import w0.t;
import ye.a;

public final class v0 extends p implements P0.p, z, e {
    public int a;
    public int b;
    public int c;
    public float d;
    public final a0 e;
    public final a0 f;
    public final b0 g;
    public Job h;
    public B0.e i;
    public final b0 j;
    public final b0 k;
    public final G.e l;
    public final E m;

    public v0(int v, int v1, int v2, w0 w00, float f) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = f;
        this.e = w.p(0);
        this.f = w.p(0);
        this.g = w.s(Boolean.FALSE);
        this.j = w.s(w00);
        this.k = w.s(new q0());  // 初始化器: Ljava/lang/Object;-><init>()V
        this.l = f.a(0.0f);
        this.m = w.i(new g(25, w00, this));
    }

    @Override  // P0.p
    public final void draw(d d0) {
        int v2;
        boolean z1;
        boolean z;
        G.e e0 = this.l;
        float f = ((Number)e0.d()).floatValue();
        float f1 = this.o0() * f;
        if(Float.compare(this.o0(), 1.0f) != 0) {
            z = ((Number)e0.d()).floatValue() < ((float)this.m0());
        }
        else if(((Number)e0.d()).floatValue() < ((float)this.n0())) {
            z = true;
        }
        else {
            z = false;
        }
        if(this.o0() == 1.0f) {
            float f2 = ((Number)e0.d()).floatValue();
            int v = this.n0();
            z1 = f2 > ((float)(this.p0() + v - this.m0()));
        }
        else {
            z1 = ((Number)e0.d()).floatValue() > ((float)this.p0());
        }
        if(this.o0() == 1.0f) {
            int v1 = this.n0();
            v2 = this.p0() + v1;
        }
        else {
            v2 = -this.n0() - this.p0();
        }
        b b0 = ((K)d0).a;
        float f3 = Float.intBitsToFloat(((int)(b0.c() & 0xFFFFFFFFL)));
        B0.e e1 = this.i;
        if(e1 != null) {
            long v3 = ((long)this.n0()) << 0x20 | ((long)a.V(f3)) & 0xFFFFFFFFL;
            androidx.compose.foundation.w w0 = new androidx.compose.foundation.w(((K)d0), 2);
            e1.g(((K)d0), ((K)d0).getLayoutDirection(), v3, new F.g(((K)d0), ((K)d0).b, w0, 10));
        }
        float f4 = f1 + ((float)this.m0());
        float f5 = Float.intBitsToFloat(((int)(b0.c() & 0xFFFFFFFFL)));
        V v4 = b0.b;
        long v5 = v4.l();
        v4.h().q();
        try {
            ((V)((c)v4.a).b).h().h(f1, 0.0f, f4, f5, 1);
            B0.e e2 = this.i;
            if(e2 == null) {
                if(z) {
                    ((K)d0).a();
                }
                if(z1) {
                    ((c)((K)d0).a.b.a).M(((float)v2), 0.0f);
                    try {
                        ((K)d0).a();
                    }
                    catch(Throwable throwable1) {
                        ((c)((K)d0).a.b.a).M(-((float)v2), -0.0f);
                        throw throwable1;
                    }
                label_60:
                    ((c)((K)d0).a.b.a).M(-((float)v2), -0.0f);
                }
            }
            else {
                if(z) {
                    y5.a.z(d0, e2);
                }
                if(z1) {
                    ((c)((K)d0).a.b.a).M(((float)v2), 0.0f);
                    try {
                        y5.a.z(d0, e2);
                        goto label_60;
                    }
                    catch(Throwable throwable0) {
                        ((c)((K)d0).a.b.a).M(-((float)v2), -0.0f);
                        throw throwable0;
                    }
                }
            }
        }
        finally {
            o.y(v4, v5);
        }
    }

    public final int m0() {
        return ((K0)this.f).m();
    }

    @Override  // P0.z
    public final int maxIntrinsicHeight(q q0, N0.p p0, int v) {
        return p0.d(0x7FFFFFFF);
    }

    @Override  // P0.z
    public final int maxIntrinsicWidth(q q0, N0.p p0, int v) {
        return p0.N(v);
    }

    @Override  // P0.z
    public final N measure-3p2s80s(O o0, L l0, long v) {
        N0.a0 a00 = l0.O(r1.a.a(v, 0, 0x7FFFFFFF, 0, 0, 13));
        ((K0)this.f).n(r1.b.g(a00.a, v));
        ((K0)this.e).n(a00.a);
        int v1 = this.m0();
        int v2 = a00.b;
        S s0 = new S(1, a00, this);
        return o0.w(v1, v2, x.a, s0);
    }

    @Override  // P0.z
    public final int minIntrinsicHeight(q q0, N0.p p0, int v) {
        return p0.C(0x7FFFFFFF);
    }

    @Override  // P0.z
    public final int minIntrinsicWidth(q q0, N0.p p0, int v) {
        return 0;
    }

    public final int n0() {
        return ((K0)this.e).m();
    }

    public final float o0() {
        float f = Math.signum(this.d);
        switch(P0.f.v(this).T.ordinal()) {
            case 0: {
                return f * 1.0f;
            }
            case 1: {
                return f * -1.0f;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    @Override  // r0.p
    public final void onAttach() {
        B0.e e0 = this.i;
        y0.z z0 = ((u)P0.f.w(this)).getGraphicsContext();
        if(e0 != null) {
            z0.b(e0);
        }
        this.i = z0.a();
        this.q0();
    }

    @Override  // r0.p
    public final void onDetach() {
        Job job0 = this.h;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        this.h = null;
        B0.e e0 = this.i;
        if(e0 != null) {
            ((u)P0.f.w(this)).getGraphicsContext().b(e0);
            this.i = null;
        }
    }

    public final int p0() {
        return ((Number)this.m.getValue()).intValue();
    }

    public final void q0() {
        Job job0 = this.h;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        if(this.isAttached()) {
            this.h = BuildersKt__Builders_commonKt.launch$default(this.getCoroutineScope(), null, null, new s0(job0, this, null), 3, null);
        }
    }

    @Override  // w0.e
    public final void r(t t0) {
        Boolean boolean0 = Boolean.valueOf(t0.a());
        ((O0)this.g).setValue(boolean0);
    }
}

