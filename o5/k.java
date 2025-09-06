package o5;

import oe.c;

public final class k extends c {
    public Object B;
    public final l D;
    public int E;
    public l r;
    public j w;

    public k(l l0, c c0) {
        this.D = l0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.b(null, this);
    }
}

