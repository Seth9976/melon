package androidx.compose.foundation;

import G.d0;
import androidx.compose.runtime.w;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import ne.a;
import oe.i;
import we.n;

public final class n0 extends i implements n {
    public int r;
    public final o0 w;

    public n0(o0 o00, Continuation continuation0) {
        this.w = o00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n0(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((n0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return a.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        o0 o00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                goto label_12;
            }
            case 1: {
                d5.n.D(object0);
                goto label_16;
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
            F0 f00 = o00.f;
            if(f00 != null) {
                ((H0)f00).d();
            }
            while(true) {
            label_12:
                Channel channel0 = o00.k;
                if(channel0 != null) {
                    this.r = 1;
                    if(channel0.receive(this) != a0) {
                        goto label_16;
                    }
                    break alab1;
                }
            label_16:
                if(o00.f == null) {
                    continue;
                }
                this.r = 2;
                if(w.l(this.getContext()).c(new d0(2, u.i), this) != a0) {
                    break;
                }
                break alab1;
            }
        }
        return a0;
    }
}

