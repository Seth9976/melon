package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveSongListRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/MusicWaveSongListRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/MusicWaveSongListRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/MusicWaveSongListRes$RESPONSE;)V", "RESPONSE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveSongListRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u000E\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000B\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R \u0010\u0011\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u000E\"\u0004\b\u0013\u0010\u0010R \u0010\u0014\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u000E\"\u0004\b\u0016\u0010\u0010R \u0010\u0017\u001A\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u000E\"\u0004\b\u0019\u0010\u0010¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveSongListRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "songList", "", "Lcom/melon/net/res/common/SongInfoBase;", "getSongList", "()Ljava/util/List;", "setSongList", "(Ljava/util/List;)V", "currentSongId", "", "getCurrentSongId", "()Ljava/lang/String;", "setCurrentSongId", "(Ljava/lang/String;)V", "currentSongIndex", "getCurrentSongIndex", "setCurrentSongIndex", "d", "getD", "setD", "status", "getStatus", "setStatus", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        public static final int $stable = 8;
        @b("CURRENTSONGID")
        @Nullable
        private String currentSongId;
        @b("CURRENTSONGINDEX")
        @Nullable
        private String currentSongIndex;
        @b("D")
        @Nullable
        private String d;
        @b("SONGLIST")
        @Nullable
        private List songList;
        @b("STATUS")
        @Nullable
        private String status;

        @Nullable
        public final String getCurrentSongId() {
            return this.currentSongId;
        }

        @Nullable
        public final String getCurrentSongIndex() {
            return this.currentSongIndex;
        }

        @Nullable
        public final String getD() {
            return this.d;
        }

        @Nullable
        public final List getSongList() {
            return this.songList;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        public final void setCurrentSongId(@Nullable String s) {
            this.currentSongId = s;
        }

        public final void setCurrentSongIndex(@Nullable String s) {
            this.currentSongIndex = s;
        }

        public final void setD(@Nullable String s) {
            this.d = s;
        }

        public final void setSongList(@Nullable List list0) {
            this.songList = list0;
        }

        public final void setStatus(@Nullable String s) {
            this.status = s;
        }
    }

    public static final int $stable = 8;
    @b("response")
    @Nullable
    private RESPONSE response;

    @Nullable
    public final RESPONSE getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable RESPONSE musicWaveSongListRes$RESPONSE0) {
        this.response = musicWaveSongListRes$RESPONSE0;
    }
}

