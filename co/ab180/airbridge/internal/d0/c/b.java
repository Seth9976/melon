package co.ab180.airbridge.internal.d0.c;

import android.content.Context;
import android.net.Uri;
import co.ab180.airbridge.internal.e0.f;
import e1.u;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.TimeoutKt;
import oe.c;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001D\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lco/ab180/airbridge/internal/d0/c/b;", "", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class b {
    @NotNull
    public static final b a;

    static {
        b.a = new b();
    }

    @Nullable
    public final Object a(@NotNull Context context0, @NotNull Continuation continuation0) {
        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001A\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008A@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "co/ab180/airbridge/internal/e0/f$b", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.util.CoroutineUtilsKt$suspendCoroutineWithTimeout$2", f = "CoroutineUtils.kt", l = {24}, m = "invokeSuspend")
        public static final class a extends i implements n {
            Object a;
            Object b;
            int c;
            final H d;
            final Context e;

            public a(H h0, Continuation continuation0, Context context0) {
                this.d = h0;
                this.e = context0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new a(this.d, continuation0, this.e);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((a)this.create(object0, ((Continuation)object1))).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b¸\u0006\u0007"}, d2 = {"co/ab180/airbridge/internal/d0/c/b$a$a", "Lco/ab180/airbridge/internal/d0/c/c/a$b;", "Lco/ab180/airbridge/internal/d0/c/c/a;", "appLinkData", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/d0/c/c/a;)V", "co/ab180/airbridge/internal/thirdparty/facebook/FacebookSdkDelegate$getDeferredAppLink$2$1", "airbridge_release"}, k = 1, mv = {1, 4, 3})
                public static final class co.ab180.airbridge.internal.d0.c.b.a.a extends co.ab180.airbridge.internal.d0.c.c.a.b {
                    final CancellableContinuation b;

                    public co.ab180.airbridge.internal.d0.c.b.a.a(CancellableContinuation cancellableContinuation0) {
                        this.b = cancellableContinuation0;
                        super();
                    }

                    @Override  // co.ab180.airbridge.internal.d0.c.c.a$b
                    public void a(@Nullable co.ab180.airbridge.internal.d0.c.c.a a0) {
                        String s = null;
                        co.ab180.airbridge.internal.b.e.a("Facebook deferred app link data received: " + (a0 == null ? null : a0.c()), new Object[0]);
                        CancellableContinuation cancellableContinuation0 = this.b;
                        if(a0 != null) {
                            Uri uri0 = a0.c();
                            if(uri0 != null) {
                                s = uri0.toString();
                            }
                        }
                        f.a(cancellableContinuation0, s);
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
                        String s = this.e.getPackageManager().getApplicationInfo("com.iloen.melon", 0x80).metaData.getString("com.facebook.sdk.ApplicationId");
                        if(s == null || s.length() == 0) {
                            co.ab180.airbridge.internal.b.e.a("Facebook app id not defined in meta-data", new Object[0]);
                        }
                        else {
                            try {
                                if(!co.ab180.airbridge.internal.d0.c.a.c()) {
                                    co.ab180.airbridge.internal.d0.c.a.a(this.e);
                                }
                                co.ab180.airbridge.internal.d0.c.b.a.a b$a$a0 = new co.ab180.airbridge.internal.d0.c.b.a.a(cancellableContinuationImpl0);
                                co.ab180.airbridge.internal.d0.c.c.a.a(this.e, b$a$a0);
                                goto label_26;
                            }
                            catch(co.ab180.airbridge.internal.d0.b.b.a unused_ex) {
                            }
                            catch(Throwable throwable0) {
                                goto label_21;
                            }
                            co.ab180.airbridge.internal.b.e.a("Cannot find Facebook SDK", new Object[0]);
                            goto label_22;
                        label_21:
                            co.ab180.airbridge.internal.b.e.e(throwable0, "Something went wrong while getting Facebook deferred app link data", new Object[0]);
                        }
                    label_22:
                        f.a(cancellableContinuationImpl0, null);
                    label_26:
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
                        a b$a0 = (a)this.a;
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


        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001A\u00020\u00002\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/content/Context;", "context", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "getDeferredAppLink", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.thirdparty.facebook.FacebookSdkDelegate", f = "FacebookSdkDelegate.kt", l = {52}, m = "getDeferredAppLink")
        static final class co.ab180.airbridge.internal.d0.c.b.b extends c {
            Object a;
            int b;
            final b c;
            Object d;

            public co.ab180.airbridge.internal.d0.c.b.b(b b0, Continuation continuation0) {
                this.c = b0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(null, this);
            }
        }

        co.ab180.airbridge.internal.d0.c.b.b b$b0;
        if(continuation0 instanceof co.ab180.airbridge.internal.d0.c.b.b) {
            b$b0 = (co.ab180.airbridge.internal.d0.c.b.b)continuation0;
            int v = b$b0.b;
            if((v & 0x80000000) == 0) {
                b$b0 = new co.ab180.airbridge.internal.d0.c.b.b(this, continuation0);
            }
            else {
                b$b0.b = v ^ 0x80000000;
            }
        }
        else {
            b$b0 = new co.ab180.airbridge.internal.d0.c.b.b(this, continuation0);
        }
        Object object0 = b$b0.a;
        ne.a a0 = ne.a.a;
        switch(b$b0.b) {
            case 0: {
                H h0 = H0.b.p(object0);
                h0.a = null;
                a b$a0 = new a(h0, null, context0);
                b$b0.d = h0;
                b$b0.b = 1;
                return TimeoutKt.withTimeoutOrNull(3000L, b$a0, b$b0) == a0 ? a0 : h0.a;
            }
            case 1: {
                H h1 = (H)b$b0.d;
                d5.n.D(object0);
                return h1.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

