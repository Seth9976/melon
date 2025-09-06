package Dd;

import Ac.g2;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class a1 extends i implements n {
    public int r;
    public final g1 w;

    public a1(g1 g10, Continuation continuation0) {
        this.w = g10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a1(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        g1 g10 = this.w;
        g2 g20 = g10.k;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                String s = g10.e;
                q.g(s, "contentRefValue");
                g20.getClass();
                g20.b = 11;
                g20.c = s;
                g20.e.setValue(null);
                g20.g.setValue(null);
                if(g20.f()) {
                    this.r = 1;
                    if(g10.n(true, true, this) == a0) {
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

