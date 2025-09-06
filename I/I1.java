package I;

import J0.L;
import J0.v;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.h;
import we.n;

public final class i1 extends h implements n {
    public Object B;
    public final v D;
    public long r;
    public int w;

    public i1(v v0, Continuation continuation0) {
        this.D = v0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new i1(this.D, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i1)this.create(((L)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        long v;
        L l1;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                L l0 = (L)this.B;
                l0.f().getClass();
                l1 = l0;
                v = this.D.b + 40L;
                goto label_14;
            }
            case 1: {
                v = this.r;
                l1 = (L)this.B;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        do {
            if(((v)object0).b >= v) {
                return (v)object0;
            }
        label_14:
            this.B = l1;
            this.r = v;
            this.w = 1;
            object0 = G1.c(l1, this, 3);
        }
        while(object0 != a0);
        return a0;
    }
}

