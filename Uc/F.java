package uc;

import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class f extends c {
    public final j B;
    public int D;
    public Mutex r;
    public Object w;

    public f(j j0, c c0) {
        this.B = j0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.b(this);
    }
}

