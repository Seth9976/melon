package tc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class i extends c {
    public DevLog B;
    public Object D;
    public Mutex E;
    public int G;
    public int I;
    public int M;
    public long N;
    public Object S;
    public final x T;
    public int V;
    public Mutex r;
    public String w;

    public i(x x0, c c0) {
        this.T = x0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.S = object0;
        this.V |= 0x80000000;
        return this.T.z(this);
    }
}

