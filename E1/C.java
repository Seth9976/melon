package e1;

import java.util.List;

public final class c extends oe.c {
    public H B;
    public int D;
    public int E;
    public Object G;
    public final d I;
    public int M;
    public d r;
    public List w;

    public c(d d0, oe.c c0) {
        this.I = d0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.G = object0;
        this.M |= 0x80000000;
        return this.I.a(this);
    }
}

