package i.n.i.b.a.s.e;

import com.google.android.exoplayer2.ui.c;
import d5.v;

public final class f7 extends w3 {
    public final N2 l;
    public v m;
    public long n;
    public volatile boolean o;

    public f7(D0 d00, W2 w20, u u0, int v, Object object0, N2 n20, c c0) {
        super(d00, w20, 2, u0, v, object0, 0x8000000000000001L, 0x8000000000000001L);
        this.l = n20;
        this.j = c0;
    }

    @Override  // i.n.i.b.a.s.e.gb
    public final void b() {
        this.o = true;
    }

    @Override  // i.n.i.b.a.s.e.gb
    public final void g() {
        if(this.n == 0L) {
            this.l.a(this.m, 0x8000000000000001L, 0x8000000000000001L);
        }
        W2 w20 = this.b;
        v3 v30 = this.j;
        if(v30 != null) {
            w20 = v30.b(w20);
        }
        try {
            this.k = w20;
            W2 w21 = w20.b(this.n);
            long v1 = w21.f;
            long v2 = this.i.b(w21);
            D2 d20 = new D2(this.i, v1, v2);
            try {
                while(!this.o) {
                    int v4 = this.l.a.f(d20, N2.j);
                    M7.J(v4 != 1);
                    if(v4 != 0) {
                        break;
                    }
                }
            }
            finally {
                this.n = d20.d - w20.f;
            }
        }
        finally {
            L7.m(this.i);
        }
    }
}

