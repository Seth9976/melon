package i.n.i.b.a.s.e;

public final class r3 implements s3 {
    public final U5 a;
    public final ie b;
    public final Z3 c;
    public final int d;
    public final byte[] e;
    public final wb f;
    public final int g;
    public final u h;
    public int i;
    public long j;
    public int k;
    public long l;
    public static final int[] m;
    public static final int[] n;

    static {
        r3.m = new int[]{-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        r3.n = new int[]{7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 0x1F, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 0x76, 130, 0x8F, 0x9D, 0xAD, 190, 209, 230, 0xFD, 279, 307, 337, 371, 408, 449, 494, 0x220, 598, 658, 724, 796, 876, 963, 1060, 0x48E, 0x502, 0x583, 0x610, 1707, 0x756, 2066, 0x8E0, 0x9C3, 0xABD, 0xBD0, 0xCFF, 3660, 0xFBA, 4428, 0x1307, 5358, 0x1706, 6484, 7132, 7845, 8630, 9493, 10442, 0x2CDF, 0x315B, 0x364B, 0x3BB9, 0x41B2, 18500, 20350, 0x5771, 0x602F, 27086, 0x7462, 0x7FFF};
    }

    public r3(U5 u50, ie ie0, Z3 z30) {
        this.a = u50;
        this.b = ie0;
        this.c = z30;
        int v = z30.c;
        int v1 = Math.max(1, v / 10);
        this.g = v1;
        int v2 = z30.f[0];
        int v3 = z30.f[1];
        int v4 = (z30.f[3] & 0xFF) << 8 | z30.f[2] & 0xFF;
        this.d = v4;
        int v5 = z30.b;
        int v6 = z30.d;
        int v7 = (v6 - v5 * 4) * 8 / (z30.e * v5) + 1;
        if(v4 != v7) {
            throw new H4("Expected frames per block: " + v7 + "; got: " + v4);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        int v8 = (v1 + v4 - 1) / v4;
        this.e = new byte[v8 * v6];
        this.f = new wb(v4 * 2 * v5 * v8);
        int v9 = v6 * v * 8 / v4;
        ob ob0 = new ob();
        ob0.k = "audio/raw";
        ob0.f = v9;
        ob0.g = v9;
        ob0.l = v1 * 2 * v5;
        ob0.x = v5;
        ob0.y = v;
        ob0.z = 2;
        this.h = new u(ob0);
    }

    @Override  // i.n.i.b.a.s.e.s3
    public final void a(long v) {
        this.i = 0;
        this.j = v;
        this.k = 0;
        this.l = 0L;
    }

    @Override  // i.n.i.b.a.s.e.s3
    public final boolean b(i5 i50, long v) {
        wb wb0;
        byte[] arr_b;
        boolean z;
        Z3 z30 = this.c;
        int v1 = this.g;
        int v2 = this.d;
        int v3 = L7.c(v1 - this.k / (z30.b * 2), v2);
        int v4 = z30.d;
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
            int v7 = i50.o(arr_b, this.i, ((int)Math.min(v5 - v6, v)));
            if(v7 == -1) {
                continue;
            }
            this.i += v7;
            goto label_10;
        }
        int v8 = this.i / v4;
        if(v8 > 0) {
            for(int v9 = 0; true; ++v9) {
                wb0 = this.f;
                if(v9 >= v8) {
                    break;
                }
                for(int v10 = 0; true; ++v10) {
                    int v11 = z30.b;
                    if(v10 >= v11) {
                        break;
                    }
                    byte[] arr_b1 = wb0.a;
                    int v12 = v10 * 4 + v9 * v4;
                    int v13 = v11 * 4 + v12;
                    int v14 = v4 / v11 - 4;
                    int v15 = (short)((arr_b[v12 + 1] & 0xFF) << 8 | arr_b[v12] & 0xFF);
                    int v16 = Math.min(arr_b[v12 + 2] & 0xFF, 88);
                    int[] arr_v = r3.n;
                    int v17 = arr_v[v16];
                    int v18 = (v9 * v2 * v11 + v10) * 2;
                    arr_b1[v18] = (byte)(v15 & 0xFF);
                    arr_b1[v18 + 1] = (byte)(v15 >> 8);
                    for(int v19 = 0; v19 < v14 * 2; ++v19) {
                        int v20 = arr_b[v19 / 8 * v11 * 4 + v13 + v19 / 2 % 4];
                        int v21 = v19 % 2 == 0 ? v20 & 15 : (v20 & 0xFF) >> 4;
                        v15 = L7.d(v15 + ((v21 & 8) == 0 ? ((v21 & 7) * 2 + 1) * v17 >> 3 : -(((v21 & 7) * 2 + 1) * v17 >> 3)), 0xFFFF8000, 0x7FFF);
                        v18 = v11 * 2 + v18;
                        arr_b1[v18] = (byte)(v15 & 0xFF);
                        arr_b1[v18 + 1] = (byte)(v15 >> 8);
                        v16 = L7.d(v16 + r3.m[v21], 0, 88);
                        v17 = arr_v[v16];
                    }
                }
            }
            wb0.n(0);
            wb0.m(v2 * v8 * 2 * z30.b);
            this.i -= v8 * v4;
            int v22 = wb0.c;
            this.b.b(v22, wb0);
            int v23 = this.k + v22;
            this.k = v23;
            if(v23 / (z30.b * 2) >= v1) {
                this.d(v1);
            }
        }
        if(z) {
            int v24 = this.k / (z30.b * 2);
            if(v24 > 0) {
                this.d(v24);
            }
        }
        return z;
    }

    @Override  // i.n.i.b.a.s.e.s3
    public final void c(int v, long v1) {
        N4 n40 = new N4(this.c, this.d, ((long)v), v1);
        this.a.t(n40);
        this.b.a(this.h);
    }

    public final void d(int v) {
        long v1 = this.j;
        long v2 = L7.C(this.l, 1000000L, this.c.c);
        int v3 = v * 2 * this.c.b;
        this.b.f(v1 + v2, 1, v3, this.k - v3, null);
        this.l += (long)v;
        this.k -= v3;
    }
}

