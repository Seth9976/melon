package z0;

import y0.M;

public final class f extends g {
    public final q e;
    public final q f;
    public final float[] g;

    public f(q q0, q q1) {
        super(q1, q0, q1, null);
        float[] arr_f3;
        this.e = q0;
        this.f = q1;
        float[] arr_f = a.b.a;
        s s0 = q0.d;
        float[] arr_f1 = q0.i;
        s s1 = q1.d;
        float[] arr_f2 = q1.j;
        if(!j.d(s0, s1)) {
            float[] arr_f4 = s0.a();
            float[] arr_f5 = s1.a();
            s s2 = j.b;
            if(!j.d(s0, s2)) {
                arr_f1 = j.g(j.c(arr_f, arr_f4, new float[]{0.964212f, 1.0f, 0.825188f}), arr_f1);
            }
            if(!j.d(s1, s2)) {
                arr_f2 = j.f(j.g(j.c(arr_f, arr_f5, new float[]{0.964212f, 1.0f, 0.825188f}), q1.i));
            }
        }
        arr_f3 = j.g(arr_f2, arr_f1);
        this.g = arr_f3;
    }

    @Override  // z0.g
    public final long a(long v) {
        float f = y0.s.i(v);
        float f1 = y0.s.h(v);
        float f2 = y0.s.f(v);
        float f3 = (float)this.e.p.a(((double)f));
        float f4 = (float)this.e.p.a(((double)f1));
        float f5 = (float)this.e.p.a(((double)f2));
        float f6 = this.g[6] * f5 + (this.g[3] * f4 + this.g[0] * f3);
        float f7 = this.g[7] * f5 + (this.g[4] * f4 + this.g[1] * f3);
        float f8 = this.g[8] * f5 + (this.g[5] * f4 + this.g[2] * f3);
        return M.b(((float)this.f.m.a(((double)f6))), ((float)this.f.m.a(((double)f7))), ((float)this.f.m.a(((double)f8))), y0.s.e(v), this.f);
    }
}

