package pc;

import java.util.ArrayList;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class o extends c {
    public int B;
    public Object D;
    public final q E;
    public int G;
    public ArrayList r;
    public Mutex w;

    public o(q q0, c c0) {
        this.E = q0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.f(null, this);
    }
}

