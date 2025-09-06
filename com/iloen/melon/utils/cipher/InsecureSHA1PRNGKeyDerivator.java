package com.iloen.melon.utils.cipher;

class InsecureSHA1PRNGKeyDerivator {
    public transient int[] a;
    public transient long b;
    public transient int[] c;
    public transient byte[] d;
    public transient int e;
    public transient long f;
    public transient int g;
    public static final int[] h;
    public static final int[] i;
    public static final int[] j;
    public static final int[] k;
    public static final int[] l;

    static {
        InsecureSHA1PRNGKeyDerivator.h = new int[]{0x80000000, 0x800000, 0x8000, 0x80};
        InsecureSHA1PRNGKeyDerivator.i = new int[]{0, 40, 0x30, 56};
        InsecureSHA1PRNGKeyDerivator.j = new int[]{0, 8, 16, 24};
        InsecureSHA1PRNGKeyDerivator.k = new int[]{0, 24, 16, 8};
        InsecureSHA1PRNGKeyDerivator.l = new int[]{-1, 0xFFFFFF, 0xFFFF, 0xFF};
    }

    public static void a(int[] arr_v) {
        int v14;
        int v11;
        int v8;
        int v = arr_v[82];
        int v1 = arr_v[83];
        int v2 = arr_v[84];
        int v3 = arr_v[85];
        int v4 = arr_v[86];
        for(int v5 = 16; v5 < 80; ++v5) {
            int v6 = arr_v[v5 - 3] ^ arr_v[v5 - 8] ^ arr_v[v5 - 14] ^ arr_v[v5 - 16];
            arr_v[v5] = v6 >>> 0x1F | v6 << 1;
        }
        int v7 = 0;
        while(true) {
            v8 = 20;
            if(v7 >= 20) {
                break;
            }
            int v9 = v4 + arr_v[v7] + 1518500249 + ((v << 5 | v >>> 27) + (v1 & v2 | ~v1 & v3));
            ++v7;
            int v10 = v1 >>> 2 | v1 << 30;
            v1 = v;
            v = v9;
            v4 = v3;
            v3 = v2;
            v2 = v10;
        }
        while(true) {
            v11 = 40;
            if(v8 >= 40) {
                break;
            }
            int v12 = v4 + arr_v[v8] + 0x6ED9EBA1 + ((v << 5 | v >>> 27) + (v1 ^ v2 ^ v3));
            ++v8;
            int v13 = v1 >>> 2 | v1 << 30;
            v1 = v;
            v = v12;
            v4 = v3;
            v3 = v2;
            v2 = v13;
        }
        while(true) {
            v14 = 60;
            if(v11 >= 60) {
                break;
            }
            int v15 = v4 + arr_v[v11] - 1894007588 + ((v << 5 | v >>> 27) + ((v2 | v3) & v1 | v2 & v3));
            ++v11;
            int v16 = v1 >>> 2 | v1 << 30;
            v1 = v;
            v = v15;
            v4 = v3;
            v3 = v2;
            v2 = v16;
        }
        while(v14 < 80) {
            int v17 = v4 + arr_v[v14] - 0x359D3E2A + ((v << 5 | v >>> 27) + (v1 ^ v2 ^ v3));
            ++v14;
            int v18 = v1 >>> 2 | v1 << 30;
            v1 = v;
            v = v17;
            v4 = v3;
            v3 = v2;
            v2 = v18;
        }
        arr_v[82] += v;
        arr_v[83] += v1;
        arr_v[84] += v2;
        arr_v[85] += v3;
        arr_v[86] += v4;
    }

    public static byte[] deriveInsecureKey(byte[] arr_b, int v) {
        int v6;
        int v5;
        InsecureSHA1PRNGKeyDerivator insecureSHA1PRNGKeyDerivator0 = new InsecureSHA1PRNGKeyDerivator();  // 初始化器: Ljava/lang/Object;-><init>()V
        int[] arr_v = new int[87];
        insecureSHA1PRNGKeyDerivator0.a = arr_v;
        arr_v[82] = 0x67452301;
        arr_v[83] = 0xEFCDAB89;
        arr_v[84] = 0x98BADCFE;
        arr_v[85] = 0x10325476;
        arr_v[86] = -1009589776;
        insecureSHA1PRNGKeyDerivator0.b = 0L;
        insecureSHA1PRNGKeyDerivator0.c = new int[37];
        insecureSHA1PRNGKeyDerivator0.d = new byte[20];
        insecureSHA1PRNGKeyDerivator0.e = 20;
        insecureSHA1PRNGKeyDerivator0.f = 0L;
        insecureSHA1PRNGKeyDerivator0.g = 0;
        if(arr_b == null) {
            throw new NullPointerException("seed == null");
        }
        insecureSHA1PRNGKeyDerivator0.g = 1;
        if(arr_b.length != 0) {
            int v1 = arr_b.length - 1;
            int v2 = arr_v[81] >> 2;
            int v3 = arr_v[81] & 3;
            arr_v[81] = arr_v[81] + v1 + 1 & 0x3F;
            int v4 = 0;
            if(v3 == 0) {
                v5 = v1 + 1 >> 2;
                v6 = 0;
            label_39:
                while(v6 < v5) {
                    arr_v[v2] = (arr_b[v4] & 0xFF) << 24 | (arr_b[v4 + 1] & 0xFF) << 16 | (arr_b[v4 + 2] & 0xFF) << 8 | arr_b[v4 + 3] & 0xFF;
                    v4 += 4;
                    ++v2;
                    if(v2 >= 16) {
                        InsecureSHA1PRNGKeyDerivator.a(arr_v);
                        v2 = 0;
                    }
                    ++v6;
                }
                int v7 = v1 - v4 + 1;
                if(v7 != 0) {
                    int v8 = (arr_b[v4] & 0xFF) << 24;
                    if(v7 != 1) {
                        v8 |= (arr_b[v4 + 1] & 0xFF) << 16;
                        if(v7 != 2) {
                            v8 |= (arr_b[v4 + 2] & 0xFF) << 8;
                        }
                    }
                    arr_v[v2] = v8;
                }
            }
            else {
                while(v4 <= v1 && v3 < 4) {
                    arr_v[v2] |= (arr_b[v4] & 0xFF) << (3 - v3 << 3);
                    ++v3;
                    ++v4;
                }
                if(v3 == 4) {
                    ++v2;
                    if(v2 == 16) {
                        InsecureSHA1PRNGKeyDerivator.a(arr_v);
                        v2 = 0;
                    }
                }
                if(v4 <= v1) {
                    v5 = v1 - v4 + 1 >> 2;
                    v6 = 0;
                    goto label_39;
                }
            }
            insecureSHA1PRNGKeyDerivator0.b += (long)arr_b.length;
        }
        byte[] arr_b1 = new byte[v];
        insecureSHA1PRNGKeyDerivator0.nextBytes(arr_b1);
        return arr_b1;
    }

