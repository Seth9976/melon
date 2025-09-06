package com.melon.net.res;

import S7.b;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000B2\u00020\u0001:\u0002\n\u000BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/melon/net/res/VoiceAlarmAlbumTracksRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/melon/net/res/VoiceAlarmAlbumTracksRes$Response;", "getResponse", "()Lcom/melon/net/res/VoiceAlarmAlbumTracksRes$Response;", "setResponse", "(Lcom/melon/net/res/VoiceAlarmAlbumTracksRes$Response;)V", "Response", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VoiceAlarmAlbumTracksRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/VoiceAlarmAlbumTracksRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000B2\u00020\u0001:\u0001\u000BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/melon/net/res/VoiceAlarmAlbumTracksRes$Response;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "trackList", "", "Lcom/melon/net/res/VoiceAlarm$TrackDto;", "getTrackList", "()Ljava/util/List;", "setTrackList", "(Ljava/util/List;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response extends ResponseBase {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/VoiceAlarmAlbumTracksRes$Response$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.melon.net.res.VoiceAlarmAlbumTracksRes.Response.Companion {
            private com.melon.net.res.VoiceAlarmAlbumTracksRes.Response.Companion() {
            }

            public com.melon.net.res.VoiceAlarmAlbumTracksRes.Response.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable;
        @NotNull
        public static final com.melon.net.res.VoiceAlarmAlbumTracksRes.Response.Companion Companion;
        private static final long serialVersionUID;
        @b("TRACKLIST")
        @Nullable
        private List trackList;

        static {
            Response.Companion = new com.melon.net.res.VoiceAlarmAlbumTracksRes.Response.Companion(null);
            Response.$stable = 8;
            Response.serialVersionUID = 0xF3B7D00F45CB221EL;
        }

        @Nullable
        public final List getTrackList() {
            return this.trackList;
        }

        public final void setTrackList(@Nullable List list0) {
            this.trackList = list0;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @b("response")
    @Nullable
    private Response response;
    private static final long serialVersionUID;

    static {
        VoiceAlarmAlbumTracksRes.Companion = new Companion(null);
        VoiceAlarmAlbumTracksRes.$stable = 8;
        VoiceAlarmAlbumTracksRes.serialVersionUID = 0xAFD7B20EB0D9D412L;
    }

    @Nullable
    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable Response voiceAlarmAlbumTracksRes$Response0) {
        this.response = voiceAlarmAlbumTracksRes$Response0;
    }
}

