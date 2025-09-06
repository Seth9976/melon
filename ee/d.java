package ee;

import E9.w;
import androidx.lifecycle.m0;
import de.h;
import k8.g;

public final class d extends m0 {
    public final g a;
    public final j b;

    public d(g g0, j j0) {
        this.a = g0;
        this.b = j0;
    }

    @Override  // androidx.lifecycle.m0
    public final void onCleared() {
        super.onCleared();
        ((h)((g)(((e)w.s(this.a, e.class)))).c.get()).a();
    }
}

