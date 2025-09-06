package com.kakao.sdk.user;

import androidx.lifecycle.B;
import androidx.lifecycle.D;
import androidx.lifecycle.r;
import com.kakao.sdk.user.model.AccessTokenInfo;
import d3.g;
import ie.H;
import ie.j;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u000E2\u00020\u0001:\u0001\u000EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000F"}, d2 = {"Lcom/kakao/sdk/user/AppLifecycleObserver;", "Landroidx/lifecycle/B;", "<init>", "()V", "Landroidx/lifecycle/D;", "source", "Landroidx/lifecycle/r;", "event", "Lie/H;", "onStateChanged", "(Landroidx/lifecycle/D;Landroidx/lifecycle/r;)V", "", "prevTimeMillis", "J", "Companion", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppLifecycleObserver implements B {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\n\u001A\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001A\u00020\u000B8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/kakao/sdk/user/AppLifecycleObserver$Companion;", "", "<init>", "()V", "Lcom/kakao/sdk/user/AppLifecycleObserver;", "instance$delegate", "Lie/j;", "getInstance", "()Lcom/kakao/sdk/user/AppLifecycleObserver;", "getInstance$annotations", "instance", "", "INTERVAL_HOUR", "I", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final AppLifecycleObserver getInstance() {
            return (AppLifecycleObserver)AppLifecycleObserver.instance$delegate.getValue();
        }

        public static void getInstance$annotations() {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final int INTERVAL_HOUR = 6;
    @NotNull
    private static final j instance$delegate;
    private long prevTimeMillis;

    static {
        AppLifecycleObserver.Companion = new Companion(null);
        AppLifecycleObserver.instance$delegate = g.Q(AppLifecycleObserver.Companion.instance.2.INSTANCE);
    }

    @NotNull
    public static final AppLifecycleObserver getInstance() {
        return AppLifecycleObserver.Companion.getInstance();
    }

    @Override  // androidx.lifecycle.B
    public void onStateChanged(@NotNull D d0, @NotNull r r0) {
        q.g(d0, "source");
        q.g(r0, "event");
        if(r0 == r.ON_START) {
            long v = System.currentTimeMillis();
            if(TimeUnit.MILLISECONDS.toHours(v - this.prevTimeMillis) >= 6L) {
                this.prevTimeMillis = v;
                UserApiClient.Companion.getInstance().checkAccessToken$user_release(com.kakao.sdk.user.AppLifecycleObserver.onStateChanged.1.INSTANCE);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u00042\b\u0010\u0001\u001A\u0004\u0018\u00010\u00002\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/kakao/sdk/user/model/AccessTokenInfo;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Lie/H;", "invoke", "(Lcom/kakao/sdk/user/model/AccessTokenInfo;Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        final class com.kakao.sdk.user.AppLifecycleObserver.onStateChanged.1 extends kotlin.jvm.internal.r implements n {
            public static final com.kakao.sdk.user.AppLifecycleObserver.onStateChanged.1 INSTANCE;

            static {
                com.kakao.sdk.user.AppLifecycleObserver.onStateChanged.1.INSTANCE = new com.kakao.sdk.user.AppLifecycleObserver.onStateChanged.1();
            }

            public com.kakao.sdk.user.AppLifecycleObserver.onStateChanged.1() {
                super(2);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return H.a;
            }

            public final void invoke(@Nullable AccessTokenInfo accessTokenInfo0, @Nullable Throwable throwable0) {
            }
        }

    }
}

