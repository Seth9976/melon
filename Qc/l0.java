package qc;

import df.v;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class l0 extends i implements n {
    public Object B;
    public final boolean D;
    public final n0 E;
    public final List G;
    public final String I;
    public D0 r;
    public int w;

    public l0(boolean z, n0 n00, List list0, String s, Continuation continuation0) {
        this.D = z;
        this.E = n00;
        this.G = list0;
        this.I = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new l0(this.D, this.E, this.G, this.I, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l0)this.create(((D0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        D0 d00 = (D0)this.B;
        a a0 = a.a;
        n0 n00 = this.E;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                if(this.D) {
                    this.B = d00;
                    this.w = 1;
                    if(n00.q.e(this.G, this.I, this) == a0) {
                        return a0;
                    }
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            case 2: {
                d00 = this.r;
                d5.n.D(object0);
                return D0.f(d00, ((List)object0), 0, null, false, null, null, false, 0x7E);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        this.B = null;
        this.r = d00;
        this.w = 2;
        object0 = v.k(n00.i, n00.r, this);
        return object0 == a0 ? a0 : D0.f(d00, ((List)object0), 0, null, false, null, null, false, 0x7E);
    }
}

