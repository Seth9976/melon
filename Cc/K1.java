package Cc;

import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import we.n;

public final class k1 extends i implements n {
    public final int B;
    public final b0 D;
    public int r;
    public final boolean w;

    public k1(boolean z, int v, b0 b00, Continuation continuation0) {
        this.w = z;
        this.B = v;
        this.D = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k1(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        b0 b00 = this.D;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                if(!this.w) {
                    b00.setValue(Boolean.FALSE);
                    return H.a;
                }
                b00.setValue(Boolean.FALSE);
                this.r = 1;
                if(DelayKt.delay(this.B, this) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        b00.setValue(Boolean.TRUE);
        return H.a;
    }
}

