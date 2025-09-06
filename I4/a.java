package i4;

import B3.L;
import B3.s;
import B3.t;
import V3.d;
import b3.I;
import b3.n;
import e3.p;
import e3.x;
import java.math.RoundingMode;

public final class a implements b {
    public final t a;
    public final L b;
    public final d c;
    public final int d;
    public final byte[] e;
    public final p f;
    public final int g;
    public final androidx.media3.common.b h;
    public int i;
    public long j;
    public int k;
    public long l;
    public static final int[] m;
    public static final int[] n;

    static {
        a.m = new int[]{-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        a.n = new int[]{7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 0x1F, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 0x76, 130, 0x8F, 0x9D, 0xAD, 190, 209, 230, 0xFD, 279, 307, 337, 371, 408, 449, 494, 0x220, 598, 658, 724, 796, 876, 963, 1060, 0x48E, 0x502, 0x583, 0x610, 1707, 0x756, 2066, 0x8E0, 0x9C3, 0xABD, 0xBD0, 0xCFF, 3660, 0xFBA, 4428, 0x1307, 5358, 0x1706, 6484, 7132, 7845, 8630, 9493, 10442, 0x2CDF, 0x315B, 0x364B, 0x3BB9, 0x41B2, 18500, 20350, 0x5771, 0x602F, 27086, 0x7462, 0x7FFF};
    }

    public a(t t0, L l0, d d0) {
        this.a = t0;
        this.b = l0;
        this.c = d0;
        int v = d0.c;
        int v1 = Math.max(1, v / 10);
        this.g = v1;
        p p0 = new p(((byte[])d0.f));
        p0.n();
        int v2 = p0.n();
        this.d = v2;
        int v3 = d0.b;
        int v4 = d0.d;
        int v5 = (v4 - v3 * 4) * 8 / (d0.e * v3) + 1;
        if(v2 != v5) {
            throw I.a(null, "Expected frames per block: " + v5 + "; got: " + v2);
        }
        int v6 = (v1 + v2 - 1) / v2;
        this.e = new byte[v6 * v4];
        this.f = new p(v2 * 2 * v3 * v6);
        int v7 = v4 * v * 8 / v2;
        n n0 = new n();
        n0.m = "audio/raw";
        n0.h = v7;
        n0.i = v7;
        n0.n = v1 * 2 * v3;
        n0.B = v3;
        n0.C = v;
        n0.D = 2;
        this.h = new androidx.media3.common.b(n0);
    }

    @Override  // i4.b
    public final boolean a(s s0, long v) {
        p p0;
        byte[] arr_b;
        boolean z;
        d d0 = this.c;
        int v1 = this.g;
        int v2 = this.d;
        int v3 = x.f(v1 - this.k / (d0.b * 2), v2);
        int v4 = d0.d;
        int v5 = v3 * v4;
        if(v != 0L) {
            z = false;
            goto label_10;
        }
        while(true) {
            z = true;
        label_10:
            arr_b = this.e;
            if(z) {
                break;
            }
            int v6 = this.i;
            if(v6 >= v5) {
                break;
            }
            int v7 = s0.read(arr_b, this.i, ((int)Math.min(v5 - v6, v)));
            if(v7 == -1) {
                continue;
            }
            this.i += v7;
            goto label_10;
        }
        int v8 = this.i / v4;
        if(v8 > 0) {
            for(int v9 = 0; true; ++v9) {
                p0 = this.f;
                if(v9 >= v8) {
                    break;
                }
                for(int v10 = 0; true; ++v10) {
                    int v11 = d0.b;
                    if(v10 >= v11) {
                        break;
                    }
                    byte[] arr_b1 = p0.a;
                    int v12 = v10 * 4 + v9 * v4;
                    int v13 = v11 * 4 + v12;
                    int v14 = v4 / v11 - 4;
                    int v15 = (short)(arr_b[v12] & 0xFF | (arr_b[v12 + 1] & 0xFF) << 8);
                    int v16 = Math.min(arr_b[v12 + 2] & 0xFF, 88);
                    int[] arr_v = a.n;
                    int v17 = arr_v[v16];
                    int v18 = (v9 * v2 * v11 + v10) * 2;
                    arr_b1[v18] = (byte)(v15 & 0xFF);
                    arr_b1[v18 + 1] = (byte)(v15 >> 8);
                    for(int v19 = 0; v19 < v14 * 2; ++v19) {
                        int v20 = arr_b[v19 / 8 * v11 * 4 + v13 + v19 / 2 % 4];
                        int v21 = v19 % 2 == 0 ? v20 & 15 : (v20 & 0xFF) >> 4;
                        v15 = x.h(v15 + ((v21 & 8) == 0 ? ((v21 & 7) * 2 + 1) * v17 >> 3 : -(((v21 & 7) * 2 + 1) * v17 >> 3)), 0xFFFF8000, 0x7FFF);
                        v18 = v11 * 2 + v18;
                        arr_b1[v18] = (byte)(v15 & 0xFF);
                        arr_b1[v18 + 1] = (byte)(v15 >> 8);
                        v16 = x.h(v16 + a.m[v21], 0, 88);
                        v17 = arr_v[v16];
                    }
                }
            }
            int v22 = v2 * v8 * 2 * d0.b;
            p0.G(0);
            p0.F(v22);
            this.i -= v8 * v4;
            int v23 = p0.c;
            this.b.d(p0, v23, 0);
            int v24 = this.k + v23;
            this.k = v24;
            if(v24 / (d0.b * 2) >= v1) {
                this.b(v1);
            }
        }
        if(z) {
            int v25 = this.k / (d0.b * 2);
            if(v25 > 0) {
                this.b(v25);
            }
        }
        return z;
    }

    public final void b(int v) {
        long v1 = this.j;
        long v2 = x.T(this.l, 1000000L, this.c.c, RoundingMode.DOWN);
        int v3 = v * 2 * this.c.b;
        this.b.c(v1 + v2, 1, v3, this.k - v3, null);
        this.l += (long)v;
        this.k -= v3;
    }

    @Override  // i4.b
    public final void init(int v, long v1) {
        i4.d d0 = new i4.d(this.c, this.d, ((long)v), v1);
        this.a.n(d0);
        this.b.b(this.h);
    }

    @Override  // i4.b
    public final void reset(long v) {
        this.i = 0;
        this.j = v;
        this.k = 0;
        this.l = 0L;
    }
}

