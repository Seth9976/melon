package jc;

import hd.h0;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import ne.a;
import we.n;

public final class i extends oe.i implements n {
    public final CoroutineScope B;
    public int r;
    public Object w;

    public i(CoroutineScope coroutineScope0, Continuation continuation0) {
        this.B = coroutineScope0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new i(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        CoroutineScope coroutineScope1 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                goto label_14;
            }
            case 1: {
                d5.n.D(object0);
                goto label_25;
            }
            case 2: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    alab1:
        while(true) {
            if(!j.d.isEmpty() && j.g == null) {
                Job job0 = BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new h(coroutineScope1, null), 3, null);
                DefaultImpls.invokeOnCompletion$default(job0, true, false, new h0(11), 2, null);
                j.g = job0;
            }
            while(true) {
            label_14:
                if(!CoroutineScopeKt.isActive(coroutineScope0)) {
                    break alab1;
                }
                d d0 = (d)j.c.take();
                j j0 = j.a;
                q.d(d0);
                if(d0.toString().length() >= 2000) {
                    g g0 = new g(d0, null);
                    this.w = coroutineScope0;
                    this.r = 1;
                    if(j0.d(coroutineScope1, g0, this) == a0) {
                        return a0;
                    }
                }
                else {
                    j.d.add(d0);
                }
            label_25:
                ArrayList arrayList0 = j.d;
                if(arrayList0.isEmpty()) {
                    continue;
                }
                int v = 0;
                for(Object object1: arrayList0) {
                    v += ((d)object1).toString().length();
                }
                if(v < 2000) {
                    break;
                }
                Job job1 = j.g;
                if(job1 != null) {
                    JobKt__JobKt.cancel$default(job1, "Cancel flushPendingJob", null, 2, null);
                }
                this.w = coroutineScope0;
                this.r = 2;
                if(j.a(coroutineScope1, this) != a0) {
                    break;
                }
                return a0;
            }
        }
        return H.a;
    }
}

