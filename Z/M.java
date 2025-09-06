package Z;

import G.e;
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

public final class m extends i implements n {
    public final float B;
    public final boolean D;
    public final Z.n E;
    public final k G;
    public int r;
    public final e w;

    public m(e e0, float f, boolean z, Z.n n0, k k0, Continuation continuation0) {
        this.w = e0;
        this.B = f;
        this.D = z;
        this.E = n0;
        this.G = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m(this.w, this.B, this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        o o0;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                e e0 = this.w;
                float f = ((f)((O0)e0.e).getValue()).a;
                float f1 = this.B;
                if(!f.a(f, f1)) {
                    if(this.D) {
                        float f3 = ((f)((O0)e0.e).getValue()).a;
                        Z.n n0 = this.E;
                        if(f.a(f3, n0.b)) {
                            o0 = new o(0L);
                        }
                        else if(f.a(f3, n0.d)) {
                            o0 = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
                        }
                        else if(f.a(f3, n0.e)) {
                            o0 = new K.f();  // 初始化器: Ljava/lang/Object;-><init>()V
                        }
                        else {
                            o0 = null;
                        }
                        this.r = 2;
                        if(u.a(e0, f1, o0, this.G, this) == a0) {
                            return a0;
                        }
                    }
                    else {
                        f f2 = new f(f1);
                        this.r = 1;
                        if(e0.e(f2, this) == a0) {
                            return a0;
                        }
                    }
                }
                return H.a;
            }
            case 1: 
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

