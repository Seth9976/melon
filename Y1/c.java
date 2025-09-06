package y1;

import d5.l;
import java.util.ArrayList;
import java.util.Arrays;
import y8.s;

public final class c {
    public int a;
    public boolean b;
    public int c;
    public final e d;
    public int e;
    public int f;
    public b[] g;
    public boolean h;
    public boolean[] i;
    public int j;
    public int k;
    public int l;
    public final s m;
    public f[] n;
    public int o;
    public b p;
    public static boolean q = false;

    public c() {
        this.a = 1000;
        this.b = false;
        this.c = 0;
        this.e = 0x20;
        this.f = 0x20;
        this.h = false;
        this.i = new boolean[0x20];
        this.j = 1;
        this.k = 0;
        this.l = 0x20;
        this.n = new f[1000];
        this.o = 0;
        this.g = new b[0x20];
        this.s();
        s s0 = new s();  // 初始化器: Ljava/lang/Object;-><init>()V
        s0.a = new b2.e();
        s0.b = new b2.e();
        s0.c = new f[0x20];
        this.m = s0;
        e e0 = new e(s0);  // 初始化器: Ly1/b;-><init>(Ly8/s;)V
        e0.f = new f[0x80];
        e0.g = new f[0x80];
        e0.h = 0;
        e0.i = new l(e0);
        this.d = e0;
        this.p = new b(s0);
    }

    public final f a(int v) {
        b2.e e0 = (b2.e)this.m.b;
        int v1 = e0.b;
        Object object0 = null;
        if(v1 > 0) {
            Object[] arr_object = e0.a;
            Object object1 = arr_object[v1 - 1];
            arr_object[v1 - 1] = null;
            e0.b = v1 - 1;
            object0 = object1;
        }
        f f0 = (f)object0;
        if(f0 == null) {
            f0 = new f(v);
        }
        else {
            f0.c();
        }
        f0.l = v;
        int v2 = this.a;
        if(this.o >= v2) {
            this.a = v2 * 2;
            this.n = (f[])Arrays.copyOf(this.n, v2 * 2);
        }
        int v3 = this.o;
        this.o = v3 + 1;
        this.n[v3] = f0;
        return f0;
    }

    public final void b(f f0, f f1, int v, float f2, f f3, f f4, int v1, int v2) {
        b b0 = this.l();
        if(f1 == f3) {
            b0.d.g(f0, 1.0f);
            b0.d.g(f4, 1.0f);
            b0.d.g(f1, -2.0f);
        }
        else if(Float.compare(f2, 0.5f) == 0) {
            b0.d.g(f0, 1.0f);
            b0.d.g(f1, -1.0f);
            b0.d.g(f3, -1.0f);
            b0.d.g(f4, 1.0f);
            if(v > 0 || v1 > 0) {
                b0.b = (float)(v1 - v);
            }
        }
        else if(f2 <= 0.0f) {
            b0.d.g(f0, -1.0f);
            b0.d.g(f1, 1.0f);
            b0.b = (float)v;
        }
        else if(f2 >= 1.0f) {
            b0.d.g(f4, -1.0f);
            b0.d.g(f3, 1.0f);
            b0.b = (float)(-v1);
        }
        else {
            b0.d.g(f0, (1.0f - f2) * 1.0f);
            b0.d.g(f1, (1.0f - f2) * -1.0f);
            b0.d.g(f3, -1.0f * f2);
            b0.d.g(f4, 1.0f * f2);
            if(v > 0 || v1 > 0) {
                b0.b = ((float)v1) * f2 + ((float)(-v)) * (1.0f - f2);
            }
        }
        if(v2 != 8) {
            b0.a(this, v2);
        }
        this.c(b0);
    }

