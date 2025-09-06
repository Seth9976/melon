package J2;

import P4.a;
import U4.F;
import androidx.compose.runtime.l;
import ie.H;
import kotlin.jvm.internal.r;
import m0.b;
import we.n;

public final class h extends r implements n {
    public final int f;
    public final B2.n g;
    public final int h;
    public final int i;
    public final b j;
    public final int k;

    public h(B2.n n0, int v, int v1, b b0, int v2, int v3, int v4) {
        this.f = v4;
        this.g = n0;
        this.h = v;
        this.i = v1;
        this.j = b0;
        this.k = v3;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.f != 0) {
            ((Number)object1).intValue();
            F.f(this.g, this.h, this.i, this.j, ((l)object0), 0xC01, this.k);
            return H.a;
        }
        ((Number)object1).intValue();
        a.a(this.g, this.h, this.i, this.j, ((l)object0), 0xC01, this.k);
        return H.a;
    }
}

