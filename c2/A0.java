package c2;

import android.view.ViewParent;
import kotlin.jvm.internal.n;
import we.k;

public final class a0 extends n implements k {
    public static final a0 b;

    static {
        a0.b = new a0(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);  // 初始化器: Lkotlin/jvm/internal/n;-><init>(ILjava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return ((ViewParent)object0).getParent();
    }
}