    public final void c(b b0) {
        boolean z4;
        boolean z3;
        if(this.k + 1 >= this.l || this.j + 1 >= this.f) {
            this.o();
        }
        if(b0.e) {
            z4 = false;
        label_142:
            if(!z4) {
                this.h(b0);
            }
        }
        else {
            ArrayList arrayList0 = b0.c;
            if(this.g.length != 0) {
                boolean z = false;
                while(!z) {
                    int v = b0.d.d();
                    for(int v1 = 0; v1 < v; ++v1) {
                        f f0 = b0.d.e(v1);
                        if(f0.c != -1 || f0.f) {
                            arrayList0.add(f0);
                        }
                    }
                    int v2 = arrayList0.size();
                    if(v2 > 0) {
                        for(int v3 = 0; v3 < v2; ++v3) {
                            f f1 = (f)arrayList0.get(v3);
                            if(f1.f) {
                                b0.h(this, f1, true);
                            }
                            else {
                                b0.i(this, this.g[f1.c], true);
                            }
                        }
                        arrayList0.clear();
                    }
                    else {
                        z = true;
                    }
                }
                if(b0.a != null && b0.d.d() == 0) {
                    b0.e = true;
                    this.b = true;
                }
            }
            if(!b0.e()) {
                float f2 = b0.b;
                if(f2 < 0.0f) {
                    b0.b = f2 * -1.0f;
                    a a0 = b0.d;
                    int v4 = a0.h;
                    for(int v5 = 0; v4 != -1 && v5 < a0.a; ++v5) {
                        a0.g[v4] *= -1.0f;
                        v4 = a0.f[v4];
                    }
                }
                int v6 = b0.d.d();
                float f3 = 0.0f;
                float f4 = 0.0f;
                f f5 = null;
                f f6 = null;
                int v7 = 0;
                boolean z1 = false;
                boolean z2 = false;
                while(v7 < v6) {
                    float f7 = b0.d.f(v7);
                    f f8 = b0.d.e(v7);
                    if(f8.l != 1) {
                        if(f5 == null && f7 < 0.0f) {
                            if(f6 == null) {
                                z2 = f8.k > 1 ? false : true;
                                goto label_82;
                            }
                            else if(f4 > f7) {
                                z2 = f8.k <= 1;
                            label_82:
                                f6 = f8;
                                f4 = f7;
                            }
                            else if(!z2 && f8.k <= 1) {
                                z2 = true;
                                f6 = f8;
                                f4 = f7;
                            }
                        }
                    }
                    else if(f5 == null) {
                        z1 = f8.k > 1 ? false : true;
                        goto label_65;
                    }
                    else if(f3 > f7) {
                        z1 = f8.k <= 1;
                    label_65:
                        f5 = f8;
                        f3 = f7;
                    }
                    else if(!z1 && f8.k <= 1) {
                        z1 = true;
                        f5 = f8;
                        f3 = f7;
                    }
                    ++v7;
                }
                if(f5 == null) {
                    f5 = f6;
                }
                if(f5 == null) {
                    z3 = true;
                }
                else {
                    b0.g(f5);
                    z3 = false;
                }
                if(b0.d.d() == 0) {
                    b0.e = true;
                }
                if(z3) {
                    if(this.j + 1 >= this.f) {
                        this.o();
                    }
                    f f9 = this.a(3);
                    int v8 = this.c + 1;
                    this.c = v8;
                    ++this.j;
                    f9.b = v8;
                    s s0 = this.m;
                    ((f[])s0.c)[v8] = f9;
                    b0.a = f9;
                    int v9 = this.k;
                    this.h(b0);
                    if(this.k == v9 + 1) {
                        b b1 = this.p;
                        b1.a = null;
                        b1.d.b();
                        for(int v10 = 0; v10 < b0.d.d(); ++v10) {
                            f f10 = b0.d.e(v10);
                            float f11 = b0.d.f(v10);
                            b1.d.a(f10, f11, true);
                        }
                        this.r(this.p);
                        if(f9.c == -1) {
                            if(b0.a == f9) {
                                f f12 = b0.f(null, f9);
                                if(f12 != null) {
                                    b0.g(f12);
                                }
                            }
                            if(!b0.e) {
                                b0.a.e(this, b0);
                            }
                            ((b2.e)s0.a).c(b0);
                            --this.k;
                        }
                        z4 = true;
                    }
                    else {
                        z4 = false;
                    }
                }
                else {
                    z4 = false;
                }
                if(b0.a != null && (b0.a.l == 1 || b0.b >= 0.0f)) {
                    goto label_142;
                }
            }
        }
    }

