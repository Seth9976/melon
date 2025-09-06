package E2;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import org.jetbrains.annotations.NotNull;

public final class d {
    public static final d a;

    static {
        d.a = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @NotNull
    public final PendingIntent a(@NotNull Context context0, @NotNull Intent intent0) {
        return PendingIntent.getForegroundService(context0, 0, intent0, 0xC000000);
    }
}

