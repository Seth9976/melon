package Y3;

import Ac.X3;
import B3.C;
import B3.L;
import B3.r;
import B3.s;
import B3.t;
import B3.v;
import androidx.media3.common.b;
import b3.I;
import b3.n;
import e3.p;
import e3.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import ye.a;

public final class h implements r {
    public final l a;
    public final b b;
    public final ArrayList c;
    public final p d;
    public byte[] e;
    public L f;
    public int g;
    public int h;
    public long[] i;
    public long j;

    public h(l l0, b b0) {
        this.a = l0;
        this.e = x.f;
        this.d = new p();
        n n0 = b0.a();
        n0.m = "application/x-media3-cues";
        n0.j = b0.n;
        n0.H = l0.j();
        this.b = new b(n0);
        this.c = new ArrayList();
        this.h = 0;
        this.i = x.g;
        this.j = 0x8000000000000001L;
    }

    @Override  // B3.r
    public final int a(s s0, v v0) {
        e3.b.j(this.h != 0 && this.h != 5);
        int v1 = 0x400;
        if(this.h == 1) {
            int v2 = s0.getLength() == -1L ? 0x400 : a.t(s0.getLength());
            if(v2 > this.e.length) {
                this.e = new byte[v2];
            }
            this.g = 0;
            this.h = 2;
        }
        ArrayList arrayList0 = this.c;
        if(this.h == 2) {
            byte[] arr_b = this.e;
            if(arr_b.length == this.g) {
                this.e = Arrays.copyOf(arr_b, arr_b.length + 0x400);
            }
            int v3 = s0.read(this.e, this.g, this.e.length - this.g);
            if(v3 != -1) {
                this.g += v3;
            }
            long v4 = s0.getLength();
            if(v4 != -1L && ((long)this.g) == v4 || v3 == -1) {
                try {
                    k k0 = this.j == 0x8000000000000001L ? k.c : new k(this.j, true);
                    byte[] arr_b1 = this.e;
                    int v5 = this.g;
                    X3 x30 = new X3(this, 18);
                    this.a.g(arr_b1, 0, v5, k0, x30);
                    Collections.sort(arrayList0);
                    this.i = new long[arrayList0.size()];
                    for(int v6 = 0; v6 < arrayList0.size(); ++v6) {
                        long[] arr_v = this.i;
                        arr_v[v6] = ((g)arrayList0.get(v6)).a;
                    }
                    this.e = x.f;
                    this.h = 4;
                    goto label_36;
                }
                catch(RuntimeException runtimeException0) {
                }
                throw I.a(runtimeException0, "SubtitleParser failed.");
            }
        }
    label_36:
        if(this.h == 3) {
            if(s0.getLength() != -1L) {
                v1 = a.t(s0.getLength());
            }
            if(s0.skip(v1) == -1) {
                for(int v7 = this.j == 0x8000000000000001L ? 0 : x.e(this.i, this.j, true); v7 < arrayList0.size(); ++v7) {
                    this.e(((g)arrayList0.get(v7)));
                }
                this.h = 4;
            }
        }
        return this.h == 4 ? -1 : 0;
    }

    @Override  // B3.r
    public final boolean c(s s0) {
        return true;
    }

    @Override  // B3.r
    public final void d(t t0) {
        e3.b.j(this.h == 0);
        L l0 = t0.track(0, 3);
        this.f = l0;
        l0.b(this.b);
        t0.endTracks();
        t0.n(new C(0x8000000000000001L, new long[]{0L}, new long[]{0L}));
        this.h = 1;
    }

    public final void e(g g0) {
        e3.b.k(this.f);
        this.d.getClass();
        this.d.E(g0.b, g0.b.length);
        this.f.d(this.d, g0.b.length, 0);
        this.f.c(g0.a, 1, g0.b.length, 0, null);
    }

    @Override  // B3.r
    public final void release() {
        if(this.h == 5) {
            return;
        }
        this.a.reset();
        this.h = 5;
    }

    @Override  // B3.r
    public final void seek(long v, long v1) {
        e3.b.j(this.h != 0 && this.h != 5);
        this.j = v1;
        if(this.h == 2) {
            this.h = 1;
        }
        if(this.h == 4) {
            this.h = 3;
        }
    }
}

