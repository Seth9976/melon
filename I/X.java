package I;

import J0.L;
import kotlin.jvm.internal.G;
import oe.c;

public final class x extends c {
    public Object B;
    public int D;
    public L r;
    public G w;

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.D |= 0x80000000;
        return I.a(null, 0L, this);
    }
}

