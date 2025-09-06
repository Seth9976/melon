package Ac;

import oe.c;

public final class f2 extends c {
    public Object B;
    public final g2 D;
    public int E;
    public boolean r;
    public boolean w;

    public f2(g2 g20, c c0) {
        this.D = g20;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.j(false, false, this);
    }
}

