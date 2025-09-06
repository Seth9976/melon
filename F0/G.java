package f0;

import Q5.h;
import Vd.w;
import androidx.compose.runtime.E0;
import androidx.compose.runtime.c;
import java.util.List;
import m0.d;

public final class g extends I {
    public static final g d;

    static {
        g.d = new g(0, 2, 1);  // 初始化器: Lf0/I;-><init>(III)V
    }

    @Override  // f0.I
    public final void c(w w0, c c0, E0 e00, h h0) {
        int v1 = ((d)w0.j(0)).a;
        List list0 = (List)w0.j(1);
        int v2 = list0.size();
        for(int v = 0; v < v2; ++v) {
            Object object0 = list0.get(v);
            int v3 = v1 + v;
            c0.j(v3, object0);
            c0.f(v3, object0);
        }
    }
}

