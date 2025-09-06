package uc;

import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class q extends c {
    public int B;
    public Object D;
    public final A E;
    public int G;
    public Mutex r;
    public Integer w;

    public q(A a0, c c0) {
        this.E = a0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.g(this);
    }
}

