package androidx.lifecycle;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt__JobKt;
import oe.i;
import we.n;

public final class x extends i implements n {
    public Object r;
    public final y w;

    public x(y y0, Continuation continuation0) {
        this.w = y0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new x(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((x)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
        y y0 = this.w;
        if(y0.a.b().compareTo(s.b) >= 0) {
            y0.a.a(y0);
            return H.a;
        }
        JobKt__JobKt.cancel$default(coroutineScope0.getCoroutineContext(), null, 1, null);
        return H.a;
    }
}

