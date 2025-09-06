package gc;

import Sb.a;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.media3.common.d;
import b3.K;
import we.k;

public final class q implements k {
    public final int a;
    public final int b;
    public final long c;
    public final int d;
    public final a e;

    public q(int v, int v1, long v2, int v3, a a0) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
        this.e = a0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        kotlin.jvm.internal.q.g(((d)object0), "$this$updateStateAndInvalidate");
        ((d)object0).d = this.a;
        ((d)object0).y = this.b;
        ((d)object0).B = this.c;
        ((d)object0).b = false;
        ((d)object0).c = this.d;
        ((d)object0).e = this.e == null ? null : new K(this.e.getMessage(), this.e.getCause(), 1000, Bundle.EMPTY, SystemClock.elapsedRealtime());
        return (d)object0;
    }
}

