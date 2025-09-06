package Q0;

import android.view.View;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.u0;
import androidx.lifecycle.D;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import oe.i;
import we.n;

public final class m1 extends i implements n {
    public final H B;
    public final u0 D;
    public final D E;
    public final n1 G;
    public final View I;
    public int r;
    public Object w;

    public m1(H h0, u0 u00, D d0, n1 n10, View view0, Continuation continuation0) {
        this.B = h0;
        this.D = u00;
        this.E = d0;
        this.G = n10;
        this.I = view0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new m1(this.B, this.D, this.E, this.G, this.I, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Throwable throwable1;
        Job job0;
        a a0 = a.a;
        n1 n10 = this.G;
        D d0 = this.E;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
                try {
                    A0 a00 = (A0)this.B.a;
                    if(a00 == null) {
                        job0 = null;
                    }
                    else {
                        StateFlow stateFlow0 = q1.a(this.I.getContext().getApplicationContext());
                        float f = ((Number)stateFlow0.getValue()).floatValue();
                        ((I0)a00.a).n(f);
                        job0 = BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new l1(stateFlow0, a00, null), 3, null);
                    }
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    job0 = null;
                    goto label_29;
                }
                try {
                    this.w = job0;
                    this.r = 1;
                    if(this.D.C(this) == a0) {
                        return a0;
                    }
                    break;
                }
                catch(Throwable throwable2) {
                    goto label_28;
                }
                return a0;
            }
            case 1: {
                job0 = (Job)this.w;
                try {
                    d5.n.D(object0);
                    break;
                }
                catch(Throwable throwable2) {
                label_28:
                    throwable1 = throwable2;
                }
            label_29:
                if(job0 != null) {
                    DefaultImpls.cancel$default(job0, null, 1, null);
                }
                d0.getLifecycle().c(n10);
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        d0.getLifecycle().c(n10);
        return ie.H.a;
    }
}

