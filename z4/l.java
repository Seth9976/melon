package z4;

import kotlin.jvm.internal.H;
import oe.c;
import we.a;

public final class l extends c {
    public H B;
    public long D;
    public Object E;
    public final n G;
    public int I;
    public n r;
    public a w;

    public l(n n0, c c0) {
        this.G = n0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return this.G.b(0L, null, this);
    }
}

