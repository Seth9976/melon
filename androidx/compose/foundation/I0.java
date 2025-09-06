package androidx.compose.foundation;

import F.C;
import K.l;
import androidx.compose.runtime.c1;
import r0.a;
import r0.n;
import r0.q;

public abstract class i0 {
    public static final c1 a;

    static {
        i0.a = new c1(h0.g);  // 初始化器: Landroidx/compose/runtime/l0;-><init>(Lwe/a;)V
    }

    public static final q a(l l0, f0 f00) {
        q q0 = n.a;
        if(f00 == null) {
            return q0;
        }
        return f00 instanceof l0 ? new IndicationModifierElement(l0, ((l0)f00)) : a.a(q0, new C(6, f00, l0));
    }
}

