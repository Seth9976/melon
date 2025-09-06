package Z;

import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.c1;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import y0.s;

public abstract class g {
    public static final c1 a;

    static {
        g.a = new c1(f.g);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
    }

    public static final long a(long v, l l0) {
        long v2;
        ((p)l0).a0(0xD6226741);
        e e0 = (e)((p)l0).k(g.a);
        long v1 = e0.b();
        b0 b00 = e0.i;
        b0 b01 = e0.h;
        if(s.d(v, v1)) {
            v2 = ((s)((O0)b01).getValue()).a;
        }
        else if(s.d(v, ((s)((O0)e0.b).getValue()).a)) {
            v2 = ((s)((O0)b01).getValue()).a;
        }
        else if(s.d(v, ((s)((O0)e0.c).getValue()).a)) {
            v2 = ((s)((O0)b00).getValue()).a;
        }
        else if(s.d(v, ((s)((O0)e0.d).getValue()).a)) {
            v2 = ((s)((O0)b00).getValue()).a;
        }
        else if(s.d(v, ((s)((O0)e0.e).getValue()).a)) {
            v2 = ((s)((O0)e0.j).getValue()).a;
        }
        else if(s.d(v, e0.c())) {
            v2 = e0.a();
        }
        else {
            v2 = s.d(v, ((s)((O0)e0.g).getValue()).a) ? ((s)((O0)e0.l).getValue()).a : s.g;
        }
        if(v2 == 16L) {
            v2 = ((s)((p)l0).k(i.a)).a;
        }
        ((p)l0).p(false);
        return v2;
    }
}

