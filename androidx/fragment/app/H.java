package androidx.fragment.app;

import android.animation.AnimatorSet;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

public final class h {
    public static final h a;

    static {
        h.a = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final long a(@NotNull AnimatorSet animatorSet0) {
        q.g(animatorSet0, "animatorSet");
        return animatorSet0.getTotalDuration();
    }
}

