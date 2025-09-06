package rc;

import df.v;
import e1.b;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import oe.i;
import we.n;

public final class k extends i implements n {
    public Object B;
    public final m D;
    public rc.n r;
    public int w;

    public k(m m0, Continuation continuation0) {
        this.D = m0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new k(this.D, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k)this.create(((rc.n)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        rc.n n0 = (rc.n)this.B;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                ArrayList arrayList0 = b.B(n0);
                this.B = null;
                this.r = n0;
                this.w = 1;
                object0 = v.k(arrayList0, this.D.f, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n0 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        q.g(((List)object0), "playableDataList");
        return new rc.n(((List)object0), n0.b, n0.c, n0.d, n0.e);
    }
}

