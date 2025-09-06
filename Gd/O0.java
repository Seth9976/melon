package gd;

import com.iloen.melon.custom.L0;
import com.melon.ui.g1;
import oe.c;

public final class o0 extends c {
    public String B;
    public Object D;
    public final u0 E;
    public int G;
    public g1 r;
    public L0 w;

    public o0(u0 u00, c c0) {
        this.E = u00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.onFetchStart(null, this);
    }
}

