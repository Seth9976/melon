package p0;

import we.a;
import we.k;

public abstract class q {
    public static final Object a;

    static {
        q.a = new Object();
    }

    public static final void a(int v, int v1) {
        if(v < 0 || v >= v1) {
            throw new IndexOutOfBoundsException("index (" + v + ") is out of bound of [0, " + v1 + ')');
        }
    }

    public static final int b(long[] arr_v, long v) {
        int v1 = arr_v.length - 1;
        int v2 = 0;
        while(v2 <= v1) {
            int v3 = v2 + v1 >>> 1;
            int v4 = Long.compare(v, arr_v[v3]);
            if(v4 > 0) {
                v2 = v3 + 1;
                continue;
            }
            if(v4 < 0) {
                v1 = v3 - 1;
                continue;
            }
            return v3;
        }
        return -(v2 + 1);
    }

    public abstract void c();

    public static h d() {
        return (h)m.a.i();
    }

    public static h e(h h0) {
        if(h0 instanceof x && ((x)h0).t == 0x709A0L) {
            ((x)h0).r = null;
            return h0;
        }
        if(h0 instanceof y && ((y)h0).h == 0x709A0L) {
            ((y)h0).g = null;
            return h0;
        }
        h h1 = m.h(h0, null, false);
        h1.j();
        return h1;
    }

    public static Object f(k k0, a a0) {
        Object object1;
        h h1;
        if(k0 == null) {
            return a0.invoke();
        }
        h h0 = (h)m.a.i();
        if(h0 instanceof x && ((x)h0).t == 0x709C1L) {
            k k1 = ((x)h0).r;
            k k2 = ((x)h0).s;
            try {
                ((x)h0).r = m.l(k0, k1, true);
                ((x)h0).s = k2;
                return a0.invoke();
            }
            finally {
                ((x)h0).r = k1;
                ((x)h0).s = k2;
            }
        }
        if(h0 == null || h0 instanceof d) {
            h1 = new x((h0 instanceof d ? ((d)h0) : null), k0, null, true, false);
        }
        else {
            if(k0 == null) {
                return a0.invoke();
            }
            h1 = h0.u(k0);
        }
        try {
            h h2 = h1.j();
            try {
                object1 = a0.invoke();
            }
            catch(Throwable throwable0) {
                h.q(h2);
                throw throwable0;
            }
            h.q(h2);
            return object1;
        }
        finally {
            h1.c();
        }
    }

    public static void g(h h0, h h1, k k0) {
        if(h0 == h1) {
            if(h0 instanceof x) {
                ((x)h0).r = k0;
                return;
            }
            if(!(h0 instanceof y)) {
                throw new IllegalStateException(("Non-transparent snapshot was reused: " + h0).toString());
            }
            ((y)h0).g = k0;
            return;
        }
        h1.getClass();
        h.q(h0);
        h1.c();
    }

    public static final void h() {
        throw new UnsupportedOperationException();
    }
}

