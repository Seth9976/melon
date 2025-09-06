package com.iloen.melon.playback.playlist.add;

import U4.x;
import com.iloen.melon.net.v5x.response.CastDetailRes.RESPONSE;
import com.iloen.melon.playback.playlist.PlaylistId;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000B\u0010\u0014\u001A\u0004\u0018\u00010\u0006HÆ\u0003J\u000B\u0010\u0015\u001A\u0004\u0018\u00010\bHÆ\u0003J1\u0010\u0016\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u001AHÖ\u0003J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001J\t\u0010\u001D\u001A\u00020\bHÖ\u0001R \u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0013\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/StationAddRequestPlayableListInfo;", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "userRequestedPlaylist", "", "Lcom/iloen/melon/playback/Playable;", "response", "Lcom/iloen/melon/net/v5x/response/CastDetailRes$RESPONSE;", "startingContsId", "", "<init>", "(Ljava/util/List;Lcom/iloen/melon/net/v5x/response/CastDetailRes$RESPONSE;Ljava/lang/String;)V", "getUserRequestedPlaylist", "()Ljava/util/List;", "setUserRequestedPlaylist", "(Ljava/util/List;)V", "getResponse", "()Lcom/iloen/melon/net/v5x/response/CastDetailRes$RESPONSE;", "getStartingContsId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class StationAddRequestPlayableListInfo implements AddRequestPlayableListInfo {
    public static final int $stable = 8;
    @Nullable
    private final RESPONSE response;
    @Nullable
    private final String startingContsId;
    @NotNull
    private List userRequestedPlaylist;

    public StationAddRequestPlayableListInfo(@NotNull List list0, @Nullable RESPONSE castDetailRes$RESPONSE0, @Nullable String s) {
        q.g(list0, "userRequestedPlaylist");
        super();
        this.userRequestedPlaylist = list0;
        this.response = castDetailRes$RESPONSE0;
        this.startingContsId = s;
    }

    public StationAddRequestPlayableListInfo(List list0, RESPONSE castDetailRes$RESPONSE0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            s = null;
        }
        this(list0, castDetailRes$RESPONSE0, s);
    }

    @NotNull
    public final List component1() {
        return this.userRequestedPlaylist;
    }

    @Nullable
    public final RESPONSE component2() {
        return this.response;
    }

    @Nullable
    public final String component3() {
        return this.startingContsId;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    public void convertCanAddPlayableListInfo(@NotNull PlaylistId playlistId0) {
        AddRequestPlayableListInfo.super.convertCanAddPlayableListInfo(playlistId0);
    }

    @NotNull
    public final StationAddRequestPlayableListInfo copy(@NotNull List list0, @Nullable RESPONSE castDetailRes$RESPONSE0, @Nullable String s) {
        q.g(list0, "userRequestedPlaylist");
        return new StationAddRequestPlayableListInfo(list0, castDetailRes$RESPONSE0, s);
    }

    public static StationAddRequestPlayableListInfo copy$default(StationAddRequestPlayableListInfo stationAddRequestPlayableListInfo0, List list0, RESPONSE castDetailRes$RESPONSE0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            list0 = stationAddRequestPlayableListInfo0.userRequestedPlaylist;
        }
        if((v & 2) != 0) {
            castDetailRes$RESPONSE0 = stationAddRequestPlayableListInfo0.response;
        }
        if((v & 4) != 0) {
            s = stationAddRequestPlayableListInfo0.startingContsId;
        }
        return stationAddRequestPlayableListInfo0.copy(list0, castDetailRes$RESPONSE0, s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof StationAddRequestPlayableListInfo)) {
            return false;
        }
        if(!q.b(this.userRequestedPlaylist, ((StationAddRequestPlayableListInfo)object0).userRequestedPlaylist)) {
            return false;
        }
        return q.b(this.response, ((StationAddRequestPlayableListInfo)object0).response) ? q.b(this.startingContsId, ((StationAddRequestPlayableListInfo)object0).startingContsId) : false;
    }

    @Nullable
    public final RESPONSE getResponse() {
        return this.response;
    }

    @Nullable
    public final String getStartingContsId() {
        return this.startingContsId;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    @NotNull
    public List getUserRequestedPlaylist() {
        return this.userRequestedPlaylist;
    }

    @Override
    public int hashCode() {
        int v = this.userRequestedPlaylist.hashCode();
        int v1 = 0;
        int v2 = this.response == null ? 0 : this.response.hashCode();
        String s = this.startingContsId;
        if(s != null) {
            v1 = s.hashCode();
        }
        return (v * 0x1F + v2) * 0x1F + v1;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    public void setUserRequestedPlaylist(@NotNull List list0) {
        q.g(list0, "<set-?>");
        this.userRequestedPlaylist = list0;
    }

    @Override
    @NotNull
    public String toString() {
        List list0 = this.userRequestedPlaylist;
        StringBuilder stringBuilder0 = new StringBuilder("StationAddRequestPlayableListInfo(userRequestedPlaylist=");
        stringBuilder0.append(list0);
        stringBuilder0.append(", response=");
        stringBuilder0.append(this.response);
        stringBuilder0.append(", startingContsId=");
        return x.m(stringBuilder0, this.startingContsId, ")");
    }
}

