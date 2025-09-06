package Vb;

import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class a0 extends c {
    public int B;
    public Object D;
    public final o0 E;
    public int G;
    public Mutex r;
    public int w;

    public a0(o0 o00, c c0) {
        this.E = o00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.n1(this);
    }
}

