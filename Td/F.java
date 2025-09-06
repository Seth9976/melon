package td;

import com.melon.ui.playermusic.l;
import kotlin.jvm.internal.n;
import we.a;

public final class f extends n implements a {
    public static final f b;

    static {
        f.b = new f(0, l.class, "canPlay", "canPlay()Z", 1);  // 初始化器: Lkotlin/jvm/internal/n;-><init>(ILjava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // we.a
    public final Object invoke() {
        return Boolean.valueOf(l.e());
    }
}

