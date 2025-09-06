package d9;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import we.n;

public final class i extends oe.i implements n {
    public int r;

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                h h0 = j.a();
                this.r = 1;
                if(h0.g(this) == a0) {
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
        j.a().d();
        return H.a;
    }
}

