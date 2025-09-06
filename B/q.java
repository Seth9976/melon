package b;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

public final class q implements OnBackAnimationCallback {
    public final o a;
    public final o b;
    public final p c;
    public final p d;

    public q(o o0, o o1, p p0, p p1) {
        this.a = o0;
        this.b = o1;
        this.c = p0;
        this.d = p1;
    }

    @Override  // android.window.OnBackAnimationCallback
    public final void onBackCancelled() {
        this.d.invoke();
    }

    @Override  // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.c.invoke();
    }

    @Override  // android.window.OnBackAnimationCallback
    public final void onBackProgressed(BackEvent backEvent0) {
        kotlin.jvm.internal.q.g(backEvent0, "backEvent");
        a a0 = new a(backEvent0);
        this.b.invoke(a0);
    }

    @Override  // android.window.OnBackAnimationCallback
    public final void onBackStarted(BackEvent backEvent0) {
        kotlin.jvm.internal.q.g(backEvent0, "backEvent");
        a a0 = new a(backEvent0);
        this.a.invoke(a0);
    }
}

