package i.n.i.b.a.s.e;

import java.util.Arrays;

public final class l0 {
    public final int a;
    public final int b;
    public final float c;
    public final float d;
    public final float e;
    public final int f;
    public final int g;
    public final int h;
    public final short[] i;
    public short[] j;
    public int k;
    public short[] l;
    public int m;
    public short[] n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;

    public l0(int v, int v1, float f, float f1, int v2) {
        this.a = v;
        this.b = v1;
        this.c = f;
        this.d = f1;
        this.e = ((float)v) / ((float)v2);
        this.f = v / 400;
        this.g = v / 65;
        int v3 = v / 65 * 2;
        this.h = v3;
        this.i = new short[v3];
        int v4 = v3 * v1;
        this.j = new short[v4];
        this.l = new short[v4];
        this.n = new short[v4];
    }

    public final int a(short[] arr_v, int v, int v1, int v2) {
        int v3 = v * this.b;
        int v4 = 0xFF;
        int v5 = 1;
        int v6 = 0;
        int v7 = 0;
        while(v1 <= v2) {
            int v9 = 0;
            for(int v8 = 0; v8 < v1; ++v8) {
                v9 += Math.abs(arr_v[v3 + v8] - arr_v[v3 + v1 + v8]);
            }
            if(v9 * v6 < v5 * v1) {
                v6 = v1;
                v5 = v9;
            }
            if(v9 * v4 > v7 * v1) {
                v4 = v1;
                v7 = v9;
            }
            ++v1;
        }
        this.u = v5 / v6;
        this.v = v7 / v4;
        return v6;
    }

    public static void b(int v, int v1, short[] arr_v, int v2, short[] arr_v1, int v3, short[] arr_v2, int v4) {
        for(int v5 = 0; v5 < v1; ++v5) {
            int v6 = v2 * v1 + v5;
            int v7 = v4 * v1 + v5;
            int v8 = v3 * v1 + v5;
            for(int v9 = 0; v9 < v; ++v9) {
                arr_v[v6] = (short)((arr_v2[v7] * v9 + (v - v9) * arr_v1[v8]) / v);
                v6 += v1;
                v8 += v1;
                v7 += v1;
            }
        }
    }

    public final void c(short[] arr_v, int v, int v1) {
        short[] arr_v1 = this.e(this.l, this.m, v1);
        this.l = arr_v1;
        System.arraycopy(arr_v, v * this.b, arr_v1, this.m * this.b, this.b * v1);
        this.m += v1;
    }

    public final void d(short[] arr_v, int v, int v1) {
        int v2 = this.h / v1;
        int v3 = v1 * this.b;
        int v4 = v * this.b;
        for(int v5 = 0; v5 < v2; ++v5) {
            int v7 = 0;
            for(int v6 = 0; v6 < v3; ++v6) {
                v7 += arr_v[v5 * v3 + v4 + v6];
            }
            this.i[v5] = (short)(v7 / v3);
        }
    }

    public final short[] e(short[] arr_v, int v, int v1) {
        int v2 = arr_v.length / this.b;
        return v + v1 > v2 ? Arrays.copyOf(arr_v, (v2 * 3 / 2 + v1) * this.b) : arr_v;
    }

