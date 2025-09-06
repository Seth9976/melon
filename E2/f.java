package E2;

import android.content.Context;
import android.content.Intent;
import org.jetbrains.annotations.NotNull;

public final class f {
    public static final f a;

    static {
        f.a = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final void a(@NotNull Context context0, @NotNull Intent intent0) {
        context0.startForegroundService(intent0);
    }
}

