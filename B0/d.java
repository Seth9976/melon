package b0;

import G.x0;
import K.b;
import K.h;
import K.k;
import K.o;
import androidx.compose.runtime.O0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import r1.f;
import we.n;

public final class d extends i implements n {
    public final float B;
    public final boolean D;
    public final e E;
    public final k G;
    public int r;
    public final G.e w;

    public d(G.e e0, float f, boolean z, e e1, k k0, Continuation continuation0) {
        this.w = e0;
        this.B = f;
        this.D = z;
        this.E = e1;
        this.G = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d(this.w, this.B, this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        H h1;
        o o0;
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                G.e e0 = this.w;
                float f = ((f)((O0)e0.e).getValue()).a;
                float f1 = this.B;
                if(!f.a(f, f1)) {
                    if(!this.D) {
                        f f2 = new f(f1);
                        this.r = 1;
                        return e0.e(f2, this) == a0 ? a0 : h0;
                    }
                    float f3 = ((f)((O0)e0.e).getValue()).a;
                    e e1 = this.E;
                    x0 x00 = null;
                    if(f.a(f3, e1.b)) {
                        o0 = new o(0L);
                    }
                    else if(f.a(f3, e1.d)) {
                        o0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
                    }
                    else if(f.a(f3, e1.c)) {
                        o0 = new K.f();  // 初始化器: Ljava/lang/Object;-><init>()V
                    }
                    else {
                        o0 = null;
                    }
                    this.r = 2;
                    x0 x01 = c0.e.b;
                    x0 x02 = c0.e.a;
                    k k0 = this.G;
                    if(k0 == null) {
                        if(o0 != null) {
                            if(o0 instanceof o) {
                                x00 = x01;
                            }
                            else if(o0 instanceof b) {
                                x00 = x01;
                            }
                            else if(o0 instanceof h) {
                                x00 = c0.e.c;
                            }
                            else if(o0 instanceof K.f) {
                                x00 = x01;
                            }
                        }
                    }
                    else if(k0 instanceof o) {
                        x00 = x02;
                    }
                    else if(k0 instanceof b || k0 instanceof h || k0 instanceof K.f) {
                        x00 = x02;
                    }
                    G.e e2 = this.w;
                    if(x00 == null) {
                        h1 = e2.e(new f(f1), this);
                        if(h1 != a0) {
                            h1 = h0;
                        }
                    }
                    else {
                        h1 = G.e.c(e2, new f(f1), x00, null, this, 12);
                        if(h1 != a0) {
                            h1 = h0;
                        }
                    }
                    if(h1 == a0) {
                        return a0;
                    }
                }
                return h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            case 2: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

