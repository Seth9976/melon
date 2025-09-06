package H8;

import G4.a;
import java.util.List;
import we.k;

public final class m implements k {
    public final int a;
    public final q b;
    public final List c;

    public m(q q0, List list0, int v) {
        this.a = v;
        this.b = q0;
        this.c = list0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            ((h)this.b.f).handleMultiple(((a)object0), this.c);
            return null;
        }
        ((h)this.b.g).handleMultiple(((a)object0), this.c);
        return null;
    }
}

