package l2;

import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class f0 extends c {
    public Object B;
    public final i0 D;
    public int E;
    public Object r;
    public Mutex w;

    public f0(i0 i00, c c0) {
        this.D = i00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.b(null, this);
    }
}

