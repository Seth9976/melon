package i.n.i.b.a.s.e;

import android.util.Log;

public final class h1 implements g1 {
    public final int a;
    public final int b;
    public final Object c;

    public h1(int v, int v1, Object object0) {
        this.a = v;
        this.b = v1;
        this.c = object0;
        super();
    }

    public h1(p0 p00, u u0) {
        wb wb0 = p00.c;
        this.c = wb0;
        wb0.n(12);
        int v = wb0.C();
        if("audio/raw".equals(u0.l)) {
            int v1 = L7.v(u0.V, u0.S);
            if(v == 0 || v % v1 != 0) {
                Log.w("AtomParsers", "Audio sample size mismatch. stsd sample size: " + v1 + ", stsz sample size: " + v);
                v = v1;
            }
        }
        if(v == 0) {
            v = -1;
        }
        this.a = v;
        this.b = wb0.C();
    }

    @Override  // i.n.i.b.a.s.e.g1
    public int a() {
        return this.a;
    }

    @Override  // i.n.i.b.a.s.e.g1
    public int b() {
        return this.b;
    }

    @Override  // i.n.i.b.a.s.e.g1
    public int c() {
        return this.a == -1 ? ((wb)this.c).C() : this.a;
    }
}

