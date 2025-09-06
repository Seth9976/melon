package androidx.compose.foundation;

import I.G1;
import J0.L;
import J0.o;
import J0.u;
import J0.v;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import je.p;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.h;
import we.n;

public final class l extends h implements n {
    public final m B;
    public int r;
    public Object w;

    public l(m m0, Continuation continuation0) {
        this.B = m0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new l(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l)this.create(((L)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object3;
        L l0;
        a a0 = a.a;
        m m0 = this.B;
    alab1:
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                l0 = (L)this.w;
                this.w = l0;
                this.r = 1;
                object0 = G1.c(l0, this, 2);
                if(object0 != a0) {
                    m0.h = ((v)object0).a;
                    m0.b = ((v)object0).c;
                    goto label_50;
                }
                break;
            }
            case 1: {
                l0 = (L)this.w;
                d5.n.D(object0);
                m0.h = ((v)object0).a;
                m0.b = ((v)object0).c;
                goto label_50;
            }
            case 2: {
                l0 = (L)this.w;
                d5.n.D(object0);
                while(true) {
                    Object object1 = ((J0.n)object0).a;
                    ArrayList arrayList0 = new ArrayList(((List)object1).size());
                    int v = ((Collection)object1).size();
                    int v1 = 0;
                    for(int v2 = 0; v2 < v; ++v2) {
                        Object object2 = ((List)object1).get(v2);
                        if(((v)object2).d) {
                            arrayList0.add(object2);
                        }
                    }
                    int v3 = arrayList0.size();
                    while(true) {
                        object3 = null;
                        if(v1 < v3) {
                            Object object4 = arrayList0.get(v1);
                            if(u.d(((v)object4).a, m0.h)) {
                                object3 = object4;
                            }
                            else {
                                ++v1;
                                continue;
                            }
                        }
                        break;
                    }
                    v v4 = (v)object3;
                    if(v4 == null) {
                        v4 = (v)p.m0(arrayList0);
                    }
                    if(v4 != null) {
                        m0.h = v4.a;
                        m0.b = v4.c;
                    }
                    if(arrayList0.isEmpty()) {
                        m0.h = -1L;
                        return H.a;
                    }
                label_50:
                    this.w = l0;
                    this.r = 2;
                    object0 = l0.a(o.b, this);
                    if(object0 != a0) {
                        continue;
                    }
                    break alab1;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

