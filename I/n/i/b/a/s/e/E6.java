package i.n.i.b.a.s.e;

import d5.v;

public final class e6 extends w0 {
    public final long B;
    public final N2 D;
    public long E;
    public volatile boolean G;
    public boolean I;
    public final int w;

    public e6(D0 d00, W2 w20, u u0, int v, Object object0, long v1, long v2, long v3, long v4, long v5, int v6, long v7, N2 n20, v3 v30) {
        super(d00, w20, u0, v, object0, v1, v2, v3, v4, v5, v30);
        this.w = v6;
        this.B = v7;
        this.D = n20;
    }

    @Override  // i.n.i.b.a.s.e.C7
    public final long a() {
        return this.l + ((long)this.w);
    }

    @Override  // i.n.i.b.a.s.e.gb
    public final void b() {
        this.G = true;
    }

    @Override  // i.n.i.b.a.s.e.C7
    public final boolean c() {
        return this.I;
    }

    @Override  // i.n.i.b.a.s.e.gb
    public final void g() {
        if(Long.compare(this.E, 0L) == 0) {
            v v0 = this.o;
            M7.G(v0);
            long v1 = this.B;
            e7[] arr_e7 = (e7[])v0.b;
            for(int v2 = 0; v2 < arr_e7.length; ++v2) {
                e7 e70 = arr_e7[v2];
                if(e70.G != v1) {
                    e70.G = v1;
                    e70.A = true;
                }
            }
            N2 n20 = this.D;
            long v3 = 0x8000000000000001L;
            long v4 = this.m == 0x8000000000000001L ? 0x8000000000000001L : this.m - this.B;
            long v5 = this.n;
            if(v5 != 0x8000000000000001L) {
                v3 = v5 - this.B;
            }
            n20.a(v0, v4, v3);
        }
        W2 w20 = this.b;
        v3 v30 = this.j;
        if(v30 != null) {
            w20 = v30.b(w20);
        }
        try {
            this.k = w20;
            W2 w21 = w20.b(this.E);
            long v7 = w21.f;
            long v8 = this.i.b(w21);
            D2 d20 = new D2(this.i, v7, v8);
            try {
                while(!this.G) {
                    int v10 = this.D.a.f(d20, N2.j);
                    M7.J(v10 != 1);
                    if(v10 != 0) {
                        break;
                    }
                }
            }
            finally {
                this.E = d20.d - w20.f;
            }
        }
        finally {
            L7.m(this.i);
        }
        this.I = !this.G;
    }
}

