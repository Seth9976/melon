package z0;

import java.util.Arrays;
import t9.B;
import y0.M;

public final class q extends c {
    public final s d;
    public final float e;
    public final float f;
    public final r g;
    public final float[] h;
    public final float[] i;
    public final float[] j;
    public final i k;
    public final p l;
    public final m m;
    public final i n;
    public final p o;
    public final m p;
    public final boolean q;
    public static final B r;

    static {
        q.r = new B(12);
    }

    public q(String s, float[] arr_f, s s1, double f, float f1, float f2, int v) {
        int v1 = Double.compare(f, 1.0);
        B b0 = q.r;
        B b1 = v1 == 0 ? b0 : new n(f, 0);
        if(v1 != 0) {
            b0 = new n(f, 1);
        }
        this(s, arr_f, s1, null, b1, b0, f1, f2, new r(f, 1.0, 0.0, 0.0, 0.0), v);
    }

    public q(String s, float[] arr_f, s s1, r r0, int v) {
        o o1;
        o o0;
        double f = r0.a;
        double f1 = r0.g;
        double f2 = r0.f;
        if(f == -3.0) {
            o0 = new o(r0, 4);
        }
        else if(f == -2.0) {
            o0 = new o(r0, 5);
        }
        else {
            o0 = f2 != 0.0 || f1 != 0.0 ? new o(r0, 7) : new o(r0, 6);
        }
        if(f == -3.0) {
            o1 = new o(r0, 0);
        }
        else if(f == -2.0) {
            o1 = new o(r0, 1);
        }
        else {
            o1 = f2 != 0.0 || f1 != 0.0 ? new o(r0, 3) : new o(r0, 2);
        }
        this(s, arr_f, s1, null, o0, o1, 0.0f, 1.0f, r0, v);
    }

