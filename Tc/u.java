package tc;

import com.iloen.melon.utils.log.DevLog;
import java.util.ArrayList;
import kotlinx.coroutines.sync.Mutex;
import oe.c;
import we.n;

public final class u extends c {
    public Mutex B;
    public String D;
    public DevLog E;
    public Object G;
    public Mutex I;
    public ArrayList M;
    public boolean N;
    public int S;
    public int T;
    public int V;
    public int W;
    public long X;
    public Object Y;
    public final x Z;
    public int b0;
    public n r;
    public String w;

    public u(x x0, c c0) {
        this.Z = x0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.Y = object0;
        this.b0 |= 0x80000000;
        return this.Z.h(null, false, null, this);
    }
}

