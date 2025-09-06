package f1;

import P4.a;
import V3.d;
import androidx.appcompat.app.o;

public final class t implements g {
    public final int a;
    public final int b;

    public t(int v, int v1) {
        this.a = v;
        this.b = v1;
    }

    @Override  // f1.g
    public final void a(d d0) {
        boolean z = d0.d != -1;
        A3.g g0 = (A3.g)d0.f;
        if(z) {
            d0.d = -1;
            d0.e = -1;
        }
        int v = g0.l();
        int v1 = a.j(this.a, 0, v);
        int v2 = g0.l();
        int v3 = a.j(this.b, 0, v2);
        if(v1 != v3) {
            if(v1 < v3) {
                d0.h(v1, v3);
                return;
            }
            d0.h(v3, v1);
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof t)) {
            return false;
        }
        return this.a == ((t)object0).a ? this.b == ((t)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.a * 0x1F + this.b;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SetComposingRegionCommand(start=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", end=");
        return o.q(stringBuilder0, this.b, ')');
    }
}

