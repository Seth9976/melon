package b3;

import android.util.SparseBooleanArray;
import e3.b;
import i.n.i.b.a.s.e.M7;
import i.n.i.b.a.s.e.m4;

public final class l {
    public final SparseBooleanArray a;
    public boolean b;

    public l(int v) {
        if(v != 1) {
            super();
            this.a = new SparseBooleanArray();
            return;
        }
        super();
        this.a = new SparseBooleanArray();
    }

    public m4 a() {
        M7.J(!this.b);
        this.b = true;
        return new m4(this.a);
    }

    public void b(int v) {
        M7.J(!this.b);
        this.a.append(v, true);
    }

    public void c(int v) {
        b.j(!this.b);
        this.a.append(v, true);
    }

    public void d(m m0) {
        for(int v = 0; v < m0.a.size(); ++v) {
            this.c(m0.b(v));
        }
    }

    public void e(int[] arr_v) {
        for(int v = 0; v < arr_v.length; ++v) {
            this.c(arr_v[v]);
        }
    }

    public m f() {
        b.j(!this.b);
        this.b = true;
        return new m(this.a);
    }
}

