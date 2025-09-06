package a3;

import I6.V;
import androidx.media3.session.e1;
import androidx.media3.session.n0;
import androidx.media3.session.w0;
import b3.E;
import b3.P;
import e3.j;

public final class e implements e1, j {
    public final int a;
    public final E b;

    public e(int v, E e0) {
        this.a = v;
        this.b = e0;
        super();
    }

    @Override  // androidx.media3.session.e1
    public Object e(n0 n00, w0 w00, int v) {
        switch(this.a) {
            case 1: {
                return n00.o(w00, V.t(this.b));
            }
            case 2: {
                return n00.o(w00, V.t(this.b));
            }
            default: {
                return n00.o(w00, V.t(this.b));
            }
        }
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        ((P)object0).t(2, this.b);
    }
}

