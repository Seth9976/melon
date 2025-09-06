package androidx.compose.foundation;

import oe.c;

public final class k extends c {
    public Object B;
    public final m D;
    public int E;
    public m r;
    public long w;

    public k(m m0, c c0) {
        this.D = m0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.b(0L, null, this);
    }
}

