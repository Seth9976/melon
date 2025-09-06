package M;

import Q0.x0;
import ie.H;
import kotlin.jvm.internal.r;
import r1.f;
import we.k;

public final class c0 extends r implements k {
    public final int f;
    public final float g;
    public final float h;

    public c0(float f, float f1, int v) {
        this.f = v;
        this.g = f;
        this.h = f1;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            ((x0)object0).a = "padding";
            f f0 = new f(this.g);
            ((x0)object0).c.b(f0, "horizontal");
            f f1 = new f(this.h);
            ((x0)object0).c.b(f1, "vertical");
            return H.a;
        }
        ((x0)object0).a = "offset";
        f f2 = new f(this.g);
        ((x0)object0).c.b(f2, "x");
        f f3 = new f(this.h);
        ((x0)object0).c.b(f3, "y");
        return H.a;
    }
}

