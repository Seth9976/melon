package Ve;

import Xe.j;
import Xe.k;
import Ye.d;
import Ye.g;
import i.n.i.b.a.s.e.L7;
import i.n.i.b.a.s.e.M7;
import i.n.i.b.a.s.e.T4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.q;

public final class b0 implements T4 {
    public final ArrayList a;
    public final ArrayList b;

    public b0(int v, String s, e0 e00) {
        q.g(s, "name");
        super();
        this.a = new ArrayList(1);
        k.a.getClass();
        Iterable iterable0 = j.a();
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
        for(Object object0: iterable0) {
            ((d)(((k)object0))).getClass();
            arrayList0.add(new g());
        }
        this.b = arrayList0;
    }

    public b0(ArrayList arrayList0, ArrayList arrayList1) {
        this.a = arrayList0;
        this.b = arrayList1;
    }

    @Override  // i.n.i.b.a.s.e.T4
    public int a() {
        return this.b.size();
    }

    @Override  // i.n.i.b.a.s.e.T4
    public int a(long v) {
        Long long0 = v;
        ArrayList arrayList0 = this.b;
        int v1 = Collections.binarySearch(arrayList0, long0);
        if(v1 < 0) {
            int v2 = ~v1;
            return v2 >= arrayList0.size() ? -1 : v2;
        }
        int v3 = arrayList0.size();
        do {
            ++v1;
        }
        while(v1 < v3 && ((Comparable)arrayList0.get(v1)).compareTo(long0) == 0);
        return v1 >= arrayList0.size() ? -1 : v1;
    }

    @Override  // i.n.i.b.a.s.e.T4
    public long a(int v) {
        boolean z = false;
        M7.u(v >= 0);
        ArrayList arrayList0 = this.b;
        if(v < arrayList0.size()) {
            z = true;
        }
        M7.u(z);
        return (long)(((Long)arrayList0.get(v)));
    }

    @Override  // i.n.i.b.a.s.e.T4
    public List b(long v) {
        int v1 = L7.x(this.b, v, false);
        return v1 == -1 ? Collections.EMPTY_LIST : ((List)this.a.get(v1));
    }
}

