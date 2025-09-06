package Ic;

import Jc.N;
import Jc.c0;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class l0 implements k {
    public final int a;
    public final A0 b;
    public final int c;

    public l0(A0 a00, int v, int v1) {
        this.a = v1;
        this.b = a00;
        this.c = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        int v = this.c;
        A0 a00 = this.b;
        if(this.a != 0) {
            q.g(((c0)object0), "uiState");
            a00.onUserEvent(new a0(((c0)object0), v));
            return h0;
        }
        q.g(((N)object0), "uiState");
        a00.onUserEvent(new K(((N)object0), v));
        return h0;
    }
}

