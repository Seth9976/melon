package com.iloen.melon.playback.playlist.add;

import com.iloen.melon.playback.playlist.PlaylistId;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000B\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FHÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R \u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/CommonAddRequestPlayableListInfo;", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "userRequestedPlaylist", "", "Lcom/iloen/melon/playback/Playable;", "<init>", "(Ljava/util/List;)V", "getUserRequestedPlaylist", "()Ljava/util/List;", "setUserRequestedPlaylist", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CommonAddRequestPlayableListInfo implements AddRequestPlayableListInfo {
    public static final int $stable = 8;
    @NotNull
    private List userRequestedPlaylist;

    public CommonAddRequestPlayableListInfo(@NotNull List list0) {
        q.g(list0, "userRequestedPlaylist");
        super();
        this.userRequestedPlaylist = list0;
    }

    @NotNull
    public final List component1() {
        return this.userRequestedPlaylist;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    public void convertCanAddPlayableListInfo(@NotNull PlaylistId playlistId0) {
        AddRequestPlayableListInfo.super.convertCanAddPlayableListInfo(playlistId0);
    }

    @NotNull
    public final CommonAddRequestPlayableListInfo copy(@NotNull List list0) {
        q.g(list0, "userRequestedPlaylist");
        return new CommonAddRequestPlayableListInfo(list0);
    }

    public static CommonAddRequestPlayableListInfo copy$default(CommonAddRequestPlayableListInfo commonAddRequestPlayableListInfo0, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            list0 = commonAddRequestPlayableListInfo0.userRequestedPlaylist;
        }
        return commonAddRequestPlayableListInfo0.copy(list0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof CommonAddRequestPlayableListInfo ? q.b(this.userRequestedPlaylist, ((CommonAddRequestPlayableListInfo)object0).userRequestedPlaylist) : false;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    @NotNull
    public List getUserRequestedPlaylist() {
        return this.userRequestedPlaylist;
    }

    @Override
    public int hashCode() {
        return this.userRequestedPlaylist.hashCode();
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    public void setUserRequestedPlaylist(@NotNull List list0) {
        q.g(list0, "<set-?>");
        this.userRequestedPlaylist = list0;
    }

    @Override
    @NotNull
    public String toString() {
        return "CommonAddRequestPlayableListInfo(userRequestedPlaylist=" + this.userRequestedPlaylist + ")";
    }
}

