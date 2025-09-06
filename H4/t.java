package h4;

import B3.L;
import B3.N;
import B3.a;
import androidx.media3.common.b;
import b3.I;
import b3.n;
import e3.p;
import java.util.Collections;

public final class t implements i {
    public final String a;
    public final int b;
    public final p c;
    public final N d;
    public L e;
    public String f;
    public b g;
    public int h;
    public int i;
    public int j;
    public int k;
    public long l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public long r;
    public int s;
    public long t;
    public int u;
    public String v;

    public t(String s, int v) {
        this.a = s;
        this.b = v;
        p p0 = new p(0x400);
        this.c = p0;
        this.d = new N(p0.a, p0.a.length, 2, 0);
        this.l = 0x8000000000000001L;
    }

    @Override  // h4.i
    public final void a(p p0) {
        e3.b.k(this.e);
        while(p0.a() > 0) {
            int v = this.h;
            boolean z = true;
            switch(v) {
                case 0: {
                    if(p0.u() != 86) {
                        continue;
                    }
                    this.h = 1;
                    continue;
                }
                case 1: {
                    int v11 = p0.u();
                    if((v11 & 0xE0) == 0xE0) {
                        this.k = v11;
                        this.h = 2;
                        continue;
                    }
                    if(v11 != 86) {
                        break;
                    }
                    continue;
                }
                default: {
                    p p1 = this.c;
                    N n0 = this.d;
                    switch(v) {
                        case 2: {
                            int v1 = (this.k & 0xFFFFFF1F) << 8 | p0.u();
                            this.j = v1;
                            if(v1 > p1.a.length) {
                                p1.D(v1);
                                byte[] arr_b = p1.a;
                                n0.getClass();
                                n0.K(arr_b, arr_b.length);
                            }
                            this.i = 0;
                            this.h = 3;
                            break;
                        }
                        case 3: {
                            int v2 = Math.min(p0.a(), this.j - this.i);
                            p0.e(n0.d, this.i, v2);
                            int v3 = this.i + v2;
                            this.i = v3;
                            if(v3 != this.j) {
                                break;
                            }
                            n0.L(0);
                            if(!n0.C()) {
                                this.m = true;
                                int v4 = n0.D(1);
                                int v5 = v4 == 1 ? n0.D(1) : 0;
                                this.n = v5;
                                if(v5 != 0) {
                                    throw I.a(null, null);
                                }
                                if(v4 == 1) {
                                    n0.D((n0.D(2) + 1) * 8);
                                }
                                if(!n0.C()) {
                                    throw I.a(null, null);
                                }
                                this.o = n0.D(6);
                                if(n0.D(4) != 0 || n0.D(3) != 0) {
                                    throw I.a(null, null);
                                }
                                if(v4 == 0) {
                                    a a0 = B3.b.m(n0, true);
                                    this.v = a0.a;
                                    this.s = a0.b;
                                    this.u = a0.c;
                                    n0.L(n0.B());
                                    byte[] arr_b1 = new byte[0];
                                    n0.E(0, arr_b1);
                                    n n1 = new n();
                                    n1.a = this.f;
                                    n1.m = "audio/mp4a-latm";
                                    n1.j = this.v;
                                    n1.B = this.u;
                                    n1.C = this.s;
                                    n1.p = Collections.singletonList(arr_b1);
                                    n1.d = this.a;
                                    n1.f = this.b;
                                    b b0 = new b(n1);
                                    if(!b0.equals(this.g)) {
                                        this.g = b0;
                                        this.t = 1024000000L / ((long)b0.D);
                                        this.e.b(b0);
                                    }
                                }
                                else {
                                    int v6 = (int)(((long)n0.D((n0.D(2) + 1) * 8)));
                                    a a1 = B3.b.m(n0, true);
                                    this.v = a1.a;
                                    this.s = a1.b;
                                    this.u = a1.c;
                                    n0.O(v6);
                                }
                                int v7 = n0.D(3);
                                this.p = v7;
                                switch(v7) {
                                    case 0: {
                                        n0.O(8);
                                        break;
                                    }
                                    case 1: {
                                        n0.O(9);
                                        break;
                                    }
                                    case 3: 
                                    case 4: 
                                    case 5: {
                                        n0.O(6);
                                        break;
                                    }
                                    case 6: 
                                    case 7: {
                                        n0.O(1);
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException();
                                    }
                                }
                                boolean z1 = n0.C();
                                this.q = z1;
                                this.r = 0L;
                                if(z1) {
                                    if(v4 == 1) {
                                        this.r = (long)n0.D((n0.D(2) + 1) * 8);
                                    }
                                    else {
                                        while(true) {
                                            boolean z2 = n0.C();
                                            this.r = (this.r << 8) + ((long)n0.D(8));
                                            if(!z2) {
                                                break;
                                            }
                                        }
                                    }
                                }
                                if(n0.C()) {
                                    n0.O(8);
                                }
                                goto label_93;
                            }
                            else if(this.m) {
                            label_93:
                                if(this.n != 0 || this.o != 0 || this.p != 0) {
                                    throw I.a(null, null);
                                }
                                int v8 = 0;
                                do {
                                    int v9 = n0.D(8);
                                    v8 += v9;
                                }
                                while(v9 == 0xFF);
                                int v10 = n0.B();
                                if((v10 & 7) == 0) {
                                    p1.G(v10 >> 3);
                                }
                                else {
                                    n0.E(v8 * 8, p1.a);
                                    p1.G(0);
                                }
                                this.e.d(p1, v8, 0);
                                if(this.l == 0x8000000000000001L) {
                                    z = false;
                                }
                                e3.b.j(z);
                                this.e.c(this.l, 1, v8, 0, null);
                                this.l += this.t;
                                if(this.q) {
                                    n0.O(((int)this.r));
                                }
                            }
                            this.h = 0;
                            break;
                        }
                        default: {
                            throw new IllegalStateException();
                        }
                    }
                    continue;
                }
            }
            this.h = 0;
        }
    }

    @Override  // h4.i
    public final void b(boolean z) {
    }

    @Override  // h4.i
    public final void d(B3.t t0, G g0) {
        g0.c();
        g0.d();
        this.e = t0.track(g0.d, 1);
        g0.d();
        this.f = g0.e;
    }

    @Override  // h4.i
    public final void packetStarted(long v, int v1) {
        this.l = v;
    }

    @Override  // h4.i
    public final void seek() {
        this.h = 0;
        this.l = 0x8000000000000001L;
        this.m = false;
    }
}

