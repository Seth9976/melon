package androidx.media3.exoplayer;

import B7.b;
import b3.P;
import b3.n;
import b3.z0;
import e3.j;
import i3.a;

public final class w implements j {
    public final int a;
    public final z0 b;

    public w(z0 z00) {
        this.a = 0;
        super();
        this.b = z00;
    }

    public w(a a0, z0 z00) {
        this.a = 1;
        super();
        this.b = z00;
    }

    @Override  // e3.j
    public final void invoke(Object object0) {
        if(this.a != 0) {
            b b0 = ((i3.j)(((i3.b)object0))).o;
            z0 z00 = this.b;
            if(b0 != null) {
                androidx.media3.common.b b1 = (androidx.media3.common.b)b0.c;
                if(b1.v == -1) {
                    n n0 = b1.a();
                    n0.t = z00.a;
                    n0.u = z00.b;
                    androidx.media3.common.b b2 = new androidx.media3.common.b(n0);
                    ((i3.j)(((i3.b)object0))).o = new b(b0.a, b2, ((String)b0.b));
                }
            }
            return;
        }
        ((P)object0).c0(this.b);
    }
}

