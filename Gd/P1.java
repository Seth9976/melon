package gd;

import Pc.e;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import we.n;

public final class p1 extends i implements n {
    public final r1 B;
    public int r;
    public final e w;

    public p1(e e0, r1 r10, Continuation continuation0) {
        this.w = e0;
        this.B = r10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new p1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                f1 f10 = ((j1)this.w).a;
                String s = f10.a;
                if(s != null) {
                    String s1 = this.B.getMenuId();
                    q.f("N10006", "code(...)");
                    q.f("N20004", "value");
                    Flow flow0 = H8.q.s(this.B.c, !f10.e, s, s1, "N10006", null, "N20004", 16);
                    this.r = 1;
                    if(r1.c(this.B, flow0, f10.a, this) == a0) {
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

