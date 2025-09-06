package qc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class y extends c {
    public String B;
    public DevLog D;
    public String E;
    public Mutex G;
    public Object I;
    public final n0 M;
    public int N;
    public String r;
    public Mutex w;

    public y(n0 n00, c c0) {
        this.M = n00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.I = object0;
        this.N |= 0x80000000;
        return this.M.a(null, this);
    }
}

