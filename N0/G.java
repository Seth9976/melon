package N0;

import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ie.H;
import kotlin.jvm.internal.r;
import we.n;

public final class g extends r implements n {
    public static final g f;

    static {
        g.f = new g(2);  // 初始化器: Lkotlin/jvm/internal/r;-><init>(I)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = ((Number)object1).intValue();
        if(!((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            ((p)(((l)object0))).T();
        }
        return H.a;
    }
}

