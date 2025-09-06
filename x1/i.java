package x1;

import N0.X;
import Q0.N;
import we.k;

public final class i extends N implements X {
    public final e c;
    public final k d;

    public i(e e0, k k0) {
        this.c = e0;
        this.d = k0;
    }

    @Override  // N0.X
    public final Object a() {
        return new h(this.c, this.d);
    }

    @Override
    public final boolean equals(Object object0) {
        k k0 = null;
        i i0 = object0 instanceof i ? ((i)object0) : null;
        if(i0 != null) {
            k0 = i0.d;
        }
        return this.d == k0;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode();
    }
}

