package I;

import kotlin.jvm.internal.G;
import oe.c;

public final class a1 extends c {
    public Object B;
    public final g1 D;
    public int E;
    public g1 r;
    public G w;

    public a1(g1 g10, c c0) {
        this.D = g10;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.b(0L, this);
    }
}

