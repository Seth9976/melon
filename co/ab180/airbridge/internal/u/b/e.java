package co.ab180.airbridge.internal.u.b;

import co.ab180.airbridge.common.OnFailure;
import co.ab180.airbridge.common.OnSuccess;
import co.ab180.airbridge.common.ReferrerDetails;
import co.ab180.airbridge.internal.e0.p;
import d5.n;
import ie.H;
import ie.j;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.c;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0005\u001A\u00020\u00042\u000E\u0010\n\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FR\u001B\u0010\u0013\u001A\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001A\u0004\b\u0007\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lco/ab180/airbridge/internal/u/b/e;", "Lco/ab180/airbridge/internal/u/b/f;", "<init>", "()V", "", "vendor", "Lco/ab180/airbridge/common/ReferrerDetails;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lco/ab180/airbridge/common/OnSuccess;", "onSuccess", "Lco/ab180/airbridge/common/OnFailure;", "onFailure", "", "d", "(Ljava/lang/String;Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "Lco/ab180/airbridge/internal/b0/e;", "Lie/j;", "()Lco/ab180/airbridge/internal/b0/e;", "expandScrapper", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class e implements f {
    private final j a;

    public e() {
        this.a = co.ab180.airbridge.internal.z.f.b(co.ab180.airbridge.internal.b0.e.class);
    }

    private final co.ab180.airbridge.internal.b0.e a() {
        return (co.ab180.airbridge.internal.b0.e)this.a.getValue();
    }

    private final Object a(String s, Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001A\u00020\u00002\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0082@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "vendor", "Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/common/ReferrerDetails;", "continuation", "", "fetchInstallReferrerDetails", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.api.expand.ExpandApiInstallReferrerImpl", f = "ExpandApiInstallReferrerImpl.kt", l = {46, 0x2F, 49, 50}, m = "fetchInstallReferrerDetails")
        static final class b extends c {
            Object a;
            int b;
            final e c;

            public b(e e0, Continuation continuation0) {
                this.c = e0;
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

        b e$b0;
        if(continuation0 instanceof b) {
            e$b0 = (b)continuation0;
            int v = e$b0.b;
            if((v & 0x80000000) == 0) {
                e$b0 = new b(this, continuation0);
            }
            else {
                e$b0.b = v ^ 0x80000000;
            }
        }
        else {
            e$b0 = new b(this, continuation0);
        }
        Object object0 = e$b0.a;
        a a0 = a.a;
        switch(e$b0.b) {
            case 0: {
                n.D(object0);
                if(s == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                switch(s.toLowerCase()) {
                    case "galaxy_store": {
                        co.ab180.airbridge.internal.b0.e e3 = this.a();
                        e$b0.b = 3;
                        object0 = e3.c(e$b0);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case "google": {
                        co.ab180.airbridge.internal.b0.e e0 = this.a();
                        e$b0.b = 1;
                        object0 = e0.a(e$b0);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case "huawei": {
                        co.ab180.airbridge.internal.b0.e e1 = this.a();
                        e$b0.b = 2;
                        object0 = e1.d(e$b0);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case "meta": {
                        co.ab180.airbridge.internal.b0.e e2 = this.a();
                        e$b0.b = 4;
                        object0 = e2.b(e$b0);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("Not support vendor : " + s);
                    }
                }
                return (ReferrerDetails)object0;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                n.D(object0);
                return (ReferrerDetails)object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // co.ab180.airbridge.internal.u.b.f
    public boolean d(@NotNull String s, @NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.api.expand.ExpandApiInstallReferrerImpl$fetchInstallReferrerDetails$1", f = "ExpandApiInstallReferrerImpl.kt", l = {29}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.u.b.e.a extends i implements we.n {
            private Object a;
            int b;
            final e c;
            final String d;
            final OnFailure e;
            final OnSuccess f;

            public co.ab180.airbridge.internal.u.b.e.a(e e0, String s, OnFailure onFailure0, OnSuccess onSuccess0, Continuation continuation0) {
                this.c = e0;
                this.d = s;
                this.e = onFailure0;
                this.f = onSuccess0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                Continuation continuation1 = new co.ab180.airbridge.internal.u.b.e.a(this.c, this.d, this.e, this.f, continuation0);
                continuation1.a = object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.u.b.e.a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                ReferrerDetails referrerDetails1;
                Throwable throwable1;
                CoroutineScope coroutineScope1;
                Object object1;
                a a0 = a.a;
                H h0 = H.a;
                switch(this.b) {
                    case 0: {
                        n.D(object0);
                        CoroutineScope coroutineScope0 = (CoroutineScope)this.a;
                        try {
                            this.a = coroutineScope0;
                            this.b = 1;
                            object1 = this.c.a(this.d, this);
                        }
                        catch(Throwable throwable0) {
                            coroutineScope1 = coroutineScope0;
                            throwable1 = throwable0;
                            break;
                        }
                        if(object1 == a0) {
                            return a0;
                        }
                        coroutineScope1 = coroutineScope0;
                        object0 = object1;
                        goto label_21;
                    }
                    case 1: {
                        coroutineScope1 = (CoroutineScope)this.a;
                        try {
                            n.D(object0);
                        label_21:
                            ReferrerDetails referrerDetails0 = (ReferrerDetails)object0;
                            co.ab180.airbridge.internal.b.e.a("InstallReferrerInterface(" + p.a(coroutineScope1) + ")#fetchInstallReferrerDetails: result={" + coroutineScope1 + '}', new Object[0]);
                            referrerDetails1 = (ReferrerDetails)object0;
                            goto label_31;
                        }
                        catch(Throwable throwable1) {
                        }
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                co.ab180.airbridge.internal.b.e.a("InstallReferrerInterface(" + p.a(coroutineScope1) + ")#fetchInstallReferrerDetails: throwable={" + throwable1 + '}', new Object[0]);
                OnFailure onFailure0 = this.e;
                if(onFailure0 != null) {
                    onFailure0.invoke(throwable1);
                }
                return h0;
            label_31:
                this.f.invoke(referrerDetails1);
                return h0;
            }
        }

        co.ab180.airbridge.internal.b.e.d("InstallReferrerInterface(" + p.a(this) + ")#fetchInstallReferrerDetails: vendor={" + s + '}', new Object[0]);
        co.ab180.airbridge.internal.u.b.e.a e$a0 = new co.ab180.airbridge.internal.u.b.e.a(this, s, onFailure0, onSuccess0, null);
        BuildersKt__Builders_commonKt.launch$default(() -> me.j.a, Dispatchers.getMain(), null, e$a0, 2, null);
        return true;
    }
}

