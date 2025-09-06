package androidx.constraintlayout.widget;

import android.util.Log;
import java.util.Arrays;

public final class h {
    public int[] a;
    public int[] b;
    public int c;
    public int[] d;
    public float[] e;
    public int f;
    public int[] g;
    public String[] h;
    public int i;
    public int[] j;
    public boolean[] k;
    public int l;

    public final void a(float f, int v) {
        int[] arr_v = this.d;
        if(this.f >= arr_v.length) {
            this.d = Arrays.copyOf(arr_v, arr_v.length * 2);
            this.e = Arrays.copyOf(this.e, this.e.length * 2);
        }
        int v1 = this.f;
        this.d[v1] = v;
        this.f = v1 + 1;
        this.e[v1] = f;
    }

    public final void b(int v, int v1) {
        int[] arr_v = this.a;
        if(this.c >= arr_v.length) {
            this.a = Arrays.copyOf(arr_v, arr_v.length * 2);
            this.b = Arrays.copyOf(this.b, this.b.length * 2);
        }
        int v2 = this.c;
        this.a[v2] = v;
        this.c = v2 + 1;
        this.b[v2] = v1;
    }

    public final void c(int v, String s) {
        int[] arr_v = this.g;
        if(this.i >= arr_v.length) {
            this.g = Arrays.copyOf(arr_v, arr_v.length * 2);
            this.h = (String[])Arrays.copyOf(this.h, this.h.length * 2);
        }
        int v1 = this.i;
        this.g[v1] = v;
        this.i = v1 + 1;
        this.h[v1] = s;
    }

    public final void d(int v, boolean z) {
        int[] arr_v = this.j;
        if(this.l >= arr_v.length) {
            this.j = Arrays.copyOf(arr_v, arr_v.length * 2);
            this.k = Arrays.copyOf(this.k, this.k.length * 2);
        }
        int v1 = this.l;
        this.j[v1] = v;
        this.l = v1 + 1;
        this.k[v1] = z;
    }

