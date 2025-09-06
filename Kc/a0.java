package kc;

import com.melon.playlist.b;
import oe.c;

public final class a0 extends c {
    public boolean B;
    public Object D;
    public Object E;
    public final b G;
    public int I;
    public int r;
    public long w;

    public a0(b b0, c c0) {
        this.G = b0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return this.G.P(0, 0L, false, this);
    }
}

