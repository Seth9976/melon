package Y;

import J0.h;
import Vd.w;
import a1.Q;
import a1.y;
import ie.j;
import kotlin.jvm.internal.r;
import we.a;

public final class o extends r implements a {
    public final w f;
    public final int g;
    public final int h;
    public final h i;
    public final Object j;

    public o(w w0, int v, int v1, h h0, j j0) {
        this.f = w0;
        this.g = v;
        this.h = v1;
        this.i = h0;
        this.j = j0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        w w0 = this.f;
        Q q0 = (Q)w0.e;
        int v = ((Number)((j)this.j).getValue()).intValue();
        boolean z = this.i.b;
        boolean z1 = this.i.j() == i.a;
        int v1 = this.g;
        long v2 = q0.j(v1);
        y y0 = q0.b;
        int v3 = (int)(v2 >> 0x20);
        int v4 = y0.d(v3);
        int v5 = y0.f;
        if(v4 != v) {
            v3 = v < v5 ? q0.g(v) : q0.g(v5 - 1);
        }
        int v6 = (int)(v2 & 0xFFFFFFFFL);
        if(y0.d(v6) != v) {
            v6 = v < v5 ? y0.c(v, false) : y0.c(v5 - 1, false);
        }
        int v7 = this.h;
        if(v3 == v7) {
            return w0.d(v6);
        }
        if(v6 == v7) {
            return w0.d(v3);
        }
        if((z ^ z1) != 0) {
            return v1 > v6 ? w0.d(v6) : w0.d(v3);
        }
        if(v1 >= v3) {
            v3 = v6;
        }
        return w0.d(v3);
    }
}

