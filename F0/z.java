package f0;

import Q5.h;
import Vd.w;
import androidx.compose.runtime.E0;
import androidx.compose.runtime.c;
import androidx.compose.runtime.q;

public final class z extends I {
    public static final z d;

    static {
        z.d = new z(0, 0, 3);  // 初始化器: Lf0/I;-><init>(III)V
    }

    @Override  // f0.I
    public final void c(w w0, c c0, E0 e00, h h0) {
        if(e00.n != 0) {
            q.c("Cannot reset when inserting");
        }
        e00.E();
        e00.t = 0;
        e00.u = e00.m() - e00.h;
        e00.i = 0;
        e00.j = 0;
        e00.o = 0;
    }
}

