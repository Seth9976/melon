package va;

import com.iloen.melon.utils.log.DevLog;
import ie.p;
import kotlinx.coroutines.sync.Mutex;
import ne.a;
import oe.c;

public final class f extends c {
    public DevLog B;
    public String D;
    public long E;
    public Object G;
    public final n I;
    public int M;
    public Mutex r;
    public String w;

    public f(n n0, c c0) {
        this.I = n0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.G = object0;
        this.M |= 0x80000000;
        Object object1 = this.I.b(this);
        return object1 == a.a ? object1 : new p(object1);
    }
}

