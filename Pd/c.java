package pd;

import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;

public final class c {
    public static final c a;
    public static final LogU b;

    static {
        c.a = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        c.b = Companion.create$default(LogU.Companion, "PlaybackUi", false, null, 6, null);
    }
}

