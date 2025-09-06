package pc;

import e1.b;
import ie.H;
import java.util.List;
import je.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.F;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class C extends i implements n {
    public final int B;
    public final int D;
    public final F E;
    public final boolean G;
    public int r;
    public final Z w;

    public C(Z z0, int v, int v1, F f0, boolean z1, Continuation continuation0) {
        this.w = z0;
        this.B = v;
        this.D = v1;
        this.E = f0;
        this.G = z1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new C(this.w, this.B, this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((C)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        Z z0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                B b0 = new B(z0, this.B, this.D, this.E, null);
                this.r = 1;
                object0 = z0.A(b0, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(this.G) {
            List list0 = p.P0(b.B(((z0)object0)));
            m0 m00 = new m0(((y0)z0.c), list0, null);
            BuildersKt__Builders_commonKt.launch$default(((y0)z0.c).g, null, null, m00, 3, null);
            ((y0)z0.c).f(((z0)object0).b, "move()");
            ((y0)z0.c).e(((z0)object0).d);
        }
        Z.c(z0);
        return object0;
    }
}

