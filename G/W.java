package G;

import A7.d;
import e1.G;
import y0.M;

public final class w implements A {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    public w(float f, float f1, float f2, float f3) {
        int v1;
        this.a = f;
        this.b = f1;
        this.c = f2;
        this.d = f3;
        if(Float.isNaN(f) || Float.isNaN(f1) || Float.isNaN(f2) || Float.isNaN(f3)) {
            W.a(("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: " + f + ", " + f1 + ", " + f2 + ", " + f3 + '.'));
        }
        float[] arr_f = new float[5];
        float f4 = (f1 - 0.0f) * 3.0f;
        float f5 = (f3 - f1) * 3.0f;
        float f6 = (1.0f - f3) * 3.0f;
        double f7 = ((double)f4) - ((double)f5) * 2.0 + ((double)f6);
        if(f7 != 0.0) {
            double f8 = Math.sqrt(((double)f5) * ((double)f5) - ((double)f6) * ((double)f4));
            double f9 = ((double)f5) - ((double)f4);
            int v2 = M.D(((float)(-(f9 - f8) / f7)), arr_f, 0);
            int v3 = M.D(((float)((-f8 - f9) / f7)), arr_f, v2) + v2;
            if(v3 > 1) {
                float f10 = arr_f[0];
                float f11 = arr_f[1];
                if(f10 > f11) {
                    arr_f[0] = f11;
                    arr_f[1] = f10;
                    v1 = v3;
                }
                else if(f10 == f11) {
                    v1 = v3 - 1;
                }
                else {
                    v1 = v3;
                }
            }
            else {
                v1 = v3;
            }
        }
        else if(((double)f5) == ((double)f6)) {
            v1 = 0;
        }
        else {
            v1 = M.D(((float)((((double)f5) * 2.0 - ((double)f6)) / (((double)f5) * 2.0 - ((double)f6) * 2.0))), arr_f, 0);
        }
        float f12 = (f5 - f4) * 2.0f;
        int v4 = M.D(-f12 / ((f6 - f5) * 2.0f - f12), arr_f, v1);
        float f13 = 0.0f;
        float f14 = 1.0f;
        for(int v = 0; v < v4 + v1; ++v) {
            float f15 = arr_f[v];
            float f16 = ((((f1 - f3) * 3.0f + 1.0f - 0.0f) * f15 + (f3 - f1 * 2.0f + 0.0f) * 3.0f) * f15 + f4) * f15 + 0.0f;
            f13 = Math.min(f13, f16);
            f14 = Math.max(f14, f16);
        }
        long v5 = ((long)Float.floatToRawIntBits(f13)) << 0x20 | ((long)Float.floatToRawIntBits(f14)) & 0xFFFFFFFFL;
        this.e = Float.intBitsToFloat(((int)(v5 >> 0x20)));
        this.f = Float.intBitsToFloat(((int)(v5 & 0xFFFFFFFFL)));
    }

