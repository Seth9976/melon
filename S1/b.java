package s1;

import androidx.collection.W;
import r1.i;

public abstract class b {
    public static final float[] a;
    public static volatile W b;
    public static final Object[] c;

    static {
        b.a = new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f};
        b.b = new W(0);
        Object[] arr_object = new Object[0];
        b.c = arr_object;
        synchronized(arr_object) {
            b.b.d(0x73, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{9.2f, 11.5f, 13.8f, 16.4f, 19.799999f, 21.799999f, 25.200001f, 30.0f, 100.0f}));
            b.b.d(130, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{10.4f, 13.0f, 15.6f, 18.799999f, 21.6f, 23.6f, 26.4f, 30.0f, 100.0f}));
            b.b.d(150, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{12.0f, 15.0f, 18.0f, 22.0f, 24.0f, 26.0f, 28.0f, 30.0f, 100.0f}));
            b.b.d(180, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{14.4f, 18.0f, 21.6f, 24.4f, 27.6f, 30.799999f, 32.799999f, 34.799999f, 100.0f}));
            b.b.d(200, new c(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{16.0f, 20.0f, 24.0f, 26.0f, 30.0f, 34.0f, 36.0f, 38.0f, 100.0f}));
        }
        if(((float)b.b.a[0]) / 100.0f - 0.01f > 1.03f) {
            return;
        }
        i.b("You should only apply non-linear scaling to font scales > 1");
    }

    public static a a(float f) {
        float f1;
        a a2;
        float[] arr_f = b.a;
        if(f >= 1.03f) {
            a a0 = (a)b.b.c(((int)(f * 100.0f)));
            if(a0 != null) {
                return a0;
            }
            int v = E.a.a(b.b.c, ((int)(f * 100.0f)), b.b.a);
            if(v >= 0) {
                return (a)b.b.e(v);
            }
            int v1 = -(v + 1) - 1;
            if(-(v + 1) >= b.b.c) {
                a a1 = new c(new float[]{1.0f}, new float[]{f});
                b.b(f, ((c)a1));
                return a1;
            }
            if(v1 < 0) {
                a2 = new c(arr_f, arr_f);
                f1 = 1.0f;
            }
            else {
                f1 = ((float)b.b.a[v1]) / 100.0f;
                a2 = (a)b.b.e(v1);
            }
            float f2 = ((float)b.b.a[-(v + 1)]) / 100.0f;
            float f3 = Math.max(0.0f, Math.min(1.0f, (Float.compare(f1, f2) == 0 ? 0.0f : (f - f1) / (f2 - f1))));
            a a3 = (a)b.b.e(-(v + 1));
            float[] arr_f1 = new float[9];
            for(int v2 = 0; v2 < 9; ++v2) {
                float f4 = arr_f[v2];
                float f5 = a2.b(f4);
                arr_f1[v2] = (a3.b(f4) - f5) * (f3 * 1.0f + 0.0f) + f5;
            }
            a a4 = new c(arr_f, arr_f1);
            b.b(f, ((c)a4));
            return a4;
        }
        return null;
    }

    public static void b(float f, c c0) {
        synchronized(b.c) {
            W w0 = b.b.b();
            w0.d(((int)(f * 100.0f)), c0);
            b.b = w0;
        }
    }
}

