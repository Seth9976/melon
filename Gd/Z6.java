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

public final class z6 extends i implements n {
    public final e B;
    public int r;
    public final C6 w;

    public z6(C6 c60, e e0, Continuation continuation0) {
        this.w = c60;
        this.B = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new z6(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((z6)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                q.f("N10030", "code(...)");
                String s = this.w.g;
                String s1 = this.w.getMenuId();
                Flow flow0 = H8.q.s(this.w.c, !((F6)this.B).a, s, s1, "N10030", null, null, 0x30);
                this.r = 1;
                return C6.c(this.w, flow0, this) == a0 ? a0 : H.a;
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

