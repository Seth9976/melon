package va;

import com.iloen.melon.LoginUser;
import ie.H;
import k8.s;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class t0 extends i implements n {
    public Object r;
    public final String w;

    public t0(String s, Continuation continuation0) {
        this.w = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new t0(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((t0)this.create(((LoginUser)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        LoginUser loginUser0 = (LoginUser)this.r;
        d5.n.D(object0);
        s s0 = (s)loginUser0.toBuilder();
        s0.i(this.w);
        return s0.a();
    }
}

