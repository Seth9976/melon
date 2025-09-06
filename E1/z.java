package e1;

import android.content.Context;
import org.jetbrains.annotations.NotNull;

public final class z {
    public static final z a;

    static {
        z.a = new z();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final int a(@NotNull Context context0) {
        return context0.getResources().getConfiguration().fontWeightAdjustment;
    }
}

