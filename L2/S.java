package l2;

import Ac.F2;
import ie.H;
import kb.r;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.n;

public final class s extends i implements n {
    public Object B;
    public final M D;
    public d r;
    public int w;

    public s(M m0, Continuation continuation0) {
        this.D = m0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new s(this.D, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        j0 j00;
        FlowCollector flowCollector1;
        a a0 = a.a;
        H h0 = H.a;
        M m0 = this.D;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                FlowCollector flowCollector0 = (FlowCollector)this.B;
                this.B = flowCollector0;
                this.w = 1;
                Object object1 = BuildersKt.withContext(m0.c.getCoroutineContext(), new F(m0, null), this);
                if(object1 == a0) {
                    return a0;
                }
                flowCollector1 = flowCollector0;
                object0 = object1;
                goto label_19;
            }
            case 1: {
                FlowCollector flowCollector2 = (FlowCollector)this.B;
                d5.n.D(object0);
                flowCollector1 = flowCollector2;
            label_19:
                j00 = (j0)object0;
                if(j00 instanceof d) {
                    this.B = flowCollector1;
                    this.r = (d)j00;
                    this.w = 2;
                    if(flowCollector1.emit(((d)j00).b, this) != a0) {
                        goto label_35;
                    }
                    return a0;
                }
                else {
                    if(j00 instanceof m0) {
                        throw new IllegalStateException("This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542");
                    }
                    if(j00 instanceof Z) {
                        throw ((Z)j00).b;
                    }
                    if(!(j00 instanceof X)) {
                        goto label_35;
                    }
                }
                break;
            }
            case 2: {
                j00 = this.r;
                flowCollector1 = (FlowCollector)this.B;
                d5.n.D(object0);
            label_35:
                o o0 = new o(m0, null);
                Flow flow0 = FlowKt.onCompletion(new F2(FlowKt.dropWhile(FlowKt.takeWhile(FlowKt.onStart(m0.h.a, o0), new p(2, null)), new q(j00, null)), 23), new r(m0, null));  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                this.B = null;
                this.r = null;
                this.w = 3;
                if(FlowKt.emitAll(flowCollector1, flow0, this) == a0) {
                    return a0;
                }
                break;
            }
            case 3: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }
}

