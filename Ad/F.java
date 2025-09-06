package ad;

import O.F;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class f extends i implements n {
    public final F B;
    public int r;
    public boolean w;

    public f(F f0, Continuation continuation0) {
        this.B = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new f(this.B, continuation0);
        continuation1.w = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        return ((f)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                F f0 = this.B;
                if(z) {
                    this.w = true;
                    this.r = 1;
                    if(f0.f(0, 0, this) == a0) {
                        return a0;
                    }
                }
                else {
                    this.w = false;
                    this.r = 2;
                    if(f0.j(0, 0, this) == a0) {
                        return a0;
                    }
                }
                return H.a;
            }
            case 1: 
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

