package androidx.media3.session.legacy;

import android.util.SparseIntArray;

public final class b {
    public final a a;
    public static final int b;

    static {
        SparseIntArray sparseIntArray0 = new SparseIntArray();
        sparseIntArray0.put(5, 1);
        sparseIntArray0.put(6, 2);
        sparseIntArray0.put(7, 2);
        sparseIntArray0.put(8, 1);
        sparseIntArray0.put(9, 1);
        sparseIntArray0.put(10, 1);
    }

    public b(a a0) {
        this.a = a0;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof b ? this.a.equals(((b)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return this.a.toString();
    }
}

