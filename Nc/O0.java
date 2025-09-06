package nc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class o0 extends c {
    public String B;
    public DevLog D;
    public Object E;
    public Mutex G;
    public int I;
    public int M;
    public long N;
    public Object S;
    public final u0 T;
    public int V;
    public String r;
    public Mutex w;

    public o0(u0 u00, c c0) {
        this.T = u00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.S = object0;
        this.V |= 0x80000000;
        return this.T.T(null, this);
    }
}

