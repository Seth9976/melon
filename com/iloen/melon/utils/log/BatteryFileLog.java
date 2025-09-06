package com.iloen.melon.utils.log;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/utils/log/BatteryFileLog;", "Lcom/iloen/melon/utils/log/FileLog;", "", "in", "Lie/H;", "write", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BatteryFileLog extends FileLog {
    public static final int $stable;
    @NotNull
    public static final BatteryFileLog INSTANCE;

    static {
        BatteryFileLog.INSTANCE = new BatteryFileLog("battery", "battery_log", ".txt", true, 5);  // 初始化器: Lcom/iloen/melon/utils/log/FileLog;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZI)V
        BatteryFileLog.$stable = 8;
    }

    public final void write(@Nullable String s) {
        this.write("", s);
    }
}

