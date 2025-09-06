package id;

import com.iloen.melon.custom.L0;
import oe.c;

public final class u extends c {
    public Object B;
    public final w D;
    public int E;
    public L0 r;
    public String w;

    public u(w w0, c c0) {
        this.D = w0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.onFetchStart(null, this);
    }
}

