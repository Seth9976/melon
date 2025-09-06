package Ge;

import Hf.x;
import Me.L;
import Me.u;
import Pe.S;
import Se.c;
import java.lang.reflect.Method;
import kotlin.jvm.internal.q;
import sf.g;
import we.k;

public final class b implements k {
    public final int a;
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;
    public static final b f;
    public static final b g;
    public static final b h;
    public static final b i;
    public static final b j;

    static {
        b.b = new b(0);
        b.c = new b(1);
        b.d = new b(2);
        b.e = new b(3);
        b.f = new b(4);
        b.g = new b(5);
        b.h = new b(6);
        b.i = new b(7);
        b.j = new b(8);
    }

    public b(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                q.g(((Class)object0), "it");
                return new B(((Class)object0));
            }
            case 1: {
                q.g(((Class)object0), "it");
                return new T(((Class)object0));
            }
            case 2: {
                Class class0 = ((Method)object0).getReturnType();
                q.f(class0, "getReturnType(...)");
                return c.b(class0);
            }
            case 3: {
                q.d(((Class)object0));
                return c.b(((Class)object0));
            }
            case 4: {
                q.g(((L)object0), "descriptor");
                return g.e.w(((L)object0)) + " | " + y0.b(((L)object0)).k();
            }
            case 5: {
                q.g(((u)object0), "descriptor");
                return g.e.w(((u)object0)) + " | " + y0.c(((u)object0)).s();
            }
            case 6: {
                x x0 = ((S)object0).getType();
                q.f(x0, "getType(...)");
                return x0.d(x0);
            }
            case 7: {
                x x1 = ((S)object0).getType();
                q.f(x1, "getType(...)");
                return x0.d(x1);
            }
            default: {
                q.d(((Class)object0));
                return c.b(((Class)object0));
            }
        }
    }
}

