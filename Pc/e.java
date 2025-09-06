package pc;

import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class e extends c {
    public Object B;
    public final q D;
    public int E;
    public Mutex r;
    public int w;

    public e(q q0, c c0) {
        this.D = q0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.a(this);
    }
}

