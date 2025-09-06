package e4;

import android.text.Layout.Alignment;

public final class f {
    public String a;
    public int b;
    public boolean c;
    public int d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public float k;
    public String l;
    public int m;
    public int n;
    public Layout.Alignment o;
    public Layout.Alignment p;
    public int q;
    public b r;
    public float s;

    public f() {
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.m = -1;
        this.n = -1;
        this.q = -1;
        this.s = 3.402823E+38f;
    }

    public final void a(f f0) {
        if(f0 != null) {
            if(!this.c && f0.c) {
                this.b = f0.b;
                this.c = true;
            }
            if(this.h == -1) {
                this.h = f0.h;
            }
            if(this.i == -1) {
                this.i = f0.i;
            }
            if(this.a == null) {
                String s = f0.a;
                if(s != null) {
                    this.a = s;
                }
            }
            if(this.f == -1) {
                this.f = f0.f;
            }
            if(this.g == -1) {
                this.g = f0.g;
            }
            if(this.n == -1) {
                this.n = f0.n;
            }
            if(this.o == null) {
                Layout.Alignment layout$Alignment0 = f0.o;
                if(layout$Alignment0 != null) {
                    this.o = layout$Alignment0;
                }
            }
            if(this.p == null) {
                Layout.Alignment layout$Alignment1 = f0.p;
                if(layout$Alignment1 != null) {
                    this.p = layout$Alignment1;
                }
            }
            if(this.q == -1) {
                this.q = f0.q;
            }
            if(this.j == -1) {
                this.j = f0.j;
                this.k = f0.k;
            }
            if(this.r == null) {
                this.r = f0.r;
            }
            if(this.s == 3.402823E+38f) {
                this.s = f0.s;
            }
            if(!this.e && f0.e) {
                this.d = f0.d;
                this.e = true;
            }
            if(this.m == -1) {
                int v = f0.m;
                if(v != -1) {
                    this.m = v;
                }
            }
        }
    }
}