    @Override  // G.A
    public final float e(float f) {
        float f12;
        if(f > 0.0f && f < 1.0f) {
            float f1 = Math.max(f, 1.192093E-07f);
            float f2 = this.a;
            float f3 = f2 - f1;
            float f4 = this.c;
            float f5 = f4 - f1;
            float f6 = 0.0f;
            double f7 = ((double)(f3 - (0.0f - f1))) * 3.0;
            double f8 = (((double)(0.0f - f1)) - ((double)f3) * 2.0 + ((double)f5)) * 3.0;
            double f9 = ((double)(f3 - f5)) * 3.0 + ((double)(-(0.0f - f1))) + ((double)(1.0f - f1));
            float f10 = NaNf;
            if(Double.compare(Math.abs(f9 - 0.0), 1.000000E-07) >= 0) {
                double f17 = f8 / f9;
                double f18 = f7 / f9;
                double f19 = (f18 * 3.0 - f17 * f17) / 9.0;
                double f20 = (((double)(0.0f - f1)) / f9 * 27.0 + (2.0 * f17 * f17 * f17 - 9.0 * f17 * f18)) / 54.0;
                double f21 = f19 * (f19 * f19);
                double f22 = f20 * f20 + f21;
                int v = Double.compare(f22, 0.0);
                if(v < 0) {
                    double f23 = Math.sqrt(-f21);
                    double f24 = -f20 / f23;
                    if(f24 < -1.0) {
                        f24 = -1.0;
                    }
                    if(f24 > 1.0) {
                        f24 = 1.0;
                    }
                    double f25 = Math.acos(f24);
                    float f26 = G.p(((float)f23));
                    float f27 = (float)(Math.cos(f25 / 3.0) * ((double)(f26 * 2.0f)) - f17 / 3.0);
                    float f28 = f27 < 0.0f ? 0.0f : f27;
                    if(f28 > 1.0f) {
                        f28 = 1.0f;
                    }
                    if(Math.abs(f28 - f27) > 0.000001f) {
                        f28 = NaNf;
                    }
                    if(Float.isNaN(f28)) {
                        float f29 = (float)(Math.cos((f25 + 6.283185) / 3.0) * ((double)(f26 * 2.0f)) - f17 / 3.0);
                        f28 = f29 < 0.0f ? 0.0f : f29;
                        if(f28 > 1.0f) {
                            f28 = 1.0f;
                        }
                        if(Math.abs(f28 - f29) > 0.000001f) {
                            f28 = NaNf;
                        }
                        if(Float.isNaN(f28)) {
                            float f30 = (float)(Math.cos((f25 + 12.566371) / 3.0) * ((double)(f26 * 2.0f)) - f17 / 3.0);
                            if(f30 >= 0.0f) {
                                f6 = f30;
                            }
                            f12 = f6 > 1.0f ? 1.0f : f6;
                            if(Math.abs(f12 - f30) <= 0.000001f) {
                                f10 = f12;
                            }
                        }
                        else {
                            f10 = f28;
                        }
                    }
                    else {
                        f10 = f28;
                    }
                }
                else if(v == 0) {
                    float f31 = G.p(((float)f20));
                    float f32 = -f31 * 2.0f - ((float)(f17 / 3.0));
                    float f33 = f32 < 0.0f ? 0.0f : f32;
                    if(f33 > 1.0f) {
                        f33 = 1.0f;
                    }
                    if(Math.abs(f33 - f32) > 0.000001f) {
                        f33 = NaNf;
                    }
                    if(Float.isNaN(f33)) {
                        float f34 = --f31 - ((float)(f17 / 3.0));
                        if(f34 >= 0.0f) {
                            f6 = f34;
                        }
                        f12 = f6 > 1.0f ? 1.0f : f6;
                        if(Math.abs(f12 - f34) <= 0.000001f) {
                            f10 = f12;
                        }
                    }
                    else {
                        f10 = f33;
                    }
                }
                else {
                    double f35 = Math.sqrt(f22);
                    float f36 = (float)(((double)(G.p(((float)(f35 - f20))) - G.p(((float)(f20 + f35))))) - f17 / 3.0);
                    if(f36 >= 0.0f) {
                        f6 = f36;
                    }
                    f12 = f6 > 1.0f ? 1.0f : f6;
                    if(Math.abs(f12 - f36) <= 0.000001f) {
                        f10 = f12;
                    }
                }
            }
            else if(Math.abs(f8 - 0.0) >= 1.000000E-07) {
                double f13 = Math.sqrt(f7 * f7 - 4.0 * f8 * ((double)(0.0f - f1)));
                float f14 = (float)((f13 - f7) / (f8 * 2.0));
                float f15 = f14 < 0.0f ? 0.0f : f14;
                if(f15 > 1.0f) {
                    f15 = 1.0f;
                }
                if(Math.abs(f15 - f14) > 0.000001f) {
                    f15 = NaNf;
                }
                if(Float.isNaN(f15)) {
                    float f16 = (float)((-f7 - f13) / (f8 * 2.0));
                    if(f16 >= 0.0f) {
                        f6 = f16;
                    }
                    f12 = f6 > 1.0f ? 1.0f : f6;
                    if(Math.abs(f12 - f16) <= 0.000001f) {
                        f10 = f12;
                    }
                }
                else {
                    f10 = f15;
                }
            }
            else if(Math.abs(f7 - 0.0) >= 1.000000E-07) {
                float f11 = (float)(-((double)(0.0f - f1)) / f7);
                if(f11 >= 0.0f) {
                    f6 = f11;
                }
                f12 = f6 > 1.0f ? 1.0f : f6;
                if(Math.abs(f12 - f11) <= 0.000001f) {
                    f10 = f12;
                }
            }
            float f37 = this.d;
            float f38 = this.b;
            if(Float.isNaN(f10)) {
                throw new IllegalArgumentException("The cubic curve with parameters (" + f2 + ", " + f38 + ", " + f4 + ", " + f37 + ") has no solution at " + f);
            }
            float f39 = (((f38 - f37 + 0.333333f) * f10 + (f37 - 2.0f * f38)) * f10 + f38) * 3.0f * f10;
            float f40 = this.e;
            if(f39 < f40) {
                f39 = f40;
            }
            return f39 > this.f ? this.f : f39;
        }
        return f;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof w && this.a == ((w)object0).a && this.b == ((w)object0).b && this.c == ((w)object0).c && this.d == ((w)object0).d;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.d) + d.a(this.c, d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F), 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("CubicBezierEasing(a=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", b=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", c=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", d=");
        return d.m(stringBuilder0, this.d, ')');
    }
}

