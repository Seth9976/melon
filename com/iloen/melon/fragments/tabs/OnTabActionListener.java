package com.iloen.melon.fragments.tabs;

import com.iloen.melon.fragments.main.common.ViewableCheckViewHolder.OnStateChangeListener;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.kakao.tiara.data.ViewImpContent;
import com.melon.net.res.common.SongInfoBase;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pc.w1;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000F\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J-\u0010\t\u001A\u00020\b2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u0006H&\u00A2\u0006\u0004\b\t\u0010\nJ#\u0010\r\u001A\u00020\b2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&\u00A2\u0006\u0004\b\r\u0010\u000EJ#\u0010\u0010\u001A\u00020\b2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&\u00A2\u0006\u0004\b\u0010\u0010\u000EJ-\u0010\u0013\u001A\u00020\b2\b\u0010\u0011\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0012\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&\u00A2\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0017\u001A\u00020\b2\b\u0010\u0015\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0016\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&\u00A2\u0006\u0004\b\u0017\u0010\u0014J7\u0010\u0017\u001A\u00020\b2\b\u0010\u0015\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0018\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0019\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&\u00A2\u0006\u0004\b\u0017\u0010\u001AJ+\u0010\u001D\u001A\u00020\b2\u0010\u0010\u001C\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u000B\u0018\u00010\u001B2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&\u00A2\u0006\u0004\b\u001D\u0010\u001EJ+\u0010 \u001A\u00020\b2\u0010\u0010\u001F\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u001B2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&\u00A2\u0006\u0004\b \u0010\u001EJ-\u0010#\u001A\u00020\b2\b\u0010!\u001A\u0004\u0018\u00010\u000B2\b\u0010\"\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&\u00A2\u0006\u0004\b#\u0010\u0014J\u001F\u0010\'\u001A\u00020\b2\u0006\u0010$\u001A\u00020\u000B2\u0006\u0010&\u001A\u00020%H&\u00A2\u0006\u0004\b\'\u0010(J\u000F\u0010)\u001A\u00020\u0006H&\u00A2\u0006\u0004\b)\u0010*J\u0017\u0010-\u001A\u00020\b2\u0006\u0010,\u001A\u00020+H&\u00A2\u0006\u0004\b-\u0010.J\u0017\u0010/\u001A\u00020\b2\u0006\u0010,\u001A\u00020+H&\u00A2\u0006\u0004\b/\u0010.J\u000F\u00100\u001A\u00020\u0006H&\u00A2\u0006\u0004\b0\u0010*J\u0019\u00102\u001A\u00020\b2\b\b\u0002\u00101\u001A\u00020\u0006H&\u00A2\u0006\u0004\b2\u00103J-\u00104\u001A\u00020\b2\b\u0010\u0016\u001A\u0004\u0018\u00010\u000B2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u0006H&\u00A2\u0006\u0004\b4\u00105J\u0019\u00106\u001A\u00020\b2\b\u0010!\u001A\u0004\u0018\u00010\u000BH&\u00A2\u0006\u0004\b6\u00107J\u0017\u00109\u001A\u00020\b2\u0006\u00108\u001A\u00020\u000BH&\u00A2\u0006\u0004\b9\u00107J!\u0010<\u001A\u00020\b2\u0006\u0010;\u001A\u00020:2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&\u00A2\u0006\u0004\b<\u0010=\u00A8\u0006>\u00C0\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/tabs/OnTabActionListener;", "", "Lcom/melon/net/res/common/SongInfoBase;", "songInfoBase", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElementsBase", "", "isGenreExcluded", "Lie/H;", "onPlaySongListener", "(Lcom/melon/net/res/common/SongInfoBase;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;Z)V", "", "albumId", "onPlayAlbumListener", "(Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "mvId", "onPlayMvListener", "seq", "contsTypeCode", "onPlayPlaylistListener", "(Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "contsId", "songIds", "onPlayForUSongListener", "seedContsId", "seedContsTypeCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "", "songIdList", "onPlayWithSongIdList", "(Ljava/util/List;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "songList", "onPlayShuffleWithSongList", "castSeq", "menuId", "onPlayRadioCast", "key", "Lcom/kakao/tiara/data/ViewImpContent;", "viewImpContent", "onImpLogListener", "(Ljava/lang/String;Lcom/kakao/tiara/data/ViewImpContent;)V", "onShowNetworkCheckOrSettingPopupIfNeed", "()Z", "Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;", "listener", "addOnStateChangeListener", "(Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;)V", "removeOnStateChangeListener", "isForegroundFragment", "removeSlot", "onTopNotificationClose", "(Z)V", "onPlayWithSongIds", "(Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;Z)V", "onOpenCastEpisodeDetailView", "(Ljava/lang/String;)V", "argMenuSeq", "onStartProgramSelectActivity", "Lpc/w1;", "mixUpType", "onPlayMixUp", "(Lpc/w1;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface OnTabActionListener {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class DefaultImpls {
        public static void onPlaySongListener$default(OnTabActionListener onTabActionListener0, SongInfoBase songInfoBase0, StatsElementsBase statsElementsBase0, boolean z, int v, Object object0) {
            OnTabActionListener.onPlaySongListener$default(onTabActionListener0, songInfoBase0, statsElementsBase0, z, v, object0);
        }

        public static void onPlayWithSongIds$default(OnTabActionListener onTabActionListener0, String s, StatsElementsBase statsElementsBase0, boolean z, int v, Object object0) {
            OnTabActionListener.onPlayWithSongIds$default(onTabActionListener0, s, statsElementsBase0, z, v, object0);
        }

        public static void onTopNotificationClose$default(OnTabActionListener onTabActionListener0, boolean z, int v, Object object0) {
            OnTabActionListener.onTopNotificationClose$default(onTabActionListener0, z, v, object0);
        }
    }

    void addOnStateChangeListener(@NotNull OnStateChangeListener arg1);

    boolean isForegroundFragment();

    void onImpLogListener(@NotNull String arg1, @NotNull ViewImpContent arg2);

    void onOpenCastEpisodeDetailView(@Nullable String arg1);

    void onPlayAlbumListener(@Nullable String arg1, @Nullable StatsElementsBase arg2);

    void onPlayForUSongListener(@Nullable String arg1, @Nullable String arg2, @Nullable StatsElementsBase arg3);

    void onPlayForUSongListener(@Nullable String arg1, @Nullable String arg2, @Nullable String arg3, @Nullable StatsElementsBase arg4);

    void onPlayMixUp(@NotNull w1 arg1, @Nullable StatsElementsBase arg2);

    void onPlayMvListener(@Nullable String arg1, @Nullable StatsElementsBase arg2);

    void onPlayPlaylistListener(@Nullable String arg1, @Nullable String arg2, @Nullable StatsElementsBase arg3);

    void onPlayRadioCast(@Nullable String arg1, @Nullable String arg2, @Nullable StatsElementsBase arg3);

    void onPlayShuffleWithSongList(@Nullable List arg1, @Nullable StatsElementsBase arg2);

    void onPlaySongListener(@Nullable SongInfoBase arg1, @Nullable StatsElementsBase arg2, boolean arg3);

    static void onPlaySongListener$default(OnTabActionListener onTabActionListener0, SongInfoBase songInfoBase0, StatsElementsBase statsElementsBase0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPlaySongListener");
        }
        if((v & 4) != 0) {
            z = false;
        }
        onTabActionListener0.onPlaySongListener(songInfoBase0, statsElementsBase0, z);
    }

    void onPlayWithSongIdList(@Nullable List arg1, @Nullable StatsElementsBase arg2);

    void onPlayWithSongIds(@Nullable String arg1, @Nullable StatsElementsBase arg2, boolean arg3);

    static void onPlayWithSongIds$default(OnTabActionListener onTabActionListener0, String s, StatsElementsBase statsElementsBase0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPlayWithSongIds");
        }
        if((v & 4) != 0) {
            z = false;
        }
        onTabActionListener0.onPlayWithSongIds(s, statsElementsBase0, z);
    }

    boolean onShowNetworkCheckOrSettingPopupIfNeed();

    void onStartProgramSelectActivity(@NotNull String arg1);

    void onTopNotificationClose(boolean arg1);

    static void onTopNotificationClose$default(OnTabActionListener onTabActionListener0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTopNotificationClose");
        }
        if((v & 1) != 0) {
            z = false;
        }
        onTabActionListener0.onTopNotificationClose(z);
    }

    void removeOnStateChangeListener(@NotNull OnStateChangeListener arg1);
}

