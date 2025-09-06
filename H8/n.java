package H8;

import Eb.f;
import G4.a;
import java.util.ArrayList;
import we.k;

public final class n implements k {
    public final int a;
    public final q b;
    public final ArrayList c;

    public n(q q0, ArrayList arrayList0, int v) {
        this.a = v;
        this.b = q0;
        this.c = arrayList0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                ((f)this.b.d).insert(((a)object0), this.c);
                return null;
            }
            case 1: {
                ((h)this.b.e).handleMultiple(((a)object0), this.c);
                return null;
            }
            default: {
                ((f)this.b.c).insert(((a)object0), this.c);
                return null;
            }
        }
    }
}

