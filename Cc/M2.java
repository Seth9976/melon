package Cc;

import G.e;
import G.x0;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import r1.l;
import we.n;

public final class m2 extends i implements n {
    public final b0 B;
    public final float D;
    public final float E;
    public final x0 G;
    public final boolean I;
    public int r;
    public final e w;

    public m2(e e0, b0 b00, float f, float f1, x0 x00, boolean z, Continuation continuation0) {
        this.w = e0;
        this.B = b00;
        this.D = f;
        this.E = f1;
        this.G = x00;
        this.I = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m2(this.w, this.B, this.D, this.E, this.G, this.I, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                long v = ((l)this.B.getValue()).a;
                this.r = 1;
                return u2.d(this.w, v, this.D, this.E, this.G, this.I, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

