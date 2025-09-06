package qc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oc.y0;
import oe.c;

public final class d0 extends c {
    public String B;
    public DevLog D;
    public Object E;
    public Mutex G;
    public int I;
    public int M;
    public long N;
    public Object S;
    public final n0 T;
    public int V;
    public y0 r;
    public Mutex w;

    public d0(n0 n00, c c0) {
        this.T = n00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.S = object0;
        this.V |= 0x80000000;
        return this.T.s(null, this);
    }
}

