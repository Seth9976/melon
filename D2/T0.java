package D2;

import android.widget.RemoteViews;
import org.jetbrains.annotations.NotNull;

public final class t0 {
    public static final t0 a;

    static {
        t0.a = new t0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @NotNull
    public final RemoteViews a(@NotNull String s, int v, int v1) {
        return new RemoteViews(s, v, v1);
    }
}

