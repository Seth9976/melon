package G;

import androidx.compose.runtime.M0;
import androidx.compose.runtime.O0;
import ie.H;
import kotlin.jvm.internal.r;
import we.k;
import ye.a;

public final class p0 extends r implements k {
    public final t0 f;
    public final float g;

    public p0(t0 t00, float f) {
        this.f = t00;
        this.g = f;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        long v = ((Number)object0).longValue();
        t0 t00 = this.f;
        boolean z = t00.g();
        M0 m00 = t00.g;
        if(!z) {
            if(m00.m() == 0x8000000000000000L) {
                m00.n(v);
                ((O0)t00.a.a).setValue(Boolean.TRUE);
            }
            long v1 = v - m00.m();
            float f = this.g;
            int v2 = Float.compare(f, 0.0f);
            if(v2 != 0) {
                v1 = a.W(((double)v1) / ((double)f));
            }
            if(t00.b == null) {
                t00.f.n(v1);
            }
            t00.h(v1, v2 == 0);
        }
        return H.a;
    }
}

