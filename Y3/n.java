package Y3;

import B3.K;
import B3.L;
import androidx.media3.common.b;
import b3.H;
import e3.p;
import e3.x;
import java.io.EOFException;

public final class n implements L {
    public final L a;
    public final j b;
    public final p c;
    public int d;
    public int e;
    public byte[] f;
    public l g;
    public b h;

    public n(L l0, j j0) {
        this.a = l0;
        this.b = j0;
        this.d = 0;
        this.e = 0;
        this.f = x.f;
        this.c = new p();
    }

    @Override  // B3.L
    public final int a(b3.j j0, int v, boolean z) {
        if(this.g == null) {
            return this.a.a(j0, v, z);
        }
        this.e(v);
        int v1 = j0.read(this.f, this.e, v);
        if(v1 == -1) {
            if(!z) {
                throw new EOFException();
            }
            return -1;
        }
        this.e += v1;
        return v1;
    }

    @Override  // B3.L
    public final void b(b b0) {
        b0.n.getClass();
        String s = b0.n;
        e3.b.c(H.g(s) == 3);
        boolean z = b0.equals(this.h);
        j j0 = this.b;
        if(!z) {
            this.h = b0;
            this.g = j0.n(b0) ? j0.l(b0) : null;
        }
        L l0 = this.a;
        if(this.g == null) {
            l0.b(b0);
            return;
        }
        b3.n n0 = b0.a();
        n0.m = "application/x-media3-cues";
        n0.j = s;
        n0.r = 0x7FFFFFFFFFFFFFFFL;
        n0.H = j0.e(b0);
        l0.b(new b(n0));
    }

    @Override  // B3.L
    public final void c(long v, int v1, int v2, int v3, K k0) {
        if(this.g == null) {
            this.a.c(v, v1, v2, v3, k0);
            return;
        }
        e3.b.d(k0 == null, "DRM on subtitles is not supported");
        int v4 = this.e - v3 - v2;
        l l0 = this.g;
        byte[] arr_b = this.f;
        m m0 = new m(this, v, v1);
        l0.g(arr_b, v4, v2, k.c, m0);
        int v5 = v4 + v2;
        this.d = v5;
        if(v5 == this.e) {
            this.d = 0;
            this.e = 0;
        }
    }

    @Override  // B3.L
    public final void d(p p0, int v, int v1) {
        if(this.g == null) {
            this.a.d(p0, v, v1);
            return;
        }
        this.e(v);
        p0.e(this.f, this.e, v);
        this.e += v;
    }

    public final void e(int v) {
        int v1 = this.e;
        if(this.f.length - v1 >= v) {
            return;
        }
        int v2 = v1 - this.d;
        int v3 = Math.max(v2 * 2, v + v2);
        byte[] arr_b = this.f;
        byte[] arr_b1 = v3 > arr_b.length ? new byte[v3] : arr_b;
        System.arraycopy(arr_b, this.d, arr_b1, 0, v2);
        this.d = 0;
        this.e = v2;
        this.f = arr_b1;
    }
}

