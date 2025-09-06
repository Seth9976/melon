package tg;

import ie.H;
import we.k;

public final class v implements k {
    public final int a;
    public final d b;

    public v(d d0, int v) {
        this.a = v;
        this.b = d0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                Throwable throwable1 = (Throwable)object0;
                this.b.cancel();
                return H.a;
            }
            case 1: {
                Throwable throwable2 = (Throwable)object0;
                this.b.cancel();
                return H.a;
            }
            default: {
                Throwable throwable0 = (Throwable)object0;
                this.b.cancel();
                return H.a;
            }
        }
    }
}

