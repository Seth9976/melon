package ud;

import ie.H;
import we.k;

public final class x implements k {
    public final int a;
    public final C b;

    public x(C c0, int v) {
        this.a = v;
        this.b = c0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            m0 m00 = new m0(((Boolean)object0).booleanValue());
            this.b.sendUserEvent(m00);
            return H.a;
        }
        ((R0)this.b.getViewModel()).d.z(((long)(((Long)object0))));
        return H.a;
    }
}

