package nc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;
import we.n;

public final class q0 extends c {
    public Mutex B;
    public String D;
    public DevLog E;
    public Object G;
    public Mutex I;
    public boolean M;
    public int N;
    public int S;
    public int T;
    public int V;
    public long W;
    public Object X;
    public final u0 Y;
    public int Z;
    public n r;
    public String w;

    public q0(u0 u00, c c0) {
        this.Y = u00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.X = object0;
        this.Z |= 0x80000000;
        return this.Y.h(null, false, null, this);
    }
}

