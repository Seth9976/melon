package d0;

import G.e;
import I0.a;
import I0.g;
import P0.f;
import P0.l;
import P0.n;
import Q0.k0;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.w;
import df.v;
import e1.x;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import oe.c;
import x0.b;

public final class p extends n implements a, l {
    public boolean c;
    public we.a d;
    public boolean e;
    public q f;
    public float g;
    public final g h;
    public final Z i;
    public final Z j;

    public p(boolean z, we.a a0, boolean z1, q q0, float f) {
        this.c = z;
        this.d = a0;
        this.e = z1;
        this.f = q0;
        this.g = f;
        this.h = new g(this, null);
        this.i = w.o(0.0f);
        this.j = w.o(0.0f);
    }

    @Override  // r0.p
    public final void onAttach() {
        this.m0(this.h);
        BuildersKt__Builders_commonKt.launch$default(this.getCoroutineScope(), null, null, new k(this, null), 3, null);
    }

    @Override  // I0.a
    public final long onPostScroll-DzOQY0M(long v, long v1, int v2) {
        if(!((Boolean)((O0)((s)this.f).a.d).getValue()).booleanValue() && this.e && v2 == 1) {
            long v3 = this.r0(v1);
            BuildersKt__Builders_commonKt.launch$default(this.getCoroutineScope(), null, null, new d0.l(this, null), 3, null);
            return v3;
        }
        return 0L;
    }

    @Override  // I0.a
    public final Object onPreFling-QWom1Mo(long v, Continuation continuation0) {
        m m0;
        if(continuation0 instanceof m) {
            m0 = (m)continuation0;
            int v1 = m0.B;
            if((v1 & 0x80000000) == 0) {
                m0 = new m(this, ((c)continuation0));
            }
            else {
                m0.B = v1 ^ 0x80000000;
            }
        }
        else {
            m0 = new m(this, ((c)continuation0));
        }
        Object object0 = m0.r;
        ne.a a0 = ne.a.a;
        switch(m0.B) {
            case 0: {
                d5.n.D(object0);
                m0.B = 1;
                object0 = this.t0(r1.q.c(v), m0);
                return object0 == a0 ? a0 : new r1.q(x.x(0.0f, ((Number)object0).floatValue()));
            }
            case 1: {
                d5.n.D(object0);
                return new r1.q(x.x(0.0f, ((Number)object0).floatValue()));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    // 去混淆评级： 低(20)
    @Override  // I0.a
    public final long onPreScroll-OzD1aCk(long v, int v1) {
        return ((Boolean)((O0)((s)this.f).a.d).getValue()).booleanValue() || !this.e || v1 != 1 || b.e(v) >= 0.0f ? 0L : this.r0(v);
    }

    public final Object p0(c c0) {
        p p0;
        i i0;
        if(c0 instanceof i) {
            i0 = (i)c0;
            int v = i0.D;
            if((v & 0x80000000) == 0) {
                i0 = new i(this, c0);
            }
            else {
                i0.D = v ^ 0x80000000;
            }
        }
        else {
            i0 = new i(this, c0);
        }
        Object object0 = i0.w;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(i0.D) {
            case 0: {
                d5.n.D(object0);
                i0.r = this;
                i0.D = 1;
                H h1 = e.c(((s)this.f).a, new Float(0.0f), null, null, i0, 14);
                if(h1 != a0) {
                    h1 = h0;
                }
                if(h1 == a0) {
                    return a0;
                }
                p0 = this;
                break;
            }
            case 1: {
                p0 = i0.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ((I0)p0.j).n(0.0f);
        ((I0)p0.i).n(0.0f);
        return h0;
    }

    public final Object q0(c c0) {
        p p0;
        j j0;
        if(c0 instanceof j) {
            j0 = (j)c0;
            int v = j0.D;
            if((v & 0x80000000) == 0) {
                j0 = new j(this, c0);
            }
            else {
                j0.D = v ^ 0x80000000;
            }
        }
        else {
            j0 = new j(this, c0);
        }
        Object object0 = j0.w;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(j0.D) {
            case 0: {
                d5.n.D(object0);
                j0.r = this;
                j0.D = 1;
                H h1 = e.c(((s)this.f).a, new Float(1.0f), null, null, j0, 14);
                if(h1 != a0) {
                    h1 = h0;
                }
                if(h1 == a0) {
                    return a0;
                }
                p0 = this;
                break;
            }
            case 1: {
                p0 = j0.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        float f = (float)p0.s0();
        ((I0)p0.j).n(f);
        float f1 = (float)p0.s0();
        ((I0)p0.i).n(f1);
        return h0;
    }

    public final long r0(long v) {
        float f2;
        if(this.c) {
            return 0L;
        }
        Z z0 = this.j;
        float f = b.e(v) + ((I0)z0).m();
        if(f < 0.0f) {
            f = 0.0f;
        }
        float f1 = f - ((I0)z0).m();
        ((I0)z0).n(f);
        if(((I0)z0).m() * 0.5f <= ((float)this.s0())) {
            f2 = ((I0)z0).m() * 0.5f;
        }
        else {
            float f3 = P4.a.i(Math.abs(((I0)z0).m() * 0.5f / ((float)this.s0())) - 1.0f, 0.0f, 2.0f);
            float f4 = ((float)this.s0()) * (f3 - ((float)Math.pow(f3, 2.0)) / 4.0f);
            f2 = ((float)this.s0()) + f4;
        }
        ((I0)this.i).n(f2);
        return v.h(0.0f, f1);
    }

    public final int s0() {
        return ((r1.c)f.i(this, k0.h)).z(this.g);
    }

    public final Object t0(float f, c c0) {
        p p0;
        d0.n n0;
        if(c0 instanceof d0.n) {
            n0 = (d0.n)c0;
            int v = n0.E;
            if((v & 0x80000000) == 0) {
                n0 = new d0.n(this, c0);
            }
            else {
                n0.E = v ^ 0x80000000;
            }
        }
        else {
            n0 = new d0.n(this, c0);
        }
        Object object0 = n0.B;
        ne.a a0 = ne.a.a;
        switch(n0.E) {
            case 0: {
                d5.n.D(object0);
                if(this.c) {
                    return new Float(0.0f);
                }
                if(((I0)this.j).m() * 0.5f > ((float)this.s0())) {
                    n0.r = this;
                    n0.w = f;
                    n0.E = 1;
                    if(this.q0(n0) == a0) {
                        return a0;
                    }
                    p0 = this;
                    p0.d.invoke();
                }
                else {
                    n0.r = this;
                    n0.w = f;
                    n0.E = 2;
                    if(this.p0(n0) == a0) {
                        return a0;
                    }
                    p0 = this;
                }
                break;
            }
            case 1: {
                f = n0.w;
                p0 = n0.r;
                d5.n.D(object0);
                p0.d.invoke();
                break;
            }
            case 2: {
                f = n0.w;
                p0 = n0.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((I0)p0.j).m() == 0.0f) {
            f = 0.0f;
        }
        else if(f < 0.0f) {
            f = 0.0f;
        }
        ((I0)p0.j).n(0.0f);
        return new Float(f);
    }
}

