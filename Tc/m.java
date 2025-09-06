package tc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class m extends c {
    public String B;
    public DevLog D;
    public String E;
    public Mutex G;
    public Object I;
    public final x M;
    public int N;
    public long r;
    public Mutex w;

    public m(x x0, c c0) {
        this.M = x0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.I = object0;
        this.N |= 0x80000000;
        return this.M.r(0L, this);
    }
}

