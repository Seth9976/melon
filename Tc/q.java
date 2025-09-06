package tc;

import e1.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class q extends i implements n {
    public final long B;
    public final int D;
    public final boolean E;
    public final String G;
    public int r;
    public final x w;

    public q(x x0, long v, int v1, boolean z, String s, Continuation continuation0) {
        this.w = x0;
        this.B = v;
        this.D = v1;
        this.E = z;
        this.G = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new q(this.w, this.B, this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        x x0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                p p0 = new p(x0, this.B, this.D, null);
                this.r = 1;
                object0 = x0.m(p0, this);
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
        E e0 = x0.a;
        if(this.E) {
            boolean z = b.y(((F)object0)) == null;
            kotlin.jvm.internal.q.g(this.G, "reason");
            D d0 = new D(e0, "", this.G, null);
            BuildersKt__Builders_commonKt.launch$default(e0.a, null, null, d0, 3, null);
            e0.c(this.B, this.G);
        }
        return object0;
    }
}