    public final void d(f f0, int v) {
        int v1 = f0.c;
        if(v1 == -1) {
            f0.d(this, ((float)v));
            for(int v2 = 0; v2 < this.c + 1; ++v2) {
                f f1 = ((f[])this.m.c)[v2];
            }
            return;
        }
        b b0 = this.g[v1];
        if(b0.e) {
            b0.b = (float)v;
            return;
        }
        if(b0.d.d() == 0) {
            b0.e = true;
            b0.b = (float)v;
            return;
        }
        b b1 = this.l();
        if(v < 0) {
            b1.b = (float)(-v);
            b1.d.g(f0, 1.0f);
        }
        else {
            b1.b = (float)v;
            b1.d.g(f0, -1.0f);
        }
        this.c(b1);
    }

    public final void e(f f0, f f1, int v, int v1) {
        if(v1 == 8 && f1.f && f0.c == -1) {
            f0.d(this, f1.e + ((float)v));
            return;
        }
        b b0 = this.l();
        boolean z = false;
        if(v != 0) {
            if(v < 0) {
                v = -v;
                z = true;
            }
            b0.b = (float)v;
        }
        if(z) {
            b0.d.g(f0, 1.0f);
            b0.d.g(f1, -1.0f);
        }
        else {
            b0.d.g(f0, -1.0f);
            b0.d.g(f1, 1.0f);
        }
        if(v1 != 8) {
            b0.a(this, v1);
        }
        this.c(b0);
    }

    public final void f(f f0, f f1, int v, int v1) {
        b b0 = this.l();
        f f2 = this.m();
        f2.d = 0;
        b0.b(f0, f1, f2, v);
        if(v1 != 8) {
            float f3 = b0.d.c(f2);
            f f4 = this.j(v1);
            b0.d.g(f4, ((float)(((int)(f3 * -1.0f)))));
        }
        this.c(b0);
    }

    public final void g(f f0, f f1, int v, int v1) {
        b b0 = this.l();
        f f2 = this.m();
        f2.d = 0;
        b0.c(f0, f1, f2, v);
        if(v1 != 8) {
            float f3 = b0.d.c(f2);
            f f4 = this.j(v1);
            b0.d.g(f4, ((float)(((int)(f3 * -1.0f)))));
        }
        this.c(b0);
    }

    public final void h(b b0) {
        int v4;
        if(b0.e) {
            b0.a.d(this, b0.b);
        }
        else {
            int v = this.k;
            this.g[v] = b0;
            b0.a.c = v;
            this.k = v + 1;
            b0.a.e(this, b0);
        }
        if(this.b) {
            for(int v1 = 0; v1 < this.k; ++v1) {
                if(this.g[v1] == null) {
                    System.out.println("WTF");
                }
                b b1 = this.g[v1];
                if(b1 != null && b1.e) {
                    b1.a.d(this, b1.b);
                    ((b2.e)this.m.a).c(b1);
                    this.g[v1] = null;
                    int v2 = v1 + 1;
                    int v3 = v2;
                    while(true) {
                        v4 = this.k;
                        if(v2 >= v4) {
                            break;
                        }
                        b[] arr_b = this.g;
                        b b2 = arr_b[v2];
                        arr_b[v2 - 1] = b2;
                        f f0 = b2.a;
                        if(f0.c == v2) {
                            f0.c = v2 - 1;
                        }
                        v3 = v2;
                        ++v2;
                    }
                    if(v3 < v4) {
                        this.g[v3] = null;
                    }
                    this.k = v4 - 1;
                    --v1;
                }
            }
            this.b = false;
        }
    }

