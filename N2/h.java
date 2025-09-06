package n2;

import oe.c;
import okio.Path;

public final class h extends c {
    public Path B;
    public Object D;
    public Object E;
    public final i G;
    public int I;
    public i r;
    public Object w;

    public h(i i0, c c0) {
        this.G = i0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return this.G.a(null, this);
    }
}

