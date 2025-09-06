package k6;

import E9.h;

public final class a {
    public final int a;
    public final float b;
    public int c;
    public int d;
    public final float e;
    public final float f;
    public final int g;
    public final float h;

    public a(int v, float f, float f1, float f2, int v1, float f3, int v2, float f4, int v3, float f5) {
        float f13;
        this.a = v;
        float f6 = h.q(f, f1, f2);
        this.b = f6;
        this.c = v1;
        this.e = f3;
        this.d = v2;
        this.f = f4;
        this.g = v3;
        float f7 = f5 - (f6 * ((float)v1) + (f3 * ((float)v2) + f4 * ((float)v3)));
        if(v1 > 0 && f7 > 0.0f) {
            this.b = Math.min(f7 / ((float)v1), f2 - f6) + f6;
        }
        else if(v1 > 0 && f7 < 0.0f) {
            this.b = Math.max(f7 / ((float)v1), f1 - f6) + f6;
        }
        float f8 = this.c <= 0 ? 0.0f : this.b;
        this.b = f8;
        int v4 = this.d;
        float f9 = (f5 - (((float)this.c) + ((float)v4) / 2.0f) * (this.c <= 0 ? 0.0f : f8)) / (((float)v4) / 2.0f + ((float)v3));
        this.f = f9;
        float f10 = (f8 + f9) / 2.0f;
        this.e = f10;
        if(v4 > 0 && f9 != f4) {
            float f11 = (f4 - f9) * ((float)v3);
            float f12 = Math.min(Math.abs(f11), f10 * 0.1f * ((float)v4));
            if(f11 > 0.0f) {
                this.e -= f12 / ((float)this.d);
                this.f = f12 / ((float)v3) + this.f;
            }
            else {
                this.e = f12 / ((float)this.d) + this.e;
                this.f -= f12 / ((float)v3);
            }
        }
        if(v3 <= 0 || this.c <= 0 || this.d <= 0) {
            f13 = v3 <= 0 || this.c <= 0 || this.f > this.b ? ((float)v) * Math.abs(f4 - this.f) : 3.402823E+38f;
        }
        else if(this.f <= this.e || this.e <= this.b) {
            f13 = 3.402823E+38f;
        }
        else {
            f13 = ((float)v) * Math.abs(f4 - this.f);
        }
        this.h = f13;
    }

    public static a a(float f, float f1, float f2, float f3, int[] arr_v, float f4, int[] arr_v1, float f5, int[] arr_v2) {
        a a0 = null;
        for(int v1 = 0; v1 < arr_v2.length; ++v1) {
            int v2 = arr_v2[v1];
            for(int v3 = 0; v3 < arr_v1.length; ++v3) {
                int v4 = arr_v1[v3];
                int v5 = 0;
                for(int v = 1; v5 < arr_v.length; ++v) {
                    a a1 = new a(v, f1, f2, f3, arr_v[v5], f4, v4, f5, v2, f);
                    float f6 = a1.h;
                    if(a0 == null || f6 < a0.h) {
                        if(f6 == 0.0f) {
                            return a1;
                        }
                        a0 = a1;
                    }
                    ++v5;
                }
            }
        }
        return a0;
    }

    @Override
    public final String toString() {
        return "Arrangement [priority=" + this.a + ", smallCount=" + this.c + ", smallSize=" + this.b + ", mediumCount=" + this.d + ", mediumSize=" + this.e + ", largeCount=" + this.g + ", largeSize=" + this.f + ", cost=" + this.h + "]";
    }
}

