package t5;

import androidx.lifecycle.C;
import androidx.lifecycle.f;
import androidx.lifecycle.s;
import androidx.lifecycle.t;

public final class h extends t {
    public static final h b;
    public static final g c;

    static {
        h.b = new h();  // 初始化器: Landroidx/lifecycle/t;-><init>()V
        h.c = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // androidx.lifecycle.t
    public final void a(C c0) {
        if(!(c0 instanceof f)) {
            throw new IllegalArgumentException((c0 + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
        }
        ((f)c0).c(h.c);
        ((f)c0).onStart(h.c);
        ((f)c0).onResume(h.c);
    }

    @Override  // androidx.lifecycle.t
    public final s b() {
        return s.e;
    }

    @Override  // androidx.lifecycle.t
    public final void c(C c0) {
    }

    @Override
    public final String toString() {
        return "coil.request.GlobalLifecycle";
    }
}

