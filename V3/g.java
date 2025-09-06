package v3;

import I6.H;
import androidx.media3.common.b;
import androidx.media3.exoplayer.e;

public final class g implements Comparable {
    public final boolean a;
    public final boolean b;

    public g(b b0, int v) {
        this.a = (b0.e & 1) != 0;
        this.b = e.j(v, false);
    }

    @Override
    public final int compareTo(Object object0) {
        return H.a.c(this.b, ((g)object0).b).c(this.a, ((g)object0).a).e();
    }
}

