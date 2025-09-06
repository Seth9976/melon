package kc;

import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class l2 extends i implements n {
    public final List B;
    public final boolean D;
    public int r;
    public final r2 w;

    public l2(List list0, r2 r20, Continuation continuation0, boolean z) {
        this.w = r20;
        this.B = list0;
        this.D = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l2(this.B, this.w, continuation0, this.D);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                k2 k20 = new k2(this.B, this.w, null, this.D);
                this.r = 1;
                return BuildersKt.withContext(this.w.b, k20, this) == a0 ? a0 : H.a;
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

