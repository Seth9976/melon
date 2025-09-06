package ec;

import R8.l;
import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.k;

public final class f extends i implements k {
    public int r;

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new f(1, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((f)this.create(((Continuation)object0))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                this.r = 1;
                R8.a a1 = new R8.a(1, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                H h1 = l.f.j(a1, this);
                if(h1 != a0) {
                    h1 = h0;
                }
                return h1 == a0 ? a0 : h0;
            }
            case 1: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

