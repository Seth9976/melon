package Ac;

import J8.v;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.coroutines.Continuation;
import m0.b;
import oe.i;
import we.n;

public final class e3 extends i implements n {
    public final v B;
    public Object r;
    public final j3 w;

    public e3(j3 j30, v v0, Continuation continuation0) {
        this.w = j30;
        this.B = v0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new e3(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((e3)this.create(((B3)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        B3 b30 = (B3)this.r;
        d5.n.D(object0);
        j3 j30 = this.w;
        LogU.debug$default(j30.h, "sortUiState : " + b30, null, false, 6, null);
        if(Cb.i.l(b30)) {
            b b0 = new b(0x623830A5, new S2(j30, b30), true);
            this.B.f.setContent(b0);
        }
        return H.a;
    }
}

