package Q7;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import q2.h;
import we.n;

public final class j extends i implements n {
    public final m B;
    public m r;
    public int w;

    public j(m m0, Continuation continuation0) {
        this.B = m0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j(this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        m m1;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                m m0 = this.B;
                Flow flow0 = m0.a.getData();
                this.r = m0;
                this.w = 1;
                Object object1 = FlowKt.first(flow0, this);
                if(object1 == a0) {
                    return a0;
                }
                m1 = m0;
                object0 = object1;
                break;
            }
            case 1: {
                m1 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        m.a(m1, ((h)object0).d());
        return H.a;
    }
}

