package kc;

import Nb.z0;
import ac.x;
import b3.E;
import ec.g;
import oe.c;

public final class z1 extends c {
    public x B;
    public g D;
    public Object E;
    public final A1 G;
    public int I;
    public E r;
    public z0 w;

    public z1(A1 a10, c c0) {
        this.G = a10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return this.G.c(null, null, null, this);
    }
}

