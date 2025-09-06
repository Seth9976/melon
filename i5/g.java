package i5;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import t5.f;
import t5.j;
import t5.k;
import we.n;

public final class g extends i implements n {
    public final j B;
    public int r;
    public final i5.n w;

    public g(i5.n n0, Continuation continuation0, j j0) {
        this.w = n0;
        this.B = j0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new g(this.w, continuation0, this.B);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        i5.n n0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = i5.n.a(n0, this.B, 0, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((k)object0) instanceof f && n0.g != null) {
            x5.k.a("RealImageLoader", 6, null, ((f)(((k)object0))).c);
        }
        return object0;
    }
}

