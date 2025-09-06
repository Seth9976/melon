package z0;

public abstract class j {
    public static final s a;
    public static final s b;
    public static final s c;
    public static final s d;
    public static final float[] e;

    static {
        j.a = new s(0.31006f, 0.31616f);
        j.b = new s(0.34567f, 0.3585f);
        j.c = new s(0.32168f, 0.33767f);
        j.d = new s(0.31271f, 0.32902f);
        j.e = new float[]{0.964212f, 1.0f, 0.825188f};
    }

    public static c a(c c0) {
        if(b.a(c0.b, 0x300000000L)) {
            s s0 = ((q)c0).d;
            s s1 = j.b;
            if(!j.d(s0, s1)) {
                float[] arr_f = s1.a();
                float[] arr_f1 = s0.a();
                float[] arr_f2 = j.g(j.c(a.b.a, arr_f1, arr_f), ((q)c0).i);
                return new q(((q)c0).a, ((q)c0).h, s1, arr_f2, ((q)c0).k, ((q)c0).n, ((q)c0).e, ((q)c0).f, ((q)c0).g, -1);
            }
        }
        return c0;
    }

    public static float b(float[] arr_f) [...] // 潜在的解密器

    public static final float[] c(float[] arr_f, float[] arr_f1, float[] arr_f2) {
        j.h(arr_f, arr_f1);
        j.h(arr_f, arr_f2);
        new float[]{arr_f2[0] / arr_f1[0], arr_f2[1] / arr_f1[1], arr_f2[2] / arr_f1[2]};
        float f = arr_f2[0] / arr_f1[0];
        float f1 = arr_f2[1] / arr_f1[1];
        float f2 = arr_f2[2] / arr_f1[2];
        return j.g(j.f(arr_f), new float[]{arr_f[0] * f, arr_f[1] * f1, arr_f[2] * f2, arr_f[3] * f, arr_f[4] * f1, arr_f[5] * f2, f * arr_f[6], f1 * arr_f[7], f2 * arr_f[8]});
    }

    public static final boolean d(s s0, s s1) {
        return s0 == s1 ? true : Math.abs(s0.a - s1.a) < 0.001f && Math.abs(s0.b - s1.b) < 0.001f;
    }

    public static final g e(c c0, c c1) {
        if(c0 == c1) {
            return new e(c0, c0, 1);  // 初始化器: Lz0/g;-><init>(Lz0/c;Lz0/c;I)V
        }
        return b.a(c0.b, 0x300000000L) && b.a(c1.b, 0x300000000L) ? new f(((q)c0), ((q)c1)) : new g(c0, c1, 0);
    }

    public static final float[] f(float[] arr_f) {
        float f = arr_f[0];
        float f1 = arr_f[3];
        float f2 = arr_f[6];
        float f3 = arr_f[1];
        float f4 = arr_f[4];
        float f5 = arr_f[7];
        float f6 = arr_f[2];
        float f7 = arr_f[5];
        float f8 = arr_f[8];
        float f9 = f4 * f8 - f5 * f7;
        float f10 = f5 * f6 - f3 * f8;
        float f11 = f3 * f7 - f4 * f6;
        float f12 = f2 * f11 + (f1 * f10 + f * f9);
        float[] arr_f1 = new float[arr_f.length];
        arr_f1[0] = f9 / f12;
        arr_f1[1] = f10 / f12;
        arr_f1[2] = f11 / f12;
        arr_f1[3] = (f2 * f7 - f1 * f8) / f12;
        arr_f1[4] = (f8 * f - f2 * f6) / f12;
        arr_f1[5] = (f6 * f1 - f7 * f) / f12;
        arr_f1[6] = (f1 * f5 - f2 * f4) / f12;
        arr_f1[7] = (f2 * f3 - f5 * f) / f12;
        arr_f1[8] = (f * f4 - f1 * f3) / f12;
        return arr_f1;
    }

    public static final float[] g(float[] arr_f, float[] arr_f1) {
        float[] arr_f2 = new float[9];
        if(arr_f.length < 9 || arr_f1.length < 9) {
            return arr_f2;
        }
        float f = arr_f[0] * arr_f1[0];
        float f1 = arr_f[3];
        float f2 = arr_f1[1];
        float f3 = arr_f[6];
        float f4 = arr_f1[2];
        arr_f2[0] = f3 * f4 + (f1 * f2 + f);
        float f5 = arr_f[1];
        float f6 = arr_f1[0];
        float f7 = arr_f[4];
        float f8 = arr_f[7];
        arr_f2[1] = f8 * f4 + (f2 * f7 + f5 * f6);
        float f9 = arr_f[2] * f6;
        float f10 = arr_f[5];
        float f11 = arr_f1[1] * f10 + f9;
        float f12 = arr_f[8];
        arr_f2[2] = f4 * f12 + f11;
        float f13 = arr_f[0];
        float f14 = arr_f1[3] * f13;
        float f15 = arr_f1[4];
        float f16 = arr_f1[5];
        arr_f2[3] = f3 * f16 + (f1 * f15 + f14);
        float f17 = arr_f[1];
        float f18 = arr_f1[3];
        arr_f2[4] = f8 * f16 + (f7 * f15 + f17 * f18);
        float f19 = arr_f[2];
        arr_f2[5] = f16 * f12 + (f10 * arr_f1[4] + f18 * f19);
        float f20 = f13 * arr_f1[6];
        float f21 = arr_f[3];
        float f22 = arr_f1[7];
        float f23 = arr_f1[8];
        arr_f2[6] = f3 * f23 + (f21 * f22 + f20);
        float f24 = arr_f1[6];
        arr_f2[7] = f8 * f23 + (arr_f[4] * f22 + f17 * f24);
        arr_f2[8] = f12 * f23 + (arr_f[5] * arr_f1[7] + f19 * f24);
        return arr_f2;
    }

    public static final float[] h(float[] arr_f, float[] arr_f1) {
        if(arr_f.length < 9 || arr_f1.length < 3) {
            return arr_f1;
        }
        float f = arr_f1[0];
        float f1 = arr_f1[1];
        float f2 = arr_f1[2];
        arr_f1[0] = arr_f[6] * f2 + (arr_f[3] * f1 + arr_f[0] * f);
        arr_f1[1] = arr_f[7] * f2 + (arr_f[4] * f1 + arr_f[1] * f);
        arr_f1[2] = arr_f[8] * f2 + (arr_f[5] * f1 + arr_f[2] * f);
        return arr_f1;
    }
}

