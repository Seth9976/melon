package h4;

import B3.m;
import B3.r;
import B3.s;
import B3.t;
import B3.v;
import B3.w;
import e3.p;

public final class d implements r {
    public final b a;
    public final p b;
    public boolean c;

    static {
    }

    public d() {
        this.a = new b(null, 0, 1);
        this.b = new p(0x4000);
    }

    @Override  // B3.r
    public final int a(s s0, v v0) {
        p p0 = this.b;
        int v1 = s0.read(p0.a, 0, 0x4000);
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
        int v6;
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
            int v4 = 7;
            ((m)s0).peekFully(p0.a, 0, 7, false);
            p0.G(0);
            int v5 = p0.A();
            if(v5 == 0xAC40 || v5 == 44097) {
                ++v2;
                if(v2 >= 4) {
                    return true;
                }
                byte[] arr_b = p0.a;
                if(arr_b.length < 7) {
                    v6 = -1;
                }
                else {
                    int v7 = (arr_b[2] & 0xFF) << 8 | arr_b[3] & 0xFF;
                    if(v7 == 0xFFFF) {
                        v7 = (arr_b[4] & 0xFF) << 16 | (arr_b[5] & 0xFF) << 8 | arr_b[6] & 0xFF;
                    }
                    else {
                        v4 = 4;
                    }
                    if(v5 == 44097) {
                        v4 += 2;
                    }
                    v6 = v7 + v4;
                }
                if(v6 == -1) {
                    return false;
                }
                goto label_42;
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
        label_42:
            ((m)s0).a(v6 - 7, false);
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

