package Z;

import P0.f;
import b0.A;
import b0.k;
import b0.x;
import b0.z;
import y0.M;
import y0.u;

public final class q implements u {
    public final int a;
    public final Object b;

    public q(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // y0.u
    public final long invoke-0d7_KjU() {
        switch(this.a) {
            case 0: {
                s s0 = (s)this.b;
                long v = s0.g.invoke-0d7_KjU();
                if(v == 16L) {
                    F f0 = (F)f.i(s0, G.a);
                    if(f0 == null) {
                        v = ((y0.s)f.i(s0, i.a)).a;
                        return ((e)f.i(s0, g.a)).d() || ((double)M.q(v)) >= 0.5 ? v : y0.s.c;
                    }
                    v = f0.a;
                    if(v == 16L) {
                        v = ((y0.s)f.i(s0, i.a)).a;
                        return ((e)f.i(s0, g.a)).d() || ((double)M.q(v)) >= 0.5 ? v : y0.s.c;
                    }
                }
                return v;
            }
            case 1: {
                return ((H)this.b).b;
            }
            case 2: {
                s s1 = (s)this.b;
                long v1 = s1.g.invoke-0d7_KjU();
                if(v1 == 16L) {
                    x x0 = (x)f.i(s1, z.b);
                    if(x0 != null) {
                        return x0.a == 16L ? ((y0.s)f.i(s1, k.a)).a : x0.a;
                    }
                    return ((y0.s)f.i(s1, k.a)).a;
                }
                return v1;
            }
            default: {
                return ((A)this.b).b;
            }
        }
    }
}

