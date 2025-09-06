package O;

import L.a;
import androidx.compose.foundation.lazy.layout.D;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.w;

public final class x {
    public final int a;
    public final a0 b;
    public final a0 c;
    public boolean d;
    public Object e;
    public final D f;

    public x(int v, int v1, int v2) {
        this.a = v2;
        if(v2 != 1) {
            super();
            this.b = w.p(v);
            this.c = w.p(v1);
            this.f = new D(v, 30, 100);
            return;
        }
        super();
        this.b = w.p(v);
        this.c = w.p(v1);
        this.f = new D(v, 90, 200);
    }

    public final int a() {
        return ((K0)this.b).m();
    }

    public final int b() {
        return ((K0)this.c).m();
    }

    public final void c(int v, int v1) {
        if(this.a != 0) {
            if(((float)v) < 0.0f) {
                a.a("Index should be non-negative");
            }
            ((K0)this.b).n(v);
            this.f.a(v);
            ((K0)this.c).n(v1);
            return;
        }
        if(((float)v) < 0.0f) {
            a.a(("Index should be non-negative (" + v + ')'));
        }
        ((K0)this.b).n(v);
        this.f.a(v);
        ((K0)this.c).n(v1);
    }
}

