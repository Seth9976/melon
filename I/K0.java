package I;

import kotlin.jvm.internal.E;
import oe.c;

public final class k0 extends c {
    public E B;
    public float D;
    public Object E;
    public final t0 G;
    public int I;
    public t0 r;
    public g1 w;

    public k0(t0 t00, c c0) {
        this.G = t00;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return t0.b(this.G, null, null, 0.0f, 0.0f, this);
    }
}

