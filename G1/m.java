package G1;

import java.util.ArrayList;

public final class m {
    public p a;
    public ArrayList b;

    public static long a(g g0, long v) {
        p p0 = g0.d;
        ArrayList arrayList0 = g0.k;
        if(p0 instanceof k) {
            return v;
        }
        int v1 = arrayList0.size();
        long v3 = v;
        for(int v2 = 0; v2 < v1; ++v2) {
            e e0 = (e)arrayList0.get(v2);
            if(e0 instanceof g && ((g)e0).d != p0) {
                v3 = Math.min(v3, m.a(((g)e0), ((long)((g)e0).f) + v));
            }
        }
        g g1 = p0.h;
        if(g0 == p0.i) {
            long v4 = v - p0.j();
            return Math.min(Math.min(v3, m.a(g1, v4)), v4 - ((long)g1.f));
        }
        return v3;
    }

    public static long b(g g0, long v) {
        p p0 = g0.d;
        ArrayList arrayList0 = g0.k;
        if(p0 instanceof k) {
            return v;
        }
        int v1 = arrayList0.size();
        long v3 = v;
        for(int v2 = 0; v2 < v1; ++v2) {
            e e0 = (e)arrayList0.get(v2);
            if(e0 instanceof g && ((g)e0).d != p0) {
                v3 = Math.max(v3, m.b(((g)e0), ((long)((g)e0).f) + v));
            }
        }
        g g1 = p0.i;
        if(g0 == p0.h) {
            long v4 = p0.j() + v;
            return Math.max(Math.max(v3, m.b(g1, v4)), v4 - ((long)g1.f));
        }
        return v3;
    }
}

