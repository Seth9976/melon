package n2;

import oe.c;

public final class g extends c {
    public boolean B;
    public Object D;
    public final i E;
    public int G;
    public i r;
    public n2.c w;

    public g(i i0, c c0) {
        this.E = i0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.b(null, this);
    }
}

