package Q7;

import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class a extends c {
    public Object B;
    public final d D;
    public int E;
    public Object r;
    public Mutex w;

    public a(d d0, c c0) {
        this.D = d0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.d(this);
    }
}

