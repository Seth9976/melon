package androidx.viewpager2.adapter;

import androidx.lifecycle.B;
import androidx.lifecycle.D;
import androidx.lifecycle.r;

public final class e implements B {
    public final f a;

    public e(f f0) {
        this.a = f0;
    }

    @Override  // androidx.lifecycle.B
    public final void onStateChanged(D d0, r r0) {
        this.a.b(false);
    }
}

