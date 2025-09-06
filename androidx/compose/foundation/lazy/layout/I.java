package androidx.compose.foundation.lazy.layout;

import L.a;
import androidx.appcompat.app.o;

public final class i {
    public final int a;
    public final int b;

    public i(int v, int v1) {
        this.a = v;
        this.b = v1;
        if(v < 0) {
            a.a("negative start index");
        }
        if(v1 < v) {
            a.a("end index greater than start");
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof i)) {
            return false;
        }
        return this.a == ((i)object0).a ? this.b == ((i)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Interval(start=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", end=");
        return o.q(stringBuilder0, this.b, ')');
    }
}

