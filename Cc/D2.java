package Cc;

import we.k;

public final class d2 implements k {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;

    public d2(float f, float f1, float f2, float f3, float f4, float f5, float f6) {
        this.a = f;
        this.b = f1;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = f5;
        this.g = f6;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        float f = (float)(((Float)object0));
        float f1 = this.a;
        if(Float.compare(f, 0.0f) != 0) {
            float f2 = this.b;
            int v = Float.compare(f, f2);
            float f3 = this.c;
            if(v < 0) {
                return (float)(f1 + (f3 - f1) * f / f2);
            }
            if(v == 0) {
                return f3;
            }
            float f4 = this.d;
            int v1 = Float.compare(f, f4);
            float f5 = this.e;
            if(v1 < 0) {
                return (float)((f - f2) * (f5 - f3) / (f4 - f2) + f3);
            }
            if(v1 == 0) {
                return f5;
            }
            float f6 = this.f;
            int v2 = Float.compare(f, f6);
            float f7 = this.g;
            if(v2 < 0) {
                return (float)((f - f4) * (f7 - f5) / (f6 - f4) + f5);
            }
            if(v2 == 0) {
                return f7;
            }
            f1 = (f - f6) * (f1 - f7) / (1.0f - f6) + f7;
        }
        return f1;
    }
}

