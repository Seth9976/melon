package m1;

import Ac.U;
import E4.e;
import E4.g;
import F4.a;
import android.os.Bundle;
import androidx.lifecycle.F;
import androidx.lifecycle.s;
import androidx.lifecycle.t;

public final class f implements g {
    public final F a;
    public final E4.f b;

    public f() {
        F f0 = new F(this, false);
        this.a = f0;
        E4.f f1 = new E4.f(new a(this, new U(this, 14)));
        f1.a(new Bundle());
        this.b = f1;
        f0.h(s.e);
    }

    @Override  // androidx.lifecycle.D
    public final t getLifecycle() {
        return this.a;
    }

    @Override  // E4.g
    public final e getSavedStateRegistry() {
        return this.b.b;
    }
}

