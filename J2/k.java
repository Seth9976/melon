package J2;

import B2.i;
import B2.l;
import B2.n;
import java.util.ArrayList;
import je.q;

public final class k extends B2.k {
    public n c;
    public c d;

    public k() {
        super(0, 3);
        this.c = l.a;
        this.d = c.c;
    }

    @Override  // B2.i
    public final void a(n n0) {
        this.c = n0;
    }

    @Override  // B2.i
    public final n b() {
        return this.c;
    }

    @Override  // B2.i
    public final i copy() {
        i i0 = new k();
        i0.c = this.c;
        i0.d = this.d;
        ArrayList arrayList0 = new ArrayList(q.Q(10, this.b));
        for(Object object0: this.b) {
            arrayList0.add(((i)object0).copy());
        }
        i0.b.addAll(arrayList0);
        return i0;
    }

    @Override
    public final String toString() {
        return "EmittableBox(modifier=" + this.c + ", contentAlignment=" + this.d + "children=[\n" + this.c() + "\n])";
    }
}

