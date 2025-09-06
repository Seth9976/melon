package Y;

import B7.b;
import H0.e;
import J0.L;
import J0.v;
import U.t0;
import ie.H;
import java.util.Collection;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.h;
import we.n;

public final class r extends h implements n {
    public final Ua.h B;
    public final b D;
    public final t0 E;
    public int r;
    public Object w;

    public r(Ua.h h0, b b0, t0 t00, Continuation continuation0) {
        this.B = h0;
        this.D = b0;
        this.E = t00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new r(this.B, this.D, this.E, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r)this.create(((L)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        L l0;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                l0 = (L)this.w;
                this.w = l0;
                this.r = 1;
                object0 = e.q(l0, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                l0 = (L)this.w;
                d5.n.D(object0);
                break;
            }
            case 2: 
            case 3: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!e.M(((J0.n)object0)) || (((J0.n)object0).c & 33) == 0) {
        label_26:
            if(!e.M(((J0.n)object0))) {
                this.w = null;
                this.r = 3;
                if(e.u(l0, this.E, ((J0.n)object0), this) == a0) {
                    return a0;
                }
            }
        }
        else {
            Object object1 = ((J0.n)object0).a;
            int v = ((Collection)object1).size();
            int v1 = 0;
            while(v1 < v) {
                if(((v)((List)object1).get(v1)).b()) {
                    goto label_26;
                }
                ++v1;
            }
            this.w = null;
            this.r = 2;
            if(e.s(l0, this.B, this.D, ((J0.n)object0), this) == a0) {
                return a0;
            }
        }
        return H.a;
    }
}

