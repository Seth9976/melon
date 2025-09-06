package Q0;

import L0.b;
import android.content.res.Configuration;
import ie.H;
import kotlin.jvm.internal.r;
import w0.u;
import we.k;

public final class l extends r implements k {
    public final int f;
    public static final l g;
    public static final l h;
    public static final l i;
    public static final l j;
    public static final l k;

    static {
        l.g = new l(1, 0);
        l.h = new l(1, 1);
        l.i = new l(1, 2);
        l.j = new l(1, 3);
        l.k = new l(1, 4);
    }

    public l(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                Configuration configuration0 = (Configuration)object0;
                return H.a;
            }
            case 1: {
                u u0 = (u)object0;
                return true;
            }
            case 2: {
                b b0 = (b)object0;
                return false;
            }
            case 3: {
                return Boolean.valueOf(N.g(object0));
            }
            default: {
                x0 x00 = (x0)object0;
                return H.a;
            }
        }
    }
}

