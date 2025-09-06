package V4;

import U4.w;
import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.i;
import we.p;

public final class m extends i implements p {
    public long B;
    public int r;
    public Throwable w;

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        FlowCollector flowCollector0 = (FlowCollector)object0;
        m m0 = new m(4, ((Continuation)object3));  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        m0.w = (Throwable)object1;
        m0.B = ((Number)object2).longValue();
        return m0.invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                Throwable throwable0 = this.w;
                long v = this.B;
                w.e().d("WM-UnfinishedWorkListen", "Cannot check for unfinished work", throwable0);
                this.r = 1;
                return DelayKt.delay(Math.min(v * 30000L, o.b), this) == a0 ? a0 : true;
            }
            case 1: {
                n.D(object0);
                return true;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

