package com.iloen.melon.utils.player;

import com.kakaoent.leonplayer.core.model.data.json.Media;
import com.kakaoent.leonplayer.core.model.data.json.PlayerItem;
import java.util.Map;
import je.C;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000B\u001A\u00020\u00022\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/utils/player/LeonPlayerHelper;", "", "", "jsonString", "", "isAvailableLiveItem", "(Ljava/lang/String;)Z", "findChromecastPath", "(Ljava/lang/String;)Ljava/lang/String;", "", "mapObject", "parseToString", "(Ljava/util/Map;)Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LeonPlayerHelper {
    public static final int $stable;
    @NotNull
    public static final LeonPlayerHelper INSTANCE;

    static {
        LeonPlayerHelper.INSTANCE = new LeonPlayerHelper();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @NotNull
    public static final String findChromecastPath(@NotNull String s) {
        q.g(s, "jsonString");
        if(!LeonPlayerHelper.isAvailableLiveItem(s)) {
            return "";
        }
        PlayerItem playerItem0 = LeonPlayerHelperKt.access$toPlayerItem(s);
        if(playerItem0 == null) {
            return "";
        }
        Media media0 = LeonPlayerHelperKt.access$findChromecastMedia(playerItem0);
        if(media0 != null) {
            String s1 = media0.getUrl();
            return s1 == null ? "" : s1;
        }
        return "";
    }

    public static final boolean isAvailableLiveItem(@NotNull String s) {
        q.g(s, "jsonString");
        try {
            if(LeonPlayerHelperKt.access$toPlayerItem(s) != null) {
                return true;
            }
        }
        catch(Exception unused_ex) {
        }
        return false;
    }

    @NotNull
    public static final String parseToString(@NotNull Map map0) {
        q.g(map0, "mapObject");
        try {
            String s = new JSONObject(C.Z(map0)).toString();
            q.d(s);
            return s;
        }
        catch(Exception unused_ex) {
            return "";
        }
    }
}

