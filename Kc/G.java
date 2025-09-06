package kc;

import java.util.List;
import oe.c;

public final class g extends c {
    public Object B;
    public final h D;
    public int E;
    public List r;
    public i w;

    public g(h h0, c c0) {
        this.D = h0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.b(null, this);
    }
}

