package sc;

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

public final class u0 extends i implements n {
    public int B;
    public Object D;
    public final P0 E;
    public final y0 G;
    public y0 r;
    public int w;

    public u0(P0 p00, y0 y00, Continuation continuation0) {
        this.E = p00;
        this.G = y00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new u0(this.E, this.G, continuation0);
        continuation1.D = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((u0)this.create(((g1)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        g1 g10 = (g1)this.D;
        a a0 = a.a;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                Playable playable0 = b.y(g10);
                this.E.t.getClass();
                y0 y00 = this.G;
                Comparator comparator0 = this.E.t.a(y00);
                t.S(this.E.n, comparator0);
                int v = d.v(this.E.n, playable0);
                this.D = g10;
                this.r = y00;
                this.w = v;
                this.B = 1;
                object0 = v.k(this.E.n, this.E.w, this);
                return object0 == a0 ? a0 : g1.f(g10, ((List)object0), v, null, false, y00, null, false, 108);
            }
            case 1: {
                int v1 = this.w;
                y0 y01 = this.r;
                d5.n.D(object0);
                return g1.f(g10, ((List)object0), v1, null, false, y01, null, false, 108);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

