package kotlinx.coroutines.flow;

import we.k;

public final class a implements k {
    public final long a;

    public a(long v) {
        this.a = v;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return FlowKt__DelayKt.a(this.a, object0);
    }
}

