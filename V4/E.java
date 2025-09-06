package v4;

import kotlin.coroutines.Continuation;
import oe.c;

public final class e extends c {
    public int B;
    public Object r;
    public final f w;

    public e(f f0, Continuation continuation0) {
        this.w = f0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return f.d(this.w, null, this);
    }
}

