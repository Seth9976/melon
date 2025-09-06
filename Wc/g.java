package wc;

import Ic.K;
import Ic.a0;
import Jc.N;
import Jc.c0;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class g implements k {
    public final int a;
    public final w b;
    public final int c;

    public g(w w0, int v, int v1) {
        this.a = v1;
        this.b = w0;
        this.c = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        int v = this.c;
        w w0 = this.b;
        if(this.a != 0) {
            q.g(((N)object0), "uiState");
            w0.onUserEvent(new K(((N)object0), v));
            return h0;
        }
        q.g(((c0)object0), "uiState");
        w0.onUserEvent(new a0(((c0)object0), v));
        return h0;
    }
}

