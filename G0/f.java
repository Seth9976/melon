package g0;

import java.util.List;

public abstract class f {
    public static final void a(int v, List list0) {
        int v1 = list0.size();
        if(v >= 0 && v < v1) {
            return;
        }
        f.c(v, v1);
    }

    public static final void b(int v, int v1, List list0) {
        if(v > v1) {
            f.f(v, v1);
        }
        if(v < 0) {
            f.d(v);
        }
        if(v1 > list0.size()) {
            f.e(v1, list0.size());
        }
    }

    private static final void c(int v, int v1) {
        throw new IndexOutOfBoundsException("Index " + v + " is out of bounds. The list has " + v1 + " elements.");
    }

    private static final void d(int v) {
        throw new IndexOutOfBoundsException("fromIndex (" + v + ") is less than 0.");
    }

    private static final void e(int v, int v1) {
        throw new IndexOutOfBoundsException("toIndex (" + v + ") is more than than the list size (" + v1 + ')');
    }

    private static final void f(int v, int v1) {
        throw new IllegalArgumentException("Indices are out of order. fromIndex (" + v + ") is greater than toIndex (" + v1 + ").");
    }
}

