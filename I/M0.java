package I;

import G.f;
import G.p;
import androidx.compose.runtime.O0;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.H;
import ne.a;
import oe.i;
import we.n;

public final class m0 extends i implements n {
    public int B;
    public int D;
    public Object E;
    public final E G;
    public final H I;
    public final H M;
    public final float N;
    public final t0 S;
    public final float T;
    public final g1 V;
    public C r;
    public C w;

    public m0(E e0, H h0, H h1, float f, t0 t00, float f1, g1 g10, Continuation continuation0) {
        this.G = e0;
        this.I = h0;
        this.M = h1;
        this.N = f;
        this.S = t00;
        this.T = f1;
        this.V = g10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new m0(this.G, this.I, this.M, this.N, this.S, this.T, this.V, continuation0);
        continuation1.E = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m0)this.create(((d1)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        t0 t00;
        float f;
        C c7;
        Object object2;
        H h3;
        int v;
        Object object1;
        C c4;
        C c3;
        H h2;
        d1 d11;
        C c0;
        d1 d10;
        a a0 = a.a;
        H h0 = this.M;
        E e0 = this.G;
        H h1 = this.I;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                d10 = (d1)this.E;
                c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
                c0.a = true;
                c7 = c0;
                goto label_38;
            }
            case 1: {
                C c1 = this.w;
                C c2 = this.r;
                d11 = (d1)this.E;
                d5.n.D(object0);
                h2 = h1;
                c3 = c2;
                c4 = c1;
                object1 = object0;
                c4.a = ((Boolean)object1).booleanValue();
                goto label_35;
            }
            case 2: {
                v = this.B;
                c0 = this.r;
                d11 = (d1)this.E;
                d5.n.D(object0);
                h3 = h1;
                goto label_73;
            }
            case 3: {
                C c5 = this.w;
                C c6 = this.r;
                d11 = (d1)this.E;
                d5.n.D(object0);
                h2 = h1;
                c3 = c6;
                c0 = c5;
                object2 = object0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            c0.a = ((Boolean)object2).booleanValue();
        label_35:
            h1 = h2;
            d10 = d11;
            c7 = c3;
        label_38:
            ie.H h4 = ie.H.a;
            if(!c7.a) {
                return h4;
            }
            c7.a = false;
            f = e0.a - ((Number)((O0)((p)h1.a).b).getValue()).floatValue();
            t00 = this.S;
            if(((h0)h0.a).c) {
                goto label_87;
            }
            float f1 = this.N;
            if(Math.abs(f) < f1) {
                goto label_87;
            }
            float f2 = Math.signum(f) * f1;
            t0.a(t00, d10, f2);
            p p0 = (p)h1.a;
            p p1 = f.k(p0, ((Number)((O0)p0.b).getValue()).floatValue() + f2, 0.0f, 30);
            h1.a = p1;
            int v1 = ye.a.V(Math.abs(e0.a - ((Number)((O0)p1.b).getValue()).floatValue()) / this.T);
            if(v1 > 100) {
                v1 = 100;
            }
            float f3 = e0.a;
            p p2 = (p)h1.a;
            l0 l00 = new l0(this.S, h0, e0, this.V, c7, 0);
            c0 = c7;
            this.E = d10;
            this.r = c0;
            this.w = null;
            this.B = v1;
            this.D = 2;
            this.S.getClass();
            E e1 = new E();  // 初始化器: Ljava/lang/Object;-><init>()V
            e1.a = ((Number)((O0)p2.b).getValue()).floatValue();
            h3 = h1;
            ie.H h5 = f.g(p2, new Float(f3), f.r(v1, 0, G.C.d, 2), true, new G.a(e1, this.S, d10, l00, 2), this);
            if(h5 != a.a) {
                h5 = h4;
            }
            if(h5 == a0) {
                return a0;
            }
            v = v1;
            d11 = d10;
        label_73:
            if(c0.a) {
                break;
            }
            this.E = d11;
            this.r = c0;
            this.w = c0;
            this.D = 3;
            h2 = h3;
            object2 = t0.c(this.S, h0, e0, this.V, h2, 50L - ((long)v), this);
            if(object2 == a0) {
                return a0;
            }
            c3 = c0;
        }
        h1 = h3;
        d10 = d11;
        c7 = c0;
        goto label_38;
    label_87:
        c4 = c7;
        h2 = h1;
        t0.a(t00, d10, f);
        this.E = d10;
        this.r = c4;
        this.w = c4;
        this.D = 1;
        object1 = t0.c(this.S, h0, e0, this.V, h2, 50L, this);
        if(object1 == a0) {
            return a0;
        }
        c3 = c4;
        d11 = d10;
        c4.a = ((Boolean)object1).booleanValue();
        goto label_35;
    }
}

