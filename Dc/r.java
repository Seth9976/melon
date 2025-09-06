package Dc;

import G.a0;
import G.e;
import G.f;
import androidx.compose.runtime.O0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class r extends i implements n {
    public final float B;
    public int r;
    public final u w;

    public r(u u0, float f, Continuation continuation0) {
        this.w = u0;
        this.B = f;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new r(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        u u0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                if(u0.p.e(new Float(this.B), this) == a0) {
                    return a0;
                }
                goto label_9;
            }
            case 1: {
                d5.n.D(object0);
            label_9:
                a0 a00 = f.q(400.0f, 1, new Float(1.0f));
                this.r = 2;
                if(e.c(u0.p, new Float(0.0f), a00, null, this, 12) == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ((O0)u0.o).setValue(null);
        return H.a;
    }
}

