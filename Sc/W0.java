package sc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class w0 extends c {
    public String B;
    public P0 D;
    public DevLog E;
    public Object G;
    public Mutex I;
    public int M;
    public int N;
    public long S;
    public Object T;
    public final i V;
    public int W;
    public h1 r;
    public Mutex w;

    public w0(i i0, c c0) {
        this.V = i0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.T = object0;
        this.W |= 0x80000000;
        return this.V.a(null, this);
    }
}

