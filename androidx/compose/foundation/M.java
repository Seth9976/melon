package androidx.compose.foundation;

import B0.b;
import I.L;
import I.e1;
import I.g1;
import M.i0;
import P0.n;
import android.content.Context;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import e1.x;
import ie.H;
import ne.a;
import r1.c;
import r1.q;
import x0.e;
import y0.M;

public final class m {
    public final c a;
    public long b;
    public final N c;
    public final b0 d;
    public final boolean e;
    public boolean f;
    public long g;
    public long h;
    public final n i;

    public m(Context context0, c c0, long v, i0 i00) {
        this.a = c0;
        this.b = 0x7FC000007FC00000L;
        N n0 = new N(context0, M.z(v));
        this.c = n0;
        this.d = w.r(H.a, V.c);
        this.e = true;
        this.g = 0L;
        this.h = -1L;
        J0.N n1 = new J0.N(null, null, new L(this, 5));
        this.i = Build.VERSION.SDK_INT < 0x1F ? new W(n1, this, n0, i00) : new W(n1, this, n0);
    }

    public final void a() {
        int v1;
        N n0 = this.c;
        EdgeEffect edgeEffect0 = n0.d;
        int v = 1;
        if(edgeEffect0 == null) {
            v1 = 0;
        }
        else {
            edgeEffect0.onRelease();
            v1 = !edgeEffect0.isFinished();
        }
        EdgeEffect edgeEffect1 = n0.e;
        if(edgeEffect1 != null) {
            edgeEffect1.onRelease();
            v1 = !edgeEffect1.isFinished() || v1 != 0 ? 1 : 0;
        }
        EdgeEffect edgeEffect2 = n0.f;
        if(edgeEffect2 != null) {
            edgeEffect2.onRelease();
            v1 = !edgeEffect2.isFinished() || v1 != 0 ? 1 : 0;
        }
        EdgeEffect edgeEffect3 = n0.g;
        if(edgeEffect3 != null) {
            edgeEffect3.onRelease();
            if(edgeEffect3.isFinished() && v1 == 0) {
                v = 0;
            }
            v1 = v;
        }
        if(v1 != 0) {
            this.e();
        }
    }

