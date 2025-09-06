package sc;

import com.iloen.melon.custom.L0;
import com.iloen.melon.net.mcp.response.PlaylistsSmartEditRes;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class t2 extends c {
    public S2 B;
    public Object D;
    public Object E;
    public Object G;
    public Object I;
    public L0 M;
    public Object N;
    public Object S;
    public String T;
    public PlaylistsSmartEditRes V;
    public int W;
    public int X;
    public int Y;
    public int Z;
    public int b0;
    public int c0;
    public long d0;
    public Object e0;
    public final v2 f0;
    public int g0;
    public Mutex r;
    public String w;

    public t2(v2 v20, Continuation continuation0) {
        this.f0 = v20;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.e0 = object0;
        this.g0 |= 0x80000000;
        return this.f0.execute(this);
    }
}

