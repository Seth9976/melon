package androidx.compose.foundation;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import ne.a;
import oe.i;
import we.n;

public final class s0 extends i implements n {
    public final v0 B;
    public int r;
    public final Job w;

    public s0(Job job0, v0 v00, Continuation continuation0) {
        this.w = job0;
        this.B = v00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new s0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        H h1;
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Job job0 = this.w;
                if(job0 != null) {
                    this.r = 1;
                    if(job0.join(this) == a0) {
                        return a0;
                    }
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        this.r = 2;
        v0 v00 = this.B;
        if(v00.a > 0) {
            u0 u00 = new u0(v00, null);
            h1 = BuildersKt.withContext(O.a, u00, this);
            if(h1 != a0) {
                h1 = h0;
            }
        }
        else {
            h1 = h0;
        }
        return h1 == a0 ? a0 : h0;
    }
}

