package I;

import J0.y;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.k;
import we.n;
import we.o;

public final class p1 extends i implements n {
    public final y B;
    public final i D;
    public final r E;
    public final z0 G;
    public int r;
    public Object w;

    public p1(y y0, o o0, k k0, z0 z00, Continuation continuation0) {
        this.B = y0;
        this.D = (i)o0;
        this.E = (r)k0;
        this.G = z00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new p1(this.B, ((o)this.D), ((k)this.E), this.G, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                o1 o10 = new o1(((CoroutineScope)this.w), ((o)this.D), ((k)this.E), this.G, null);
                this.r = 1;
                return Z0.c(this.B, o10, this) == a0 ? a0 : H.a;
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

