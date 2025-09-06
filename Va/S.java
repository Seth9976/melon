package va;

import A8.u;
import A8.w;
import com.iloen.melon.utils.log.DevLog;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class s extends c {
    public Mutex B;
    public String D;
    public DevLog E;
    public Object G;
    public w I;
    public String M;
    public String N;
    public String S;
    public l1 T;
    public e0 V;
    public int W;
    public int X;
    public int Y;
    public int Z;
    public long b0;
    public Object c0;
    public final e0 d0;
    public int e0;
    public u r;
    public String w;

    public s(e0 e00, c c0) {
        this.d0 = e00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.c0 = object0;
        this.e0 |= 0x80000000;
        return this.d0.p(null, null, this);
    }
}

