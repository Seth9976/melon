package uc;

import com.iloen.melon.utils.log.DevLog;
import java.util.List;
import kotlinx.coroutines.sync.Mutex;
import oc.V;
import oe.c;

public final class m extends c {
    public String B;
    public DevLog D;
    public Object E;
    public Mutex G;
    public List I;
    public int M;
    public int N;
    public int S;
    public int T;
    public int V;
    public long W;
    public Object X;
    public final A Y;
    public int Z;
    public V r;
    public Mutex w;

    public m(A a0, c c0) {
        this.Y = a0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.X = object0;
        this.Z |= 0x80000000;
        return this.Y.u(null, this);
    }
}

