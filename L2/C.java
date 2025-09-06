package l2;

import java.io.Serializable;
import kotlin.jvm.internal.H;
import oe.c;

public final class C extends c {
    public Serializable B;
    public H D;
    public boolean E;
    public int G;
    public Object I;
    public final M M;
    public int N;
    public Object r;
    public Object w;

    public C(M m0, c c0) {
        this.M = m0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.I = object0;
        this.N |= 0x80000000;
        return M.f(this.M, false, this);
    }
}

