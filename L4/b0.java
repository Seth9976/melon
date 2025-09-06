package l4;

import android.util.SparseArray;

public final class b0 implements Runnable {
    public final int a;
    public final c0 b;

    public b0(c0 c00, int v) {
        this.a = v;
        this.b = c00;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            i0 i00 = this.b.i;
            if(i00.n == this.b) {
                i00.j();
            }
            return;
        }
        SparseArray sparseArray0 = this.b.h;
        int v = sparseArray0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            ((J)sparseArray0.valueAt(v1)).a(null, null);
        }
        sparseArray0.clear();
    }
}

