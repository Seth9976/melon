package i.n.i.b.a.s.e;

import java.util.Arrays;

public final class ze {
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public final boolean[] g;
    public int h;

    public ze(int v) {
        if(v != 1) {
            super();
            this.g = new boolean[15];
            return;
        }
        super();
        this.g = new boolean[15];
    }

    public void a(long v) {
        long v1 = this.d;
        if(Long.compare(v1, 0L) == 0) {
            this.a = v;
        }
        else if(v1 == 1L) {
            long v2 = v - this.a;
            this.b = v2;
            this.f = v2;
            this.e = 1L;
        }
        else {
            long v3 = v - this.c;
            boolean[] arr_z = this.g;
            if(Long.compare(Math.abs(v3 - this.b), 1000000L) <= 0) {
                ++this.e;
                this.f += v3;
                if(arr_z[((int)(v1 % 15L))]) {
                    arr_z[((int)(v1 % 15L))] = false;
                    --this.h;
                }
            }
            else if(!arr_z[((int)(v1 % 15L))]) {
                arr_z[((int)(v1 % 15L))] = true;
                ++this.h;
            }
        }
        ++this.d;
        this.c = v;
    }

    public boolean b() {
        return this.d > 15L && this.h == 0;
    }

    public void c() {
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.h = 0;
        Arrays.fill(this.g, false);
    }

    public boolean d() {
        return this.d > 15L && this.h == 0;
    }

    public void e(long v) {
        long v1 = this.d;
        if(Long.compare(v1, 0L) == 0) {
            this.a = v;
        }
        else if(v1 == 1L) {
            long v2 = v - this.a;
            this.b = v2;
            this.f = v2;
            this.e = 1L;
        }
        else {
            long v3 = v - this.c;
            boolean[] arr_z = this.g;
            if(Long.compare(Math.abs(v3 - this.b), 1000000L) <= 0) {
                ++this.e;
                this.f += v3;
                if(arr_z[((int)(v1 % 15L))]) {
                    arr_z[((int)(v1 % 15L))] = false;
                    --this.h;
                }
            }
            else if(!arr_z[((int)(v1 % 15L))]) {
                arr_z[((int)(v1 % 15L))] = true;
                ++this.h;
            }
        }
        ++this.d;
        this.c = v;
    }

    public void f() {
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.h = 0;
        Arrays.fill(this.g, false);
    }
}

