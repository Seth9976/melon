package gd;

import H0.e;
import com.melon.ui.W0;
import ie.H;
import we.a;

public final class h3 implements a {
    public final int a;
    public final k3 b;

    public h3(k3 k30, int v) {
        this.a = v;
        this.b = k30;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            k3 k30 = this.b;
            if(((E3)k30.getViewModel()).isEnableLoadMore()) {
                ((E3)k30.getViewModel()).updateUserEvent(new W0(null));
            }
            return H.a;
        }
        e.w(this.b);
        return H.a;
    }
}

