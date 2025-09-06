package p8;

import com.iloen.melon.MelonTiaraUserInfo;
import ie.H;
import k8.J;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class y extends i implements n {
    public final String B;
    public final String D;
    public final String E;
    public Object r;
    public final String w;

    public y(String s, String s1, String s2, String s3, Continuation continuation0) {
        this.w = s;
        this.B = s1;
        this.D = s2;
        this.E = s3;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new y(this.w, this.B, this.D, this.E, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y)this.create(((MelonTiaraUserInfo)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        MelonTiaraUserInfo melonTiaraUserInfo0 = (MelonTiaraUserInfo)this.r;
        d5.n.D(object0);
        J j0 = (J)melonTiaraUserInfo0.toBuilder();
        j0.d();
        ((MelonTiaraUserInfo)j0.b).setPaymentType(this.w);
        j0.d();
        ((MelonTiaraUserInfo)j0.b).setProductName(this.B);
        j0.d();
        ((MelonTiaraUserInfo)j0.b).setProductPrice(this.D);
        j0.d();
        ((MelonTiaraUserInfo)j0.b).setRestrictAd(this.E);
        return j0.a();
    }
}

