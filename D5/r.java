package d5;

import ie.H;
import java.util.HashMap;
import we.k;

public final class r implements k {
    public final int a;
    public final s b;

    public r(s s0, int v) {
        this.a = v;
        this.b = s0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            this.b.a(((HashMap)object0));
            return H.a;
        }
        this.b.b(((HashMap)object0));
        return H.a;
    }
}

