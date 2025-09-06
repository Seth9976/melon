package M;

import Q0.x0;
import ie.H;
import kotlin.jvm.internal.r;
import r1.f;
import we.k;

public final class f0 extends r implements k {
    public final float f;
    public final float g;
    public final float h;
    public final float i;

    public f0(float f, float f1, float f2, float f3) {
        this.f = f;
        this.g = f1;
        this.h = f2;
        this.i = f3;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        ((x0)object0).a = "padding";
        f f0 = new f(this.f);
        ((x0)object0).c.b(f0, "start");
        f f1 = new f(this.g);
        ((x0)object0).c.b(f1, "top");
        f f2 = new f(this.h);
        ((x0)object0).c.b(f2, "end");
        f f3 = new f(this.i);
        ((x0)object0).c.b(f3, "bottom");
        return H.a;
    }
}

