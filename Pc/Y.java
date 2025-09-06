package pc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class y extends c {
    public DevLog B;
    public String D;
    public Mutex E;
    public Object G;
    public final Z I;
    public int M;
    public Mutex r;
    public String w;

    public y(Z z0, c c0) {
        this.I = z0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.G = object0;
        this.M |= 0x80000000;
        return this.I.b(this);
    }
}

