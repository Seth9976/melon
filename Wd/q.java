package wd;

import Pc.e;
import ie.H;
import java.util.List;
import je.w;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import we.n;

public final class q extends i implements n {
    public final e B;
    public int r;
    public final t w;

    public q(e e0, Continuation continuation0, t t0) {
        this.w = t0;
        this.B = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new q(this.B, continuation0, this.w);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        t t0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                d5.i i0 = t0.a;
                String s = ((k)this.B).b;
                String s1 = t0.c == null ? "M20001" : t0.c;
                String s2 = ((k)this.B).c;
                List list0 = t0.f;
                if(list0 == null) {
                    list0 = w.a;
                }
                Flow flow0 = i0.c(s, s1, s2, t0.g, list0);
                this.r = 1;
                H h1 = flow0.collect(new s(t0), this);
                if(h1 != a0) {
                    h1 = h0;
                }
                if(h1 == a0) {
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
        t0.sendUiEvent(wd.i.a);
        return h0;
    }
}

