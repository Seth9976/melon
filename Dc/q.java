package Dc;

import O.v;
import oe.c;

public final class q extends c {
    public float B;
    public Object D;
    public final u E;
    public int G;
    public Object r;
    public v w;

    public q(u u0, c c0) {
        this.E = u0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.c(null, 0.0f, this);
    }
}

