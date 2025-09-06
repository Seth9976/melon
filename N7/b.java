package N7;

import java.util.Iterator;
import java.util.Map;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class b extends c {
    public d B;
    public Mutex D;
    public Map E;
    public Object G;
    public Object I;
    public final N7.c M;
    public int N;
    public Map r;
    public Iterator w;

    public b(N7.c c0, c c1) {
        this.M = c0;
        super(c1);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.I = object0;
        this.N |= 0x80000000;
        return this.M.b(this);
    }
}

