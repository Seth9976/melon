package qc;

import A3.g;
import com.iloen.melon.playback.Playable;
import d8.d;
import df.v;
import e.k;
import e1.b;
import ie.H;
import java.util.LinkedList;
import java.util.List;
import k9.j;
import kotlin.coroutines.Continuation;
import ne.a;
import oc.y0;
import pc.t;
import we.n;

public final class i extends oe.i implements n {
    public y0 B;
    public int D;
    public int E;
    public int G;
    public Object I;
    public final n0 M;
    public final List N;
    public final int S;
    public D0 r;
    public D0 w;

    public i(n0 n00, List list0, int v, Continuation continuation0) {
        this.M = n00;
        this.N = list0;
        this.S = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new i(this.M, this.N, this.S, continuation0);
        continuation1.I = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i)this.create(((D0)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v;
        D0 d02;
        Object object3;
        int v4;
        n0 n00 = this.M;
        t t0 = n00.r;
        LinkedList linkedList0 = n00.i;
        D0 d00 = (D0)this.I;
        a a0 = a.a;
        List list0 = this.N;
        switch(this.G) {
            case 0: {
                d5.n.D(object0);
                if(((D0)n00.g.getValue()).g) {
                    j.f(list0);
                }
                this.I = d00;
                this.G = 1;
                if(n00.q.a(list0, "MusicPlaylistImpl, addInternalWithoutUpdateRepository", this) == a0) {
                    return a0;
                }
                goto label_22;
            }
            case 1: {
                d5.n.D(object0);
            label_22:
                Playable playable0 = b.y(d00);
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
                je.t.S(linkedList0, lc.a.b);
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
                n00.k = n00.k == null ? null : new g(n00.k.b + list0.size(), v4);
                this.I = d00;
                this.r = null;
                this.w = d00;
                this.D = v4;
                this.E = v4;
                this.G = 2;
                object3 = v.k(linkedList0, t0, this);
                if(object3 == a0) {
                    return a0;
                }
                d02 = d00;
                break;
            }
            case 2: {
                v4 = this.E;
                D0 d03 = this.w;
                lc.a a1 = (lc.a)this.r;
                d5.n.D(object0);
                object3 = object0;
                d02 = d03;
                break;
            }
            case 3: {
                v = this.D;
                y0 y00 = this.B;
                List list1 = (List)this.w;
                D0 d01 = this.r;
                d5.n.D(object0);
                return D0.f(d01, ((List)object0), v, null, false, y00, null, false, 108);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        D0 d04 = D0.f(d02, ((List)object3), v4, null, false, null, null, false, 0x7C);
        y0 y01 = d00.e;
        Playable playable2 = b.y(d04);
        n00.o.getClass();
        je.t.S(linkedList0, n00.o.a(y01));
        v = d.v(linkedList0, playable2);
        this.I = null;
        this.r = d04;
        this.w = null;
        this.B = y01;
        this.D = v;
        this.E = 0;
        this.G = 3;
        Object object4 = v.k(linkedList0, t0, this);
        return object4 == a0 ? a0 : D0.f(d04, ((List)object4), v, null, false, y01, null, false, 108);
    }
}

