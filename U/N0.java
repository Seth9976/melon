package U;

import I.G1;
import J0.L;
import J0.o;
import J0.u;
import J0.v;
import ie.H;
import java.util.Collection;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.h;
import we.n;

public final class n0 extends h implements n {
    public Object B;
    public final t0 D;
    public v r;
    public int w;

    public n0(t0 t00, Continuation continuation0) {
        this.D = t00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new n0(this.D, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n0)this.create(((L)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        v v0;
        L l1;
        L l0;
        a a0 = a.a;
        t0 t00 = this.D;
    alab1:
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                l0 = (L)this.B;
                this.B = l0;
                this.w = 1;
                object0 = G1.c(l0, this, 2);
                if(object0 != a0) {
                    t00.a();
                    l1 = l0;
                    v0 = (v)object0;
                    goto label_28;
                }
                break;
            }
            case 1: {
                l0 = (L)this.B;
                d5.n.D(object0);
                t00.a();
                l1 = l0;
                v0 = (v)object0;
                goto label_28;
            }
            case 2: {
                v0 = this.r;
                l1 = (L)this.B;
                d5.n.D(object0);
                while(true) {
                    Object object1 = ((J0.n)object0).a;
                    int v1 = ((Collection)object1).size();
                    int v2 = 0;
                    while(true) {
                        if(v2 >= v1) {
                            t00.c();
                            return H.a;
                        }
                        v v3 = (v)((List)object1).get(v2);
                        if(!u.d(v3.a, v0.a) || !v3.d) {
                            ++v2;
                            continue;
                        }
                    label_28:
                        this.B = l1;
                        this.r = v0;
                        this.w = 2;
                        object0 = l1.a(o.b, this);
                        if(object0 != a0) {
                            break;
                        }
                        break alab1;
                    }
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

