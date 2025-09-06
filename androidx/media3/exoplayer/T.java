package androidx.media3.exoplayer;

import b3.P;
import b3.u0;
import e3.j;

public final class t implements j {
    public final int a;
    public final u0 b;

    public t(u0 u00, int v) {
        this.a = v;
        this.b = u00;
        super();
    }

    @Override  // e3.j
    public final void invoke(Object object0) {
        if(this.a != 0) {
            ((P)object0).D(this.b);
            return;
        }
        ((P)object0).D(this.b);
    }
}

