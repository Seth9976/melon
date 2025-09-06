package androidx.datastore.preferences.protobuf;

import java.util.Map.Entry;

public final class h0 implements Comparable, Map.Entry {
    public final Comparable a;
    public Object b;
    public final g0 c;

    public h0(g0 g00, Comparable comparable0, Object object0) {
        this.c = g00;
        this.a = comparable0;
        this.b = object0;
    }

    @Override
    public final int compareTo(Object object0) {
        return this.a.compareTo(((h0)object0).a);
    }

    @Override
    public final boolean equals(Object object0) {
        boolean z;
        if(object0 != this) {
            if(object0 instanceof Map.Entry) {
                Object object1 = ((Map.Entry)object0).getKey();
                Comparable comparable0 = this.a;
                if(comparable0 != null) {
                    z = comparable0.equals(object1);
                }
                else if(object1 == null) {
                    z = true;
                }
                else {
                    z = false;
                }
                if(z) {
                    Object object2 = this.b;
                    Object object3 = ((Map.Entry)object0).getValue();
                    return object2 == null ? object3 == null : object2.equals(object3);
                }
            }
            return false;
        }
        return true;
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
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        Object object0 = this.b;
        if(object0 != null) {
            v = object0.hashCode();
        }
        return v ^ v1;
    }

    @Override
    public final Object setValue(Object object0) {
        this.c.b();
        Object object1 = this.b;
        this.b = object0;
        return object1;
    }

    @Override
    public final String toString() {
        return this.a + "=" + this.b;
    }
}

