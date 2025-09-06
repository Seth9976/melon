package co.ab180.airbridge.internal.lifecycle;

import android.content.Context;
import co.ab180.airbridge.AirbridgeOption;
import co.ab180.airbridge.internal.e0.j0;
import co.ab180.airbridge.internal.e0.k0;
import co.ab180.airbridge.internal.e0.l;
import co.ab180.airbridge.internal.e0.p;
import co.ab180.airbridge.internal.network.model.c;
import co.ab180.airbridge.internal.o;
import co.ab180.airbridge.internal.x.b;
import d5.n;
import ie.H;
import ie.m;
import java.io.Closeable;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import je.C;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Job;
import ne.a;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u000F\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u0010\u0010\u000EJ%\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u001B\u0010\u0019\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\u0017H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001B\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\u0017H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u0015\u0010\u001AJ\u0017\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\u0017H\u0002\u00A2\u0006\u0004\b\u0015\u0010\u001BJ\u0017\u0010\u0019\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\u0017H\u0002\u00A2\u0006\u0004\b\u0019\u0010\u001BJ/\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\u00172\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u001CH\u0002\u00A2\u0006\u0004\b\u0015\u0010\u001EJO\u0010\u0015\u001A\u00020\u001C2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0018\u001A\u00020\u00172\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010\u00132\b\b\u0002\u0010!\u001A\u00020 2\u0018\b\u0002\u0010$\u001A\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"H\u0002\u00A2\u0006\u0004\b\u0015\u0010%J\r\u0010\'\u001A\u00020&\u00A2\u0006\u0004\b\'\u0010(J\r\u0010)\u001A\u00020 \u00A2\u0006\u0004\b)\u0010*J\r\u0010\u0015\u001A\u00020\f\u00A2\u0006\u0004\b\u0015\u0010\u000EJ\r\u0010\u0019\u001A\u00020\f\u00A2\u0006\u0004\b\u0019\u0010\u000EJ\u000F\u0010+\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b+\u0010\u000ER\u0018\u0010.\u001A\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0015\u0010-R\u0018\u00100\u001A\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0019\u0010/R\u0014\u00104\u001A\u0002018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001A\u0002058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001A\u0002098\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001A\u00020&8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010A\u001A\u0002098\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b@\u0010;R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\r\u0010BR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bG\u0010H\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006I"}, d2 = {"Lco/ab180/airbridge/internal/lifecycle/i;", "Ljava/io/Closeable;", "Landroid/content/Context;", "context", "Lco/ab180/airbridge/AirbridgeOption;", "option", "Lco/ab180/airbridge/internal/o;", "repository", "Lco/ab180/airbridge/internal/lifecycle/j;", "onTrackLifeCycleEvent", "<init>", "(Landroid/content/Context;Lco/ab180/airbridge/AirbridgeOption;Lco/ab180/airbridge/internal/o;Lco/ab180/airbridge/internal/lifecycle/j;)V", "Lie/H;", "h", "()V", "p", "q", "Lco/ab180/airbridge/internal/network/model/c;", "eventType", "", "dataString", "a", "(Lco/ab180/airbridge/internal/network/model/c;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lco/ab180/airbridge/internal/lifecycle/c;", "lifecycleContext", "b", "(Lco/ab180/airbridge/internal/lifecycle/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lco/ab180/airbridge/internal/lifecycle/c;)V", "Lco/ab180/airbridge/internal/w/b;", "eventSeed", "(Lco/ab180/airbridge/internal/lifecycle/c;Lco/ab180/airbridge/internal/network/model/c;Lco/ab180/airbridge/internal/w/b;)V", "deeplink", "", "chkInstallReferrer", "", "", "sdkAttributes", "(Lco/ab180/airbridge/internal/network/model/c;Lco/ab180/airbridge/internal/lifecycle/c;Ljava/lang/String;ZLjava/util/Map;)Lco/ab180/airbridge/internal/w/b;", "Lco/ab180/airbridge/internal/lifecycle/b$b;", "m", "()Lco/ab180/airbridge/internal/lifecycle/b$b;", "o", "()Z", "close", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "deferredDeepLinkJob", "Ljava/lang/String;", "deferredDeepLink", "Lco/ab180/airbridge/internal/x/b;", "c", "Lco/ab180/airbridge/internal/x/b;", "deferredDeeplinkgWorker", "Lco/ab180/airbridge/internal/e0/j0;", "d", "Lco/ab180/airbridge/internal/e0/j0;", "urlLinkHandler", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "trackingStarted", "f", "Lco/ab180/airbridge/internal/lifecycle/b$b;", "lastSavedLifecycleType", "g", "trackingSuspendByLifecycle", "Landroid/content/Context;", "i", "Lco/ab180/airbridge/AirbridgeOption;", "j", "Lco/ab180/airbridge/internal/o;", "k", "Lco/ab180/airbridge/internal/lifecycle/j;", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class i implements Closeable {
    private Job a;
    private String b;
    private final b c;
    private final j0 d;
    private final AtomicBoolean e;
    private co.ab180.airbridge.internal.lifecycle.b.b f;
    private final AtomicBoolean g;
    private final Context h;
    private final AirbridgeOption i;
    private final o j;
    private final j k;

    public i(@NotNull Context context0, @NotNull AirbridgeOption airbridgeOption0, @NotNull o o0, @NotNull j j0) {
        this.h = context0;
        this.i = airbridgeOption0;
        this.j = o0;
        this.k = j0;
        this.c = new b("deferred-deeplink-runner");
        this.d = new j0(k0.a(context0, airbridgeOption0));
        this.e = new AtomicBoolean(false);
        this.f = co.ab180.airbridge.internal.lifecycle.b.b.d;
        this.g = new AtomicBoolean(true);
    }

    public static co.ab180.airbridge.internal.w.b a(i i0, c c0, co.ab180.airbridge.internal.lifecycle.c c1, String s, boolean z, Map map0, int v, Object object0) {
        if((v & 4) != 0) {
            s = c1.g();
        }
        if((v & 8) != 0) {
            z = false;
        }
        if((v & 16) != 0) {
            map0 = null;
        }
        return i0.a(c0, c1, s, z, map0);
    }

    private final co.ab180.airbridge.internal.w.b a(c c0, co.ab180.airbridge.internal.lifecycle.c c1, String s, boolean z, Map map0) {
        return new co.ab180.airbridge.internal.w.b(c0, c1.i(), co.ab180.airbridge.internal.network.model.b.b, s, c1.h(), null, null, z, map0, 0x60, null);
    }

    private final Object a(co.ab180.airbridge.internal.lifecycle.c c0, Continuation continuation0) {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001A\u00020\u00002\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0082@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lco/ab180/airbridge/internal/lifecycle/c;", "lifecycleContext", "Lkotlin/coroutines/Continuation;", "Lie/H;", "continuation", "", "onAppInForegrounded", "(Lco/ab180/airbridge/internal/lifecycle/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.lifecycle.LifecycleTracker", f = "LifecycleTracker.kt", l = {0xD4}, m = "onAppInForegrounded")
        static final class co.ab180.airbridge.internal.lifecycle.i.b extends oe.c {
            Object a;
            int b;
            final i c;
            Object d;
            Object e;

            public co.ab180.airbridge.internal.lifecycle.i.b(i i0, Continuation continuation0) {
                this.c = i0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return i.a(this.c, null, this);
            }
        }

        i i0;
        c c1;
        co.ab180.airbridge.internal.lifecycle.i.b i$b0;
        if(continuation0 instanceof co.ab180.airbridge.internal.lifecycle.i.b) {
            i$b0 = (co.ab180.airbridge.internal.lifecycle.i.b)continuation0;
            int v = i$b0.b;
            if((v & 0x80000000) == 0) {
                i$b0 = new co.ab180.airbridge.internal.lifecycle.i.b(this, continuation0);
            }
            else {
                i$b0.b = v ^ 0x80000000;
            }
        }
        else {
            i$b0 = new co.ab180.airbridge.internal.lifecycle.i.b(this, continuation0);
        }
        Object object0 = i$b0.a;
        a a0 = a.a;
        switch(i$b0.b) {
            case 0: {
                n.D(object0);
                co.ab180.airbridge.internal.b.e.e("LifecycleTracker(" + p.a(this) + ")#onAppInForegrounded: {" + c0 + '}', new Object[0]);
                this.g.set(false);
                c1 = this.j.b(c0.i()) ? c.e : c.d;
                if(l.a(c0.f(), c0.g())) {
                    i$b0.d = this;
                    i$b0.e = c0;
                    i$b0.b = 1;
                    object0 = this.a(c1, c0.g(), i$b0);
                    if(object0 == a0) {
                        return a0;
                    }
                    c1 = (c)object0;
                }
                i0 = this;
                break;
            }
            case 1: {
                c0 = (co.ab180.airbridge.internal.lifecycle.c)i$b0.e;
                i i1 = (i)i$b0.d;
                n.D(object0);
                c1 = (c)object0;
                i0 = i1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        i0.j.c();
        i0.a(c0, c1, i.a(i0, c1, c0, null, false, null, 28, null));
        return H.a;
    }

    private final Object a(c c0, String s, Continuation continuation0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001A\u00020\u00002\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00000\u0004H\u0082@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lco/ab180/airbridge/internal/network/model/c;", "eventType", "", "dataString", "Lkotlin/coroutines/Continuation;", "continuation", "", "processDeeplinkData", "(Lco/ab180/airbridge/internal/network/model/c;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.lifecycle.LifecycleTracker", f = "LifecycleTracker.kt", l = {0x7F}, m = "processDeeplinkData")
        static final class d extends oe.c {
            Object a;
            int b;
            final i c;
            Object d;
            Object e;

            public d(i i0, Continuation continuation0) {
                this.c = i0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.a(null, null, this);
            }
        }

        d i$d0;
        if(continuation0 instanceof d) {
            i$d0 = (d)continuation0;
            int v = i$d0.b;
            if((v & 0x80000000) == 0) {
                i$d0 = new d(this, continuation0);
            }
            else {
                i$d0.b = v ^ 0x80000000;
            }
        }
        else {
            i$d0 = new d(this, continuation0);
        }
        Object object0 = i$d0.a;
        a a0 = a.a;
        switch(i$d0.b) {
            case 0: {
                n.D(object0);
                if((this.i.isTrackAirbridgeLinkOnly() ? this.d.c(s) : true)) {
                    switch(c0.ordinal()) {
                        case 0: {
                            c0 = c.f;
                            break;
                        }
                        case 2: 
                        case 3: {
                            c0 = c.h;
                            break;
                        }
                        case 1: 
                        case 4: {
                            c0 = c.g;
                        }
                    }
                    if(this.d.e(s) && s != null) {
                        try {
                            i$d0.d = c0;
                            i$d0.e = s;
                            i$d0.b = 1;
                            if(this.j.a(s, "click", i$d0) == a0) {
                                return a0;
                            }
                            goto label_31;
                        }
                        catch(Throwable throwable0) {
                            co.ab180.airbridge.internal.b.e.b("Failed on clicking universal tracking link: url={" + s + "} error={" + throwable0 + '}', new Object[0]);
                            return c0;
                        }
                    }
                }
                return c0;
            }
            case 1: {
                s = (String)i$d0.e;
                c0 = (c)i$d0.d;
                try {
                    n.D(object0);
                label_31:
                    co.ab180.airbridge.internal.b.e.d("Succeed on clicking universal tracking link: url={" + s + '}', new Object[0]);
                    return c0;
                }
                catch(Throwable throwable0) {
                    co.ab180.airbridge.internal.b.e.b("Failed on clicking universal tracking link: url={" + s + "} error={" + throwable0 + '}', new Object[0]);
                }
                return c0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public static final String a(i i0) {
        return i0.b;
    }

    private final void a(co.ab180.airbridge.internal.lifecycle.c c0) {
        co.ab180.airbridge.internal.b.e.e("LifecycleTracker(" + p.a(this) + ")#onAppInBackgrounded: {" + c0 + '}', new Object[0]);
        this.g.set(this.i.isPauseEventTransmitOnBackgroundEnabled());
        this.j.a(c0.i());
        i.a(this, c0, null, null, 6, null);
    }

    private final void a(co.ab180.airbridge.internal.lifecycle.c c0, c c1, co.ab180.airbridge.internal.w.b b0) {
        this.k.a(c0.j(), c1, b0);
    }

    public static void a(i i0, co.ab180.airbridge.internal.lifecycle.c c0, c c1, co.ab180.airbridge.internal.w.b b0, int v, Object object0) {
        if((v & 2) != 0) {
            c1 = null;
        }
        if((v & 4) != 0) {
            b0 = null;
        }
        i0.a(c0, c1, b0);
    }

    public final void a() {
        this.e.set(true);
        this.p();
        this.h();
    }

    public static final co.ab180.airbridge.internal.lifecycle.b.b b(i i0) {
        return i0.f;
    }

    private final Object b(co.ab180.airbridge.internal.lifecycle.c c0, Continuation continuation0) {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001A\u00020\u00002\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0082@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lco/ab180/airbridge/internal/lifecycle/c;", "lifecycleContext", "Lkotlin/coroutines/Continuation;", "Lie/H;", "continuation", "", "onAppLaunched", "(Lco/ab180/airbridge/internal/lifecycle/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.lifecycle.LifecycleTracker", f = "LifecycleTracker.kt", l = {0x97, 0x9C}, m = "onAppLaunched")
        static final class co.ab180.airbridge.internal.lifecycle.i.c extends oe.c {
            Object a;
            int b;
            final i c;
            Object d;
            Object e;
            Object f;

            public co.ab180.airbridge.internal.lifecycle.i.c(i i0, Continuation continuation0) {
                this.c = i0;
                super(continuation0);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                this.a = object0;
                this.b |= 0x80000000;
                return this.c.b(null, this);
            }
        }

        c c3;
        co.ab180.airbridge.internal.lifecycle.c c2;
        i i0;
        c c1;
        co.ab180.airbridge.internal.lifecycle.i.c i$c0;
        if(continuation0 instanceof co.ab180.airbridge.internal.lifecycle.i.c) {
            i$c0 = (co.ab180.airbridge.internal.lifecycle.i.c)continuation0;
            int v = i$c0.b;
            if((v & 0x80000000) == 0) {
                i$c0 = new co.ab180.airbridge.internal.lifecycle.i.c(this, continuation0);
            }
            else {
                i$c0.b = v ^ 0x80000000;
            }
        }
        else {
            i$c0 = new co.ab180.airbridge.internal.lifecycle.i.c(this, continuation0);
        }
        Object object0 = i$c0.a;
        a a0 = a.a;
        switch(i$c0.b) {
            case 0: {
                n.D(object0);
                co.ab180.airbridge.internal.b.e.e("LifecycleTracker(" + p.a(this) + ")#onAppLaunched: {" + c0 + '}', new Object[0]);
                this.g.set(false);
                this.j.c(0L);
                boolean z = this.j.b(c0.i());
                if(co.ab180.airbridge.internal.o.a.a(this.j, null, 1, null)) {
                    c1 = c.a;
                }
                else {
                    c1 = z ? c.b : c.c;
                }
                if(l.a(c0.f(), c0.g())) {
                    i$c0.d = this;
                    i$c0.e = c0;
                    i$c0.b = 1;
                    object0 = this.a(c1, c0.g(), i$c0);
                    if(object0 == a0) {
                        return a0;
                    }
                    c1 = (c)object0;
                }
                i0 = this;
                c2 = c0;
                goto label_40;
            }
            case 1: {
                c0 = (co.ab180.airbridge.internal.lifecycle.c)i$c0.e;
                i i1 = (i)i$c0.d;
                n.D(object0);
                c1 = (c)object0;
                i0 = i1;
                c2 = c0;
            label_40:
                switch(c1.ordinal()) {
                    case 0: {
                        goto label_45;
                    }
                    case 5: {
                        i0.a(c2, c1, i.a(i0, c1, c2, null, true, C.S(new m[]{new m("option", co.ab180.airbridge.internal.e0.b.a(i0.i, i0.h)), new m("wrapperOption", i0.i.getSdkWrapperOption())}), 4, null));
                        return H.a;
                    }
                }
                i0.a(c2, c1, i.a(i0, c1, c2, null, false, null, 28, null));
                return H.a;
            label_45:
                Job job0 = i0.a;
                if(job0 != null) {
                    i$c0.d = i0;
                    i$c0.e = c2;
                    i$c0.f = c1;
                    i$c0.b = 2;
                    if(job0.join(i$c0) == a0) {
                        return a0;
                    }
                }
                c3 = c1;
                break;
            }
            case 2: {
                c3 = (c)i$c0.f;
                co.ab180.airbridge.internal.lifecycle.c c4 = (co.ab180.airbridge.internal.lifecycle.c)i$c0.e;
                i i2 = (i)i$c0.d;
                n.D(object0);
                i0 = i2;
                c2 = c4;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        m m0 = i0.b == null || i0.b.length() == 0 ? new m(c.a, null) : new m(c.f, String.valueOf(i0.b));
        Map map0 = C.S(new m[]{new m("option", co.ab180.airbridge.internal.e0.b.a(i0.i, i0.h)), new m("wrapperOption", i0.i.getSdkWrapperOption())});
        i0.a(c2, c3, i0.a(((c)m0.a), c2, ((String)m0.b), true, map0));
        return H.a;
    }

    private final void b(co.ab180.airbridge.internal.lifecycle.c c0) {
        co.ab180.airbridge.internal.b.e.e("LifecycleTracker(" + p.a(this) + ")#onAppStopped: {" + c0 + '}', new Object[0]);
        this.g.set(true);
        i.a(this, c0, null, null, 6, null);
    }

    public final void b() {
        this.c.c();
        this.e.set(false);
        co.ab180.airbridge.internal.lifecycle.b.b.c();
    }

    @Override
    public void close() {
        this.c.c();
        this.e.set(false);
        this.q();
    }

    private final void h() {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.lifecycle.LifecycleTracker$getDeferredDeeplink$1", f = "LifecycleTracker.kt", l = {78}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.lifecycle.i.a extends oe.i implements we.n {
            Object a;
            Object b;
            int c;
            final i d;

            public co.ab180.airbridge.internal.lifecycle.i.a(i i0, Continuation continuation0) {
                this.d = i0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.lifecycle.i.a(this.d, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.lifecycle.i.a)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                String s;
                i i2;
                i i1;
                Object object1;
                i i0;
                a a0 = a.a;
                switch(this.c) {
                    case 0: {
                        n.D(object0);
                        i0 = this.d;
                        try {
                            this.a = i0;
                            this.b = i0;
                            this.c = 1;
                            object1 = i0.j.d(this);
                            if(object1 == a0) {
                                return a0;
                            }
                        }
                        catch(Throwable unused_ex) {
                            i1 = i0;
                            s = null;
                            i1.b = s;
                            return H.a;
                        }
                        i1 = i0;
                        object0 = object1;
                        i2 = i1;
                        s = (String)object0;
                        i1.b = s;
                        return H.a;
                    }
                    case 1: {
                        i1 = (i)this.b;
                        i2 = (i)this.a;
                        try {
                            n.D(object0);
                            s = (String)object0;
                            i1.b = s;
                            return H.a;
                        }
                        catch(Throwable unused_ex) {
                        }
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                i0 = i2;
                i1 = i0;
                s = null;
                i1.b = s;
                return H.a;
            }
        }

        co.ab180.airbridge.internal.lifecycle.i.a i$a0 = new co.ab180.airbridge.internal.lifecycle.i.a(this, null);
        this.a = this.c.a(i$a0);
    }

    @NotNull
    public final co.ab180.airbridge.internal.lifecycle.b.b m() {
        return this.f;
    }

    public final boolean o() {
        return this.g.get();
    }

    private final void p() {
        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\u008A@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lco/ab180/airbridge/internal/lifecycle/c;", "it", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @e(c = "co.ab180.airbridge.internal.lifecycle.LifecycleTracker$registerLifecycleListener$1", f = "LifecycleTracker.kt", l = {0x5F, 0x60}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.lifecycle.i.e extends oe.i implements we.n {
            private Object a;
            int b;
            final i c;

            public co.ab180.airbridge.internal.lifecycle.i.e(i i0, Continuation continuation0) {
                this.c = i0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                Continuation continuation1 = new co.ab180.airbridge.internal.lifecycle.i.e(this.c, continuation0);
                continuation1.a = object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.lifecycle.i.e)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                co.ab180.airbridge.internal.lifecycle.c c1;
                a a0 = a.a;
                boolean z = false;
                H h0 = H.a;
                switch(this.b) {
                    case 0: {
                        n.D(object0);
                        co.ab180.airbridge.internal.lifecycle.c c0 = (co.ab180.airbridge.internal.lifecycle.c)this.a;
                        if(!this.c.e.get()) {
                            return h0;
                        }
                        this.c.f = c0.j();
                        co.ab180.airbridge.internal.b.e.d("Following app state detected: state={" + c0.j().name() + '}', new Object[0]);
                        int v = c0.j().ordinal();
                        switch(v) {
                            case 0: {
                                this.a = c0;
                                this.b = 1;
                                if(this.c.b(c0, this) == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                this.c.a(c0);
                                break;
                            }
                            case 2: {
                                this.a = c0;
                                this.b = 2;
                                if(this.c.a(c0, this) == a0) {
                                    return a0;
                                }
                                break;
                            }
                            default: {
                                if(v == 3) {
                                    this.c.b(c0);
                                }
                            }
                        }
                        c1 = c0;
                        break;
                    }
                    case 1: 
                    case 2: {
                        c1 = (co.ab180.airbridge.internal.lifecycle.c)this.a;
                        n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                AtomicBoolean atomicBoolean0 = this.c.g;
                if(c1.j() == co.ab180.airbridge.internal.lifecycle.b.b.d) {
                    z = true;
                }
                atomicBoolean0.set(z);
                return h0;
            }
        }

        co.ab180.airbridge.internal.lifecycle.i.e i$e0 = new co.ab180.airbridge.internal.lifecycle.i.e(this, null);
        co.ab180.airbridge.internal.lifecycle.b.b.a(i$e0);
    }

    private final void q() {
        co.ab180.airbridge.internal.lifecycle.b.b.b();
    }
}

