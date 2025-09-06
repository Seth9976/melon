package c2;

import P4.a;
import S1.d;

public abstract class r0 {
    public final B0 a;
    public d[] b;

    public r0() {
        this(new B0(null));
    }

    public r0(B0 b00) {
        this.a = b00;
    }

    public final void a() {
        d[] arr_d = this.b;
        if(arr_d != null) {
            d d0 = arr_d[0];
            d d1 = arr_d[1];
            B0 b00 = this.a;
            if(d1 == null) {
                d1 = b00.a.g(2);
            }
            if(d0 == null) {
                d0 = b00.a.g(1);
            }
            this.g(d.a(d0, d1));
            d[] arr_d1 = this.b;
            d d2 = arr_d1[a.u(16)];
            if(d2 != null) {
                this.f(d2);
            }
            d[] arr_d2 = this.b;
            d d3 = arr_d2[a.u(0x20)];
            if(d3 != null) {
                this.d(d3);
            }
            d[] arr_d3 = this.b;
            d d4 = arr_d3[a.u(0x40)];
            if(d4 != null) {
                this.h(d4);
            }
        }
    }

    public abstract B0 b();

    public void c(int v, d d0) {
        if(this.b == null) {
            this.b = new d[10];
        }
        for(int v1 = 1; v1 <= 0x200; v1 <<= 1) {
            if((v & v1) != 0) {
                d[] arr_d = this.b;
                arr_d[a.u(v1)] = d0;
            }
        }
    }

    public void d(d d0) {
    }

    public abstract void e(d arg1);

    public void f(d d0) {
    }

    public abstract void g(d arg1);

    public void h(d d0) {
    }
}

