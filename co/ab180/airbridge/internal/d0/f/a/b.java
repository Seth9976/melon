package co.ab180.airbridge.internal.d0.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.os.IBinder;
import co.ab180.airbridge.internal.e0.f;
import e1.u;
import ie.d;
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

@d
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0014\u001A\u00020\u0013\u0012\u0006\u0010\u0012\u001A\u00020\u000B¢\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0004\u001A\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001A\u0004\u0018\u00010\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000E\u001A\u00020\u000B8T@\u0014X\u0094\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u001C\u0010\u0012\u001A\u00020\u000B8\u0014@\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lco/ab180/airbridge/internal/d0/f/a/b;", "Lco/ab180/airbridge/internal/d0/b/a/d;", "Lco/ab180/airbridge/internal/d0/f/a/d;", "Landroid/content/Intent;", "h", "()Landroid/content/Intent;", "", "q", "()Z", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "p", "()Ljava/lang/String;", "tag", "i", "Ljava/lang/String;", "o", "packageName", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "a", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class b extends co.ab180.airbridge.internal.d0.b.a.d {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001E\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001A\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001A\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\n\u001A\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000B¨\u0006\u000E"}, d2 = {"co/ab180/airbridge/internal/d0/f/a/b$a", "", "", "ONESTORE_MIN_APP_VER", "I", "", "SERVICE_ACTION_NAME", "Ljava/lang/String;", "SERVICE_NAME", "", "TIMEOUT", "J", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {
        private a() {
        }

        public a(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final long d = 10000L;
    private static final int e = 60700;
    private static final String f = "com.onestore.android.external.installreferrer.GetInstallReferrerService";
    private static final String g = "com.onestore.android.external.BIND_GET_INSTALL_REFERRER_SERVICE";
    @NotNull
    public static final a h;
    @NotNull
    private final String i;

    static {
        b.h = new a(null);
    }

    public b(@NotNull Context context0, @NotNull String s) {
        super(context0);
        this.i = s;
    }

    public static final Context a(b b0) {
        return b0.m();
    }

    @Override  // co.ab180.airbridge.internal.d0.b.a.d
    @Nullable
    public Object d(@NotNull Continuation continuation0) {
        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001A\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008A@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "co/ab180/airbridge/internal/e0/f$b", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.util.CoroutineUtilsKt$suspendCoroutineWithTimeout$2", f = "CoroutineUtils.kt", l = {24}, m = "invokeSuspend")
        public static final class co.ab180.airbridge.internal.d0.f.a.b.b extends i implements n {
            Object a;
            Object b;
            int c;
            final H d;
            final b e;

            public co.ab180.airbridge.internal.d0.f.a.b.b(H h0, Continuation continuation0, b b0) {
                this.d = h0;
                this.e = b0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.d0.f.a.b.b(this.d, continuation0, this.e);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.d0.f.a.b.b)this.create(object0, ((Continuation)object1))).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/os/IBinder;", "it", "Lie/H;", "a", "(Landroid/os/IBinder;)V", "co/ab180/airbridge/internal/thirdparty/onestore/installreferrer/OneStoreInstallReferrerClient$request$2$connectionResult$1"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.d0.f.a.b.b.a extends r implements k {
                    final CancellableContinuation a;
                    final co.ab180.airbridge.internal.d0.f.a.b.b b;

                    public co.ab180.airbridge.internal.d0.f.a.b.b.a(CancellableContinuation cancellableContinuation0, co.ab180.airbridge.internal.d0.f.a.b.b b$b0) {
                        this.a = cancellableContinuation0;
                        this.b = b$b0;
                        super(1);
                    }

                    public final void a(@NotNull IBinder iBinder0) {
                        co.ab180.airbridge.internal.d0.f.a.d d0 = new co.ab180.airbridge.internal.d0.f.a.d(new co.ab180.airbridge.internal.d0.f.a.a(iBinder0).a("com.iloen.melon"));
                        f.a(this.a, d0);
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
                        co.ab180.airbridge.internal.d0.f.a.b.b.a b$b$a0 = new co.ab180.airbridge.internal.d0.f.a.b.b.a(cancellableContinuationImpl0, this);
                        if(!this.e.b(b$b$a0)) {
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
                        co.ab180.airbridge.internal.d0.f.a.b.b b$b0 = (co.ab180.airbridge.internal.d0.f.a.b.b)this.a;
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


        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/internal/d0/f/a/d;", "continuation", "", "request", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.thirdparty.onestore.installreferrer.OneStoreInstallReferrerClient", f = "OneStoreInstallReferrerClient.kt", l = {61}, m = "request")
        static final class c extends oe.c {
            Object a;
            int b;
            final b c;
            Object d;

            public c(b b0, Continuation continuation0) {
                this.c = b0;
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

        c b$c0;
        if(continuation0 instanceof c) {
            b$c0 = (c)continuation0;
            int v = b$c0.b;
            if((v & 0x80000000) == 0) {
                b$c0 = new c(this, continuation0);
            }
            else {
                b$c0.b = v ^ 0x80000000;
            }
        }
        else {
            b$c0 = new c(this, continuation0);
        }
        Object object0 = b$c0.a;
        ne.a a0 = ne.a.a;
        switch(b$c0.b) {
            case 0: {
                H h0 = H0.b.p(object0);
                h0.a = null;
                co.ab180.airbridge.internal.d0.f.a.b.b b$b0 = new co.ab180.airbridge.internal.d0.f.a.b.b(h0, null, this);
                b$c0.d = h0;
                b$c0.b = 1;
                return TimeoutKt.withTimeoutOrNull(10000L, b$b0, b$c0) == a0 ? a0 : h0.a;
            }
            case 1: {
                H h1 = (H)b$c0.d;
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
        Intent intent0 = new Intent("com.onestore.android.external.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent0.setComponent(new ComponentName(this.o(), "com.onestore.android.external.installreferrer.GetInstallReferrerService"));
        return intent0;
    }

    @Override  // co.ab180.airbridge.internal.d0.b.a.d
    @NotNull
    public String o() {
        return this.i;
    }

    @Override  // co.ab180.airbridge.internal.d0.b.a.d
    @NotNull
    public String p() {
        return "ONE/InstallReferrerClient(" + this.o() + ')';
    }

    @Override  // co.ab180.airbridge.internal.d0.b.a.d
    public boolean q() {
        PackageManager packageManager0 = this.m().getPackageManager();
        try {
            if(packageManager0.getPackageInfo(this.o(), 0x80).versionCode >= 60700) {
                return true;
            }
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        return false;
    }
}

