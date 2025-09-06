package a3;

import androidx.media3.session.o1;
import b3.P;
import e3.e;
import e3.j;

public final class g implements e, j {
    public final int a;
    public final boolean b;
    public final int c;

    public g(boolean z, int v, int v1) {
        this.a = v1;
        this.b = z;
        this.c = v;
        super();
    }

    @Override  // e3.e
    public void accept(Object object0) {
        ((o1)object0).d(this.c, this.b);
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        if(this.a != 0) {
            ((P)object0).p0(this.c, this.b);
            return;
        }
        ((P)object0).onPlayerStateChanged(this.b, this.c);
    }
}

