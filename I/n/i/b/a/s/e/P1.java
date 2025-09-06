package i.n.i.b.a.s.e;

import android.net.Uri;
import b3.x;
import d5.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class p1 implements ne {
    public final long a;
    public final long b;
    public final long c;
    public final boolean d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final c i;
    public final x j;
    public final Uri k;
    public final x4 l;
    public final List m;

    public p1(long v, long v1, long v2, boolean z, long v3, long v4, long v5, long v6, x4 x40, c c0, x x0, Uri uri0, ArrayList arrayList0) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = z;
        this.e = v3;
        this.f = v4;
        this.g = v5;
        this.h = v6;
        this.l = x40;
        this.i = c0;
        this.k = uri0;
        this.j = x0;
        this.m = arrayList0;
    }

    public final g4 a(int v) {
        return (g4)this.m.get(v);
    }

    @Override  // i.n.i.b.a.s.e.ne
    public final Object b(List list0) {
        long v4;
        long v2;
        LinkedList linkedList0 = new LinkedList(list0);
        Collections.sort(linkedList0);
        linkedList0.add(new fb());
        ArrayList arrayList0 = new ArrayList();
        long v = 0L;
        int v1 = 0;
        while(true) {
            v2 = 0x8000000000000001L;
            if(v1 >= this.m.size()) {
                break;
            }
            if(((fb)linkedList0.peek()).a == v1) {
            label_15:
                g4 g40 = this.a(v1);
                List list1 = g40.c;
                fb fb0 = (fb)linkedList0.poll();
                int v5 = fb0.a;
                ArrayList arrayList1 = new ArrayList();
                while(true) {
                    int v6 = fb0.b;
                    x0 x00 = (x0)list1.get(v6);
                    List list2 = x00.c;
                    ArrayList arrayList2 = new ArrayList();
                    do {
                        arrayList2.add(((z5)list2.get(fb0.c)));
                        fb0 = (fb)linkedList0.poll();
                    }
                    while(fb0.a == v5 && fb0.b == v6);
                    v4 = v;
                    arrayList1.add(new x0(x00.a, x00.b, arrayList2, x00.d, x00.e, x00.f));
                    if(fb0.a != v5) {
                        break;
                    }
                    v = v4;
                }
                linkedList0.addFirst(fb0);
                arrayList0.add(new g4(g40.a, g40.b - v4, arrayList1, g40.d));
            }
            else {
                long v3 = this.c(v1);
                if(v3 == 0x8000000000000001L) {
                    v4 = v;
                    goto label_34;
                }
                else {
                    v += v3;
                    goto label_35;
                }
                goto label_15;
            }
        label_34:
            v = v4;
        label_35:
            ++v1;
        }
        long v7 = this.b;
        if(v7 != 0x8000000000000001L) {
            v2 = v7 - v;
        }
        return new p1(this.a, v2, this.c, this.d, this.e, this.f, this.g, this.h, this.l, this.i, this.j, this.k, arrayList0);
    }

    public final long c(int v) {
        List list0 = this.m;
        if(v == list0.size() - 1) {
            return this.b == 0x8000000000000001L ? 0x8000000000000001L : this.b - ((g4)list0.get(v)).b;
        }
        return ((g4)list0.get(v + 1)).b - ((g4)list0.get(v)).b;
    }

    public final long d(int v) {
        return b4.a(this.c(v));
    }
}

