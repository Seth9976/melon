package j5;

import Ac.F2;
import C0.c;
import android.graphics.drawable.Drawable;
import i5.k;
import kotlinx.coroutines.flow.FlowKt;
import u5.h;
import v5.b;

public final class j implements h, b {
    public final l a;

    public j(l l0) {
        this.a = l0;
        super();
    }

    @Override  // v5.b
    public void a(Drawable drawable0) {
    }

    @Override  // v5.b
    public void b(Drawable drawable0) {
        c c0 = drawable0 == null ? null : this.a.a(drawable0);
        this.a.b(new e(c0));
    }

    @Override  // u5.h
    public Object c(k k0) {
        return FlowKt.first(new F2(this.a.b, 14), k0);
    }

    @Override  // v5.b
    public void d(Drawable drawable0) {
    }
}

