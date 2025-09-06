package pd;

import Hc.b;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class e extends i implements n {
    public int r;
    public final f w;

    public e(f f0, Continuation continuation0) {
        this.w = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((e)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return a.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                b b0 = new b(this.w, 4);
                this.r = 1;
                if(this.w.a.d.collect(b0, this) == a0) {
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
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }
}

