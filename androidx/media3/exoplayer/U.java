package androidx.media3.exoplayer;

import b3.P;
import b3.Q;
import e3.j;

public final class u implements j {
    public final int a;
    public final int b;
    public final Q c;
    public final Q d;

    public u(int v, Q q0, Q q1, int v1) {
        this.a = v1;
        this.b = v;
        this.c = q0;
        this.d = q1;
        super();
    }

    @Override  // e3.j
    public final void invoke(Object object0) {
        if(this.a != 0) {
            ((P)object0).onPositionDiscontinuity(this.b);
            ((P)object0).r(this.c, this.d, this.b);
            return;
        }
        ((P)object0).onPositionDiscontinuity(this.b);
        ((P)object0).r(this.c, this.d, this.b);
    }
}

