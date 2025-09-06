package com.iloen.melon.net.mcp.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u001A\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R \u0010\u0016\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R \u0010\u0019\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0010\"\u0004\b\u001B\u0010\u0012R \u0010\u001C\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0010\"\u0004\b\u001E\u0010\u0012R \u0010\u001F\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R \u0010\"\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R \u0010%\u001A\u0004\u0018\u00010\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b&\u0010\u0010\"\u0004\b\'\u0010\u0012R\u001E\u0010(\u001A\u00020)8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/iloen/melon/net/mcp/response/PlayDjMalrangBase;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "playlist", "Lcom/iloen/melon/net/mcp/response/MixUpPlayBase$PlaylistBase;", "getPlaylist", "()Lcom/iloen/melon/net/mcp/response/MixUpPlayBase$PlaylistBase;", "setPlaylist", "(Lcom/iloen/melon/net/mcp/response/MixUpPlayBase$PlaylistBase;)V", "waitingList", "getWaitingList", "setWaitingList", "mainTitle", "", "getMainTitle", "()Ljava/lang/String;", "setMainTitle", "(Ljava/lang/String;)V", "artistName", "getArtistName", "setArtistName", "artistImg", "getArtistImg", "setArtistImg", "songTitle", "getSongTitle", "setSongTitle", "playlistType", "getPlaylistType", "setPlaylistType", "playlistId", "getPlaylistId", "setPlaylistId", "poolId", "getPoolId", "setPoolId", "titleKey", "getTitleKey", "setTitleKey", "success", "", "getSuccess", "()Z", "setSuccess", "(Z)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlayDjMalrangBase extends ResponseBase {
    public static final int $stable = 8;
    @b("ARTISTIMG")
    @Nullable
    private String artistImg;
    @b(alternate = {"ARTISTNM"}, value = "ARTISTNAME")
    @Nullable
    private String artistName;
    @b("MAINTITLE")
    @Nullable
    private String mainTitle;
    @b("PLAYLIST")
    @Nullable
    private PlaylistBase playlist;
    @b("PLAYLISTID")
    @Nullable
    private String playlistId;
    @b("PLAYLISTTYPE")
    @Nullable
    private String playlistType;
    @b("POOLID")
    @Nullable
    private String poolId;
    @b("SONGTITLE")
    @Nullable
    private String songTitle;
    @b("SUCCESS")
    private boolean success;
    @b("TITLEKEY")
    @Nullable
    private String titleKey;
    @b("WAITINGLIST")
    @Nullable
    private PlaylistBase waitingList;

    public PlayDjMalrangBase() {
        this.mainTitle = "";
        this.artistName = "";
        this.artistImg = "";
        this.songTitle = "";
        this.playlistType = "";
        this.playlistId = "";
        this.poolId = "";
        this.titleKey = "";
    }

    @Nullable
    public final String getArtistImg() [...] // 潜在的解密器

    @Nullable
    public final String getArtistName() [...] // 潜在的解密器

    @Nullable
    public final String getMainTitle() [...] // 潜在的解密器

    @Nullable
    public final PlaylistBase getPlaylist() {
        return this.playlist;
    }

    @Nullable
    public final String getPlaylistId() [...] // 潜在的解密器

    @Nullable
    public final String getPlaylistType() [...] // 潜在的解密器

    @Nullable
    public final String getPoolId() [...] // 潜在的解密器

    @Nullable
    public final String getSongTitle() [...] // 潜在的解密器

    public final boolean getSuccess() {
        return this.success;
    }

    @Nullable
    public final String getTitleKey() [...] // 潜在的解密器

    @Nullable
    public final PlaylistBase getWaitingList() {
        return this.waitingList;
    }

    public final void setArtistImg(@Nullable String s) {
        this.artistImg = s;
    }

    public final void setArtistName(@Nullable String s) {
        this.artistName = s;
    }

    public final void setMainTitle(@Nullable String s) {
        this.mainTitle = s;
    }

    public final void setPlaylist(@Nullable PlaylistBase mixUpPlayBase$PlaylistBase0) {
        this.playlist = mixUpPlayBase$PlaylistBase0;
    }

    public final void setPlaylistId(@Nullable String s) {
        this.playlistId = s;
    }

    public final void setPlaylistType(@Nullable String s) {
        this.playlistType = s;
    }

    public final void setPoolId(@Nullable String s) {
        this.poolId = s;
    }

    public final void setSongTitle(@Nullable String s) {
        this.songTitle = s;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    public final void setTitleKey(@Nullable String s) {
        this.titleKey = s;
    }

    public final void setWaitingList(@Nullable PlaylistBase mixUpPlayBase$PlaylistBase0) {
        this.waitingList = mixUpPlayBase$PlaylistBase0;
    }
}

