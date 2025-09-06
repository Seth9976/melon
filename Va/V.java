package va;

import A8.x;
import com.iloen.melon.custom.L0;
import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class v extends c {
    public L0 B;
    public DevLog D;
    public Object E;
    public x G;
    public int I;
    public int M;
    public int N;
    public int S;
    public long T;
    public Object V;
    public final e0 W;
    public int X;
    public Mutex r;
    public String w;

    public v(e0 e00, c c0) {
        this.W = e00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.V = object0;
        this.X |= 0x80000000;
        return this.W.q(null, null, this);
    }
}

