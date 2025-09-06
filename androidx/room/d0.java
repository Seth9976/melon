package androidx.room;

import oe.c;

public final class d0 extends c {
    public String[] B;
    public int D;
    public int E;
    public Object G;
    public final h0 I;
    public int M;
    public w r;
    public String w;

    public d0(h0 h00, c c0) {
        this.I = h00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.G = object0;
        this.M |= 0x80000000;
        return h0.d(this.I, null, 0, this);
    }
}

