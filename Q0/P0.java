package Q0;

import E4.e;
import ie.H;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.r;
import w7.d;
import we.a;

public final class p0 extends r implements a {
    public final boolean f;
    public final e g;
    public final String h;

    public p0(boolean z, e e0, String s) {
        this.f = z;
        this.g = e0;
        this.h = s;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.f) {
            d d0 = (d)this.g.a.f;
            synchronized(d0) {
                E4.d d1 = (E4.d)((LinkedHashMap)this.g.a.g).remove(this.h);
                return H.a;
            }
        }
        return H.a;
    }
}

