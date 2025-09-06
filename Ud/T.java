package ud;

import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import we.n;

public final class t extends i implements n {
    public final boolean B;
    public final b0 D;
    public final b0 E;
    public int r;
    public final String w;

    public t(String s, boolean z, b0 b00, b0 b01, Continuation continuation0) {
        this.w = s;
        this.B = z;
        this.D = b00;
        this.E = b01;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new t(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((t)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        boolean z = this.B;
        b0 b00 = this.E;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                if(this.w.length() != 0) {
                    b0 b01 = this.D;
                    if(((Boolean)b01.getValue()).booleanValue()) {
                        u.g(b00, z);
                        b01.setValue(Boolean.FALSE);
                        return H.a;
                    }
                    u.g(b00, false);
                    this.r = 1;
                    if(DelayKt.delay(2000L, this) == a0) {
                        return a0;
                    }
                    u.g(b00, z);
                    return H.a;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                u.g(b00, z);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

