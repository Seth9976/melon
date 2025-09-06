package androidx.collection;

import Sf.m;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import we.n;

public final class h extends oe.h implements n {
    public int B;
    public int D;
    public int E;
    public int G;
    public long I;
    public int M;
    public Object N;
    public final i S;
    public i r;
    public long[] w;

    public h(i i0, Continuation continuation0) {
        this.S = i0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new h(this.S, continuation0);
        continuation1.N = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(((m)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v1;
        int v;
        long[] arr_v;
        i i0;
        m m0;
        a a0 = a.a;
        switch(this.M) {
            case 0: {
                d5.n.D(object0);
                m0 = (m)this.N;
                i0 = this.S;
                arr_v = i0.b.a;
                v = arr_v.length - 2;
                if(v >= 0) {
                    v1 = 0;
                    goto label_44;
                }
                break;
            }
            case 1: {
                int v2 = this.G;
                int v3 = this.E;
                long v4 = this.I;
                v1 = this.D;
                int v5 = this.B;
                long[] arr_v1 = this.w;
                i i1 = this.r;
                m m1 = (m)this.N;
                d5.n.D(object0);
                while(true) {
                    v4 >>= 8;
                    ++v2;
                label_22:
                    if(v2 >= v3) {
                        break;
                    }
                    if((0xFFL & v4) >= 0x80L) {
                        continue;
                    }
                    int v6 = (v1 << 3) + v2;
                    v v7 = new v(0, i1.b.b[v6], i1.b.c[v6]);
                    this.N = m1;
                    this.r = i1;
                    this.w = arr_v1;
                    this.B = v5;
                    this.D = v1;
                    this.I = v4;
                    this.E = v3;
                    this.G = v2;
                    this.M = 1;
                    m1.a(v7, this);
                    return a0;
                }
                if(v3 == 8) {
                    v = v5;
                    arr_v = arr_v1;
                    i0 = i1;
                    m0 = m1;
                    while(true) {
                        if(v1 == v) {
                            break;
                        }
                        ++v1;
                    label_44:
                        long v8 = arr_v[v1];
                        if((~v8 << 7 & v8 & 0x8080808080808080L) == 0x8080808080808080L) {
                            continue;
                        }
                        i1 = i0;
                        v3 = 8 - (~(v1 - v) >>> 0x1F);
                        m1 = m0;
                        v2 = 0;
                        arr_v1 = arr_v;
                        v5 = v;
                        v4 = v8;
                        goto label_22;
                    }
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }
}

