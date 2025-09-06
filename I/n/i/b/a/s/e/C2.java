package i.n.i.b.a.s.e;

import B3.N;
import B3.v;
import h4.G;
import java.io.EOFException;

public final class c2 implements q4 {
    public final int a;
    public final F2 b;
    public final wb c;
    public final wb d;
    public final N e;
    public U5 f;
    public long g;
    public long h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;

    static {
    }

    public c2(int v) {
        this.a = v;
        this.b = new F2(true, null);
        this.c = new wb(0x800);
        this.i = -1;
        this.h = -1L;
        wb wb0 = new wb(10);
        this.d = wb0;
        this.e = new N(wb0.a, wb0.a.length, 6, 0);
    }

    public final int a(i5 i50) {
        int v = 0;
        while(true) {
            wb wb0 = this.d;
            i50.s(wb0.a, 0, 10);
            wb0.n(0);
            if(wb0.B() != 4801587) {
                break;
            }
            wb0.o(3);
            int v1 = wb0.y();
            v += v1 + 10;
            i50.e(v1);
        }
        i50.b();
        i50.e(v);
        if(this.h == -1L) {
            this.h = (long)v;
        }
        return v;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void d(long v, long v1) {
        this.k = false;
        this.b.l = false;
        this.b.h = 0;
        this.b.i = 0;
        this.b.j = 0x100;
        this.g = v1;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final boolean e(i5 i50) {
        int v = this.a(i50);
        int v1 = v;
        while(true) {
            int v2 = 0;
            for(int v3 = 0; true; v3 += v4) {
                wb wb0 = this.d;
                i50.s(wb0.a, 0, 2);
                wb0.n(0);
                if((wb0.b() & 0xFFF6) != 0xFFF0) {
                    break;
                }
                ++v2;
                if(v2 >= 4 && v3 > 0xBC) {
                    return true;
                }
                i50.s(wb0.a, 0, 4);
                this.e.p(14);
                int v4 = this.e.a(13);
                if(v4 <= 6) {
                    return false;
                }
                i50.e(v4 - 6);
            }
            i50.b();
            ++v1;
            if(v1 - v >= 0x2000) {
                return false;
            }
            i50.e(v1);
        }
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final int f(i5 i50, v v0) {
        long v5;
        int v4;
        M7.G(this.f);
        long v1 = ((D2)i50).c;
        boolean z = (this.a & 1) != 0 && v1 != -1L;
        if(z) {
            N n0 = this.e;
            wb wb0 = this.d;
            if(!this.j) {
                this.i = -1;
                ((D2)i50).f = 0;
                long v2 = 0L;
                if(((D2)i50).d == 0L) {
                    this.a(i50);
                }
                int v3 = 0;
                while(true) {
                    try {
                        byte[] arr_b = wb0.a;
                        D2 d20 = (D2)i50;
                        if(!d20.k(arr_b, 0, 2, true)) {
                            goto label_32;
                        }
                        wb0.n(0);
                        if((wb0.b() & 0xFFF6) != 0xFFF0) {
                            v3 = 0;
                            goto label_34;
                        }
                        if(!d20.k(wb0.a, 0, 4, true)) {
                            goto label_32;
                        }
                        n0.p(14);
                        v4 = n0.a(13);
                        if(v4 > 6) {
                            goto label_22;
                        }
                        break;
                    }
                    catch(EOFException unused_ex) {
                        goto label_32;
                    }
                label_22:
                    v2 += (long)v4;
                    ++v3;
                    if(v3 == 1000) {
                        goto label_34;
                    }
                    try {
                        if(d20.d(v4 - 6, true)) {
                            continue;
                        }
                    }
                    catch(EOFException unused_ex) {
                    }
                    goto label_34;
                }
                try {
                    v5 = v2;
                    this.j = true;
                    throw new H4("Malformed ADTS stream");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                    try {
                        v3 = 0;
                        goto label_34;
                    label_32:
                        v5 = v2;
                    }
                    catch(EOFException unused_ex) {
                        goto label_32;
                    }
                }
                catch(EOFException unused_ex) {
                }
                v2 = v5;
            label_34:
                ((D2)i50).f = 0;
                this.i = v3 > 0 ? ((int)(v2 / ((long)v3))) : -1;
                this.j = true;
            }
        }
        wb wb1 = this.c;
        int v6 = ((D2)i50).o(wb1.a, 0, 0x800);
        F2 f20 = this.b;
        if(!this.l) {
            boolean z1 = z && this.i > 0;
            if(!z1 || f20.q != 0x8000000000000001L || v6 == -1) {
                if(z1) {
                    long v7 = f20.q;
                    if(v7 == 0x8000000000000001L) {
                        this.f.t(new K8(0x8000000000000001L));
                    }
                    else {
                        this.f.t(new Z1(v1, this.h, ((int)(((long)(this.i * 8)) * 1000000L / v7)), this.i));
                    }
                }
                else {
                    this.f.t(new K8(0x8000000000000001L));
                }
                this.l = true;
            }
        }
        if(v6 == -1) {
            return -1;
        }
        wb1.n(0);
        wb1.m(v6);
        if(!this.k) {
            f20.s = this.g;
            this.k = true;
        }
        f20.c(wb1);
        return 0;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void g(U5 u50) {
        this.f = u50;
        G g0 = new G(0, 1, 1, 0);
        this.b.e(u50, g0);
        u50.b();
    }
}

