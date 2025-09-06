package ed;

import Na.f;
import com.iloen.melon.custom.L0;
import java.util.List;
import kotlinx.coroutines.Deferred;
import oe.c;

public final class z0 extends c {
    public Deferred B;
    public Deferred D;
    public Deferred E;
    public List G;
    public Object I;
    public f M;
    public f N;
    public int S;
    public int T;
    public Object V;
    public final F0 W;
    public int X;
    public L0 r;
    public String w;

    public z0(F0 f00, c c0) {
        this.W = f00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.V = object0;
        this.X |= 0x80000000;
        return this.W.onFetchStart(null, this);
    }
}

