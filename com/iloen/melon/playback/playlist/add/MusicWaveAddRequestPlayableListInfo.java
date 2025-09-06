package com.iloen.melon.playback.playlist.add;

import A7.d;
import U4.x;
import com.iloen.melon.net.v6x.response.MusicWavePlayInfoRes.RESPONSE.LOG;
import com.iloen.melon.net.v6x.response.MusicWavePlayInfoRes.RESPONSE.NEXTSONG;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.musicwave.MusicWaveChannelInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\f\u0012\b\u0010\r\u001A\u0004\u0018\u00010\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010 \u001A\u00020\u0006HÆ\u0003J\t\u0010!\u001A\u00020\bHÆ\u0003J\t\u0010\"\u001A\u00020\nHÆ\u0003J\u000B\u0010#\u001A\u0004\u0018\u00010\fHÆ\u0003J\u000B\u0010$\u001A\u0004\u0018\u00010\u000EHÆ\u0003JO\u0010%\u001A\u00020\u00002\u000E\b\u0002\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000EHÆ\u0001J\u0013\u0010&\u001A\u00020\'2\b\u0010(\u001A\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001A\u00020+HÖ\u0001J\t\u0010,\u001A\u00020\u0006HÖ\u0001R \u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0013\u0010\u000B\u001A\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0013\u0010\r\u001A\u0004\u0018\u00010\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001E¨\u0006-"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/MusicWaveAddRequestPlayableListInfo;", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "userRequestedPlaylist", "", "Lcom/iloen/melon/playback/Playable;", "songId", "", "channelInfo", "Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;", "timePos", "", "nextSongResponse", "Lcom/iloen/melon/net/v6x/response/MusicWavePlayInfoRes$RESPONSE$NEXTSONG;", "logResponse", "Lcom/iloen/melon/net/v6x/response/MusicWavePlayInfoRes$RESPONSE$LOG;", "<init>", "(Ljava/util/List;Ljava/lang/String;Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;JLcom/iloen/melon/net/v6x/response/MusicWavePlayInfoRes$RESPONSE$NEXTSONG;Lcom/iloen/melon/net/v6x/response/MusicWavePlayInfoRes$RESPONSE$LOG;)V", "getUserRequestedPlaylist", "()Ljava/util/List;", "setUserRequestedPlaylist", "(Ljava/util/List;)V", "getSongId", "()Ljava/lang/String;", "getChannelInfo", "()Lcom/iloen/melon/playback/playlist/musicwave/MusicWaveChannelInfo;", "getTimePos", "()J", "getNextSongResponse", "()Lcom/iloen/melon/net/v6x/response/MusicWavePlayInfoRes$RESPONSE$NEXTSONG;", "getLogResponse", "()Lcom/iloen/melon/net/v6x/response/MusicWavePlayInfoRes$RESPONSE$LOG;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveAddRequestPlayableListInfo implements AddRequestPlayableListInfo {
    public static final int $stable = 8;
    @NotNull
    private final MusicWaveChannelInfo channelInfo;
    @Nullable
    private final LOG logResponse;
    @Nullable
    private final NEXTSONG nextSongResponse;
    @NotNull
    private final String songId;
    private final long timePos;
    @NotNull
    private List userRequestedPlaylist;

    public MusicWaveAddRequestPlayableListInfo(@NotNull List list0, @NotNull String s, @NotNull MusicWaveChannelInfo musicWaveChannelInfo0, long v, @Nullable NEXTSONG musicWavePlayInfoRes$RESPONSE$NEXTSONG0, @Nullable LOG musicWavePlayInfoRes$RESPONSE$LOG0) {
        q.g(list0, "userRequestedPlaylist");
        q.g(s, "songId");
        q.g(musicWaveChannelInfo0, "channelInfo");
        super();
        this.userRequestedPlaylist = list0;
        this.songId = s;
        this.channelInfo = musicWaveChannelInfo0;
        this.timePos = v;
        this.nextSongResponse = musicWavePlayInfoRes$RESPONSE$NEXTSONG0;
        this.logResponse = musicWavePlayInfoRes$RESPONSE$LOG0;
    }

    @NotNull
    public final List component1() {
        return this.userRequestedPlaylist;
    }

    @NotNull
    public final String component2() {
        return this.songId;
    }

    @NotNull
    public final MusicWaveChannelInfo component3() {
        return this.channelInfo;
    }

    public final long component4() {
        return this.timePos;
    }

    @Nullable
    public final NEXTSONG component5() {
        return this.nextSongResponse;
    }

    @Nullable
    public final LOG component6() {
        return this.logResponse;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    public void convertCanAddPlayableListInfo(@NotNull PlaylistId playlistId0) {
        AddRequestPlayableListInfo.super.convertCanAddPlayableListInfo(playlistId0);
    }

    @NotNull
    public final MusicWaveAddRequestPlayableListInfo copy(@NotNull List list0, @NotNull String s, @NotNull MusicWaveChannelInfo musicWaveChannelInfo0, long v, @Nullable NEXTSONG musicWavePlayInfoRes$RESPONSE$NEXTSONG0, @Nullable LOG musicWavePlayInfoRes$RESPONSE$LOG0) {
        q.g(list0, "userRequestedPlaylist");
        q.g(s, "songId");
        q.g(musicWaveChannelInfo0, "channelInfo");
        return new MusicWaveAddRequestPlayableListInfo(list0, s, musicWaveChannelInfo0, v, musicWavePlayInfoRes$RESPONSE$NEXTSONG0, musicWavePlayInfoRes$RESPONSE$LOG0);
    }

    public static MusicWaveAddRequestPlayableListInfo copy$default(MusicWaveAddRequestPlayableListInfo musicWaveAddRequestPlayableListInfo0, List list0, String s, MusicWaveChannelInfo musicWaveChannelInfo0, long v, NEXTSONG musicWavePlayInfoRes$RESPONSE$NEXTSONG0, LOG musicWavePlayInfoRes$RESPONSE$LOG0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            list0 = musicWaveAddRequestPlayableListInfo0.userRequestedPlaylist;
        }
        if((v1 & 2) != 0) {
            s = musicWaveAddRequestPlayableListInfo0.songId;
        }
        if((v1 & 4) != 0) {
            musicWaveChannelInfo0 = musicWaveAddRequestPlayableListInfo0.channelInfo;
        }
        if((v1 & 8) != 0) {
            v = musicWaveAddRequestPlayableListInfo0.timePos;
        }
        if((v1 & 16) != 0) {
            musicWavePlayInfoRes$RESPONSE$NEXTSONG0 = musicWaveAddRequestPlayableListInfo0.nextSongResponse;
        }
        if((v1 & 0x20) != 0) {
            musicWavePlayInfoRes$RESPONSE$LOG0 = musicWaveAddRequestPlayableListInfo0.logResponse;
        }
        return musicWaveAddRequestPlayableListInfo0.copy(list0, s, musicWaveChannelInfo0, v, musicWavePlayInfoRes$RESPONSE$NEXTSONG0, musicWavePlayInfoRes$RESPONSE$LOG0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof MusicWaveAddRequestPlayableListInfo)) {
            return false;
        }
        if(!q.b(this.userRequestedPlaylist, ((MusicWaveAddRequestPlayableListInfo)object0).userRequestedPlaylist)) {
            return false;
        }
        if(!q.b(this.songId, ((MusicWaveAddRequestPlayableListInfo)object0).songId)) {
            return false;
        }
        if(!q.b(this.channelInfo, ((MusicWaveAddRequestPlayableListInfo)object0).channelInfo)) {
            return false;
        }
        if(this.timePos != ((MusicWaveAddRequestPlayableListInfo)object0).timePos) {
            return false;
        }
        return q.b(this.nextSongResponse, ((MusicWaveAddRequestPlayableListInfo)object0).nextSongResponse) ? q.b(this.logResponse, ((MusicWaveAddRequestPlayableListInfo)object0).logResponse) : false;
    }

    @NotNull
    public final MusicWaveChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    @Nullable
    public final LOG getLogResponse() {
        return this.logResponse;
    }

    @Nullable
    public final NEXTSONG getNextSongResponse() {
        return this.nextSongResponse;
    }

    @NotNull
    public final String getSongId() {
        return this.songId;
    }

    public final long getTimePos() {
        return this.timePos;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    @NotNull
    public List getUserRequestedPlaylist() {
        return this.userRequestedPlaylist;
    }

    @Override
    public int hashCode() {
        int v = d.c((this.channelInfo.hashCode() + x.b(this.userRequestedPlaylist.hashCode() * 0x1F, 0x1F, this.songId)) * 0x1F, 0x1F, this.timePos);
        int v1 = 0;
        int v2 = this.nextSongResponse == null ? 0 : this.nextSongResponse.hashCode();
        LOG musicWavePlayInfoRes$RESPONSE$LOG0 = this.logResponse;
        if(musicWavePlayInfoRes$RESPONSE$LOG0 != null) {
            v1 = musicWavePlayInfoRes$RESPONSE$LOG0.hashCode();
        }
        return (v + v2) * 0x1F + v1;
    }

    @Override  // com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo
    public void setUserRequestedPlaylist(@NotNull List list0) {
        q.g(list0, "<set-?>");
        this.userRequestedPlaylist = list0;
    }

    @Override
    @NotNull
    public String toString() {
        return "MusicWaveAddRequestPlayableListInfo(userRequestedPlaylist=" + this.userRequestedPlaylist + ", songId=" + this.songId + ", channelInfo=" + this.channelInfo + ", timePos=" + this.timePos + ", nextSongResponse=" + this.nextSongResponse + ", logResponse=" + this.logResponse + ")";
    }
}

