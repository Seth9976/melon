package uc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oc.j;
import oe.c;

public final class r extends c {
    public DevLog B;
    public Object D;
    public Mutex E;
    public j G;
    public int I;
    public int M;
    public long N;
    public Object S;
    public final A T;
    public int V;
    public Mutex r;
    public String w;

    public r(A a0, c c0) {
        this.T = a0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.S = object0;
        this.V |= 0x80000000;
        return this.T.B(this);
    }
}

