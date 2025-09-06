package P;

import androidx.compose.foundation.lazy.layout.B;
import androidx.compose.foundation.lazy.layout.z;
import java.util.List;
import r1.a;
import r1.m;

public final class o implements B {
    public final j a;
    public final z b;
    public final int c;
    public final z d;
    public final F e;
    public final boolean f;
    public final int g;
    public final int h;
    public final long i;

    public o(j j0, z z0, int v, F f0, boolean z1, int v1, int v2, long v3) {
        this.d = z0;
        this.e = f0;
        this.f = z1;
        this.g = v1;
        this.h = v2;
        this.i = v3;
        this.a = j0;
        this.b = z0;
        this.c = v;
    }

    public final t a(int v, long v1, int v2, int v3, int v4) {
        int v5;
        Object object0 = this.a.c(v);
        Object object1 = this.a.b.m(v);
        List list0 = this.b.a(v, v1);
        if(a.f(v1)) {
            v5 = a.j(v1);
        }
        else {
            if(!a.e(v1)) {
                L.a.a("does not have fixed height");
            }
            v5 = a.i(v1);
        }
        m m0 = this.d.b.getLayoutDirection();
        return new t(v, object0, this.f, v5, v4, m0, this.g, this.h, list0, this.i, object1, this.e.m, v1, v2, v3);
    }
}

