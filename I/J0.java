package I;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import ne.a;
import oe.i;
import we.n;

public final class j0 extends i implements n {
    public final Channel B;
    public int r;
    public Object w;

    public j0(Channel channel0, Continuation continuation0) {
        this.B = channel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new j0(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        h0 h00;
        Job job0;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                job0 = BuildersKt__Builders_commonKt.launch$default(((CoroutineScope)this.w), null, null, new i0(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                try {
                    this.w = job0;
                    this.r = 1;
                    object0 = this.B.receive(this);
                    if(object0 == a0) {
                        return a0;
                    }
                    h00 = (h0)object0;
                    goto label_17;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 1: {
                job0 = (Job)this.w;
                try {
                    d5.n.D(object0);
                    h00 = (h0)object0;
                    goto label_17;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        DefaultImpls.cancel$default(job0, null, 1, null);
        throw throwable0;
    label_17:
        DefaultImpls.cancel$default(job0, null, 1, null);
        return h00;
    }
}

