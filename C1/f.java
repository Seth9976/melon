package C1;

import F1.d;
import F1.e;

public final class f {
    public int a;
    public int b;
    public float c;
    public int d;
    public String e;
    public String f;
    public boolean g;
    public static final String h;
    public static final String i;
    public static final String j;
    public static final String k;
    public static final String l;
    public static final String m;

    static {
        f.h = new String("FIXED_DIMENSION");
        f.i = new String("WRAP_DIMENSION");
        f.j = new String("SPREAD_DIMENSION");
        f.k = new String("PARENT_DIMENSION");
        f.l = new String("PERCENT_DIMENSION");
        f.m = new String("RATIO_DIMENSION");
    }

    public f(String s) {
        this.a = 0;
        this.b = 0x7FFFFFFF;
        this.c = 1.0f;
        this.d = 0;
        this.e = null;
        this.g = false;
        this.f = s;
    }

    public final void a(e e0, int v) {
        String s = this.e;
        if(s != null) {
            e0.L(s);
        }
        d d0 = d.a;
        d d1 = d.d;
        d d2 = d.b;
        int v1 = 2;
        d d3 = d.c;
        if(v == 0) {
            if(this.g) {
                e0.P(d3);
                String s1 = this.f;
                if(s1 == "WRAP_DIMENSION") {
                    v1 = 1;
                }
                else if(s1 != "PERCENT_DIMENSION") {
                    v1 = 0;
                }
                e0.Q(v1, this.c, this.a, this.b);
                return;
            }
            int v2 = this.a;
            if(v2 > 0) {
                e0.e0 = v2;
            }
            int v3 = this.b;
            if(v3 < 0x7FFFFFFF) {
                e0.D[0] = v3;
            }
            String s2 = this.f;
            if(s2 == "WRAP_DIMENSION") {
                e0.P(d2);
                return;
            }
            if(s2 == "PARENT_DIMENSION") {
                e0.P(d1);
                return;
            }
            if(s2 == null) {
                e0.P(d0);
                e0.T(this.d);
            }
        }
        else {
            if(this.g) {
                e0.R(d3);
                String s3 = this.f;
                if(s3 == "WRAP_DIMENSION") {
                    v1 = 1;
                }
                else if(s3 != "PERCENT_DIMENSION") {
                    v1 = 0;
                }
                e0.S(v1, this.c, this.a, this.b);
                return;
            }
            int v4 = this.a;
            if(v4 > 0) {
                e0.f0 = v4;
            }
            int v5 = this.b;
            if(v5 < 0x7FFFFFFF) {
                e0.D[1] = v5;
            }
            String s4 = this.f;
            if(s4 == "WRAP_DIMENSION") {
                e0.R(d2);
                return;
            }
            if(s4 == "PARENT_DIMENSION") {
                e0.R(d1);
                return;
            }
            if(s4 == null) {
                e0.R(d0);
                e0.O(this.d);
            }
        }
    }

    public static f b(int v) {
        f f0 = new f("FIXED_DIMENSION");
        f0.f = null;
        f0.d = v;
        return f0;
    }

    public static f c(String s) {
        f f0 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        f0.a = 0;
        f0.b = 0x7FFFFFFF;
        f0.c = 1.0f;
        f0.d = 0;
        f0.e = null;
        f0.f = s;
        f0.g = true;
        return f0;
    }
}

