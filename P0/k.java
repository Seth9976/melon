package p0;

import Sf.m;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.h;
import we.n;

public final class k extends h implements n {
    public int B;
    public int D;
    public Object E;
    public final l G;
    public long[] r;
    public int w;

    public k(l l0, Continuation continuation0) {
        this.G = l0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new k(this.G, continuation0);
        continuation1.E = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k)this.create(((m)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v7;
        m m2;
        int v6;
        m m1;
        int v4;
        int v3;
        long[] arr_v;
        m m0;
        l l0 = this.G;
        long v = l0.a;
        long v1 = l0.c;
        long v2 = l0.b;
        a a0 = a.a;
    alab1:
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                m0 = (m)this.E;
                arr_v = l0.d;
                if(arr_v != null) {
                    v3 = arr_v.length;
                    v4 = 0;
                    goto label_20;
                }
                goto label_28;
            }
            case 1: {
                v3 = this.B;
                int v5 = this.w;
                arr_v = this.r;
                m0 = (m)this.E;
                d5.n.D(object0);
                v4 = v5 + 1;
            label_20:
                if(v4 < v3) {
                    this.E = m0;
                    this.r = arr_v;
                    this.w = v4;
                    this.B = v3;
                    this.D = 1;
                    m0.a(new Long(arr_v[v4]), this);
                    return a0;
                }
            label_28:
                if(v2 != 0L) {
                    m1 = m0;
                    v6 = 0;
                    goto label_36;
                }
                goto label_45;
            }
            case 2: {
                v6 = this.w;
                m1 = (m)this.E;
                d5.n.D(object0);
                while(true) {
                    ++v6;
                label_36:
                    if(v6 >= 0x40) {
                        break;
                    }
                    if((1L << v6 & v2) == 0L) {
                        continue;
                    }
                    this.E = m1;
                    this.r = null;
                    this.w = v6;
                    this.D = 2;
                    m1.a(new Long(v1 + ((long)v6)), this);
                    return a0;
                }
                m0 = m1;
            label_45:
                if(v != 0L) {
                    m2 = m0;
                    v7 = 0;
                    goto label_53;
                }
                break;
            }
            case 3: {
                v7 = this.w;
                m2 = (m)this.E;
                d5.n.D(object0);
                while(true) {
                    ++v7;
                label_53:
                    if(v7 >= 0x40) {
                        break alab1;
                    }
                    if((1L << v7 & v) == 0L) {
                        continue;
                    }
                    this.E = m2;
                    this.r = null;
                    this.w = v7;
                    this.D = 3;
                    m2.a(new Long(v1 + ((long)v7) + 0x40L), this);
                    return a0;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

