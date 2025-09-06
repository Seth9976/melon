package i.n.i.b.a.s.e;

import android.util.SparseBooleanArray;

public final class m4 {
    public final SparseBooleanArray a;

    public m4(SparseBooleanArray sparseBooleanArray0) {
        this.a = sparseBooleanArray0;
    }

    public final int a(int v) {
        M7.z(v, this.a.size());
        return this.a.keyAt(v);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof m4 ? this.a.equals(((m4)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
}

