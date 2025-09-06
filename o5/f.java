package o5;

import oe.c;

public final class f extends c {
    public Object B;
    public final i D;
    public int E;
    public i r;
    public l w;

    public f(i i0, c c0) {
        this.D = i0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.a(null, this);
    }
}

