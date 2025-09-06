package co.ab180.airbridge.internal.b0.n;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import co.ab180.airbridge.internal.d0.b.a.d;
import co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.ReferrerDetails;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.n;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001A\u0004\u0018\u00010\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001A\u0004\u0018\u00010\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001A\u0004\u0018\u00010\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\bJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rR\u001A\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0016\u001A\n \u0013*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lco/ab180/airbridge/internal/b0/n/e;", "Lco/ab180/airbridge/internal/b0/n/h;", "Lco/ab180/airbridge/internal/b0/m/c;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "h", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "d", "Lie/H;", "close", "()V", "Lco/ab180/airbridge/internal/b0/n/i;", "Lco/ab180/airbridge/internal/thirdparty/huawei/installreferrer/ReferrerDetails;", "a", "Lco/ab180/airbridge/internal/b0/n/i;", "huaweiServiceClientRunner", "kotlin.jvm.PlatformType", "b", "Landroid/content/Context;", "appContext", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class e implements h {
    private final i a;
    private final Context b;

    public e(@NotNull Context context0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lco/ab180/airbridge/internal/d0/b/a/d;", "Lco/ab180/airbridge/internal/thirdparty/huawei/installreferrer/ReferrerDetails;", "a", "()Lco/ab180/airbridge/internal/d0/b/a/d;"}, k = 3, mv = {1, 4, 3})
        static final class c extends r implements a {
            final Context a;

            public c(Context context0) {
                this.a = context0;
                super(0);
            }

            @NotNull
            public final d a() {
                return new co.ab180.airbridge.internal.thirdparty.huawei.installreferrer.a(this.a);
            }

            @Override  // we.a
            public Object invoke() {
                return this.a();
            }
        }

        this.a = new i(new c(context0));
        this.b = context0.getApplicationContext();
    }

    @Override  // co.ab180.airbridge.internal.b0.n.h
    public void close() {
        this.a.a();
    }

    @Override  // co.ab180.airbridge.internal.b0.n.h
    @Nullable
    public Object d(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/b0/m/c;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.scrapper.runner.HuaweiInstallReferrerRunner$request$2", f = "HuaweiInstallReferrerRunner.kt", l = {61, 62}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.b0.n.e.d extends oe.i implements n {
            int a;
            final e b;

            public co.ab180.airbridge.internal.b0.n.e.d(e e0, Continuation continuation0) {
                this.b = e0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.b0.n.e.d(this.b, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.b0.n.e.d)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.a) {
                    case 0: {
                        d5.n.D(object0);
                        this.a = 1;
                        object0 = this.b.h(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    case 2: {
                        d5.n.D(object0);
                        return (co.ab180.airbridge.internal.b0.m.c)object0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(((co.ab180.airbridge.internal.b0.m.c)object0) != null) {
                    return (co.ab180.airbridge.internal.b0.m.c)object0;
                }
                this.a = 2;
                object0 = this.b.i(this);
                return object0 == a0 ? a0 : ((co.ab180.airbridge.internal.b0.m.c)object0);
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new co.ab180.airbridge.internal.b0.n.e.d(this, null), continuation0);
    }

    private final Object h(Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/b0/m/c;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.scrapper.runner.HuaweiInstallReferrerRunner$getHuaweiInstallReferrerByAIDL$2", f = "HuaweiInstallReferrerRunner.kt", l = {21}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.b0.n.e.a extends oe.i implements n {
            int a;
            final e b;

            public co.ab180.airbridge.internal.b0.n.e.a(e e0, Continuation continuation0) {
                this.b = e0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.b0.n.e.a(this.b, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.b0.n.e.a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.a) {
                    case 0: {
                        d5.n.D(object0);
                        try {
                            this.a = 1;
                            object0 = this.b.a.a(this);
                            if(object0 == a0) {
                                return a0;
                            label_8:
                                d5.n.D(object0);
                            }
                            if(((ReferrerDetails)object0) != null) {
                                long v = 0L;
                                String s = ((ReferrerDetails)object0).getInstallReferrer();
                                if(s != null) {
                                    long v1 = ((ReferrerDetails)object0).getReferrerClickTimestampMillis() == null ? 0L : ((long)((ReferrerDetails)object0).getReferrerClickTimestampMillis()) / 1000L;
                                    if(((ReferrerDetails)object0).getInstallBeginTimestampMillis() != null) {
                                        v = ((long)((ReferrerDetails)object0).getInstallBeginTimestampMillis()) / 1000L;
                                    }
                                    return new co.ab180.airbridge.internal.b0.m.c(s, v1, v);
                                }
                            }
                        }
                        catch(Exception unused_ex) {
                        }
                        return null;
                    }
                    case 1: {
                        goto label_8;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new co.ab180.airbridge.internal.b0.n.e.a(this, null), continuation0);
    }

    private final Object i(Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/b0/m/c;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.scrapper.runner.HuaweiInstallReferrerRunner$getHuaweiInstallReferrerByContentResolver$2", f = "HuaweiInstallReferrerRunner.kt", l = {}, m = "invokeSuspend")
        static final class b extends oe.i implements n {
            int a;
            final e b;

            public b(e e0, Continuation continuation0) {
                this.b = e0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new b(this.b, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((b)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                co.ab180.airbridge.internal.b0.m.c c0;
                if(this.a != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Uri uri0 = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
                try {
                    Cursor cursor0 = this.b.b.getContentResolver().query(uri0, null, null, new String[]{"com.iloen.melon"}, null);
                    if(cursor0 != null) {
                        try {
                            cursor0.moveToFirst();
                            String s = cursor0.getString(0);
                            String s1 = cursor0.getString(1);
                            long v = 0L;
                            long v1 = s1 == null ? 0L : ((long)new Long(Long.parseLong(s1)));
                            String s2 = cursor0.getString(2);
                            if(s2 != null) {
                                v = (long)new Long(Long.parseLong(s2));
                            }
                            c0 = new co.ab180.airbridge.internal.b0.m.c(s, v1, v);
                        }
                        catch(Throwable throwable0) {
                            d8.d.l(cursor0, throwable0);
                            throw throwable0;
                        }
                        cursor0.close();
                        return c0;
                    }
                }
                catch(Exception unused_ex) {
                }
                return null;
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new b(this, null), continuation0);
    }
}

