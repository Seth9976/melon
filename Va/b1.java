package va;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class b1 extends c {
    public DevLog B;
    public String D;
    public long E;
    public Object G;
    public final j1 I;
    public int M;
    public Mutex r;
    public String w;

    public b1(j1 j10, c c0) {
        this.I = j10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.G = object0;
        this.M |= 0x80000000;
        return this.I.i(null, this);
    }
}

