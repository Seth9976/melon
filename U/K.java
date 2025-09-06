package U;

import I.u0;
import N0.Z;
import X0.l;
import X0.s;
import Y.F;
import a1.M;
import a1.Q;
import a1.S;
import a1.w;
import f1.e;
import f1.x;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;

public final class k extends r implements we.k {
    public static final k B;
    public static final k D;
    public final int f;
    public static final k g;
    public static final k h;
    public static final k i;
    public static final k j;
    public static final k k;
    public static final k l;
    public static final k m;
    public static final k n;
    public static final k o;
    public static final k r;
    public static final k w;

    static {
        k.g = new k(1, 0);
        k.h = new k(1, 1);
        k.i = new k(1, 2);
        k.j = new k(1, 3);
        k.k = new k(1, 4);
        k.l = new k(1, 5);
        k.m = new k(1, 6);
        k.n = new k(1, 7);
        k.o = new k(1, 8);
        k.r = new k(1, 9);
        k.w = new k(1, 10);
        k.B = new k(1, 11);
        k.D = new k(1, 12);
    }

    public k(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        switch(this.f) {
            case 0: {
                Q q0 = (Q)object0;
                return h0;
            }
            case 1: {
                Z z0 = (Z)object0;
                return h0;
            }
            case 2: {
                Z z1 = (Z)object0;
                return h0;
            }
            case 3: {
                x x0 = (x)object0;
                return h0;
            }
            case 4: {
                long v = ((F)object0).f;
                return new e(((int)(v & 0xFFFFFFFFL)) - b0.v(((int)(0xFFFFFFFFL & v)), ((F)object0).g.b), 0);
            }
            case 5: {
                int v1 = b0.s(((int)(((F)object0).f & 0xFFFFFFFFL)), ((F)object0).g.b);
                return v1 == -1 ? null : new e(0, v1 - ((int)(0xFFFFFFFFL & ((F)object0).f)));
            }
            case 6: {
                Integer integer0 = ((F)object0).e();
                return integer0 == null ? null : new e(((int)(0xFFFFFFFFL & ((F)object0).f)) - integer0.intValue(), 0);
            }
            case 7: {
                Integer integer1 = ((F)object0).d();
                return integer1 == null ? null : new e(0, integer1.intValue() - ((int)(0xFFFFFFFFL & ((F)object0).f)));
            }
            case 8: {
                Integer integer2 = ((F)object0).c();
                return integer2 == null ? null : new e(((int)(0xFFFFFFFFL & ((F)object0).f)) - integer2.intValue(), 0);
            }
            case 9: {
                Integer integer3 = ((F)object0).b();
                return integer3 == null ? null : new e(0, integer3.intValue() - ((int)(0xFFFFFFFFL & ((F)object0).f)));
            }
            case 10: {
                Object object1 = ((List)object0).get(1);
                q.e(object1, "null cannot be cast to non-null type kotlin.Boolean");
                Object object2 = ((List)object0).get(0);
                q.e(object2, "null cannot be cast to non-null type kotlin.Float");
                return new H0((((Boolean)object1).booleanValue() ? u0.a : u0.b), ((float)(((Float)object2))));
            }
            case 11: {
                Object object3 = ((a1.e)object0).a;
                if(object3 instanceof w) {
                    q.e(object3, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation");
                    S s0 = ((w)object3).a();
                    if(s0 != null && (s0.a != null || s0.b != null || s0.c != null || s0.d != null)) {
                        q.e(((a1.e)object0).a, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation");
                        S s1 = ((w)((a1.e)object0).a).a();
                        if(s1 != null) {
                            return s1.a == null ? e.k.e(new a1.e[]{((a1.e)object0), new a1.e(new M(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 0xFFFF), ((a1.e)object0).b, ((a1.e)object0).c)}) : e.k.e(new a1.e[]{((a1.e)object0), new a1.e(s1.a, ((a1.e)object0).b, ((a1.e)object0).c)});
                        }
                        return e.k.e(new a1.e[]{((a1.e)object0), new a1.e(new M(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 0xFFFF), ((a1.e)object0).b, ((a1.e)object0).c)});
                    }
                }
                return e.k.e(new a1.e[]{((a1.e)object0)});
            }
            default: {
                ((l)(((X0.x)object0))).g(s.x, h0);
                return h0;
            }
        }
    }
}

