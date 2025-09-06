package l2;

import df.v;
import me.g;
import me.h;
import me.i;
import we.n;

public final class p0 implements g {
    public final p0 a;
    public final M b;

    public p0(p0 p00, M m0) {
        this.a = p00;
        this.b = m0;
    }

    public final void a(M m0) {
        if(this.b == m0) {
            throw new IllegalStateException("Calling updateData inside updateData on the same DataStore instance is not supported\nsince updates made in the parent updateData call will not be visible to the nested\nupdateData call. See https://issuetracker.google.com/issues/241760537 for details.");
        }
        p0 p00 = this.a;
        if(p00 != null) {
            p00.a(m0);
        }
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
        return o0.a;
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

