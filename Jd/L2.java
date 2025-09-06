package jd;

import O.F;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class l2 extends i implements n {
    public final F B;
    public final float D;
    public final b0 E;
    public int r;
    public final int w;

    public l2(int v, F f0, float f1, b0 b00, Continuation continuation0) {
        this.w = v;
        this.B = f0;
        this.D = f1;
        this.E = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l2(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        b0 b00 = this.E;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                int v = this.w;
                if(v >= 0) {
                    boolean z = ((Boolean)b00.getValue()).booleanValue();
                    float f = this.D;
                    F f1 = this.B;
                    if(!z) {
                        goto label_16;
                    }
                    this.r = 1;
                    if(f1.f(v, -((int)f), this) == a0) {
                        return a0;
                    label_16:
                        this.r = 2;
                        if(f1.j(v, -((int)f), this) == a0) {
                            return a0;
                        }
                        b00.setValue(Boolean.TRUE);
                        return H.a;
                    }
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            case 2: {
                d5.n.D(object0);
                b00.setValue(Boolean.TRUE);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

