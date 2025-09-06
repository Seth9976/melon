package uc;

import kotlinx.coroutines.flow.MutableStateFlow;
import oe.c;

public final class i extends c {
    public Object B;
    public final j D;
    public int E;
    public String r;
    public MutableStateFlow w;

    public i(j j0, c c0) {
        this.D = j0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.e(null, null, this);
    }
}

