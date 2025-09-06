package i3;

import b3.o0;
import b3.p0;
import s3.z;

public final class f {
    public final String a;
    public int b;
    public long c;
    public final z d;
    public boolean e;
    public boolean f;
    public final g g;

    public f(g g0, String s, int v, z z0) {
        this.g = g0;
        this.a = s;
        this.b = v;
        this.c = z0 == null ? -1L : z0.d;
        if(z0 != null && z0.b()) {
            this.d = z0;
        }
    }

    public final boolean a(a a0) {
        z z0 = a0.d;
        p0 p00 = a0.b;
        if(z0 == null) {
            return this.b != a0.c;
        }
        long v = this.c;
        if(v != -1L) {
            if(z0.d > v) {
                return true;
            }
            z z1 = this.d;
            if(z1 != null) {
                int v1 = z1.b;
                int v2 = p00.b(z0.a);
                int v3 = p00.b(z1.a);
                if(z0.d >= z1.d && v2 >= v3) {
                    if(v2 <= v3) {
                        return z0.b() ? z0.b > v1 || z0.b == v1 && z0.c > z1.c : z0.e == -1 || z0.e > v1;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean b(p0 p00, p0 p01) {
        int v = this.b;
        if(v < p00.o()) {
            g g0 = this.g;
            o0 o00 = g0.a;
            p00.n(v, o00);
            for(int v1 = o00.n; v1 <= o00.o; ++v1) {
                int v2 = p01.b(p00.l(v1));
                if(v2 != -1) {
                    v = p01.f(v2, g0.b, false).c;
                    break;
                }
            }
        }
        else if(v >= p01.o()) {
        }
        this.b = v;
        return v != -1 && (this.d == null || p01.b(this.d.a) != -1);
    }
}

