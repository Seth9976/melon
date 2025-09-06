package androidx.compose.foundation.lazy.layout;

import N0.j0;
import Q0.P;
import androidx.compose.runtime.H;
import kotlin.jvm.internal.r;
import we.k;
import y8.s;

public final class w extends r implements k {
    public final I f;
    public final u g;
    public final j0 h;
    public final b0 i;

    public w(I i0, u u0, j0 j00, b0 b00) {
        this.f = i0;
        this.g = u0;
        this.h = j00;
        this.i = b00;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = (H)object0;
        this.f.c = new s(this.g, this.h, this.i);
        return new P(this.f, 3);
    }
}