    public final void f() {
        int v30;
        int v29;
        int v28;
        int v27;
        int v21;
        int v20;
        int v19;
        int v11;
        int v = this.m;
        float f = this.c / this.d;
        float f1 = this.e * this.d;
        int v1 = this.a;
        int v2 = this.b;
        if(Double.compare(f, 1.00001) > 0 || ((double)f) < 0.99999) {
            int v3 = this.k;
            int v4 = this.h;
            if(v3 >= v4) {
                int v5 = 0;
                do {
                    int v6 = this.r;
                    if(v6 > 0) {
                        int v7 = Math.min(v4, v6);
                        this.c(this.j, v5, v7);
                        this.r -= v7;
                        v5 += v7;
                    }
                    else {
                        short[] arr_v = this.j;
                        int v8 = v1 <= 4000 ? 1 : v1 / 4000;
                        int v9 = this.g;
                        int v10 = this.f;
                        if(v2 != 1 || v8 != 1) {
                            this.d(arr_v, v5, v8);
                            short[] arr_v1 = this.i;
                            int v12 = this.a(arr_v1, 0, v10 / v8, v9 / v8);
                            if(v8 == 1) {
                                v11 = v12;
                            }
                            else {
                                int v13 = v12 * v8;
                                int v14 = v13 - v8 * 4;
                                int v15 = v13 + v8 * 4;
                                if(v14 >= v10) {
                                    v10 = v14;
                                }
                                if(v15 <= v9) {
                                    v9 = v15;
                                }
                                if(v2 == 1) {
                                    v11 = this.a(arr_v, v5, v10, v9);
                                }
                                else {
                                    this.d(arr_v, v5, 1);
                                    v11 = this.a(arr_v1, 0, v10, v9);
                                }
                            }
                        }
                        else {
                            v11 = this.a(arr_v, v5, v10, v9);
                        }
                        int v16 = this.u;
                        int v17 = this.v;
                        if(v16 == 0) {
                            v19 = v11;
                        }
                        else {
                            int v18 = this.s;
                            if(v18 != 0 && v17 <= v16 * 3 && v16 * 2 > this.t * 3) {
                                v19 = v18;
                            }
                        }
                        this.t = v16;
                        this.s = v11;
                        if(Double.compare(f, 1.0) > 0) {
                            short[] arr_v2 = this.j;
                            if(f >= 2.0f) {
                                v20 = (int)(((float)v19) / (f - 1.0f));
                            }
                            else {
                                this.r = (int)((2.0f - f) * ((float)v19) / (f - 1.0f));
                                v20 = v19;
                            }
                            short[] arr_v3 = this.e(this.l, this.m, v20);
                            this.l = arr_v3;
                            l0.b(v20, this.b, arr_v3, this.m, arr_v2, v5, arr_v2, v5 + v19);
                            this.m += v20;
                            v5 = v19 + v20 + v5;
                        }
                        else {
                            short[] arr_v4 = this.j;
                            if(f < 0.5f) {
                                v21 = (int)(((float)v19) * f / (1.0f - f));
                            }
                            else {
                                this.r = (int)((2.0f * f - 1.0f) * ((float)v19) / (1.0f - f));
                                v21 = v19;
                            }
                            int v22 = v19 + v21;
                            short[] arr_v5 = this.e(this.l, this.m, v22);
                            this.l = arr_v5;
                            System.arraycopy(arr_v4, v5 * v2, arr_v5, this.m * v2, v19 * v2);
                            l0.b(v21, this.b, this.l, this.m + v19, arr_v4, v5 + v19, arr_v4, v5);
                            this.m += v22;
                            v5 += v21;
                        }
                    }
                }
                while(v5 + v4 <= v3);
                int v23 = this.k - v5;
                System.arraycopy(this.j, v5 * v2, this.j, 0, v23 * v2);
                this.k = v23;
            }
        }
        else {
            this.c(this.j, 0, this.k);
            this.k = 0;
        }
        if(f1 != 1.0f && this.m != v) {
            int v24 = (int)(((float)v1) / f1);
            while(v24 > 0x4000 || v1 > 0x4000) {
                v24 /= 2;
                v1 /= 2;
            }
            int v25 = this.m - v;
            short[] arr_v6 = this.e(this.n, this.o, v25);
            this.n = arr_v6;
            System.arraycopy(this.l, v * v2, arr_v6, this.o * v2, v25 * v2);
            this.m = v;
            this.o += v25;
            for(int v26 = 0; true; ++v26) {
                v27 = this.o;
                v28 = v27 - 1;
                if(v26 >= v28) {
                    break;
                }
                while(true) {
                    v29 = this.p + 1;
                    v30 = this.q;
                    if(v29 * v24 <= v30 * v1) {
                        break;
                    }
                    this.l = this.e(this.l, this.m, 1);
                    for(int v31 = 0; v31 < v2; ++v31) {
                        int v32 = v26 * v2 + v31;
                        int v33 = (this.p + 1) * v24;
                        int v34 = v33 - this.q * v1;
                        int v35 = v33 - this.p * v24;
                        this.l[this.m * v2 + v31] = (short)(((v35 - v34) * this.n[v32 + v2] + this.n[v32] * v34) / v35);
                    }
                    ++this.q;
                    ++this.m;
                }
                this.p = v29;
                if(v29 == v1) {
                    this.p = 0;
                    M7.J(v30 == v24);
                    this.q = 0;
                }
            }
            if(v28 != 0) {
                System.arraycopy(this.n, v28 * v2, this.n, 0, (v27 - v28) * v2);
                this.o -= v28;
            }
        }
    }
}

