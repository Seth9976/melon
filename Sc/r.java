package sc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class r extends c {
    public int B;
    public int D;
    public Mutex E;
    public String G;
    public DevLog I;
    public Object M;
    public Mutex N;
    public long S;
    public Object T;
    public final P0 V;
    public int W;
    public int r;
    public int w;

    public r(P0 p00, c c0) {
        this.V = p00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.T = object0;
        this.W |= 0x80000000;
        return this.V.q(0, 0, this);
    }
}

