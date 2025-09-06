package h4;

import B3.m;
import B3.r;
import B3.s;
import B3.t;
import B3.v;
import B3.w;
import e3.p;

public final class a implements r {
    public final b a;
    public final p b;
    public boolean c;

    static {
    }

    public a() {
        this.a = new b();
        this.b = new p(0xAE2);
    }

    @Override  // B3.r
    public final int a(s s0, v v0) {
        p p0 = this.b;
        int v1 = s0.read(p0.a, 0, 0xAE2);
        if(v1 == -1) {
            return -1;
        }
        p0.G(0);
        p0.F(v1);
        b b0 = this.a;
        if(!this.c) {
            b0.n = 0L;
            this.c = true;
        }
        b0.a(p0);
        return 0;
    }

    @Override  // B3.r
    public final boolean c(s s0) {
        int v4;
        p p0 = new p(10);
        int v = 0;
        while(true) {
            ((m)s0).peekFully(p0.a, 0, 10, false);
            p0.G(0);
            if(p0.x() != 4801587) {
                break;
            }
            p0.H(3);
            int v1 = p0.t();
            v += v1 + 10;
            ((m)s0).a(v1, false);
        }
        ((m)s0).f = 0;
        ((m)s0).a(v, false);
        int v2 = 0;
        int v3 = v;
        while(true) {
            ((m)s0).peekFully(p0.a, 0, 6, false);
            p0.G(0);
            if(p0.A() == 0xB77) {
                ++v2;
                if(v2 >= 4) {
                    return true;
                }
                byte[] arr_b = p0.a;
                if(arr_b.length < 6) {
                    v4 = -1;
                }
                else {
                    v4 = (arr_b[5] & 0xF8) >> 3 <= 10 ? B3.b.f((arr_b[4] & 0xC0) >> 6, arr_b[4] & 0x3F) : (((arr_b[2] & 7) << 8 | arr_b[3] & 0xFF) + 1) * 2;
                }
                if(v4 == -1) {
                    return false;
                }
                goto label_33;
            }
            else {
                ((m)s0).f = 0;
                ++v3;
                if(v3 - v < 0x2000) {
                    ((m)s0).a(v3, false);
                    v2 = 0;
                    continue;
                }
            }
            return false;
        label_33:
            ((m)s0).a(v4 - 6, false);
        }
    }

    @Override  // B3.r
    public final void d(t t0) {
        G g0 = new G(0, 1, 0, 0);
        this.a.d(t0, g0);
        t0.endTracks();
        t0.n(new w(0x8000000000000001L));
    }

    @Override  // B3.r
    public final void release() {
    }

    @Override  // B3.r
    public final void seek(long v, long v1) {
        this.c = false;
        this.a.seek();
    }
}

