package androidx.compose.foundation;

import K.h;
import K.l;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import we.n;

public final class i extends oe.i implements n {
    public final j r;

    public i(j j0, Continuation continuation0) {
        this.r = j0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((i)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        j j0 = this.r;
        h h0 = j0.m;
        if(h0 != null) {
            K.i i0 = new K.i(h0);
            l l0 = j0.c;
            if(l0 != null) {
                BuildersKt__Builders_commonKt.launch$default(j0.getCoroutineScope(), null, null, new b(l0, i0, null), 3, null);
            }
            j0.m = null;
        }
        return H.a;
    }
}

