package z4;

import F.w;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import oe.c;

public final class i extends c {
    public FlowCollector B;
    public final w D;
    public Object r;
    public int w;

    public i(w w0, Continuation continuation0) {
        this.D = w0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.r = object0;
        this.w |= 0x80000000;
        return this.D.emit(null, this);
    }
}

