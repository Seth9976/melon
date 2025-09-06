package sc;

import e1.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class b0 extends i implements n {
    public final boolean B;
    public final int D;
    public final long E;
    public final boolean G;
    public final String I;
    public int r;
    public final P0 w;

    public b0(P0 p00, boolean z, int v, long v1, boolean z1, String s, Continuation continuation0) {
        this.w = p00;
        this.B = z;
        this.D = v;
        this.E = v1;
        this.G = z1;
        this.I = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b0(this.w, this.B, this.D, this.E, this.G, this.I, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        P0 p00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                a0 a00 = new a0(this.B, p00, this.D, this.E, null);
                this.r = 1;
                object0 = p00.e0(a00, this);
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
        f1 f10 = p00.d;
        if(this.G) {
            f10.e(b.y(((g1)object0)), this.I);
            f10.f(this.E, this.I);
        }
        return object0;
    }
}

