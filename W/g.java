package W;

import P0.f;
import Q0.R0;
import Q0.l0;
import U.f0;
import ie.H;
import kotlin.jvm.internal.r;
import w0.p;
import we.a;

public final class g extends r implements a {
    public final int f;
    public final i g;

    public g(i i0, int v) {
        this.f = v;
        this.g = i0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                f.s(this.g);
                return H.a;
            }
            case 1: {
                this.g.i.f();
                return true;
            }
            case 2: {
                this.g.i.o();
                return true;
            }
            case 3: {
                this.g.e.w.invoke(new f1.i(this.g.j.e));
                return true;
            }
            case 4: {
                f0 f00 = this.g.e;
                p p0 = this.g.k;
                if(!f00.b()) {
                    p.b(p0);
                    return true;
                }
                R0 r00 = f00.c;
                if(r00 != null) {
                    ((l0)r00).b();
                }
                return true;
            }
            case 5: {
                this.g.i.h(true);
                return true;
            }
            case 6: {
                this.g.i.d(true);
                return true;
            }
            default: {
                f.s(this.g);
                return H.a;
            }
        }
    }
}

