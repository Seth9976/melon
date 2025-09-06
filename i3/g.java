package i3;

import H6.m;
import b3.m0;
import b3.o0;
import b3.p0;
import e3.x;
import java.util.HashMap;
import java.util.Random;
import s3.z;

public final class g {
    public final o0 a;
    public final m0 b;
    public final HashMap c;
    public j d;
    public p0 e;
    public String f;
    public long g;
    public static final m h;
    public static final Random i;

    static {
        g.h = new m(3);
        g.i = new Random();
    }

    public g() {
        this.a = new o0();
        this.b = new m0();
        this.c = new HashMap();
        this.e = p0.a;
        this.g = -1L;
    }

    public final void a(f f0) {
        long v = f0.c;
        if(v != -1L) {
            this.g = v;
        }
        this.f = null;
    }

    public final f b(int v, z z0) {
        long v4;
        HashMap hashMap0 = this.c;
        f f0 = null;
        long v1 = 0x7FFFFFFFFFFFFFFFL;
        for(Object object0: hashMap0.values()) {
            f f1 = (f)object0;
            z z1 = f1.d;
            if(f1.c == -1L && v == f1.b && z0 != null) {
                long v2 = z0.d;
                g g0 = f1.g;
                f f2 = (f)g0.c.get(g0.f);
                if(f2 == null) {
                    v4 = g0.g + 1L;
                }
                else {
                    long v3 = f2.c;
                    if(v3 != -1L) {
                        v4 = v3;
                    }
                }
                if(v2 >= v4) {
                    f1.c = v2;
                }
            }
            if(z0 != null) {
                long v5 = z0.d;
                if(z1 != null) {
                    if(v5 == z1.d && z0.b == z1.b && z0.c == z1.c) {
                        goto label_28;
                    }
                    continue;
                }
                else if(z0.b() || v5 != f1.c) {
                    continue;
                }
            }
            else if(v != f1.b) {
                continue;
            }
        label_28:
            long v6 = f1.c;
            if(v6 != -1L) {
                int v7 = Long.compare(v6, v1);
                if(v7 >= 0) {
                    if(v7 != 0 || f0.d == null || z1 == null) {
                        continue;
                    }
                    f0 = f1;
                    continue;
                }
            }
            f0 = f1;
            v1 = v6;
        }
        if(f0 == null) {
            String s = (String)g.h.get();
            f0 = new f(this, s, v, z0);
            hashMap0.put(s, f0);
        }
        return f0;
    }

    public final String c(p0 p00, z z0) {
        synchronized(this) {
            f f0 = this.b(p00.g(z0.a, this.b).c, z0);
            return f0.a;
        }
    }

    public final void d(a a0) {
        int v = a0.c;
        z z0 = a0.d;
        boolean z1 = a0.b.p();
        HashMap hashMap0 = this.c;
        if(z1) {
            String s = this.f;
            if(s != null) {
                f f0 = (f)hashMap0.get(s);
                f0.getClass();
                this.a(f0);
            }
        }
        else {
            f f1 = (f)hashMap0.get(this.f);
            this.f = this.b(v, z0).a;
            this.e(a0);
            if(z0 != null) {
                long v1 = z0.d;
                if(z0.b() && (f1 == null || f1.c != v1 || (f1.d == null || f1.d.b != z0.b || f1.d.c != z0.c))) {
                    this.b(v, new z(z0.a, v1));
                    this.d.getClass();
                }
            }
        }
    }

    public final void e(a a0) {
        long v2;
        synchronized(this) {
            this.d.getClass();
            if(a0.b.p()) {
                return;
            }
            z z0 = a0.d;
            if(z0 != null) {
                long v1 = z0.d;
                f f0 = (f)this.c.get(this.f);
                if(f0 == null) {
                    v2 = this.g + 1L;
                }
                else {
                    v2 = f0.c;
                    if(v2 == -1L) {
                        v2 = this.g + 1L;
                    }
                }
                if(v1 < v2) {
                    return;
                }
                f f1 = (f)this.c.get(this.f);
                if(f1 != null && f1.c == -1L && f1.b != a0.c) {
                    return;
                }
            }
            f f2 = this.b(a0.c, a0.d);
            if(this.f == null) {
                this.f = f2.a;
            }
            if(a0.d != null && a0.d.b()) {
                z z1 = new z(a0.d.a, a0.d.d, a0.d.b);
                f f3 = this.b(a0.c, z1);
                if(!f3.e) {
                    f3.e = true;
                    a0.b.g(a0.d.a, this.b);
                    x.Z(this.b.d(a0.d.b));
                    x.Z(this.b.e);
                    this.d.getClass();
                }
            }
            if(!f2.e) {
                f2.e = true;
                this.d.getClass();
            }
            if(f2.a.equals(this.f) && !f2.f) {
                f2.f = true;
                j j0 = this.d;
                String s = f2.a;
                j0.getClass();
                if(a0.d == null || !a0.d.b()) {
                    j0.b();
                    j0.i = s;
                    j0.j = com.airbnb.lottie.utils.a.v(com.airbnb.lottie.utils.a.f(h.h()));
                    j0.c(a0.b, a0.d);
                }
            }
        }
    }
}

