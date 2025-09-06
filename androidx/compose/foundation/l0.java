package androidx.compose.foundation;

import androidx.compose.runtime.K0;
import kotlin.jvm.internal.r;
import we.a;

public final class L0 extends r implements a {
    public final int f;
    public final N0 g;

    public L0(N0 n00, int v) {
        this.f = v;
        this.g = n00;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        return this.f == 0 ? ((float)this.g.a.g()) : ((float)((K0)this.g.a.d).m());
    }
}

