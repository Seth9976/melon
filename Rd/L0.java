package rd;

import G.e;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;
import y0.N;

public final class l0 implements k {
    public final int a;
    public final e b;

    public l0(e e0, int v) {
        this.a = v;
        this.b = e0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((N)object0), "$this$graphicsLayer");
            ((N)object0).a(((Number)this.b.d()).floatValue());
            return H.a;
        }
        q.g(((N)object0), "$this$graphicsLayer");
        ((N)object0).a(((Number)this.b.d()).floatValue());
        return H.a;
    }
}

