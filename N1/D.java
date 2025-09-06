package n1;

import kotlin.jvm.internal.r;
import r0.o;
import we.k;

public final class d extends r implements k {
    public static final d f;

    static {
        d.f = new d(1);  // 初始化器: Lkotlin/jvm/internal/r;-><init>(I)V
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return Boolean.valueOf(((o)object0).getClass().getName().equals("androidx.compose.animation.SizeAnimationModifierElement"));
    }
}

