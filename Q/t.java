package Q;

import X0.a;
import X0.l;
import X0.x;
import ie.H;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineScope;
import we.k;

public final class t extends r implements k {
    public final boolean f;
    public final K g;
    public final CoroutineScope h;

    public t(boolean z, K k0, CoroutineScope coroutineScope0) {
        this.f = z;
        this.g = k0;
        this.h = coroutineScope0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        CoroutineScope coroutineScope0 = this.h;
        K k0 = this.g;
        if(this.f) {
            a a0 = new a(null, new s(k0, coroutineScope0, 0));
            ((l)(((x)object0))).g(X0.k.x, a0);
            a a1 = new a(null, new s(k0, coroutineScope0, 1));
            ((l)(((x)object0))).g(X0.k.z, a1);
            return H.a;
        }
        a a2 = new a(null, new s(k0, coroutineScope0, 2));
        ((l)(((x)object0))).g(X0.k.y, a2);
        a a3 = new a(null, new s(k0, coroutineScope0, 3));
        ((l)(((x)object0))).g(X0.k.A, a3);
        return H.a;
    }
}

