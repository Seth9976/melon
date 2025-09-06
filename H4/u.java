package h4;

import B3.D;
import B3.L;
import B3.t;
import b3.H;
import b3.n;
import e3.b;
import e3.p;

public final class u implements i {
    public final p a;
    public final D b;
    public final String c;
    public final int d;
    public L e;
    public String f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public long k;
    public int l;
    public long m;

    public u(String s, int v) {
        this.g = 0;
        p p0 = new p(4);
        this.a = p0;
        p0.a[0] = -1;
        this.b = new D();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.m = 0x8000000000000001L;
        this.c = s;
        this.d = v;
    }

    @Override  // h4.i
    public final void a(p p0) {
        b.k(this.e);
    label_1:
        while(p0.a() > 0) {
            p p1 = this.a;
            boolean z = true;
            switch(this.g) {
                case 0: {
                    byte[] arr_b = p0.a;
                    int v = p0.b;
                    int v1 = p0.c;
                    while(v < v1) {
                        int v2 = arr_b[v];
                        boolean z1 = this.j && (v2 & 0xE0) == 0xE0;
                        this.j = (v2 & 0xFF) == 0xFF;
                        if(z1) {
                            p0.G(v + 1);
                            this.j = false;
                            p1.a[1] = arr_b[v];
                            this.h = 2;
                            this.g = 1;
                            continue label_1;
                        }
                        ++v;
                    }
                    p0.G(v1);
                    continue;
                }
                case 1: {
                    int v3 = Math.min(p0.a(), 4 - this.h);
                    p0.e(p1.a, this.h, v3);
                    int v4 = this.h + v3;
                    this.h = v4;
                    if(v4 < 4) {
                        continue;
                    }
                    p1.G(0);
                    int v5 = p1.g();
                    D d0 = this.b;
                    if(d0.b(v5)) {
                        this.l = d0.c;
                        if(!this.i) {
                            this.k = ((long)d0.g) * 1000000L / ((long)d0.d);
                            n n0 = new n();
                            n0.a = this.f;
                            n0.m = H.l(d0.b);
                            n0.n = 0x1000;
                            n0.B = d0.e;
                            n0.C = d0.d;
                            n0.d = this.c;
                            n0.f = this.d;
                            androidx.media3.common.b b0 = new androidx.media3.common.b(n0);
                            this.e.b(b0);
                            this.i = true;
                        }
                        p1.G(0);
                        this.e.d(p1, 4, 0);
                        this.g = 2;
                    }
                    else {
                        this.h = 0;
                        this.g = 1;
                    }
                    continue;
                }
                case 2: {
                    int v6 = Math.min(p0.a(), this.l - this.h);
                    this.e.d(p0, v6, 0);
                    int v7 = this.h + v6;
                    this.h = v7;
                    if(v7 < this.l) {
                        continue;
                    }
                    if(this.m == 0x8000000000000001L) {
                        z = false;
                    }
                    break;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
            b.j(z);
            this.e.c(this.m, 1, this.l, 0, null);
            this.m += this.k;
            this.h = 0;
            this.g = 0;
        }
    }

    @Override  // h4.i
    public final void b(boolean z) {
    }

    @Override  // h4.i
    public final void d(t t0, G g0) {
        g0.c();
        g0.d();
        this.f = g0.e;
        g0.d();
        this.e = t0.track(g0.d, 1);
    }

    @Override  // h4.i
    public final void packetStarted(long v, int v1) {
        this.m = v;
    }

    @Override  // h4.i
    public final void seek() {
        this.g = 0;
        this.h = 0;
        this.j = false;
        this.m = 0x8000000000000001L;
    }
}

