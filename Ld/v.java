package ld;

import com.iloen.melon.custom.L0;
import com.melon.ui.g1;
import oe.c;

public final class v extends c {
    public g1 B;
    public x D;
    public Object E;
    public final x G;
    public int I;
    public L0 r;
    public String w;

    public v(x x0, c c0) {
        this.G = x0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return this.G.onFetchStart(null, this);
    }
}

