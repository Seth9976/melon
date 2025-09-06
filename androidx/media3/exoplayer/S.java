package androidx.media3.exoplayer;

import b3.P;
import b3.d;
import e3.j;

public final class s implements j {
    public final int a;
    public final d b;

    public s(d d0, int v) {
        this.a = v;
        this.b = d0;
        super();
    }

    @Override  // e3.j
    public final void invoke(Object object0) {
        if(this.a != 0) {
            ((P)object0).A0(this.b);
            return;
        }
        ((P)object0).A0(this.b);
    }
}

