package qd;

import com.iloen.melon.custom.SeekBarWithRange;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class u implements k {
    public final long a;
    public final long b;
    public final long c;
    public final long d;

    public u(long v, long v1, long v2, long v3) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((SeekBarWithRange)object0), "seekBarView");
        ((SeekBarWithRange)object0).setMax(((int)this.a));
        ((SeekBarWithRange)object0).setProgress(((int)this.b));
        ((SeekBarWithRange)object0).b = this.c;
        ((SeekBarWithRange)object0).c = this.d;
        ((SeekBarWithRange)object0).invalidate();
        return H.a;
    }
}

