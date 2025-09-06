package gc;

import androidx.media3.common.d;
import b3.E;
import kotlin.jvm.internal.q;
import we.k;

public final class o implements k {
    public final long a;
    public final y b;
    public final E c;
    public final long d;

    public o(long v, y y0, E e0, long v1) {
        this.a = v;
        this.b = y0;
        this.c = e0;
        this.d = v1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((d)object0), "$this$updateStateAndInvalidate");
        long v = this.a;
        if(v != 0x8000000000000001L) {
            ((d)object0).b(this.b.F0(this.c, v));
        }
        ((d)object0).B = this.d;
        ((d)object0).d = 3;
        return (d)object0;
    }
}

