package l2;

import kotlin.jvm.internal.H;
import oe.c;

public final class k extends c {
    public Object B;
    public H D;
    public M E;
    public Object G;
    public final l I;
    public int M;
    public Object r;
    public Object w;

    public k(l l0, c c0) {
        this.I = l0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.G = object0;
        this.M |= 0x80000000;
        return this.I.a(null, this);
    }
}

