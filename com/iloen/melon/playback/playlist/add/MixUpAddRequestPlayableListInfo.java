package com.iloen.melon.playback.playlist.add;

import A7.d;
import com.iloen.melon.playback.playlist.PlaylistId;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000F\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001A\u00020\tHÆ\u0003J=\u0010\u0019\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\tHÆ\u0001J\u0013\u0010\u001A\u001A\u00020\t2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001CHÖ\u0003J\t\u0010\u001D\u001A\u00020\u001EHÖ\u0001J\t\u0010\u001F\u001A\u00020 HÖ\u0001R \u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/MixUpAddRequestPlayableListInfo;", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "userRequestedPlaylist", "", "Lcom/iloen/melon/playback/Playable;", "recommendPlayableLists", "mixUpRequestInfo", "Lcom/iloen/melon/playback/playlist/add/MixUpRequestInfo;", "mixUpSeedOverMaxSize", "", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/iloen/melon/playback/playlist/add/MixUpRequestInfo;Z)V", "getUserRequestedPlaylist", "()Ljava/util/List;", "setUserRequestedPlaylist", "(Ljava/util/List;)V", "getRecommendPlayableLists", "getMixUpRequestInfo", "()Lcom/iloen/melon/playback/playlist/add/MixUpRequestInfo;", "getMixUpSeedOverMaxSize", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixUpAddRequestPlayableListInfo implements AddRequestPlayableListInfo {
    public static final int $stable = 8;
    @NotNull
    private final MixUpRequestInfo mixUpRequestInfo;
    private final boolean mixUpSeedOverMaxSize;
    @NotNull
    private final List recommendPlayableLists;
    @NotNull
    private List userRequestedPlaylist;

    public MixUpAddRequestPlayableListInfo(@NotNull List list0, @NotNull List list1, @NotNull MixUpRequestInfo mixUpRequestInfo0, boolean z) {
        q.g(list0, "userRequestedPlaylist");
        q.g(list1, "recommendPlayableLists");
        q.g(mixUpRequestInfo0, "mixUpRequestInfo");
        super();
        this.userRequestedPlaylist = list0;
        this.recommendPlayableLists = list1;
        this.mixUpRequestInfo = mixUpRequestInfo0;
        this.mixUpSeedOverMaxSize = z;
    }

    @NotNull
    public final List component1() {
        return this.userRequestedPlaylist;
    }

    @NotNull
    public final List component2() {
        return this.recommendPlayableLists;
    }

    @NotNull
    public final MixUpRequestInfo component3() {
        return this.mixUpRequestInfo;
    }

    public final boolean component4() {
        return this.mixUpSeedOverMaxSize;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    public void convertCanAddPlayableListInfo(@NotNull PlaylistId playlistId0) {
        AddRequestPlayableListInfo.super.convertCanAddPlayableListInfo(playlistId0);
    }

    @NotNull
    public final MixUpAddRequestPlayableListInfo copy(@NotNull List list0, @NotNull List list1, @NotNull MixUpRequestInfo mixUpRequestInfo0, boolean z) {
        q.g(list0, "userRequestedPlaylist");
        q.g(list1, "recommendPlayableLists");
        q.g(mixUpRequestInfo0, "mixUpRequestInfo");
        return new MixUpAddRequestPlayableListInfo(list0, list1, mixUpRequestInfo0, z);
    }

    public static MixUpAddRequestPlayableListInfo copy$default(MixUpAddRequestPlayableListInfo mixUpAddRequestPlayableListInfo0, List list0, List list1, MixUpRequestInfo mixUpRequestInfo0, boolean z, int v, Object object0) {
        if((v & 1) != 0) {
            list0 = mixUpAddRequestPlayableListInfo0.userRequestedPlaylist;
        }
        if((v & 2) != 0) {
            list1 = mixUpAddRequestPlayableListInfo0.recommendPlayableLists;
        }
        if((v & 4) != 0) {
            mixUpRequestInfo0 = mixUpAddRequestPlayableListInfo0.mixUpRequestInfo;
        }
        if((v & 8) != 0) {
            z = mixUpAddRequestPlayableListInfo0.mixUpSeedOverMaxSize;
        }
        return mixUpAddRequestPlayableListInfo0.copy(list0, list1, mixUpRequestInfo0, z);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MixUpAddRequestPlayableListInfo)) {
            return false;
        }
        if(!q.b(this.userRequestedPlaylist, ((MixUpAddRequestPlayableListInfo)object0).userRequestedPlaylist)) {
            return false;
        }
        if(!q.b(this.recommendPlayableLists, ((MixUpAddRequestPlayableListInfo)object0).recommendPlayableLists)) {
            return false;
        }
        return q.b(this.mixUpRequestInfo, ((MixUpAddRequestPlayableListInfo)object0).mixUpRequestInfo) ? this.mixUpSeedOverMaxSize == ((MixUpAddRequestPlayableListInfo)object0).mixUpSeedOverMaxSize : false;
    }

    @NotNull
    public final MixUpRequestInfo getMixUpRequestInfo() {
        return this.mixUpRequestInfo;
    }

    public final boolean getMixUpSeedOverMaxSize() {
        return this.mixUpSeedOverMaxSize;
    }

    @NotNull
    public final List getRecommendPlayableLists() {
        return this.recommendPlayableLists;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    @NotNull
    public List getUserRequestedPlaylist() {
        return this.userRequestedPlaylist;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(this.mixUpSeedOverMaxSize) + (this.mixUpRequestInfo.hashCode() + d.d(this.userRequestedPlaylist.hashCode() * 0x1F, 0x1F, this.recommendPlayableLists)) * 0x1F;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    public void setUserRequestedPlaylist(@NotNull List list0) {
        q.g(list0, "<set-?>");
        this.userRequestedPlaylist = list0;
    }

    @Override
    @NotNull
    public String toString() {
        return "MixUpAddRequestPlayableListInfo(userRequestedPlaylist=" + this.userRequestedPlaylist + ", recommendPlayableLists=" + this.recommendPlayableLists + ", mixUpRequestInfo=" + this.mixUpRequestInfo + ", mixUpSeedOverMaxSize=" + this.mixUpSeedOverMaxSize + ")";
    }
}

