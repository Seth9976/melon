package f0;

import Q5.h;
import Vd.w;
import androidx.compose.runtime.E0;
import androidx.compose.runtime.c;

public final class k extends I {
    public static final k d;

    static {
        k.d = new k(0, 1, 1);  // 初始化器: Lf0/I;-><init>(III)V
    }

    @Override  // f0.I
    public final void c(w w0, c c0, E0 e00, h h0) {
        Object[] arr_object = (Object[])w0.j(0);
        for(int v = 0; v < arr_object.length; ++v) {
            c0.k(arr_object[v]);
        }
    }
}

