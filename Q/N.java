package Q;

import je.p;
import x1.a;

public final class n implements androidx.compose.foundation.lazy.layout.n {
    public final K a;
    public final int b;

    public n(K k0, int v) {
        this.a = k0;
        this.b = v;
    }

    @Override  // androidx.compose.foundation.lazy.layout.n
    public final int a() {
        K k0 = this.a;
        if(k0.k().a.size() == 0) {
            return 0;
        }
        int v = a.B(k0.k());
        A a0 = k0.k();
        A a1 = k0.k();
        int v1 = a0.b + a1.c;
        if(v1 == 0) {
            return 1;
        }
        int v2 = v / v1;
        return v2 >= 1 ? v2 : 1;
    }

    @Override  // androidx.compose.foundation.lazy.layout.n
    public final boolean b() {
        return !this.a.k().a.isEmpty();
    }

    @Override  // androidx.compose.foundation.lazy.layout.n
    public final int c() {
        return Math.max(0, this.a.e - this.b);
    }

    @Override  // androidx.compose.foundation.lazy.layout.n
    public final int d() {
        return Math.min(this.a.l() - 1, ((j)p.s0(this.a.k().a)).a + this.b);
    }

    @Override  // androidx.compose.foundation.lazy.layout.n
    public final int getItemCount() {
        return this.a.l();
    }
}

