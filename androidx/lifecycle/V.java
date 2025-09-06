package androidx.lifecycle;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;
import we.n;

public final class v extends i implements n {
    public final i B;
    public int r;
    public final y w;

    public v(y y0, n n0, Continuation continuation0) {
        this.w = y0;
        this.B = (i)n0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new v(this.w, ((n)this.B), continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((v)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new P(this.w.a, s.c, ((n)this.B), null), this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

