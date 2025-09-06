package com.iloen.melon.utils;

import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\n\u001A\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/utils/MutexLockUtil;", "", "", "TAG", "Ljava/lang/String;", "Lcom/iloen/melon/utils/log/LogU;", "a", "Lcom/iloen/melon/utils/log/LogU;", "getLog", "()Lcom/iloen/melon/utils/log/LogU;", "log", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MutexLockUtil {
    public static final int $stable = 0;
    @NotNull
    public static final MutexLockUtil INSTANCE = null;
    @NotNull
    public static final String TAG = "MutexLockUtil";
    public static final LogU a;

    static {
        MutexLockUtil.INSTANCE = new MutexLockUtil();  // 初始化器: Ljava/lang/Object;-><init>()V
        MutexLockUtil.a = LogU.Companion.create("MutexLockUtil", true, Category.Playback);
        MutexLockUtil.$stable = 8;
    }

    @NotNull
    public final LogU getLog() {
        return MutexLockUtil.a;
    }
}

