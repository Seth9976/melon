package H8;

import G4.a;
import java.util.ArrayList;
import we.k;

public final class e implements k {
    public final int a;
    public final i b;
    public final ArrayList c;

    public e(i i0, ArrayList arrayList0, int v) {
        this.a = v;
        this.b = i0;
        this.c = arrayList0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                ((h)this.b.d).handleMultiple(((a)object0), this.c);
                return null;
            }
            case 1: {
                return ((h)this.b.f).handleMultiple(((a)object0), this.c);
            }
            default: {
                ((h)this.b.e).handleMultiple(((a)object0), this.c);
                return null;
            }
        }
    }
}

