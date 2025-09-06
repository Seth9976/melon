package Cc;

import G.e;
import androidx.compose.runtime.M0;
import ie.H;
import we.k;

public final class i implements k {
    public final float a;
    public final long b;
    public final M0 c;

    public i(float f, long v, M0 m00) {
        this.a = f;
        this.b = v;
        this.c = m00;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        float f = ((Number)((e)object0).d()).floatValue();
        this.c.n(((long)((f - 1.0f) / (this.a - 1.0f) * ((float)this.b))));
        return H.a;
    }
}

