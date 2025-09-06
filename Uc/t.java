package uc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class t extends c {
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
    public final A X;
    public int Y;
    public int r;
    public int w;

    public t(A a0, c c0) {
        this.X = a0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.W = object0;
        this.Y |= 0x80000000;
        return this.X.v(0, 0L, false, null, this);
    }
}

