package a3;

import androidx.media3.session.o1;
import b3.L;
import b3.P;
import e3.e;
import e3.j;

public final class d implements e, j {
    public final int a;
    public final L b;

    public d(L l0, int v) {
        this.a = v;
        this.b = l0;
        super();
    }

    @Override  // e3.e
    public void accept(Object object0) {
        ((o1)object0).a(this.b);
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        switch(this.a) {
            case 0: {
                ((P)object0).n(this.b);
                return;
            }
            case 1: {
                ((P)object0).n(this.b);
                return;
            }
            default: {
                ((P)object0).n(this.b);
            }
        }
    }
}

