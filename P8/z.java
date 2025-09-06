package p8;

import ea.d;
import oe.c;

public final class z extends c {
    public Object B;
    public final d D;
    public int E;
    public boolean r;
    public boolean w;

    public z(d d0, c c0) {
        this.D = d0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.s(false, false, this);
    }
}

