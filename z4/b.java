package Z4;

import androidx.appcompat.app.o;

public final class b extends c {
    public final int a;

    public b(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b ? this.a == ((b)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return o.q(new StringBuilder("ConstraintsNotMet(reason="), this.a, ')');
    }
}

