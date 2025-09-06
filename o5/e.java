package o5;

import i5.b;
import oe.c;
import t5.j;
import t5.o;

public final class e extends c {
    public j B;
    public Object D;
    public o E;
    public i5.c G;
    public int I;
    public Object M;
    public final i N;
    public int S;
    public i r;
    public b w;

    public e(i i0, c c0) {
        this.N = i0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.M = object0;
        this.S |= 0x80000000;
        return this.N.d(null, null, null, null, null, this);
    }
}

