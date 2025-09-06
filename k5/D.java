package k5;

import kotlinx.coroutines.sync.Semaphore;
import oe.c;

public final class d extends c {
    public Object B;
    public final e D;
    public int E;
    public Object r;
    public Semaphore w;

    public d(e e0, c c0) {
        this.D = e0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.a(this);
    }
}

