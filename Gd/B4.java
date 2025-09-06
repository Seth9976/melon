package gd;

import com.iloen.melon.custom.L0;
import com.melon.ui.g1;
import oe.c;

public final class b4 extends c {
    public String B;
    public Object D;
    public final f4 E;
    public int G;
    public g1 r;
    public L0 w;

    public b4(f4 f40, c c0) {
        this.E = f40;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.onFetchStart(null, this);
    }
}

