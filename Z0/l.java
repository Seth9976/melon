package z0;

import e1.G;
import y0.M;

public final class l extends c {
    public static final float[] d;
    public static final float[] e;
    public static final float[] f;
    public static final float[] g;

    static {
        float[] arr_f = j.c(a.b.a, new float[]{0.964212f, 1.0f, 0.825188f}, new float[]{0.950429f, 1.0f, 1.0889f});
        float[] arr_f1 = j.g(new float[]{0.818933f, 0.032985f, 0.0482f, 0.361867f, 0.929312f, 0.264366f, -0.12886f, 0.036146f, 0.633852f}, arr_f);
        l.d = arr_f1;
        float[] arr_f2 = {0.210454f, 1.977998f, 0.025904f, 0.793618f, -2.428592f, 0.782772f, -0.004072f, 0.450594f, -0.808676f};
        l.e = arr_f2;
        l.f = j.f(arr_f1);
        l.g = j.f(arr_f2);
    }

    @Override  // z0.c
    public final float a(int v) {
        return v == 0 ? 1.0f : 0.5f;
    }

    @Override  // z0.c
    public final float b(int v) {
        return v == 0 ? 0.0f : -0.5f;
    }

    @Override  // z0.c
    public final long d(float f, float f1, float f2) {
        if(f < 0.0f) {
            f = 0.0f;
        }
        if(f > 1.0f) {
            f = 1.0f;
        }
        if(f1 < -0.5f) {
            f1 = -0.5f;
        }
        float f3 = 0.5f;
        if(f1 > 0.5f) {
            f1 = 0.5f;
        }
        if(f2 < -0.5f) {
            f2 = -0.5f;
        }
        if(f2 <= 0.5f) {
            f3 = f2;
        }
        float f4 = l.g[6] * f3 + (l.g[3] * f1 + l.g[0] * f);
        float f5 = l.g[7] * f3 + (l.g[4] * f1 + l.g[1] * f);
        float f6 = l.g[8] * f3 + (l.g[5] * f1 + l.g[2] * f);
        float f7 = f4 * f4 * f4;
        float f8 = f5 * f5 * f5;
        float f9 = f6 * f6 * f6;
        return ((long)Float.floatToRawIntBits(l.f[7] * f9 + (l.f[4] * f8 + l.f[1] * f7))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(l.f[6] * f9 + (l.f[3] * f8 + l.f[0] * f7))) << 0x20;
    }

    @Override  // z0.c
    public final float e(float f, float f1, float f2) {
        if(f < 0.0f) {
            f = 0.0f;
        }
        if(f > 1.0f) {
            f = 1.0f;
        }
        if(f1 < -0.5f) {
            f1 = -0.5f;
        }
        float f3 = 0.5f;
        if(f1 > 0.5f) {
            f1 = 0.5f;
        }
        if(f2 < -0.5f) {
            f2 = -0.5f;
        }
        if(f2 <= 0.5f) {
            f3 = f2;
        }
        float f4 = l.g[6] * f3 + (l.g[3] * f1 + l.g[0] * f);
        float f5 = l.g[7] * f3 + (l.g[4] * f1 + l.g[1] * f);
        float f6 = l.g[8] * f3 + (l.g[5] * f1 + l.g[2] * f);
        return l.f[8] * (f6 * f6 * f6) + (l.f[5] * (f5 * f5 * f5) + l.f[2] * (f4 * f4 * f4));
    }

    @Override  // z0.c
    public final long f(float f, float f1, float f2, float f3, c c0) {
        float f4 = l.d[6] * f2 + (l.d[3] * f1 + l.d[0] * f);
        float f5 = l.d[7] * f2 + (l.d[4] * f1 + l.d[1] * f);
        float f6 = l.d[8] * f2 + (l.d[5] * f1 + l.d[2] * f);
        float f7 = G.p(f4);
        float f8 = G.p(f5);
        float f9 = G.p(f6);
        return M.b(l.e[6] * f9 + (l.e[3] * f8 + l.e[0] * f7), l.e[7] * f9 + (l.e[4] * f8 + l.e[1] * f7), l.e[8] * f9 + (l.e[5] * f8 + l.e[2] * f7), f3, c0);
    }
}

