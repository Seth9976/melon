package com.iloen.melon.playback;

import android.content.Context;
import com.google.android.exoplayer2.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u000E\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003\u001A\u0010\u0010\u0004\u001A\u00020\u00012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u001A\u0010\u0010\u0007\u001A\u00020\u00012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¨\u0006\b"}, d2 = {"getExoPlayerUserAgent", "", "context", "Landroid/content/Context;", "getTitleMetadata", "playable", "Lcom/iloen/melon/playback/Playable;", "getArtistMetadata", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class PlayerUtil {
    // 去混淆评级： 中等(80)
    @NotNull
    public static final String getArtistMetadata(@Nullable Playable playable0) {
        return "";
    }

    @NotNull
    public static final String getExoPlayerUserAgent(@NotNull Context context0) {
        q.g(context0, "context");
        String s = Util.getUserAgent(context0, "MelOn");
        q.f(s, "getUserAgent(...)");
        return s;
    }

    // 去混淆评级： 低(22)
    @NotNull
    public static final String getTitleMetadata(@Nullable Playable playable0) {
        if(playable0 == null) {
            return "";
        }
        if(playable0.isTypeOfMv()) {
            q.d("");
            return "";
        }
        if(playable0.isTypeOfLive()) {
            q.d("");
            return "";
        }
        return "";
    }
}

