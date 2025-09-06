package sc;

import A3.g;
import com.iloen.melon.playback.Playable;
import d8.d;
import df.v;
import e.k;
import e1.b;
import ie.H;
import java.util.LinkedList;
import java.util.List;
import je.t;
import k9.j;
import kotlin.coroutines.Continuation;
import ne.a;
import oc.y0;
import oe.i;
import we.n;

public final class h extends i implements n {
    public y0 B;
    public int D;
    public int E;
    public int G;
    public Object I;
    public final P0 M;
    public final List N;
    public final int S;
    public g1 r;
    public g1 w;

    public h(P0 p00, List list0, int v, Continuation continuation0) {
        this.M = p00;
        this.N = list0;
        this.S = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new h(this.M, this.N, this.S, continuation0);
        continuation1.I = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(((g1)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v;
        g1 g12;
        Object object3;
        int v4;
        P0 p00 = this.M;
        sc.i i0 = p00.w;
        LinkedList linkedList0 = p00.n;
        g1 g10 = (g1)this.I;
        a a0 = a.a;
        List list0 = this.N;
        switch(this.G) {
            case 0: {
                d5.n.D(object0);
                if(((g1)p00.l.getValue()).g) {
                    j.f(list0);
                }
                this.I = g10;
                this.G = 1;
                if(p00.v.a(list0, "SmartPlaylistImpl, addInternalWithoutUpdateRepositoryAndSync", this) == a0) {
                    return a0;
                }
                goto label_22;
            }
            case 1: {
                d5.n.D(object0);
            label_22:
                Playable playable0 = b.y(g10);
                long v1 = System.currentTimeMillis();
                int v2 = 0;
                for(Object object1: list0) {
                    Playable playable1 = (Playable)object1;
                    if(playable1.getCreatedSeq() == -1) {
                        playable1.setCreatedSeq(v2);
                        ++v2;
                    }
                    if(playable1.getCreatedAt() == 0L) {
                        playable1.setCreatedAt(v1);
                    }
                }
                t.S(linkedList0, lc.a.b);
                linkedList0.addAll(this.S, list0);
                int v3 = 0;
                for(Object object2: linkedList0) {
                    if(v3 >= 0) {
                        ((Playable)object2).setOrder(v3);
                        ++v3;
                        continue;
                    }
                    k.O();
                    throw null;
                }
                v4 = d.v(linkedList0, playable0);
                if(v4 == -1 && !linkedList0.isEmpty()) {
                    v4 = 0;
                }
                p00.p = p00.p == null ? null : new g(p00.p.b + list0.size(), v4);
                this.I = g10;
                this.r = null;
                this.w = g10;
                this.D = v4;
                this.E = v4;
                this.G = 2;
                object3 = v.k(linkedList0, i0, this);
                if(object3 == a0) {
                    return a0;
                }
                g12 = g10;
                break;
            }
            case 2: {
                v4 = this.E;
                g1 g13 = this.w;
                lc.a a1 = (lc.a)this.r;
                d5.n.D(object0);
                object3 = object0;
                g12 = g13;
                break;
            }
            case 3: {
                v = this.D;
                y0 y00 = this.B;
                List list1 = (List)this.w;
                g1 g11 = this.r;
                d5.n.D(object0);
                return g1.f(g11, ((List)object0), v, null, false, y00, null, false, 108);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        g1 g14 = g1.f(g12, ((List)object3), v4, null, false, null, null, false, 0x7C);
        y0 y01 = g10.e;
        Playable playable2 = b.y(g14);
        p00.t.getClass();
        t.S(linkedList0, p00.t.a(y01));
        v = d.v(linkedList0, playable2);
        this.I = null;
        this.r = g14;
        this.w = null;
        this.B = y01;
        this.D = v;
        this.E = 0;
        this.G = 3;
        Object object4 = v.k(linkedList0, i0, this);
        return object4 == a0 ? a0 : g1.f(g14, ((List)object4), v, null, false, y01, null, false, 108);
    }
}

