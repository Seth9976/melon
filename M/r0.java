package M;

import H0.b;
import N.a;
import androidx.compose.foundation.layout.LayoutWeightElement;
import r0.h;
import r0.q;

public final class r0 implements q0 {
    public static final r0 a;

    static {
        r0.a = new r0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final q b(h h0, q q0) {
        return b.r(h0, q0);
    }

    public final q c(float f, q q0, boolean z) {
        if(((double)f) <= 0.0) {
            a.a("invalid weight; must be greater than zero");
        }
        if(f > 3.402823E+38f) {
            f = 3.402823E+38f;
        }
        return q0.then(new LayoutWeightElement(f, z));
    }
}

