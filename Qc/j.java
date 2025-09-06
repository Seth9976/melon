package qc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class j extends c {
    public DevLog B;
    public Object D;
    public Mutex E;
    public int G;
    public int I;
    public long M;
    public Object N;
    public final n0 S;
    public int T;
    public Mutex r;
    public String w;

    public j(n0 n00, c c0) {
        this.S = n00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.N = object0;
        this.T |= 0x80000000;
        return this.S.t(this);
    }
}

