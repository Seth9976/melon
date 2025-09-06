package a3;

import android.util.SparseArray;
import android.util.SparseIntArray;
import b3.E;
import b3.b;
import b3.m0;
import b3.o0;
import b3.p0;
import java.util.Arrays;

public final class p extends p0 {
    public final SparseIntArray e;
    public final E[] f;
    public final int[] g;
    public final long[] h;
    public final long[] i;
    public final boolean[] j;
    public static final p k;

    static {
        SparseArray sparseArray0 = new SparseArray();
        p.k = new p(new int[0], sparseArray0);
    }

    public p(int[] arr_v, SparseArray sparseArray0) {
        this.e = new SparseIntArray(arr_v.length);
        this.g = Arrays.copyOf(arr_v, arr_v.length);
        this.h = new long[arr_v.length];
        this.i = new long[arr_v.length];
        this.j = new boolean[arr_v.length];
        this.f = new E[arr_v.length];
        for(int v = 0; true; ++v) {
            int[] arr_v1 = this.g;
            if(v >= arr_v1.length) {
                break;
            }
            int v1 = arr_v1[v];
            this.e.put(v1, v);
            o o0 = (o)sparseArray0.get(v1, o.f);
            this.f[v] = o0.d;
            this.h[v] = o0.a;
            this.i[v] = o0.b == 0x8000000000000001L ? 0L : o0.b;
            this.j[v] = o0.c;
        }
    }

    // 去混淆评级： 低(20)
    @Override  // b3.p0
    public final int b(Object object0) {
        return object0 instanceof Integer ? this.e.get(((int)(((Integer)object0))), -1) : -1;
    }

    @Override  // b3.p0
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof p ? Arrays.equals(this.g, ((p)object0).g) && Arrays.equals(this.h, ((p)object0).h) && Arrays.equals(this.i, ((p)object0).i) && Arrays.equals(this.j, ((p)object0).j) : false;
    }

    @Override  // b3.p0
    public final m0 f(int v, m0 m00, boolean z) {
        int v1 = this.g[v];
        long v2 = this.h[v];
        m00.getClass();
        m00.i(v1, v1, v, v2, 0L, b.f, false);
        return m00;
    }

    @Override  // b3.p0
    public final int h() {
        return this.g.length;
    }

    @Override  // b3.p0
    public final int hashCode() {
        int v = Arrays.hashCode(this.g);
        int v1 = Arrays.hashCode(this.h);
        int v2 = Arrays.hashCode(this.i);
        return Arrays.hashCode(this.j) + (v2 + (v1 + v * 0x1F) * 0x1F) * 0x1F;
    }

    @Override  // b3.p0
    public final Object l(int v) {
        return (int)this.g[v];
    }

    @Override  // b3.p0
    public final o0 m(int v, o0 o00, long v1) {
        long v2 = this.h[v];
        int v3 = v2 == 0x8000000000000001L ? 1 : 0;
        Integer integer0 = (int)this.g[v];
        E e0 = this.f[v];
        o00.b(integer0, e0, null, 0x8000000000000001L, 0x8000000000000001L, 0x8000000000000001L, ((boolean)(v3 ^ 1)), ((boolean)v3), (this.j[v] ? e0.c : null), this.i[v], v2, v, v, 0L);
        return o00;
    }

    @Override  // b3.p0
    public final int o() {
        return this.g.length;
    }
}

