package co.ab180.airbridge.internal.thirdparty.huawei.installreferrer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.os.IBinder;
import co.ab180.airbridge.internal.d0.b.a.d;
import co.ab180.airbridge.internal.e0.b0;
import co.ab180.airbridge.internal.e0.f;
import co.ab180.airbridge.internal.parser.c;
import co.ab180.airbridge.internal.parser.e.y;
import e1.u;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.TimeoutKt;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import we.k;
import we.n;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u000F\u0012\u0006\u0010\u0012\u001A\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0004\u001A\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001A\u0004\u0018\u00010\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000E\u001A\u00020\u000B8T@\u0014X\u0094\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001A\u00020\u000B8T@\u0014X\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lco/ab180/airbridge/internal/thirdparty/huawei/installreferrer/a;", "Lco/ab180/airbridge/internal/d0/b/a/d;", "Lco/ab180/airbridge/internal/thirdparty/huawei/installreferrer/ReferrerDetails;", "Landroid/content/Intent;", "h", "()Landroid/content/Intent;", "", "q", "()Z", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "o", "()Ljava/lang/String;", "packageName", "p", "tag", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "i", "a", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class a extends d {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000B\u0010\fR\u0016\u0010\u0003\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001A\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001A\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001A\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001A\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\r"}, d2 = {"co/ab180/airbridge/internal/thirdparty/huawei/installreferrer/a$a", "", "", "HMS_MIN_APP_VER", "J", "", "SERVICE_ACTION_NAME", "Ljava/lang/String;", "SERVICE_NAME", "SERVICE_PACKAGE_NAME", "TIMEOUT", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
    public static final class co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.a {
        private co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.a() {
        }

        public co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.a(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final long d = 10000L;
    private static final long e = 20605000L;
    private static final String f = "com.huawei.hwid";
    private static final String g = "com.huawei.android.hms.ppskit.PpsChannelInfoService";
    private static final String h = "com.huawei.android.hms.CHANNEL_SERVICE";
    @NotNull
    public static final co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.a i;

    static {
        a.i = new co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.a(null);
    }

    public a(@NotNull Context context0) {
        super(context0);
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
                @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/os/IBinder;", "it", "Lie/H;", "a", "(Landroid/os/IBinder;)V", "co/ab180/airbridge/internal/thirdparty/huawei/installreferrer/HuaweiInstallReferrerClient$request$2$connectionResult$1"}, k = 3, mv = {1, 4, 3})
                static final class co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.b.a extends r implements k {
                    final CancellableContinuation a;

                    public co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.b.a(CancellableContinuation cancellableContinuation0) {
                        this.a = cancellableContinuation0;
                        super(1);
                    }

                    public final void a(@NotNull IBinder iBinder0) {
                        Object object0;
                        Class class0 = ReferrerDetails.class;
                        String s = new co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.b(iBinder0).b();
                        ReferrerDetails referrerDetails0 = null;
                        try {
                            c c0 = c.b;
                            J j0 = I.a;
                            De.d d0 = j0.b(class0);
                            if(d0.equals(j0.b(Map.class))) {
                                Map map0 = b0.a(new JSONObject(s));
                                if(map0 != null) {
                                    referrerDetails0 = (ReferrerDetails)map0;
                                    goto label_34;
                                }
                                goto label_33;
                            }
                            else if(!d0.equals(j0.b(List.class))) {
                                JSONObject jSONObject0 = new JSONObject(s);
                                co.ab180.airbridge.internal.parser.a a0 = c0.a(class0);
                                if(a0 == null) {
                                    object0 = null;
                                }
                                else {
                                    y y0 = a0.b();
                                    object0 = y0 == null ? null : y0.a(jSONObject0);
                                }
                                if(!(object0 instanceof ReferrerDetails)) {
                                    object0 = null;
                                }
                                if(((ReferrerDetails)object0) == null) {
                                    goto label_33;
                                }
                                else {
                                    referrerDetails0 = (ReferrerDetails)object0;
                                }
                            }
                            else {
                                List list0 = b0.a(new JSONArray(s));
                                if(!(list0 instanceof ReferrerDetails)) {
                                    list0 = null;
                                }
                                if(((ReferrerDetails)list0) == null) {
                                    goto label_33;
                                }
                                else {
                                    referrerDetails0 = (ReferrerDetails)list0;
                                }
                            }
                            goto label_34;
                        }
                        catch(Throwable unused_ex) {
                        }
                    label_33:
                        co.ab180.airbridge.internal.b.e.b("Failed to parse JSON string into ReferrerDetails: jsonString={" + s + '}', new Object[0]);
                    label_34:
                        f.a(this.a, referrerDetails0);
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
                        co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.b.a a$b$a0 = new co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.b.a(cancellableContinuationImpl0);
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


        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/internal/thirdparty/huawei/installreferrer/ReferrerDetails;", "continuation", "", "request", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.HuaweiInstallReferrerClient", f = "HuaweiInstallReferrerClient.kt", l = {0x40}, m = "request")
        static final class co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.c extends oe.c {
            Object a;
            int b;
            final a c;
            Object d;

            public co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.c(a a0, Continuation continuation0) {
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

        co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.c a$c0;
        if(continuation0 instanceof co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.c) {
            a$c0 = (co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.c)continuation0;
            int v = a$c0.b;
            if((v & 0x80000000) == 0) {
                a$c0 = new co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.c(this, continuation0);
            }
            else {
                a$c0.b = v ^ 0x80000000;
            }
        }
        else {
            a$c0 = new co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a.c(this, continuation0);
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
        Intent intent0 = new Intent("com.huawei.android.hms.CHANNEL_SERVICE");
        intent0.setComponent(new ComponentName("com.huawei.hwid", "com.huawei.android.hms.ppskit.PpsChannelInfoService"));
        return intent0;
    }

    @Override  // co.ab180.airbridge.internal.d0.b.a.d
    @NotNull
    public String o() {
        return "com.huawei.hwid";
    }

    @Override  // co.ab180.airbridge.internal.d0.b.a.d
    @NotNull
    public String p() {
        return "Huawei/InstallReferrerClient";
    }

    @Override  // co.ab180.airbridge.internal.d0.b.a.d
    public boolean q() {
        PackageManager packageManager0 = this.m().getPackageManager();
        try {
            if(((long)packageManager0.getPackageInfo("com.huawei.hwid", 0x80).versionCode) >= 20605000L) {
                return true;
            }
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        return false;
    }
}

