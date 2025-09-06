package com.melon.net.res;

import com.melon.net.res.common.SongInfoBase;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/melon/net/res/MusicSearchHistorySongInfo;", "Lcom/melon/net/res/common/SongInfoBase;", "<init>", "()V", "timestamp", "", "getTimestamp", "()Ljava/lang/String;", "setTimestamp", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicSearchHistorySongInfo extends SongInfoBase {
    public static final int $stable = 8;
    @NotNull
    private String timestamp;

    public MusicSearchHistorySongInfo() {
        this.timestamp = "";
    }

    @NotNull
    public final String getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(@NotNull String s) {
        q.g(s, "<set-?>");
        this.timestamp = s;
    }
}

