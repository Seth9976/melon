package n5;

import oe.c;

public final class k extends c {
    public Object B;
    public Object D;
    public final l E;
    public int G;
    public l r;
    public hg.c w;

    public k(l l0, c c0) {
        this.E = l0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.a(this);
    }
}

