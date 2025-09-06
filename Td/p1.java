package td;

import oe.c;

public final class p1 extends c {
    public int B;
    public Object r;
    public final t1 w;

    public p1(t1 t10, c c0) {
        this.w = t10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return t1.d(this.w, this);
    }
}

