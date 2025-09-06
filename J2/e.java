package J2;

import ie.H;
import kotlin.jvm.internal.r;
import we.n;

public final class e extends r implements n {
    public final int f;
    public static final e g;
    public static final e h;
    public static final e i;
    public static final e j;
    public static final e k;
    public static final e l;
    public static final e m;
    public static final e n;
    public static final e o;

    static {
        e.g = new e(2, 0);
        e.h = new e(2, 1);
        e.i = new e(2, 2);
        e.j = new e(2, 3);
        e.k = new e(2, 4);
        e.l = new e(2, 5);
        e.m = new e(2, 6);
        e.n = new e(2, 7);
        e.o = new e(2, 8);
    }

    public e(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.f) {
            case 0: {
                ((k)object0).c = (B2.n)object1;
                return H.a;
            }
            case 1: {
                ((k)object0).d = (c)object1;
                return H.a;
            }
            case 2: {
                ((l)object0).c = (B2.n)object1;
                return H.a;
            }
            case 3: {
                ((l)object0).e = ((a)object1).a;
                return H.a;
            }
            case 4: {
                ((l)object0).d = ((b)object1).a;
                return H.a;
            }
            case 5: {
                ((m)object0).c = (B2.n)object1;
                return H.a;
            }
            case 6: {
                ((m)object0).e = ((b)object1).a;
                return H.a;
            }
            case 7: {
                ((m)object0).d = ((a)object1).a;
                return H.a;
            }
            default: {
                ((J2.n)object0).a = (B2.n)object1;
                return H.a;
            }
        }
    }
}

