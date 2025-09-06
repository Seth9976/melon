package ud;

import O.F;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class f extends i implements n {
    public final F B;
    public final b0 D;
    public int r;
    public final Integer w;

    public f(Integer integer0, F f0, b0 b00, Continuation continuation0) {
        this.w = integer0;
        this.B = f0;
        this.D = b00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new f(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        b0 b00 = this.D;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Integer integer0 = this.w;
                if(integer0 != null) {
                    boolean z = ((Boolean)b00.getValue()).booleanValue();
                    F f0 = this.B;
                    if(z) {
                        int v = (int)integer0;
                        if(v < 0) {
                            v = 0;
                        }
                        this.r = 1;
                        if(f0.j(v, 0, this) == a0) {
                            return a0;
                        }
                        break;
                    }
                    int v1 = (int)integer0;
                    if(v1 < 0) {
                        v1 = 0;
                    }
                    this.r = 2;
                    if(f0.f(v1, 0, this) == a0) {
                        return a0;
                    }
                }
                return H.a;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        b00.setValue(Boolean.FALSE);
        return H.a;
    }
}

