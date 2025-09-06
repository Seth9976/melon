package co.ab180.airbridge.internal.b0;

import android.content.Context;
import co.ab180.airbridge.internal.b0.n.a;
import co.ab180.airbridge.internal.b0.n.c;
import co.ab180.airbridge.internal.b0.n.e;
import co.ab180.airbridge.internal.b;
import co.ab180.airbridge.internal.z.f;
import ie.H;
import ie.j;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\n\u001A\u0004\u0018\u00010\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006J\u001F\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0003R\u001B\u0010\u0016\u001A\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000E\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001A\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u001D\u001A\u00020\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0014\u0010!\u001A\u00020\u001E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001F\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lco/ab180/airbridge/internal/b0/h;", "Lco/ab180/airbridge/internal/b0/g;", "<init>", "()V", "Lco/ab180/airbridge/internal/b0/m/b;", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lco/ab180/airbridge/internal/b0/m/c;", "g", "Lco/ab180/airbridge/internal/b0/m/a;", "e", "", "facebookAppId", "Lco/ab180/airbridge/internal/b0/m/e;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lie/H;", "close", "Landroid/content/Context;", "Lie/j;", "h", "()Landroid/content/Context;", "context", "Lco/ab180/airbridge/internal/b0/n/c;", "Lco/ab180/airbridge/internal/b0/n/c;", "googleRunner", "Lco/ab180/airbridge/internal/b0/n/e;", "c", "Lco/ab180/airbridge/internal/b0/n/e;", "huaweiRunner", "Lco/ab180/airbridge/internal/b0/n/a;", "d", "Lco/ab180/airbridge/internal/b0/n/a;", "galaxyStoreRunner", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class h implements g {
    private final j a;
    private final c b;
    private final e c;
    private final a d;

    public h() {
        this.a = f.b(Context.class);
        this.b = new c(this.h());
        this.c = new e(this.h());
        this.d = new a(this.h());
    }

    @Override  // co.ab180.airbridge.internal.b0.g
    @Nullable
    public Object a(@Nullable String s, @NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/b0/m/e;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.scrapper.InstallReferrerProviderImpl$getMetaInstallReferrer$2", f = "InstallReferrerProvider.kt", l = {60}, m = "invokeSuspend")
        static final class d extends i implements n {
            int a;
            final h b;
            final String c;

            public d(h h0, String s, Continuation continuation0) {
                this.b = h0;
                this.c = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new d(this.b, this.c, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((d)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.a) {
                    case 0: {
                        d5.n.D(object0);
                        co.ab180.airbridge.internal.b0.n.f f0 = new co.ab180.airbridge.internal.b0.n.f(this.b.h(), this.c);
                        this.a = 1;
                        object0 = f0.d(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(((co.ab180.airbridge.internal.b0.m.e)object0) != null) {
                    b.e.d("Meta install referrer received : " + ((co.ab180.airbridge.internal.b0.m.e)object0).g(), new Object[0]);
                    return (co.ab180.airbridge.internal.b0.m.e)object0;
                }
                return null;
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new d(this, s, null), continuation0);
    }

    @Override  // co.ab180.airbridge.internal.b0.g
    @Nullable
    public Object b(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/b0/m/b;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.scrapper.InstallReferrerProviderImpl$getGoogleInstallReferrer$2", f = "InstallReferrerProvider.kt", l = {0x20}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.b0.h.b extends i implements n {
            int a;
            final h b;

            public co.ab180.airbridge.internal.b0.h.b(h h0, Continuation continuation0) {
                this.b = h0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.b0.h.b(this.b, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.b0.h.b)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.a) {
                    case 0: {
                        d5.n.D(object0);
                        this.a = 1;
                        object0 = this.b.b.d(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(((co.ab180.airbridge.internal.b0.m.b)object0) != null) {
                    b.e.d("Google install referrer received : " + ((co.ab180.airbridge.internal.b0.m.b)object0).l(), new Object[0]);
                    return (co.ab180.airbridge.internal.b0.m.b)object0;
                }
                return null;
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new co.ab180.airbridge.internal.b0.h.b(this, null), continuation0);
    }

    @Override
    public void close() {
        this.b.close();
        this.c.close();
        this.d.close();
    }

    @Override  // co.ab180.airbridge.internal.b0.g
    @Nullable
    public Object e(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/b0/m/a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.scrapper.InstallReferrerProviderImpl$getGalaxyStoreInstallReferrer$2", f = "InstallReferrerProvider.kt", l = {53}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.b0.h.a extends i implements n {
            int a;
            final h b;

            public co.ab180.airbridge.internal.b0.h.a(h h0, Continuation continuation0) {
                this.b = h0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.b0.h.a(this.b, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.b0.h.a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.a) {
                    case 0: {
                        d5.n.D(object0);
                        this.a = 1;
                        object0 = this.b.d.d(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(((co.ab180.airbridge.internal.b0.m.a)object0) != null) {
                    b.e.d("Galaxy store install referrer received : " + ((co.ab180.airbridge.internal.b0.m.a)object0).e(), new Object[0]);
                    return (co.ab180.airbridge.internal.b0.m.a)object0;
                }
                return null;
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new co.ab180.airbridge.internal.b0.h.a(this, null), continuation0);
    }

    @Override  // co.ab180.airbridge.internal.b0.g
    @Nullable
    public Object g(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lco/ab180/airbridge/internal/b0/m/c;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.scrapper.InstallReferrerProviderImpl$getHuaweiInstallReferrer$2", f = "InstallReferrerProvider.kt", l = {46}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.b0.h.c extends i implements n {
            int a;
            final h b;

            public co.ab180.airbridge.internal.b0.h.c(h h0, Continuation continuation0) {
                this.b = h0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.b0.h.c(this.b, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.b0.h.c)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.a) {
                    case 0: {
                        d5.n.D(object0);
                        this.a = 1;
                        object0 = this.b.c.d(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(((co.ab180.airbridge.internal.b0.m.c)object0) != null) {
                    b.e.d("Huawei install referrer received : " + ((co.ab180.airbridge.internal.b0.m.c)object0).e(), new Object[0]);
                    return (co.ab180.airbridge.internal.b0.m.c)object0;
                }
                return null;
            }
        }

        return BuildersKt.withContext(Dispatchers.getIO(), new co.ab180.airbridge.internal.b0.h.c(this, null), continuation0);
    }

    private final Context h() {
        return (Context)this.a.getValue();
    }
}

