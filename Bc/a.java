package bc;

import Nb.z0;
import Va.b;
import ac.B;
import b3.E;
import oe.c;

public final class a extends c {
    public b B;
    public Object D;
    public B E;
    public int G;
    public int I;
    public Object M;
    public final bc.c N;
    public int S;
    public E r;
    public z0 w;

    public a(bc.c c0, c c1) {
        this.N = c0;
        super(c1);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.M = object0;
        this.S |= 0x80000000;
        return this.N.a(null, null, 0, this);
    }
}

