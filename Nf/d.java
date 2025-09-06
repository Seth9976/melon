package nf;

import f0.I;
import lf.B;
import lf.C;
import lf.h0;
import lf.j;

public abstract class d {
    public static final b A;
    public static final b B;
    public static final b C;
    public static final b D;
    public static final b E;
    public static final b F;
    public static final b G;
    public static final b H;
    public static final b I;
    public static final b J;
    public static final b K;
    public static final b L;
    public static final b M;
    public static final b N;
    public static final b O;
    public static final b P;
    public static final b a;
    public static final b b;
    public static final b c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final b g;
    public static final b h;
    public static final b i;
    public static final b j;
    public static final b k;
    public static final b l;
    public static final b m;
    public static final b n;
    public static final b o;
    public static final c p;
    public static final b q;
    public static final b r;
    public static final b s;
    public static final b t;
    public static final b u;
    public static final b v;
    public static final b w;
    public static final b x;
    public static final b y;
    public static final b z;

    static {
        b b0 = I.b();
        d.a = b0;
        d.b = I.a(b0);
        b b1 = I.b();
        d.c = b1;
        h0[] arr_h0 = h0.values();
        int v = b1.b + b1.c;
        c c0 = new c(v, arr_h0);
        d.d = c0;
        C[] arr_c = C.values();
        int v1 = v + c0.c;
        c c1 = new c(v1, arr_c);
        d.e = c1;
        j[] arr_j = j.values();
        c c2 = new c(v1 + c1.c, arr_j);
        d.f = c2;
        b b2 = I.a(c2);
        d.g = b2;
        b b3 = I.a(b2);
        d.h = b3;
        b b4 = I.a(b3);
        d.i = b4;
        b b5 = I.a(b4);
        d.j = b5;
        b b6 = I.a(b5);
        d.k = b6;
        b b7 = I.a(b6);
        d.l = b7;
        d.m = I.a(b7);
        b b8 = I.a(c0);
        d.n = b8;
        d.o = I.a(b8);
        B[] arr_b = B.values();
        c c3 = new c(v1 + c1.c, arr_b);
        d.p = c3;
        b b9 = I.a(c3);
        d.q = b9;
        b b10 = I.a(b9);
        d.r = b10;
        b b11 = I.a(b10);
        d.s = b11;
        b b12 = I.a(b11);
        d.t = b12;
        b b13 = I.a(b12);
        d.u = b13;
        b b14 = I.a(b13);
        d.v = b14;
        b b15 = I.a(b14);
        d.w = b15;
        d.x = I.a(b15);
        b b16 = I.a(c3);
        d.y = b16;
        b b17 = I.a(b16);
        d.z = b17;
        b b18 = I.a(b17);
        d.A = b18;
        b b19 = I.a(b18);
        d.B = b19;
        b b20 = I.a(b19);
        d.C = b20;
        b b21 = I.a(b20);
        d.D = b21;
        b b22 = I.a(b21);
        d.E = b22;
        b b23 = I.a(b22);
        d.F = b23;
        d.G = I.a(b23);
        b b24 = I.a(b1);
        d.H = b24;
        b b25 = I.a(b24);
        d.I = b25;
        d.J = I.a(b25);
        b b26 = I.a(c1);
        d.K = b26;
        b b27 = I.a(b26);
        d.L = b27;
        d.M = I.a(b27);
        b b28 = I.b();
        d.N = b28;
        d.O = I.a(b28);
        d.P = I.b();
    }

    public static void a(int v) {
        Object[] arr_object = new Object[3];
        switch(v) {
            case 2: {
                arr_object[0] = "kind";
                break;
            }
            case 6: 
            case 9: {
                arr_object[0] = "memberKind";
                break;
            }
            case 1: 
            case 5: 
            case 8: 
            case 11: {
                arr_object[0] = "modality";
                break;
            }
            default: {
                arr_object[0] = "visibility";
            }
        }
        arr_object[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch(v) {
            case 3: {
                arr_object[2] = "getConstructorFlags";
                break;
            }
            case 4: 
            case 5: 
            case 6: {
                arr_object[2] = "getFunctionFlags";
                break;
            }
            case 7: 
            case 8: 
            case 9: {
                arr_object[2] = "getPropertyFlags";
                break;
            }
            case 10: 
            case 11: {
                arr_object[2] = "getAccessorFlags";
                break;
            }
            default: {
                arr_object[2] = "getClassFlags";
            }
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", arr_object));
    }

    public static int b(boolean z, h0 h00, C c0) {
        if(h00 != null) {
            if(c0 != null) {
                d.c.getClass();
                d.e.getClass();
                int v = c0.a();
                d.d.getClass();
                int v1 = h00.a();
                d.K.getClass();
                d.L.getClass();
                d.M.getClass();
                return (z ? 1 << d.c.b : 0) | v << d.e.b | v1 << d.d.b;
            }
            d.a(11);
            throw null;
        }
        d.a(10);
        throw null;
    }
}

