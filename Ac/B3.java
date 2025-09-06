package Ac;

import J8.v;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.coroutines.Continuation;
import m0.b;
import oe.i;
import we.n;

public final class b3 extends i implements n {
    public final v B;
    public Object r;
    public final j3 w;

    public b3(j3 j30, v v0, Continuation continuation0) {
        this.w = j30;
        this.B = v0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new b3(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((b3)this.create(((v3)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        v3 v30 = (v3)this.r;
        d5.n.D(object0);
        j3 j30 = this.w;
        LogU.debug$default(j30.h, "filterUiState : " + v30, null, false, 6, null);
        if(Cb.i.l(v30)) {
            b b0 = new b(0xBF9DA0C8, new T2(j30, v30), true);
            this.B.d.setContent(b0);
        }
        return H.a;
    }
}

