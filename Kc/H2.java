package kc;

import java.util.List;
import oe.c;

public final class h2 extends c {
    public long B;
    public boolean D;
    public Object E;
    public final r2 G;
    public int I;
    public List r;
    public String w;

    public h2(r2 r20, c c0) {
        this.G = r20;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return this.G.a(null, null, this);
    }
}

