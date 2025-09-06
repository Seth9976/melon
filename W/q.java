package W;

import Q0.I0;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class q extends i implements n {
    public final e B;
    public int r;
    public final r w;

    public q(r r0, e e0, Continuation continuation0) {
        this.w = r0;
        this.B = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new q(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((q)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return a.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                I0.a(this.w, this.B, this);
                return a0;
            }
            case 1: {
                d5.n.D(object0);
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

