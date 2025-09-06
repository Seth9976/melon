package v3;

import I6.H;
import I6.V;
import I6.w0;
import androidx.media3.common.b;
import androidx.media3.exoplayer.e;
import b3.q0;
import java.util.Objects;

public final class m extends l {
    public final boolean B;
    public final int D;
    public final boolean e;
    public final h f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final boolean n;
    public final boolean o;
    public final int r;
    public final boolean w;

    public m(int v, q0 q00, int v1, h h0, int v2, int v3, boolean z) {
        super(v, q00, v1);
        int v13;
        int v9;
        this.f = h0;
        V v4 = h0.l;
        int v5 = h0.j0 ? 24 : 16;
        int v6 = 0;
        this.o = false;
        this.e = z && ((this.d.u == -1 || this.d.u <= h0.a) && (this.d.v == -1 || this.d.v <= h0.b) && (this.d.w == -1.0f || this.d.w <= ((float)h0.c)) && (this.d.j == -1 || this.d.j <= h0.d));
        this.g = z && ((this.d.u == -1 || this.d.u >= h0.e) && (this.d.v == -1 || this.d.v >= h0.f) && (this.d.w == -1.0f || this.d.w >= ((float)h0.g)) && (this.d.j == -1 || this.d.j >= h0.h));
        this.h = e.j(v2, false);
        b b0 = this.d;
        this.i = b0.w != -1.0f && b0.w >= 10.0f;
        this.j = b0.j;
        int v7 = b0.u;
        if(v7 == -1) {
            v9 = -1;
        }
        else {
            int v8 = b0.v;
            v9 = v8 == -1 ? -1 : v7 * v8;
        }
        this.k = v9;
        int v10 = 0x7FFFFFFF;
        this.m = b0.f == 0 || b0.f != h0.m ? Integer.bitCount(h0.m & b0.f) : 0x7FFFFFFF;
        int v11 = this.d.f;
        this.n = v11 == 0 || (v11 & 1) != 0;
        for(int v12 = 0; v12 < v4.size(); ++v12) {
            String s = this.d.n;
            if(s != null && s.equals(v4.get(v12))) {
                v10 = v12;
                break;
            }
        }
        this.l = v10;
        this.w = (v2 & 0x180) == 0x80;
        this.B = (v2 & 0x40) == 0x40;
        b b1 = this.d;
        String s1 = b1.n;
        if(s1 == null) {
            v13 = 0;
        }
        else {
            v13 = 4;
            switch(s1) {
                case "video/av01": {
                    break;
                }
                case "video/avc": {
                    v13 = 1;
                    break;
                }
                case "video/dolby-vision": {
                    v13 = 5;
                    break;
                }
                case "video/hevc": {
                    v13 = 3;
                    break;
                }
                case "video/x-vnd.on2.vp9": {
                    v13 = 2;
                    break;
                }
                default: {
                    v13 = 0;
                }
            }
        }
        this.D = v13;
        boolean z1 = this.e;
        h h1 = this.f;
        if((b1.f & 0x4000) == 0 && e.j(v2, h1.n0) && (z1 || h1.i0)) {
            v6 = !e.j(v2, false) || !this.g || !z1 || b1.j == -1 || h1.z || h1.y || (v5 & v2) == 0 ? 1 : 2;
        }
        this.r = v6;
    }

    @Override  // v3.l
    public final int a() {
        return this.r;
    }

    @Override  // v3.l
    public final boolean b(l l0) {
        if(this.o || Objects.equals(this.d.n, ((m)l0).d.n)) {
            this.f.getClass();
            return this.w == ((m)l0).w && this.B == ((m)l0).B;
        }
        return false;
    }

    public static int c(m m0, m m1) {
        H h0 = H.a.c(m0.h, m1.h).a(m0.m, m1.m).c(m0.n, m1.n).c(m0.i, m1.i).c(m0.e, m1.e).c(m0.g, m1.g).b(m0.l, m1.l, w0.a).c(m0.w, m1.w).c(m0.B, m1.B);
        if(m0.w && m0.B) {
            h0 = h0.a(m0.D, m1.D);
        }
        return h0.e();
    }
}

