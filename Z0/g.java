package z0;

public class g {
    public final c a;
    public final c b;
    public final c c;
    public final float[] d;

    public g(c c0, c c1, int v) {
        float[] arr_f2;
        c c2 = b.a(c0.b, 0x300000000L) ? j.a(c0) : c0;
        c c3 = b.a(c1.b, 0x300000000L) ? j.a(c1) : c1;
        if(v == 3) {
            boolean z = b.a(c0.b, 0x300000000L);
            boolean z1 = b.a(c1.b, 0x300000000L);
            if(z && z1 || !z && !z1) {
                arr_f2 = null;
            }
            else {
                if(!z) {
                    c0 = c1;
                }
                s s0 = ((q)c0).d;
                float[] arr_f = j.e;
                float[] arr_f1 = z ? s0.a() : arr_f;
                if(z1) {
                    arr_f = s0.a();
                }
                arr_f2 = new float[]{arr_f1[0] / arr_f[0], arr_f1[1] / arr_f[1], arr_f1[2] / arr_f[2]};
            }
        }
        else {
            arr_f2 = null;
        }
        this(c1, c2, c3, arr_f2);
    }

    public g(c c0, c c1, c c2, float[] arr_f) {
        this.a = c0;
        this.b = c1;
        this.c = c2;
        this.d = arr_f;
    }

    public long a(long v) {
        float f = y0.s.i(v);
        float f1 = y0.s.h(v);
        float f2 = y0.s.f(v);
        float f3 = y0.s.e(v);
        long v1 = this.b.d(f, f1, f2);
        float f4 = Float.intBitsToFloat(((int)(v1 >> 0x20)));
        float f5 = Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL)));
        float f6 = this.b.e(f, f1, f2);
        float[] arr_f = this.d;
        if(arr_f != null) {
            f4 *= arr_f[0];
            f5 *= arr_f[1];
            f6 *= arr_f[2];
        }
        return this.c.f(f4, f5, f6, f3, this.a);
    }
}

