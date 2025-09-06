package v1;

import ie.H;
import kotlin.jvm.internal.r;
import we.a;

public final class b extends r implements a {
    public final m f;
    public final a g;
    public final q h;
    public final String i;
    public final r1.m j;

    public b(m m0, a a0, q q0, String s, r1.m m1) {
        this.f = m0;
        this.g = a0;
        this.h = q0;
        this.i = s;
        this.j = m1;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        this.f.j(this.g, this.h, this.i, this.j);
        return H.a;
    }
}

