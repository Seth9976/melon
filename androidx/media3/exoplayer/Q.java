package androidx.media3.exoplayer;

import androidx.media3.session.o1;
import b3.P;
import e3.e;
import e3.j;

public final class q implements e, j {
    public final int a;
    public final int b;
    public final int c;

    public q(int v, int v1, int v2) {
        this.a = v2;
        this.b = v;
        this.c = v1;
        super();
    }

    @Override  // e3.e
    public void accept(Object object0) {
        if(this.a != 2) {
            ((o1)object0).M(this.b, this.c);
            return;
        }
        ((o1)object0).C(this.b, this.c);
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        if(this.a != 0) {
            ((P)object0).onSurfaceSizeChanged(this.b, this.c);
            return;
        }
        ((P)object0).onSurfaceSizeChanged(this.b, this.c);
    }
}

