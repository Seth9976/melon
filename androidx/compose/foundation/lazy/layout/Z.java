package androidx.compose.foundation.lazy.layout;

import N0.L;
import N0.N;
import N0.O;
import N0.k0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r1.m;
import we.k;
import we.n;

public final class z implements O {
    public final u a;
    public final k0 b;
    public final v c;
    public final androidx.collection.z d;

    public z(u u0, k0 k00) {
        this.a = u0;
        this.b = k00;
        this.c = (v)u0.b.invoke();
        this.d = new androidx.collection.z();
    }

    @Override  // r1.c
    public final float B(long v) {
        return this.b.B(v);
    }

    @Override  // r1.c
    public final float R(int v) {
        return this.b.R(v);
    }

    @Override  // r1.c
    public final float S(float f) {
        return this.b.S(f);
    }

    @Override  // r1.c
    public final float W() {
        return this.b.W();
    }

    @Override  // r1.c
    public final float Y(float f) {
        return this.b.Y(f);
    }

    public final List a(int v, long v1) {
        androidx.collection.z z0 = this.d;
        List list0 = (List)z0.b(v);
        if(list0 != null) {
            return list0;
        }
        Object object0 = this.c.c(v);
        n n0 = this.a.a(v, object0, this.c.a(v));
        List list1 = this.b.c0(object0, n0);
        int v2 = list1.size();
        List list2 = new ArrayList(v2);
        for(int v3 = 0; v3 < v2; ++v3) {
            ((ArrayList)list2).add(((L)list1.get(v3)).O(v1));
        }
        z0.h(v, list2);
        return list2;
    }

    @Override  // r1.c
    public final float b() {
        return this.b.b();
    }

    @Override  // N0.q
    public final m getLayoutDirection() {
        return this.b.getLayoutDirection();
    }

    @Override  // r1.c
    public final long i0(long v) {
        return this.b.i0(v);
    }

    @Override  // r1.c
    public final long j(float f) {
        return this.b.j(f);
    }

    @Override  // r1.c
    public final long k(long v) {
        return this.b.k(v);
    }

    @Override  // r1.c
    public final float m(long v) {
        return this.b.m(v);
    }

    @Override  // N0.O
    public final N n(int v, int v1, Map map0, k k0) {
        return this.b.n(v, v1, map0, k0);
    }

    @Override  // r1.c
    public final long p(float f) {
        return this.b.p(f);
    }

    @Override  // N0.q
    public final boolean u() {
        return this.b.u();
    }

    @Override  // N0.O
    public final N w(int v, int v1, Map map0, k k0) {
        return this.b.w(v, v1, map0, k0);
    }

    @Override  // r1.c
    public final int z(float f) {
        return this.b.z(f);
    }
}

