package i.n.i.b.a.s.e;

import B3.v;
import h4.G;

public final class q implements q4 {
    public final W a;
    public final wb b;
    public boolean c;
    public static final p d;

    static {
        q.d = new p(0);
    }

    public q() {
        this.a = new W(null, 0);
        this.b = new wb(0xAE2);
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void d(long v, long v1) {
        this.c = false;
        this.a.a();
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final boolean e(i5 i50) {
        int v4;
        wb wb0 = new wb(10);
        int v = 0;
        while(true) {
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
        int v2 = 0;
        int v3 = v;
        while(true) {
            i50.s(wb0.a, 0, 6);
            wb0.n(0);
            if(wb0.b() == 0xB77) {
                ++v2;
                if(v2 >= 4) {
                    return true;
                }
                byte[] arr_b = wb0.a;
                if(arr_b.length < 6) {
                    v4 = -1;
                }
                else {
                    v4 = (arr_b[5] & 0xF8) >> 3 <= 10 ? Ja.b((arr_b[4] & 0xC0) >> 6, arr_b[4] & 0x3F) : (((arr_b[2] & 7) << 8 | arr_b[3] & 0xFF) + 1) * 2;
                }
                if(v4 == -1) {
                    return false;
                }
                goto label_33;
            }
            else {
                i50.b();
                ++v3;
                if(v3 - v < 0x2000) {
                    i50.e(v3);
                    v2 = 0;
                    continue;
                }
            }
            return false;
        label_33:
            i50.e(v4 - 6);
        }
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final int f(i5 i50, v v0) {
        wb wb0 = this.b;
        int v1 = ((D2)i50).o(wb0.a, 0, 0xAE2);
        if(v1 == -1) {
            return -1;
        }
        wb0.n(0);
        wb0.m(v1);
        W w0 = this.a;
        if(!this.c) {
            w0.m = 0L;
            this.c = true;
        }
        w0.c(wb0);
        return 0;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void g(U5 u50) {
        G g0 = new G(0, 1, 1, 0);
        this.a.e(u50, g0);
        u50.b();
        u50.t(new K8(0x8000000000000001L));
    }
}

