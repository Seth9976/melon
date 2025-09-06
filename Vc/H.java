package Vc;

import Tf.o;
import ie.H;
import java.util.ArrayList;
import je.q;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import oe.i;
import p0.p;
import we.a;
import we.n;

public final class h extends i implements n {
    public p B;
    public int D;
    public final p E;
    public final p G;
    public final boolean I;
    public final String M;
    public final String N;
    public final a S;
    public int r;
    public int w;

    public h(p p0, p p1, boolean z, String s, String s1, a a0, Continuation continuation0) {
        this.E = p0;
        this.G = p1;
        this.I = z;
        this.M = s;
        this.N = s1;
        this.S = a0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h(this.E, this.G, this.I, this.M, this.N, this.S, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v2;
        p p3;
        int v4;
        int v3;
        ne.a a0 = ne.a.a;
        int v = 0;
        p p0 = this.G;
        p p1 = this.E;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                p1.clear();
                p0.clear();
                if(!this.I) {
                    this.D = 1;
                    if(DelayKt.delay(1200L, this) == a0) {
                        return a0;
                    }
                label_30:
                    Iterable iterable0 = o.R0(this.M, new String[]{"\n"}, 0, 6);
                    ArrayList arrayList0 = new ArrayList(q.Q(10, iterable0));
                    for(Object object1: iterable0) {
                        arrayList0.add(o.e1(((String)object1)).toString());
                    }
                    ArrayList arrayList1 = new ArrayList();
                    for(Object object2: arrayList0) {
                        if(((String)object2).length() > 0) {
                            arrayList1.add(object2);
                        }
                    }
                    p1.addAll(arrayList1);
                    v4 = p1.size();
                    v3 = 0;
                    p3 = p0;
                    while(v3 < v4) {
                        this.B = p3;
                        this.r = v4;
                        this.w = v3;
                        this.D = 2;
                        if(DelayKt.delay(200L, this) == a0) {
                            return a0;
                        }
                    label_54:
                        p3.add(Boolean.TRUE);
                        ++v3;
                    }
                    this.B = null;
                    this.D = 3;
                    if(DelayKt.delay(1500L, this) == a0) {
                        return a0;
                    }
                label_60:
                    p0.clear();
                    p1.clear();
                    this.D = 4;
                    if(DelayKt.delay(100L, this) != a0) {
                        break;
                    }
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                goto label_30;
            }
            case 2: {
                v3 = this.w;
                v4 = this.r;
                p3 = this.B;
                d5.n.D(object0);
                goto label_54;
            }
            case 3: {
                d5.n.D(object0);
                goto label_60;
            }
            case 4: {
                d5.n.D(object0);
                break;
            }
            case 5: {
                int v1 = this.w;
                v2 = this.r;
                p p2 = this.B;
                d5.n.D(object0);
                v = v1;
                p0 = p2;
                goto label_87;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Iterable iterable1 = o.R0(this.N, new String[]{"\n"}, 0, 6);
        ArrayList arrayList2 = new ArrayList(q.Q(10, iterable1));
        for(Object object3: iterable1) {
            arrayList2.add(o.e1(((String)object3)).toString());
        }
        ArrayList arrayList3 = new ArrayList();
        for(Object object4: arrayList2) {
            if(((String)object4).length() > 0) {
                arrayList3.add(object4);
            }
        }
        p1.addAll(arrayList3);
        v2 = p1.size();
        while(v < v2) {
            this.B = p0;
            this.r = v2;
            this.w = v;
            this.D = 5;
            if(DelayKt.delay(200L, this) == a0) {
                return a0;
            }
        label_87:
            p0.add(Boolean.TRUE);
            ++v;
        }
        a a1 = this.S;
        if(a1 != null) {
            a1.invoke();
        }
        return H.a;
    }
}

