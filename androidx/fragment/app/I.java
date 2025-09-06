package androidx.fragment.app;

import android.animation.AnimatorSet;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

public final class i {
    public static final i a;

    static {
        i.a = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final void a(@NotNull AnimatorSet animatorSet0) {
        q.g(animatorSet0, "animatorSet");
        animatorSet0.reverse();
    }

    public final void b(@NotNull AnimatorSet animatorSet0, long v) {
        q.g(animatorSet0, "animatorSet");
        animatorSet0.setCurrentPlayTime(v);
    }
}

