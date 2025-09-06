package jb;

import i.n.i.b.a.s.e.Ga;
import oe.c;

public final class a extends c {
    public int B;
    public Object r;
    public final Ga w;

    public a(Ga ga0, c c0) {
        this.w = ga0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return this.w.c(this);
    }
}

