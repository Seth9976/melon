package W;

import V3.d;
import f1.g;

public final class o implements g {
    public final g[] a;

    public o(g[] arr_g) {
        this.a = arr_g;
    }

    @Override  // f1.g
    public final void a(d d0) {
        g[] arr_g = this.a;
        for(int v = 0; v < arr_g.length; ++v) {
            arr_g[v].a(d0);
        }
    }
}

