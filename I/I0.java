package I;

import androidx.compose.runtime.w;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import ne.a;
import oe.i;
import we.n;

public final class i0 extends i implements n {
    public int r;
    public Object w;

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new i0(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                coroutineScope0 = (CoroutineScope)this.w;
                break;
            }
            case 1: {
                coroutineScope0 = (CoroutineScope)this.w;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(JobKt.isActive(coroutineScope0.getCoroutineContext())) {
            this.w = coroutineScope0;
            this.r = 1;
            if(w.l(this.getContext()).c(e.i, this) == a0) {
                return a0;
            }
            if(false) {
                break;
            }
        }
        return H.a;
    }
}