    public q(String s, float[] arr_f, s s1, float[] arr_f1, i i0, i i1, float f, float f1, r r0, int v) {
        super(s, 0x300000000L, v);
        this.d = s1;
        this.e = f;
        this.f = f1;
        this.g = r0;
        this.k = i0;
        boolean z = true;
        this.l = new p(this, 1);
        this.m = new m(this, 0);
        this.n = i1;
        this.o = new p(this, 0);
        this.p = new m(this, 1);
        if(arr_f.length != 6 && arr_f.length != 9) {
            throw new IllegalArgumentException("The color space\'s primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
        }
        if(f >= f1) {
            throw new IllegalArgumentException("Invalid range: min=" + f + ", max=" + f1 + "; min must be strictly < max");
        }
        float[] arr_f2 = new float[6];
        if(arr_f.length == 9) {
            float f2 = arr_f[0];
            float f3 = arr_f[1];
            float f4 = f2 + f3 + arr_f[2];
            arr_f2[0] = f2 / f4;
            arr_f2[1] = f3 / f4;
            float f5 = arr_f[3];
            float f6 = arr_f[4];
            float f7 = f5 + f6 + arr_f[5];
            arr_f2[2] = f5 / f7;
            arr_f2[3] = f6 / f7;
            float f8 = arr_f[6];
            float f9 = arr_f[7];
            float f10 = f8 + f9 + arr_f[8];
            arr_f2[4] = f8 / f10;
            arr_f2[5] = f9 / f10;
        }
        else {
            System.arraycopy(arr_f, 0, arr_f2, 0, 6);
        }
        this.h = arr_f2;
        if(arr_f1 == null) {
            float f11 = arr_f2[0];
            float f12 = arr_f2[1];
            float f13 = arr_f2[2];
            float f14 = arr_f2[3];
            float f15 = arr_f2[4];
            float f16 = arr_f2[5];
            float f17 = (1.0f - f11) / f12;
            float f18 = f11 / f12;
            float f19 = f13 / f14 - f18;
            float f20 = s1.a / s1.b - f18;
            float f21 = (1.0f - f13) / f14 - f17;
            float f22 = f15 / f16 - f18;
            float f23 = (((1.0f - s1.a) / s1.b - f17) * f19 - f20 * f21) / (((1.0f - f15) / f16 - f17) * f19 - f21 * f22);
            float f24 = (f20 - f22 * f23) / f19;
            float f25 = 1.0f - f24 - f23;
            this.i = new float[]{f25 / f12 * f11, f25, (1.0f - f11 - f12) * (f25 / f12), f24 / f14 * f13, f24, (1.0f - f13 - f14) * (f24 / f14), f23 / f16 * f15, f23, (1.0f - f15 - f16) * (f23 / f16)};
        }
        else if(arr_f1.length == 9) {
            this.i = arr_f1;
        }
        else {
            throw new IllegalArgumentException("Transform must have 9 entries! Has " + arr_f1.length);
        }
        this.j = j.f(this.i);
        if(v != 0) {
            float[] arr_f3 = d.a;
            if(arr_f2 != arr_f3) {
                for(int v1 = 0; v1 < 6; ++v1) {
                    if(Float.compare(arr_f2[v1], arr_f3[v1]) != 0 && Math.abs(arr_f2[v1] - arr_f3[v1]) > 0.001f) {
                        z = false;
                        this.q = z;
                        return;
                    }
                }
            }
            if(j.d(s1, j.d) && f == 0.0f && f1 == 1.0f) {
                q q0 = d.e;
                for(double f26 = 0.0; f26 <= 1.0; f26 += 0.003922) {
                    if(Math.abs(i0.a(f26) - q0.k.a(f26)) > 0.001 || Math.abs(i1.a(f26) - q0.n.a(f26)) > 0.001) {
                        z = false;
                        this.q = z;
                        return;
                    }
                }
                this.q = z;
                return;
            }
            z = false;
        }
        this.q = z;
    }

    @Override  // z0.c
    public final float a(int v) {
        return this.f;
    }

    @Override  // z0.c
    public final float b(int v) {
        return this.e;
    }

    @Override  // z0.c
    public final boolean c() {
        return this.q;
    }

    @Override  // z0.c
    public final long d(float f, float f1, float f2) {
        float f3 = (float)this.p.a(((double)f));
        float f4 = (float)this.p.a(((double)f1));
        float f5 = (float)this.p.a(((double)f2));
        return this.i.length >= 9 ? ((long)Float.floatToRawIntBits(this.i[7] * f5 + (this.i[4] * f4 + this.i[1] * f3))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(this.i[6] * f5 + (this.i[3] * f4 + this.i[0] * f3))) << 0x20 : 0L;
    }

    @Override  // z0.c
    public final float e(float f, float f1, float f2) {
        float f3 = (float)this.p.a(((double)f));
        float f4 = (float)this.p.a(((double)f1));
        float f5 = (float)this.p.a(((double)f2));
        return this.i[8] * f5 + (this.i[5] * f4 + this.i[2] * f3);
    }

    @Override  // z0.c
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            if(q.class != class0 || !super.equals(object0)) {
                return false;
            }
            r r0 = ((q)object0).g;
            if(Float.compare(((q)object0).e, this.e) != 0) {
                return false;
            }
            if(Float.compare(((q)object0).f, this.f) != 0) {
                return false;
            }
            if(!kotlin.jvm.internal.q.b(this.d, ((q)object0).d)) {
                return false;
            }
            if(!Arrays.equals(this.h, ((q)object0).h)) {
                return false;
            }
            r r1 = this.g;
            if(r1 != null) {
                return kotlin.jvm.internal.q.b(r1, r0);
            }
            if(r0 == null) {
                return true;
            }
            return kotlin.jvm.internal.q.b(this.k, ((q)object0).k) ? kotlin.jvm.internal.q.b(this.n, ((q)object0).n) : false;
        }
        return false;
    }

    @Override  // z0.c
    public final long f(float f, float f1, float f2, float f3, c c0) {
        float f4 = this.j[6] * f2 + (this.j[3] * f1 + this.j[0] * f);
        float f5 = this.j[7] * f2 + (this.j[4] * f1 + this.j[1] * f);
        float f6 = this.j[8] * f2 + (this.j[5] * f1 + this.j[2] * f);
        return M.b(((float)this.m.a(((double)f4))), ((float)this.m.a(((double)f5))), ((float)this.m.a(((double)f6))), f3, c0);
    }

    @Override  // z0.c
    public final int hashCode() {
        int v = super.hashCode();
        int v1 = this.d.hashCode();
        int v2 = Arrays.hashCode(this.h);
        int v3 = 0;
        int v4 = Float.compare(this.e, 0.0f) == 0 ? 0 : Float.floatToIntBits(this.e);
        int v5 = this.f == 0.0f ? 0 : Float.floatToIntBits(this.f);
        r r0 = this.g;
        if(r0 != null) {
            v3 = r0.hashCode();
        }
        int v6 = (((v2 + (v1 + v * 0x1F) * 0x1F) * 0x1F + v4) * 0x1F + v5) * 0x1F + v3;
        return r0 == null ? this.n.hashCode() + (this.k.hashCode() + v6 * 0x1F) * 0x1F : v6;
    }
}