    public final void e(i i0) {
        for(int v1 = 0; v1 < this.c; ++v1) {
            int v2 = this.a[v1];
            int v3 = this.b[v1];
            switch(v2) {
                case 2: {
                    i0.e.J = v3;
                    break;
                }
                case 6: {
                    i0.e.D = v3;
                    break;
                }
                case 7: {
                    i0.e.E = v3;
                    break;
                }
                case 8: {
                    i0.e.K = v3;
                    break;
                }
                case 11: {
                    i0.e.Q = v3;
                    break;
                }
                case 12: {
                    i0.e.R = v3;
                    break;
                }
                case 13: {
                    i0.e.N = v3;
                    break;
                }
                case 14: {
                    i0.e.P = v3;
                    break;
                }
                case 15: {
                    i0.e.S = v3;
                    break;
                }
                case 16: {
                    i0.e.O = v3;
                    break;
                }
                case 17: {
                    i0.e.e = v3;
                    break;
                }
                case 18: {
                    i0.e.f = v3;
                    break;
                }
                case 21: {
                    i0.e.d = v3;
                    break;
                }
                case 22: {
                    i0.c.b = v3;
                    break;
                }
                case 23: {
                    i0.e.c = v3;
                    break;
                }
                case 24: {
                    i0.e.G = v3;
                    break;
                }
                case 27: {
                    i0.e.F = v3;
                    break;
                }
                case 28: {
                    i0.e.H = v3;
                    break;
                }
                case 0x1F: {
                    i0.e.L = v3;
                    break;
                }
                case 34: {
                    i0.e.I = v3;
                    break;
                }
                case 38: {
                    i0.a = v3;
                    break;
                }
                case 41: {
                    i0.e.W = v3;
                    break;
                }
                case 42: {
                    i0.e.X = v3;
                    break;
                }
                case 54: {
                    i0.e.Y = v3;
                    break;
                }
                case 55: {
                    i0.e.Z = v3;
                    break;
                }
                case 56: {
                    i0.e.a0 = v3;
                    break;
                }
                case 57: {
                    i0.e.b0 = v3;
                    break;
                }
                case 58: {
                    i0.e.c0 = v3;
                    break;
                }
                case 59: {
                    i0.e.d0 = v3;
                    break;
                }
                case 61: {
                    i0.e.A = v3;
                    break;
                }
                case 62: {
                    i0.e.B = v3;
                    break;
                }
                case 0x40: {
                    i0.d.b = v3;
                    break;
                }
                case 66: {
                    i0.d.f = v3;
                    break;
                }
                case 72: {
                    i0.e.g0 = v3;
                    break;
                }
                case 73: {
                    i0.e.h0 = v3;
                    break;
                }
                case 76: {
                    i0.d.e = v3;
                    break;
                }
                case 78: {
                    i0.c.c = v3;
                    break;
                }
                case 82: {
                    i0.d.c = v3;
                    break;
                }
                case 83: {
                    i0.f.i = v3;
                    break;
                }
                case 84: {
                    i0.d.j = v3;
                    break;
                }
                case 87: {
                    break;
                }
                case 88: {
                    i0.d.l = v3;
                    break;
                }
                case 89: {
                    i0.d.m = v3;
                    break;
                }
                case 93: {
                    i0.e.M = v3;
                    break;
                }
                case 94: {
                    i0.e.T = v3;
                    break;
                }
                case 97: {
                    i0.e.p0 = v3;
                    break;
                }
                default: {
                    Log.w("ConstraintSet", "Unknown attribute 0x");
                }
            }
        }
        for(int v4 = 0; v4 < this.f; ++v4) {
            int v5 = this.d[v4];
            float f = this.e[v4];
            switch(v5) {
                case 19: {
                    i0.e.g = f;
                    break;
                }
                case 20: {
                    i0.e.x = f;
                    break;
                }
                case 37: {
                    i0.e.y = f;
                    break;
                }
                case 39: {
                    i0.e.V = f;
                    break;
                }
                case 40: {
                    i0.e.U = f;
                    break;
                }
                case 43: {
                    i0.c.d = f;
                    break;
                }
                case 44: {
                    i0.f.n = f;
                    i0.f.m = true;
                    break;
                }
                case 45: {
                    i0.f.c = f;
                    break;
                }
                case 46: {
                    i0.f.d = f;
                    break;
                }
                case 0x2F: {
                    i0.f.e = f;
                    break;
                }
                case 0x30: {
                    i0.f.f = f;
                    break;
                }
                case 49: {
                    i0.f.g = f;
                    break;
                }
                case 50: {
                    i0.f.h = f;
                    break;
                }
                case 51: {
                    i0.f.j = f;
                    break;
                }
                case 52: {
                    i0.f.k = f;
                    break;
                }
                case 53: {
                    i0.f.l = f;
                    break;
                }
                case 60: {
                    i0.f.b = f;
                    break;
                }
                case 0x3F: {
                    i0.e.C = f;
                    break;
                }
                case 67: {
                    i0.d.h = f;
                    break;
                }
                case 68: {
                    i0.c.e = f;
                    break;
                }
                case 69: {
                    i0.e.e0 = f;
                    break;
                }
                case 70: {
                    i0.e.f0 = f;
                    break;
                }
                case 0x4F: {
                    i0.d.g = f;
                    break;
                }
                case 85: {
                    i0.d.i = f;
                    break;
                }
                case 87: {
                    break;
                }
                default: {
                    Log.w("ConstraintSet", "Unknown attribute 0x");
                }
            }
        }
        for(int v6 = 0; v6 < this.i; ++v6) {
            int v7 = this.g[v6];
            String s = this.h[v6];
            switch(v7) {
                case 5: {
                    i0.e.z = s;
                    break;
                }
                case 65: {
                    i0.d.d = s;
                    break;
                }
                case 74: {
                    i0.e.k0 = s;
                    i0.e.j0 = null;
                    break;
                }
                case 77: {
                    i0.e.l0 = s;
                    break;
                }
                case 87: {
                    break;
                }
                case 90: {
                    i0.d.k = s;
                    break;
                }
                default: {
                    Log.w("ConstraintSet", "Unknown attribute 0x");
                }
            }
        }
        for(int v = 0; v < this.l; ++v) {
            int v8 = this.j[v];
            boolean z = this.k[v];
            switch(v8) {
                case 44: {
                    i0.f.m = z;
                    break;
                }
                case 75: {
                    i0.e.o0 = z;
                    break;
                }
                case 80: {
                    i0.e.m0 = z;
                    break;
                }
                case 81: {
                    i0.e.n0 = z;
                    break;
                }
                case 87: {
                    break;
                }
                default: {
                    Log.w("ConstraintSet", "Unknown attribute 0x");
                }
            }
        }
    }
}

