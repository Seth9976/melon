package M7;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import ie.H;
import kotlin.jvm.internal.q;
import o9.b;

public final class d0 implements Application.ActivityLifecycleCallbacks {
    public static final d0 a;
    public static boolean b;
    public static b c;

    static {
        d0.a = new d0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity0, Bundle bundle0) {
        q.g(activity0, "activity");
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity0) {
        q.g(activity0, "activity");
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity0) {
        q.g(activity0, "activity");
        b b0 = d0.c;
        if(b0 != null) {
            b0.u(2);
        }
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity0) {
        H h0;
        q.g(activity0, "activity");
        b b0 = d0.c;
        if(b0 == null) {
            h0 = null;
        }
        else {
            b0.u(1);
            h0 = H.a;
        }
        if(h0 == null) {
            d0.b = true;
        }
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity0, Bundle bundle0) {
        q.g(activity0, "activity");
        q.g(bundle0, "outState");
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity0) {
        q.g(activity0, "activity");
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity0) {
        q.g(activity0, "activity");
    }
}

