package M;

import N0.M;
import N0.N;
import N0.O;
import N0.a0;
import N0.p;
import df.d;
import java.util.List;
import kotlin.jvm.internal.q;
import r0.g;
import r1.a;
import r1.b;

public final class y implements l0, M {
    public final h a;
    public final g b;

    public y(h h0, g g0) {
        this.a = h0;
        this.b = g0;
    }

    @Override  // M.l0
    public final int a(a0 a00) {
        return a00.b;
    }

    @Override  // M.l0
    public final N b(a0[] arr_a0, O o0, int[] arr_v, int v, int v1, int[] arr_v1, int v2, int v3, int v4) {
        x x0 = new x(arr_a0, this, v1, o0, arr_v);
        return o0.w(v1, v, je.x.a, x0);
    }

    @Override  // M.l0
    public final void c(int v, int[] arr_v, int[] arr_v1, O o0) {
        this.a.c(o0, v, arr_v, arr_v1);
    }

    @Override  // M.l0
    public final long d(int v, int v1, int v2, boolean z) {
        return z ? d.q(0, v2, v, v1) : b.a(0, v2, v, v1);
    }

    @Override  // M.l0
    public final int e(a0 a00) {
        return a00.a;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof y && q.b(this.a, ((y)object0).a) && this.b.equals(((y)object0).b);
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.b.a) + this.a.hashCode() * 0x1F;
    }

    @Override  // N0.M
    public final int maxIntrinsicHeight(N0.q q0, List list0, int v) {
        int v1 = q0.z(this.a.a());
        if(list0.isEmpty()) {
            return 0;
        }
        int v3 = list0.size();
        int v4 = 0;
        int v5 = 0;
        float f = 0.0f;
        for(int v2 = 0; v2 < v3; ++v2) {
            p p0 = (p)list0.get(v2);
            float f1 = c.j(c.i(p0));
            int v6 = p0.d(v);
            if(f1 == 0.0f) {
                v5 += v6;
            }
            else if(f1 > 0.0f) {
                f += f1;
                v4 = Math.max(v4, Math.round(((float)v6) / f1));
            }
        }
        return (list0.size() - 1) * v1 + (Math.round(((float)v4) * f) + v5);
    }

    @Override  // N0.M
    public final int maxIntrinsicWidth(N0.q q0, List list0, int v) {
        int v8;
        int v1 = q0.z(this.a.a());
        if(list0.isEmpty()) {
            return 0;
        }
        int v3 = Math.min((list0.size() - 1) * v1, v);
        int v4 = list0.size();
        int v6 = 0;
        float f = 0.0f;
        for(int v5 = 0; v5 < v4; ++v5) {
            p p0 = (p)list0.get(v5);
            float f1 = c.j(c.i(p0));
            if(f1 == 0.0f) {
                int v7 = Math.min(p0.d(0x7FFFFFFF), (v == 0x7FFFFFFF ? 0x7FFFFFFF : v - v3));
                v3 += v7;
                v6 = Math.max(v6, p0.N(v7));
            }
            else if(f1 > 0.0f) {
                f += f1;
            }
        }
        if(f == 0.0f) {
            v8 = 0;
        }
        else {
            v8 = v == 0x7FFFFFFF ? 0x7FFFFFFF : Math.round(((float)Math.max(v - v3, 0)) / f);
        }
        int v9 = list0.size();
        for(int v2 = 0; v2 < v9; ++v2) {
            p p1 = (p)list0.get(v2);
            float f2 = c.j(c.i(p1));
            if(f2 > 0.0f) {
                v6 = Math.max(v6, p1.N((v8 == 0x7FFFFFFF ? 0x7FFFFFFF : Math.round(((float)v8) * f2))));
            }
        }
        return v6;
    }

    @Override  // N0.M
    public final N measure-3p2s80s(O o0, List list0, long v) {
        return c.k(this, a.i(v), a.j(v), a.g(v), a.h(v), o0.z(this.a.a()), o0, list0, new a0[list0.size()], 0, list0.size(), null, 0);
    }

    @Override  // N0.M
    public final int minIntrinsicHeight(N0.q q0, List list0, int v) {
        int v1 = q0.z(this.a.a());
        if(list0.isEmpty()) {
            return 0;
        }
        int v3 = list0.size();
        int v4 = 0;
        int v5 = 0;
        float f = 0.0f;
        for(int v2 = 0; v2 < v3; ++v2) {
            p p0 = (p)list0.get(v2);
            float f1 = c.j(c.i(p0));
            int v6 = p0.C(v);
            if(f1 == 0.0f) {
                v5 += v6;
            }
            else if(f1 > 0.0f) {
                f += f1;
                v4 = Math.max(v4, Math.round(((float)v6) / f1));
            }
        }
        return (list0.size() - 1) * v1 + (Math.round(((float)v4) * f) + v5);
    }

    @Override  // N0.M
    public final int minIntrinsicWidth(N0.q q0, List list0, int v) {
        int v8;
        int v1 = q0.z(this.a.a());
        if(list0.isEmpty()) {
            return 0;
        }
        int v3 = Math.min((list0.size() - 1) * v1, v);
        int v4 = list0.size();
        int v6 = 0;
        float f = 0.0f;
        for(int v5 = 0; v5 < v4; ++v5) {
            p p0 = (p)list0.get(v5);
            float f1 = c.j(c.i(p0));
            if(f1 == 0.0f) {
                int v7 = Math.min(p0.d(0x7FFFFFFF), (v == 0x7FFFFFFF ? 0x7FFFFFFF : v - v3));
                v3 += v7;
                v6 = Math.max(v6, p0.L(v7));
            }
            else if(f1 > 0.0f) {
                f += f1;
            }
        }
        if(f == 0.0f) {
            v8 = 0;
        }
        else {
            v8 = v == 0x7FFFFFFF ? 0x7FFFFFFF : Math.round(((float)Math.max(v - v3, 0)) / f);
        }
        int v9 = list0.size();
        for(int v2 = 0; v2 < v9; ++v2) {
            p p1 = (p)list0.get(v2);
            float f2 = c.j(c.i(p1));
            if(f2 > 0.0f) {
                v6 = Math.max(v6, p1.L((v8 == 0x7FFFFFFF ? 0x7FFFFFFF : Math.round(((float)v8) * f2))));
            }
        }
        return v6;
    }

    @Override
    public final String toString() {
        return "ColumnMeasurePolicy(verticalArrangement=" + this.a + ", horizontalAlignment=" + this.b + ')';
    }
}

