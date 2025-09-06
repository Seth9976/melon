package z4;

import oe.c;

public final class r extends c {
    public boolean B;
    public Object D;
    public final u E;
    public int G;
    public u r;
    public h w;

    public r(u u0, c c0) {
        this.E = u0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.f(false, this);
    }
}

