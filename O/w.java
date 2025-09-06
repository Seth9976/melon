package O;

import androidx.collection.y;
import m0.b;
import we.o;

public interface w {
    static void a(w w0, o o0) {
        ((j)w0).t(o0);
    }

    static void b(w w0, int v, b b0) {
        ((j)w0).u(v, null, r.h, b0);
    }

    static void c(w w0, b b0) {
        B7.b b1 = ((j)w0).b;
        y y0 = ((j)w0).c;
        if(y0 == null) {
            y0 = new y();
            ((j)w0).c = y0;
        }
        y0.a(b1.a);
        ((j)w0).t(new b(0x58EDD31F, new i(b0, b1.a), true));
    }
}

