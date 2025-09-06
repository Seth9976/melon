package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveCreateChannelRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/MusicWaveCreateChannelRes$RESPONSE;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/MusicWaveCreateChannelRes$RESPONSE;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/MusicWaveCreateChannelRes$RESPONSE;)V", "RESPONSE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveCreateChannelRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveCreateChannelRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "songIds", "", "getSongIds", "()Ljava/lang/String;", "setSongIds", "(Ljava/lang/String;)V", "type", "getType", "setType", "id", "getId", "setId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        public static final int $stable = 8;
        @b("ID")
        @Nullable
        private String id;
        @b("SONGIDS")
        @Nullable
        private String songIds;
        @b("TYPE")
        @Nullable
        private String type;

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getSongIds() {
            return this.songIds;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        public final void setId(@Nullable String s) {
            this.id = s;
        }

        public final void setSongIds(@Nullable String s) {
            this.songIds = s;
        }

        public final void setType(@Nullable String s) {
            this.type = s;
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

    public final void setResponse(@Nullable RESPONSE musicWaveCreateChannelRes$RESPONSE0) {
        this.response = musicWaveCreateChannelRes$RESPONSE0;
    }
}

