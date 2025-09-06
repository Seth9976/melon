package l2;

import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class t extends c {
    public Object B;
    public final M D;
    public int E;
    public M r;
    public Mutex w;

    public t(M m0, c c0) {
        this.D = m0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return M.b(this.D, this);
    }
}

