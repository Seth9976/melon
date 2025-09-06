package O2;

import androidx.appcompat.app.o;

public final class h implements a {
    public final int a;

    public h(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof h ? this.a == ((h)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return o.q(new StringBuilder("ResourceColorProvider(resId="), this.a, ')');
    }
}

