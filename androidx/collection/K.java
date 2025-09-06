package androidx.collection;

import androidx.appcompat.app.o;

public final class k {
    public final long a;

    public k(long v) {
        this.a = v;
    }

    public static long a(int v, int v1) [...] // Inlined contents

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof k && this.a == ((k)object0).a;
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("(");
        stringBuilder0.append(((int)(this.a >> 0x20)));
        stringBuilder0.append(", ");
        return o.q(stringBuilder0, ((int)(this.a & 0xFFFFFFFFL)), ')');
    }
}