    public final void i() {
        for(int v = 0; v < this.k; ++v) {
            b b0 = this.g[v];
            b0.a.e = b0.b;
        }
    }

    public final f j(int v) {
        if(this.j + 1 >= this.f) {
            this.o();
        }
        f f0 = this.a(4);
        int v1 = this.c + 1;
        this.c = v1;
        ++this.j;
        f0.b = v1;
        f0.d = v;
        ((f[])this.m.c)[v1] = f0;
        this.d.i.b = f0;
        Arrays.fill(f0.h, 0.0f);
        f0.h[f0.d] = 1.0f;
        this.d.j(f0);
        return f0;
    }

    public final f k(Object object0) {
        if(object0 != null) {
            if(this.j + 1 >= this.f) {
                this.o();
            }
            if(object0 instanceof F1.c) {
                f f0 = ((F1.c)object0).i;
                if(f0 == null) {
                    ((F1.c)object0).k();
                    f0 = ((F1.c)object0).i;
                }
                int v = f0.b;
                s s0 = this.m;
                if(v != -1 && v <= this.c && ((f[])s0.c)[v] != null) {
                    return f0;
                }
                if(v != -1) {
                    f0.c();
                }
                int v1 = this.c + 1;
                this.c = v1;
                ++this.j;
                f0.b = v1;
                f0.l = 1;
                ((f[])s0.c)[v1] = f0;
                return f0;
            }
        }
        return null;
    }

    public final b l() {
        Object object0;
        s s0 = this.m;
        b2.e e0 = (b2.e)s0.a;
        int v = e0.b;
        if(v > 0) {
            Object[] arr_object = e0.a;
            object0 = arr_object[v - 1];
            arr_object[v - 1] = null;
            e0.b = v - 1;
        }
        else {
            object0 = null;
        }
        if(((b)object0) == null) {
            return new b(s0);
        }
        ((b)object0).a = null;
        ((b)object0).d.b();
        ((b)object0).b = 0.0f;
        ((b)object0).e = false;
        return (b)object0;
    }

    public final f m() {
        if(this.j + 1 >= this.f) {
            this.o();
        }
        f f0 = this.a(3);
        int v = this.c + 1;
        this.c = v;
        ++this.j;
        f0.b = v;
        ((f[])this.m.c)[v] = f0;
        return f0;
    }

    public static int n(Object object0) {
        f f0 = ((F1.c)object0).i;
        return f0 == null ? 0 : ((int)(f0.e + 0.5f));
    }

    public final void o() {
        int v = this.e * 2;
        this.e = v;
        this.g = (b[])Arrays.copyOf(this.g, v);
        this.m.c = (f[])Arrays.copyOf(((f[])this.m.c), this.e);
        int v1 = this.e;
        this.i = new boolean[v1];
        this.f = v1;
        this.l = v1;
    }

    public final void p() {
        e e0 = this.d;
        if(e0.e()) {
            this.i();
            return;
        }
        if(this.h) {
            for(int v = 0; v < this.k; ++v) {
                if(!this.g[v].e) {
                    this.q(e0);
                    return;
                }
            }
            this.i();
            return;
        }
        this.q(e0);
    }

