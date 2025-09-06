package com.melon.net.res;

import S7.b;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.ResponseBase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000B2\u00020\u0001:\u0002\n\u000BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/melon/net/res/VoiceAlarmTrackRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/melon/net/res/VoiceAlarmTrackRes$Response;", "getResponse", "()Lcom/melon/net/res/VoiceAlarmTrackRes$Response;", "setResponse", "(Lcom/melon/net/res/VoiceAlarmTrackRes$Response;)V", "Response", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VoiceAlarmTrackRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/VoiceAlarmTrackRes$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0011"}, d2 = {"Lcom/melon/net/res/VoiceAlarmTrackRes$Response;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "resultCode", "", "getResultCode", "()Ljava/lang/String;", "setResultCode", "(Ljava/lang/String;)V", "track", "Lcom/melon/net/res/VoiceAlarm$TrackDto;", "getTrack", "()Lcom/melon/net/res/VoiceAlarm$TrackDto;", "setTrack", "(Lcom/melon/net/res/VoiceAlarm$TrackDto;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response extends ResponseBase {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/melon/net/res/VoiceAlarmTrackRes$Response$Companion;", "", "<init>", "()V", "serialVersionUID", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.melon.net.res.VoiceAlarmTrackRes.Response.Companion {
            private com.melon.net.res.VoiceAlarmTrackRes.Response.Companion() {
            }

            public com.melon.net.res.VoiceAlarmTrackRes.Response.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final int $stable;
        @NotNull
        public static final com.melon.net.res.VoiceAlarmTrackRes.Response.Companion Companion;
        @b("RESULTCODE")
        @Nullable
        private String resultCode;
        private static final long serialVersionUID;
        @b("TRACK")
        @Nullable
        private TrackDto track;

        static {
            Response.Companion = new com.melon.net.res.VoiceAlarmTrackRes.Response.Companion(null);
            Response.$stable = 8;
            Response.serialVersionUID = 0xF5B13A599F5B8DCBL;
        }

        @Nullable
        public final String getResultCode() {
            return this.resultCode;
        }

        @Nullable
        public final TrackDto getTrack() {
            return this.track;
        }

        public final void setResultCode(@Nullable String s) {
            this.resultCode = s;
        }

        public final void setTrack(@Nullable TrackDto voiceAlarm$TrackDto0) {
            this.track = voiceAlarm$TrackDto0;
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
        VoiceAlarmTrackRes.Companion = new Companion(null);
        VoiceAlarmTrackRes.$stable = 8;
        VoiceAlarmTrackRes.serialVersionUID = 0xE6C140DFE3837947L;
    }

    @Nullable
    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable Response voiceAlarmTrackRes$Response0) {
        this.response = voiceAlarmTrackRes$Response0;
    }
}

