package ie;

import U4.x;
import kotlin.jvm.internal.q;

public final class i implements Comparable {
    public final int a;
    public final int b;
    public final int c;
    public static final i d;

    static {
        i.d = new i(2, 2, 0);
    }

    public i(int v, int v1, int v2) {
        this.a = v;
        this.b = v1;
        if(v < 0 || v >= 0x100 || v1 < 0 || v1 >= 0x100) {
            throw new IllegalArgumentException(("Version components are out of range: " + v + '.' + v1 + ".0").toString());
        }
        this.c = (v << 16) + (v1 << 8);
    }

    @Override
    public final int compareTo(Object object0) {
        q.g(((i)object0), "other");
        return this.c - ((i)object0).c;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        i i0 = object0 instanceof i ? ((i)object0) : null;
        return i0 == null ? false : this.c == i0.c;
    }

    @Override
    public final int hashCode() {
        return this.c;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.a);
        stringBuilder0.append('.');
        return x.g(this.b, ".0", stringBuilder0);
    }
}

