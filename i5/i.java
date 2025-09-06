package i5;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import t5.j;
import we.n;
import x5.g;

public final class i extends oe.i implements n {
    public final j B;
    public final i5.n D;
    public int r;
    public Object w;

    public i(i5.n n0, Continuation continuation0, j j0) {
        this.B = j0;
        this.D = n0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new i(this.D, continuation0, this.B);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(((CoroutineScope)this.w), Dispatchers.getMain().getImmediate(), null, new h(this.D, null, this.B), 2, null);
                g.c(((v5.a)this.B.c).b).a();
                this.r = 1;
                Object object1 = deferred0.await(this);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

