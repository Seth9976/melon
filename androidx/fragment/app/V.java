package androidx.fragment.app;

import android.view.View;

public final class v extends P {
    public final P a;
    public final w b;

    public v(w w0, P p0) {
        this.b = w0;
        this.a = p0;
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.fragment.app.P
    public final View b(int v) {
        return this.a.c() ? this.a.b(v) : this.b.onFindViewById(v);
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.fragment.app.P
    public final boolean c() {
        return this.a.c() || this.b.onHasView();
    }
}

