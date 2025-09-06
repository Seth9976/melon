package M2;

import java.io.Serializable;
import kotlinx.coroutines.sync.Mutex;

public final class c extends oe.c {
    public Serializable B;
    public Mutex D;
    public Object E;
    public final f G;
    public int I;
    public Object r;
    public Object w;

    public c(f f0, oe.c c0) {
        this.G = f0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return this.G.b(null, null, null, this);
    }
}

