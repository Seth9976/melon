package androidx.compose.runtime;

import df.v;
import me.g;
import me.h;
import me.i;
import we.n;

public final class f implements g {
    public static final V a;

    static {
        f.a = new V(5);
    }

    @Override  // me.i
    public final Object fold(Object object0, n n0) {
        return v.v(this, object0, n0);
    }

    @Override  // me.i
    public final g get(h h0) {
        return v.w(this, h0);
    }

    @Override  // me.g
    public final h getKey() {
        return f.a;
    }

    @Override  // me.i
    public final i minusKey(h h0) {
        return v.E(this, h0);
    }

    @Override  // me.i
    public final i plus(i i0) {
        return v.F(i0, this);
    }
}

