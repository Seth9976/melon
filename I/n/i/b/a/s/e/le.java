package i.n.i.b.a.s.e;

import B3.v;
import java.io.IOException;

public final class le implements q4 {
    public final u a;
    public final wb b;
    public ie c;
    public int d;
    public int e;
    public long f;
    public int g;
    public int h;

    public le(u u0) {
        this.a = u0;
        this.b = new wb(9);
        this.d = 0;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void d(long v, long v1) {
        this.d = 0;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final boolean e(i5 i50) {
        this.b.l(8);
        i50.s(this.b.a, 0, 8);
        return this.b.p() == 0x52434301;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final int f(i5 i50, v v0) {
        M7.G(this.c);
        while(true) {
            int v1 = this.d;
            wb wb0 = this.b;
            if(v1 != 0) {
                switch(v1) {
                    case 1: {
                        int v3 = this.e;
                        if(v3 == 0) {
                            wb0.l(5);
                            if(!((D2)i50).f(wb0.a, 0, 5, true)) {
                                this.d = 0;
                                return -1;
                            }
                            this.f = wb0.A() * 1000L / 45L;
                        }
                        else {
                            if(v3 != 1) {
                                throw new H4("Unsupported version number: " + this.e);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                            }
                            wb0.l(9);
                            if(!((D2)i50).f(wb0.a, 0, 9, true)) {
                                this.d = 0;
                                return -1;
                            }
                            this.f = wb0.w();
                        }
                        this.g = wb0.z();
                        this.h = 0;
                        this.d = 2;
                        continue;
                    }
                    case 2: {
                        while(this.g > 0) {
                            wb0.l(3);
                            ((D2)i50).f(wb0.a, 0, 3, false);
                            this.c.b(3, wb0);
                            this.h += 3;
                            --this.g;
                        }
                        int v2 = this.h;
                        if(v2 > 0) {
                            this.c.f(this.f, 1, v2, 0, null);
                        }
                        this.d = 1;
                        return 0;
                    }
                    default: {
                        throw new IllegalStateException();
                    }
                }
            }
            wb0.l(8);
            if(!((D2)i50).f(wb0.a, 0, 8, true)) {
                break;
            }
            if(wb0.p() != 0x52434301) {
                throw new IOException("Input not RawCC");
            }
            this.e = wb0.z();
            this.d = 1;
        }
        return -1;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void g(U5 u50) {
        u50.t(new K8(0x8000000000000001L));
        ie ie0 = u50.i(0, 3);
        this.c = ie0;
        ie0.a(this.a);
        u50.b();
    }
}

