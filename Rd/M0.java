package rd;

import G.e;
import G.x0;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class m0 extends i implements n {
    public final x0 B;
    public final b0 D;
    public int r;
    public final e w;

    public m0(e e0, x0 x00, b0 b00, Continuation continuation0) {
        this.w = e0;
        this.B = x00;
        this.D = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m0(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                if(this.w.e(new Float(1.0f), this) == a0) {
                    return a0;
                }
                goto label_8;
            }
            case 1: {
                d5.n.D(object0);
            label_8:
                this.r = 2;
                if(e.c(this.w, new Float(0.0f), this.B, null, this, 12) == a0) {
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
        this.D.setValue(null);
        return H.a;
    }
}

