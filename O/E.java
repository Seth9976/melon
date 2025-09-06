package O;

import I.X0;
import I.u0;
import Q.K;
import Q.O;
import X0.b;
import androidx.compose.foundation.lazy.layout.Q;
import androidx.compose.foundation.lazy.layout.U;
import ie.H;
import ye.a;

public final class e implements Q {
    public final int a;
    public final boolean b;
    public final X0 c;

    public e(X0 x00, boolean z, int v) {
        this.a = v;
        this.c = x00;
        this.b = z;
        super();
    }

    @Override  // androidx.compose.foundation.lazy.layout.Q
    public final int a() {
        return this.a == 0 ? -((F)this.c).h().l + ((F)this.c).h().q : -((K)this.c).k().f + ((K)this.c).k().d;
    }

    @Override  // androidx.compose.foundation.lazy.layout.Q
    public final float b() {
        if(this.a != 0) {
            return (float)O.a(((K)this.c).k(), ((K)this.c).l());
        }
        int v = ((F)this.c).d.a();
        int v1 = ((F)this.c).d.b();
        return ((F)this.c).d() ? ((float)(v * 500 + v1)) + 100.0f : ((float)(v * 500 + v1));
    }

    @Override  // androidx.compose.foundation.lazy.layout.Q
    public final b c() {
        if(this.a != 0) {
            K k0 = (K)this.c;
            return this.b ? new b(k0.l(), 1) : new b(1, k0.l());
        }
        return this.b ? new b(-1, 1) : new b(1, -1);
    }

    @Override  // androidx.compose.foundation.lazy.layout.Q
    public final int d() {
        if(this.a != 0) {
            K k0 = (K)this.c;
            return k0.k().e == u0.a ? ((int)(k0.k().e() & 0xFFFFFFFFL)) : ((int)(k0.k().e() >> 0x20));
        }
        F f0 = (F)this.c;
        return f0.h().p == u0.a ? ((int)(f0.h().e() & 0xFFFFFFFFL)) : ((int)(f0.h().e() >> 0x20));
    }

    @Override  // androidx.compose.foundation.lazy.layout.Q
    public final float e() {
        return this.a == 0 ? ((float)(((F)this.c).d.a() * 500 + ((F)this.c).d.b())) : ((float)a.y(((K)this.c)));
    }

    @Override  // androidx.compose.foundation.lazy.layout.Q
    public final Object f(int v, U u0) {
        H h0 = H.a;
        X0 x00 = this.c;
        if(this.a != 0) {
            Object object0 = K.t(((K)x00), v, u0);
            return object0 == ne.a.a ? object0 : h0;
        }
        Object object1 = ((F)x00).j(v, 0, u0);
        return object1 == ne.a.a ? object1 : h0;
    }
}

