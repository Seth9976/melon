package eb;

import com.melon.ui.h0;
import oe.c;

public final class k extends c {
    public String B;
    public int D;
    public Object E;
    public final n G;
    public int I;
    public Q0.n r;
    public h0 w;

    public k(n n0, c c0) {
        this.G = n0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return this.G.d(null, null, null, null, this);
    }
}