    public void nextBytes(byte[] arr_b) {
        int v3;
        synchronized(this) {
            if(arr_b != null) {
                int[] arr_v = this.a;
                int v1 = arr_v[81];
                int v2 = v1 == 0 ? 0 : v1 + 7 >> 2;
                switch(this.g) {
                    case 0: {
                        throw new IllegalStateException("No seed supplied!");
                    }
                    case 1: {
                        System.arraycopy(arr_v, 82, this.c, 0, 5);
                        for(int v4 = v2 + 3; v4 < 18; ++v4) {
                            this.a[v4] = 0;
                        }
                        long v5 = (this.b << 3) + 0x40L;
                        int[] arr_v1 = this.a;
                        if(arr_v1[81] < 0x30) {
                            v3 = v2;
                            arr_v1[14] = (int)(v5 >>> 0x20);
                            arr_v1[15] = (int)v5;
                        }
                        else {
                            v3 = v2;
                            int[] arr_v2 = this.c;
                            arr_v2[19] = (int)(v5 >>> 0x20);
                            arr_v2[20] = (int)v5;
                        }
                        this.e = 20;
                        break;
                    }
                    default: {
                        v3 = v2;
                        break;
                    }
                }
                this.g = 2;
                if(arr_b.length == 0) {
                    return;
                }
                int v6 = this.e;
                int v7 = 20 - v6 < arr_b.length ? 20 - v6 : arr_b.length;
                if(v7 > 0) {
                    System.arraycopy(this.d, v6, arr_b, 0, v7);
                    this.e += v7;
                }
                else {
                    v7 = 0;
                }
                if(v7 >= arr_b.length) {
                    return;
                }
                int v8 = this.a[81] & 3;
                do {
                    if(v8 == 0) {
                        int[] arr_v3 = this.a;
                        long v9 = this.f;
                        arr_v3[v3] = (int)(v9 >>> 0x20);
                        arr_v3[v3 + 1] = (int)v9;
                        arr_v3[v3 + 2] = InsecureSHA1PRNGKeyDerivator.h[0];
                    }
                    else {
                        int[] arr_v4 = this.a;
                        long v10 = this.f;
                        arr_v4[v3] |= (int)(v10 >>> InsecureSHA1PRNGKeyDerivator.i[v8] & ((long)InsecureSHA1PRNGKeyDerivator.l[v8]));
                        arr_v4[v3 + 1] = (int)(v10 >>> InsecureSHA1PRNGKeyDerivator.j[v8]);
                        arr_v4[v3 + 2] = (int)(((long)InsecureSHA1PRNGKeyDerivator.h[v8]) | v10 << InsecureSHA1PRNGKeyDerivator.k[v8]);
                    }
                    int[] arr_v5 = this.a;
                    if(arr_v5[81] > 0x30) {
                        int[] arr_v6 = this.c;
                        arr_v6[5] = arr_v5[16];
                        arr_v6[6] = arr_v5[17];
                    }
                    InsecureSHA1PRNGKeyDerivator.a(arr_v5);
                    int[] arr_v7 = this.a;
                    if(arr_v7[81] > 0x30) {
                        System.arraycopy(arr_v7, 0, this.c, 21, 16);
                        System.arraycopy(this.c, 5, this.a, 0, 16);
                        InsecureSHA1PRNGKeyDerivator.a(this.a);
                        System.arraycopy(this.c, 21, this.a, 0, 16);
                    }
                    ++this.f;
                    int v11 = 0;
                    for(int v12 = 0; v12 < 5; ++v12) {
                        int v13 = this.a[v12 + 82];
                        byte[] arr_b1 = this.d;
                        arr_b1[v11] = (byte)(v13 >>> 24);
                        arr_b1[v11 + 1] = (byte)(v13 >>> 16);
                        arr_b1[v11 + 2] = (byte)(v13 >>> 8);
                        arr_b1[v11 + 3] = (byte)v13;
                        v11 += 4;
                    }
                    this.e = 0;
                    int v14 = 20 >= arr_b.length - v7 ? arr_b.length - v7 : 20;
                    if(v14 > 0) {
                        System.arraycopy(this.d, 0, arr_b, v7, v14);
                        v7 += v14;
                        this.e += v14;
                    }
                }
                while(v7 < arr_b.length);
                return;
            }
        }
        throw new NullPointerException("bytes == null");
    }
}

