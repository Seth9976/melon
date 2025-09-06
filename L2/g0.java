package l2;

import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class g0 extends c {
    public Object B;
    public final i0 D;
    public int E;
    public Mutex r;
    public boolean w;

    public g0(i0 i00, c c0) {
        this.D = i00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.c(null, this);
    }
}

