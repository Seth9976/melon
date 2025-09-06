package P0;

import r0.p;

public final class o0 implements s0 {
    public final n0 a;

    public o0(n0 n00) {
        this.a = n00;
    }

    @Override  // P0.s0
    public final boolean G() {
        return ((p)this.a).getNode().isAttached();
    }
}

