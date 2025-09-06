package qc;

import e1.b;
import ie.H;
import java.util.ArrayList;
import je.p;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class s extends i implements n {
    public final int B;
    public final int D;
    public final boolean E;
    public int r;
    public final n0 w;

    public s(n0 n00, int v, int v1, boolean z, Continuation continuation0) {
        this.w = n00;
        this.B = v;
        this.D = v1;
        this.E = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new s(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        n0 n00 = this.w;
        C0 c00 = n00.b;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                r r0 = new r(n00, this.B, this.D, null);
                this.r = 1;
                object0 = n00.Q(r0, this);
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
        if(this.E) {
            ArrayList arrayList0 = b.B(((D0)object0));
            c00.getClass();
            u0 u00 = new u0(c00, p.P0(arrayList0), null);
            BuildersKt__Builders_commonKt.launch$default(c00.c, null, null, u00, 3, null);
            c00.f(((D0)object0).b, "move");
        }
        return object0;
    }
}

