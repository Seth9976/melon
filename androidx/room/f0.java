package androidx.room;

import A4.c;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.i;
import we.n;

public final class f0 extends i implements n {
    public T B;
    public int D;
    public int E;
    public int G;
    public int I;
    public final s[] M;
    public final h0 N;
    public final T S;
    public s[] r;
    public h0 w;

    public f0(s[] arr_s, h0 h00, T t0, Continuation continuation0) {
        this.M = arr_s;
        this.N = h00;
        this.S = t0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new f0(this.M, this.N, this.S, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f0)this.create(((c)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v3;
        h0 h00;
        int v2;
        s[] arr_s;
        T t0;
        int v1;
        int v;
        a a0 = a.a;
        switch(this.I) {
            case 0: {
                d5.n.D(object0);
                v = this.M.length;
                v1 = 0;
                t0 = this.S;
                arr_s = this.M;
                v2 = 0;
                h00 = this.N;
                goto label_20;
            }
            case 1: 
            case 2: {
                v = this.G;
                v1 = this.E;
                v3 = this.D;
                t0 = this.B;
                h00 = this.w;
                arr_s = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    alab1:
        while(true) {
            v2 = v3;
        alab2:
            while(true) {
                ++v1;
            label_20:
                if(v1 >= v) {
                    break alab1;
                }
                switch(arr_s[v1].ordinal()) {
                    case 0: {
                        ++v2;
                        break;
                    }
                    case 1: {
                        break alab2;
                    }
                    case 2: {
                        goto label_34;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
            this.r = arr_s;
            this.w = h00;
            this.B = t0;
            this.D = v2 + 1;
            this.E = v1;
            this.G = v;
            this.I = 1;
            if(h0.c(h00, t0, v2, this) == a0) {
                return a0;
            label_34:
                this.r = arr_s;
                this.w = h00;
                this.B = t0;
                this.D = v2 + 1;
                this.E = v1;
                this.G = v;
                this.I = 2;
                if(h0.d(h00, t0, v2, this) != a0) {
                    v3 = v2 + 1;
                    continue;
                }
            }
            else {
                v3 = v2 + 1;
                continue;
            }
            return a0;
        }
        return H.a;
    }
}

