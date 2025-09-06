package vb;

import Cb.f;
import kotlin.coroutines.Continuation;
import oe.c;

public final class k extends c {
    public final f B;
    public Object r;
    public int w;

    public k(f f0, Continuation continuation0) {
        this.B = f0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.w |= 0x80000000;
        return this.B.emit(null, this);
    }
}

