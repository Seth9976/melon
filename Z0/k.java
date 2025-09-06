package z0;

import y0.M;

public final class k extends c {
    public final int d;

    public k(int v, int v1, long v2, String s) {
        this.d = v1;
        super(s, v2, v);
    }

    @Override  // z0.c
    public final float a(int v) {
        if(this.d != 0) {
            return 2.0f;
        }
        return v == 0 ? 100.0f : 128.0f;
    }

    @Override  // z0.c
    public final float b(int v) {
        if(this.d != 0) {
            return -2.0f;
        }
        return v == 0 ? 0.0f : -128.0f;
    }

    @Override  // z0.c
    public final long d(float f, float f1, float f2) {
        if(this.d != 0) {
            if(f < -2.0f) {
                f = -2.0f;
            }
            float f3 = 2.0f;
            if(f > 2.0f) {
                f = 2.0f;
            }
            if(f1 < -2.0f) {
                f1 = -2.0f;
            }
            if(f1 <= 2.0f) {
                f3 = f1;
            }
            return ((long)Float.floatToRawIntBits(f)) << 0x20 | ((long)Float.floatToRawIntBits(f3)) & 0xFFFFFFFFL;
        }
        if(f < 0.0f) {
            f = 0.0f;
        }
        if(f > 100.0f) {
            f = 100.0f;
        }
        if(f1 < -128.0f) {
            f1 = -128.0f;
        }
        if(f1 > 128.0f) {
            f1 = 128.0f;
        }
        float f4 = (f + 16.0f) / 116.0f;
        float f5 = f1 * 0.002f + f4;
        float f6 = Float.compare(f5, 0.206897f) <= 0 ? (f5 - 0.137931f) * 0.128419f : f5 * f5 * f5;
        return f4 > 0.206897f ? ((long)Float.floatToRawIntBits(f4 * f4 * f4 * j.e[1])) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f6 * j.e[0])) << 0x20 : ((long)Float.floatToRawIntBits((f4 - 0.137931f) * 0.128419f * j.e[1])) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f6 * j.e[0])) << 0x20;
    }

    @Override  // z0.c
    public final float e(float f, float f1, float f2) {
        if(this.d != 0) {
            if(f2 < -2.0f) {
                f2 = -2.0f;
            }
            return f2 > 2.0f ? 2.0f : f2;
        }
        if(f < 0.0f) {
            f = 0.0f;
        }
        if(f > 100.0f) {
            f = 100.0f;
        }
        if(f2 < -128.0f) {
            f2 = -128.0f;
        }
        if(f2 > 128.0f) {
            f2 = 128.0f;
        }
        float f3 = (f + 16.0f) / 116.0f - f2 * 0.005f;
        return f3 > 0.206897f ? f3 * f3 * f3 * j.e[2] : 0.128419f * (f3 - 0.137931f) * j.e[2];
    }

    @Override  // z0.c
    public final long f(float f, float f1, float f2, float f3, c c0) {
        if(this.d != 0) {
            if(f < -2.0f) {
                f = -2.0f;
            }
            float f4 = 2.0f;
            if(f > 2.0f) {
                f = 2.0f;
            }
            if(f1 < -2.0f) {
                f1 = -2.0f;
            }
            if(f1 > 2.0f) {
                f1 = 2.0f;
            }
            if(f2 < -2.0f) {
                f2 = -2.0f;
            }
            if(f2 <= 2.0f) {
                f4 = f2;
            }
            return M.b(f, f1, f4, f3, c0);
        }
        float f5 = f / j.e[0];
        float f6 = f1 / j.e[1];
        float f7 = f2 / j.e[2];
        float f8 = f6 > 0.008856f ? ((float)Math.cbrt(f6)) : f6 * 7.787037f + 0.137931f;
        float f9 = 116.0f * f8 - 16.0f;
        float f10 = ((Float.compare(f5, 0.008856f) <= 0 ? f5 * 7.787037f + 0.137931f : ((float)Math.cbrt(f5))) - f8) * 500.0f;
        float f11 = (f8 - (f7 > 0.008856f ? ((float)Math.cbrt(f7)) : f7 * 7.787037f + 0.137931f)) * 200.0f;
        if(f9 < 0.0f) {
            f9 = 0.0f;
        }
        if(f9 > 100.0f) {
            f9 = 100.0f;
        }
        if(f10 < -128.0f) {
            f10 = -128.0f;
        }
        float f12 = 128.0f;
        if(f10 > 128.0f) {
            f10 = 128.0f;
        }
        if(f11 < -128.0f) {
            f11 = -128.0f;
        }
        if(f11 <= 128.0f) {
            f12 = f11;
        }
        return M.b(f9, f10, f12, f3, c0);
    }
}

