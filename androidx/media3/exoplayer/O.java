package androidx.media3.exoplayer;

import androidx.media3.session.o1;
import b3.G;
import b3.P;
import e3.e;
import e3.j;

public final class o implements e, j {
    public final int a;
    public final G b;

    public o(G g0, int v) {
        this.a = v;
        this.b = g0;
        super();
    }

    @Override  // e3.e
    public void accept(Object object0) {
        ((o1)object0).K(this.b);
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        if(this.a != 0) {
            ((P)object0).u0(this.b);
            return;
        }
        ((P)object0).J0(this.b);
    }
}

