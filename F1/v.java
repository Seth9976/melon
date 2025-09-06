package f1;

import P4.a;
import V3.d;
import androidx.appcompat.app.o;

public final class v implements g {
    public final int a;
    public final int b;

    public v(int v, int v1) {
        this.a = v;
        this.b = v1;
    }

    @Override  // f1.g
    public final void a(d d0) {
        int v = ((A3.g)d0.f).l();
        int v1 = a.j(this.a, 0, v);
        int v2 = ((A3.g)d0.f).l();
        int v3 = a.j(this.b, 0, v2);
        if(v1 < v3) {
            d0.i(v1, v3);
            return;
        }
        d0.i(v3, v1);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof v)) {
            return false;
        }
        return this.a == ((v)object0).a ? this.b == ((v)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.a * 0x1F + this.b;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SetSelectionCommand(start=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", end=");
        return o.q(stringBuilder0, this.b, ')');
    }
}

