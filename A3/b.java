package a3;

import b3.P;
import b3.Q;
import e3.j;

public final class b implements j {
    public final int a;
    public final Q b;
    public final Q c;

    public b(Q q0, Q q1, int v) {
        this.a = v;
        this.b = q0;
        this.c = q1;
        super();
    }

    @Override  // e3.j
    public final void invoke(Object object0) {
        switch(this.a) {
            case 0: {
                ((P)object0).onPositionDiscontinuity(4);
                ((P)object0).r(this.b, this.c, 4);
                return;
            }
            case 1: {
                ((P)object0).onPositionDiscontinuity(0);
                ((P)object0).r(this.b, this.c, 0);
                return;
            }
            default: {
                ((P)object0).onPositionDiscontinuity(1);
                ((P)object0).r(this.b, this.c, 1);
            }
        }
    }
}

