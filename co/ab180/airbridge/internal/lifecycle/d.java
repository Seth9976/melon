package co.ab180.airbridge.internal.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;
import co.ab180.airbridge.Airbridge;
import co.ab180.airbridge.AirbridgeExKt;
import co.ab180.airbridge.AirbridgeLifecycleIntegration;
import co.ab180.airbridge.internal.e0.l;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\b\u0002\u0010\u000E\u001A\u00020\rH\u0002¢\u0006\u0004\b\t\u0010\u000FJ!\u0010\u0012\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u0018\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u0019\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u0015J\u001F\u0010\u001B\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u001A\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u001B\u0010\u0013R\u0014\u0010\u001E\u001A\u00020\u001C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001DR\u0014\u0010 \u001A\u00020\u001C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001F\u0010\u001DR\u0016\u0010$\u001A\u00020!8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001A\u00020!8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b%\u0010#¨\u0006\'"}, d2 = {"Lco/ab180/airbridge/internal/lifecycle/d;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "Lco/ab180/airbridge/internal/lifecycle/b$b;", "type", "Landroid/app/Activity;", "activity", "Lie/H;", "a", "(Lco/ab180/airbridge/internal/lifecycle/b$b;Landroid/app/Activity;)V", "Landroid/content/Intent;", "intent", "", "checkReferrer", "(Lco/ab180/airbridge/internal/lifecycle/b$b;Landroid/content/Intent;Z)V", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityDestroyed", "(Landroid/app/Activity;)V", "onActivityStarted", "onActivityStopped", "onActivityResumed", "onActivityPaused", "outState", "onActivitySaveInstanceState", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "appInLaunched", "b", "appInForegrounded", "", "c", "I", "activityCreatedCount", "d", "activityStartCount", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class d implements Application.ActivityLifecycleCallbacks {
    private final AtomicBoolean a;
    private final AtomicBoolean b;
    private int c;
    private int d;

    public d() {
        this.a = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
    }

    private final void a(b b$b0, Activity activity0) {
        AirbridgeLifecycleIntegration airbridgeLifecycleIntegration0 = AirbridgeExKt.getLifecycleIntegration(Airbridge.INSTANCE);
        String s = null;
        String s1 = airbridgeLifecycleIntegration0 == null ? null : airbridgeLifecycleIntegration0.getDataString(activity0);
        if(s1 != null && s1.length() != 0) {
            s = s1;
        }
        if(s != null) {
            c c0 = new c(b$b0, "android.intent.action.VIEW", s);
            co.ab180.airbridge.internal.lifecycle.b.b.a(c0);
            Intent intent0 = activity0.getIntent();
            if(intent0 != null) {
                l.b(intent0);
            }
            return;
        }
        this.a(b$b0, activity0.getIntent(), true);
    }

    private final void a(b b$b0, Intent intent0, boolean z) {
        c c0 = new c(b$b0, intent0, z, 0L, 8, null);
        co.ab180.airbridge.internal.lifecycle.b.b.a(c0);
        if(intent0 != null) {
            l.b(intent0);
        }
    }

    public static void a(d d0, b b$b0, Intent intent0, boolean z, int v, Object object0) {
        if((v & 4) != 0) {
            z = false;
        }
        d0.a(b$b0, intent0, z);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity0, @Nullable Bundle bundle0) {
        b b$b0;
        ++this.c;
        if(this.a.get() && !this.b.get() && !activity0.isChangingConfigurations()) {
            this.b.set(true);
            b$b0 = b.c;
        }
        else if(this.c == 1 && !this.a.getAndSet(true) && !this.b.getAndSet(true) && !activity0.isChangingConfigurations()) {
            b$b0 = b.a;
        }
        else {
            return;
        }
        this.a(b$b0, activity0);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity0) {
        int v = this.c - 1;
        this.c = v;
        if(v <= 0 && !activity0.isChangingConfigurations()) {
            Intent intent0 = activity0.getIntent();
            d.a(this, b.d, intent0, false, 4, null);
        }
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity0) {
        if(this.a.get() && !this.b.getAndSet(true) && !activity0.isChangingConfigurations()) {
            this.a(b.c, activity0);
        }
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity0, @NotNull Bundle bundle0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity0) {
        ++this.d;
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity0) {
        int v = this.d - 1;
        this.d = v;
        if(v <= 0 && this.b.get() && !activity0.isChangingConfigurations()) {
            this.b.set(false);
            Intent intent0 = activity0.getIntent();
            d.a(this, b.b, intent0, false, 4, null);
        }
    }
}

