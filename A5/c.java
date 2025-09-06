package a5;

import U4.d;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

public abstract class c implements e {
    public final b5.e a;

    public c(b5.e e0) {
        q.g(e0, "tracker");
        super();
        this.a = e0;
    }

    @Override  // a5.e
    public final Flow a(d d0) {
        q.g(d0, "constraints");
        return FlowKt.callbackFlow(new b(this, null));
    }

    // 去混淆评级： 低(20)
    @Override  // a5.e
    public final boolean c(d5.q q0) {
        return this.b(q0) && this.e(this.a.a());
    }

    public abstract int d();

    public abstract boolean e(Object arg1);
}

