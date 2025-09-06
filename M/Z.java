package M;

import N.a;
import androidx.compose.foundation.layout.LayoutWeightElement;
import r0.q;

public final class z {
    public static final z a;

    static {
        z.a = new z();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static q a(q q0, float f) {
        if(((double)f) <= 0.0) {
            a.a("invalid weight; must be greater than zero");
        }
        if(f > 3.402823E+38f) {
            f = 3.402823E+38f;
        }
        return q0.then(new LayoutWeightElement(f, true));
    }
}

