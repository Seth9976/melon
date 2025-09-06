package androidx.compose.foundation.lazy.layout;

import kotlinx.coroutines.CancellableContinuationImpl;

public final class c extends oe.c {
    public final d B;
    public int D;
    public CancellableContinuationImpl r;
    public Object w;

    public c(d d0, oe.c c0) {
        this.B = d0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return this.B.c(this);
    }
}

