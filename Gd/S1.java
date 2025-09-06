package gd;

import H0.e;
import com.melon.ui.W0;
import ie.H;
import we.a;

public final class s1 implements a {
    public final int a;
    public final u1 b;

    public s1(u1 u10, int v) {
        this.a = v;
        this.b = u10;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                ((V1)this.b.getViewModel()).d(false);
                return H.a;
            }
            case 1: {
                ((V1)this.b.getViewModel()).d(false);
                return H.a;
            }
            case 2: {
                e.w(this.b);
                return H.a;
            }
            default: {
                u1 u10 = this.b;
                if(((V1)u10.getViewModel()).isEnableLoadMore()) {
                    u10.sendUserEvent(new W0(null));
                }
                return H.a;
            }
        }
    }
}

