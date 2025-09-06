package androidx.compose.foundation;

import K.l;
import K.m;
import K.o;
import K.p;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class g extends i implements n {
    public final o B;
    public int r;
    public final j w;

    public g(j j0, o o0, Continuation continuation0) {
        this.w = j0;
        this.B = o0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new g(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                l l0 = this.w.c;
                if(l0 != null) {
                    p p0 = new p(this.B);
                    this.r = 1;
                    if(((m)l0).a(p0, this) == a0) {
                        return a0;
                    }
                }
                return H.a;
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

