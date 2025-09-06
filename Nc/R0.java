package nc;

import df.v;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class r0 extends i implements n {
    public Object B;
    public final boolean D;
    public final u0 E;
    public final List G;
    public final String I;
    public C0 r;
    public int w;

    public r0(boolean z, u0 u00, List list0, String s, Continuation continuation0) {
        this.D = z;
        this.E = u00;
        this.G = list0;
        this.I = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new r0(this.D, this.E, this.G, this.I, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r0)this.create(((C0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        C0 c00 = (C0)this.B;
        a a0 = a.a;
        u0 u00 = this.E;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                if(this.D) {
                    this.B = c00;
                    this.w = 1;
                    if(u00.p.e(this.G, this.I, this) == a0) {
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
                c00 = this.r;
                d5.n.D(object0);
                return C0.f(c00, ((List)object0), 0, null, null, false, false, null, false, null, 510);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        this.B = null;
        this.r = c00;
        this.w = 2;
        object0 = v.k(u00.j, u00.q, this);
        return object0 == a0 ? a0 : C0.f(c00, ((List)object0), 0, null, null, false, false, null, false, null, 510);
    }
}

