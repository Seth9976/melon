package Dc;

import ie.H;
import kotlin.jvm.internal.q;
import we.k;
import y0.N;

public final class m implements k {
    public final int a;
    public final u b;

    public m(u u0, int v) {
        this.a = v;
        this.b = u0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((N)object0), "$this$graphicsLayer");
            ((N)object0).I(((Number)this.b.p.d()).floatValue());
            return H.a;
        }
        q.g(((N)object0), "$this$graphicsLayer");
        ((N)object0).I(this.b.b());
        return H.a;
    }
}

