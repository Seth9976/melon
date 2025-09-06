package rc;

import kotlinx.coroutines.sync.Mutex;

public final class c extends oe.c {
    public final m B;
    public int D;
    public Mutex r;
    public Object w;

    public c(m m0, oe.c c0) {
        this.B = m0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.b(this);
    }
}

