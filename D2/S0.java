package D2;

import androidx.appcompat.app.o;

public final class s0 {
    public final int a;

    public s0(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof s0 && this.a == ((s0)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return o.q(new StringBuilder("LayoutInfo(layoutId="), this.a, ')');
    }
}

