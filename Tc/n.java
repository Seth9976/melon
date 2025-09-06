package tc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class n extends c {
    public int B;
    public long D;
    public long E;
    public boolean G;
    public String I;
    public Mutex M;
    public String N;
    public DevLog S;
    public Object T;
    public Mutex V;
    public Object W;
    public final x X;
    public int Y;
    public int r;
    public int w;

    public n(x x0, c c0) {
        this.X = x0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.W = object0;
        this.Y |= 0x80000000;
        return this.X.v(0, 0L, false, null, this);
    }
}

