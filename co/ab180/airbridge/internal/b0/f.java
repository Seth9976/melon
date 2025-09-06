package co.ab180.airbridge.internal.b0;

import android.content.Context;
import co.ab180.airbridge.AirbridgeOption;
import co.ab180.airbridge.common.AdvertisingIdInfo;
import co.ab180.airbridge.common.ReferrerDetails;
import co.ab180.airbridge.internal.b0.m.b;
import d5.n;
import d8.d;
import ie.j;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001A\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001A\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001A\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006J\u0013\u0010\u000B\u001A\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000B\u0010\u0006J\u0013\u0010\f\u001A\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006R\u001B\u0010\u0010\u001A\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u000E\u001A\u0004\b\u0005\u0010\u000FR\u001B\u0010\u0013\u001A\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u000E\u001A\u0004\b\t\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lco/ab180/airbridge/internal/b0/f;", "Lco/ab180/airbridge/internal/b0/e;", "<init>", "()V", "Lco/ab180/airbridge/common/ReferrerDetails;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "c", "b", "Lco/ab180/airbridge/common/AdvertisingIdInfo;", "f", "e", "Landroid/content/Context;", "Lie/j;", "()Landroid/content/Context;", "context", "Lco/ab180/airbridge/AirbridgeOption;", "()Lco/ab180/airbridge/AirbridgeOption;", "option", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class f implements e {
    private final j a;
    private final j b;

    public f() {
        this.a = co.ab180.airbridge.internal.z.f.b(Context.class);
        this.b = co.ab180.airbridge.internal.z.f.b(AirbridgeOption.class);
    }

    private final Context a() {
        return (Context)this.a.getValue();
    }

    @Override  // co.ab180.airbridge.internal.b0.e
    @Nullable
    public Object a(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/common/ReferrerDetails;", "continuation", "", "fetchGoogleInstallReferrerDetails", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.scrapper.ExpandScrapperImpl", f = "ExpandScrapper.kt", l = {34}, m = "fetchGoogleInstallReferrerDetails")
        static final class c extends oe.c {
            Object a;
            int b;
            final f c;
            Object d;
            Object e;

            public c(f f0, Continuation continuation0) {
                this.c = f0;
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

        b b0;
        Throwable throwable1;
        Closeable closeable0;
        c f$c0;
        if(continuation0 instanceof c) {
            f$c0 = (c)continuation0;
            int v = f$c0.b;
            if((v & 0x80000000) == 0) {
                f$c0 = new c(this, continuation0);
            }
            else {
                f$c0.b = v ^ 0x80000000;
            }
        }
        else {
            f$c0 = new c(this, continuation0);
        }
        Object object0 = f$c0.a;
        a a0 = a.a;
        switch(f$c0.b) {
            case 0: {
                n.D(object0);
                closeable0 = new co.ab180.airbridge.internal.b0.n.c(this.a());
                try {
                    f$c0.d = closeable0;
                    f$c0.e = null;
                    f$c0.b = 1;
                    object0 = ((co.ab180.airbridge.internal.b0.n.c)closeable0).d(f$c0);
                    if(object0 == a0) {
                        return a0;
                    }
                    throwable1 = null;
                    b0 = (b)object0;
                    goto label_31;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 1: {
                throwable1 = (Throwable)f$c0.e;
                closeable0 = (Closeable)f$c0.d;
                try {
                    n.D(object0);
                    b0 = (b)object0;
                    goto label_31;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d.l(closeable0, throwable0);
        throw throwable0;
    label_31:
        d.l(closeable0, throwable1);
        return b0 != null ? new ReferrerDetails(b0.l(), b0.m(), b0.i()) : null;
    }

    private final AirbridgeOption b() {
        return (AirbridgeOption)this.b.getValue();
    }

    @Override  // co.ab180.airbridge.internal.b0.e
    @Nullable
    public Object b(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/common/ReferrerDetails;", "continuation", "", "fetchMetaInstallReferrerDetails", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.scrapper.ExpandScrapperImpl", f = "ExpandScrapper.kt", l = {78}, m = "fetchMetaInstallReferrerDetails")
        static final class co.ab180.airbridge.internal.b0.f.f extends oe.c {
            Object a;
            int b;
            final f c;
            Object d;
            Object e;

            public co.ab180.airbridge.internal.b0.f.f(f f0, Continuation continuation0) {
                this.c = f0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.b(this);
            }
        }

        co.ab180.airbridge.internal.b0.m.e e0;
        Throwable throwable1;
        Closeable closeable0;
        co.ab180.airbridge.internal.b0.f.f f$f0;
        if(continuation0 instanceof co.ab180.airbridge.internal.b0.f.f) {
            f$f0 = (co.ab180.airbridge.internal.b0.f.f)continuation0;
            int v = f$f0.b;
            if((v & 0x80000000) == 0) {
                f$f0 = new co.ab180.airbridge.internal.b0.f.f(this, continuation0);
            }
            else {
                f$f0.b = v ^ 0x80000000;
            }
        }
        else {
            f$f0 = new co.ab180.airbridge.internal.b0.f.f(this, continuation0);
        }
        Object object0 = f$f0.a;
        a a0 = a.a;
        switch(f$f0.b) {
            case 0: {
                n.D(object0);
                closeable0 = new co.ab180.airbridge.internal.b0.n.f(this.a(), this.b().getFacebookAppId());
                try {
                    f$f0.d = closeable0;
                    f$f0.e = null;
                    f$f0.b = 1;
                    object0 = ((co.ab180.airbridge.internal.b0.n.f)closeable0).d(f$f0);
                    if(object0 == a0) {
                        return a0;
                    }
                    throwable1 = null;
                    e0 = (co.ab180.airbridge.internal.b0.m.e)object0;
                    goto label_31;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 1: {
                throwable1 = (Throwable)f$f0.e;
                closeable0 = (Closeable)f$f0.d;
                try {
                    n.D(object0);
                    e0 = (co.ab180.airbridge.internal.b0.m.e)object0;
                    goto label_31;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d.l(closeable0, throwable0);
        throw throwable0;
    label_31:
        d.l(closeable0, throwable1);
        if(e0 != null) {
            if(e0.f() != null) {
                throw new Exception(e0.f());
            }
            String s = e0.g() == null ? "" : e0.g();
            Long long0 = e0.e();
            long v1 = 0L;
            long v2 = long0 == null ? 0L : ((long)long0);
            Long long1 = e0.e();
            if(long1 != null) {
                v1 = (long)long1;
            }
            return new ReferrerDetails(s, v2, v1);
        }
        return null;
    }

    @Override  // co.ab180.airbridge.internal.b0.e
    @Nullable
    public Object c(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/common/ReferrerDetails;", "continuation", "", "fetchGalaxyStoreInstallReferrerDetails", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.scrapper.ExpandScrapperImpl", f = "ExpandScrapper.kt", l = {67}, m = "fetchGalaxyStoreInstallReferrerDetails")
        static final class co.ab180.airbridge.internal.b0.f.a extends oe.c {
            Object a;
            int b;
            final f c;
            Object d;
            Object e;

            public co.ab180.airbridge.internal.b0.f.a(f f0, Continuation continuation0) {
                this.c = f0;
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

        co.ab180.airbridge.internal.b0.m.a a1;
        Throwable throwable1;
        Closeable closeable0;
        co.ab180.airbridge.internal.b0.f.a f$a0;
        if(continuation0 instanceof co.ab180.airbridge.internal.b0.f.a) {
            f$a0 = (co.ab180.airbridge.internal.b0.f.a)continuation0;
            int v = f$a0.b;
            if((v & 0x80000000) == 0) {
                f$a0 = new co.ab180.airbridge.internal.b0.f.a(this, continuation0);
            }
            else {
                f$a0.b = v ^ 0x80000000;
            }
        }
        else {
            f$a0 = new co.ab180.airbridge.internal.b0.f.a(this, continuation0);
        }
        Object object0 = f$a0.a;
        a a0 = a.a;
        switch(f$a0.b) {
            case 0: {
                n.D(object0);
                closeable0 = new co.ab180.airbridge.internal.b0.n.a(this.a());
                try {
                    f$a0.d = closeable0;
                    f$a0.e = null;
                    f$a0.b = 1;
                    object0 = ((co.ab180.airbridge.internal.b0.n.a)closeable0).d(f$a0);
                    if(object0 == a0) {
                        return a0;
                    }
                    throwable1 = null;
                    a1 = (co.ab180.airbridge.internal.b0.m.a)object0;
                    goto label_31;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 1: {
                throwable1 = (Throwable)f$a0.e;
                closeable0 = (Closeable)f$a0.d;
                try {
                    n.D(object0);
                    a1 = (co.ab180.airbridge.internal.b0.m.a)object0;
                    goto label_31;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d.l(closeable0, throwable0);
        throw throwable0;
    label_31:
        d.l(closeable0, throwable1);
        return a1 != null ? new ReferrerDetails(a1.e(), a1.f(), a1.d()) : null;
    }

    @Override  // co.ab180.airbridge.internal.b0.e
    @Nullable
    public Object d(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\u000E\u0010\u0002\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/common/ReferrerDetails;", "continuation", "", "fetchHuaweiInstallReferrerDetails", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.scrapper.ExpandScrapperImpl", f = "ExpandScrapper.kt", l = {45}, m = "fetchHuaweiInstallReferrerDetails")
        static final class co.ab180.airbridge.internal.b0.f.e extends oe.c {
            Object a;
            int b;
            final f c;
            Object d;
            Object e;

            public co.ab180.airbridge.internal.b0.f.e(f f0, Continuation continuation0) {
                this.c = f0;
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

        co.ab180.airbridge.internal.b0.m.c c0;
        Throwable throwable1;
        Closeable closeable0;
        co.ab180.airbridge.internal.b0.f.e f$e0;
        if(continuation0 instanceof co.ab180.airbridge.internal.b0.f.e) {
            f$e0 = (co.ab180.airbridge.internal.b0.f.e)continuation0;
            int v = f$e0.b;
            if((v & 0x80000000) == 0) {
                f$e0 = new co.ab180.airbridge.internal.b0.f.e(this, continuation0);
            }
            else {
                f$e0.b = v ^ 0x80000000;
            }
        }
        else {
            f$e0 = new co.ab180.airbridge.internal.b0.f.e(this, continuation0);
        }
        Object object0 = f$e0.a;
        a a0 = a.a;
        switch(f$e0.b) {
            case 0: {
                n.D(object0);
                closeable0 = new co.ab180.airbridge.internal.b0.n.e(this.a());
                try {
                    f$e0.d = closeable0;
                    f$e0.e = null;
                    f$e0.b = 1;
                    object0 = ((co.ab180.airbridge.internal.b0.n.e)closeable0).d(f$e0);
                    if(object0 == a0) {
                        return a0;
                    }
                    throwable1 = null;
                    c0 = (co.ab180.airbridge.internal.b0.m.c)object0;
                    goto label_31;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 1: {
                throwable1 = (Throwable)f$e0.e;
                closeable0 = (Closeable)f$e0.d;
                try {
                    n.D(object0);
                    c0 = (co.ab180.airbridge.internal.b0.m.c)object0;
                    goto label_31;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d.l(closeable0, throwable0);
        throw throwable0;
    label_31:
        d.l(closeable0, throwable1);
        return c0 != null ? new ReferrerDetails(c0.e(), c0.f(), c0.d()) : null;
    }

    @Override  // co.ab180.airbridge.internal.b0.e
    @Nullable
    public Object e(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/common/AdvertisingIdInfo;", "continuation", "", "fetchHuaweiAdvertisingIdInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.scrapper.ExpandScrapperImpl", f = "ExpandScrapper.kt", l = {103}, m = "fetchHuaweiAdvertisingIdInfo")
        static final class co.ab180.airbridge.internal.b0.f.d extends oe.c {
            Object a;
            int b;
            final f c;
            Object d;
            Object e;

            public co.ab180.airbridge.internal.b0.f.d(f f0, Continuation continuation0) {
                this.c = f0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.e(this);
            }
        }

        String s;
        co.ab180.airbridge.internal.b0.m.d d1;
        Throwable throwable2;
        Throwable throwable1;
        Closeable closeable0;
        Object object1;
        co.ab180.airbridge.internal.b0.f.d f$d0;
        if(continuation0 instanceof co.ab180.airbridge.internal.b0.f.d) {
            f$d0 = (co.ab180.airbridge.internal.b0.f.d)continuation0;
            int v = f$d0.b;
            if((v & 0x80000000) == 0) {
                f$d0 = new co.ab180.airbridge.internal.b0.f.d(this, continuation0);
            }
            else {
                f$d0.b = v ^ 0x80000000;
            }
        }
        else {
            f$d0 = new co.ab180.airbridge.internal.b0.f.d(this, continuation0);
        }
        Object object0 = f$d0.a;
        a a0 = a.a;
        switch(f$d0.b) {
            case 0: {
                n.D(object0);
                co.ab180.airbridge.internal.b0.n.d d0 = new co.ab180.airbridge.internal.b0.n.d(this.a());
                try {
                    f$d0.d = d0;
                    f$d0.e = null;
                    f$d0.b = 1;
                    object1 = d0.d(f$d0);
                }
                catch(Throwable throwable0) {
                    closeable0 = d0;
                    throwable1 = throwable0;
                    break;
                }
                if(object1 == a0) {
                    return a0;
                }
                closeable0 = d0;
                object0 = object1;
                throwable2 = null;
                d1 = (co.ab180.airbridge.internal.b0.m.d)object0;
                goto label_40;
            }
            case 1: {
                throwable2 = (Throwable)f$d0.e;
                closeable0 = (Closeable)f$d0.d;
                try {
                    n.D(object0);
                    d1 = (co.ab180.airbridge.internal.b0.m.d)object0;
                    goto label_40;
                }
                catch(Throwable throwable1) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            throw throwable1;
        }
        catch(Throwable throwable3) {
            d.l(closeable0, throwable1);
            throw throwable3;
        }
    label_40:
        d.l(closeable0, throwable2);
        if(d1 == null) {
            s = "";
        }
        else {
            s = d1.d();
            if(s == null) {
                return d1 == null ? new AdvertisingIdInfo("", false) : new AdvertisingIdInfo("", d1.c());
            }
        }
        return d1 == null ? new AdvertisingIdInfo(s, false) : new AdvertisingIdInfo(s, d1.c());
    }

    @Override  // co.ab180.airbridge.internal.b0.e
    @Nullable
    public Object f(@NotNull Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/coroutines/Continuation;", "Lco/ab180/airbridge/common/AdvertisingIdInfo;", "continuation", "", "fetchGoogleAdvertisingIdInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.scrapper.ExpandScrapperImpl", f = "ExpandScrapper.kt", l = {93}, m = "fetchGoogleAdvertisingIdInfo")
        static final class co.ab180.airbridge.internal.b0.f.b extends oe.c {
            Object a;
            int b;
            final f c;
            Object d;
            Object e;

            public co.ab180.airbridge.internal.b0.f.b(f f0, Continuation continuation0) {
                this.c = f0;
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

        String s;
        co.ab180.airbridge.internal.b0.m.d d0;
        Throwable throwable2;
        Throwable throwable1;
        Closeable closeable0;
        Object object1;
        co.ab180.airbridge.internal.b0.f.b f$b0;
        if(continuation0 instanceof co.ab180.airbridge.internal.b0.f.b) {
            f$b0 = (co.ab180.airbridge.internal.b0.f.b)continuation0;
            int v = f$b0.b;
            if((v & 0x80000000) == 0) {
                f$b0 = new co.ab180.airbridge.internal.b0.f.b(this, continuation0);
            }
            else {
                f$b0.b = v ^ 0x80000000;
            }
        }
        else {
            f$b0 = new co.ab180.airbridge.internal.b0.f.b(this, continuation0);
        }
        Object object0 = f$b0.a;
        a a0 = a.a;
        switch(f$b0.b) {
            case 0: {
                n.D(object0);
                co.ab180.airbridge.internal.b0.n.b b0 = new co.ab180.airbridge.internal.b0.n.b(this.a());
                try {
                    f$b0.d = b0;
                    f$b0.e = null;
                    f$b0.b = 1;
                    object1 = b0.d(f$b0);
                }
                catch(Throwable throwable0) {
                    closeable0 = b0;
                    throwable1 = throwable0;
                    break;
                }
                if(object1 == a0) {
                    return a0;
                }
                closeable0 = b0;
                object0 = object1;
                throwable2 = null;
                d0 = (co.ab180.airbridge.internal.b0.m.d)object0;
                goto label_40;
            }
            case 1: {
                throwable2 = (Throwable)f$b0.e;
                closeable0 = (Closeable)f$b0.d;
                try {
                    n.D(object0);
                    d0 = (co.ab180.airbridge.internal.b0.m.d)object0;
                    goto label_40;
                }
                catch(Throwable throwable1) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            throw throwable1;
        }
        catch(Throwable throwable3) {
            d.l(closeable0, throwable1);
            throw throwable3;
        }
    label_40:
        d.l(closeable0, throwable2);
        if(d0 == null) {
            s = "";
        }
        else {
            s = d0.d();
            if(s == null) {
                return d0 == null ? new AdvertisingIdInfo("", false) : new AdvertisingIdInfo("", d0.c());
            }
        }
        return d0 == null ? new AdvertisingIdInfo(s, false) : new AdvertisingIdInfo(s, d0.c());
    }
}

