package G;

import ie.H;
import kotlin.jvm.internal.r;
import r1.f;
import r1.g;
import r1.j;
import r1.l;
import we.a;
import we.k;
import x0.b;
import x0.c;
import x0.e;

public final class i0 extends r implements k {
    public static final i0 B;
    public static final i0 D;
    public static final i0 E;
    public static final i0 G;
    public static final i0 I;
    public static final i0 M;
    public static final i0 N;
    public static final i0 S;
    public static final i0 T;
    public final int f;
    public static final i0 g;
    public static final i0 h;
    public static final i0 i;
    public static final i0 j;
    public static final i0 k;
    public static final i0 l;
    public static final i0 m;
    public static final i0 n;
    public static final i0 o;
    public static final i0 r;
    public static final i0 w;

    static {
        i0.g = new i0(1, 0);
        i0.h = new i0(1, 1);
        i0.i = new i0(1, 2);
        i0.j = new i0(1, 3);
        i0.k = new i0(1, 4);
        i0.l = new i0(1, 5);
        i0.m = new i0(1, 6);
        i0.n = new i0(1, 7);
        i0.o = new i0(1, 8);
        i0.r = new i0(1, 9);
        i0.w = new i0(1, 10);
        i0.B = new i0(1, 11);
        i0.D = new i0(1, 12);
        i0.E = new i0(1, 13);
        i0.G = new i0(1, 14);
        i0.I = new i0(1, 15);
        i0.M = new i0(1, 16);
        i0.N = new i0(1, 17);
        i0.S = new i0(1, 18);
        i0.T = new i0(1, 19);
    }

    public i0(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                n n0 = (n)object0;
                return H.a;
            }
            case 1: {
                ((a)object0).invoke();
                return H.a;
            }
            case 2: {
                return new G.r(Float.intBitsToFloat(((int)(((g)object0).a >> 0x20))), Float.intBitsToFloat(((int)(((g)object0).a & 0xFFFFFFFFL))));
            }
            case 3: {
                return new g(((long)Float.floatToRawIntBits(((G.r)object0).a)) << 0x20 | ((long)Float.floatToRawIntBits(((G.r)object0).b)) & 0xFFFFFFFFL);
            }
            case 4: {
                return new q(((f)object0).a);
            }
            case 5: {
                return new f(((q)object0).a);
            }
            case 6: {
                return new q(((Number)object0).floatValue());
            }
            case 7: {
                return ((q)object0).a;
            }
            case 8: {
                return new G.r(((float)(((int)(((j)object0).a >> 0x20)))), ((float)(((int)(((j)object0).a & 0xFFFFFFFFL)))));
            }
            case 9: {
                return new j(((long)Math.round(((G.r)object0).a)) << 0x20 | ((long)Math.round(((G.r)object0).b)) & 0xFFFFFFFFL);
            }
            case 10: {
                return new G.r(((float)(((int)(((l)object0).a >> 0x20)))), ((float)(((int)(((l)object0).a & 0xFFFFFFFFL)))));
            }
            case 11: {
                int v = Math.round(((G.r)object0).a);
                int v1 = 0;
                if(v < 0) {
                    v = 0;
                }
                int v2 = Math.round(((G.r)object0).b);
                if(v2 >= 0) {
                    v1 = v2;
                }
                return new l(((long)v1) & 0xFFFFFFFFL | ((long)v) << 0x20);
            }
            case 12: {
                return new q(((float)((Number)object0).intValue()));
            }
            case 13: {
                return (int)((q)object0).a;
            }
            case 14: {
                return new G.r(Float.intBitsToFloat(((int)(((b)object0).a >> 0x20))), Float.intBitsToFloat(((int)(((b)object0).a & 0xFFFFFFFFL))));
            }
            case 15: {
                return new b(((long)Float.floatToRawIntBits(((G.r)object0).a)) << 0x20 | ((long)Float.floatToRawIntBits(((G.r)object0).b)) & 0xFFFFFFFFL);
            }
            case 16: {
                return new t(((c)object0).a, ((c)object0).b, ((c)object0).c, ((c)object0).d);
            }
            case 17: {
                return new c(((t)object0).a, ((t)object0).b, ((t)object0).c, ((t)object0).d);
            }
            case 18: {
                return new G.r(Float.intBitsToFloat(((int)(((e)object0).a >> 0x20))), Float.intBitsToFloat(((int)(((e)object0).a & 0xFFFFFFFFL))));
            }
            default: {
                return new e(((long)Float.floatToRawIntBits(((G.r)object0).a)) << 0x20 | ((long)Float.floatToRawIntBits(((G.r)object0).b)) & 0xFFFFFFFFL);
            }
        }
    }
}

