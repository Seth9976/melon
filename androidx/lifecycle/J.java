package androidx.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class j implements Application.ActivityLifecycleCallbacks {
    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity0, @Nullable Bundle bundle0) {
        q.g(activity0, "activity");
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity0) {
        q.g(activity0, "activity");
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity0) {
        q.g(activity0, "activity");
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity0) {
        q.g(activity0, "activity");
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity0, @NotNull Bundle bundle0) {
        q.g(activity0, "activity");
        q.g(bundle0, "outState");
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity0) {
        q.g(activity0, "activity");
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity0) {
        q.g(activity0, "activity");
    }
}

