package G;

import androidx.compose.runtime.O0;
import d5.n;
import ie.H;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import ne.a;
import oe.i;
import we.k;

public final class b extends i implements k {
    public int B;
    public final e D;
    public final Object E;
    public final j0 G;
    public final long I;
    public final k M;
    public p r;
    public C w;

    public b(e e0, Object object0, j0 j00, long v, k k0, Continuation continuation0) {
        this.D = e0;
        this.E = object0;
        this.G = j00;
        this.I = v;
        this.M = k0;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new b(this.D, this.E, this.G, this.I, this.M, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((b)this.create(((Continuation)object0))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        j0 j00 = this.G;
        a a0 = a.a;
        e e0 = this.D;
        switch(this.B) {
            case 0: {
                n.D(object0);
                try {
                    e0.c.c = (u)e0.a.a.invoke(this.E);
                    ((O0)e0.e).setValue(j00.c);
                    ((O0)e0.d).setValue(Boolean.TRUE);
                    Object object1 = ((O0)e0.c.b).getValue();
                    u u0 = f.j(e0.c.c);
                    p p0 = new p(e0.c.a, object1, u0, e0.c.d, 0x8000000000000000L, e0.c.f);
                    C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
                    G.a a1 = new G.a(e0, p0, this.M, c0, 0);
                    this.r = p0;
                    this.w = c0;
                    this.B = 1;
                    if(f.c(p0, j00, this.I, a1, this) == a0) {
                        return a0;
                    }
                    p p1 = p0;
                    C c1 = c0;
                    goto label_25;
                label_22:
                    c1 = this.w;
                    p1 = this.r;
                    n.D(object0);
                label_25:
                    l l0 = c1.a ? l.a : l.b;
                    e.b(e0);
                    return new m(p1, l0);
                }
                catch(CancellationException cancellationException0) {
                    break;
                }
            }
            case 1: {
                goto label_22;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        e.b(e0);
        throw cancellationException0;
    }
}

