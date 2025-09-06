package W;

import Q0.V;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.k;
import we.n;

public final class d extends i implements n {
    public final V B;
    public final k D;
    public final f E;
    public final r G;
    public int r;
    public Object w;

    public d(V v0, k k0, f f0, r r0, Continuation continuation0) {
        this.B = v0;
        this.D = k0;
        this.E = f0;
        this.G = r0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new d(this.B, this.D, this.E, this.G, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((d)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return a.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        f f0 = this.E;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
                V v0 = this.B;
                v.a.getClass();
                p p0 = new p(v0.a);
                c c0 = new c(this.G);
                w w0 = new w(v0.a, c0, p0);
                if(V.c.a) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new b(f0, p0, null), 3, null);
                }
                k k0 = this.D;
                if(k0 != null) {
                    k0.invoke(w0);
                }
                try {
                    f0.c = w0;
                    this.r = 1;
                    v0.a(w0, this);
                    return a0;
                label_20:
                    d5.n.D(object0);
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                catch(Throwable throwable0) {
                    f0.c = null;
                    throw throwable0;
                }
            }
            case 1: {
                goto label_20;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

