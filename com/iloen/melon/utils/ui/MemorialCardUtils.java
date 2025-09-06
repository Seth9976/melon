package com.iloen.melon.utils.ui;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/utils/ui/MemorialCardUtils;", "", "<init>", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MemorialCardUtils {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000E\b\u0086\u0003\u0018\u00002\u00020\u0001J\u001F\u0010\u0006\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000B\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000B\u0010\tR\u0014\u0010\f\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000E\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000E\u0010\tR\u0014\u0010\u000F\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000F\u0010\tR\u0014\u0010\u0010\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/utils/ui/MemorialCardUtils$Companion;", "", "Landroid/content/Context;", "context", "", "type", "getMemorialTitle", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "TYPE_FAN_DAY", "Ljava/lang/String;", "TYPE_TEMPERATURE_TOP", "TYPE_LAST_SONG", "TYPE_FIRST_SONG", "TYPE_FIRST_LIKE_SONG", "TYPE_MAX_MONTH", "TYPE_HOT_DAY", "TYPE_DEBUT_DAY", "TYPE_BIRTH_DAY", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final String getMemorialTitle(@Nullable Context context0, @NotNull String s) {
            int v;
            q.g(s, "type");
            switch(s) {
                case "BIRTH_DAY": {
                    v = 0x7F130155;  // string:artist_memorial_birth_day "아티스트 생일"
                    break;
                }
                case "DEBUT_DAY": {
                    v = 0x7F130159;  // string:artist_memorial_debut_day "데뷔한 날"
                    break;
                }
                case "FAN_DAY": {
                    v = 0x7F13015A;  // string:artist_memorial_fan_day "팬이 된 날"
                    break;
                }
                case "FIRST_LIKE_SONG": {
                    v = 0x7F13015C;  // string:artist_memorial_first_like_song "처음 좋아요한 곡"
                    break;
                }
                case "FIRST_SONG": {
                    v = 0x7F13015D;  // string:artist_memorial_first_song "처음 들은 곡"
                    break;
                }
                case "HOT_DAY": {
                    v = 0x7F130161;  // string:artist_memorial_hot_day "가장 뜨거웠던 날"
                    break;
                }
                case "LAST_SONG": {
                    v = 0x7F130163;  // string:artist_memorial_last_song "마지막으로 들은 곡"
                    break;
                }
                case "MAX_MONTH": {
                    v = 0x7F130165;  // string:artist_memorial_max_month "가장 많이 들은 달"
                    break;
                }
                case "TEMPERATURE_TOP": {
                    v = 0x7F13016B;  // string:artist_memorial_temperature_top "친밀도 상위 1%"
                    break;
                }
                default: {
                    return "";
                }
            }
            if(context0 != null) {
                String s1 = context0.getString(v);
                return s1 == null ? "" : s1;
            }
            return "";
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TYPE_BIRTH_DAY = "BIRTH_DAY";
    @NotNull
    public static final String TYPE_DEBUT_DAY = "DEBUT_DAY";
    @NotNull
    public static final String TYPE_FAN_DAY = "FAN_DAY";
    @NotNull
    public static final String TYPE_FIRST_LIKE_SONG = "FIRST_LIKE_SONG";
    @NotNull
    public static final String TYPE_FIRST_SONG = "FIRST_SONG";
    @NotNull
    public static final String TYPE_HOT_DAY = "HOT_DAY";
    @NotNull
    public static final String TYPE_LAST_SONG = "LAST_SONG";
    @NotNull
    public static final String TYPE_MAX_MONTH = "MAX_MONTH";
    @NotNull
    public static final String TYPE_TEMPERATURE_TOP = "TEMPERATURE_TOP";

    static {
        MemorialCardUtils.Companion = new Companion(null);
    }
}

