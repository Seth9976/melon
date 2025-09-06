package a0;

import Cb.f;
import K.l;
import K.m;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class e extends i implements n {
    public final l B;
    public final a D;
    public int r;
    public Object w;

    public e(l l0, a a0, Continuation continuation0) {
        this.B = l0;
        this.D = a0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new e(this.B, this.D, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ne.a a0 = ne.a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                f f0 = new f(7, this.D, ((CoroutineScope)this.w));
                this.r = 1;
                return ((m)this.B).a.collect(f0, this) == a0 ? a0 : H.a;
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

