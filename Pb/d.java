package pb;

import e3.h;
import oe.c;
import oe.i;

public final class d extends c {
    public i B;
    public String D;
    public String E;
    public long G;
    public Object I;
    public final h M;
    public int N;
    public boolean r;
    public boolean w;

    public d(h h0, c c0) {
        this.M = h0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.I = object0;
        this.N |= 0x80000000;
        return this.M.r(false, null, false, 0L, null, null, this);
    }
}