    public final void q(e e0) {
        for(int v = 0; v < this.k; ++v) {
            b b0 = this.g[v];
            if(b0.a.l != 1 && b0.b < 0.0f) {
                int v1 = 0;
                boolean z = false;
                while(!z) {
                    ++v1;
                    float f = 3.402823E+38f;
                    int v2 = -1;
                    int v3 = -1;
                    int v5 = 0;
                    for(int v4 = 0; v4 < this.k; ++v4) {
                        b b1 = this.g[v4];
                        if(b1.a.l != 1 && !b1.e && b1.b < 0.0f) {
                            int v6 = b1.d.d();
                            for(int v7 = 0; v7 < v6; ++v7) {
                                f f1 = b1.d.e(v7);
                                float f2 = b1.d.c(f1);
                                if(f2 > 0.0f) {
                                    for(int v8 = 0; v8 < 9; ++v8) {
                                        float f3 = f1.g[v8] / f2;
                                        if(f3 < f && v8 == v5 || v8 > v5) {
                                            v5 = v8;
                                            v3 = f1.b;
                                            v2 = v4;
                                            f = f3;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(v2 == -1) {
                        z = true;
                    }
                    else {
                        b b2 = this.g[v2];
                        b2.a.c = -1;
                        b2.g(((f[])this.m.c)[v3]);
                        b2.a.c = v2;
                        b2.a.e(this, b2);
                    }
                    if(v1 > this.j / 2) {
                        z = true;
                    }
                }
                break;
            }
        }
        this.r(e0);
        this.i();
    }

    public final void r(b b0) {
        for(int v = 0; v < this.j; ++v) {
            this.i[v] = false;
        }
        int v1 = 0;
        boolean z = false;
        while(!z) {
            ++v1;
            if(v1 >= this.j * 2) {
                break;
            }
            f f0 = b0.a;
            if(f0 != null) {
                this.i[f0.b] = true;
            }
            f f1 = b0.d(this.i);
            if(f1 != null) {
                boolean[] arr_z = this.i;
                int v2 = f1.b;
                if(arr_z[v2]) {
                    break;
                }
                arr_z[v2] = true;
            }
            if(f1 == null) {
                z = true;
            }
            else {
                float f2 = 3.402823E+38f;
                int v4 = -1;
                for(int v3 = 0; v3 < this.k; ++v3) {
                    b b1 = this.g[v3];
                    if(b1.a.l != 1 && !b1.e) {
                        boolean z1 = false;
                        a a0 = b1.d;
                        int v5 = a0.h;
                        if(v5 != -1) {
                            for(int v6 = 0; v5 != -1 && v6 < a0.a; ++v6) {
                                if(a0.e[v5] == f1.b) {
                                    z1 = true;
                                    break;
                                }
                                v5 = a0.f[v5];
                            }
                        }
                        if(z1) {
                            float f3 = b1.d.c(f1);
                            if(f3 < 0.0f) {
                                float f4 = -b1.b / f3;
                                if(f4 < f2) {
                                    f2 = f4;
                                    v4 = v3;
                                }
                            }
                        }
                    }
                }
                if(v4 <= -1) {
                    continue;
                }
                b b2 = this.g[v4];
                b2.a.c = -1;
                b2.g(f1);
                b2.a.c = v4;
                b2.a.e(this, b2);
            }
        }
    }

    public final void s() {
        for(int v = 0; v < this.k; ++v) {
            b b0 = this.g[v];
            if(b0 != null) {
                ((b2.e)this.m.a).c(b0);
            }
            this.g[v] = null;
        }
    }

    public final void t() {
        s s0;
        for(int v = 0; true; ++v) {
            s0 = this.m;
            f[] arr_f = (f[])s0.c;
            if(v >= arr_f.length) {
                break;
            }
            f f0 = arr_f[v];
            if(f0 != null) {
                f0.c();
            }
        }
        b2.e e0 = (b2.e)s0.b;
        f[] arr_f1 = this.n;
        int v1 = this.o;
        e0.getClass();
        if(v1 > arr_f1.length) {
            v1 = arr_f1.length;
        }
        for(int v2 = 0; v2 < v1; ++v2) {
            f f1 = arr_f1[v2];
            int v3 = e0.b;
            Object[] arr_object = e0.a;
            if(v3 < arr_object.length) {
                arr_object[v3] = f1;
                e0.b = v3 + 1;
            }
        }
        this.o = 0;
        Arrays.fill(((f[])s0.c), null);
        this.c = 0;
        this.d.h = 0;
        this.d.b = 0.0f;
        this.j = 1;
        for(int v4 = 0; v4 < this.k; ++v4) {
            b b0 = this.g[v4];
        }
        this.s();
        this.k = 0;
        this.p = new b(s0);
    }
}

