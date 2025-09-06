package sc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class n0 extends c {
    public String B;
    public DevLog D;
    public Object E;
    public Mutex G;
    public int I;
    public int M;
    public long N;
    public Object S;
    public final P0 T;
    public int V;
    public boolean r;
    public Mutex w;

    public n0(P0 p00, c c0) {
        this.T = p00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.S = object0;
        this.V |= 0x80000000;
        return this.T.m(false, this);
    }
}

