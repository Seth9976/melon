package ie;

import java.io.Serializable;

public final class g implements j, Serializable {
    public final Object a;

    public g(Object object0) {
        this.a = object0;
    }

    @Override  // ie.j
    public final Object getValue() {
        return this.a;
    }

    @Override
    public final String toString() {
        return String.valueOf(this.a);
    }
}

