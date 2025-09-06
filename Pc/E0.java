package pc;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class e0 extends i implements n {
    public int r;
    public final y0 w;

    public e0(y0 y00, Continuation continuation0) {
        this.w = y00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e0(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        H h0 = H.a;
        y0 y00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                d0 d00 = new d0(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                this.r = 1;
                if(y00.e.a(d00, this) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        this.r = 2;
        H h1 = y00.c.a.clear(this);
        if(h1 != a0) {
            h1 = h0;
        }
        return h1 == a0 ? a0 : h0;
    }
}

