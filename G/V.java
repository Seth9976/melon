package G;

import com.iloen.melon.utils.a;
import java.util.Arrays;

public final class v {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public float h;
    public float i;
    public final float[] j;
    public final float k;
    public final float l;
    public final float m;
    public final float n;
    public final float o;
    public final boolean p;
    public final float q;
    public final float r;

    public v(float f, float f1, float f2, float f3, float f4, float f5, int v) {
        boolean z1;
        boolean z;
        this.a = f;
        this.b = f1;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = f5;
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        switch(v) {
            case 1: {
                z = true;
                break;
            }
            case 4: {
                z = f7 > 0.0f;
                break;
            }
            case 5: {
                z = f7 < 0.0f;
                break;
            }
            default: {
                z = false;
            }
        }
        this.m = z ? -1.0f : 1.0f;
        float f8 = 1.0f / (f1 - f);
        this.k = f8;
        float[] arr_f = new float[101];
        this.j = arr_f;
        if(v == 3 || Math.abs(f6) < 0.001f || Math.abs(f7) < 0.001f) {
            float f17 = (float)Math.hypot(f7, f6);
            this.g = f17;
            this.l = f17 * f8;
            this.q = f6 * f8;
            this.r = f7 * f8;
            this.n = NaNf;
            this.o = NaNf;
            z1 = true;
        }
        else {
            this.n = f6 * (z ? -1.0f : 1.0f);
            this.o = f7 * -(z ? -1.0f : 1.0f);
            this.q = z ? f4 : f2;
            this.r = z ? f3 : f5;
            float f9 = f3 - f5;
            float[] arr_f1 = f.i;
            float f10 = f9;
            float f11 = 0.0f;
            int v1 = 1;
            for(float f12 = 0.0f; true; f12 = f14) {
                double f13 = (double)(((float)Math.toRadians(((double)v1) * 90.0 / 90.0)));
                float f14 = ((float)Math.sin(f13)) * (f4 - f2);
                float f15 = ((float)Math.cos(f13)) * f9;
                f11 += (float)Math.hypot(f14 - f12, f15 - f10);
                arr_f1[v1] = f11;
                if(v1 == 90) {
                    break;
                }
                ++v1;
                f10 = f15;
            }
            this.g = f11;
            for(int v2 = 1; true; ++v2) {
                arr_f1[v2] /= f11;
                if(v2 == 90) {
                    break;
                }
            }
            for(int v3 = 0; v3 < 101; ++v3) {
                int v4 = Arrays.binarySearch(arr_f1, 0, 91, ((float)v3) / 100.0f);
                if(v4 >= 0) {
                    arr_f[v3] = ((float)v4) / 90.0f;
                }
                else if(v4 == -1) {
                    arr_f[v3] = 0.0f;
                }
                else {
                    float f16 = arr_f1[-v4 - 2];
                    arr_f[v3] = ((((float)v3) / 100.0f - f16) / (arr_f1[-v4 - 1] - f16) + ((float)(-v4 - 2))) / 90.0f;
                }
            }
            this.l = this.g * this.k;
            z1 = false;
        }
        this.p = z1;
    }

    public final float a() {
        float f = this.n * this.i;
        return f * this.m * (this.l / ((float)Math.hypot(f, -this.o * this.h)));
    }

    public final float b() {
        float f = -this.o * this.h;
        return f * this.m * (this.l / ((float)Math.hypot(this.n * this.i, f)));
    }

    public final void c(float f) {
        float f1 = (this.m == -1.0f ? this.b - f : f - this.a) * this.k;
        float f2 = 0.0f;
        if(f1 > 0.0f && f1 < 1.0f) {
            int v = (int)(f1 * 100.0f);
            float f3 = this.j[v];
            f2 = a.c(this.j[v + 1], f3, f1 * 100.0f - ((float)v), f3);
        }
        this.h = (float)Math.sin(f2 * 1.570796f);
        this.i = (float)Math.cos(f2 * 1.570796f);
    }
}

