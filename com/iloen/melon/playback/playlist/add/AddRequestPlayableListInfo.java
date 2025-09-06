package com.iloen.melon.playback.playlist.add;

import com.iloen.melon.playback.playlist.PlaylistId;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001A\b\u0012\u0004\u0012\u00020\b0\u00078&@&X¦\u000E¢\u0006\f\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\f\u0082\u0001\u0007\u000E\u000F\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "Lie/H;", "convertCanAddPlayableListInfo", "(Lcom/iloen/melon/playback/playlist/PlaylistId;)V", "", "Lcom/iloen/melon/playback/Playable;", "getUserRequestedPlaylist", "()Ljava/util/List;", "setUserRequestedPlaylist", "(Ljava/util/List;)V", "userRequestedPlaylist", "Lcom/iloen/melon/playback/playlist/add/CommonAddRequestPlayableListInfo;", "Lcom/iloen/melon/playback/playlist/add/DrawerAddRequestPlayableListInfo;", "Lcom/iloen/melon/playback/playlist/add/EmptyAddRequestPlayableListInfo;", "Lcom/iloen/melon/playback/playlist/add/LiveAddRequestPlayableListInfo;", "Lcom/iloen/melon/playback/playlist/add/MixUpAddRequestPlayableListInfo;", "Lcom/iloen/melon/playback/playlist/add/MusicWaveAddRequestPlayableListInfo;", "Lcom/iloen/melon/playback/playlist/add/StationAddRequestPlayableListInfo;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface AddRequestPlayableListInfo {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class DefaultImpls {
        @Deprecated
        public static void convertCanAddPlayableListInfo(@NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull PlaylistId playlistId0) {
            q.g(playlistId0, "playlistId");
            addRequestPlayableListInfo0.super.convertCanAddPlayableListInfo(playlistId0);
        }
    }

    // 去混淆评级： 低(40)
    default void convertCanAddPlayableListInfo(@NotNull PlaylistId playlistId0) {
        q.g(playlistId0, "playlistId");
    }

    @NotNull
    List getUserRequestedPlaylist();

    void setUserRequestedPlaylist(@NotNull List arg1);
}

