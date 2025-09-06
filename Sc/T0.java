package sc;

import java.util.LinkedList;
import k8.a;
import oc.y0;
import oe.c;

public final class t0 extends c {
    public String B;
    public LinkedList D;
    public P0 E;
    public boolean G;
    public Object I;
    public final P0 M;
    public int N;
    public y0 r;
    public a w;

    public t0(P0 p00, c c0) {
        this.M = p00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.I = object0;
        this.N |= 0x80000000;
        return P0.I(this.M, null, false, this);
    }
}

