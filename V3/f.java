package v3;

import androidx.media3.common.b;
import androidx.media3.exoplayer.e;
import b3.q0;

public final class f extends l implements Comparable {
    public final int e;
    public final int f;

    public f(int v, q0 q00, int v1, h h0, int v2) {
        super(v, q00, v1);
        this.e = e.j(v2, h0.n0);
        b b0 = this.d;
        int v3 = b0.u;
        int v4 = -1;
        if(v3 != -1) {
            int v5 = b0.v;
            if(v5 != -1) {
                v4 = v3 * v5;
            }
        }
        this.f = v4;
    }

    @Override  // v3.l
    public final int a() {
        return this.e;
    }

    @Override  // v3.l
    public final boolean b(l l0) {
        f f0 = (f)l0;
        return false;
    }

    @Override
    public final int compareTo(Object object0) {
        return Integer.compare(this.f, ((f)object0).f);
    }
}

