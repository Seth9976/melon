package H;

import I.G1;
import J0.L;
import J0.o;
import J0.v;
import U4.F;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.h;
import we.k;
import we.n;
import x0.b;

public final class f extends h implements n {
    public final k B;
    public int r;
    public Object w;

    public f(k k0, Continuation continuation0) {
        this.B = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new f(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f)this.create(((L)object0), ((Continuation)object1))).invokeSuspend(H.a);
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
                object0 = F.h(l0, this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_12;
            }
            case 1: {
                l0 = (L)this.w;
                d5.n.D(object0);
            label_12:
                ((v)object0).a();
                b b0 = new b(((v)object0).c);
                this.B.invoke(b0);
                this.w = null;
                this.r = 2;
                object0 = G1.g(l0, o.b, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((v)object0) != null) {
            ((v)object0).a();
        }
        return H.a;
    }
}

