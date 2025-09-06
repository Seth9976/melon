package com.iloen.melon.playback.playlist.add;

import com.iloen.melon.net.v6x.response.LiveDetailRes;
import com.iloen.melon.playback.playlist.PlaylistId;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001D\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0006HÆ\u0003J#\u0010\u0011\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001R \u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/LiveAddRequestPlayableListInfo;", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "userRequestedPlaylist", "", "Lcom/iloen/melon/playback/Playable;", "detailRes", "Lcom/iloen/melon/net/v6x/response/LiveDetailRes;", "<init>", "(Ljava/util/List;Lcom/iloen/melon/net/v6x/response/LiveDetailRes;)V", "getUserRequestedPlaylist", "()Ljava/util/List;", "setUserRequestedPlaylist", "(Ljava/util/List;)V", "getDetailRes", "()Lcom/iloen/melon/net/v6x/response/LiveDetailRes;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LiveAddRequestPlayableListInfo implements AddRequestPlayableListInfo {
    public static final int $stable = 8;
    @NotNull
    private final LiveDetailRes detailRes;
    @NotNull
    private List userRequestedPlaylist;

    public LiveAddRequestPlayableListInfo(@NotNull List list0, @NotNull LiveDetailRes liveDetailRes0) {
        q.g(list0, "userRequestedPlaylist");
        q.g(liveDetailRes0, "detailRes");
        super();
        this.userRequestedPlaylist = list0;
        this.detailRes = liveDetailRes0;
    }

    @NotNull
    public final List component1() {
        return this.userRequestedPlaylist;
    }

    @NotNull
    public final LiveDetailRes component2() {
        return this.detailRes;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    public void convertCanAddPlayableListInfo(@NotNull PlaylistId playlistId0) {
        AddRequestPlayableListInfo.super.convertCanAddPlayableListInfo(playlistId0);
    }

    @NotNull
    public final LiveAddRequestPlayableListInfo copy(@NotNull List list0, @NotNull LiveDetailRes liveDetailRes0) {
        q.g(list0, "userRequestedPlaylist");
        q.g(liveDetailRes0, "detailRes");
        return new LiveAddRequestPlayableListInfo(list0, liveDetailRes0);
    }

    public static LiveAddRequestPlayableListInfo copy$default(LiveAddRequestPlayableListInfo liveAddRequestPlayableListInfo0, List list0, LiveDetailRes liveDetailRes0, int v, Object object0) {
        if((v & 1) != 0) {
            list0 = liveAddRequestPlayableListInfo0.userRequestedPlaylist;
        }
        if((v & 2) != 0) {
            liveDetailRes0 = liveAddRequestPlayableListInfo0.detailRes;
        }
        return liveAddRequestPlayableListInfo0.copy(list0, liveDetailRes0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof LiveAddRequestPlayableListInfo)) {
            return false;
        }
        return q.b(this.userRequestedPlaylist, ((LiveAddRequestPlayableListInfo)object0).userRequestedPlaylist) ? q.b(this.detailRes, ((LiveAddRequestPlayableListInfo)object0).detailRes) : false;
    }

    @NotNull
    public final LiveDetailRes getDetailRes() {
        return this.detailRes;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    @NotNull
    public List getUserRequestedPlaylist() {
        return this.userRequestedPlaylist;
    }

    @Override
    public int hashCode() {
        return this.detailRes.hashCode() + this.userRequestedPlaylist.hashCode() * 0x1F;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    public void setUserRequestedPlaylist(@NotNull List list0) {
        q.g(list0, "<set-?>");
        this.userRequestedPlaylist = list0;
    }

    @Override
    @NotNull
    public String toString() {
        return "LiveAddRequestPlayableListInfo(userRequestedPlaylist=" + this.userRequestedPlaylist + ", detailRes=" + this.detailRes + ")";
    }
}

