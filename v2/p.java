package v2;

import android.util.SparseArray;

public final class p {
    public final SparseArray a;
    public s b;

    public p(int v) {
        this.a = new SparseArray(v);
    }

    public final void a(s s0, int v, int v1) {
        int v2 = s0.a(v);
        SparseArray sparseArray0 = this.a;
        p p0 = sparseArray0 == null ? null : ((p)sparseArray0.get(v2));
        if(p0 == null) {
            p0 = new p(1);
            sparseArray0.put(s0.a(v), p0);
        }
        if(v1 > v) {
            p0.a(s0, v + 1, v1);
            return;
        }
        p0.b = s0;
    }
}

