package b3;

import android.util.SparseBooleanArray;
import e3.b;

public final class m {
    public final SparseBooleanArray a;

    public m(SparseBooleanArray sparseBooleanArray0) {
        this.a = sparseBooleanArray0;
    }

    public final boolean a(int[] arr_v) {
        for(int v = 0; v < arr_v.length; ++v) {
            if(this.a.get(arr_v[v])) {
                return true;
            }
        }
        return false;
    }

    public final int b(int v) {
        b.g(v, this.a.size());
        return this.a.keyAt(v);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof m ? this.a.equals(((m)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
}

