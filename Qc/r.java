package qc;

import com.iloen.melon.playback.Playable;
import d8.d;
import df.v;
import e.k;
import e1.b;
import ie.H;
import java.util.LinkedList;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class r extends i implements n {
    public int B;
    public Object D;
    public final n0 E;
    public final int G;
    public final int I;
    public D0 r;
    public int w;

    public r(n0 n00, int v, int v1, Continuation continuation0) {
        this.E = n00;
        this.G = v;
        this.I = v1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new r(this.E, this.G, this.I, continuation0);
        continuation1.D = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r)this.create(((D0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        D0 d00 = (D0)this.D;
        a a0 = a.a;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                n0 n00 = this.E;
                LinkedList linkedList0 = n00.i;
                Playable playable0 = (Playable)linkedList0.get(this.G);
                Playable playable1 = b.y(d00);
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
                this.r = d00;
                this.w = v1;
                this.B = 1;
                object0 = v.k(linkedList0, n00.r, this);
                return object0 == a0 ? a0 : D0.f(d00, ((List)object0), v1, null, false, null, null, false, 0x7C);
            }
            case 1: {
                int v2 = this.w;
                D0 d01 = this.r;
                d5.n.D(object0);
                return D0.f(d01, ((List)object0), v2, null, false, null, null, false, 0x7C);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

