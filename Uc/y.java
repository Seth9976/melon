package uc;

import com.iloen.melon.playback.Playable;
import com.melon.playlist.interfaces.PlayableData;
import df.v;
import ie.H;
import java.util.Iterator;
import java.util.List;
import je.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import oe.i;
import we.n;

public final class y extends i implements n {
    public List B;
    public Iterator D;
    public List E;
    public B G;
    public int I;
    public int M;
    public int N;
    public int S;
    public Object T;
    public final List V;
    public final List W;
    public final A X;
    public List r;
    public A w;

    public y(List list0, List list1, A a0, Continuation continuation0) {
        this.V = list0;
        this.W = list1;
        this.X = a0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new y(this.V, this.W, this.X, continuation0);
        continuation1.T = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y)this.create(((B)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        List list2;
        B b1;
        int v2;
        A a1;
        int v1;
        Iterator iterator0;
        List list1;
        List list0;
        int v;
        B b0 = (B)this.T;
        a a0 = a.a;
        switch(this.S) {
            case 0: {
                d5.n.D(object0);
                v = 0;
                list0 = p.Q0(this.V);
                list1 = list0;
                iterator0 = this.W.iterator();
                v1 = 0;
                a1 = this.X;
                goto label_26;
            }
            case 1: {
                v2 = this.N;
                v1 = this.M;
                v = this.I;
                b1 = this.G;
                list0 = this.E;
                iterator0 = this.D;
                list2 = this.B;
                a1 = this.w;
                list1 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            q.d(object0);
            list0.set(v2, object0);
            b0 = b1;
            list0 = list2;
        label_26:
            if(!iterator0.hasNext()) {
                break;
            }
            Object object1 = iterator0.next();
            Playable playable0 = (Playable)object1;
            for(Object object2: list0) {
                if(!q.b(((PlayableData)object2).b, playable0.getTrackId())) {
                    continue;
                }
                goto label_35;
            }
            object2 = null;
        label_35:
            if(((PlayableData)object2) == null) {
                if(false) {
                    break;
                }
                goto label_26;
            }
            int v3 = list0.indexOf(((PlayableData)object2));
            this.T = null;
            this.r = list1;
            this.w = a1;
            this.B = list0;
            this.D = iterator0;
            this.E = list0;
            this.G = b0;
            this.I = v;
            this.M = v1;
            this.N = v3;
            this.S = 1;
            object0 = v.j(playable0, a1.f, this);
            if(object0 == a0) {
                return a0;
            }
            b1 = b0;
            v2 = v3;
            list2 = list0;
        }
        q.g(list1, "playableDataList");
        return new B(list1, b0.b);
    }
}

