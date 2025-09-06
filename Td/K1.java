package td;

import Pc.e;
import ac.b;
import ac.d;
import d9.h;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import ob.z;
import oe.i;
import qd.O;
import we.n;

public final class k1 extends i implements n {
    public final e B;
    public int r;
    public final t1 w;

    public k1(t1 t10, e e0, Continuation continuation0) {
        this.w = t10;
        this.B = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k1(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        t1 t10 = this.w;
        z z0 = t10.d;
        a a0 = a.a;
        e e0 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                d d0 = z0.c.a().j;
                if(d0 instanceof b && ((O)e0).b < ((b)d0).a) {
                    this.r = 1;
                    if(z0.e.p(this) == a0) {
                        return a0;
                    }
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        z0.z(((O)e0).b);
        if(!z0.n()) {
            ((h)t10.v.getValue()).h.postValue(new Integer(((O)e0).a));
        }
        return H.a;
    }
}

