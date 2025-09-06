package androidx.lifecycle;

import Qc.l;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Fragment;
import android.os.Build.VERSION;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Landroidx/lifecycle/b0;", "Landroid/app/Fragment;", "<init>", "()V", "androidx/lifecycle/b", "a", "androidx/lifecycle/Z", "lifecycle-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public class b0 extends Fragment {
    public static final class a implements Application.ActivityLifecycleCallbacks {
        @NotNull
        public static final a0 Companion;

        static {
            a.Companion = new a0();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

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
        public void onActivityPostCreated(@NotNull Activity activity0, @Nullable Bundle bundle0) {
            q.g(activity0, "activity");
            Z.a(activity0, r.ON_CREATE);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPostResumed(@NotNull Activity activity0) {
            q.g(activity0, "activity");
            Z.a(activity0, r.ON_RESUME);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPostStarted(@NotNull Activity activity0) {
            q.g(activity0, "activity");
            Z.a(activity0, r.ON_START);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(@NotNull Activity activity0) {
            q.g(activity0, "activity");
            Z.a(activity0, r.ON_DESTROY);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPrePaused(@NotNull Activity activity0) {
            q.g(activity0, "activity");
            Z.a(activity0, r.ON_PAUSE);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPreStopped(@NotNull Activity activity0) {
            q.g(activity0, "activity");
            Z.a(activity0, r.ON_STOP);
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity0) {
            q.g(activity0, "activity");
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity0, @NotNull Bundle bundle0) {
            q.g(activity0, "activity");
            q.g(bundle0, "bundle");
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity0) {
            q.g(activity0, "activity");
        }

        @Override  // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity0) {
            q.g(activity0, "activity");
        }

        public static final void registerIn(@NotNull Activity activity0) {
            a.Companion.getClass();
            q.g(activity0, "activity");
            l.k(activity0, new a());
        }
    }

    public b a;
    public static final int b;

    public final void a(r r0) {
        if(Build.VERSION.SDK_INT < 29) {
            Activity activity0 = this.getActivity();
            q.f(activity0, "getActivity(...)");
            Z.a(activity0, r0);
        }
    }

    @Override  // android.app.Fragment
    public final void onActivityCreated(Bundle bundle0) {
        super.onActivityCreated(bundle0);
        this.a(r.ON_CREATE);
    }

    @Override  // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.a(r.ON_DESTROY);
        this.a = null;
    }

    @Override  // android.app.Fragment
    public final void onPause() {
        super.onPause();
        this.a(r.ON_PAUSE);
    }

    @Override  // android.app.Fragment
    public final void onResume() {
        super.onResume();
        b b0 = this.a;
        if(b0 != null) {
            ((T)b0.b).a();
        }
        this.a(r.ON_RESUME);
    }

    @Override  // android.app.Fragment
    public final void onStart() {
        super.onStart();
        b b0 = this.a;
        if(b0 != null) {
            T t0 = (T)b0.b;
            int v = t0.a + 1;
            t0.a = v;
            if(v == 1 && t0.d) {
                t0.f.f(r.ON_START);
                t0.d = false;
            }
        }
        this.a(r.ON_START);
    }

    @Override  // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.a(r.ON_STOP);
    }
}

