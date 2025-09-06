package c3;

import e3.b;
import java.util.Arrays;

public final class f {
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
    public double w;

    public f(int v, int v1, float f, float f1, int v2) {
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
        this.j = new short[v3 * v1];
        this.l = new short[v3 * v1];
        this.n = new short[v3 * v1];
    }

    public final void a(short[] arr_v, int v, int v1) {
        short[] arr_v1 = this.c(this.l, this.m, v1);
        this.l = arr_v1;
        System.arraycopy(arr_v, v * this.b, arr_v1, this.m * this.b, this.b * v1);
        this.m += v1;
    }

    public final void b(short[] arr_v, int v, int v1) {
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

    public final short[] c(short[] arr_v, int v, int v1) {
        int v2 = arr_v.length / this.b;
        return v + v1 > v2 ? Arrays.copyOf(arr_v, (v2 * 3 / 2 + v1) * this.b) : arr_v;
    }

    public final int d(short[] arr_v, int v, int v1, int v2) {
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

    public static void e(int v, int v1, short[] arr_v, int v2, short[] arr_v1, int v3, short[] arr_v2, int v4) {
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

    public final void f() {
        long v36;
        int v34;
        int v33;
        int v32;
        int v24;
        int v21;
        int v20;
        int v12;
        int v8;
        int v = this.m;
        double f = (double)(this.c / this.d);
        float f1 = this.e * this.d;
        int v1 = this.a;
        int v2 = this.b;
        if(Double.compare(f, 1.00001) > 0 || f < 0.99999) {
            int v3 = this.k;
            int v4 = this.h;
            if(v3 >= v4) {
                int v5 = 0;
                while(true) {
                    int v6 = this.r;
                    if(v6 > 0) {
                        int v7 = Math.min(v4, v6);
                        this.a(this.j, v5, v7);
                        this.r -= v7;
                        v5 += v7;
                        v8 = v4;
                    }
                    else {
                        short[] arr_v = this.j;
                        int v9 = v1 <= 4000 ? 1 : v1 / 4000;
                        int v10 = this.g;
                        int v11 = this.f;
                        if(v2 != 1 || v9 != 1) {
                            this.b(arr_v, v5, v9);
                            short[] arr_v1 = this.i;
                            int v13 = this.d(arr_v1, 0, v11 / v9, v10 / v9);
                            if(v9 == 1) {
                                v12 = v13;
                            }
                            else {
                                int v14 = v13 * v9;
                                int v15 = v14 - v9 * 4;
                                int v16 = v14 + v9 * 4;
                                if(v15 >= v11) {
                                    v11 = v15;
                                }
                                if(v16 <= v10) {
                                    v10 = v16;
                                }
                                if(v2 == 1) {
                                    v12 = this.d(arr_v, v5, v11, v10);
                                }
                                else {
                                    this.b(arr_v, v5, 1);
                                    v12 = this.d(arr_v1, 0, v11, v10);
                                }
                            }
                        }
                        else {
                            v12 = this.d(arr_v, v5, v11, v10);
                        }
                        int v17 = this.u;
                        int v18 = this.v;
                        if(v17 == 0) {
                            v20 = v12;
                        }
                        else {
                            int v19 = this.s;
                            if(v19 != 0 && v18 <= v17 * 3 && v17 * 2 > this.t * 3) {
                                v20 = v19;
                            }
                        }
                        this.t = v17;
                        this.s = v12;
                        if(Double.compare(f, 1.0) > 0) {
                            short[] arr_v2 = this.j;
                            if(f >= 2.0) {
                                v8 = v4;
                                double f2 = ((double)v20) / (f - 1.0) + this.w;
                                v21 = (int)Math.round(f2);
                                this.w = f2 - ((double)v21);
                            }
                            else {
                                v8 = v4;
                                double f3 = (2.0 - f) * ((double)v20) / (f - 1.0) + this.w;
                                int v22 = (int)Math.round(f3);
                                this.r = v22;
                                this.w = f3 - ((double)v22);
                                v21 = v20;
                            }
                            short[] arr_v3 = this.c(this.l, this.m, v21);
                            this.l = arr_v3;
                            f.e(v21, this.b, arr_v3, this.m, arr_v2, v5, arr_v2, v5 + v20);
                            this.m += v21;
                            v5 = v20 + v21 + v5;
                        }
                        else {
                            v8 = v4;
                            short[] arr_v4 = this.j;
                            if(f < 0.5) {
                                double f4 = ((double)v20) * f / (1.0 - f) + this.w;
                                int v23 = (int)Math.round(f4);
                                this.w = f4 - ((double)v23);
                                v24 = v23;
                            }
                            else {
                                double f5 = (f * 2.0 - 1.0) * ((double)v20) / (1.0 - f) + this.w;
                                int v25 = (int)Math.round(f5);
                                this.r = v25;
                                this.w = f5 - ((double)v25);
                                v24 = v20;
                            }
                            int v26 = v20 + v24;
                            short[] arr_v5 = this.c(this.l, this.m, v26);
                            this.l = arr_v5;
                            System.arraycopy(arr_v4, v5 * v2, arr_v5, this.m * v2, v20 * v2);
                            f.e(v24, this.b, this.l, this.m + v20, arr_v4, v5 + v20, arr_v4, v5);
                            this.m += v26;
                            v5 += v24;
                        }
                    }
                    if(v5 + v8 > v3) {
                        break;
                    }
                    v4 = v8;
                }
                int v27 = this.k - v5;
                System.arraycopy(this.j, v5 * v2, this.j, 0, v27 * v2);
                this.k = v27;
            }
        }
        else {
            this.a(this.j, 0, this.k);
            this.k = 0;
        }
        if(f1 != 1.0f && this.m != v) {
            long v28 = (long)(((float)v1) / f1);
            long v29;
            for(v29 = (long)v1; v28 != 0L && v29 != 0L && v28 % 2L == 0L && v29 % 2L == 0L; v29 /= 2L) {
                v28 /= 2L;
            }
            int v30 = this.m - v;
            short[] arr_v6 = this.c(this.n, this.o, v30);
            this.n = arr_v6;
            System.arraycopy(this.l, v * v2, arr_v6, this.o * v2, v30 * v2);
            this.m = v;
            this.o += v30;
            for(int v31 = 0; true; ++v31) {
                v32 = this.o;
                v33 = v32 - 1;
                if(v31 >= v33) {
                    break;
                }
                while(true) {
                    v34 = this.p + 1;
                    long v35 = (long)v34;
                    v36 = (long)this.q;
                    if(v35 * v28 <= v36 * v29) {
                        break;
                    }
                    this.l = this.c(this.l, this.m, 1);
                    for(int v37 = 0; v37 < v2; ++v37) {
                        int v38 = v31 * v2 + v37;
                        long v39 = ((long)(this.p + 1)) * v28;
                        long v40 = v39 - ((long)this.q) * v29;
                        long v41 = v39 - ((long)this.p) * v28;
                        this.l[this.m * v2 + v37] = (short)(((int)(((v41 - v40) * ((long)this.n[v38 + v2]) + ((long)this.n[v38]) * v40) / v41)));
                    }
                    ++this.q;
                    ++this.m;
                }
                this.p = v34;
                if(v35 == v29) {
                    this.p = 0;
                    b.j(v36 == v28);
                    this.q = 0;
                }
            }
            if(v33 != 0) {
                System.arraycopy(this.n, v33 * v2, this.n, 0, (v32 - v33) * v2);
                this.o -= v33;
            }
        }
    }
}

