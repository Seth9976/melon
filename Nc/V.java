package nc;

import com.iloen.melon.playback.Playable;
import d8.d;
import e.k;
import e1.b;
import ie.H;
import java.util.LinkedList;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import oc.Q;
import oe.i;
import we.n;

public final class v extends i implements n {
    public int B;
    public Object D;
    public final u0 E;
    public final int G;
    public final int I;
    public C0 r;
    public int w;

    public v(u0 u00, int v, int v1, Continuation continuation0) {
        this.E = u00;
        this.G = v;
        this.I = v1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new v(this.E, this.G, this.I, continuation0);
        continuation1.D = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((v)this.create(((C0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        C0 c00 = (C0)this.D;
        a a0 = a.a;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                u0 u00 = this.E;
                Q q0 = (Q)u00.h.getValue();
                LinkedList linkedList0 = u00.j;
                Playable playable0 = (Playable)linkedList0.get(this.G);
                Playable playable1 = b.y(q0);
                linkedList0.remove(this.G);
                linkedList0.add(this.I, playable0);
                int v = 0;
                for(Object object1: linkedList0) {
                    if(v >= 0) {
                        ((Playable)object1).setOrder(v);
                        ++v;
                        continue;
                    }
                    k.O();
                    throw null;
                }
                int v1 = d.v(linkedList0, playable1);
                this.D = null;
                this.r = c00;
                this.w = v1;
                this.B = 1;
                object0 = df.v.k(linkedList0, u00.q, this);
                return object0 == a0 ? a0 : C0.f(c00, ((List)object0), v1, null, null, false, false, null, false, null, 508);
            }
            case 1: {
                int v2 = this.w;
                C0 c01 = this.r;
                d5.n.D(object0);
                return C0.f(c01, ((List)object0), v2, null, null, false, false, null, false, null, 508);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

