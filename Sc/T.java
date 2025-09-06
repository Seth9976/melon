package sc;

import com.iloen.melon.playback.Playable;
import d8.d;
import df.v;
import e.k;
import e1.b;
import ie.H;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class t extends i implements n {
    public int B;
    public Object D;
    public final P0 E;
    public final int G;
    public final int I;
    public final ArrayList M;
    public g1 r;
    public int w;

    public t(P0 p00, int v, int v1, ArrayList arrayList0, Continuation continuation0) {
        this.E = p00;
        this.G = v;
        this.I = v1;
        this.M = arrayList0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new t(this.E, this.G, this.I, this.M, continuation0);
        continuation1.D = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((t)this.create(((g1)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        g1 g10 = (g1)this.D;
        a a0 = a.a;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                P0 p00 = this.E;
                LinkedList linkedList0 = p00.n;
                Playable playable0 = (Playable)linkedList0.get(this.G);
                Playable playable1 = b.y(g10);
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
                this.M.add(playable0);
                this.D = null;
                this.r = g10;
                this.w = v1;
                this.B = 1;
                object0 = v.k(linkedList0, p00.w, this);
                return object0 == a0 ? a0 : g1.f(g10, ((List)object0), v1, null, false, null, null, false, 0x7C);
            }
            case 1: {
                int v2 = this.w;
                g1 g11 = this.r;
                d5.n.D(object0);
                return g1.f(g11, ((List)object0), v2, null, false, null, null, false, 0x7C);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

