package Q0;

import X0.p;
import ie.m;
import java.util.Comparator;
import x0.c;

public final class z0 implements Comparator {
    public final int a;
    public static final z0 b;
    public static final z0 c;
    public static final z0 d;

    static {
        z0.b = new z0(0);
        z0.c = new z0(1);
        z0.d = new z0(2);
    }

    public z0(int v) {
        this.a = v;
        super();
    }

    @Override
    public final int compare(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                c c0 = ((p)object0).f();
                c c1 = ((p)object1).f();
                int v1 = Float.compare(c0.a, c1.a);
                if(v1 == 0) {
                    v1 = Float.compare(c0.b, c1.b);
                    if(v1 == 0) {
                        v1 = Float.compare(c0.d, c1.d);
                        return v1 == 0 ? Float.compare(c0.c, c1.c) : v1;
                    }
                }
                return v1;
            }
            case 1: {
                c c2 = ((p)object0).f();
                c c3 = ((p)object1).f();
                int v2 = Float.compare(c3.c, c2.c);
                if(v2 == 0) {
                    v2 = Float.compare(c2.b, c3.b);
                    if(v2 == 0) {
                        v2 = Float.compare(c2.d, c3.d);
                        return v2 == 0 ? Float.compare(c3.a, c2.a) : v2;
                    }
                }
                return v2;
            }
            default: {
                int v = Float.compare(((c)((m)object0).a).b, ((c)((m)object1).a).b);
                return v == 0 ? Float.compare(((c)((m)object0).a).d, ((c)((m)object1).a).d) : v;
            }
        }
    }
}

