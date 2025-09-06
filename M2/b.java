package M2;

import android.content.Context;
import kotlinx.coroutines.sync.Mutex;
import oe.c;

public final class b extends c {
    public String B;
    public Mutex D;
    public Object E;
    public final f G;
    public int I;
    public Context r;
    public g w;

    public b(f f0, c c0) {
        this.G = f0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return this.G.a(null, null, null, this);
    }
}

