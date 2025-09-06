package androidx.room;

import U.w;
import kotlin.coroutines.Continuation;
import oe.c;

public final class W extends c {
    public Object B;
    public final w D;
    public int E;
    public w r;
    public int[] w;

    public W(w w0, Continuation continuation0) {
        this.D = w0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.a(null, this);
    }
}

