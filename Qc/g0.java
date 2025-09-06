package qc;

import com.iloen.melon.playback.Playable;
import d8.d;
import df.v;
import e1.b;
import ie.H;
import java.util.Comparator;
import java.util.List;
import je.t;
import kotlin.coroutines.Continuation;
import ne.a;
import oc.y0;
import oe.i;
import we.n;

public final class g0 extends i implements n {
    public int B;
    public Object D;
    public final n0 E;
    public final y0 G;
    public y0 r;
    public int w;

    public g0(n0 n00, y0 y00, Continuation continuation0) {
        this.E = n00;
        this.G = y00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new g0(this.E, this.G, continuation0);
        continuation1.D = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g0)this.create(((D0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        D0 d00 = (D0)this.D;
        a a0 = a.a;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                Playable playable0 = b.y(d00);
                this.E.o.getClass();
                y0 y00 = this.G;
                Comparator comparator0 = this.E.o.a(y00);
                t.S(this.E.i, comparator0);
                int v = d.v(this.E.i, playable0);
                this.D = d00;
                this.r = y00;
                this.w = v;
                this.B = 1;
                object0 = v.k(this.E.i, this.E.r, this);
                return object0 == a0 ? a0 : D0.f(d00, ((List)object0), v, null, false, y00, null, false, 108);
            }
            case 1: {
                int v1 = this.w;
                y0 y01 = this.r;
                d5.n.D(object0);
                return D0.f(d00, ((List)object0), v1, null, false, y01, null, false, 108);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

