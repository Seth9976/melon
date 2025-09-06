package N4;

import androidx.transition.Transition;

public final class u implements S {
    public final Runnable a;

    public u(Runnable runnable0) {
        this.a = runnable0;
    }

    @Override  // N4.S
    public final void a() {
    }

    @Override  // N4.S
    public final void d() {
    }

    @Override  // N4.S
    public final void e(Transition transition0) {
    }

    @Override  // N4.S
    public final void f(Transition transition0) {
        this.a.run();
    }

    @Override  // N4.S
    public final void g(Transition transition0) {
    }
}

