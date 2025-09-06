package com.kakaoent.leonplayer.core.model.data.configuration;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\u001AT\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u00032\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\u0014\b\u0002\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000B¨\u0006\f"}, d2 = {"copy", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonPlayerItem;", "id", "", "url", "startTime", "", "posterImage", "drmInfo", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonDrmInfo;", "header", "", "leonplayer_release"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class LeonPlayerItemKt {
    @NotNull
    public static final LeonPlayerItem copy(@NotNull LeonPlayerItem leonPlayerItem0, @NotNull String s, @NotNull String s1, int v, @NotNull String s2, @Nullable LeonDrmInfo leonDrmInfo0, @NotNull Map map0) {
        q.g(leonPlayerItem0, "<this>");
        q.g(s, "id");
        q.g(s1, "url");
        q.g(s2, "posterImage");
        q.g(map0, "header");
        return LeonPlayerItem.Companion.of(s, s1, v, s2, leonDrmInfo0, map0);
    }

    public static LeonPlayerItem copy$default(LeonPlayerItem leonPlayerItem0, String s, String s1, int v, String s2, LeonDrmInfo leonDrmInfo0, Map map0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = leonPlayerItem0.getId();
        }
        if((v1 & 2) != 0) {
            s1 = leonPlayerItem0.getUrl();
        }
        if((v1 & 4) != 0) {
            v = leonPlayerItem0.getStartTime();
        }
        if((v1 & 8) != 0) {
            s2 = leonPlayerItem0.getPosterImage();
        }
        if((v1 & 16) != 0) {
            leonDrmInfo0 = leonPlayerItem0.getDrmInfo();
        }
        if((v1 & 0x20) != 0) {
            map0 = leonPlayerItem0.getHeader();
        }
        return LeonPlayerItemKt.copy(leonPlayerItem0, s, s1, v, s2, leonDrmInfo0, map0);
    }
}

