package nc;

import kotlinx.coroutines.sync.Mutex;
import oc.j;
import oe.c;

public final class z extends c {
    public int B;
    public Object D;
    public final u0 E;
    public int G;
    public Mutex r;
    public j w;

    public z(u0 u00, c c0) {
        this.E = u00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.B(this);
    }
}

