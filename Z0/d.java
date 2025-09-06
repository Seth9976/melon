package z0;

import t9.B;

public final class d {
    public static final float[] a;
    public static final float[] b;
    public static final r c;
    public static final r d;
    public static final q e;
    public static final q f;
    public static final q g;
    public static final q h;
    public static final q i;
    public static final q j;
    public static final q k;
    public static final q l;
    public static final q m;
    public static final q n;
    public static final q o;
    public static final q p;
    public static final q q;
    public static final q r;
    public static final k s;
    public static final k t;
    public static final q u;
    public static final q v;
    public static final q w;
    public static final l x;
    public static final c[] y;

    static {
        float[] arr_f = {0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f};
        d.a = arr_f;
        float[] arr_f1 = {0.67f, 0.33f, 0.21f, 0.71f, 0.14f, 0.08f};
        d.b = arr_f1;
        float[] arr_f2 = {0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f};
        r r0 = new r(2.4, 0.947867, 0.052133, 0.077399, 0.04045);
        r r1 = new r(2.2, 0.947867, 0.052133, 0.077399, 0.04045);
        r r2 = new r(-3.0, 2.0, 2.0, 5.591816, 0.284669, 0.559911, -0.68549);
        d.c = r2;
        r r3 = new r(-2.0, -1.555223, 1.860454, 0.012683, 18.851563, -18.6875, 6.277395);
        d.d = r3;
        q q0 = new q("sRGB IEC61966-2.1", arr_f, j.d, r0, 0);
        d.e = q0;
        q q1 = new q("sRGB IEC61966-2.1 (Linear)", arr_f, j.d, 1.0, 0.0f, 1.0f, 1);
        d.f = q1;
        B b0 = new B(6);
        B b1 = new B(7);
        q q2 = new q("scRGB-nl IEC 61966-2-2:2003", arr_f, j.d, null, b0, b1, -0.799f, 2.399f, r0, 2);
        d.g = q2;
        q q3 = new q("scRGB IEC 61966-2-2:2003", arr_f, j.d, 1.0, -0.5f, 7.499f, 3);
        d.h = q3;
        r r4 = new r(2.222222, 0.909918, 0.090082, 0.222222, 0.081);
        q q4 = new q("Rec. ITU-R BT.709-5", new float[]{0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f}, j.d, r4, 4);
        d.i = q4;
        r r5 = new r(2.222222, 0.90967, 0.09033, 0.222222, 0.08145);
        q q5 = new q("Rec. ITU-R BT.2020-1", new float[]{0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f}, j.d, r5, 5);
        d.j = q5;
        s s0 = new s(0.314f, 0.351f);
        q q6 = new q("SMPTE RP 431-2-2007 DCI (P3)", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, s0, 2.6, 0.0f, 1.0f, 6);
        d.k = q6;
        q q7 = new q("Display P3", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, j.d, r0, 7);
        d.l = q7;
        r r6 = new r(2.222222, 0.909918, 0.090082, 0.222222, 0.081);
        q q8 = new q("NTSC (1953)", arr_f1, j.a, r6, 8);
        d.m = q8;
        r r7 = new r(2.222222, 0.909918, 0.090082, 0.222222, 0.081);
        q q9 = new q("SMPTE-C RGB", new float[]{0.63f, 0.34f, 0.31f, 0.595f, 0.155f, 0.07f}, j.d, r7, 9);
        d.n = q9;
        q q10 = new q("Adobe RGB (1998)", new float[]{0.64f, 0.33f, 0.21f, 0.71f, 0.15f, 0.06f}, j.d, 2.2, 0.0f, 1.0f, 10);
        d.o = q10;
        r r8 = new r(1.8, 1.0, 0.0, 0.0625, 0.031248);
        q q11 = new q("ROMM RGB ISO 22028-2:2013", new float[]{0.7347f, 0.2653f, 0.1596f, 0.8404f, 0.0366f, 0.0001f}, j.b, r8, 11);
        d.p = q11;
        q q12 = new q("SMPTE ST 2065-1:2012 ACES", new float[]{0.7347f, 0.2653f, 0.0f, 1.0f, 0.0001f, -0.077f}, j.c, 1.0, -65504.0f, 65504.0f, 12);
        d.q = q12;
        q q13 = new q("Academy S-2014-004 ACEScg", new float[]{0.713f, 0.293f, 0.165f, 0.83f, 0.128f, 0.044f}, j.c, 1.0, -65504.0f, 65504.0f, 13);
        d.r = q13;
        k k0 = new k(14, 1, 0x300000001L, "Generic XYZ");
        d.s = k0;
        k k1 = new k(15, 0, 0x300000002L, "Generic L*a*b*");
        d.t = k1;
        q q14 = new q("None", arr_f, j.d, r1, 16);
        d.u = q14;
        B b2 = new B(8);
        B b3 = new B(9);
        q q15 = new q("Hybrid Log Gamma encoding", arr_f2, j.d, null, b2, b3, 0.0f, 1.0f, r2, 17);
        d.v = q15;
        B b4 = new B(10);
        B b5 = new B(11);
        q q16 = new q("Perceptual Quantizer encoding", arr_f2, j.d, null, b4, b5, 0.0f, 1.0f, r3, 18);
        d.w = q16;
        l l0 = new l("Oklab", 0x300000002L, 19);  // 初始化器: Lz0/c;-><init>(Ljava/lang/String;JI)V
        d.x = l0;
        d.y = new c[]{q0, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, k0, k1, q14, q15, q16, l0};
    }

    public static double a(r r0, double f) {
        double f1 = f < 0.0 ? -1.0 : 1.0;
        double f2 = f * f1;
        double f3 = r0.g + 1.0;
        double f4 = r0.b * f2;
        return f4 <= 1.0 ? f3 * f1 * Math.pow(f4, r0.c) : f3 * f1 * (Math.exp((f2 - r0.f) * r0.d) + r0.e);
    }

    public static double b(r r0, double f) {
        double f1 = Double.compare(f, 0.0) >= 0 ? 1.0 : -1.0;
        double f2 = f * f1 / (r0.g + 1.0);
        return f2 <= 1.0 ? f1 * (Math.pow(f2, 1.0 / r0.c) * (1.0 / r0.b)) : f1 * (Math.log(f2 - r0.e) * (1.0 / r0.d) + r0.f);
    }

    public static double c(r r0, double f) {
        double f1 = 0.0;
        double f2 = f < 0.0 ? -1.0 : 1.0;
        double f3 = f * f2;
        double f4 = r0.d;
        double f5 = Math.pow(f3, f4) * r0.c + r0.b;
        if(f5 >= 0.0) {
            f1 = f5;
        }
        return Math.pow(f1 / (Math.pow(f3, f4) * r0.f + r0.e), r0.g) * f2;
    }

    public static double d(r r0, double f) {
        return Double.compare(f, 0.0) >= 0 ? Math.pow(Math.max(Math.pow(f * 1.0, 1.0 / r0.g) * r0.e + -r0.b, 0.0) / (Math.pow(f * 1.0, 1.0 / r0.g) * -r0.f + r0.c), 1.0 / r0.d) * 1.0 : Math.pow(Math.max(Math.pow(f * -1.0, 1.0 / r0.g) * r0.e + -r0.b, 0.0) / (Math.pow(f * -1.0, 1.0 / r0.g) * -r0.f + r0.c), 1.0 / r0.d) * -1.0;
    }
}

