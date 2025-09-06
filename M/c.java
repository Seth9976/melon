package m;

import java.util.Map.Entry;

public final class c implements Map.Entry {
    public final Object a;
    public final Object b;
    public c c;
    public c d;

    public c(Object object0, Object object1) {
        this.a = object0;
        this.b = object1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof c ? this.a.equals(((c)object0).a) && this.b.equals(((c)object0).b) : false;
    }

    @Override
    public final Object getKey() {
        return this.a;
    }

    @Override
    public final Object getValue() {
        return this.b;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() ^ this.b.hashCode();
    }

    @Override
    public final Object setValue(Object object0) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    @Override
    public final String toString() {
        return this.a + "=" + this.b;
    }
}

