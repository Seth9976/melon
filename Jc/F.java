package jc;

import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;
import oe.c;
import oe.i;

public final class f extends c {
    public Semaphore B;
    public int D;
    public Object E;
    public final j G;
    public int I;
    public CoroutineScope r;
    public i w;

    public f(j j0, c c0) {
        this.G = j0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return this.G.d(null, null, this);
    }
}

