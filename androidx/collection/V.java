package androidx.collection;

import java.util.Map.Entry;
import kotlin.jvm.internal.q;
import xe.a;

public class v implements Map.Entry, a {
    public final int a;
    public final Object b;
    public final Object c;

    public v(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override
    public boolean equals(Object object0) {
        if(this.a != 1) {
            return super.equals(object0);
        }
        Map.Entry map$Entry0 = object0 instanceof Map.Entry ? ((Map.Entry)object0) : null;
        return map$Entry0 != null && q.b(map$Entry0.getKey(), this.b) && q.b(map$Entry0.getValue(), this.getValue());
    }

    @Override
    public final Object getKey() {
        return this.b;
    }

    @Override
    public Object getValue() {
        return this.c;
    }

    @Override
    public int hashCode() {
        if(this.a != 1) {
            return super.hashCode();
        }
        int v = 0;
        int v1 = this.b == null ? 0 : this.b.hashCode();
        Object object0 = this.getValue();
        if(object0 != null) {
            v = object0.hashCode();
        }
        return v ^ v1;
    }

    @Override
    public Object setValue(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public String toString() {
        return this.a == 1 ? this.b + '=' + this.getValue() : super.toString();
    }
}

