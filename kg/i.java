package kg;

import ie.H;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.a;

public final class i extends r implements a {
    public final int f;
    public final j g;
    public final l h;

    public i(j j0, l l0, int v) {
        this.f = v;
        this.g = j0;
        this.h = l0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.f != 0) {
            for(Object object0: this.g.a) {
                ((jg.a)object0).getClass();
                q.g(this.h, "device");
                ((jg.a)object0).b.invoke(this.h);
            }
            return H.a;
        }
        for(Object object1: this.g.a) {
            ((jg.a)object1).getClass();
            ((jg.a)object1).a.invoke(this.h);
        }
        return H.a;
    }
}

