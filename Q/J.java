package Q;

import I.u0;
import L.a;
import N0.a0;
import i.n.i.b.a.s.e.M3;
import java.util.List;
import r0.g;
import r0.h;
import r1.m;

public final class j {
    public final int a;
    public final List b;
    public final long c;
    public final Object d;
    public final g e;
    public final h f;
    public final m g;
    public final boolean h;
    public final boolean i;
    public final int j;
    public final int[] k;
    public int l;
    public int m;

    public j(int v, int v1, List list0, long v2, Object object0, u0 u00, g g0, h h0, m m0, boolean z) {
        this.a = v;
        this.b = list0;
        this.c = v2;
        this.d = object0;
        this.e = g0;
        this.f = h0;
        this.g = m0;
        this.h = z;
        this.i = u00 == u0.a;
        int v4 = list0.size();
        int v5 = 0;
        for(int v3 = 0; v3 < v4; ++v3) {
            a0 a00 = (a0)list0.get(v3);
            v5 = Math.max(v5, (this.i ? a00.a : a00.b));
        }
        this.j = v5;
        this.k = new int[this.b.size() * 2];
        this.m = 0x80000000;
    }

    public final void a(int v) {
        this.l += v;
        int[] arr_v = this.k;
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            if(this.i && v1 % 2 == 1 || !this.i && v1 % 2 == 0) {
                arr_v[v1] += v;
            }
        }
    }

    public final void b(int v, int v1, int v2) {
        int v5;
        this.l = v;
        boolean z = this.i;
        this.m = z ? v2 : v1;
        List list0 = this.b;
        int v3 = list0.size();
        int v4 = 0;
        while(v4 < v3) {
            a0 a00 = (a0)list0.get(v4);
            int[] arr_v = this.k;
            if(z) {
                g g0 = this.e;
                if(g0 != null) {
                    arr_v[v4 * 2] = g0.a(a00.a, v1, this.g);
                    arr_v[v4 * 2 + 1] = v;
                    v5 = a00.b;
                    v += v5;
                    ++v4;
                    continue;
                }
                a.b("null horizontalAlignment");
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            else {
                arr_v[v4 * 2] = v;
                h h0 = this.f;
                if(h0 == null) {
                    a.b("null verticalAlignment");
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                arr_v[v4 * 2 + 1] = h0.a(a00.b, v2);
                v5 = a00.a;
            }
            v += v5;
            ++v4;
        }
    }
}

