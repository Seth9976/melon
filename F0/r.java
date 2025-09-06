package f0;

import Q5.h;
import Vd.w;
import androidx.compose.runtime.E0;
import androidx.compose.runtime.c;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.x0;
import g0.e;
import we.a;

public final class r extends I {
    public final int d;
    public static final r e;
    public static final r f;
    public static final r g;
    public static final r h;

    static {
        r.e = new r(1, 2, 0);
        r.f = new r(1, 1, 1);
        r.g = new r(1, 2, 2);
        r.h = new r(1, 1, 3);
    }

    public r(int v, int v1, int v2) {
        this.d = v2;
        super(v, v1, 0, 0);
    }

    @Override  // f0.I
    public final void c(w w0, c c0, E0 e00, h h0) {
        int v10;
        int v9;
        switch(this.d) {
            case 0: {
                Object object2 = ((a)w0.j(0)).invoke();
                androidx.compose.runtime.a a0 = (androidx.compose.runtime.a)w0.j(1);
                int v2 = w0.i(0);
                a0.getClass();
                e00.S(e00.c(a0), object2);
                c0.f(v2, object2);
                c0.k(object2);
                return;
            }
            case 1: {
                androidx.compose.runtime.a a1 = (androidx.compose.runtime.a)w0.j(0);
                int v3 = w0.i(0);
                c0.q();
                a1.getClass();
                c0.j(v3, e00.B(e00.c(a1)));
                return;
            }
            case 2: {
                Object object3 = w0.j(0);
                androidx.compose.runtime.a a2 = (androidx.compose.runtime.a)w0.j(1);
                int v4 = w0.i(0);
                if(object3 instanceof x0) {
                    ((e)h0.c).b(((x0)object3));
                }
                int v5 = e00.c(a2);
                int v6 = e00.g(e00.L(v5, v4));
                Object[] arr_object1 = e00.c;
                Object object4 = arr_object1[v6];
                arr_object1[v6] = object3;
                if(object4 instanceof x0) {
                    int v7 = e00.o();
                    int v8 = e00.L(v5, v4);
                    androidx.compose.runtime.a a3 = ((x0)object4).b;
                    if(a3 == null || !a3.a()) {
                        v9 = -1;
                        v10 = -1;
                    }
                    else {
                        v9 = e00.c(a3);
                        v10 = e00.o() - e00.M(v9);
                    }
                    h0.f(v7 - v8, v9, v10, ((x0)object4));
                    return;
                }
                if(object4 instanceof n0) {
                    ((n0)object4).d();
                }
                return;
            }
            default: {
                Object object0 = w0.j(0);
                int v = w0.i(0);
                if(object0 instanceof x0) {
                    ((e)h0.c).b(((x0)object0));
                }
                int v1 = e00.g(e00.L(e00.t, v));
                Object[] arr_object = e00.c;
                Object object1 = arr_object[v1];
                arr_object[v1] = object0;
                if(object1 instanceof x0) {
                    h0.f(e00.o() - e00.L(e00.t, v), -1, -1, ((x0)object1));
                    return;
                }
                if(object1 instanceof n0) {
                    ((n0)object1).d();
                }
            }
        }
    }
}

