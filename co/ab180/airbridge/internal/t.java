package co.ab180.airbridge.internal;

import android.content.Context;
import co.ab180.airbridge.AirbridgeOption;
import co.ab180.airbridge.common.Event;
import co.ab180.airbridge.internal.a0.e;
import co.ab180.airbridge.internal.e0.p;
import co.ab180.airbridge.internal.e0.y.a;
import co.ab180.airbridge.internal.e0.y;
import co.ab180.airbridge.internal.lifecycle.i;
import co.ab180.airbridge.internal.y.b;
import co.ab180.airbridge.internal.y.c;
import co.ab180.airbridge.internal.z.f;
import ie.H;
import ie.j;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\u00C2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J+\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u00052\b\u0010\b\u001A\u0004\u0018\u00010\u00072\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0002\u00A2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b\f\u0010\u0010J\u0017\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\f\u0010\u0012J\u000F\u0010\u0016\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0004J\u000F\u0010\u0017\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0004J\u0017\u0010\u0016\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0010J\u0017\u0010\u0019\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u0010J;\u0010\f\u001A\u00020\u001F2\u0014\u0010\u001C\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001B\u0012\u0004\u0012\u00020\u000B0\u001A2\u0014\u0010\u001E\u001A\u0010\u0012\u0004\u0012\u00020\u001D\u0012\u0004\u0012\u00020\u000B\u0018\u00010\u001AH\u0016\u00A2\u0006\u0004\b\f\u0010 JA\u0010\f\u001A\u00020\u000B2\u0006\u0010!\u001A\u00020\u00072\u0006\u0010#\u001A\u00020\"2\b\u0010%\u001A\u0004\u0018\u00010$2\u0016\u0010(\u001A\u0012\u0012\u0004\u0012\u00020\u000E\u0012\u0006\u0012\u0004\u0018\u00010\'\u0018\u00010&H\u0016\u00A2\u0006\u0004\b\f\u0010)J\u000F\u0010*\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b*\u0010\u0004J\u000F\u0010+\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b+\u0010\u0004J\u000F\u0010,\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b,\u0010\u0004R\u001B\u00101\u001A\u00020-8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\f\u0010.\u001A\u0004\b/\u00100R\u001B\u00105\u001A\u0002028BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\u0014\u0010.\u001A\u0004\b3\u00104R\u001B\u00109\u001A\u0002068BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\u0011\u0010.\u001A\u0004\b7\u00108R\u001B\u0010>\u001A\u00020:8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b;\u0010.\u001A\u0004\b<\u0010=R\u001B\u0010B\u001A\u00020?8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\u0019\u0010.\u001A\u0004\b@\u0010AR\u0014\u0010E\u001A\u00020C8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0016\u0010DR\u0014\u0010H\u001A\u00020F8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0017\u0010GR\u0014\u0010K\u001A\u00020I8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b+\u0010JR\u0014\u0010O\u001A\u00020L8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001A\u00020P8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010U\u001A\u00020P8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bT\u0010RR\u0014\u0010Y\u001A\u00020V8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010[\u001A\u00020\u001F8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bQ\u0010Z\u00A8\u0006\\"}, d2 = {"Lco/ab180/airbridge/internal/t;", "Lco/ab180/airbridge/internal/r;", "Lco/ab180/airbridge/internal/e0/y$a;", "<init>", "()V", "Lco/ab180/airbridge/internal/lifecycle/b$b;", "lifecycleType", "Lco/ab180/airbridge/internal/network/model/c;", "triggerEventType", "Lco/ab180/airbridge/internal/w/b;", "eventSeed", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/lifecycle/b$b;Lco/ab180/airbridge/internal/network/model/c;Lco/ab180/airbridge/internal/w/b;)V", "", "pushToken", "(Ljava/lang/String;)V", "c", "(Lco/ab180/airbridge/internal/w/b;)V", "Lkotlinx/coroutines/Job;", "b", "(Lco/ab180/airbridge/internal/w/b;)Lkotlinx/coroutines/Job;", "f", "g", "deeplink", "e", "Lkotlin/Function1;", "Landroid/net/Uri;", "onSuccess", "", "onFailure", "", "(Lwe/k;Lwe/k;)Z", "eventType", "Lco/ab180/airbridge/internal/network/model/b;", "triggerType", "Lco/ab180/airbridge/common/Event;", "event", "", "", "sdkAttributes", "(Lco/ab180/airbridge/internal/network/model/c;Lco/ab180/airbridge/internal/network/model/b;Lco/ab180/airbridge/common/Event;Ljava/util/Map;)V", "m", "h", "close", "Landroid/content/Context;", "Lie/j;", "p", "()Landroid/content/Context;", "context", "Lco/ab180/airbridge/AirbridgeOption;", "r", "()Lco/ab180/airbridge/AirbridgeOption;", "option", "Lco/ab180/airbridge/internal/c;", "o", "()Lco/ab180/airbridge/internal/c;", "attribution", "Lco/ab180/airbridge/internal/i;", "d", "q", "()Lco/ab180/airbridge/internal/i;", "eventHandler", "Lco/ab180/airbridge/internal/o;", "s", "()Lco/ab180/airbridge/internal/o;", "repository", "Lco/ab180/airbridge/internal/x/a;", "Lco/ab180/airbridge/internal/x/a;", "eventWorker", "Lco/ab180/airbridge/internal/e0/y;", "Lco/ab180/airbridge/internal/e0/y;", "networkHandler", "Lco/ab180/airbridge/internal/y/c;", "Lco/ab180/airbridge/internal/y/c;", "pushTokenDelegate", "Lco/ab180/airbridge/internal/y/b;", "i", "Lco/ab180/airbridge/internal/y/b;", "deferredDeepLinkDelegate", "Ljava/util/concurrent/atomic/AtomicBoolean;", "j", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isClosed", "k", "trackingStarted", "Lco/ab180/airbridge/internal/lifecycle/i;", "l", "Lco/ab180/airbridge/internal/lifecycle/i;", "lifecycleTracker", "()Z", "isTrackingStarted", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class t implements a, r {
    private final j a;
    private final j b;
    private final j c;
    private final j d;
    private final j e;
    private final co.ab180.airbridge.internal.x.a f;
    private final y g;
    private final c h;
    private final b i;
    private final AtomicBoolean j;
    private final AtomicBoolean k;
    private final i l;

    public t() {
        @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J+\u0010\t\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"co/ab180/airbridge/internal/t$a", "Lco/ab180/airbridge/internal/lifecycle/j;", "Lco/ab180/airbridge/internal/lifecycle/b$b;", "lifecycleType", "Lco/ab180/airbridge/internal/network/model/c;", "triggerEventType", "Lco/ab180/airbridge/internal/w/b;", "eventSeed", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/lifecycle/b$b;Lco/ab180/airbridge/internal/network/model/c;Lco/ab180/airbridge/internal/w/b;)V", "airbridge_release"}, k = 1, mv = {1, 4, 3})
        public static final class co.ab180.airbridge.internal.t.a implements co.ab180.airbridge.internal.lifecycle.j {
            final t a;

            public co.ab180.airbridge.internal.t.a(t t0) {
                this.a = t0;
                super();
            }

            @Override  // co.ab180.airbridge.internal.lifecycle.j
            public void a(@NotNull co.ab180.airbridge.internal.lifecycle.b.b b$b0, @Nullable co.ab180.airbridge.internal.network.model.c c0, @Nullable co.ab180.airbridge.internal.w.b b0) {
                t.a(this.a, b$b0, c0, b0);
            }
        }


        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lie/H;", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.t.b extends kotlin.jvm.internal.r implements k {
            final t a;

            public co.ab180.airbridge.internal.t.b(t t0) {
                this.a = t0;
                super(1);
            }

            public final void a(@NotNull String s) {
                t.a(this.a, s);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.a(((String)object0));
                return H.a;
            }
        }

        this.a = f.b(Context.class);
        this.b = f.b(AirbridgeOption.class);
        this.c = f.b(co.ab180.airbridge.internal.c.class);
        this.d = f.b(co.ab180.airbridge.internal.i.class);
        this.e = f.b(o.class);
        this.f = new co.ab180.airbridge.internal.x.a("tracker-event-runner");
        this.g = new y();
        this.h = new c(new co.ab180.airbridge.internal.t.b(this));
        this.i = new b();
        this.j = new AtomicBoolean(false);
        this.k = new AtomicBoolean(false);
        this.l = new i(this.p(), this.r(), this.s(), new co.ab180.airbridge.internal.t.a(this));
    }

    private final void a(co.ab180.airbridge.internal.lifecycle.b.b b$b0, co.ab180.airbridge.internal.network.model.c c0, co.ab180.airbridge.internal.w.b b0) {
        switch(b$b0.ordinal()) {
            case 0: {
                if(c0 == co.ab180.airbridge.internal.network.model.c.c && !this.r().isTrackInSessionLifeCycleEventEnabled()) {
                    co.ab180.airbridge.internal.b.e.d("Drop lifecycle in session event: category={" + c0 + '}', new Object[0]);
                    this.q().a();
                }
                else if(b0 != null) {
                    this.c(b0);
                }
                this.h.a();
                this.i.a(c0);
                this.o().a();
                return;
            }
            case 1: {
                if(this.r().isPauseEventTransmitOnBackgroundEnabled()) {
                    co.ab180.airbridge.internal.b.e.d("Into the background, so sending event packets paused", new Object[0]);
                    this.q().b();
                    return;
                }
                break;
            }
            case 2: {
                if(c0 == co.ab180.airbridge.internal.network.model.c.d && !this.r().isTrackInSessionLifeCycleEventEnabled()) {
                    co.ab180.airbridge.internal.b.e.d("Drop lifecycle in session event: category={" + c0 + '}', new Object[0]);
                    this.q().a();
                    return;
                }
                if(b0 != null) {
                    this.c(b0);
                    return;
                }
                break;
            }
            case 3: {
                this.q().b();
            }
        }
    }

    public static final void a(t t0, co.ab180.airbridge.internal.lifecycle.b.b b$b0, co.ab180.airbridge.internal.network.model.c c0, co.ab180.airbridge.internal.w.b b0) {
        t0.a(b$b0, c0, b0);
    }

    public static final void a(t t0, String s) {
        t0.a(s);
    }

    private final void a(co.ab180.airbridge.internal.w.b b0) {
        switch(b0.m().ordinal()) {
            case 0: 
            case 5: {
                this.s().a(Boolean.FALSE);
                return;
            }
            case 9: {
                this.h.e();
            }
        }
    }

    private final void a(String s) {
        if(!this.j()) {
            return;
        }
        co.ab180.airbridge.internal.b.e.d("Track special event: category={" + co.ab180.airbridge.internal.network.model.c.j + '}', new Object[0]);
        this.b(new co.ab180.airbridge.internal.w.b(co.ab180.airbridge.internal.network.model.c.j, System.currentTimeMillis(), co.ab180.airbridge.internal.network.model.b.b, null, null, s, null, false, null, 472, null));
    }

    @Override  // co.ab180.airbridge.internal.r
    public void a(@NotNull co.ab180.airbridge.internal.network.model.c c0, @NotNull co.ab180.airbridge.internal.network.model.b b0, @Nullable Event event0, @Nullable Map map0) {
        if(!this.j()) {
            return;
        }
        this.b(new co.ab180.airbridge.internal.w.b(c0, System.currentTimeMillis(), b0, null, null, null, (event0 == null ? null : e.a(event0)), false, map0, 0xB8, null));
    }

    @Override  // co.ab180.airbridge.internal.r
    public boolean a(@NotNull k k0, @Nullable k k1) {
        co.ab180.airbridge.internal.b.e.e("Tracker(" + p.a(this) + ")#handleDeferredDeeplink", new Object[0]);
        return this.i.b(k0, k1);
    }

    private final Job b(co.ab180.airbridge.internal.w.b b0) {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u008A@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
        @oe.e(c = "co.ab180.airbridge.internal.TrackerImpl$trackEvent$1", f = "Tracker.kt", l = {0x106}, m = "invokeSuspend")
        static final class co.ab180.airbridge.internal.t.c extends oe.i implements n {
            int a;
            final t b;
            final co.ab180.airbridge.internal.w.b c;

            public co.ab180.airbridge.internal.t.c(t t0, co.ab180.airbridge.internal.w.b b0, Continuation continuation0) {
                this.b = t0;
                this.c = b0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new co.ab180.airbridge.internal.t.c(this.b, this.c, continuation0);
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((co.ab180.airbridge.internal.t.c)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.a) {
                    case 0: {
                        d5.n.D(object0);
                        if(this.b.k.get()) {
                            co.ab180.airbridge.internal.i i0 = this.b.q();
                            this.a = 1;
                            if(i0.a(this.c, this) == a0) {
                                return a0;
                            }
                            this.b.a(this.c);
                            return H.a;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        this.b.a(this.c);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return H.a;
            }
        }

        co.ab180.airbridge.internal.t.c t$c0 = new co.ab180.airbridge.internal.t.c(this, b0, null);
        return this.f.a(t$c0);
    }

    private final void c(co.ab180.airbridge.internal.w.b b0) {
        co.ab180.airbridge.internal.b.e.d("Track lifecycle event: eventType={" + b0.m() + '}', new Object[0]);
        this.b(b0);
    }

    @Override
    public void close() {
        Context context0 = this.p();
        this.g.c(context0);
        this.l.close();
        this.k.set(false);
        this.q().b();
        this.j.set(true);
    }

    @Override  // co.ab180.airbridge.internal.r
    public void e(@NotNull String s) {
        co.ab180.airbridge.internal.b.e.e("Tracker(" + p.a(this) + ")#registerPushToken: {" + s + '}', new Object[0]);
        this.h.a(s);
    }

    @Override  // co.ab180.airbridge.internal.r
    public void f() {
        if(this.k.getAndSet(true)) {
            co.ab180.airbridge.internal.b.e.f("Airbridge is already started tracking", new Object[0]);
            return;
        }
        co.ab180.airbridge.internal.b.e.d("startTracking signal is received", new Object[0]);
        Context context0 = this.p();
        this.g.a(context0, this);
        this.l.a();
        if(this.l.m() != co.ab180.airbridge.internal.lifecycle.b.b.d) {
            this.o().a();
        }
        if(!co.ab180.airbridge.internal.o.a.a(this.s(), null, 1, null)) {
            this.h.a();
        }
    }

    @Override  // co.ab180.airbridge.internal.r
    public void f(@NotNull String s) {
        if(!this.j()) {
            return;
        }
        co.ab180.airbridge.internal.b.e.d("Track special event: category={" + co.ab180.airbridge.internal.network.model.c.i + '}', new Object[0]);
        this.b(new co.ab180.airbridge.internal.w.b(co.ab180.airbridge.internal.network.model.c.i, System.currentTimeMillis(), co.ab180.airbridge.internal.network.model.b.b, s, null, null, null, false, null, 0x1F0, null));
    }

    @Override  // co.ab180.airbridge.internal.r
    public void g() {
        if(!this.k.getAndSet(false)) {
            co.ab180.airbridge.internal.b.e.a("Airbridge is already stopped tracking", new Object[0]);
        }
        co.ab180.airbridge.internal.b.e.d("stopTracking signal is received", new Object[0]);
        this.l.b();
        this.o().b();
        this.q().b();
    }

    @Override  // co.ab180.airbridge.internal.e0.y$a
    public void h() {
        co.ab180.airbridge.internal.b.e.e("Tracker(" + p.a(this) + ")#onNetworkStateLost", new Object[0]);
        this.q().b();
    }

    @Override  // co.ab180.airbridge.internal.r
    public boolean j() {
        return this.k.get();
    }

    @Override  // co.ab180.airbridge.internal.e0.y$a
    public void m() {
        co.ab180.airbridge.internal.b.e.e("Tracker(" + p.a(this) + ")#onNetworkStateAvailable", new Object[0]);
        if(!this.j.get() && !this.l.o()) {
            this.q().a();
        }
    }

    private final co.ab180.airbridge.internal.c o() {
        return (co.ab180.airbridge.internal.c)this.c.getValue();
    }

    private final Context p() {
        return (Context)this.a.getValue();
    }

    private final co.ab180.airbridge.internal.i q() {
        return (co.ab180.airbridge.internal.i)this.d.getValue();
    }

    private final AirbridgeOption r() {
        return (AirbridgeOption)this.b.getValue();
    }

    private final o s() {
        return (o)this.e.getValue();
    }
}

