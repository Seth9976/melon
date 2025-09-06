package androidx.media3.exoplayer;

import b3.E;
import b3.P;
import e3.j;

public final class v implements j {
    public final int a;
    public final E b;
    public final int c;

    public v(E e0, int v, int v1) {
        this.a = v1;
        this.b = e0;
        this.c = v;
        super();
    }

    @Override  // e3.j
    public final void invoke(Object object0) {
        if(this.a != 0) {
            ((P)object0).t(this.c, this.b);
            return;
        }
        ((P)object0).t(this.c, this.b);
    }
}

