package com.iloen.melon.playback.playlist.add;

import com.iloen.melon.playback.playlist.PlaylistId;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EHÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001R \u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/EmptyAddRequestPlayableListInfo;", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "<init>", "()V", "userRequestedPlaylist", "", "Lcom/iloen/melon/playback/Playable;", "getUserRequestedPlaylist", "()Ljava/util/List;", "setUserRequestedPlaylist", "(Ljava/util/List;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EmptyAddRequestPlayableListInfo implements AddRequestPlayableListInfo {
    public static final int $stable;
    @NotNull
    public static final EmptyAddRequestPlayableListInfo INSTANCE;
    @NotNull
    private static List userRequestedPlaylist;

    static {
        EmptyAddRequestPlayableListInfo.INSTANCE = new EmptyAddRequestPlayableListInfo();
        EmptyAddRequestPlayableListInfo.userRequestedPlaylist = w.a;
        EmptyAddRequestPlayableListInfo.$stable = 8;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    public void convertCanAddPlayableListInfo(@NotNull PlaylistId playlistId0) {
        AddRequestPlayableListInfo.super.convertCanAddPlayableListInfo(playlistId0);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 ? true : object0 instanceof EmptyAddRequestPlayableListInfo;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    @NotNull
    public List getUserRequestedPlaylist() {
        return EmptyAddRequestPlayableListInfo.userRequestedPlaylist;
    }

    @Override
    public int hashCode() {
        return 909285182;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    public void setUserRequestedPlaylist(@NotNull List list0) {
        q.g(list0, "<set-?>");
        EmptyAddRequestPlayableListInfo.userRequestedPlaylist = list0;
    }

    @Override
    @NotNull
    public String toString() {
        return "EmptyAddRequestPlayableListInfo";
    }
}

