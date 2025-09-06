package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.l;
import ie.H;
import kotlin.jvm.internal.r;
import r0.q;
import we.a;
import we.n;

public final class y extends r implements n {
    public final a f;
    public final q g;
    public final I h;
    public final n i;

    public y(a a0, q q0, I i0, n n0, int v) {
        this.f = a0;
        this.g = q0;
        this.h = i0;
        this.i = n0;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Number)object1).intValue();
        j.d(this.f, this.g, this.h, this.i, ((l)object0), 1);
        return H.a;
    }
}

