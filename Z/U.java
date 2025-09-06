package Z;

import G.C;
import G.e;
import G.w;
import G.x0;
import K.b;
import K.f;
import K.h;
import K.k;
import K.o;
import ie.H;
import ne.a;
import oe.c;

public abstract class u {
    public static final x0 a;
    public static final x0 b;
    public static final x0 c;

    static {
        u.a = new x0(120, C.a, 2);
        u.b = new x0(150, new w(0.4f, 0.0f, 0.6f, 1.0f), 2);
        u.c = new x0(120, new w(0.4f, 0.0f, 0.6f, 1.0f), 2);
    }

    public static final Object a(e e0, float f, k k0, k k1, c c0) {
        x0 x01;
        x0 x00 = null;
        if(k1 != null) {
            x01 = u.a;
            if(k1 instanceof o) {
                x00 = x01;
            }
            else if(k1 instanceof b || k1 instanceof h || k1 instanceof f) {
                x00 = x01;
            }
        }
        else if(k0 != null) {
            x01 = u.b;
            if(k0 instanceof o || k0 instanceof b) {
                x00 = x01;
            }
            else if(k0 instanceof h) {
                x00 = u.c;
            }
            else if(k0 instanceof f) {
                x00 = x01;
            }
        }
        if(x00 == null) {
            Object object1 = e0.e(new r1.f(f), c0);
            if(object1 == a.a) {
                return object1;
            }
        }
        else {
            Object object0 = e.c(e0, new r1.f(f), x00, null, c0, 12);
            if(object0 == a.a) {
                return object0;
            }
        }
        return H.a;
    }
}

