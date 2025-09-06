package i5;

import android.graphics.Bitmap;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import t5.j;
import u5.g;
import we.n;

public final class l extends i implements n {
    public final i5.n B;
    public final g D;
    public final c E;
    public final Bitmap G;
    public int r;
    public final j w;

    public l(j j0, i5.n n0, g g0, c c0, Bitmap bitmap0, Continuation continuation0) {
        this.w = j0;
        this.B = n0;
        this.D = g0;
        this.E = c0;
        this.G = bitmap0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l(this.w, this.B, this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                o5.l l0 = new o5.l(this.w, this.B.k, 0, this.w, this.D, this.E, this.G != null);
                this.r = 1;
                Object object1 = l0.b(this.w, this);
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

