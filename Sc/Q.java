package sc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class q extends c {
    public DevLog B;
    public String D;
    public Mutex E;
    public Object G;
    public final P0 I;
    public int M;
    public Mutex r;
    public String w;

    public q(P0 p00, c c0) {
        this.I = p00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.G = object0;
        this.M |= 0x80000000;
        return this.I.b(this);
    }
}

