package I;

import F.g;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Job;
import ne.a;
import oe.i;
import we.n;

public final class j extends i implements n {
    public final K1 B;
    public final l D;
    public final d E;
    public final Job G;
    public int r;
    public Object w;

    public j(K1 k10, l l0, d d0, Job job0, Continuation continuation0) {
        this.B = k10;
        this.D = l0;
        this.E = d0;
        this.G = job0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new j(this.B, this.D, this.E, this.G, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j)this.create(((d1)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                d1 d10 = (d1)this.w;
                this.B.e = l.m0(this.D, this.E);
                g g0 = new g(this.D, this.G, d10, 3);
                I.i i0 = new I.i(this.D, this.B, this.E, 0);
                this.r = 1;
                return this.B.a(g0, i0, this) == a0 ? a0 : H.a;
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

