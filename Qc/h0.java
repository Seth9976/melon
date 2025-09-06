package qc;

import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oc.y0;
import oe.i;
import we.n;

public final class h0 extends i implements n {
    public final y0 B;
    public final boolean D;
    public int r;
    public final n0 w;

    public h0(n0 n00, y0 y00, boolean z, Continuation continuation0) {
        this.w = n00;
        this.B = y00;
        this.D = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h0(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        n0 n00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                g0 g00 = new g0(n00, this.B, null);
                this.r = 1;
                object0 = n00.Q(g00, this);
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
        if(this.D) {
            n00.b.getClass();
            q.g(((D0)object0).e, "sortType");
            B0 b00 = new B0(n00.b, ((D0)object0).e, null);
            BuildersKt__Builders_commonKt.launch$default(n00.b.c, null, null, b00, 3, null);
        }
        return object0;
    }
}

