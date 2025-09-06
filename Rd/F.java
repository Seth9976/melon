package rd;

import N0.v;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;
import we.n;

public final class f implements k {
    public final int a;
    public final n b;

    public f(n n0, int v) {
        this.a = v;
        this.b = n0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((v)object0), "coordinates");
            long v = ((v)object0).j0(0L);
            this.b.invoke(Float.intBitsToFloat(((int)(v >> 0x20))), Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))));
            return H.a;
        }
        q.g(((v)object0), "coordinates");
        long v1 = ((v)object0).j0(0L);
        this.b.invoke(Float.intBitsToFloat(((int)(v1 >> 0x20))), Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))));
        return H.a;
    }
}

