package androidx.compose.runtime;

import androidx.collection.G;
import androidx.collection.K;
import androidx.collection.L;
import androidx.collection.P;
import d5.n;
import e1.u;
import g0.h;
import ie.H;
import ie.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.o;

public final class t0 extends i implements o {
    public List B;
    public L D;
    public L E;
    public L G;
    public Set I;
    public L M;
    public int N;
    public W S;
    public final u0 T;
    public List r;
    public List w;

    public t0(u0 u00, Continuation continuation0) {
        this.T = u00;
        super(3, continuation0);
    }

    public static final void d(u0 u00, List list0, List list1, List list2, L l0, L l1, L l2, L l3) {
        synchronized(u00.c) {
            list0.clear();
            list1.clear();
            int v1 = list2.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                v v3 = (v)list2.get(v2);
                v3.b();
                u00.B(v3);
            }
            list2.clear();
            Object[] arr_object = l0.b;
            long[] arr_v = l0.a;
            int v4 = arr_v.length - 2;
            if(v4 >= 0) {
                int v5 = 0;
                while(true) {
                    long v6 = arr_v[v5];
                    if((~v6 << 7 & v6 & 0x8080808080808080L) == 0x8080808080808080L) {
                        goto label_32;
                    }
                    int v7 = 8 - (~(v5 - v4) >>> 0x1F);
                    for(int v8 = 0; v8 < v7; ++v8) {
                        if((v6 & 0xFFL) < 0x80L) {
                            v v9 = (v)arr_object[(v5 << 3) + v8];
                            v9.b();
                            u00.B(v9);
                        }
                        v6 >>= 8;
                    }
                    if(v7 == 8) {
                    label_32:
                        if(v5 != v4) {
                            ++v5;
                            continue;
                        }
                    }
                    goto label_35;
                }
            }
            else {
            label_35:
                l0.b();
                Object[] arr_object1 = l1.b;
                long[] arr_v1 = l1.a;
                int v10 = arr_v1.length - 2;
                if(v10 >= 0) {
                    int v11 = 0;
                    while(true) {
                        long v12 = arr_v1[v11];
                        if((~v12 << 7 & v12 & 0x8080808080808080L) == 0x8080808080808080L) {
                            goto label_52;
                        }
                        int v13 = 8 - (~(v11 - v10) >>> 0x1F);
                        for(int v14 = 0; v14 < v13; ++v14) {
                            if((v12 & 0xFFL) < 0x80L) {
                                ((v)arr_object1[(v11 << 3) + v14]).h();
                            }
                            v12 >>= 8;
                        }
                        if(v13 == 8) {
                        label_52:
                            if(v11 != v10) {
                                ++v11;
                                continue;
                            }
                        }
                        goto label_55;
                    }
                }
                else {
                label_55:
                    l1.b();
                    l2.b();
                    Object[] arr_object2 = l3.b;
                    long[] arr_v2 = l3.a;
                    int v15 = arr_v2.length - 2;
                    if(v15 >= 0) {
                        int v16 = 0;
                        while(true) {
                            long v17 = arr_v2[v16];
                            if((~v17 << 7 & v17 & 0x8080808080808080L) != 0x8080808080808080L) {
                                int v18 = 8 - (~(v16 - v15) >>> 0x1F);
                                for(int v19 = 0; v19 < v18; ++v19) {
                                    if((v17 & 0xFFL) < 0x80L) {
                                        v v20 = (v)arr_object2[(v16 << 3) + v19];
                                        v20.b();
                                        u00.B(v20);
                                    }
                                    v17 >>= 8;
                                }
                                if(v18 == 8) {
                                    goto label_75;
                                }
                                break;
                            }
                        label_75:
                            if(v16 == v15) {
                                break;
                            }
                            ++v16;
                        }
                    }
                }
            }
            l3.b();
        }
    }

    public static final void e(List list0, u0 u00) {
        list0.clear();
        synchronized(u00.c) {
            ArrayList arrayList0 = u00.k;
            int v1 = arrayList0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                list0.add(((Y)arrayList0.get(v2)));
            }
            u00.k.clear();
        }
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        CoroutineScope coroutineScope0 = (CoroutineScope)object0;
        t0 t00 = new t0(this.T, ((Continuation)object2));
        t00.S = (W)object1;
        t00.invokeSuspend(H.a);
        return a.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        H h2;
        CancellableContinuationImpl cancellableContinuationImpl1;
        W w3;
        G g1;
        L l9;
        List list6;
        List list5;
        L l8;
        L l5;
        List list2;
        L l4;
        List list1;
        Set set0;
        List list0;
        L l3;
        L l0;
        W w0;
        a a0 = a.a;
        switch(this.N) {
            case 0: {
                n.D(object0);
                w0 = this.S;
                ArrayList arrayList0 = new ArrayList();
                ArrayList arrayList1 = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                l0 = new L();
                L l1 = new L();
                L l2 = new L();
                h h0 = new h(l2);
                l3 = new L();
                list0 = arrayList0;
                set0 = h0;
                list1 = arrayList1;
                l4 = l2;
                list2 = arrayList2;
                l5 = l1;
                goto label_87;
            }
            case 1: {
                L l6 = this.M;
                set0 = this.I;
                l4 = this.G;
                l5 = this.E;
                L l7 = this.D;
                List list3 = this.B;
                list1 = this.w;
                List list4 = this.r;
                W w1 = this.S;
                n.D(object0);
                l8 = l6;
                w0 = w1;
                list5 = list3;
                list6 = list4;
                l9 = l7;
                goto label_126;
            }
            case 2: {
                L l10 = this.M;
                set0 = this.I;
                l4 = this.G;
                l5 = this.E;
                l0 = this.D;
                list2 = this.B;
                list1 = this.w;
                list0 = this.r;
                W w2 = this.S;
                n.D(object0);
                l3 = l10;
                w0 = w2;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    alab1:
        while(true) {
            u0 u00 = this.T;
            synchronized(u00.c) {
                K k0 = u00.l;
                if(k0.e == 0) {
                    w3 = w0;
                    g1 = P.b;
                    q.e(g1, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.emptyObjectList>");
                }
                else {
                    G g0 = g0.a.b(k0);
                    u00.l.a();
                    ((K)u00.m.a).a();
                    ((K)u00.m.b).a();
                    u00.o.a();
                    g1 = new G(g0.b);
                    Object[] arr_object = g0.a;
                    int v1 = g0.b;
                    for(int v2 = 0; v2 < v1; ++v2) {
                        Y y0 = (Y)arr_object[v2];
                        g1.a(new m(y0, u00.n.g(y0)));
                    }
                    w3 = w0;
                    u00.n.a();
                }
            }
            Object[] arr_object1 = g1.a;
            int v3 = g1.b;
            for(int v4 = 0; v4 < v3; ++v4) {
                m m0 = (m)arr_object1[v4];
                Y y1 = (Y)m0.a;
                X x0 = (X)m0.b;
            }
            w0 = w3;
            while(true) {
            label_87:
                u0 u01 = this.T;
                this.S = w0;
                this.r = list0;
                this.w = list1;
                this.B = list2;
                this.D = l0;
                this.E = l5;
                this.G = l4;
                this.I = set0;
                this.M = l3;
                this.N = 1;
                if(u01.w()) {
                    h2 = H.a;
                }
                else {
                    CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(this), 1);
                    cancellableContinuationImpl0.initCancellability();
                    synchronized(u01.c) {
                        if(u01.w()) {
                            cancellableContinuationImpl1 = cancellableContinuationImpl0;
                        }
                        else {
                            u01.r = cancellableContinuationImpl0;
                            cancellableContinuationImpl1 = null;
                        }
                    }
                    if(cancellableContinuationImpl1 != null) {
                        cancellableContinuationImpl1.resumeWith(H.a);
                    }
                    H h1 = cancellableContinuationImpl0.getResult();
                    h2 = h1 == a.a ? h1 : H.a;
                }
                if(h2 == a0) {
                    break alab1;
                }
                l9 = l0;
                l8 = l3;
                list5 = list2;
                list6 = list0;
            label_126:
                if(u0.r(this.T)) {
                    s0 s00 = new s0(this.T, l4, l8, list6, list1, l9, list5, l5, set0);
                    this.S = w0;
                    this.r = list6;
                    this.w = list1;
                    this.B = list5;
                    this.D = l9;
                    this.E = l5;
                    this.G = l4;
                    this.I = set0;
                    this.M = l8;
                    this.N = 2;
                    if(w0.c(s00, this) == a0) {
                        break alab1;
                    }
                    l3 = l8;
                    l0 = l9;
                    list0 = list6;
                    list2 = list5;
                    break;
                }
                l3 = l8;
                l0 = l9;
                list0 = list6;
                list2 = list5;
            }
        }
        return a0;
    }
}

