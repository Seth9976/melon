package I;

import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import r1.q;
import we.n;

public final class e1 extends i implements n {
    public long B;
    public final g1 D;
    public long r;
    public int w;

    public e1(g1 g10, Continuation continuation0) {
        this.D = g10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new e1(this.D, continuation0);
        continuation1.B = ((q)object0).a;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        e1 e10 = new e1(this.D, ((Continuation)object1));
        e10.B = ((q)object0).a;
        return e10.invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        long v4;
        long v2;
        a a0 = a.a;
        g1 g10 = this.D;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                v2 = this.B;
                this.B = v2;
                this.w = 1;
                object0 = g10.f.b(v2, this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_17;
            }
            case 1: {
                v2 = this.B;
                d5.n.D(object0);
            label_17:
                long v3 = q.d(v2, ((q)object0).a);
                this.B = v2;
                this.r = v3;
                this.w = 2;
                object0 = g10.b(v3, this);
                if(object0 == a0) {
                    return a0;
                }
                v4 = v3;
                break;
            }
            case 2: {
                v4 = this.r;
                v2 = this.B;
                d5.n.D(object0);
                break;
            }
            case 3: {
                long v = this.r;
                long v1 = this.B;
                d5.n.D(object0);
                return new q(q.d(v1, q.d(v, ((q)object0).a)));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        long v5 = ((q)object0).a;
        this.B = v2;
        this.r = v5;
        this.w = 3;
        object0 = g10.f.a(q.d(v4, v5), v5, this);
        return object0 == a0 ? a0 : new q(q.d(v2, q.d(v5, ((q)object0).a)));
    }
}

