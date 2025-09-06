package com.iloen.melon.player.playlist.drawernew.model;

import b3.Z;
import com.iloen.melon.MelonAppBase;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001B\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytTab;", "", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public @interface DrawerPlytTab {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001J\u001F\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\t\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\u000B\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u0015\u0010\r\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\u0002¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000E\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u000E\u0010\fR\u0014\u0010\u000F\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytTab$Companion;", "", "", "tab", "", "isMix", "getMenuIdsInDetail", "(Ljava/lang/String;Z)Ljava/lang/String;", "isDetail", "getActionName", "alyacKey", "getPvDummyLogActionFromAlyacKey", "(Ljava/lang/String;)Ljava/lang/String;", "getAlyacName", "getServerTabName", "MADE_BY_ME", "Ljava/lang/String;", "RECENT", "LIKE", "DJ", "NONE", "DEFAULT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        @NotNull
        public static final String DEFAULT = "MADE_BY_ME";
        @NotNull
        public static final String DJ = "DJ";
        @NotNull
        public static final String LIKE = "LIKE";
        @NotNull
        public static final String MADE_BY_ME = "MADE_BY_ME";
        @NotNull
        public static final String NONE = "";
        @NotNull
        public static final String RECENT = "RECENT";
        public static final Companion a;

        static {
            Companion.a = new Companion();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @NotNull
        public final String getActionName(@NotNull String s, boolean z) {
            q.g(s, "tab");
            switch(s) {
                case "LIKE": {
                    return z ? "connStorageLikePlylstDtl" : "connStorageLikeList";
                }
                case "MADE_BY_ME": {
                    return z ? "connStorageImadePlylstDtl" : "mymusicPlaylistPlayList";
                }
                case "RECENT": {
                    return z ? "connStorageRecentPlylstDtl" : "connStorageRecentList";
                }
                default: {
                    return z ? "connStorageDjPlylstDtl" : "playlistDjplaylist";
                }
            }
        }

        @NotNull
        public final String getAlyacName(@NotNull String s) {
            q.g(s, "alyacKey");
            switch(s) {
                case "LIKE": {
                    return Z.m(MelonAppBase.Companion, 0x7F130A20, "getString(...)");  // string:smart_playlist_filter_tag_like "좋아요"
                }
                case "MADE_BY_ME": {
                    return Z.m(MelonAppBase.Companion, 0x7F130A21, "getString(...)");  // string:smart_playlist_filter_tag_madebyme "내가만든"
                }
                case "RECENT": {
                    return Z.m(MelonAppBase.Companion, 0x7F130A22, "getString(...)");  // string:smart_playlist_filter_tag_recent "최근들은"
                }
                default: {
                    return Z.m(MelonAppBase.Companion, 0x7F130A1F, "getString(...)");  // string:smart_playlist_filter_tag_dj "DJ"
                }
            }
        }

        @NotNull
        public final String getMenuIdsInDetail(@NotNull String s, boolean z) {
            q.g(s, "tab");
            switch(s) {
                case "DJ": {
                    return "1000003097";
                }
                case "LIKE": {
                    return z ? "1000003094" : "1000003095";
                }
                case "MADE_BY_ME": {
                    return "1000003096";
                }
                case "RECENT": {
                    return z ? "1000003092" : "1000003093";
                }
                default: {
                    return "9999999999";
                }
            }
        }

        public static String getMenuIdsInDetail$default(Companion drawerPlytTab$Companion0, String s, boolean z, int v, Object object0) {
            if((v & 2) != 0) {
                z = false;
            }
            return drawerPlytTab$Companion0.getMenuIdsInDetail(s, z);
        }

        @NotNull
        public final String getPvDummyLogActionFromAlyacKey(@NotNull String s) {
            q.g(s, "alyacKey");
            switch(s.hashCode()) {
                case 0x8FD93A5B: {
                    return s.equals("RECENT") ? "connStorageRecentList" : "mymusicPlaylistPlayList";
                }
                case 0x9F3D6ED6: {
                    return "mymusicPlaylistPlayList";
                }
                case 0x886: {
                    return s.equals("DJ") ? "playlistDjplaylist" : "mymusicPlaylistPlayList";
                }
                case 0x23A797: {
                    return s.equals("LIKE") ? "connStorageLikeList" : "mymusicPlaylistPlayList";
                }
                default: {
                    return "mymusicPlaylistPlayList";
                }
            }
        }

        @NotNull
        public final String getServerTabName(@NotNull String s) {
            q.g(s, "tab");
            switch(s) {
                case "DJ": {
                    return "DJ";
                }
                case "LIKE": {
                    return "LIKE";
                }
                case "MADE_BY_ME": {
                    return "CREATED";
                }
                case "RECENT": {
                    return "RECENT";
                }
                default: {
                    return "";
                }
            }
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String DEFAULT = "MADE_BY_ME";
    @NotNull
    public static final String DJ = "DJ";
    @NotNull
    public static final String LIKE = "LIKE";
    @NotNull
    public static final String MADE_BY_ME = "MADE_BY_ME";
    @NotNull
    public static final String NONE = "";
    @NotNull
    public static final String RECENT = "RECENT";

    static {
        DrawerPlytTab.Companion = Companion.a;
    }
}

