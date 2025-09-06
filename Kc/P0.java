package kc;

import com.melon.playlist.b;
import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import ne.a;
import oe.i;
import we.k;

public final class p0 extends i implements k {
    public final b B;
    public int r;
    public final C w;

    public p0(C c0, b b0, Continuation continuation0) {
        this.w = c0;
        this.B = b0;
        super(1, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Continuation continuation0) {
        return new p0(this.w, this.B, continuation0);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((p0)this.create(((Continuation)object0))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                n.D(object0);
                this.w.a = true;
                this.r = 1;
                object0 = this.B.B(this);
                return object0 == a0 ? a0 : Boolean.valueOf(e.k.y(((oc.H)object0)));
            }
            case 1: {
                n.D(object0);
                return Boolean.valueOf(e.k.y(((oc.H)object0)));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

