package wc;

import oe.c;

public final class h extends c {
    public int B;
    public Object r;
    public final w w;

    public h(w w0, c c0) {
        this.w = w0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return w.s(this.w, null, null, this);
    }
}

