package m8;

import com.iloen.melon.utils.Navigator;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import mb.k;
import ne.a;
import oe.i;
import va.e0;
import va.o;
import we.n;

public final class f extends i implements n {
    public int r;

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new f(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                k k0 = o.a();
                this.r = 1;
                if(((e0)k0).z("mismatch memberKey from external", true, this) == a0) {
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
        Navigator.openLoginView(r8.f.i);
        return H.a;
    }
}

