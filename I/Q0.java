package I;

import B2.o;
import Sf.m;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.h;
import we.n;

public final class q0 extends h implements n {
    public Object B;
    public final o D;
    public Object r;
    public int w;

    public q0(o o0, Continuation continuation0) {
        this.D = o0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new q0(this.D, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q0)this.create(((m)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object1;
        m m0;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                m0 = (m)this.B;
                goto label_11;
            }
            case 1: {
                object1 = this.r;
                m0 = (m)this.B;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            if(object1 == null) {
                return H.a;
            }
        label_11:
            Object object2 = this.D.invoke();
            if(object2 != null) {
                this.B = m0;
                this.r = object2;
                this.w = 1;
                m0.a(object2, this);
                return a0;
            }
            object1 = null;
        }
    }
}

