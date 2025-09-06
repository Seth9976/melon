package kc;

import com.melon.playlist.b;
import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import oc.A0;
import oc.B0;
import oe.i;
import we.k;

public final class j1 extends i implements k {
    public final B0 B;
    public final boolean D;
    public int r;
    public final b w;

    public j1(b b0, B0 b00, boolean z, Continuation continuation0) {
        this.w = b0;
        this.B = b00;
        this.D = z;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new j1(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((j1)this.create(((Continuation)object0))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                e e0 = this.w.t;
                if(e0 != null) {
                    this.r = 1;
                    return e.a(e0, ((A0)this.B).a, this.D, this) == a0 ? a0 : H.a;
                }
                return null;
            }
            case 1: {
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

