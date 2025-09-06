package m0;

import androidx.compose.runtime.e1;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l0;
import j0.b;
import j0.j;

public final class g extends b implements i0 {
    public static final g d;

    static {
        g.d = new g(j.e, 0);  // 初始化器: Lj0/b;-><init>(Lj0/j;I)V
    }

    @Override  // j0.b
    public final boolean containsKey(Object object0) {
        return object0 instanceof l0 ? super.containsKey(((l0)object0)) : false;
    }

    @Override  // je.g
    public final boolean containsValue(Object object0) {
        return object0 instanceof e1 ? super.containsValue(((e1)object0)) : false;
    }

    @Override  // j0.b
    public final Object get(Object object0) {
        return !(object0 instanceof l0) ? null : ((e1)super.get(((l0)object0)));
    }

    @Override
    public final Object getOrDefault(Object object0, Object object1) {
        return !(object0 instanceof l0) ? object1 : ((e1)super.getOrDefault(((l0)object0), ((e1)object1)));
    }
}

