package androidx.collection;

import E.a;
import java.util.ConcurrentModificationException;
import kotlin.jvm.internal.q;

public abstract class t {
    public static final Object a;
    public static final long[] b;
    public static final Object c;

    static {
        t.a = new Object();
        t.b = new long[0];
        t.c = new Object();
    }

    public static final void a(g g0, int v) {
        g0.a = new int[v];
        g0.b = new Object[v];
    }

    public static final int b(g g0, Object object0, int v) {
        int v2;
        int v1 = g0.c;
        if(v1 == 0) {
            return -1;
        }
        try {
            v2 = a.a(v1, v, g0.a);
        }
        catch(IndexOutOfBoundsException unused_ex) {
            throw new ConcurrentModificationException();
        }
        if(v2 < 0 || q.b(object0, g0.b[v2])) {
            return v2;
        }
        int v3;
        for(v3 = v2 + 1; v3 < v1 && g0.a[v3] == v; ++v3) {
            if(q.b(object0, g0.b[v3])) {
                return v3;
            }
        }
        for(int v4 = v2 - 1; v4 >= 0 && g0.a[v4] == v; --v4) {
            if(q.b(object0, g0.b[v4])) {
                return v4;
            }
        }
        return ~v3;
    }
}

