package co.ab180.airbridge.internal;

import android.app.Application;
import android.content.Intent;
import android.webkit.WebView;
import co.ab180.airbridge.AirbridgeLifecycleIntegration;
import co.ab180.airbridge.AirbridgeOption;
import co.ab180.airbridge.common.Event;
import co.ab180.airbridge.common.OnFailure;
import co.ab180.airbridge.common.OnSuccess;
import co.ab180.airbridge.internal.u.b.b;
import co.ab180.airbridge.internal.u.b.d;
import co.ab180.airbridge.internal.u.c.c;
import co.ab180.airbridge.internal.u.c.g;
import co.ab180.airbridge.internal.u.c.l;
import co.ab180.airbridge.internal.u.c.s;
import co.ab180.airbridge.internal.u.c.t;
import co.ab180.airbridge.internal.z.f;
import com.google.firebase.messaging.RemoteMessage;
import ie.H;
import ie.j;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00C0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u001D\u0010\f\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u000FJ\u000F\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u000FJ\u000F\u0010\u0015\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0015\u0010\u000FJ\u000F\u0010\u0016\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0013J\u000F\u0010\u0017\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0017\u0010\u000FJ\u000F\u0010\u0018\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u000FJ\u0019\u0010\u001B\u001A\u00020\u000B2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0019H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0019\u0010\u0016\u001A\u00020\u000B2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0019H\u0016\u00A2\u0006\u0004\b\u0016\u0010\u001CJ\u0019\u0010\u001F\u001A\u00020\u000B2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0019H\u0016\u00A2\u0006\u0004\b\u001F\u0010\u001CJ!\u0010\f\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020\u00192\b\u0010\"\u001A\u0004\u0018\u00010!H\u0016\u00A2\u0006\u0004\b\f\u0010#J\u000F\u0010\f\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\f\u0010\u000FJ!\u0010\f\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020\u00192\b\u0010\"\u001A\u0004\u0018\u00010\u0019H\u0016\u00A2\u0006\u0004\b\f\u0010$J\u000F\u0010\u001B\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u000FJ\u000F\u0010%\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b%\u0010\u000FJ\'\u0010\u0016\u001A\u00020\u00112\f\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u00190&2\b\u0010)\u001A\u0004\u0018\u00010(H\u0016\u00A2\u0006\u0004\b\u0016\u0010*J\'\u0010\u001F\u001A\u00020\u00112\f\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u00190&2\b\u0010)\u001A\u0004\u0018\u00010(H\u0016\u00A2\u0006\u0004\b\u001F\u0010*J\u001F\u0010\u001F\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020\u00192\u0006\u0010\"\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u001F\u0010$J\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\f\u0010\u001CJ\u000F\u0010\u001F\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u001F\u0010\u000FJ\u001F\u0010\f\u001A\u00020\u000B2\u0006\u0010,\u001A\u00020+2\u0006\u0010-\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\f\u0010.J\u001F\u0010\u0016\u001A\u00020\u00192\u0006\u0010-\u001A\u00020\u00192\u0006\u0010/\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u0016\u00100J\u0017\u0010\u0014\u001A\u00020\u000B2\u0006\u00101\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u001CJ7\u0010\f\u001A\u00020\u000B2\u0006\u00103\u001A\u0002022\u0006\u00105\u001A\u0002042\u0016\u00107\u001A\u0012\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u000106H\u0016\u00A2\u0006\u0004\b\f\u00108J\u0017\u0010%\u001A\u00020\u000B2\u0006\u00109\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b%\u0010\u001CJ\u0017\u0010\f\u001A\u00020\u00112\u0006\u0010;\u001A\u00020:H\u0016\u00A2\u0006\u0004\b\f\u0010<J/\u0010\f\u001A\u00020\u00112\u0006\u0010>\u001A\u00020=2\f\u0010\'\u001A\b\u0012\u0004\u0012\u00020?0&2\b\u0010)\u001A\u0004\u0018\u00010(H\u0016\u00A2\u0006\u0004\b\f\u0010@J)\u0010\f\u001A\u00020\u00112\u000E\u0010\'\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010?0&2\b\u0010)\u001A\u0004\u0018\u00010(H\u0016\u00A2\u0006\u0004\b\f\u0010*JC\u0010\f\u001A\u00020\u000B2\u0006\u0010A\u001A\u00020\u00192\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020!062\f\u0010\'\u001A\b\u0012\u0004\u0012\u00020B0&2\b\u0010)\u001A\u0004\u0018\u00010(H\u0016\u00A2\u0006\u0004\b\f\u0010CJ1\u0010\u0016\u001A\u00020\u00112\u0006\u0010D\u001A\u00020\u00192\u000E\u0010\'\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010&2\b\u0010)\u001A\u0004\u0018\u00010(H\u0016\u00A2\u0006\u0004\b\u0016\u0010EJ1\u0010\u001F\u001A\u00020\u00112\u0006\u0010D\u001A\u00020\u00192\u000E\u0010\'\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010&2\b\u0010)\u001A\u0004\u0018\u00010(H\u0016\u00A2\u0006\u0004\b\u001F\u0010EJ1\u0010\u001B\u001A\u00020\u00112\u0006\u0010F\u001A\u00020\u00192\u000E\u0010\'\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010G0&2\b\u0010)\u001A\u0004\u0018\u00010(H\u0016\u00A2\u0006\u0004\b\u001B\u0010EJ/\u0010\f\u001A\u00020\u00112\u0006\u0010F\u001A\u00020\u00192\f\u0010\'\u001A\b\u0012\u0004\u0012\u00020H0&2\b\u0010)\u001A\u0004\u0018\u00010(H\u0016\u00A2\u0006\u0004\b\f\u0010EJ\u001D\u0010\f\u001A\u00020\u000B2\f\u0010J\u001A\b\u0012\u0004\u0012\u00020\u000B0IH\u0002\u00A2\u0006\u0004\b\f\u0010KJ+\u0010\f\u001A\u00028\u0000\"\u0004\b\u0000\u0010L2\f\u0010J\u001A\b\u0012\u0004\u0012\u00028\u00000I2\u0006\u0010M\u001A\u00028\u0000H\u0002\u00A2\u0006\u0004\b\f\u0010NR\u0014\u0010Q\u001A\u00020O8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\f\u0010PR\u0014\u0010R\u001A\u00020O8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001F\u0010PR\u0014\u0010U\u001A\u00020S8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0016\u0010TR\u001B\u0010\b\u001A\u00020\u00078BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b\u001B\u0010V\u001A\u0004\bW\u0010XR\u001B\u0010\n\u001A\u00020\t8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b%\u0010V\u001A\u0004\bY\u0010ZR\u0016\u0010]\u001A\u00020[8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0014\u0010\\R\u0016\u0010`\u001A\u00020^8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0015\u0010_R\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0017\u0010aR\u0011\u0010c\u001A\u00020\u00118F\u00A2\u0006\u0006\u001A\u0004\bb\u0010\u0013R\u0013\u0010g\u001A\u0004\u0018\u00010d8F\u00A2\u0006\u0006\u001A\u0004\be\u0010fR\u0014\u0010i\u001A\u00020\u00118BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bh\u0010\u0013\u00A8\u0006j"}, d2 = {"Lco/ab180/airbridge/internal/a;", "Lco/ab180/airbridge/internal/u/c/g;", "Lco/ab180/airbridge/internal/u/b/b;", "Lco/ab180/airbridge/internal/e;", "debrisMass", "<init>", "(Lco/ab180/airbridge/internal/e;)V", "Landroid/app/Application;", "app", "Lco/ab180/airbridge/AirbridgeOption;", "option", "Lie/H;", "a", "(Landroid/app/Application;Lco/ab180/airbridge/AirbridgeOption;)V", "j", "()V", "l", "", "i", "()Z", "f", "g", "c", "h", "k", "", "id", "d", "(Ljava/lang/String;)V", "email", "phone", "b", "key", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "e", "Lco/ab180/airbridge/common/OnSuccess;", "onSuccess", "Lco/ab180/airbridge/common/OnFailure;", "onFailure", "(Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "Landroid/webkit/WebView;", "webView", "webToken", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "postMessageScript", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "command", "Lco/ab180/airbridge/internal/network/model/b;", "triggerType", "Lco/ab180/airbridge/common/Event;", "event", "", "sdkAttributes", "(Lco/ab180/airbridge/internal/network/model/b;Lco/ab180/airbridge/common/Event;Ljava/util/Map;)V", "token", "Lcom/google/firebase/messaging/RemoteMessage;", "remoteMessage", "(Lcom/google/firebase/messaging/RemoteMessage;)Z", "Landroid/content/Intent;", "intent", "Landroid/net/Uri;", "(Landroid/content/Intent;Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "channel", "Lco/ab180/airbridge/common/AirbridgeTrackingLink;", "(Ljava/lang/String;Ljava/util/Map;Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)V", "trackingLink", "(Ljava/lang/String;Lco/ab180/airbridge/common/OnSuccess;Lco/ab180/airbridge/common/OnFailure;)Z", "vendor", "Lco/ab180/airbridge/common/ReferrerDetails;", "Lco/ab180/airbridge/common/AdvertisingIdInfo;", "Lkotlin/Function0;", "runnable", "(Lwe/a;)V", "T", "defaultResult", "(Lwe/a;Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "sdkEnabled", "Lco/ab180/airbridge/internal/lifecycle/g;", "Lco/ab180/airbridge/internal/lifecycle/g;", "lifecycleProviderHandler", "Lie/j;", "m", "()Landroid/app/Application;", "o", "()Lco/ab180/airbridge/AirbridgeOption;", "Lco/ab180/airbridge/internal/u/c/l;", "Lco/ab180/airbridge/internal/u/c/l;", "publicApiFacade", "Lco/ab180/airbridge/internal/u/b/d;", "Lco/ab180/airbridge/internal/u/b/d;", "expandApiFacade", "Lco/ab180/airbridge/internal/e;", "q", "isSdkEnabled", "Lco/ab180/airbridge/AirbridgeLifecycleIntegration;", "n", "()Lco/ab180/airbridge/AirbridgeLifecycleIntegration;", "lifecycleIntegration", "p", "isInitialized", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class a implements b, g {
    private final AtomicBoolean a;
    private final AtomicBoolean b;
    private final co.ab180.airbridge.internal.lifecycle.g c;
    private final j d;
    private final j e;
    private l f;
    private d g;
    private final e h;

    public a() {
        this(null, 1, null);
    }

    public a(@Nullable e e0) {
        this.h = e0;
        this.a = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.c = new co.ab180.airbridge.internal.lifecycle.g();
        this.d = f.b(Application.class);
        this.e = f.b(AirbridgeOption.class);
        this.f = new l();
        this.g = new d();
    }

    public a(e e0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            e0 = null;
        }
        this(e0);
    }

    // 去混淆评级： 低(20)
    private final Object a(we.a a0, Object object0) {
        return !this.p() || !this.q() ? object0 : a0.invoke();
    }

    public static final void a(a a0, d d0) {
        a0.g = d0;
    }

    public static final void a(a a0, l l0) {
        a0.f = l0;
    }

    private final void a(we.a a0) {
        if(this.p() && this.q()) {
            a0.invoke();
        }
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void a() {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.a.d extends r implements we.a {
            final a a;

            public co.ab180.airbridge.internal.a.d(a a0) {
                this.a = a0;
                super(0);
            }

            public final void a() {
                s s0 = this.a.f.l();
                if(s0 != null) {
                    s0.a();
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new co.ab180.airbridge.internal.a.d(this));
    }

    public final void a(@NotNull Application application0, @NotNull AirbridgeOption airbridgeOption0) {
        if(this.a.getAndSet(true)) {
            co.ab180.airbridge.internal.b.e.f("Airbridge is already initialized", new Object[0]);
            return;
        }
        this.b.set(airbridgeOption0.isSdkEnabled());
        e e0 = this.h;
        if(e0 != null) {
            e0.a(application0, airbridgeOption0);
        }
        this.c.b(application0, airbridgeOption0.isSdkEnabled());
        co.ab180.airbridge.internal.b.b b$b0 = co.ab180.airbridge.internal.b.e;
        b$b0.d("Airbridge is initialized", new Object[0]);
        if(airbridgeOption0.isSdkEnabled()) {
            this.f.c();
            this.g.c();
        }
        if(airbridgeOption0.isAutoStartTrackingEnabled()) {
            b$b0.d("startTracking signal is sent automatically", new Object[0]);
            this.f();
        }
    }

    @Override  // co.ab180.airbridge.internal.u.c.t
    public void a(@NotNull WebView webView0, @NotNull String s) {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class z extends r implements we.a {
            final a a;
            final WebView b;
            final String c;

            public z(a a0, WebView webView0, String s) {
                this.a = a0;
                this.b = webView0;
                this.c = s;
                super(0);
            }

            public final void a() {
                t t0 = this.a.f.m();
                if(t0 != null) {
                    t0.a(this.b, this.c);
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new z(this, webView0, s));
    }

    @Override  // co.ab180.airbridge.internal.u.c.d
    public void a(@NotNull co.ab180.airbridge.internal.network.model.b b0, @NotNull Event event0, @Nullable Map map0) {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class c0 extends r implements we.a {
            final a a;
            final co.ab180.airbridge.internal.network.model.b b;
            final Event c;
            final Map d;

            public c0(a a0, co.ab180.airbridge.internal.network.model.b b0, Event event0, Map map0) {
                this.a = a0;
                this.b = b0;
                this.c = event0;
                this.d = map0;
                super(0);
            }

            public final void a() {
                co.ab180.airbridge.internal.u.c.d d0 = this.a.f.h();
                if(d0 != null) {
                    d0.a(this.b, this.c, this.d);
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new c0(this, b0, event0, map0));
    }

    @Override  // co.ab180.airbridge.internal.u.c.c
    public void a(@NotNull String s) {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.a.s extends r implements we.a {
            final a a;
            final String b;

            public co.ab180.airbridge.internal.a.s(a a0, String s) {
                this.a = a0;
                this.b = s;
                super(0);
            }

            public final void a() {
                c c0 = this.a.f.g();
                if(c0 != null) {
                    c0.a(this.b);
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new co.ab180.airbridge.internal.a.s(this, s));
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void a(@NotNull String s, @Nullable Object object0) {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class v extends r implements we.a {
            final a a;
            final String b;
            final Object c;

            public v(a a0, String s, Object object0) {
                this.a = a0;
                this.b = s;
                this.c = object0;
                super(0);
            }

            public final void a() {
                s s0 = this.a.f.l();
                if(s0 != null) {
                    s0.a(this.b, this.c);
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new v(this, s, object0));
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void a(@NotNull String s, @Nullable String s1) {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class u extends r implements we.a {
            final a a;
            final String b;
            final String c;

            public u(a a0, String s, String s1) {
                this.a = a0;
                this.b = s;
                this.c = s1;
                super(0);
            }

            public final void a() {
                s s0 = this.a.f.l();
                if(s0 != null) {
                    s0.a(this.b, this.c);
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new u(this, s, s1));
    }

    @Override  // co.ab180.airbridge.internal.u.c.b
    public void a(@NotNull String s, @NotNull Map map0, @NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.a.f extends r implements we.a {
            final a a;
            final String b;
            final Map c;
            final OnSuccess d;
            final OnFailure e;

            public co.ab180.airbridge.internal.a.f(a a0, String s, Map map0, OnSuccess onSuccess0, OnFailure onFailure0) {
                this.a = a0;
                this.b = s;
                this.c = map0;
                this.d = onSuccess0;
                this.e = onFailure0;
                super(0);
            }

            public final void a() {
                co.ab180.airbridge.internal.u.c.b b0 = this.a.f.f();
                if(b0 != null) {
                    b0.a(this.b, this.c, this.d, this.e);
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new co.ab180.airbridge.internal.a.f(this, s, map0, onSuccess0, onFailure0));
    }

    @Override  // co.ab180.airbridge.internal.u.c.b
    public boolean a(@NotNull Intent intent0, @NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Z"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.a.l extends r implements we.a {
            final a a;
            final Intent b;
            final OnSuccess c;
            final OnFailure d;

            public co.ab180.airbridge.internal.a.l(a a0, Intent intent0, OnSuccess onSuccess0, OnFailure onFailure0) {
                this.a = a0;
                this.b = intent0;
                this.c = onSuccess0;
                this.d = onFailure0;
                super(0);
            }

            public final boolean a() {
                co.ab180.airbridge.internal.u.c.b b0 = this.a.f.f();
                return b0 == null ? false : b0.a(this.b, this.c, this.d);
            }

            @Override  // we.a
            public Object invoke() {
                return Boolean.valueOf(this.a());
            }
        }

        return ((Boolean)this.a(new co.ab180.airbridge.internal.a.l(this, intent0, onSuccess0, onFailure0), Boolean.FALSE)).booleanValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.b
    public boolean a(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Z"}, k = 3, mv = {1, 4, 3})
        static final class m extends r implements we.a {
            final a a;
            final OnSuccess b;
            final OnFailure c;

            public m(a a0, OnSuccess onSuccess0, OnFailure onFailure0) {
                this.a = a0;
                this.b = onSuccess0;
                this.c = onFailure0;
                super(0);
            }

            public final boolean a() {
                co.ab180.airbridge.internal.u.c.b b0 = this.a.f.f();
                return b0 == null ? false : b0.a(this.b, this.c);
            }

            @Override  // we.a
            public Object invoke() {
                return Boolean.valueOf(this.a());
            }
        }

        return ((Boolean)this.a(new m(this, onSuccess0, onFailure0), Boolean.FALSE)).booleanValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.e
    public boolean a(@NotNull RemoteMessage remoteMessage0) {
        return this.f.i().a(remoteMessage0);
    }

    @Override  // co.ab180.airbridge.internal.u.b.a
    public boolean a(@NotNull String s, @NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Z"}, k = 3, mv = {1, 4, 3})
        static final class h extends r implements we.a {
            final a a;
            final String b;
            final OnSuccess c;
            final OnFailure d;

            public h(a a0, String s, OnSuccess onSuccess0, OnFailure onFailure0) {
                this.a = a0;
                this.b = s;
                this.c = onSuccess0;
                this.d = onFailure0;
                super(0);
            }

            public final boolean a() {
                co.ab180.airbridge.internal.u.b.a a0 = this.a.g.e();
                return a0 == null ? false : a0.a(this.b, this.c, this.d);
            }

            @Override  // we.a
            public Object invoke() {
                return Boolean.valueOf(this.a());
            }
        }

        return ((Boolean)this.a(new h(this, s, onSuccess0, onFailure0), Boolean.FALSE)).booleanValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.c
    public void b() {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.a.a extends r implements we.a {
            final a a;

            public co.ab180.airbridge.internal.a.a(a a0) {
                this.a = a0;
                super(0);
            }

            public final void a() {
                c c0 = this.a.f.g();
                if(c0 != null) {
                    c0.b();
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new co.ab180.airbridge.internal.a.a(this));
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void b(@Nullable String s) {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class y extends r implements we.a {
            final a a;
            final String b;

            public y(a a0, String s) {
                this.a = a0;
                this.b = s;
                super(0);
            }

            public final void a() {
                s s0 = this.a.f.l();
                if(s0 != null) {
                    s0.b(this.b);
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new y(this, s));
    }

    @Override  // co.ab180.airbridge.internal.u.c.c
    public void b(@NotNull String s, @NotNull String s1) {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.a.t extends r implements we.a {
            final a a;
            final String b;
            final String c;

            public co.ab180.airbridge.internal.a.t(a a0, String s, String s1) {
                this.a = a0;
                this.b = s;
                this.c = s1;
                super(0);
            }

            public final void a() {
                c c0 = this.a.f.g();
                if(c0 != null) {
                    c0.b(this.b, this.c);
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new co.ab180.airbridge.internal.a.t(this, s, s1));
    }

    @Override  // co.ab180.airbridge.internal.u.c.c
    public boolean b(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Z"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.a.j extends r implements we.a {
            final a a;
            final OnSuccess b;
            final OnFailure c;

            public co.ab180.airbridge.internal.a.j(a a0, OnSuccess onSuccess0, OnFailure onFailure0) {
                this.a = a0;
                this.b = onSuccess0;
                this.c = onFailure0;
                super(0);
            }

            public final boolean a() {
                c c0 = this.a.f.g();
                return c0 == null ? false : c0.b(this.b, this.c);
            }

            @Override  // we.a
            public Object invoke() {
                return Boolean.valueOf(this.a());
            }
        }

        return ((Boolean)this.a(new co.ab180.airbridge.internal.a.j(this, onSuccess0, onFailure0), Boolean.FALSE)).booleanValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.f
    public boolean b(@NotNull String s, @Nullable OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Z"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.a.e extends r implements we.a {
            final a a;
            final String b;
            final OnSuccess c;
            final OnFailure d;

            public co.ab180.airbridge.internal.a.e(a a0, String s, OnSuccess onSuccess0, OnFailure onFailure0) {
                this.a = a0;
                this.b = s;
                this.c = onSuccess0;
                this.d = onFailure0;
                super(0);
            }

            public final boolean a() {
                co.ab180.airbridge.internal.u.c.f f0 = this.a.f.j();
                return f0 == null ? false : f0.b(this.b, this.c, this.d);
            }

            @Override  // we.a
            public Object invoke() {
                return Boolean.valueOf(this.a());
            }
        }

        return ((Boolean)this.a(new co.ab180.airbridge.internal.a.e(this, s, onSuccess0, onFailure0), Boolean.FALSE)).booleanValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.t
    @NotNull
    public String c(@NotNull String s, @NotNull String s1) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000E\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.a.g extends r implements we.a {
            final a a;
            final String b;
            final String c;

            public co.ab180.airbridge.internal.a.g(a a0, String s, String s1) {
                this.a = a0;
                this.b = s;
                this.c = s1;
                super(0);
            }

            @NotNull
            public final String a() {
                t t0 = this.a.f.m();
                if(t0 != null) {
                    String s = t0.c(this.b, this.c);
                    return s == null ? "" : s;
                }
                return "";
            }

            @Override  // we.a
            public Object invoke() {
                return this.a();
            }
        }

        return (String)this.a(new co.ab180.airbridge.internal.a.g(this, s, s1), "");
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void c(@Nullable String s) {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class w extends r implements we.a {
            final a a;
            final String b;

            public w(a a0, String s) {
                this.a = a0;
                this.b = s;
                super(0);
            }

            public final void a() {
                s s0 = this.a.f.l();
                if(s0 != null) {
                    s0.c(this.b);
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new w(this, s));
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public boolean c() {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Z"}, k = 3, mv = {1, 4, 3})
        static final class p extends r implements we.a {
            final a a;

            public p(a a0) {
                this.a = a0;
                super(0);
            }

            public final boolean a() {
                co.ab180.airbridge.internal.u.c.a a0 = this.a.f.e();
                return a0 == null ? false : a0.c();
            }

            @Override  // we.a
            public Object invoke() {
                return Boolean.valueOf(this.a());
            }
        }

        return ((Boolean)this.a(new p(this), Boolean.FALSE)).booleanValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.c
    public boolean c(@NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Z"}, k = 3, mv = {1, 4, 3})
        static final class i extends r implements we.a {
            final a a;
            final OnSuccess b;
            final OnFailure c;

            public i(a a0, OnSuccess onSuccess0, OnFailure onFailure0) {
                this.a = a0;
                this.b = onSuccess0;
                this.c = onFailure0;
                super(0);
            }

            public final boolean a() {
                c c0 = this.a.f.g();
                return c0 == null ? false : c0.c(this.b, this.c);
            }

            @Override  // we.a
            public Object invoke() {
                return Boolean.valueOf(this.a());
            }
        }

        return ((Boolean)this.a(new i(this, onSuccess0, onFailure0), Boolean.FALSE)).booleanValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.f
    public boolean c(@NotNull String s, @Nullable OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Z"}, k = 3, mv = {1, 4, 3})
        static final class o extends r implements we.a {
            final a a;
            final String b;
            final OnSuccess c;
            final OnFailure d;

            public o(a a0, String s, OnSuccess onSuccess0, OnFailure onFailure0) {
                this.a = a0;
                this.b = s;
                this.c = onSuccess0;
                this.d = onFailure0;
                super(0);
            }

            public final boolean a() {
                co.ab180.airbridge.internal.u.c.f f0 = this.a.f.j();
                return f0 == null ? false : f0.c(this.b, this.c, this.d);
            }

            @Override  // we.a
            public Object invoke() {
                return Boolean.valueOf(this.a());
            }
        }

        return ((Boolean)this.a(new o(this, s, onSuccess0, onFailure0), Boolean.FALSE)).booleanValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void d() {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.a.c extends r implements we.a {
            final a a;

            public co.ab180.airbridge.internal.a.c(a a0) {
                this.a = a0;
                super(0);
            }

            public final void a() {
                s s0 = this.a.f.l();
                if(s0 != null) {
                    s0.d();
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new co.ab180.airbridge.internal.a.c(this));
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void d(@Nullable String s) {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class x extends r implements we.a {
            final a a;
            final String b;

            public x(a a0, String s) {
                this.a = a0;
                this.b = s;
                super(0);
            }

            public final void a() {
                s s0 = this.a.f.l();
                if(s0 != null) {
                    s0.d(this.b);
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new x(this, s));
    }

    @Override  // co.ab180.airbridge.internal.u.b.f
    public boolean d(@NotNull String s, @NotNull OnSuccess onSuccess0, @Nullable OnFailure onFailure0) {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Z"}, k = 3, mv = {1, 4, 3})
        static final class k extends r implements we.a {
            final a a;
            final String b;
            final OnSuccess c;
            final OnFailure d;

            public k(a a0, String s, OnSuccess onSuccess0, OnFailure onFailure0) {
                this.a = a0;
                this.b = s;
                this.c = onSuccess0;
                this.d = onFailure0;
                super(0);
            }

            public final boolean a() {
                co.ab180.airbridge.internal.u.b.f f0 = this.a.g.f();
                return f0 == null ? false : f0.d(this.b, this.c, this.d);
            }

            @Override  // we.a
            public Object invoke() {
                return Boolean.valueOf(this.a());
            }
        }

        return ((Boolean)this.a(new k(this, s, onSuccess0, onFailure0), Boolean.FALSE)).booleanValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.s
    public void e() {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.a.b extends r implements we.a {
            final a a;

            public co.ab180.airbridge.internal.a.b(a a0) {
                this.a = a0;
                super(0);
            }

            public final void a() {
                s s0 = this.a.f.l();
                if(s0 != null) {
                    s0.e();
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new co.ab180.airbridge.internal.a.b(this));
    }

    @Override  // co.ab180.airbridge.internal.u.c.r
    public void e(@NotNull String s) {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class co.ab180.airbridge.internal.a.r extends r implements we.a {
            final a a;
            final String b;

            public co.ab180.airbridge.internal.a.r(a a0, String s) {
                this.a = a0;
                this.b = s;
                super(0);
            }

            public final void a() {
                co.ab180.airbridge.internal.u.c.r r0 = this.a.f.k();
                if(r0 != null) {
                    r0.e(this.b);
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new co.ab180.airbridge.internal.a.r(this, s));
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public void f() {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class a0 extends r implements we.a {
            final a a;

            public a0(a a0) {
                this.a = a0;
                super(0);
            }

            public final void a() {
                co.ab180.airbridge.internal.u.c.a a0 = this.a.f.e();
                if(a0 != null) {
                    a0.f();
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new a0(this));
    }

    @Override  // co.ab180.airbridge.internal.u.c.t
    public void f(@NotNull String s) {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class n extends r implements we.a {
            final a a;
            final String b;

            public n(a a0, String s) {
                this.a = a0;
                this.b = s;
                super(0);
            }

            public final void a() {
                t t0 = this.a.f.m();
                if(t0 != null) {
                    t0.f(this.b);
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new n(this, s));
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public void g() {
        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "a", "()V"}, k = 3, mv = {1, 4, 3})
        static final class b0 extends r implements we.a {
            final a a;

            public b0(a a0) {
                this.a = a0;
                super(0);
            }

            public final void a() {
                co.ab180.airbridge.internal.u.c.a a0 = this.a.f.e();
                if(a0 != null) {
                    a0.g();
                }
            }

            @Override  // we.a
            public Object invoke() {
                this.a();
                return H.a;
            }
        }

        this.a(new b0(this));
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public void h() {
        co.ab180.airbridge.internal.u.c.a a0 = this.f.e();
        if(a0 != null) {
            a0.h();
        }
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public boolean i() {
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000B\n\u0002\b\u0002\u0010\u0001\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Z"}, k = 3, mv = {1, 4, 3})
        static final class q extends r implements we.a {
            final a a;

            public q(a a0) {
                this.a = a0;
                super(0);
            }

            public final boolean a() {
                co.ab180.airbridge.internal.u.c.a a0 = this.a.f.e();
                return a0 == null ? false : a0.i();
            }

            @Override  // we.a
            public Object invoke() {
                return Boolean.valueOf(this.a());
            }
        }

        return ((Boolean)this.a(new q(this), Boolean.FALSE)).booleanValue();
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public void j() {
        if(!this.p()) {
            return;
        }
        if(this.b.getAndSet(true)) {
            co.ab180.airbridge.internal.b.e.f("Airbridge is already enabled", new Object[0]);
            return;
        }
        e e0 = this.h;
        if(e0 != null) {
            e0.a();
        }
        this.f.c();
        this.g.c();
        co.ab180.airbridge.internal.u.c.a a0 = this.f.e();
        if(a0 != null) {
            a0.j();
        }
        Application application0 = this.m();
        this.c.a(application0, true);
        co.ab180.airbridge.internal.b.e.d("Airbridge is enabled", new Object[0]);
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public void k() {
        co.ab180.airbridge.internal.u.c.a a0 = this.f.e();
        if(a0 != null) {
            a0.k();
        }
    }

    @Override  // co.ab180.airbridge.internal.u.c.a
    public void l() {
        if(!this.p()) {
            return;
        }
        if(!this.b.getAndSet(false)) {
            co.ab180.airbridge.internal.b.e.f("Airbridge is already disabled", new Object[0]);
            return;
        }
        Application application0 = this.m();
        this.c.a(application0, false);
        co.ab180.airbridge.internal.u.c.a a0 = this.f.e();
        if(a0 != null) {
            a0.l();
        }
        this.f.b();
        this.g.b();
        e e0 = this.h;
        if(e0 != null) {
            e0.b();
        }
        co.ab180.airbridge.internal.b.e.d("Airbridge is disabled", new Object[0]);
    }

    private final Application m() {
        return (Application)this.d.getValue();
    }

    // 去混淆评级： 低(20)
    @Nullable
    public final AirbridgeLifecycleIntegration n() {
        return this.p() ? this.o().getLifecycleIntegration() : null;
    }

    private final AirbridgeOption o() {
        return (AirbridgeOption)this.e.getValue();
    }

    private final boolean p() {
        boolean z = this.a.get();
        if(!z) {
            co.ab180.airbridge.internal.b.e.f("Airbridge is not initialized", new Object[0]);
        }
        return z;
    }

    public final boolean q() {
        if(this.p()) {
            boolean z = this.b.get();
            if(!z) {
                co.ab180.airbridge.internal.b.e.f("Airbridge is not enabled", new Object[0]);
            }
            return z;
        }
        return false;
    }
}

