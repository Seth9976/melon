package com.google.android.material.bottomappbar;

import z6.f;
import z6.x;

public final class i extends f implements Cloneable {
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;

    @Override  // z6.f
    public final void l(float f, float f1, float f2, x x0) {
        float f10;
        float f9;
        float f3 = this.d;
        if(f3 == 0.0f) {
            x0.d(f, 0.0f);
            return;
        }
        float f4 = (this.c * 2.0f + f3) / 2.0f;
        float f5 = f2 * this.b;
        float f6 = f1 + this.f;
        float f7 = (1.0f - f2) * f4 + this.e * f2;
        if(f7 / f4 >= 1.0f) {
            x0.d(f, 0.0f);
            return;
        }
        float f8 = this.g * f2;
        boolean z = this.g == -1.0f || Math.abs(this.g * 2.0f - f3) < 0.1f;
        if(z) {
            f10 = f7;
            f9 = 0.0f;
        }
        else {
            f9 = 1.75f;
            f10 = 0.0f;
        }
        float f11 = f10 + f5;
        float f12 = (float)Math.sqrt((f4 + f5) * (f4 + f5) - f11 * f11);
        float f13 = f6 - f12;
        float f14 = (float)Math.toDegrees(Math.atan(f12 / f11));
        float f15 = 90.0f - f14 + f9;
        x0.d(f13, 0.0f);
        x0.a(f13 - f5, 0.0f, f13 + f5, f5 * 2.0f, 270.0f, f14);
        if(z) {
            x0.a(f6 - f4, -f4 - f10, f6 + f4, f4 - f10, 180.0f - f15, f15 * 2.0f - 180.0f);
        }
        else {
            x0.a(f6 - f4, -(f8 + this.c), this.c + f8 * 2.0f + (f6 - f4), this.c + f8, 180.0f - f15, (f15 * 2.0f - 180.0f) / 2.0f);
            float f16 = f6 + f4;
            x0.d(f16 - (this.c / 2.0f + f8), this.c + f8);
            x0.a(f16 - (f8 * 2.0f + this.c), -(f8 + this.c), f16, this.c + f8, 90.0f, f15 - 90.0f);
        }
        x0.a(f6 + f12 - f5, 0.0f, f6 + f12 + f5, f5 * 2.0f, 270.0f - f14, f14);
        x0.d(f, 0.0f);
    }

    public final void u(float f) {
        if(f < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.e = f;
    }
}

