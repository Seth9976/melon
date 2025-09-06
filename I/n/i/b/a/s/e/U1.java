package i.n.i.b.a.s.e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class u1 implements ne {
    public final int a;
    public final int b;
    public final int c;
    public final boolean d;
    public final s1 e;
    public final t1[] f;
    public final long g;
    public final long h;

    public u1(int v, int v1, long v2, long v3, int v4, boolean z, s1 s10, t1[] arr_t1) {
        this.a = v;
        this.b = v1;
        this.g = v2;
        this.h = v3;
        this.c = v4;
        this.d = z;
        this.e = s10;
        this.f = arr_t1;
    }

    @Override  // i.n.i.b.a.s.e.ne
    public final Object b(List list0) {
        ArrayList arrayList0 = new ArrayList(list0);
        Collections.sort(arrayList0);
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        t1 t10 = null;
        int v = 0;
        while(v < arrayList0.size()) {
            fb fb0 = (fb)arrayList0.get(v);
            t1 t11 = this.f[fb0.b];
            if(t11 != t10 && t10 != null) {
                arrayList1.add(t10.b(((u[])arrayList2.toArray(new u[0]))));
                arrayList2.clear();
            }
            arrayList2.add(t11.j[fb0.c]);
            ++v;
            t10 = t11;
        }
        if(t10 != null) {
            arrayList1.add(t10.b(((u[])arrayList2.toArray(new u[0]))));
        }
        Object[] arr_object = arrayList1.toArray(new t1[0]);
        return new u1(this.a, this.b, this.g, this.h, this.c, this.d, this.e, ((t1[])arr_object));
    }
}

