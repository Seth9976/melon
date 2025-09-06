package H8;

import G4.a;
import we.k;

public final class f implements k {
    public final int a;
    public final i b;
    public final H8.k c;

    public f(i i0, H8.k k0, int v) {
        this.a = v;
        this.b = i0;
        this.c = k0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            ((h)this.b.e).handle(((a)object0), this.c);
            return null;
        }
        ((Eb.f)this.b.c).insert(((a)object0), this.c);
        return null;
    }
}

