package J2;

import B2.i;
import B2.l;

public final class n implements i {
    public B2.n a;

    public n() {
        this.a = l.a;
    }

    @Override  // B2.i
    public final void a(B2.n n0) {
        this.a = n0;
    }

    @Override  // B2.i
    public final B2.n b() {
        return this.a;
    }

    @Override  // B2.i
    public final i copy() {
        i i0 = new n();
        i0.a = this.a;
        return i0;
    }

    @Override
    public final String toString() {
        return "EmittableSpacer(modifier=" + this.a + ')';
    }
}

