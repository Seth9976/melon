package I;

import androidx.compose.foundation.A0;
import androidx.compose.foundation.x0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import ne.a;
import oe.i;
import we.n;

public final class p extends i implements n {
    public final x0 B;
    public final n D;
    public int r;
    public final r w;

    public p(r r0, x0 x00, n n0, Continuation continuation0) {
        this.w = r0;
        this.B = x00;
        this.D = n0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new p(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                o o0 = new o(this.w, this.D, null);
                this.r = 1;
                this.w.c.getClass();
                return CoroutineScopeKt.coroutineScope(new A0(this.B, this.w.c, o0, this.w.b, null), this) == a0 ? a0 : H.a;
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

