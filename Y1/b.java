package y1;

import java.util.ArrayList;
import k8.Y;
import y8.s;

public class b {
    public f a;
    public float b;
    public final ArrayList c;
    public final a d;
    public boolean e;

    public b(s s0) {
        this.a = null;
        this.b = 0.0f;
        this.c = new ArrayList();
        this.e = false;
        this.d = new a(this, s0);
    }

    public final void a(c c0, int v) {
        f f0 = c0.j(v);
        this.d.g(f0, 1.0f);
        f f1 = c0.j(v);
        this.d.g(f1, -1.0f);
    }

    public final void b(f f0, f f1, f f2, int v) {
        boolean z = false;
        if(v != 0) {
            if(v < 0) {
                v = -v;
                z = true;
            }
            this.b = (float)v;
        }
        if(!z) {
            this.d.g(f0, -1.0f);
            this.d.g(f1, 1.0f);
            this.d.g(f2, 1.0f);
            return;
        }
        this.d.g(f0, 1.0f);
        this.d.g(f1, -1.0f);
        this.d.g(f2, -1.0f);
    }

    public final void c(f f0, f f1, f f2, int v) {
        boolean z = false;
        if(v != 0) {
            if(v < 0) {
                v = -v;
                z = true;
            }
            this.b = (float)v;
        }
        if(!z) {
            this.d.g(f0, -1.0f);
            this.d.g(f1, 1.0f);
            this.d.g(f2, -1.0f);
            return;
        }
        this.d.g(f0, 1.0f);
        this.d.g(f1, -1.0f);
        this.d.g(f2, 1.0f);
    }

    public f d(boolean[] arr_z) {
        return this.f(arr_z, null);
    }

    public boolean e() {
        return this.a == null && this.b == 0.0f && this.d.d() == 0;
    }

    public final f f(boolean[] arr_z, f f0) {
        int v = this.d.d();
        f f1 = null;
        float f2 = 0.0f;
        for(int v1 = 0; v1 < v; ++v1) {
            float f3 = this.d.f(v1);
            if(f3 < 0.0f) {
                f f4 = this.d.e(v1);
                if((arr_z == null || !arr_z[f4.b]) && f4 != f0 && (f4.l == 3 || f4.l == 4) && f3 < f2) {
                    f2 = f3;
                    f1 = f4;
                }
            }
        }
        return f1;
    }

    public final void g(f f0) {
        f f1 = this.a;
        if(f1 != null) {
            this.d.g(f1, -1.0f);
            this.a.c = -1;
            this.a = null;
        }
        float f2 = this.d.h(f0, true);
        this.a = f0;
        if(f2 * -1.0f == 1.0f) {
            return;
        }
        this.b /= f2 * -1.0f;
        a a0 = this.d;
        int v = a0.h;
        for(int v1 = 0; v != -1 && v1 < a0.a; ++v1) {
            a0.g[v] /= f2 * -1.0f;
            v = a0.f[v];
        }
    }

    public final void h(c c0, f f0, boolean z) {
        if(f0.f) {
            float f1 = this.d.c(f0);
            this.b = f0.e * f1 + this.b;
            this.d.h(f0, z);
            if(z) {
                f0.b(this);
            }
            if(this.d.d() == 0) {
                this.e = true;
                c0.b = true;
            }
        }
    }

    public void i(c c0, b b0, boolean z) {
        a a0 = this.d;
        a0.getClass();
        float f = a0.c(b0.a);
        a0.h(b0.a, z);
        a a1 = b0.d;
        int v = a1.d();
        for(int v1 = 0; v1 < v; ++v1) {
            f f1 = a1.e(v1);
            a0.a(f1, a1.c(f1) * f, z);
        }
        this.b = b0.b * f + this.b;
        if(z) {
            b0.a.b(this);
        }
        if(this.a != null && this.d.d() == 0) {
            this.e = true;
            c0.b = true;
        }
    }

    @Override
    public String toString() {
        boolean z;
        String s = (this.a == null ? "0" : "" + this.a) + " = ";
        if(Float.compare(this.b, 0.0f) == 0) {
            z = false;
        }
        else {
            StringBuilder stringBuilder0 = Y.p(s);
            stringBuilder0.append(this.b);
            s = stringBuilder0.toString();
            z = true;
        }
        int v1 = this.d.d();
        for(int v = 0; v < v1; ++v) {
            f f0 = this.d.e(v);
            if(f0 != null) {
                float f1 = this.d.f(v);
                int v2 = Float.compare(f1, 0.0f);
                if(v2 != 0) {
                    String s1 = f0.toString();
                    if(z) {
                        if(v2 > 0) {
                            s = s + " + ";
                        }
                        else {
                            s = s + " - ";
                            f1 *= -1.0f;
                        }
                    }
                    else if(f1 < 0.0f) {
                        s = s + "- ";
                        f1 *= -1.0f;
                    }
                    s = f1 == 1.0f ? s + s1 : s + f1 + " " + s1;
                    z = true;
                }
            }
        }
        return z ? s : s + "0.0";
    }
}

