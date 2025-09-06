package androidx.room;

import oe.c;

public final class c0 extends c {
    public String B;
    public String[] D;
    public int E;
    public int G;
    public int I;
    public Object M;
    public final h0 N;
    public int S;
    public h0 r;
    public w w;

    public c0(h0 h00, c c0) {
        this.N = h00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.M = object0;
        this.S |= 0x80000000;
        return h0.c(this.N, null, 0, this);
    }
}

