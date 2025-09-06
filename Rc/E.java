package rc;

import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class e extends c {
    public DevLog B;
    public Object D;
    public Mutex E;
    public int G;
    public int I;
    public int M;
    public int N;
    public long S;
    public Object T;
    public final m V;
    public int W;
    public Mutex r;
    public String w;

    public e(m m0, c c0) {
        this.V = m0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.T = object0;
        this.W |= 0x80000000;
        return this.V.B(this);
    }
}

