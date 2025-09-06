package I;

import B0.b;
import B2.o;
import I0.d;
import I0.g;
import P0.f;
import androidx.compose.foundation.gestures.a;
import androidx.compose.foundation.m;
import androidx.compose.foundation.x0;
import d5.n;
import ie.H;
import kotlin.jvm.internal.G;
import oe.c;
import r1.q;

public final class g1 {
    public X0 a;
    public m b;
    public Z c;
    public u0 d;
    public boolean e;
    public d f;
    public final o g;
    public boolean h;
    public int i;
    public F0 j;
    public final d1 k;
    public final b l;

    public g1(X0 x00, m m0, Z z0, u0 u00, boolean z1, d d0, o o0) {
        this.a = x00;
        this.b = m0;
        this.c = z0;
        this.d = u00;
        this.e = z1;
        this.f = d0;
        this.g = o0;
        this.i = 1;
        this.j = a.a;
        this.k = new d1(this);
        this.l = new b(this, 8);
    }

    public static final long a(g1 g10, F0 f00, long v, int v1) {
        g g0 = g10.f.a;
        g g1 = null;
        g g2 = g0 == null || !g0.isAttached() ? null : ((g)f.j(g0));
        long v2 = 0L;
        long v3 = g2 == null ? 0L : g2.onPreScroll-OzD1aCk(v, v1);
        long v4 = x0.b.f(v, v3);
        long v5 = g10.d(g10.g(f00.a(g10.f(g10.d(x0.b.a((g10.d == u0.b ? 1 : 2), v4, 0.0f))))));
        long v6 = x0.b.f(v4, v5);
        g g3 = g10.f.a;
        if(g3 != null && g3.isAttached()) {
            g1 = (g)f.j(g3);
        }
        if(g1 != null) {
            v2 = g1.onPostScroll-DzOQY0M(v5, v6, v1);
        }
        return x0.b.g(x0.b.g(v3, v5), v2);
    }

    public final Object b(long v, c c0) {
        G g1;
        g1 g10;
        a1 a10;
        if(c0 instanceof a1) {
            a10 = (a1)c0;
            int v1 = a10.E;
            if((v1 & 0x80000000) == 0) {
                a10 = new a1(this, c0);
            }
            else {
                a10.E = v1 ^ 0x80000000;
            }
        }
        else {
            a10 = new a1(this, c0);
        }
        Object object0 = a10.B;
        ne.a a0 = ne.a.a;
        switch(a10.E) {
            case 0: {
                n.D(object0);
                G g0 = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
                g0.a = v;
                this.h = true;
                c1 c10 = new c1(this, g0, v, null);
                a10.r = this;
                a10.w = g0;
                a10.E = 1;
                if(this.e(x0.a, c10, a10) == a0) {
                    return a0;
                }
                g10 = this;
                g1 = g0;
                break;
            }
            case 1: {
                g1 = a10.w;
                g10 = a10.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        g10.h = false;
        return new q(g1.a);
    }

    // 去混淆评级： 低(20)
    public final float c(float f) {
        return this.e ? f * -1.0f : f;
    }

    // 去混淆评级： 低(20)
    public final long d(long v) {
        return this.e ? x0.b.h(v, -1.0f) : v;
    }

    public final Object e(x0 x00, we.n n0, c c0) {
        Object object0 = this.a.a(x00, new f1(this, n0, null), c0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    public final float f(long v) {
        return this.d == u0.b ? Float.intBitsToFloat(((int)(v >> 0x20))) : Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)));
    }

    public final long g(float f) {
        if(f == 0.0f) {
            return 0L;
        }
        return this.d == u0.b ? ((long)Float.floatToRawIntBits(f)) << 0x20 : ((long)Float.floatToRawIntBits(f)) & 0xFFFFFFFFL;
    }
}

