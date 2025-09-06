package f0;

import Q5.h;
import Vd.w;
import androidx.compose.runtime.E0;
import androidx.compose.runtime.a;
import androidx.compose.runtime.c;
import androidx.compose.runtime.q;
import androidx.compose.runtime.x0;

public final class e extends I {
    public static final e d;

    static {
        e.d = new e(0, 2, 1);  // 初始化器: Lf0/I;-><init>(III)V
    }

    @Override  // f0.I
    public final void c(w w0, c c0, E0 e00, h h0) {
        a a0 = (a)w0.j(0);
        Object object0 = w0.j(1);
        if(object0 instanceof x0) {
            ((g0.e)h0.c).b(((x0)object0));
        }
        if(e00.n != 0) {
            q.c("Can only append a slot if not current inserting");
        }
        int v = e00.i;
        int v1 = e00.j;
        int v2 = e00.c(a0);
        int v3 = e00.f(e00.q(v2 + 1), e00.b);
        e00.i = v3;
        e00.j = v3;
        e00.v(1, v2);
        if(v >= v3) {
            ++v;
            ++v1;
        }
        e00.c[v3] = object0;
        e00.i = v;
        e00.j = v1;
    }
}

