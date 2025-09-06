package co.ab180.airbridge.internal.d0.d.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import co.ab180.airbridge.internal.d0.b.a.d;
import co.ab180.airbridge.internal.e0.f;
import e1.u;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.TimeoutKt;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u000F\u0012\u0006\u0010\u0012\u001A\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0004\u001A\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001A\u0004\u0018\u00010\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000E\u001A\u00020\u000B8T@\u0014X\u0094\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001A\u00020\u000B8T@\u0014X\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lco/ab180/airbridge/internal/d0/d/c/a;", "Lco/ab180/airbridge/internal/d0/b/a/d;", "Lco/ab180/airbridge/internal/d0/d/c/c;", "Landroid/content/Intent;", "h", "()Landroid/content/Intent;", "", "q", "()Z", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "o", "()Ljava/lang/String;", "packageName", "p", "tag", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "i", "a", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class a extends d {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000B\u0010\fR\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001A\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001A\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001A\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\r"}, d2 = {"co/ab180/airbridge/internal/d0/d/c/a$a", "", "", "PLAY_STORE_MIN_APP_VER", "J", "", "SERVICE_ACTION_NAME", "Ljava/lang/String;", "SERVICE_NAME", "SERVICE_PACKAGE_NAME", "TIMEOUT", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class co.ab180.airbridge.internal.d0.d.c.a.a {
        private co.ab180.airbridge.internal.d0.d.c.a.a() {
        }

        public co.ab180.airbridge.internal.d0.d.c.a.a(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final long d = 10000L;
    private static final long e = 80837300L;
    private static final String f = "com.android.vending";
    private static final String g = "com.google.android.finsky.externalreferrer.GetInstallReferrerService";
    private static final String h = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE";
    @NotNull
    public static final co.ab180.airbridge.internal.d0.d.c.a.a i;

    static {
        a.i = new co.ab180.airbridge.internal.d0.d.c.a.a(null);
    }

    public a(@NotNull Context context0) {
        super(context0);
    }

    public static final Context a(a a0) {
        return a0.m();
    }

    @Override  // co.ab180.airbridge.internal.d0.b.a.d
    @Nullable
    public Object d(@NotNull Continuation continuation0) {
        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001A\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008A@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "co/ab180/airbridge/internal/e0/f$b", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.util.CoroutineUtilsKt$suspendCoroutineWithTimeout$2", f = "CoroutineUtils.kt", l = {24}, m = "invokeSuspend")
        public static final class b extends i implements n {
            Object a;
            Object b;
            int c;
            final H d;
            final a e;

            public b(H h0, Continuation continuation0, a a0) {
                this.d = h0;
                this.e = a0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new b(this.d, continuation0, this.e);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((b)this.create(object0, ((Continuation)object1))).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/os/IBinder;", "it", "Lie/H;", "a", "(Landroid/os/IBinder;)V", "co/ab180/airbridge/internal/thirdparty/google/installreferrer/GoogleInstallReferrerClient$request$2$connectionResult$1"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.d0.d.c.a.b.a extends r implements k {
                    final CancellableContinuation a;
                    final b b;

                    public co.ab180.airbridge.internal.d0.d.c.a.b.a(CancellableContinuation cancellableContinuation0, b a$b0) {
                        this.a = cancellableContinuation0;
                        this.b = a$b0;
                        super(1);
                    }

                    public final void a(@NotNull IBinder iBinder0) {
                        co.ab180.airbridge.internal.d0.d.c.b b0 = new co.ab180.airbridge.internal.d0.d.c.b(iBinder0);
                        Bundle bundle0 = new Bundle();
                        bundle0.putString("package_name", "com.iloen.melon");
                        c c0 = new c(b0.a(bundle0));
                        f.a(this.a, c0);
                    }

                    @Override  // we.k
                    public Object invoke(Object object0) {
                        this.a(((IBinder)object0));
                        return ie.H.a;
                    }
                }

                H h1;
                ne.a a0 = ne.a.a;
                switch(this.c) {
                    case 0: {
                        d5.n.D(object0);
                        H h0 = this.d;
                        this.a = this;
                        this.b = h0;
                        this.c = 1;
                        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(this), 1);
                        cancellableContinuationImpl0.initCancellability();
                        co.ab180.airbridge.internal.d0.d.c.a.b.a a$b$a0 = new co.ab180.airbridge.internal.d0.d.c.a.b.a(cancellableContinuationImpl0, this);
                        if(!this.e.b(a$b$a0)) {
                            f.a(cancellableContinuationImpl0, null);
                        }
                        Object object1 = cancellableContinuationImpl0.getResult();
                        if(object1 == a0) {
                            return a0;
                        }
                        h1 = h0;
                        object0 = object1;
                        break;
                    }
                    case 1: {
                        h1 = (H)this.b;
                        b a$b0 = (b)this.a;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                h1.a = object0;
                return ie.H.a;
            }
        }


        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/internal/d0/d/c/c;", "continuation", "", "request", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.thirdparty.google.installreferrer.GoogleInstallReferrerClient", f = "GoogleInstallReferrerClient.kt", l = {52}, m = "request")
        static final class co.ab180.airbridge.internal.d0.d.c.a.c extends oe.c {
            Object a;
            int b;
            final a c;
            Object d;

            public co.ab180.airbridge.internal.d0.d.c.a.c(a a0, Continuation continuation0) {
                this.c = a0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.d(this);
            }
        }

        co.ab180.airbridge.internal.d0.d.c.a.c a$c0;
        if(continuation0 instanceof co.ab180.airbridge.internal.d0.d.c.a.c) {
            a$c0 = (co.ab180.airbridge.internal.d0.d.c.a.c)continuation0;
            int v = a$c0.b;
            if((v & 0x80000000) == 0) {
                a$c0 = new co.ab180.airbridge.internal.d0.d.c.a.c(this, continuation0);
            }
            else {
                a$c0.b = v ^ 0x80000000;
            }
        }
        else {
            a$c0 = new co.ab180.airbridge.internal.d0.d.c.a.c(this, continuation0);
        }
        Object object0 = a$c0.a;
        ne.a a0 = ne.a.a;
        switch(a$c0.b) {
            case 0: {
                H h0 = H0.b.p(object0);
                h0.a = null;
                b a$b0 = new b(h0, null, this);
                a$c0.d = h0;
                a$c0.b = 1;
                return TimeoutKt.withTimeoutOrNull(10000L, a$b0, a$c0) == a0 ? a0 : h0.a;
            }
            case 1: {
                H h1 = (H)a$c0.d;
                d5.n.D(object0);
                return h1.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // co.ab180.airbridge.internal.d0.b.a.d
    @NotNull
    public Intent h() {
        Intent intent0 = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent0.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        return intent0;
    }

    @Override  // co.ab180.airbridge.internal.d0.b.a.d
    @NotNull
    public String o() {
        return "com.android.vending";
    }

    @Override  // co.ab180.airbridge.internal.d0.b.a.d
    @NotNull
    public String p() {
        return "Google/InstallReferrerClient";
    }

    @Override  // co.ab180.airbridge.internal.d0.b.a.d
    public boolean q() {
        return co.ab180.airbridge.internal.d0.d.a.a.a.b(this.m(), 80837300L);
    }
}

