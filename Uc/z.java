package uc;

import kotlinx.coroutines.flow.MutableStateFlow;
import oe.c;

public final class z extends c {
    public Object B;
    public final A D;
    public int E;
    public String r;
    public MutableStateFlow w;

    public z(A a0, c c0) {
        this.D = a0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.j(null, null, this);
    }
}

