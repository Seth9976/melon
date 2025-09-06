package f0;

import Q5.h;
import Vd.w;
import androidx.compose.runtime.B0;
import androidx.compose.runtime.E0;
import androidx.compose.runtime.a;
import androidx.compose.runtime.c;
import androidx.compose.runtime.q;

public final class t extends I {
    public static final t d;

    static {
        t.d = new t(0, 3, 1);  // 初始化器: Lf0/I;-><init>(III)V
    }

    @Override  // f0.I
    public final void c(w w0, c c0, E0 e00, h h0) {
        B0 b00 = (B0)w0.j(1);
        a a0 = (a)w0.j(0);
        f0.c c1 = (f0.c)w0.j(2);
        E0 e01 = b00.k();
        try {
            if(!c1.h.J()) {
                q.c("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
            }
            c1.g.I(c0, e01, h0);
        }
        catch(Throwable throwable0) {
            e01.e(false);
            throw throwable0;
        }
        e01.e(true);
        e00.d();
        a0.getClass();
        e00.y(b00, b00.a(a0));
        e00.j();
    }
}

