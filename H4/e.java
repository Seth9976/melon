package h4;

import B3.N;
import B3.m;
import B3.r;
import B3.s;
import B3.t;
import B3.v;
import B3.w;
import e3.b;
import e3.p;

public final class e implements r {
    public final f a;
    public final p b;
    public final p c;
    public final N d;
    public t e;
    public long f;
    public long g;
    public boolean h;
    public boolean i;

    static {
    }

    public e(int v) {
        this.a = new f(true, null, 0);
        this.b = new p(0x800);
        this.g = -1L;
        p p0 = new p(10);
        this.c = p0;
        this.d = new N(p0.a, p0.a.length, 2, 0);
    }

    @Override  // B3.r
    public final int a(s s0, v v0) {
        b.k(this.e);
        s0.getLength();
        p p0 = this.b;
        int v1 = s0.read(p0.a, 0, 0x800);
        if(!this.i) {
            this.e.n(new w(0x8000000000000001L));
            this.i = true;
        }
        if(v1 == -1) {
            return -1;
        }
        p0.G(0);
        p0.F(v1);
        f f0 = this.a;
        if(!this.h) {
            f0.t = this.f;
            this.h = true;
        }
        f0.a(p0);
        return 0;
    }

    @Override  // B3.r
    public final boolean c(s s0) {
        int v = 0;
        while(true) {
            p p0 = this.c;
            s0.peekFully(p0.a, 0, 10);
            p0.G(0);
            if(p0.x() != 4801587) {
                break;
            }
            p0.H(3);
            int v1 = p0.t();
            v += v1 + 10;
            s0.advancePeekPosition(v1);
        }
        s0.resetPeekPosition();
        s0.advancePeekPosition(v);
        if(this.g == -1L) {
            this.g = (long)v;
        }
        int v2 = v;
        int v3 = 0;
        int v4 = 0;
        do {
            p p1 = this.c;
            ((m)s0).peekFully(p1.a, 0, 2, false);
            p1.G(0);
            if((p1.A() & 0xFFF6) == 0xFFF0) {
                ++v3;
                if(v3 >= 4 && v4 > 0xBC) {
                    return true;
                }
                ((m)s0).peekFully(p1.a, 0, 4, false);
                this.d.L(14);
                int v5 = this.d.D(13);
                if(v5 <= 6) {
                    ++v2;
                    ((m)s0).f = 0;
                    ((m)s0).a(v2, false);
                    goto label_38;
                }
                else {
                    ((m)s0).a(v5 - 6, false);
                    v4 += v5;
                    continue;
                }
                goto label_35;
            }
            else {
            label_35:
                ++v2;
                ((m)s0).f = 0;
                ((m)s0).a(v2, false);
            }
        label_38:
            v3 = 0;
            v4 = 0;
        }
        while(v2 - v < 0x2000);
        return false;
    }

    @Override  // B3.r
    public final void d(t t0) {
        this.e = t0;
        G g0 = new G(0, 1, 0, 0);
        this.a.d(t0, g0);
        t0.endTracks();
    }

    @Override  // B3.r
    public final void release() {
    }

    @Override  // B3.r
    public final void seek(long v, long v1) {
        this.h = false;
        this.a.seek();
        this.f = v1;
    }
}

