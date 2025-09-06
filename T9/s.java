package t9;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Deferred;
import oe.c;

public final class s extends c {
    public int B;
    public Object D;
    public final v E;
    public int G;
    public Deferred r;
    public String w;

    public s(v v0, Continuation continuation0) {
        this.E = v0;
        super(continuation0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.D = object0;
        this.G |= 0x80000000;
        return this.E.a(null, this);
    }
}

