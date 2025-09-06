package kc;

import com.melon.playlist.b;
import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import nc.G0;
import nc.H0;
import ne.a;
import oe.i;
import we.k;

public final class w0 extends i implements k {
    public final H0 B;
    public int r;
    public final b w;

    public w0(b b0, H0 h00, Continuation continuation0) {
        this.w = b0;
        this.B = h00;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new w0(this.w, this.B, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((w0)this.create(((Continuation)object0))).invokeSuspend(H.a);
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
                    return e.a(e0, ((G0)this.B).a, true, this) == a0 ? a0 : H.a;
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

