package tc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oc.V;

public final class c extends oe.c {
    public String B;
    public DevLog D;
    public Object E;
    public Mutex G;
    public int I;
    public int M;
    public long N;
    public Object S;
    public final x T;
    public int V;
    public V r;
    public Mutex w;

    public c(x x0, oe.c c0) {
        this.T = x0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.S = object0;
        this.V |= 0x80000000;
        return this.T.u(null, this);
    }
}

