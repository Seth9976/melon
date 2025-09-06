package k5;

import kotlin.jvm.internal.C;
import oe.c;

public final class u extends c {
    public Object B;
    public final y D;
    public int E;
    public Object r;
    public C w;

    public u(y y0, c c0) {
        this.D = y0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.a(this);
    }
}

