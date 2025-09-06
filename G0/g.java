package g0;

import Sf.m;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.h;
import we.n;

public final class g extends h implements n {
    public int B;
    public int D;
    public int E;
    public int G;
    public long I;
    public int M;
    public Object N;
    public final g0.h S;
    public Object[] r;
    public long[] w;

    public g(g0.h h0, Continuation continuation0) {
        this.S = h0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new g(this.S, continuation0);
        continuation1.N = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g)this.create(((m)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v1;
        int v;
        long[] arr_v;
        Object[] arr_object;
        m m0;
        a a0 = a.a;
        switch(this.M) {
            case 0: {
                d5.n.D(object0);
                m0 = (m)this.N;
                arr_object = this.S.a.b;
                arr_v = this.S.a.a;
                v = arr_v.length - 2;
                if(v >= 0) {
                    v1 = 0;
                    goto label_42;
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
                Object[] arr_object1 = this.r;
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
                    this.N = m1;
                    this.r = arr_object1;
                    this.w = arr_v1;
                    this.B = v5;
                    this.D = v1;
                    this.I = v4;
                    this.E = v3;
                    this.G = v2;
                    this.M = 1;
                    m1.a(arr_object1[(v1 << 3) + v2], this);
                    return a0;
                }
                if(v3 == 8) {
                    v = v5;
                    arr_v = arr_v1;
                    arr_object = arr_object1;
                    m0 = m1;
                    while(true) {
                        if(v1 == v) {
                            break;
                        }
                        ++v1;
                    label_42:
                        long v6 = arr_v[v1];
                        if((~v6 << 7 & v6 & 0x8080808080808080L) == 0x8080808080808080L) {
                            continue;
                        }
                        m1 = m0;
                        v2 = 0;
                        arr_v1 = arr_v;
                        v5 = v;
                        v3 = 8 - (~(v1 - v) >>> 0x1F);
                        arr_object1 = arr_object;
                        v4 = v6;
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

