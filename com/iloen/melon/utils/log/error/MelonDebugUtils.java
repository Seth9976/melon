package com.iloen.melon.utils.log.error;

import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001J\u001D\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\u0006\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0006\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/utils/log/error/MelonDebugUtils;", "", "", "tag", "message", "Lie/H;", "errorLogOrException", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/iloen/melon/utils/log/LogU;", "log", "(Lcom/iloen/melon/utils/log/LogU;Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonDebugUtils {
    public static final int $stable;
    @NotNull
    public static final MelonDebugUtils INSTANCE;

    static {
        MelonDebugUtils.INSTANCE = new MelonDebugUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final void errorLogOrException(@NotNull LogU logU0, @NotNull String s) {
        q.g(logU0, "log");
        q.g(s, "message");
        LogU.error$default(logU0, s, null, false, 6, null);
    }

    public final void errorLogOrException(@NotNull String s, @NotNull String s1) {
        q.g(s, "tag");
        q.g(s1, "message");
        LogU.Companion.e(s, s1);
    }
}