    public final Object b(long v, e1 e10, oe.c c0) {
        m m0;
        long v3;
        float f1;
        float f;
        k k0;
        if(c0 instanceof k) {
            k0 = (k)c0;
            int v1 = k0.E;
            if((v1 & 0x80000000) == 0) {
                k0 = new k(this, c0);
            }
            else {
                k0.E = v1 ^ 0x80000000;
            }
        }
        else {
            k0 = new k(this, c0);
        }
        Object object0 = k0.B;
        a a0 = a.a;
        H h0 = H.a;
        switch(k0.E) {
            case 0: {
                d5.n.D(object0);
                if(e.e(this.g)) {
                    k0.E = 1;
                    e10.getClass();
                    e1 e11 = new e1(e10.D, k0);
                    e11.B = v;
                    return e11.invokeSuspend(h0) == a0 ? a0 : h0;
                }
                N n0 = this.c;
                boolean z = N.g(n0.f);
                c c1 = this.a;
                if(!z || q.b(v) >= 0.0f) {
                    f = !N.g(n0.g) || q.b(v) <= 0.0f ? 0.0f : -androidx.compose.foundation.q.d(n0.d(), -q.b(v), Float.intBitsToFloat(((int)(this.g >> 0x20))), c1);
                }
                else {
                    f = androidx.compose.foundation.q.d(n0.c(), q.b(v), Float.intBitsToFloat(((int)(this.g >> 0x20))), c1);
                }
                if(!N.g(n0.d) || q.c(v) >= 0.0f) {
                    f1 = !N.g(n0.e) || q.c(v) <= 0.0f ? 0.0f : -androidx.compose.foundation.q.d(n0.b(), -q.c(v), Float.intBitsToFloat(((int)(this.g & 0xFFFFFFFFL))), c1);
                }
                else {
                    f1 = androidx.compose.foundation.q.d(n0.e(), q.c(v), Float.intBitsToFloat(((int)(this.g & 0xFFFFFFFFL))), c1);
                }
                long v2 = x.x(f, f1);
                if(v2 != 0L) {
                    this.e();
                }
                v3 = q.d(v, v2);
                k0.r = this;
                k0.w = v3;
                k0.E = 2;
                e10.getClass();
                e1 e12 = new e1(e10.D, k0);
                e12.B = v3;
                object0 = e12.invokeSuspend(h0);
                if(object0 == a0) {
                    return a0;
                }
                m0 = this;
                break;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            case 2: {
                v3 = k0.w;
                m0 = k0.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v4 = q.d(v3, ((q)object0).a);
        m0.f = false;
        N n1 = m0.c;
        if(Float.compare(q.b(v4), 0.0f) > 0) {
            EdgeEffect edgeEffect0 = n1.c();
            int v5 = ye.a.V(q.b(v4));
            if(Build.VERSION.SDK_INT >= 0x1F) {
                edgeEffect0.onAbsorb(v5);
            }
            else if(edgeEffect0.isFinished()) {
                edgeEffect0.onAbsorb(v5);
            }
        }
        else if(q.b(v4) < 0.0f) {
            EdgeEffect edgeEffect1 = n1.d();
            int v6 = ye.a.V(q.b(v4));
            if(Build.VERSION.SDK_INT >= 0x1F) {
                edgeEffect1.onAbsorb(-v6);
            }
            else if(edgeEffect1.isFinished()) {
                edgeEffect1.onAbsorb(-v6);
            }
        }
        if(q.c(v4) > 0.0f) {
            EdgeEffect edgeEffect2 = n1.e();
            int v7 = ye.a.V(q.c(v4));
            if(Build.VERSION.SDK_INT >= 0x1F) {
                edgeEffect2.onAbsorb(v7);
            }
            else if(edgeEffect2.isFinished()) {
                edgeEffect2.onAbsorb(v7);
            }
        }
        else if(q.c(v4) < 0.0f) {
            EdgeEffect edgeEffect3 = n1.b();
            int v8 = ye.a.V(q.c(v4));
            if(Build.VERSION.SDK_INT >= 0x1F) {
                edgeEffect3.onAbsorb(-v8);
            }
            else if(edgeEffect3.isFinished()) {
                edgeEffect3.onAbsorb(-v8);
            }
        }
        m0.a();
        return h0;
    }

    public final long c(long v, int v1, b b0) {
        boolean z2;
        int v9;
        boolean z1;
        boolean z;
        long v8;
        float f5;
        float f4;
        float f2;
        if(e.e(this.g)) {
            b0.getClass();
            return new x0.b(g1.a(((g1)b0.g), ((g1)b0.g).j, v, ((g1)b0.g).i)).a;
        }
        int v2 = 1;
        N n0 = this.c;
        if(!this.f) {
            if(N.g(n0.f)) {
                this.g(0L);
            }
            if(N.g(n0.g)) {
                this.h(0L);
            }
            if(N.g(n0.d)) {
                this.i(0L);
            }
            if(N.g(n0.e)) {
                this.f(0L);
            }
            this.f = true;
        }
        float f = v1 == 2 ? 4.0f : 1.0f;
        long v3 = x0.b.h(v, f);
        if(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) == 0.0f) {
            f2 = 0.0f;
        }
        else if(N.g(n0.d) && Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) < 0.0f) {
            float f1 = this.i(v3);
            if(!N.g(n0.d)) {
                n0.e().finish();
            }
            f2 = f1 == Float.intBitsToFloat(((int)(v3 & 0xFFFFFFFFL))) ? Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) : f1 / f;
        }
        else if(!N.g(n0.e) || Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) <= 0.0f) {
            f2 = 0.0f;
        }
        else {
            float f3 = this.f(v3);
            if(!N.g(n0.e)) {
                n0.b().finish();
            }
            f2 = f3 == Float.intBitsToFloat(((int)(v3 & 0xFFFFFFFFL))) ? Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) : f3 / f;
        }
        if(Float.intBitsToFloat(((int)(v >> 0x20))) == 0.0f) {
            f5 = 0.0f;
        }
        else if(N.g(n0.f) && Float.intBitsToFloat(((int)(v >> 0x20))) < 0.0f) {
            f4 = this.g(v3);
            if(!N.g(n0.f)) {
                n0.c().finish();
            }
            f5 = f4 == Float.intBitsToFloat(((int)(v3 >> 0x20))) ? Float.intBitsToFloat(((int)(v >> 0x20))) : f4 / f;
        }
        else if(!N.g(n0.g) || Float.intBitsToFloat(((int)(v >> 0x20))) <= 0.0f) {
            f5 = 0.0f;
        }
        else {
            f4 = this.h(v3);
            if(!N.g(n0.g)) {
                n0.d().finish();
            }
            f5 = f4 == Float.intBitsToFloat(((int)(v3 >> 0x20))) ? Float.intBitsToFloat(((int)(v >> 0x20))) : f4 / f;
        }
        long v4 = ((long)Float.floatToRawIntBits(f5)) << 0x20 | ((long)Float.floatToRawIntBits(f2)) & 0xFFFFFFFFL;
        if(!x0.b.b(v4, 0L)) {
            this.e();
        }
        long v5 = x0.b.f(v, v4);
        b0.getClass();
        long v6 = new x0.b(g1.a(((g1)b0.g), ((g1)b0.g).j, v5, ((g1)b0.g).i)).a;
        long v7 = x0.b.f(v5, v6);
        if((Float.intBitsToFloat(((int)(v5 >> 0x20))) != 0.0f || Float.intBitsToFloat(((int)(v5 & 0xFFFFFFFFL))) != 0.0f) && (Float.intBitsToFloat(((int)(v6 >> 0x20))) != 0.0f || Float.intBitsToFloat(((int)(v6 & 0xFFFFFFFFL))) != 0.0f) && (N.g(n0.f) || N.g(n0.d) || N.g(n0.g) || N.g(n0.e))) {
            this.a();
        }
        if(v1 == 1) {
            if(Float.compare(Float.intBitsToFloat(((int)(v7 >> 0x20))), 0.5f) > 0) {
                v8 = v7;
                this.g(v8);
                z = true;
            }
            else {
                v8 = v7;
                if(Float.intBitsToFloat(((int)(v7 >> 0x20))) < -0.5f) {
                    this.h(v8);
                    z = true;
                }
                else {
                    z = false;
                }
            }
            if(Float.intBitsToFloat(((int)(v8 & 0xFFFFFFFFL))) > 0.5f) {
                this.i(v8);
                z1 = true;
            }
            else if(Float.intBitsToFloat(((int)(v8 & 0xFFFFFFFFL))) < -0.5f) {
                this.f(v8);
                z1 = true;
            }
            else {
                z1 = false;
            }
            v9 = !z && !z1 ? 0 : 1;
        }
        else {
            v9 = 0;
        }
        if(!x0.b.b(v5, 0L)) {
            if(!N.f(n0.f) || Float.intBitsToFloat(((int)(v >> 0x20))) >= 0.0f) {
                z2 = false;
            }
            else {
                EdgeEffect edgeEffect0 = n0.c();
                float f6 = Float.intBitsToFloat(((int)(v >> 0x20)));
                if(edgeEffect0 instanceof GlowEdgeEffectCompat) {
                    float f7 = ((GlowEdgeEffectCompat)edgeEffect0).b + f6;
                    ((GlowEdgeEffectCompat)edgeEffect0).b = f7;
                    if(Math.abs(f7) > ((GlowEdgeEffectCompat)edgeEffect0).a) {
                        ((GlowEdgeEffectCompat)edgeEffect0).onRelease();
                    }
                }
                else {
                    edgeEffect0.onRelease();
                }
                z2 = N.f(n0.f);
            }
            if(N.f(n0.g) && Float.intBitsToFloat(((int)(v >> 0x20))) > 0.0f) {
                EdgeEffect edgeEffect1 = n0.d();
                float f8 = Float.intBitsToFloat(((int)(v >> 0x20)));
                if(edgeEffect1 instanceof GlowEdgeEffectCompat) {
                    float f9 = ((GlowEdgeEffectCompat)edgeEffect1).b + f8;
                    ((GlowEdgeEffectCompat)edgeEffect1).b = f9;
                    if(Math.abs(f9) > ((GlowEdgeEffectCompat)edgeEffect1).a) {
                        ((GlowEdgeEffectCompat)edgeEffect1).onRelease();
                    }
                }
                else {
                    edgeEffect1.onRelease();
                }
                z2 = z2 || N.f(n0.g);
            }
            if(N.f(n0.d) && Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) < 0.0f) {
                EdgeEffect edgeEffect2 = n0.e();
                float f10 = Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
                if(edgeEffect2 instanceof GlowEdgeEffectCompat) {
                    float f11 = ((GlowEdgeEffectCompat)edgeEffect2).b + f10;
                    ((GlowEdgeEffectCompat)edgeEffect2).b = f11;
                    if(Math.abs(f11) > ((GlowEdgeEffectCompat)edgeEffect2).a) {
                        ((GlowEdgeEffectCompat)edgeEffect2).onRelease();
                    }
                }
                else {
                    edgeEffect2.onRelease();
                }
                z2 = z2 || N.f(n0.d);
            }
            if(N.f(n0.e) && Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) > 0.0f) {
                EdgeEffect edgeEffect3 = n0.b();
                float f12 = Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
                if(edgeEffect3 instanceof GlowEdgeEffectCompat) {
                    float f13 = ((GlowEdgeEffectCompat)edgeEffect3).b + f12;
                    ((GlowEdgeEffectCompat)edgeEffect3).b = f13;
                    if(Math.abs(f13) > ((GlowEdgeEffectCompat)edgeEffect3).a) {
                        ((GlowEdgeEffectCompat)edgeEffect3).onRelease();
                    }
                }
                else {
                    edgeEffect3.onRelease();
                }
                z2 = z2 || N.f(n0.e);
            }
            if(!z2 && v9 == 0) {
                v2 = 0;
            }
            v9 = v2;
        }
        if(v9 != 0) {
            this.e();
        }
        return x0.b.g(v4, v6);
    }

    public final long d() {
        long v = (0x7FFFFFFF7FFFFFFFL & this.b) == 0x7FC000007FC00000L ? e1.m.r(this.g) : this.b;
        return ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) / Float.intBitsToFloat(((int)(this.g & 0xFFFFFFFFL))))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v >> 0x20))) / Float.intBitsToFloat(((int)(this.g >> 0x20))))) << 0x20;
    }

    public final void e() {
        if(this.e) {
            ((O0)this.d).setValue(H.a);
        }
    }

    public final float f(long v) {
        float f = Float.intBitsToFloat(((int)(this.d() >> 0x20)));
        float f1 = Float.intBitsToFloat(((int)(this.g & 0xFFFFFFFFL)));
        EdgeEffect edgeEffect0 = this.c.b();
        float f2 = -(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) / f1);
        int v1 = Build.VERSION.SDK_INT;
        if(v1 >= 0x1F) {
            f2 = p.c(edgeEffect0, f2, 1.0f - f);
        }
        else {
            edgeEffect0.onPull(f2, 1.0f - f);
        }
        float f3 = Float.intBitsToFloat(((int)(0xFFFFFFFFL & this.g)));
        return (v1 < 0x1F ? 0.0f : p.b(edgeEffect0)) == 0.0f ? f3 * -f2 : Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
    }

    public final float g(long v) {
        float f = Float.intBitsToFloat(((int)(this.d() & 0xFFFFFFFFL)));
        float f1 = Float.intBitsToFloat(((int)(v >> 0x20))) / Float.intBitsToFloat(((int)(this.g >> 0x20)));
        EdgeEffect edgeEffect0 = this.c.c();
        int v1 = Build.VERSION.SDK_INT;
        if(v1 >= 0x1F) {
            f1 = p.c(edgeEffect0, f1, 1.0f - f);
        }
        else {
            edgeEffect0.onPull(f1, 1.0f - f);
        }
        float f2 = Float.intBitsToFloat(((int)(this.g >> 0x20)));
        return (v1 < 0x1F ? 0.0f : p.b(edgeEffect0)) == 0.0f ? f2 * f1 : Float.intBitsToFloat(((int)(v >> 0x20)));
    }

    public final float h(long v) {
        float f = Float.intBitsToFloat(((int)(this.d() & 0xFFFFFFFFL)));
        float f1 = Float.intBitsToFloat(((int)(this.g >> 0x20)));
        EdgeEffect edgeEffect0 = this.c.d();
        float f2 = -(Float.intBitsToFloat(((int)(v >> 0x20))) / f1);
        int v1 = Build.VERSION.SDK_INT;
        if(v1 >= 0x1F) {
            f2 = p.c(edgeEffect0, f2, f);
        }
        else {
            edgeEffect0.onPull(f2, f);
        }
        float f3 = Float.intBitsToFloat(((int)(this.g >> 0x20)));
        return (v1 < 0x1F ? 0.0f : p.b(edgeEffect0)) == 0.0f ? f3 * -f2 : Float.intBitsToFloat(((int)(v >> 0x20)));
    }

    public final float i(long v) {
        float f = Float.intBitsToFloat(((int)(this.d() >> 0x20)));
        float f1 = Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))) / Float.intBitsToFloat(((int)(this.g & 0xFFFFFFFFL)));
        EdgeEffect edgeEffect0 = this.c.e();
        int v1 = Build.VERSION.SDK_INT;
        if(v1 >= 0x1F) {
            f1 = p.c(edgeEffect0, f1, f);
        }
        else {
            edgeEffect0.onPull(f1, f);
        }
        float f2 = Float.intBitsToFloat(((int)(this.g & 0xFFFFFFFFL)));
        return (v1 < 0x1F ? 0.0f : p.b(edgeEffect0)) == 0.0f ? f2 * f1 : Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
    }

    public final void j(long v) {
        boolean z = e.a(this.g, 0L);
        boolean z1 = e.a(v, this.g);
        this.g = v;
        if(!z1) {
            int v1 = ye.a.V(Float.intBitsToFloat(((int)(v >> 0x20))));
            long v2 = ((long)ye.a.V(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))))) & 0xFFFFFFFFL | ((long)v1) << 0x20;
            N n0 = this.c;
            n0.c = v2;
            EdgeEffect edgeEffect0 = n0.d;
            if(edgeEffect0 != null) {
                edgeEffect0.setSize(((int)(v2 >> 0x20)), ((int)(v2 & 0xFFFFFFFFL)));
            }
            EdgeEffect edgeEffect1 = n0.e;
            if(edgeEffect1 != null) {
                edgeEffect1.setSize(((int)(v2 >> 0x20)), ((int)(v2 & 0xFFFFFFFFL)));
            }
            EdgeEffect edgeEffect2 = n0.f;
            if(edgeEffect2 != null) {
                edgeEffect2.setSize(((int)(v2 & 0xFFFFFFFFL)), ((int)(v2 >> 0x20)));
            }
            EdgeEffect edgeEffect3 = n0.g;
            if(edgeEffect3 != null) {
                edgeEffect3.setSize(((int)(v2 & 0xFFFFFFFFL)), ((int)(v2 >> 0x20)));
            }
            EdgeEffect edgeEffect4 = n0.h;
            if(edgeEffect4 != null) {
                edgeEffect4.setSize(((int)(v2 >> 0x20)), ((int)(v2 & 0xFFFFFFFFL)));
            }
            EdgeEffect edgeEffect5 = n0.i;
            if(edgeEffect5 != null) {
                edgeEffect5.setSize(((int)(v2 >> 0x20)), ((int)(v2 & 0xFFFFFFFFL)));
            }
            EdgeEffect edgeEffect6 = n0.j;
            if(edgeEffect6 != null) {
                edgeEffect6.setSize(((int)(v2 & 0xFFFFFFFFL)), ((int)(v2 >> 0x20)));
            }
            EdgeEffect edgeEffect7 = n0.k;
            if(edgeEffect7 != null) {
                edgeEffect7.setSize(((int)(0xFFFFFFFFL & v2)), ((int)(v2 >> 0x20)));
            }
        }
        if(!z && !z1) {
            this.a();
        }
    }
}

