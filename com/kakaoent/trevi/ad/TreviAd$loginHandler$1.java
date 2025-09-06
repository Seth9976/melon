package com.kakaoent.trevi.ad;

import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import we.a;
import we.k;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "userId", "Lie/H;", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
final class TreviAd.loginHandler.1 extends r implements k {
    public static final TreviAd.loginHandler.1 INSTANCE;

    static {
        TreviAd.loginHandler.1.INSTANCE = new TreviAd.loginHandler.1();
    }

    public TreviAd.loginHandler.1() {
        super(1);
    }

    @Override  // we.k
    public Object invoke(Object object0) {
        this.invoke(((String)object0));
        return H.a;
    }

    public final void invoke(@NotNull String s) {
        q.g(s, "userId");
        TreviAd.INSTANCE.setAppUserId(s);
        a a0 = TreviAd.INSTANCE.getLoginReceiver$trevi_ad_android_sdk_release();
        if(a0 != null) {
            a0.invoke();
        }
    }
}

