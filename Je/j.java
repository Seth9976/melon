package je;

import Sf.m;
import ie.H;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ne.a;
import oe.h;
import we.n;

public final class J extends h implements n {
    public int B;
    public int D;
    public int E;
    public Object G;
    public final int I;
    public final int M;
    public final Iterator N;
    public Object r;
    public Iterator w;

    public J(int v, int v1, Iterator iterator0, Continuation continuation0) {
        this.I = v;
        this.M = v1;
        this.N = iterator0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new J(this.I, this.M, this.N, continuation0);
        continuation1.G = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((J)this.create(((m)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        je.H h1;
        int v3;
        int v2;
        je.H h2;
        Iterator iterator0;
        int v4;
        int v7;
        ArrayList arrayList2;
        Iterator iterator1;
        int v6;
        int v5;
        Object[] arr_object1;
        m m0 = (m)this.G;
        a a0 = a.a;
        int v = this.M;
        int v1 = this.I;
        switch(this.E) {
            case 0: {
                d5.n.D(object0);
                int v8 = v1 > 0x400 ? 0x400 : v1;
                v7 = v - v1;
                Iterator iterator2 = this.N;
                if(v7 >= 0) {
                    arrayList2 = new ArrayList(v8);
                    v6 = v8;
                    v5 = 0;
                    iterator1 = iterator2;
                label_41:
                    while(iterator1.hasNext()) {
                        Object object1 = iterator1.next();
                        if(v5 > 0) {
                            --v5;
                        }
                        else {
                            arrayList2.add(object1);
                            if(arrayList2.size() == v1) {
                                this.G = m0;
                                this.r = arrayList2;
                                this.w = iterator1;
                                this.B = v6;
                                this.D = v7;
                                this.E = 1;
                                m0.a(arrayList2, this);
                                return a0;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                    if(!arrayList2.isEmpty()) {
                        this.G = null;
                        this.r = null;
                        this.w = null;
                        this.B = v6;
                        this.D = v7;
                        this.E = 2;
                        m0.a(arrayList2, this);
                        return a0;
                    }
                }
                else {
                    v4 = v8;
                    v2 = v7;
                    iterator0 = iterator2;
                    h2 = new je.H(new Object[v8], 0);
                    while(true) {
                    label_70:
                        int v9 = h2.b;
                        Object[] arr_object = h2.a;
                        if(!iterator0.hasNext()) {
                            goto label_97;
                        }
                        Object object2 = iterator0.next();
                        if(h2.size() == v9) {
                            throw new IllegalStateException("ring buffer is full");
                        }
                        arr_object[(h2.size() + h2.c) % v9] = object2;
                        h2.d = h2.size() + 1;
                        if(h2.size() == v9) {
                            if(h2.size() >= v1) {
                                break;
                            }
                            int v10 = v9 + (v9 >> 1) + 1 <= v1 ? v9 + (v9 >> 1) + 1 : v1;
                            if(h2.c == 0) {
                                arr_object1 = Arrays.copyOf(arr_object, v10);
                                q.f(arr_object1, "copyOf(...)");
                            }
                            else {
                                arr_object1 = h2.toArray(new Object[v10]);
                            }
                            h2 = new je.H(arr_object1, h2.size());
                        }
                    }
                    ArrayList arrayList3 = new ArrayList(h2);
                    this.G = m0;
                    this.r = h2;
                    this.w = iterator0;
                    this.B = v4;
                    this.D = v2;
                    this.E = 3;
                    m0.a(arrayList3, this);
                    return a0;
                label_97:
                    v3 = v4;
                    h1 = h2;
                label_99:
                    if(h1.size() > v) {
                        ArrayList arrayList4 = new ArrayList(h1);
                        this.G = m0;
                        this.r = h1;
                        this.w = null;
                        this.B = v3;
                        this.D = v2;
                        this.E = 4;
                        m0.a(arrayList4, this);
                        return a0;
                    }
                    if(!h1.isEmpty()) {
                        this.G = null;
                        this.r = null;
                        this.w = null;
                        this.B = v3;
                        this.D = v2;
                        this.E = 5;
                        m0.a(h1, this);
                        return a0;
                    }
                }
                break;
            }
            case 1: {
                v5 = this.D;
                v6 = this.B;
                iterator1 = this.w;
                ArrayList arrayList1 = (ArrayList)this.r;
                d5.n.D(object0);
                arrayList2 = new ArrayList(v1);
                v7 = v5;
                goto label_41;
            }
            case 2: {
                ArrayList arrayList0 = (ArrayList)this.r;
                d5.n.D(object0);
                return H.a;
            }
            case 3: {
                v2 = this.D;
                v4 = this.B;
                iterator0 = this.w;
                h2 = (je.H)this.r;
                d5.n.D(object0);
                h2.a(v);
                goto label_70;
            }
            case 4: {
                v2 = this.D;
                v3 = this.B;
                h1 = (je.H)this.r;
                d5.n.D(object0);
                h1.a(v);
                goto label_99;
            }
            case 5: {
                je.H h0 = (je.H)this.r;
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

