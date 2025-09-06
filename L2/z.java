package l2;

import kotlin.coroutines.Continuation;
import oe.c;

public final class z extends c {
    public boolean B;
    public Object D;
    public final M E;
    public int G;
    public M r;
    public j0 w;

    public z(M m0, Continuation continuation0) {
        this.E = m0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return M.e(this.E, false, this);
    }
}

