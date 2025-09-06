package co.ab180.airbridge.internal.b0;

import android.content.Context;
import co.ab180.airbridge.AirbridgeOption;
import co.ab180.airbridge.BuildConfig;
import co.ab180.airbridge.common.AirbridgeTrackingBlocklist;
import co.ab180.airbridge.internal.b0.n.b;
import co.ab180.airbridge.internal.b0.n.d;
import co.ab180.airbridge.internal.z.f;
import d5.n;
import ie.H;
import ie.j;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import oe.c;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0005\u001A\u00020\u0004H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0007\u001A\u00020\u0004H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0015\u0010\u000B\u001A\u0004\u0018\u00010\rH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u000B\u0010\u0006J\u0015\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u000E\u0010\u0006J\u0015\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0010\u0010\u0006J\u000F\u0010\u0010\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0003J\u000F\u0010\u0011\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0003R\u001B\u0010\u0015\u001A\u00020\u00128BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\u000B\u0010\u0013\u001A\u0004\b\u0005\u0010\u0014R\u001B\u0010\u001A\u001A\u00020\u00168BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001A\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001D\u001A\u00020\u001B8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0010\u0010\u001CR\u0014\u0010!\u001A\u00020\u001E8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001F\u0010 R\u0014\u0010%\u001A\u00020\"8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\'\u001A\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u000E\u0010&R\u0018\u0010)\u001A\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b(\u0010&R\u0018\u0010+\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0005\u0010*R\u0014\u0010.\u001A\u00020,8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010-R\u0014\u00102\u001A\u00020/8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u00063"}, d2 = {"Lco/ab180/airbridge/internal/b0/l;", "Lco/ab180/airbridge/internal/b0/k;", "<init>", "()V", "Lie/H;", "h", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "Lco/ab180/airbridge/common/AirbridgeTrackingBlocklist;", "blocklist", "", "a", "(Lco/ab180/airbridge/common/AirbridgeTrackingBlocklist;)Z", "Lco/ab180/airbridge/internal/b0/m/d;", "f", "Lco/ab180/airbridge/internal/b0/a$a;", "c", "close", "Landroid/content/Context;", "Lie/j;", "()Landroid/content/Context;", "context", "Lco/ab180/airbridge/AirbridgeOption;", "b", "m", "()Lco/ab180/airbridge/AirbridgeOption;", "option", "Lco/ab180/airbridge/internal/b0/n/b;", "Lco/ab180/airbridge/internal/b0/n/b;", "googleRunner", "Lco/ab180/airbridge/internal/b0/n/d;", "d", "Lco/ab180/airbridge/internal/b0/n/d;", "huaweiRunner", "Lco/ab180/airbridge/internal/b0/a;", "e", "Lco/ab180/airbridge/internal/b0/a;", "appSetInfo", "Lco/ab180/airbridge/internal/b0/m/d;", "gaidInfo", "g", "oaidInfo", "Lco/ab180/airbridge/internal/b0/a$a;", "appSetIdInfo", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "needsToRefreshAdIdInfo", "Lkotlinx/coroutines/sync/Mutex;", "j", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class l implements k {
    private final j a;
    private final j b;
    private final b c;
    private final d d;
    private final a e;
    private co.ab180.airbridge.internal.b0.m.d f;
    private co.ab180.airbridge.internal.b0.m.d g;
    private co.ab180.airbridge.internal.b0.a.a h;
    private final AtomicBoolean i;
    private final Mutex j;

    public l() {
        this.a = f.b(Context.class);
        this.b = f.b(AirbridgeOption.class);
        this.c = new b(this.h());
        this.d = new d(this.h());
        this.e = new a();
        this.i = new AtomicBoolean(true);
        this.j = MutexKt.Mutex$default(false, 1, null);
    }

    private final boolean a(AirbridgeTrackingBlocklist airbridgeTrackingBlocklist0) {
        return this.m().getTrackingBlocklist().contains(airbridgeTrackingBlocklist0);
    }

    @Override  // co.ab180.airbridge.internal.b0.k
    @Nullable
    public Object a(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/internal/b0/m/d;", "continuation", "", "getGAIDInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.scrapper.UUIDProviderImpl", f = "UUIDProvider.kt", l = {49}, m = "getGAIDInfo")
        static final class co.ab180.airbridge.internal.b0.l.d extends c {
            Object a;
            int b;
            final l c;
            Object d;

            public co.ab180.airbridge.internal.b0.l.d(l l0, Continuation continuation0) {
                this.c = l0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(this);
            }
        }

        l l0;
        co.ab180.airbridge.internal.b0.l.d l$d0;
        if(continuation0 instanceof co.ab180.airbridge.internal.b0.l.d) {
            l$d0 = (co.ab180.airbridge.internal.b0.l.d)continuation0;
            int v = l$d0.b;
            if((v & 0x80000000) == 0) {
                l$d0 = new co.ab180.airbridge.internal.b0.l.d(this, continuation0);
            }
            else {
                l$d0.b = v ^ 0x80000000;
            }
        }
        else {
            l$d0 = new co.ab180.airbridge.internal.b0.l.d(this, continuation0);
        }
        Object object0 = l$d0.a;
        ne.a a0 = ne.a.a;
        switch(l$d0.b) {
            case 0: {
                n.D(object0);
                if(this.a(AirbridgeTrackingBlocklist.GAID)) {
                    return null;
                }
                l$d0.d = this;
                l$d0.b = 1;
                if(this.h(l$d0) == a0) {
                    return a0;
                }
                l0 = this;
                break;
            }
            case 1: {
                l0 = (l)l$d0.d;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        co.ab180.airbridge.internal.b0.m.d d0 = l0.f;
        if(d0 != null) {
            String s = d0.d();
            if(s != null) {
                co.ab180.airbridge.internal.b0.m.d d1 = l0.f;
                if(d1 != null) {
                    return new co.ab180.airbridge.internal.b0.m.d(s, d1.c());
                }
            }
        }
        return null;
    }

    @Override  // co.ab180.airbridge.internal.b0.k
    @Nullable
    public Object c(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/internal/b0/a$a;", "continuation", "", "getAppSetIdInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.scrapper.UUIDProviderImpl", f = "UUIDProvider.kt", l = {69}, m = "getAppSetIdInfo")
        static final class co.ab180.airbridge.internal.b0.l.c extends c {
            Object a;
            int b;
            final l c;
            Object d;

            public co.ab180.airbridge.internal.b0.l.c(l l0, Continuation continuation0) {
                this.c = l0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.c(this);
            }
        }

        co.ab180.airbridge.internal.b0.l.c l$c0;
        if(continuation0 instanceof co.ab180.airbridge.internal.b0.l.c) {
            l$c0 = (co.ab180.airbridge.internal.b0.l.c)continuation0;
            int v = l$c0.b;
            if((v & 0x80000000) == 0) {
                l$c0 = new co.ab180.airbridge.internal.b0.l.c(this, continuation0);
            }
            else {
                l$c0.b = v ^ 0x80000000;
            }
        }
        else {
            l$c0 = new co.ab180.airbridge.internal.b0.l.c(this, continuation0);
        }
        Object object0 = l$c0.a;
        ne.a a0 = ne.a.a;
        switch(l$c0.b) {
            case 0: {
                n.D(object0);
                if(this.a(AirbridgeTrackingBlocklist.APP_SET_ID)) {
                    return null;
                }
                l$c0.d = this;
                l$c0.b = 1;
                return this.h(l$c0) == a0 ? a0 : this.h;
            }
            case 1: {
                l l0 = (l)l$c0.d;
                n.D(object0);
                return l0.h;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // co.ab180.airbridge.internal.b0.k
    public void c() {
        this.i.set(true);
    }

    @Override
    public void close() {
        this.c.close();
        this.d.close();
    }

    @Override  // co.ab180.airbridge.internal.b0.k
    @Nullable
    public Object f(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/internal/b0/m/d;", "continuation", "", "getOAIDInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.scrapper.UUIDProviderImpl", f = "UUIDProvider.kt", l = {59}, m = "getOAIDInfo")
        static final class co.ab180.airbridge.internal.b0.l.e extends c {
            Object a;
            int b;
            final l c;
            Object d;

            public co.ab180.airbridge.internal.b0.l.e(l l0, Continuation continuation0) {
                this.c = l0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.f(this);
            }
        }

        l l0;
        co.ab180.airbridge.internal.b0.l.e l$e0;
        if(continuation0 instanceof co.ab180.airbridge.internal.b0.l.e) {
            l$e0 = (co.ab180.airbridge.internal.b0.l.e)continuation0;
            int v = l$e0.b;
            if((v & 0x80000000) == 0) {
                l$e0 = new co.ab180.airbridge.internal.b0.l.e(this, continuation0);
            }
            else {
                l$e0.b = v ^ 0x80000000;
            }
        }
        else {
            l$e0 = new co.ab180.airbridge.internal.b0.l.e(this, continuation0);
        }
        Object object0 = l$e0.a;
        ne.a a0 = ne.a.a;
        switch(l$e0.b) {
            case 0: {
                n.D(object0);
                if(this.a(AirbridgeTrackingBlocklist.OAID)) {
                    return null;
                }
                l$e0.d = this;
                l$e0.b = 1;
                if(this.h(l$e0) == a0) {
                    return a0;
                }
                l0 = this;
                break;
            }
            case 1: {
                l0 = (l)l$e0.d;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        co.ab180.airbridge.internal.b0.m.d d0 = l0.g;
        if(d0 != null) {
            String s = d0.d();
            if(s != null) {
                co.ab180.airbridge.internal.b0.m.d d1 = l0.g;
                if(d1 != null) {
                    return new co.ab180.airbridge.internal.b0.m.d(s, d1.c());
                }
            }
        }
        return null;
    }

    private final Context h() {
        return (Context)this.a.getValue();
    }

    private final Object h(Continuation continuation0) {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.scrapper.UUIDProviderImpl$appendAdIdInfo$2", f = "UUIDProvider.kt", l = {0x6F, 80}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.b0.l.a extends i implements we.n {
            Object a;
            int b;
            final l c;

            public co.ab180.airbridge.internal.b0.l.a(l l0, Continuation continuation0) {
                this.c = l0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.b0.l.a(this.c, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.b0.l.a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                Throwable throwable2;
                Mutex mutex2;
                Mutex mutex0;
                ne.a a0 = ne.a.a;
                switch(this.b) {
                    case 0: {
                        n.D(object0);
                        mutex0 = this.c.j;
                        this.a = mutex0;
                        this.b = 1;
                        if(mutex0.lock(null, this) == a0) {
                            return a0;
                        }
                        goto label_12;
                    }
                    case 1: {
                        Mutex mutex1 = (Mutex)this.a;
                        n.D(object0);
                        mutex0 = mutex1;
                        try {
                        label_12:
                            if(this.c.i.getAndSet(false)) {
                                goto label_16;
                            }
                            mutex2 = mutex0;
                            break;
                        }
                        catch(Throwable throwable0) {
                            mutex0.unlock(null);
                            throw throwable0;
                        }
                        try {
                        label_16:
                            this.a = mutex0;
                            this.b = 2;
                            if(this.c.i(this) == a0) {
                                return a0;
                            }
                        }
                        catch(Throwable throwable1) {
                            mutex2 = mutex0;
                            throwable2 = throwable1;
                            goto label_31;
                        }
                        mutex2 = mutex0;
                        break;
                    }
                    case 2: {
                        mutex2 = (Mutex)this.a;
                        try {
                            n.D(object0);
                            break;
                        }
                        catch(Throwable throwable2) {
                        }
                        try {
                        label_31:
                            co.ab180.airbridge.internal.b.e.e(throwable2, "Something went wrong while fetching ADID", new Object[0]);
                            break;
                        }
                        catch(Throwable throwable3) {
                            throwable0 = throwable3;
                            mutex0 = mutex2;
                        }
                        mutex0.unlock(null);
                        throw throwable0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                mutex2.unlock(null);
                return H.a;
            }
        }

        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new co.ab180.airbridge.internal.b0.l.a(this, null), continuation0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    private final Object i(Continuation continuation0) {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0082@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "Lie/H;", "continuation", "", "fetch", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.scrapper.UUIDProviderImpl", f = "UUIDProvider.kt", l = {93, 99, 100}, m = "fetch")
        static final class co.ab180.airbridge.internal.b0.l.b extends c {
            Object a;
            int b;
            final l c;
            Object d;
            Object e;

            public co.ab180.airbridge.internal.b0.l.b(l l0, Continuation continuation0) {
                this.c = l0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.i(this);
            }
        }

        l l4;
        l l3;
        l l2;
        l l1;
        l l0;
        co.ab180.airbridge.internal.b0.l.b l$b0;
        if(continuation0 instanceof co.ab180.airbridge.internal.b0.l.b) {
            l$b0 = (co.ab180.airbridge.internal.b0.l.b)continuation0;
            int v = l$b0.b;
            if((v & 0x80000000) == 0) {
                l$b0 = new co.ab180.airbridge.internal.b0.l.b(this, continuation0);
            }
            else {
                l$b0.b = v ^ 0x80000000;
            }
        }
        else {
            l$b0 = new co.ab180.airbridge.internal.b0.l.b(this, continuation0);
        }
        Object object0 = l$b0.a;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(l$b0.b) {
            case 0: {
                n.D(object0);
                Context context0 = this.h();
                l$b0.d = this;
                l$b0.e = this;
                l$b0.b = 1;
                object0 = this.e.a(context0, l$b0);
                if(object0 == a0) {
                    return a0;
                }
                l0 = this;
                l1 = l0;
                goto label_27;
            }
            case 1: {
                l0 = (l)l$b0.e;
                l1 = (l)l$b0.d;
                n.D(object0);
            label_27:
                l0.h = (co.ab180.airbridge.internal.b0.a.a)object0;
                if(BuildConfig.RESTRICTED.booleanValue()) {
                    return h0;
                }
                l$b0.d = l1;
                l$b0.e = l1;
                l$b0.b = 2;
                object0 = l1.c.d(l$b0);
                if(object0 == a0) {
                    return a0;
                }
                l2 = l1;
                l3 = l2;
                goto label_41;
            }
            case 2: {
                l2 = (l)l$b0.e;
                l3 = (l)l$b0.d;
                n.D(object0);
            label_41:
                l2.f = (co.ab180.airbridge.internal.b0.m.d)object0;
                l$b0.d = l3;
                l$b0.e = null;
                l$b0.b = 3;
                object0 = l3.d.d(l$b0);
                if(object0 == a0) {
                    return a0;
                }
                l4 = l3;
                break;
            }
            case 3: {
                l4 = (l)l$b0.d;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        l4.g = (co.ab180.airbridge.internal.b0.m.d)object0;
        return h0;
    }

    private final AirbridgeOption m() {
        return (AirbridgeOption)this.b.getValue();
    }
}

