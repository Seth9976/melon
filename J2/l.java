package J2;

import B2.i;
import B2.k;
import B2.n;
import java.util.ArrayList;
import je.q;

public final class l extends k {
    public n c;
    public int d;
    public int e;

    public l() {
        super(0, 3);
        this.c = B2.l.a;
        this.d = 0;
        this.e = 0;
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
        i i0 = new l();
        i0.c = this.c;
        i0.d = this.d;
        i0.e = this.e;
        ArrayList arrayList0 = new ArrayList(q.Q(10, this.b));
        for(Object object0: this.b) {
            arrayList0.add(((i)object0).copy());
        }
        i0.b.addAll(arrayList0);
        return i0;
    }

    @Override
    public final String toString() {
        return "EmittableColumn(modifier=" + this.c + ", verticalAlignment=" + b.b(this.d) + ", horizontalAlignment=" + a.b(this.e) + ", children=[\n" + this.c() + "\n])";
    }
}

