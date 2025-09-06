package pc;

import java.util.Collection;
import java.util.List;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class i extends c {
    public List B;
    public Mutex D;
    public int E;
    public Object G;
    public final q I;
    public int M;
    public List r;
    public Collection w;

    public i(q q0, c c0) {
        this.I = q0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.G = object0;
        this.M |= 0x80000000;
        return this.I.c(null, null, null, this);
    }
}

