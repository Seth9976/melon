package uc;

import com.iloen.melon.utils.log.DevLog;
import java.util.List;
import kotlinx.coroutines.sync.Mutex;
import oe.c;
import we.n;

public final class g extends c {
    public Mutex B;
    public String D;
    public DevLog E;
    public Object G;
    public Mutex I;
    public List M;
    public boolean N;
    public int S;
    public int T;
    public int V;
    public int W;
    public long X;
    public Object Y;
    public final j Z;
    public int b0;
    public n r;
    public String w;

    public g(j j0, c c0) {
        this.Z = j0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.Y = object0;
        this.b0 |= 0x80000000;
        return this.Z.h(null, false, null, this);
    }
}

