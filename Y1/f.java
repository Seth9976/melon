package y1;

import java.util.Arrays;

public final class f implements Comparable {
    public boolean a;
    public int b;
    public int c;
    public int d;
    public float e;
    public boolean f;
    public final float[] g;
    public final float[] h;
    public b[] i;
    public int j;
    public int k;
    public int l;

    public f(int v) {
        this.b = -1;
        this.c = -1;
        this.d = 0;
        this.f = false;
        this.g = new float[9];
        this.h = new float[9];
        this.i = new b[16];
        this.j = 0;
        this.k = 0;
        this.l = v;
    }

    public final void a(b b0) {
        for(int v = 0; true; ++v) {
            int v1 = this.j;
            if(v >= v1) {
                break;
            }
            if(this.i[v] == b0) {
                return;
            }
        }
        b[] arr_b = this.i;
        if(v1 >= arr_b.length) {
            this.i = (b[])Arrays.copyOf(arr_b, arr_b.length * 2);
        }
        int v2 = this.j;
        this.i[v2] = b0;
        this.j = v2 + 1;
    }

    public final void b(b b0) {
        int v = this.j;
        for(int v1 = 0; v1 < v; ++v1) {
            if(this.i[v1] == b0) {
                while(v1 < v - 1) {
                    this.i[v1] = this.i[v1 + 1];
                    ++v1;
                }
                --this.j;
                return;
            }
        }
    }

    public final void c() {
        this.l = 5;
        this.d = 0;
        this.b = -1;
        this.c = -1;
        this.e = 0.0f;
        this.f = false;
        int v = this.j;
        for(int v1 = 0; v1 < v; ++v1) {
            this.i[v1] = null;
        }
        this.j = 0;
        this.k = 0;
        this.a = false;
        Arrays.fill(this.h, 0.0f);
    }

    @Override
    public final int compareTo(Object object0) {
        return this.b - ((f)object0).b;
    }

    public final void d(c c0, float f) {
        this.e = f;
        this.f = true;
        int v = this.j;
        this.c = -1;
        for(int v1 = 0; v1 < v; ++v1) {
            this.i[v1].h(c0, this, false);
        }
        this.j = 0;
    }

    public final void e(c c0, b b0) {
        int v = this.j;
        for(int v1 = 0; v1 < v; ++v1) {
            this.i[v1].i(c0, b0, false);
        }
        this.j = 0;
    }

    @Override
    public final String toString() {
        return "" + this.b;
    }
}

